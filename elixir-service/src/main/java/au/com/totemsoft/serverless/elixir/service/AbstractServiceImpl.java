package au.com.totemsoft.serverless.elixir.service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class AbstractServiceImpl {

    protected final Logger log = LogManager.getLogger();

    @Value("#{environment.DEBUG ?: 'true'}")
    private boolean debug;

    @Autowired
    @Qualifier("sqsService")
    protected MessageService messageService;

    @Autowired
    @Qualifier("workDocsUploadService")
    //@Qualifier("s3UploadService")
    protected UploadService uploadService;

    @Autowired
    protected ObjectMapper objectMapper;

    @Resource
    private HttpServletRequest httpServletRequest;

    protected HttpServletRequest httpServletRequest() {
        return httpServletRequest;
    }

    /**
     * Current userId - derived from JWT.
     * @return
     */
    protected String sub() {
        final Base64.Decoder decoder = Base64.getUrlDecoder();
        String authHeader = httpServletRequest.getHeader(HttpHeaders.AUTHORIZATION);
        if (authHeader == null) {
            throw new RuntimeException("No HTTP Authorization header found.");
        }
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

    @SuppressWarnings("unchecked")
    protected <T> T readValue(String folderId, String name, Class<T> valueType) throws IOException {
        final ByteArrayOutputStream stream = new ByteArrayOutputStream();
        uploadService.download(folderId, name, stream);
        if (String.class.equals(valueType)) {
            return (T) stream.toString();
        }
        return objectMapper.readValue(stream.toByteArray(), valueType);
    }

    protected <T> ResponseEntity<T> entity(T body, HttpStatus status, MediaType contentType) {
        HttpHeaders responseHeaders = new HttpHeaders();
        if (contentType != null) {
            responseHeaders.setContentType(contentType);
        }
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
