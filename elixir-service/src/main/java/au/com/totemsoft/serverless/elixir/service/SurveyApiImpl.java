package au.com.totemsoft.serverless.elixir.service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.util.InMemoryResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import au.com.totemsoft.elixir.survey.v1.api.SurveyApi;
import au.com.totemsoft.elixir.survey.v1.model.BrokerDetails;
import au.com.totemsoft.elixir.survey.v1.model.InsuredDetails;
import au.com.totemsoft.elixir.survey.v1.model.SurveyRequest;
import au.com.totemsoft.elixir.survey.v1.model.SurveyResponse;
import au.com.totemsoft.elixir.survey.v1.model.SurveySummaryResponse;
import au.com.totemsoft.elixir.survey.v1.model.UploadResponse;

@Service("surveyApi")
public class SurveyApiImpl extends AbstractServiceImpl implements SurveyApi {

    @Override
    public SurveyApi getDelegate() {
        return this;
    }

    @Override
    public ResponseEntity<SurveySummaryResponse> createSurvey(String client, SurveyRequest surveyRequest, Optional<String> location) {
        final BrokerDetails broker = broker(client, location);
        surveyRequest.setBroker(broker);
        //
        final UUID reference = UUID.randomUUID();
        surveyRequest.setReference(reference);
        final String refName = reference.toString();
        try {
            //
            // this is new insured (Elixir file) - create folder to store documents
            final String folderId = uploadService.mkdir(refName);
            surveyRequest.setFolderId(folderId);
            //
            upload(surveyRequest);
            //
            // send message via JMS (AWS SQS) - Elixir instance pickup and do job
            // get/create file with insured file reference (UUID)
            messageService.sendMessage(surveyRequest);
            //
            SurveySummaryResponse result = new SurveySummaryResponse()
                .reference(reference)
                .folderId(folderId)
                ;
            //
            return entity(result, null, null);
        } catch (Exception e) {
            SurveySummaryResponse error = new SurveySummaryResponse()
                .reference(reference)
                .message(error(e));
            return entity(error, HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }

    @Override
    public ResponseEntity<List<SurveySummaryResponse>> findSurveys(String client, Optional<String> location) {
        final BrokerDetails broker = broker(client, location);
        //
        try {
            // find all references
            List<ImmutablePair<UUID, String>> folders = uploadService.findByBroker(broker);
            List<SurveySummaryResponse> result = new ArrayList<>();
            for (ImmutablePair<UUID, String> folder : folders) {
                result.add(new SurveySummaryResponse()
                    .reference(folder.getKey())
                    .folderId(folder.getValue())
                );
            }
            //
            return entity(result, null, null);
        } catch (Exception e) {
            List<SurveySummaryResponse> error = Arrays.asList(
                new SurveySummaryResponse()
                    .message(error(e)));
            return entity(error, HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }

    @Override
    public ResponseEntity<SurveyResponse> findSurvey(String client, UUID reference, String folderId, Optional<String> location) {
        final BrokerDetails broker = broker(client, location);
        //
        final String refName = reference.toString();
        try {
            if (StringUtils.isBlank(folderId)) {
                ImmutablePair<UUID, String> folder = uploadService.findByReference(broker, refName);
                if (folder == null) {
                    SurveyResponse error = new SurveyResponse()
                        .reference(reference)
                        .broker(broker)
                        .message("No folder found.");
                    return entity(error, HttpStatus.PRECONDITION_FAILED, null);
                }
                folderId = folder.getValue();
            }
            //
            String message = null;
            //
            InsuredDetails insured;
            try {
                insured = readValue(folderId, uploadService.insuredFile(reference), InsuredDetails.class);
            } catch (IOException e) {
                String msg = "No insured found: " + reference;
                log.warn(msg);
                message = msg;
                insured = null;
            }
            //
            String survey;
            try {
                survey = readValue(folderId, uploadService.surveyFile(reference), String.class);
            } catch (IOException e) {
                String msg = "No survey found: " + reference;
                log.warn(msg);
                message = message == null ? msg : message + "\n" + msg;
                survey = null;
            }
            //
            SurveyResponse result = new SurveyResponse()
                .reference(reference)
                .folderId(folderId)
                .insured(insured)
                .broker(broker)
                .survey(survey)
                .message(message);
            //
            return entity(result, null, null);
        } catch (Exception e) {
            SurveyResponse error = new SurveyResponse()
                .reference(reference)
                .message(error(e));
            return entity(error, HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }

    @Override
    public ResponseEntity<SurveyResponse> updateSurvey(String client, SurveyRequest surveyRequest, Optional<String> location) {
        final BrokerDetails broker = broker(client, location);
        surveyRequest.setBroker(broker);
        //
        final UUID reference = surveyRequest.getReference();
        try {
            upload(surveyRequest);
            //
            // send message via JMS (AWS SQS) - Elixir instance pickup and do job
            // get/create file with insured file reference (UUID)
            messageService.sendMessage(surveyRequest);
            //
            SurveyResponse result = new SurveyResponse()
                .reference(reference)
                .folderId(surveyRequest.getFolderId())
                .broker(broker)
                ;
            //
            return entity(result, null, null);
        } catch (Exception e) {
            SurveyResponse error = new SurveyResponse()
                .reference(reference)
                .message(error(e));
            return entity(error, HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }

    @Override
    public ResponseEntity<UploadResponse> upload(UUID reference, String folderId,
        MultipartFile fileUpload,
        String fileNote) {
        final String refName = reference.toString();
        final String name = fileUpload.getOriginalFilename();
        final String contentType = fileUpload.getContentType();
        try {
            String fileInfo = String.format("name: %s, contentType: %s, size: %d",
                name, contentType, fileUpload.getSize());
            log.info("upload: " + fileInfo);
            // save to document store
            Resource resource = fileUpload.getResource();
            String documentId = uploadService.upload(folderId, resource,
                metadata(name, contentType, fileNote));
            log.info("documentId: " + documentId);
            // result
            UploadResponse result = new UploadResponse()
                .reference(reference)
                .documentId(documentId)
                .message("[" + refName + "] " + fileInfo + " - " + fileNote);
            log.info("result: " + result);
            return entity(result, null, null);
        } catch (Exception e) {
            UploadResponse error = new UploadResponse()
                .reference(reference)
                .message(error(e));
            return entity(error, HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }

    private Map<String, Object> metadata(String name, String contentType, String fileNote) {
        Map<String, Object> metadata = new TreeMap<>();
        metadata.put(UploadService.NAME, name);
        metadata.put(UploadService.CONTENT_TYPE, contentType);
        metadata.put(UploadService.LAST_MODIFIED, new Date()); // TODO: not used
        metadata.put(UploadService.FILE_NOTE, fileNote); // TODO: not used
        return metadata;
    }

    /**
     * Upload JSON documents.
     * @param request
     * @throws IOException
     */
    private void upload(SurveyRequest request) throws IOException {
        uploadBroker(request);
        uploadSurvey(request);
        uploadInsured(request);
    }

    /**
     * Upload Broker details JSON document.
     * @param request
     * @throws IOException
     */
    private void uploadBroker(SurveyRequest request) throws IOException {
        final BrokerDetails broker = request.getBroker();
        if (broker == null) {
            return;
        }
        // upload Broker JSON document
        final String name = uploadService.brokerFile(request.getReference());
        final String fileNote = "Broker details JSON document";
        final Resource resource = new ByteArrayResource(objectMapper.writeValueAsBytes(broker));
        /*String documentId = */uploadService.upload(request.getFolderId(), resource,
            metadata(name, MediaType.APPLICATION_JSON_VALUE, fileNote));
    }

    /**
     * Upload Survey JSON document.
     * @param request
     * @throws IOException
     */
    private void uploadSurvey(SurveyRequest request) throws IOException {
        final String survey = request.getSurvey();
        if (StringUtils.isBlank(survey)) {
            return;
        }
        // upload Survey JSON document
        final String name = uploadService.surveyFile(request.getReference());
        final String fileNote = "Survey JSON document";
        final Resource resource = new ByteArrayResource(survey.getBytes());
        /*String documentId = */uploadService.upload(request.getFolderId(), resource,
            metadata(name, MediaType.APPLICATION_JSON_VALUE, fileNote));
    }

    /**
     * Upload Insured details JSON document.
     * @param request
     * @throws IOException
     */
    private void uploadInsured(SurveyRequest request) throws IOException {
        final InsuredDetails insured = request.getInsured();
        if (insured == null) {
            return;
        }
        // upload Insured JSON document
        final String name = uploadService.insuredFile(request.getReference());
        final String fileNote = "Insured details JSON document";
        final Resource resource = new ByteArrayResource(objectMapper.writeValueAsBytes(insured));
        /*String documentId = */uploadService.upload(request.getFolderId(), resource,
            metadata(name, MediaType.APPLICATION_JSON_VALUE, fileNote));
    }

    @Override
    public ResponseEntity<Resource> download(UUID reference, String folderId, String filename) {
        try {
            // get from document store
            final ByteArrayOutputStream content = new ByteArrayOutputStream();
            uploadService.download(folderId, filename, content);
            log.info("download '" + filename);
            // result
            Resource result = new InMemoryResource(content.toByteArray(), filename);
            return entity(result, null, null);
        } catch (Exception e) {
            Resource error = new ByteArrayResource(error(e).getBytes(), filename);
            return entity(error, HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }

}
