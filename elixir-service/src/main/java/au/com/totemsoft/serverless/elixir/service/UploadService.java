package au.com.totemsoft.serverless.elixir.service;

import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.springframework.core.io.Resource;

import au.com.totemsoft.elixir.survey.v1.model.BrokerDetails;

public interface UploadService {

    String BROKER_JSON  = ".broker.json";
    String SURVEY_JSON  = ".survey.json";
    String INSURED_JSON = ".insured.json";

    String NAME = "name";

    String LAST_MODIFIED = "lastModified";
    SimpleDateFormat LAST_MODIFIED_FORMAT = new SimpleDateFormat("yyyy-MM-dd'T'HHmmss.SSS");

    String CONTENT_TYPE = "contentType";

    String FILE_NOTE = "fileNote";

    List<ImmutablePair<UUID, String>> findByBroker(BrokerDetails broker) throws IOException;

    ImmutablePair<UUID, String> findByReference(BrokerDetails broker, String reference) throws IOException;

    /**
     * Translate reference to folderId (could be different, eg for AWS WorkDocs)
     * @param reference - directory name
     * @return folderId
     * @throws IOException
     */
    String mkdir(String reference) throws IOException;

    /**
     * 
     * @param folderId - directory to get document from, reference => folderId
     * @param resource
     * @param metadata
     * @return
     * @throws IOException
     */
    String upload(String folderId, Resource resource, Map<String, Object> metadata) throws IOException;

    /**
     * 
     * @param folderId - directory to get document from, reference => folderId
     * @param name - file name
     * @param target
     * @throws IOException
     */
    void download(String folderId, String name, OutputStream target) throws IOException;

}
