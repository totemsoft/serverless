package au.com.totemsoft.serverless.elixir.service;

import java.io.IOException;
import java.io.OutputStream;
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
     * @param reference
     * @param resource
     * @param metadata
     * @return
     * @throws IOException
     */
    String upload(String reference, Resource resource, Map<String, Object> metadata) throws IOException;

    /**
     * 
     * @param reference
     * @param target
     * @throws IOException
     */
    public void download(String reference, OutputStream target) throws IOException;

}
