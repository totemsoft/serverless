package au.com.totemsoft.serverless.elixir.service;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import au.com.totemsoft.elixir.survey.v1.api.SurveyApi;
import au.com.totemsoft.elixir.survey.v1.model.Answer;
import au.com.totemsoft.elixir.survey.v1.model.Question;
import au.com.totemsoft.elixir.survey.v1.model.QuestionType;
import au.com.totemsoft.elixir.survey.v1.model.RequestSurvey;
import au.com.totemsoft.elixir.survey.v1.model.ResponseSurvey;

@Service("surveyApi")
public class SurveyApiImpl implements SurveyApi {

    @Override
    public SurveyApi getDelegate() {
        return this;
    }

    @Override
    public ResponseEntity<ResponseSurvey> surveyQuestions(String xV, RequestSurvey surveyRequest) {
        HttpHeaders responseHeaders = new HttpHeaders();
        //responseHeaders.setLocation(location);
        //responseHeaders.set("MyResponseHeader", "MyValue");
        //
        ResponseSurvey survey = new ResponseSurvey()
            .surveyId(surveyRequest.getSurveyId())
            .addQuestionsItem(new Question()
                .type(QuestionType.TEXT)
                .text("What is abra-cadabra?")
                .addAnswersItem(new Answer().text("It is cool."))
                .addAnswersItem(new Answer().text("It is not cool."))
        );
        //
        return new ResponseEntity<>(survey, responseHeaders, HttpStatus.OK);
        //return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

}
