package au.com.totemsoft.serverless.elixir.controller;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.core.MediaType;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@RestController
@EnableWebMvc
@RequestMapping("/survey")
public class SurveyController {

    @GetMapping(path = {"", "/"}, produces = MediaType.APPLICATION_JSON)
    public Map<String, String> survey() {
        Map<String, String> result = new HashMap<>();
        result.put("survey", "Survey");
        return result;
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON)
    public Map<String, String> survey(@PathVariable("id") int id) {
        Map<String, String> result = new HashMap<>();
        result.put("survey", "Survey: " + id);
        return result;
    }

}
