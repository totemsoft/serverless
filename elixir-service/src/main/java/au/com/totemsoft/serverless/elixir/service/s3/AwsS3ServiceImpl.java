package au.com.totemsoft.serverless.elixir.service.s3;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.PutObjectResult;

import au.com.totemsoft.serverless.elixir.service.UploadService;

@Service("s3UploadService")
public class AwsS3ServiceImpl implements UploadService {

    /** The name of an existing bucket, or access point ARN, to which the new object will be uploaded. */
    @Value("#{environment.AWS_BUCKET}")
    private String bucket;

    //** S3 does not require region selection */
    //@Value("#{environment.AWS_REGION ?: 'ap-southeast-2'}")
    //private String region;
    //private Region DEFAULT_REGION = Region.getRegion(Regions.AP_SOUTHEAST_2);

    private AmazonS3ClientBuilder builder;

    private AmazonS3 client() {
        if (builder == null) {
            builder = AmazonS3ClientBuilder.standard()
                //.withCredentials(new EnvironmentVariableCredentialsProvider())
                //.withRegion(region)
                ;
        }
        return builder.build();
    }

    @Override
    public List<ImmutablePair<String, String>> list() {
        throw new IllegalArgumentException("Not implememnted yet.");
    }

    @Override
    public ImmutablePair<String, String> find(String reference) {
        throw new IllegalArgumentException("Not implememnted yet.");
    }

    @Override
    public String mkdir(String reference) throws IOException {
        return reference;
    }

    @Override
    public String upload(String reference, String folderId,
        Resource resource, Map<String, Object> metadata) throws IOException {
        final AmazonS3 client = client();
        // store in pathname folder
        final ObjectMetadata om = new ObjectMetadata();
        for (Iterator<Entry<String, Object>> i = metadata.entrySet().iterator(); i.hasNext(); ) {
            final Entry<String, Object> entry = i.next();
            final String key = entry.getKey();
            final Object value = entry.getValue();
            if (LAST_MODIFIED.equals(key)) {
                om.setLastModified((Date) value);
            } else if (CONTENT_TYPE.equals(key)) {
                om.setContentType(value.toString());
            } else if (value != null) {
                om.addUserMetadata(key, value.toString());
            }
        }
        final String name = resource.getFilename();
        PutObjectResult result = client.putObject(new PutObjectRequest(bucket,
            folderId + '/' + name,
            resource.getInputStream(),
            om));
        return result.getETag();
    }

    @Override
    public void download(String reference, String folderId,
        String name, OutputStream target) throws IOException {
        throw new IllegalArgumentException("Not implememnted yet.");
    }

}
