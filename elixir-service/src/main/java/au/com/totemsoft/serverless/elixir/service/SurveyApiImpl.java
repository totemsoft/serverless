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

import au.com.totemsoft.elixir.survey.v1.api.SurveyApi;
import au.com.totemsoft.elixir.survey.v1.model.SurveyRequest;
import au.com.totemsoft.elixir.survey.v1.model.SurveyResponse;
import au.com.totemsoft.elixir.survey.v1.model.UploadResponse;

@Service("surveyApi")
public class SurveyApiImpl implements SurveyApi {

    @Value("#{environment.DEBUG ?: 'true'}")
    private boolean debug;

    @Autowired
    @Qualifier("workDocsUploadService")
    //@Qualifier("s3UploadService")
    private UploadService uploadService;

    @Autowired
    @Qualifier("sqsService")
    private MessageService messageService;

    @Override
    public SurveyApi getDelegate() {
        return this;
    }

    @Override
    public ResponseEntity<SurveyResponse> create(@Valid SurveyRequest surveyRequest) {
        final UUID reference = UUID.randomUUID();
        surveyRequest.setReference(reference);
        try {
            //
            // this is new insured (Elixir file) - create folder to store documents
            final String folderId = uploadService.mkdir(reference.toString());
            surveyRequest.setFolderId(folderId);
            //
            uploadSurvey(surveyRequest);
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
    public ResponseEntity<List<SurveyResponse>> findAll() {
        try {
            //
            // find all references
            List<ImmutablePair<String, String>> folders = uploadService.list();
            //
            List<SurveyResponse> result = new ArrayList<>();
            for (ImmutablePair<String, String> folder : folders) {
                final String reference = folder.getKey();
                result.add(new SurveyResponse()
                    .reference(UUID.fromString(reference))
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
    public ResponseEntity<SurveyResponse> find(UUID reference) {
        try {
            //
            final String folderId = uploadService.mkdir(reference.toString());
            final ByteArrayOutputStream survey = new ByteArrayOutputStream();
            uploadService.download(folderId, reference.toString(), survey);
            //
            SurveyResponse result = new SurveyResponse()
                .reference(reference)
                .folderId(folderId)
                //.insured(insured)
                .survey(survey.toString());
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
    public ResponseEntity<SurveyResponse> update(@Valid SurveyRequest surveyRequest) {
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
    public ResponseEntity<UploadResponse> upload(UUID reference,
        @Valid MultipartFile fileUpload, String fileNote) {
        try {
            String fileInfo = String.format("name: %s, size: %d",
                fileUpload.getOriginalFilename(), fileUpload.getSize());
            // save to document store
            Resource resource = fileUpload.getResource();
            Map<String, Object> metadata = new TreeMap<>();
            metadata.put(UploadService.LAST_MODIFIED, new Date()); // TODO: lastModifiedDate
            metadata.put(UploadService.CONTENT_TYPE, fileUpload.getContentType());
            metadata.put(UploadService.FILE_NOTE, fileNote);
            String documentId = uploadService.upload(reference.toString(), resource, metadata);
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

    /**
     * Upload Survey JSON document (optional).
     * @param surveyRequest
     * @throws IOException
     */
    private void uploadSurvey(SurveyRequest surveyRequest) throws IOException {
        if (StringUtils.isBlank(surveyRequest.getSurvey())) {
            return;
        }
        final UUID reference = surveyRequest.getReference();
        // upload Survey JSON document
        Resource survey = new InMemoryResource(surveyRequest.getSurvey().getBytes(), reference.toString());
        Map<String, Object> metadata = new TreeMap<>();
        metadata.put(UploadService.LAST_MODIFIED, new Date()); // TODO: lastModifiedDate
        metadata.put(UploadService.CONTENT_TYPE, MediaType.APPLICATION_JSON);
        uploadService.upload(surveyRequest.getFolderId(), survey, metadata);
    }

    @Override
    public ResponseEntity<Resource> download(UUID reference, String filename) {
        try {
            // get from document store
            final ByteArrayOutputStream file = new ByteArrayOutputStream();
            uploadService.download(reference.toString(), filename, file);
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
