package au.com.totemsoft.serverless.elixir;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

import javax.ws.rs.HttpMethod;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.cxf.helpers.IOUtils;
import org.junit.BeforeClass;
import org.junit.Test;

import com.amazonaws.serverless.proxy.internal.LambdaContainerHandler;
import com.amazonaws.serverless.proxy.internal.testutils.AwsProxyRequestBuilder;
import com.amazonaws.serverless.proxy.internal.testutils.MockLambdaContext;
import com.amazonaws.serverless.proxy.model.AwsProxyResponse;
import com.amazonaws.services.lambda.runtime.Context;

public class StreamLambdaHandlerTest {

    // APPLICATION_JSON_UTF8
    private static final String APPLICATION_JSON = MediaType.APPLICATION_JSON + ";charset=UTF-8";

    private static StreamLambdaHandler handler;
    private static Context lambdaContext;

    @BeforeClass
    public static void setUp() {
        handler = new StreamLambdaHandler();
        lambdaContext = new MockLambdaContext();
    }

    @Test
    public void health() {
        InputStream requestStream = new AwsProxyRequestBuilder("/health", HttpMethod.GET)
            .header(HttpHeaders.ACCEPT, APPLICATION_JSON)
            .buildStream();
        ByteArrayOutputStream responseStream = new ByteArrayOutputStream();

        handle(requestStream, responseStream);

        AwsProxyResponse response = readResponse(responseStream);
        assertNotNull(response);
        assertEquals(Response.Status.OK.getStatusCode(), response.getStatusCode());
        assertFalse(response.isBase64Encoded());
        assertTrue(response.getBody().contains("\"status\":\"UP\""));
        assertTrue(response.getMultiValueHeaders().containsKey(HttpHeaders.CONTENT_TYPE));
        assertTrue(response.getMultiValueHeaders().getFirst(HttpHeaders.CONTENT_TYPE).startsWith(MediaType.APPLICATION_JSON));
    }

    @Test
    public void health_404() {
        InputStream requestStream = new AwsProxyRequestBuilder("/ZDOROVJE", HttpMethod.GET)
            .header(HttpHeaders.ACCEPT, APPLICATION_JSON)
            .buildStream();
        ByteArrayOutputStream responseStream = new ByteArrayOutputStream();

        handle(requestStream, responseStream);

        AwsProxyResponse response = readResponse(responseStream);
        assertNotNull(response);
        assertEquals(Response.Status.NOT_FOUND.getStatusCode(), response.getStatusCode());
    }

    @Test
    public void survey_upload() throws IOException {
        InputStream contentStream = getClass().getClassLoader().getResourceAsStream("document.json");
        InputStream requestStream = new AwsProxyRequestBuilder("/survey/upload", HttpMethod.POST)
            .header(HttpHeaders.CONTENT_TYPE, MediaType.MULTIPART_FORM_DATA + "; boundary=survey_upload")
            .header(HttpHeaders.AUTHORIZATION, "Bearer " + System.getProperty("access_token", "{{access_token}}"))
            .header("x-v", "1")
            .header("reference", UUID.randomUUID().toString())
            .formFilePart("fileUpload", "document.json", IOUtils.readBytesFromStream(contentStream))
            .toHttpApiV2RequestStream();
        ByteArrayOutputStream responseStream = new ByteArrayOutputStream();

        handle(requestStream, responseStream);

        AwsProxyResponse response = readResponse(responseStream);
        assertNotNull(response);
        assertEquals(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), response.getStatusCode());
    }

    private void handle(InputStream is, ByteArrayOutputStream os) {
        try {
            handler.handleRequest(is, os, lambdaContext);
        } catch (IOException e) {
            e.printStackTrace();
            fail(e.getMessage());
        }
    }

    private AwsProxyResponse readResponse(ByteArrayOutputStream responseStream) {
        try {
            return LambdaContainerHandler.getObjectMapper().readValue(responseStream.toByteArray(), AwsProxyResponse.class);
        } catch (IOException e) {
            e.printStackTrace();
            fail("Error while parsing response: " + e.getMessage());
        }
        return null;
    }

}
