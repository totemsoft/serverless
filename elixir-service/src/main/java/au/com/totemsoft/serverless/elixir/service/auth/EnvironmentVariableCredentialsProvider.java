package au.com.totemsoft.serverless.elixir.service.auth;

import static com.amazonaws.SDKGlobalConfiguration.ACCESS_KEY_ENV_VAR;
import static com.amazonaws.SDKGlobalConfiguration.ALTERNATE_ACCESS_KEY_ENV_VAR;
import static com.amazonaws.SDKGlobalConfiguration.ALTERNATE_SECRET_KEY_ENV_VAR;
import static com.amazonaws.SDKGlobalConfiguration.AWS_SESSION_TOKEN_ENV_VAR;
import static com.amazonaws.SDKGlobalConfiguration.SECRET_KEY_ENV_VAR;

import com.amazonaws.SdkClientException;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.auth.BasicSessionCredentials;
import com.amazonaws.util.StringUtils;

/**
 * Copy of @EnvironmentVariableCredentialsProvider from AWS - added custom env credential names.
 * 
 * {@link AWSCredentialsProvider} implementation that provides credentials by looking at the: <code>AWS_ACCESS_KEY_ID</code> (or
 * <code>AWS_ACCESS_KEY</code>) and <code>AWS_SECRET_KEY</code> (or <code>AWS_SECRET_ACCESS_KEY</code>) environment variables. If
 * the <code>AWS_SESSION_TOKEN</code> environment variable is also set then temporary credentials will be used.
 */
public class EnvironmentVariableCredentialsProvider implements AWSCredentialsProvider {

    /////////////////////// Environment Variables ///////////////////////
    /** Environment variable name for the AWS access key ID */
    private static final String ACCESS_KEY_ID = "ACCESS_KEY_ID";

    /** Environment variable name for the AWS secret key */
    private static final String SECRET_ACCESS_KEY = "SECRET_ACCESS_KEY";

    @Override
    public AWSCredentials getCredentials() {
        String accessKey = System.getenv(ACCESS_KEY_ENV_VAR);
        if (accessKey == null) {
            accessKey = System.getenv(ALTERNATE_ACCESS_KEY_ENV_VAR);
        }
        if (accessKey == null) {
            accessKey = System.getenv(ACCESS_KEY_ID);
        }

        String secretKey = System.getenv(SECRET_KEY_ENV_VAR);
        if (secretKey == null) {
            secretKey = System.getenv(ALTERNATE_SECRET_KEY_ENV_VAR);
        }
        if (secretKey == null) {
            secretKey = System.getenv(SECRET_ACCESS_KEY);
        }

        accessKey = StringUtils.trim(accessKey);
        secretKey = StringUtils.trim(secretKey);
        if (StringUtils.isNullOrEmpty(accessKey) || StringUtils.isNullOrEmpty(secretKey)) {
            throw new SdkClientException(
                "Unable to load AWS credentials from environment variables " +
                "(" + ACCESS_KEY_ENV_VAR + " (or " + ALTERNATE_ACCESS_KEY_ENV_VAR + " or " + ACCESS_KEY_ID + ") and " +
                SECRET_KEY_ENV_VAR + " (or " + ALTERNATE_SECRET_KEY_ENV_VAR + " or " + SECRET_ACCESS_KEY + "))");
        }

        String sessionToken = System.getenv(AWS_SESSION_TOKEN_ENV_VAR);
        if (sessionToken == null) {
            sessionToken = System.getenv("SESSION_TOKEN");
        }
        sessionToken = StringUtils.trim(sessionToken);
        return sessionToken == null ?
            new BasicAWSCredentials(accessKey, secretKey)
            :
            new BasicSessionCredentials(accessKey, secretKey, sessionToken);
    }

    @Override
    public void refresh() {
    }

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }

}
