package au.com.totemsoft.serverless.elixir.service;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Map;

import org.springframework.core.io.Resource;

public interface UploadService {

    /** lastModified */
    String LAST_MODIFIED = "lastModified";
    SimpleDateFormat LAST_MODIFIED_FORMAT = new SimpleDateFormat("yyyy-MM-dd'T'HHmmss.SSS");

    String CONTENT_TYPE = "contentType";

    String FILE_NOTE = "fileNote";

    /**
     * Translate reference to folderId (could be different, eg for AWS WorkDocs)
     * @param reference
     * @return folderId
     * @throws IOException
     */
    String mkdir(String reference) throws IOException;

    /**
     * 
     * @param resource
     * @param reference
     * @param metadata
     * @return
     * @throws IOException
     */
    String upload(Resource resource, String reference, Map<String, Object> metadata) throws IOException;

}
