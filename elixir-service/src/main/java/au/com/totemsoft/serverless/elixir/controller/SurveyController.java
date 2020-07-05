package au.com.totemsoft.serverless.elixir.controller;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import au.com.totemsoft.elixir.survey.v1.api.SurveyApi;

@RestController("surveyController")
@EnableWebMvc
public class SurveyController implements SurveyApi, HealthIndicator {

    @Autowired @Qualifier("surveyApi")
    private SurveyApi surveyApi;

    @Override
    public SurveyApi getDelegate() {
        return this.surveyApi;
    }

    @Override
    @GetMapping(path = "/health", produces = MediaType.APPLICATION_JSON)
    public Health health() {
        try {
            return Health.up()
                .withDetail("version", "1.0.0-SNAPSHOT")
                .build();
         }
         catch (Exception ex) {
            return Health.down(ex).build();
         }
    }

}
