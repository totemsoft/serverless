package au.com.totemsoft.serverless.elixir.service;

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
import au.com.totemsoft.elixir.survey.v1.model.ResponseUpload;

@Service("surveyApi")
public class SurveyApiImpl implements SurveyApi {

    @Override
    public SurveyApi getDelegate() {
        return this;
    }

    private <T> ResponseEntity<T> entity(T body) {
        HttpHeaders responseHeaders = new HttpHeaders();
        //responseHeaders.setLocation(location);
        //responseHeaders.set("MyResponseHeader", "MyValue");
        //
        return new ResponseEntity<>(body, responseHeaders, HttpStatus.OK);
        //return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @Override
    public ResponseEntity<ResponseSurvey> surveyQuestions(String xV, RequestSurvey surveyRequest) {
        ResponseSurvey result = new ResponseSurvey()
            .surveyId(surveyRequest.getSurveyId())
            .addQuestionsItem(new Question()
                .type(QuestionType.TEXT)
                .text("What is abra-cadabra?")
                .addAnswersItem(new Answer().text("It is cool."))
                .addAnswersItem(new Answer().text("It is not cool."))
        );
        //
        return entity(result);
    }

    @Override
    public ResponseEntity<ResponseUpload> surveyUpload(MultipartFile fileUpload, String fileNote) {
        String fileInfo = String.format("name: %s, size: %d", fileUpload.getOriginalFilename(), fileUpload.getSize());
        ResponseUpload result = new ResponseUpload().surveyId(fileNote + " - " + fileInfo);
        // TODO: save in s3
        return entity(result);
    }

}
