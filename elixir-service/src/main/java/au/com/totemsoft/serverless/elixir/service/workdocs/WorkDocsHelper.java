package au.com.totemsoft.serverless.elixir.service.workdocs;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.core.io.Resource;

import com.amazonaws.SdkClientException;
import com.amazonaws.services.workdocs.AmazonWorkDocs;
import com.amazonaws.services.workdocs.model.AmazonWorkDocsException;
import com.amazonaws.services.workdocs.model.CreateFolderRequest;
import com.amazonaws.services.workdocs.model.CreateFolderResult;
import com.amazonaws.services.workdocs.model.DeleteFolderRequest;
import com.amazonaws.services.workdocs.model.DescribeFolderContentsRequest;
import com.amazonaws.services.workdocs.model.DescribeFolderContentsResult;
import com.amazonaws.services.workdocs.model.DescribeUsersRequest;
import com.amazonaws.services.workdocs.model.DescribeUsersResult;
import com.amazonaws.services.workdocs.model.DocumentMetadata;
import com.amazonaws.services.workdocs.model.DocumentSourceType;
import com.amazonaws.services.workdocs.model.DocumentVersionMetadata;
import com.amazonaws.services.workdocs.model.DocumentVersionStatus;
import com.amazonaws.services.workdocs.model.EntityAlreadyExistsException;
import com.amazonaws.services.workdocs.model.FolderMetadata;
import com.amazonaws.services.workdocs.model.GetDocumentVersionRequest;
import com.amazonaws.services.workdocs.model.GetDocumentVersionResult;
import com.amazonaws.services.workdocs.model.InitiateDocumentVersionUploadRequest;
import com.amazonaws.services.workdocs.model.InitiateDocumentVersionUploadResult;
import com.amazonaws.services.workdocs.model.UpdateDocumentRequest;
import com.amazonaws.services.workdocs.model.UpdateDocumentVersionRequest;
import com.amazonaws.services.workdocs.model.UpdateFolderRequest;
import com.amazonaws.services.workdocs.model.UploadMetadata;
import com.amazonaws.services.workdocs.model.User;

public class WorkDocsHelper {

    public static List<User> describeUsers(AmazonWorkDocs client, String organizationId, String userName) {
        DescribeUsersRequest request = new DescribeUsersRequest();
        // Set to the OrganizationId of your WorkDocs site.
        request.setOrganizationId(organizationId);
        String marker = null;
        List<User> users = new ArrayList<>();
        do {
            request.setMarker(marker);
            if (userName != null) {
                request.setQuery(userName);
            }
            DescribeUsersResult result = client.describeUsers(request);
            users.addAll(result.getUsers());
            marker = result.getMarker();
        } while (marker != null);
        return users;
    }

    public static User describeUser(AmazonWorkDocs client, String organizationId, String userName) {
        List<User> users = describeUsers(client, organizationId, userName);
        if (users.isEmpty()) {
            throw new SdkClientException("No user found: " + userName);
        }
        if (users.size() == 1) {
            return users.get(0);
        }
        throw new SdkClientException("Multiple users found: " + userName);
    }

    public static String getRootFolderId(AmazonWorkDocs client, String organizationId, String userName) {
        User user = describeUser(client, organizationId, userName);
        return user.getRootFolderId();
    }

    /**
     * TODO: better logic to identify WorkDocs folders ???
     * @param client
     * @param folderId
     * @param create
     * @return
     */
    public static boolean checkFolderId(AmazonWorkDocs client, String folderId) {
        if (folderId != null && folderId.trim().length() == 64 && StringUtils.isAlphanumeric(folderId.trim())) {
            return true;
        }
        return false;
    }

    public static String getOrCreateFolderId(AmazonWorkDocs client, String folderId, String name) {
        if (checkFolderId(client, name)) {
            return name;
        }
        // map reference to WorkDocs folderId (create directory if resource does not exist)
        try {
            CreateFolderRequest request = new CreateFolderRequest();
            request.setParentFolderId(folderId);
            request.setName(name);
            CreateFolderResult result = client.createFolder(request);
            return result.getMetadata().getId();
        } catch (EntityAlreadyExistsException e) {
            return getFolderId(client, folderId, name);
        }
    }

    /**
     * @param client
     * @param baseFolderId
     * @param name
     * @return
     */
    public static String getFolderId(AmazonWorkDocs client, String folderId, String name) {
        if (checkFolderId(client, name)) {
            return name;
        }
        //
        DescribeFolderContentsRequest request = new DescribeFolderContentsRequest();
        request.setFolderId(folderId);
        String marker = null;
        do {
            request.setMarker(marker);
            DescribeFolderContentsResult result = client.describeFolderContents(request);
            for (FolderMetadata folder: result.getFolders()) {
                if (folder.getName().equals(name)) {
                    return folder.getId();
                }
            }
            marker = result.getMarker();
        } while (marker != null);
        throw new SdkClientException("No folder found: " + folderId + "/" + name);
    }

    public static DocumentMetadata documentMetadata(AmazonWorkDocs client, String folderId, String name) {
        DescribeFolderContentsRequest request = new DescribeFolderContentsRequest();
        request.setFolderId(folderId);
        DescribeFolderContentsResult result = client.describeFolderContents(request);
        for (DocumentMetadata document : result.getDocuments()) {
            if (name.equals(document.getLatestVersionMetadata().getName())) {
                return document;
            }
        }
        return null;
    }

    public static String documentUrl(AmazonWorkDocs client, DocumentMetadata document) {
        GetDocumentVersionRequest request = new GetDocumentVersionRequest();
        request.setDocumentId(document.getId());
        request.setVersionId(document.getLatestVersionMetadata().getId());
        request.setFields("SOURCE");
        GetDocumentVersionResult result = client.getDocumentVersion(request);
        return result.getMetadata().getSource().get(DocumentSourceType.ORIGINAL.name());
    }

    public static void documentDownload(String downloadUrl, OutputStream output) throws IOException {
        // get doc from provided URL
        URL url = new URL(downloadUrl);
        URLConnection connection = url.openConnection();
        try (final InputStream input = connection.getInputStream();) {
            IOUtils.copy(input, output);
        }
    }

    public static Map<String, String> documentUploadMetadata(AmazonWorkDocs client, String folderId, String name, String contentType) {
        InitiateDocumentVersionUploadRequest request = new InitiateDocumentVersionUploadRequest();
        request.setParentFolderId(folderId);
        request.setName(name);
        request.setContentType(contentType);
        //
        InitiateDocumentVersionUploadResult result = client.initiateDocumentVersionUpload(request);
        UploadMetadata uploadMetadata = result.getUploadMetadata();
        DocumentMetadata document = result.getMetadata();
        DocumentVersionMetadata md = document.getLatestVersionMetadata();
        //
        Map<String, String> map = new HashMap<>();
        map.put("doc_id", document.getId());
        map.put("version_id", md.getId());
        map.put("upload_url", uploadMetadata.getUploadUrl());
        return map;
    }

    public static int documentUploadStart(String uploadUrl, String contentType, Resource resource) throws IOException {
        URL url = new URL(uploadUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setDoOutput(true);
        connection.setRequestMethod("PUT");
        // Content-Type supplied here should match with the Content-Type set in the InitiateDocumentVersionUpload request.
        connection.setRequestProperty("Content-Type", contentType);
        connection.setRequestProperty("x-amz-server-side-encryption", "AES256");
        InputStream inputStream = resource.getInputStream();
        OutputStream outputStream = connection.getOutputStream();
        IOUtils.copy(inputStream, outputStream);
        IOUtils.closeQuietly(inputStream);
        IOUtils.closeQuietly(outputStream);
        // Very misleading. Getting a 200 only means the call succeeded, not that the copy worked.
        return connection.getResponseCode();  // int where 200 == success
    }

    public static void documentUploadComplete(AmazonWorkDocs client, String documentId, String versionId) {
        UpdateDocumentVersionRequest request = new UpdateDocumentVersionRequest();
        request.setDocumentId(documentId);
        request.setVersionId(versionId);
        request.setVersionStatus(DocumentVersionStatus.ACTIVE);
        /*UpdateDocumentVersionResult result = */client.updateDocumentVersion(request);
    }

    public static void removeFile(AmazonWorkDocs client, String pathname) {
        // TODO: delete file
    }

    public static void removeDir(AmazonWorkDocs client, String pathname) {
        //final boolean dir = StringUtils.endsWith(pathname, "/");
        String[] path = StringUtils.split(pathname, '/');
        String folderId = path[0];
        String name = path[path.length - 1];
        DeleteFolderRequest request = new DeleteFolderRequest();
        request.setFolderId(getFolderId(client, folderId, name));
        /*DeleteFolderResult result = */client.deleteFolder(request);
    }

    public static String mkdirs(AmazonWorkDocs client, String pathname, String directory) {
        try {
            final boolean dir = StringUtils.endsWith(directory, "/");
            final String[] paths = StringUtils.split(directory, '/');
            final String folderId = paths[0];
            final String name = paths[paths.length - 1];
            if (dir) {
                if (StringUtils.isBlank(pathname)) {
                    // create directory  - The resource already exists.
                    try {
                        CreateFolderRequest request = new CreateFolderRequest();
                        request.setParentFolderId(folderId);
                        request.setName(name);
                        CreateFolderResult result = client.createFolder(request);
                        return result.getMetadata().getId();
                    } catch (EntityAlreadyExistsException e) {
                        //LOG.info("FAILED to mkdirs: pathname=" + pathname + ", directory=" + directory + ". EntityAlreadyExistsException: " + e.getMessage());
                        return getFolderId(client, folderId, name);
                    }
                }
                // update directory
                UpdateFolderRequest request = new UpdateFolderRequest();
                request.setFolderId(folderId);
                request.setName(name);
                /*UpdateFolderResult result = */client.updateFolder(request);
            }
            return folderId;
        } catch (AmazonWorkDocsException e) {
            //LOG.error("FAILED to mkdirs: pathname=" + pathname + ", directory=" + directory + ". AmazonWorkDocsException: " + e.getMessage());
            throw e;
        }
    }

    public static void renameDir(AmazonWorkDocs client, String from, String to) {
        final String[] fromPath = StringUtils.split(from, '/');
        final String fromFolderId = fromPath[0];
        final String fromName = fromPath[fromPath.length - 1];
        //
        final String[] toPath = StringUtils.split(to, '/');
        final String toFolderId = toPath[0];
        final String toName = toPath[toPath.length - 1];
        //
        UpdateFolderRequest request = new UpdateFolderRequest();
        if (fromFolderId.equals(toFolderId)) {
            // rename folder within baseFolderId
            request.setFolderId(getFolderId(client, fromFolderId, fromName));
            request.setName(toName);
            //LOG.info("renameDir in " + fromFolderId + ": from " + fromName + " to " + toName);
        } else if (fromName.equals(toName)) {
            // archive - move folder 'file/' to new baseFolder '_Archive/file/'
            request.setFolderId(getFolderId(client, fromFolderId, fromName));
            request.setParentFolderId(toFolderId);
            //LOG.info("renameDir " + fromFolderId + "/" + fromName + " to " + toFolderId + "/" + toName);
        }
        /*UpdateFolderResult result = */client.updateFolder(request);
    }

    public static void renameFile(AmazonWorkDocs client, String from, String to) {
        final String[] fromPath = StringUtils.split(from, '/');
        final String fromFolderId = fromPath[0];
        final String fromName = fromPath[fromPath.length - 1];
        //
        final String[] toPath = StringUtils.split(to, '/');
        final String toFolderId = toPath[0];
        final String toName = toPath[toPath.length - 1];
        //
        DocumentMetadata document = documentMetadata(client, fromFolderId, fromName);
        if (document == null) {
            throw new SdkClientException("Could not move " + from + " to " + to);
        }
        UpdateDocumentRequest request = new UpdateDocumentRequest();
        request.setDocumentId(document.getId());
        if (fromFolderId.equals(toFolderId)) {
            // rename document within baseFolder
            request.setName(toName);
        } else {
            // move document to new baseFolder
            request.setParentFolderId(toFolderId);
        }
        /*UpdateDocumentResult result = */client.updateDocument(request);
    }

}