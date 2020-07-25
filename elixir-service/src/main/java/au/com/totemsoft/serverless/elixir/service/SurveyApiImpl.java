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
import au.com.totemsoft.elixir.survey.v1.model.Answer;
import au.com.totemsoft.elixir.survey.v1.model.Question;
import au.com.totemsoft.elixir.survey.v1.model.QuestionType;
import au.com.totemsoft.elixir.survey.v1.model.RequestSurvey;
import au.com.totemsoft.elixir.survey.v1.model.ResponseSurvey;
import au.com.totemsoft.elixir.survey.v1.model.ResponseSurveyQuestions;
import au.com.totemsoft.elixir.survey.v1.model.ResponseUpload;

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
    public ResponseEntity<ResponseSurvey> survey(@Valid RequestSurvey surveyRequest) {
        try {
            // send message to JMS (AWS SQS)
            messageService.sendMessage(surveyRequest);
            // TODO: get/create file with reference = WorkDocs folderId
            ResponseSurvey result = new ResponseSurvey()
                .reference(UUID.randomUUID().toString())
                .surveyId(surveyRequest.getSurveyId());
            //
            return entity(result, null);
        } catch (Exception e) {
            ResponseSurvey error = new ResponseSurvey().surveyId(error(e));
            return entity(error, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<ResponseSurveyQuestions> surveyQuestions(String reference,
        RequestSurvey surveyRequest) {
        try {
            // send message to JMS (AWS SQS)
            messageService.sendMessage(surveyRequest);
            // TODO: questions (depends on sendMessage result ???)
            ResponseSurveyQuestions result = new ResponseSurveyQuestions()
                .surveyId(surveyRequest.getSurveyId())
                .addQuestionsItem(new Question()
                    .type(QuestionType.TEXT)
                    .text("What is abra-cadabra?")
                    .addAnswersItem(new Answer().text("It is cool."))
                    .addAnswersItem(new Answer().text("It is not cool.")));
            //
            return entity(result, null);
        } catch (Exception e) {
            ResponseSurveyQuestions error = new ResponseSurveyQuestions().surveyId(error(e));
            return entity(error, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<ResponseUpload> surveyUpload(String reference,
        MultipartFile fileUpload, String fileNote) {
        try {
            String fileInfo = String.format("reference: %s, name: %s, size: %d", reference, fileUpload.getOriginalFilename(), fileUpload.getSize());
            // save s3
            Resource r = fileUpload.getResource();
            Map<String, Object> metadata = new TreeMap<>();
            metadata.put(UploadService.LAST_MODIFIED, new Date()); // TODO: lastModifiedDate
            metadata.put(UploadService.CONTENT_TYPE, fileUpload.getContentType());
            metadata.put(UploadService.FILE_NOTE, fileNote);
            String uploadResult = uploadService.upload(r, reference, metadata);
            // result
            ResponseUpload result = new ResponseUpload()
                .surveyId(uploadResult + ": [" + reference + "]" + fileNote + " - " + fileInfo);
            return entity(result, null);
        } catch (Exception e) {
            ResponseUpload error = new ResponseUpload().surveyId(error(e));
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
