package au.com.totemsoft.serverless.elixir.service;

import java.util.Base64;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class AbstractServiceImpl {

    @Value("#{environment.DEBUG ?: 'true'}")
    private boolean debug;

    @Autowired
    @Qualifier("sqsService")
    protected MessageService messageService;

    @Autowired
    protected ObjectMapper objectMapper;

    @Resource
    private HttpServletRequest httpServletRequest;

    protected HttpServletRequest httpServletRequest() {
        return httpServletRequest;
    }

    protected String sub() {
        final Base64.Decoder decoder = Base64.getUrlDecoder();
        String authHeader = httpServletRequest.getHeader(HttpHeaders.AUTHORIZATION);
        String jwtToken = authHeader.split(" ")[1]; // "Bearer jwtToken"
        String[] parts = jwtToken.split("\\.");
        //String headerJson = new String(decoder.decode(parts[0]));
        String payloadJson = new String(decoder.decode(parts[1]));
        //String signatureJson = new String(decoder.decode(parts[2]));
        return jsonMap(payloadJson).get("sub");
    }

    protected Map<String, String> jsonMap(String json) {
        try {
            return objectMapper.readValue(json,
                new TypeReference<Map<String, String>>() {});
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    protected <T> ResponseEntity<T> entity(T body, HttpStatus status) {
        HttpHeaders responseHeaders = new HttpHeaders();
        //responseHeaders.setLocation(location);
        //responseHeaders.set("MyResponseHeader", "MyValue");
        //
        return new ResponseEntity<>(body, responseHeaders, status == null ? HttpStatus.OK : status);
        //return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    protected String error(Exception e) {
        if (debug) {
            e.printStackTrace();
            return ExceptionUtils.getStackTrace(e);
        }
        return ExceptionUtils.getRootCauseMessage(e);
    }

}
