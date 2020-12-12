package au.com.totemsoft.ping;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.sourceid.saml20.domain.datasource.info.LdapInfo;
import org.springframework.ldap.core.support.LdapContextSource;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pingidentity.access.DataSourceAccessor;

import au.com.totemsoft.ping.domain.AbstractResponse;
import au.com.totemsoft.ping.domain.SendOtpResponse;
import au.com.totemsoft.ping.domain.ValidateOtpResponse;
import au.com.totemsoft.ping.domain.ValidateUsernameResponse;
import au.com.totemsoft.ping.http.CloseableHttpClientBuilder;
import au.com.totemsoft.ping.sdk.PluginConfiguration;
import lombok.Generated;

@Generated
public class UserService {

    private static final Logger LOG = LogManager.getLogger(UserService.class);

    private static final String JSON_KEY_OTP = "otp";
    private static final String JSON_KEY_OTP_DATA_ID = "otpDataId";

    // baseAddress
    private final String baseAddress; // https://ms-users/api/users/
    // keyStoreAlias
    private final String keyStoreAlias;
    // relative path segment
    private final String validateUsernamePath = "identity/validateUsername";
    private final String sendOtpPath = "identity/sendOtp";
    private final String validateOtpPath = "identity/validateOtp";

    public UserService(PluginConfiguration config) {
        this.baseAddress = config.getBaseAddress();
        this.keyStoreAlias = config.getKeyStoreAlias();
        //
        final String ldapDatastore = config.getLdapDatastore();
        if (StringUtils.isNotBlank(ldapDatastore)) {
            LOG.info("LdapDatastore: " + ldapDatastore);
            DataSourceAccessor dataSourceAccessor = new DataSourceAccessor();
            LdapInfo ldapInfo = dataSourceAccessor.getLdapInfo(ldapDatastore);
            final String url = ldapInfo.getServerUrl();
            final String userDn = ldapInfo.getPrincipal();
            final String password = ldapInfo.getCredentials();
            LOG.info("LdapInfo: " + url + ", " + userDn + ", " + password);
            //
            LdapContextSource ctx = new LdapContextSource();
            ctx.setPooled(true);
            ctx.setUrl(url);
            ctx.setUserDn(userDn);
            ctx.setPassword(password);
            ctx.afterPropertiesSet();
            LOG.info("LdapDatastore: " + ldapDatastore);
        }
    }

    public ValidateUsernameResponse validateUsername(String accessToken, String username) throws IOException {
        try (CloseableHttpClient httpClient = CloseableHttpClientBuilder.getInstance(this.keyStoreAlias);) {
            final String uri = baseAddress + validateUsernamePath;
            LOG.info("validateUsername: " + uri);
            HttpPost request = new HttpPost(uri);
            request.addHeader(HttpHeaders.CONTENT_TYPE, ContentType.APPLICATION_JSON.getMimeType());
            request.addHeader(HttpHeaders.AUTHORIZATION, "Bearer " + accessToken);

            ObjectMapper mapper = new ObjectMapper();
            Map<String, Object> dto = new HashMap<>();
            dto.put(PcvConstants.USERNAME_ATTRIBUTE, username);
            String json = mapper.writeValueAsString(dto);
            LOG.info("Validate Username request: " + json);
            request.setEntity(new StringEntity(json));

            HttpResponse response = httpClient.execute(request);
            return parse(response, ValidateUsernameResponse.class);
        } catch (Exception e) {
            LOG.error("Error executing authentication request: " + e.getMessage(), e);
            throw e;
        }
    }

    public SendOtpResponse sendOtp(String accessToken, String username) throws IOException {
        try (CloseableHttpClient httpClient = CloseableHttpClientBuilder.getInstance(this.keyStoreAlias);) {
            final String uri = baseAddress + sendOtpPath;
            LOG.info("sendOtp url: " + uri);
            HttpPost request = new HttpPost(uri);
            request.addHeader(HttpHeaders.CONTENT_TYPE, ContentType.APPLICATION_JSON.getMimeType());
            request.addHeader(HttpHeaders.AUTHORIZATION, "Bearer " + accessToken);

            ObjectMapper mapper = new ObjectMapper();
            Map<String, Object> dto = new HashMap<>();
            dto.put(PcvConstants.USERNAME_ATTRIBUTE, username);
            String json = mapper.writeValueAsString(dto);
            LOG.info("sendOtp request: " + json);
            request.setEntity(new StringEntity(json));

            HttpResponse response = httpClient.execute(request);
            return parse(response, SendOtpResponse.class);
        } catch (IOException e) {
            LOG.error("Error executing authentication request: " + e.getMessage(), e);
            throw e;
        }
    }

    public ValidateOtpResponse validateOtp(String accessToken,
        String username, String otp, Long otpDataId) throws IOException {
        try (CloseableHttpClient httpClient = CloseableHttpClientBuilder.getInstance(this.keyStoreAlias);) {
            final String uri = baseAddress + validateOtpPath;
            LOG.info("validateOtp: " + uri);
            HttpPost request = new HttpPost(uri);
            request.addHeader(HttpHeaders.CONTENT_TYPE, ContentType.APPLICATION_JSON.getMimeType());
            if (accessToken != null) {
                request.addHeader(HttpHeaders.AUTHORIZATION, "Bearer " + accessToken);
            }

            final ObjectMapper mapper = new ObjectMapper();
            Map<String, Object> dto = new HashMap<>();
            dto.put(PcvConstants.USERNAME_ATTRIBUTE, username);
            dto.put(JSON_KEY_OTP, otp);
            dto.put(JSON_KEY_OTP_DATA_ID, otpDataId);
            String json = mapper.writeValueAsString(dto);
            LOG.info("Validate OTP request: " + json);
            request.setEntity(new StringEntity(json));

            HttpResponse response = httpClient.execute(request);
            return parse(response, ValidateOtpResponse.class);
        } catch (Exception e) {
            LOG.error("Error executing authentication request: " + e.getMessage(), e);
            throw e;
        }
    }

    private <T extends AbstractResponse> T parse(HttpResponse response, Class<T> clazz) throws IOException {
        final ObjectMapper mapper = new ObjectMapper();
        final int statusCode = response.getStatusLine().getStatusCode();
        final String content = EntityUtils.toString(response.getEntity());
        LOG.info("[" + statusCode + "] parsing content:\n" + content);
        final T result = mapper.readValue(content, clazz);
        if (statusCode == HttpStatus.SC_OK) {
            return result;
        }
        result.setStatusCode(statusCode); // 4XX, 5XX
        LOG.warn("statusCode={}, errorCode={}", result.getStatusCode(), result.getErrorCode());
        return result;
    }

}

