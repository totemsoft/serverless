package au.com.totemsoft.serverless.elixir.controller;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.core.MediaType;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import au.com.totemsoft.elixir.survey.v1.api.SurveyApi;

@RestController
@EnableWebMvc
@RequestMapping("${openapi.elixirSurvey.base-path:/survey}")
public class SurveyController implements SurveyApi {

    @Override
    public SurveyApi getDelegate() {
        // TODO Auto-generated method stub
        return null;
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON)
    public Map<String, String> survey(@PathVariable("id") int id) {
        Map<String, String> result = new HashMap<>();
        result.put("survey", "Survey: " + id);
        return result;
    }

}
