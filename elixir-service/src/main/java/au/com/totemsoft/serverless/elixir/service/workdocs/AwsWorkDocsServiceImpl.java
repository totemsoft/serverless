package au.com.totemsoft.serverless.elixir.service.workdocs;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import com.amazonaws.SdkClientException;
import com.amazonaws.services.workdocs.AmazonWorkDocs;
import com.amazonaws.services.workdocs.AmazonWorkDocsClientBuilder;
import com.amazonaws.services.workdocs.model.DocumentMetadata;
import com.amazonaws.services.workdocs.model.FolderMetadata;
import com.fasterxml.jackson.databind.ObjectMapper;

import au.com.totemsoft.elixir.survey.v1.model.BrokerDetails;
import au.com.totemsoft.serverless.elixir.service.UploadService;

@Service("workDocsUploadService")
public class AwsWorkDocsServiceImpl implements UploadService {

    private static final Logger LOG = LogManager.getLogger();

    @Autowired
    private ObjectMapper objectMapper;

    /** The name of an existing bucket, or access point ARN, to which the new object will be uploaded. */
    @Value("#{environment.AWS_WORKDOCS_FOLDER}")
    private String documentFolderId;

    //** WorkDoks does not require region selection ??? */
    //@Value("#{environment.AWS_REGION ?: 'ap-southeast-2'}")
    //private String region;
    //private Region DEFAULT_REGION = Region.getRegion(Regions.AP_SOUTHEAST_2);

    private AmazonWorkDocsClientBuilder builder;

    private AmazonWorkDocs client() {
        if (builder == null) {
            if (!WorkDocsHelper.checkFolderId(null, documentFolderId)) {
                throw new SdkClientException(
                    "Unable to load AWS WorkDocs folder from environment variable AWS_WORKDOCS_FOLDER: " + documentFolderId);
            }
            builder = AmazonWorkDocsClientBuilder.standard()
                //.withCredentials(new EnvironmentVariableCredentialsProvider())
                //.withRegion(region)
                ;
        }
        return builder.build();
    }

    private <T> T readValue(String folderId, String name, Class<T> valueType) throws IOException {
        final ByteArrayOutputStream stream = new ByteArrayOutputStream();
        download(folderId, name, stream);
        return objectMapper.readValue(stream.toByteArray(), valueType);
    }

    @Override
    public List<ImmutablePair<UUID, String>> findByBroker(BrokerDetails broker) throws IOException {
        final AmazonWorkDocs client = client();
        try {
            List<ImmutablePair<UUID, String>> result = new ArrayList<>();
            for (FolderMetadata folder : WorkDocsHelper.getFolders(client, documentFolderId)) {
                final String refName = folder.getName();
                final UUID ref;
                try {
                    ref = UUID.fromString(refName);
                } catch (IllegalArgumentException ignore) {
                    // key does not conform to the string representation of UUID
                    continue;
                }
                final String folderId = folder.getId();
                // filter by broker's client
                BrokerDetails thisBroker = readValue(folderId, brokerFile(ref), BrokerDetails.class);
                if (thisBroker != null && thisBroker.getClient().equals(broker.getClient())) {
                    result.add(new ImmutablePair<>(ref, folderId));
                }
            }
            return result;
        } finally {
            client.shutdown();
        }
    }

    @Override
    public ImmutablePair<UUID, String> findByReference(BrokerDetails broker, String reference) throws IOException {
        final AmazonWorkDocs client = client();
        try {
            final String folderId = WorkDocsHelper.getFolderId(client, documentFolderId, reference);
            for (FolderMetadata folder : WorkDocsHelper.getFolders(client, folderId)) {
                final String refName = folder.getName();
                final UUID ref;
                try {
                    ref = UUID.fromString(refName);
                } catch (IllegalArgumentException ignore) {
                    // key does not conform to the string representation of UUID
                    continue;
                }
                // filter by broker's client
                BrokerDetails thisBroker = readValue(folder.getId(), brokerFile(ref), BrokerDetails.class);
                if (thisBroker == null) {
                    throw new IllegalArgumentException("No broker found for " + reference);
                }
                if (thisBroker.getClient().equals(broker.getClient())) {
                    return new ImmutablePair<>(ref, folder.getId());
                }
                throw new IllegalArgumentException("Broker's client does not match for " + reference);
            }
            return null;
        } finally {
            client.shutdown();
        }
    }

    @Override
    public String mkdir(String reference) throws IOException {
        final AmazonWorkDocs client = client();
        try {
            // TODO: use WorkDocs folderId as file reference ???
            return WorkDocsHelper.getOrCreateFolderId(client, documentFolderId, reference);
        } finally {
            client.shutdown();
        }
    }

    @Override
    public String upload(String folderId, Resource resource, Map<String, Object> metadata) throws IOException {
        final AmazonWorkDocs client = client();
        try {
            String name = metadata.get(NAME).toString();
            String contentType = metadata.get(CONTENT_TYPE).toString();
            Map<String, String> map = WorkDocsHelper.documentUploadMetadata(client, folderId, name, contentType);
            String documentId = map.get("doc_id");
            String versionId = map.get("version_id");
            String uploadUrl = map.get("upload_url");
            //
            int rc = WorkDocsHelper.documentUploadStart(uploadUrl, contentType, resource);
            if (rc == HttpURLConnection.HTTP_OK) {
                WorkDocsHelper.documentUploadComplete(client, documentId, versionId);
            }
            return documentId;
        } finally {
            client.shutdown();
        }
    }

    @Override
    public void download(String folderId, String name, OutputStream target) throws IOException {
        final AmazonWorkDocs client = client();
        try {
            DocumentMetadata document = WorkDocsHelper.documentMetadata(client, folderId, name);
            if (document == null) {
                throw new IOException("No document found: " + name);
            }
            String downloadUrl = WorkDocsHelper.documentUrl(client, document);
            WorkDocsHelper.documentDownload(downloadUrl, target);
        } finally {
            client.shutdown();
        }
    }

}
