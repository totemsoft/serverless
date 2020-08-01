package au.com.totemsoft.serverless.elixir.service;

import java.util.Date;
import java.util.Map;
import java.util.TreeMap;
import java.util.UUID;

import javax.validation.Valid;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
        try {
            //
            // check if this is new insured (Elixir file) - create folder to store documents
            surveyRequest.setReference(reference);
            /*String folderId = */uploadService.mkdir(reference.toString());
            //
            // send message via JMS (AWS SQS) - Elixir instance pickup and do job
            // get/create file with insured file reference (UUID)
            messageService.sendMessage(surveyRequest);
            //
            SurveyResponse result = new SurveyResponse()
                .reference(reference);
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
    public ResponseEntity<SurveyResponse> find(UUID reference) {
        try {
            //
            // check if this is new insured (Elixir file) - create folder to store documents
            //String folderId = uploadService.mkdir(reference);
            //
            //
            SurveyResponse result = new SurveyResponse()
                .reference(reference);
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
            // check if this is new insured (Elixir file) - create folder to store documents
            //UUID reference = surveyRequest.getReference();
            /*String folderId = */uploadService.mkdir(reference.toString());
            //
            // send message via JMS (AWS SQS) - Elixir instance pickup and do job
            // get/create file with insured file reference (UUID)
            messageService.sendMessage(surveyRequest);
            //
            SurveyResponse result = new SurveyResponse()
                .reference(reference);
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
            String fileInfo = String.format("reference: %s, name: %s, size: %d",
                reference, fileUpload.getOriginalFilename(), fileUpload.getSize());
            // save to document store
            Resource r = fileUpload.getResource();
            Map<String, Object> metadata = new TreeMap<>();
            metadata.put(UploadService.LAST_MODIFIED, new Date()); // TODO: lastModifiedDate
            metadata.put(UploadService.CONTENT_TYPE, fileUpload.getContentType());
            metadata.put(UploadService.FILE_NOTE, fileNote);
            String uploadResult = uploadService.upload(r, reference.toString(), metadata);
            // result
            UploadResponse result = new UploadResponse()
                .reference(reference)
                .message(uploadResult + ": [" + reference + "]" + fileNote + " - " + fileInfo);
            return entity(result, null);
        } catch (Exception e) {
            UploadResponse error = new UploadResponse()
                .reference(reference)
                .message(error(e));
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
