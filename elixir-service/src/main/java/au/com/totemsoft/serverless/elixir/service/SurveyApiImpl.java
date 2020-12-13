package au.com.totemsoft.serverless.elixir.service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.UUID;

import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.util.InMemoryResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;

import au.com.totemsoft.elixir.survey.v1.api.SurveyApi;
import au.com.totemsoft.elixir.survey.v1.model.InsuredDetails;
import au.com.totemsoft.elixir.survey.v1.model.SurveyRequest;
import au.com.totemsoft.elixir.survey.v1.model.SurveyResponse;
import au.com.totemsoft.elixir.survey.v1.model.UploadResponse;

@Service("surveyApi")
public class SurveyApiImpl implements SurveyApi {

    private final static String SURVEY_JSON  = ".survey.json";
    private final static String INSURED_JSON = ".insured.json";

    @Value("#{environment.DEBUG ?: 'true'}")
    private boolean debug;

    @Autowired
    @Qualifier("workDocsUploadService")
    //@Qualifier("s3UploadService")
    private UploadService uploadService;

    @Autowired
    @Qualifier("sqsService")
    private MessageService messageService;

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public SurveyApi getDelegate() {
        return this;
    }

    @Override
    public ResponseEntity<SurveyResponse> createSurvey(@Valid SurveyRequest surveyRequest) {
        final UUID reference = UUID.randomUUID();
        surveyRequest.setReference(reference);
        final String refName = reference.toString();
        try {
            //
            // this is new insured (Elixir file) - create folder to store documents
            final String folderId = uploadService.mkdir(refName);
            surveyRequest.setFolderId(folderId);
            //
            uploadSurvey(surveyRequest);
            uploadInsured(surveyRequest);
            //
            // send message via JMS (AWS SQS) - Elixir instance pickup and do job
            // get/create file with insured file reference (UUID)
            messageService.sendMessage(surveyRequest);
            //
            SurveyResponse result = new SurveyResponse()
                .reference(reference)
                .folderId(folderId);
            //
            return entity(result, null);
        } catch (Exception e) {
            SurveyResponse error = new SurveyResponse()
                .reference(reference)
                .message(error(e));
            return entity(error, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<List<SurveyResponse>> findSurveys() {
        try {
            //
            // find all references
            List<ImmutablePair<String, String>> folders = uploadService.list();
            //
            List<SurveyResponse> result = new ArrayList<>();
            for (ImmutablePair<String, String> folder : folders) {
                final String key = folder.getKey();
                final UUID reference;
                try {
                    reference = UUID.fromString(key);
                } catch (IllegalArgumentException ignore) {
                    // key does not conform to the string representation of UUID
                    continue;
                }
                result.add(new SurveyResponse()
                    .reference(reference)
                    .folderId(folder.getValue())
                );
            }
            //
            return entity(result, null);
        } catch (Exception e) {
            List<SurveyResponse> error = Arrays.asList(
                new SurveyResponse()
                    .message(error(e)));
            return entity(error, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<SurveyResponse> findSurvey(UUID reference, String folderId) {
        final String refName = reference.toString();
        try {
            //
            if (StringUtils.isBlank(folderId)) {
                ImmutablePair<String, String> folder = uploadService.find(refName);
                if (folder == null) {
                    SurveyResponse error = new SurveyResponse()
                        .reference(reference)
                        .message("No folder found.");
                    return entity(error, HttpStatus.PRECONDITION_FAILED);
                }
                folderId = folder.getValue();
            }
            //
            final ByteArrayOutputStream surveyStream = new ByteArrayOutputStream();
            uploadService.download(refName, folderId,
                refName + SURVEY_JSON, surveyStream);
            //
            final ByteArrayOutputStream insuredStream = new ByteArrayOutputStream();
            uploadService.download(refName, folderId,
                refName + INSURED_JSON, insuredStream);
            //
            SurveyResponse result = new SurveyResponse()
                .reference(reference)
                .folderId(folderId)
                .insured(objectMapper.readValue(insuredStream.toByteArray(), InsuredDetails.class))
                .survey(surveyStream.toString());
            //
            return entity(result, null);
        } catch (Exception e) {
            SurveyResponse error = new SurveyResponse()
                .reference(reference)
                .message(error(e));
            return entity(error, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<SurveyResponse> updateSurvey(@Valid SurveyRequest surveyRequest) {
        final UUID reference = surveyRequest.getReference();
        try {
            //
            uploadSurvey(surveyRequest);
            //
            // send message via JMS (AWS SQS) - Elixir instance pickup and do job
            // get/create file with insured file reference (UUID)
            messageService.sendMessage(surveyRequest);
            //
            SurveyResponse result = new SurveyResponse()
                .reference(reference)
                .folderId(surveyRequest.getFolderId());
            //
            return entity(result, null);
        } catch (Exception e) {
            SurveyResponse error = new SurveyResponse()
                .reference(reference)
                .message(error(e));
            return entity(error, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<UploadResponse> upload(UUID reference, String folderId,
        @Valid MultipartFile fileUpload,
        String fileNote) {
        final String refName = reference.toString();
        try {
            String fileInfo = String.format("name: %s, size: %d",
                fileUpload.getOriginalFilename(), fileUpload.getSize());
            // save to document store
            Resource resource = fileUpload.getResource();
            String documentId = uploadService.upload(refName, folderId,
                resource,
                metadata(fileUpload.getContentType(), fileNote));
            // result
            UploadResponse result = new UploadResponse()
                .reference(reference)
                .documentId(documentId)
                .message("[" + reference + "] " + fileInfo + " - " + fileNote);
            return entity(result, null);
        } catch (Exception e) {
            UploadResponse error = new UploadResponse()
                .reference(reference)
                .message(error(e));
            return entity(error, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private Map<String, Object> metadata(String contentType, String fileNote) {
        Map<String, Object> metadata = new TreeMap<>();
        metadata.put(UploadService.CONTENT_TYPE, contentType);
        metadata.put(UploadService.LAST_MODIFIED, new Date()); // TODO: not used
        metadata.put(UploadService.FILE_NOTE, fileNote); // TODO: not used
        return metadata;
    }

    /**
     * Upload Survey JSON document.
     * @param request
     * @throws IOException
     */
    private void uploadSurvey(SurveyRequest request) throws IOException {
        final UUID reference = request.getReference();
        if (StringUtils.isBlank(request.getSurvey())) {
            return; // TODO: throw ???
        }
        // upload Survey JSON document
        final String name = reference.toString() + SURVEY_JSON;
        final String fileNote = "Survey JSON document";
        Resource resource = new InMemoryResource(request.getSurvey().getBytes(), name);
        /*String documentId = */uploadService.upload(name, request.getFolderId(),
            resource,
            metadata(MediaType.APPLICATION_JSON_VALUE, fileNote));
    }

    /**
     * Upload Insured details JSON document.
     * @param request
     * @throws IOException
     */
    private void uploadInsured(SurveyRequest request) throws IOException {
        final UUID reference = request.getReference();
        final InsuredDetails insured = request.getInsured();
        if (insured == null) {
            return; // TODO: throw ???
        }
        // upload Insured JSON document
        final String name = reference.toString() + INSURED_JSON;
        final String fileNote = "Insured details JSON document";
        Resource resource = new InMemoryResource(objectMapper.writeValueAsBytes(insured), name);
        /*String documentId = */uploadService.upload(name, request.getFolderId(),
            resource,
            metadata(MediaType.APPLICATION_JSON_VALUE, fileNote));
    }

    @Override
    public ResponseEntity<Resource> download(UUID reference, String folderId,
        String filename) {
        final String refName = reference.toString();
        try {
            // get from document store
            final ByteArrayOutputStream file = new ByteArrayOutputStream();
            uploadService.download(refName, folderId,
                filename, file);
            // result
            Resource result = new InMemoryResource(file.toByteArray(), filename);
            return entity(result, null);
        } catch (Exception e) {
            Resource error = new ByteArrayResource(error(e).getBytes(), filename);
            return entity(error, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private <T> ResponseEntity<T> entity(T body, HttpStatus status) {
        HttpHeaders responseHeaders = new HttpHeaders();
        //responseHeaders.setLocation(location);
        //responseHeaders.set("MyResponseHeader", "MyValue");
        //
        return new ResponseEntity<>(body, responseHeaders, status == null ? HttpStatus.OK : status);
        //return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    private String error(Exception e) {
        if (debug) {
            e.printStackTrace();
            return ExceptionUtils.getStackTrace(e);
        }
        return ExceptionUtils.getRootCauseMessage(e);
    }

}
