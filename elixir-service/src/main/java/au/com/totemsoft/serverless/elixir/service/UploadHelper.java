package au.com.totemsoft.serverless.elixir.service;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Map;

import org.springframework.core.io.Resource;

public interface UploadHelper {

    /** lastModified */
    String LAST_MODIFIED = "lastModified";
    SimpleDateFormat LAST_MODIFIED_FORMAT = new SimpleDateFormat("yyyy-MM-dd'T'HHmmss.SSS");

    String CONTENT_TYPE = "contentType";

    /**
     * 
     * @param resource
     * @param metadata
     * @return
     * @throws IOException
     */
    String upload(Resource resource, Map<String, Object> metadata) throws IOException;

}
