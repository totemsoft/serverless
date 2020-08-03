package au.com.totemsoft.serverless.elixir.service;

import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.springframework.core.io.Resource;

public interface UploadService {

    /** lastModified */
    String LAST_MODIFIED = "lastModified";
    SimpleDateFormat LAST_MODIFIED_FORMAT = new SimpleDateFormat("yyyy-MM-dd'T'HHmmss.SSS");

    String CONTENT_TYPE = "contentType";

    String FILE_NOTE = "fileNote";

    List<ImmutablePair<String, String>> list();

    List<ImmutablePair<String, String>> list(String reference);

    /**
     * Translate reference to folderId (could be different, eg for AWS WorkDocs)
     * @param reference - directory name
     * @return folderId
     * @throws IOException
     */
    String mkdir(String reference) throws IOException;

    /**
     * 
     * @param reference - directory to store document
     * @param folderId
     * @param resource
     * @param metadata
     * @return
     * @throws IOException
     */
    String upload(String reference, String folderId,
        Resource resource, Map<String, Object> metadata) throws IOException;

    /**
     * 
     * @param reference - directory to get document from
     * @param folderId
     * @param name - file name
     * @param target
     * @throws IOException
     */
    public void download(String reference, String folderId,
        String name, OutputStream target) throws IOException;

}
