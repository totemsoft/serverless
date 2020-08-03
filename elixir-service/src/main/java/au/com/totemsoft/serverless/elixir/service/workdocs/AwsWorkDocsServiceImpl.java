package au.com.totemsoft.serverless.elixir.service.workdocs;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import com.amazonaws.SdkClientException;
import com.amazonaws.services.workdocs.AmazonWorkDocs;
import com.amazonaws.services.workdocs.AmazonWorkDocsClientBuilder;
import com.amazonaws.services.workdocs.model.DocumentMetadata;
import com.amazonaws.services.workdocs.model.FolderMetadata;

import au.com.totemsoft.serverless.elixir.service.UploadService;

@Service("workDocsUploadService")
public class AwsWorkDocsServiceImpl implements UploadService {

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

    @Override
    public List<String> list() {
        final AmazonWorkDocs client = client();
        try {
            List<String> result = new ArrayList<>();
            for (FolderMetadata folder : WorkDocsHelper.getFolders(client, documentFolderId)) {
                result.add(folder.getName());
            }
            return result;
        } finally {
            client.shutdown();
        }
    }

    @Override
    public List<String> list(String reference) {
        final AmazonWorkDocs client = client();
        try {
            List<String> result = new ArrayList<>();
            final String folderId = WorkDocsHelper.getFolderId(client, documentFolderId, reference);
            for (FolderMetadata folder : WorkDocsHelper.getFolders(client, folderId)) {
                result.add(folder.getName());
            }
            return result;
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
    public String upload(String reference, Resource resource, Map<String, Object> metadata) throws IOException {
        final AmazonWorkDocs client = client();
        try {
            final String folderId = WorkDocsHelper.getFolderId(client, documentFolderId, reference);
            final String name = resource.getFilename() != null ? resource.getFilename() : resource.getDescription();
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
    public void download(String reference, String name, OutputStream target) throws IOException {
        final AmazonWorkDocs client = client();
        try {
            final String folderId = WorkDocsHelper.getFolderId(client, documentFolderId, reference);
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
