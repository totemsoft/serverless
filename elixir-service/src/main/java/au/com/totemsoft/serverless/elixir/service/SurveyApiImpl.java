package au.com.totemsoft.serverless.elixir.service;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import au.com.totemsoft.elixir.survey.v1.api.SurveyApi;
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
        ResponseSurvey survey = new ResponseSurvey();
        HttpHeaders responseHeaders = new HttpHeaders();
        //responseHeaders.setLocation(location);
        //responseHeaders.set("MyResponseHeader", "MyValue");
        return new ResponseEntity<>(survey, responseHeaders, HttpStatus.OK);
        //return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

}
