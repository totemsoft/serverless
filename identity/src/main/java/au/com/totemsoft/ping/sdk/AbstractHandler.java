package au.com.totemsoft.ping.sdk;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.sourceid.websso.servlet.adapter.Handler;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.Generated;
import au.com.totemsoft.ping.PcvConstants;
import au.com.totemsoft.ping.domain.AbstractResponse;
import au.com.totemsoft.ping.domain.CustomerRequest;

@Generated
public abstract class AbstractHandler<T extends AbstractResponse> implements Handler {

    protected final Logger log = LogManager.getLogger(getClass());

    protected final PluginConfiguration config;

    protected AbstractHandler(PluginConfiguration config) {
        this.config = config;
    }

    @Override
    public void handle(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info(String.format("Processing %s request for %s", req.getContextPath(), req.getParameter(PcvConstants.USERNAME_ATTRIBUTE)));
        final ObjectMapper mapper = new ObjectMapper();
        // get and parse json request
        CustomerRequest request = mapper.readValue(req.getReader(), CustomerRequest.class);
        log.info("request\n" + request);
        // send request for processing
        T result = execute(request, req, resp);
        // write to response
        if (result.getStatusCode() != null) {
            resp.setStatus(result.getStatusCode());
        }
        // re-map statusCode
        if (result.getErrorCode() != null) {
            result.setStatusCode(PcvConstants.BUSINESS_ERROR);
        }
        mapper.writeValue(resp.getWriter(), result);
    }

    protected abstract T execute(CustomerRequest request,
        HttpServletRequest req, HttpServletResponse resp) throws IOException;

}
