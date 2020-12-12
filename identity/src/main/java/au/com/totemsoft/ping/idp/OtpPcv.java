package au.com.totemsoft.ping.idp;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.sourceid.saml20.adapter.attribute.AttributeValue;
import org.sourceid.saml20.adapter.conf.Configuration;
import org.sourceid.util.log.AttributeMap;
import org.sourceid.websso.servlet.adapter.HandlerRegistry;

import com.pingidentity.sdk.PluginDescriptor;
import com.pingidentity.sdk.password.PasswordCredentialValidator;
import com.pingidentity.sdk.password.PasswordCredentialValidatorAuthnException;
import com.pingidentity.sdk.password.PasswordValidationException;

import au.com.totemsoft.ping.PcvConstants;
import au.com.totemsoft.ping.UserService;
import au.com.totemsoft.ping.domain.ValidateOtpResponse;
import au.com.totemsoft.ping.idp.handler.OtpHandler;
import au.com.totemsoft.ping.sdk.PluginConfiguration;

/**
 * A password credential validator containing a single username and password pair.
 */
public class OtpPcv implements PasswordCredentialValidator {

    private static final Logger LOG = LogManager.getLogger(OtpPcv.class);

    public static final String TYPE = "OtpPcv";

    private static final String DESCRIPTION = "OTP PasswordCredentialValidator";

    private PluginConfiguration config;

    private UserService userService;

    public OtpPcv() {
        this.config = new PluginConfiguration(this, TYPE, DESCRIPTION);
    }

    @Override
    public void configure(Configuration configuration) {
        config.configure(configuration);
        // adapter submit rest api
        if (this.userService == null) {
            this.userService = new UserService(config);
        }
        // adapter handlers
        registerHandlers(config);
    }

    @Override
    public PluginDescriptor getPluginDescriptor() {
        return config.getPluginDescriptor();
    }

    private void registerHandlers(PluginConfiguration config) {
        HandlerRegistry.registerHandler("/identity/otp", new OtpHandler(config));
    }

    /**
     * Validates the given username and password.
     *
     * @param username - username
     * @param password - password
     * @return An AttributeMap with at least one entry representing the
     *     principal. The key of the entry does not matter, so long as the
     *     map is not empty. If the map is empty or null, the username and
     *     password combination is considered invalid.
     * @throws PasswordValidationException
     *     runtime exception when the validator cannot process the
     *     username and password combination due to system failure such
     *     as data source off line, host name unreachable, etc.
     */
    @Override
    public AttributeMap processPasswordCredential(String username, String password) throws PasswordValidationException {
        LOG.info("Received OTP authentication request for username: " + username);
        try {
            final String[] values = password.split("\\|");
            final String otp = values[0];
            final Long otpDataId = values.length > 1 ? Long.valueOf(values[1]) : null;
            final String clientId = values.length > 2 ? values[2] : null;
            final ValidateOtpResponse response = userService.validateOtp(
                config.accessToken(username, clientId),
                username, otp, otpDataId);
            //
            final Integer errorCode = response.getErrorCode();
            if (errorCode != null) {
                LOG.warn("OTP authentication failed: " + username + ", with error code: " + errorCode);
                throw new PasswordCredentialValidatorAuthnException(true, PcvConstants.BUSINESS_ERROR.toString());
            }
            //
            LOG.info("User succesfully authenticated with username: " + username);
            AttributeMap attributeMap = new AttributeMap();
            attributeMap.put(PcvConstants.USERNAME_ATTRIBUTE, new AttributeValue(username));
            // If authentication failed - returns null (an empty map is also OK)
            return attributeMap;
        } catch (PasswordCredentialValidatorAuthnException e) {
            throw e;
        } catch (Exception e) {
            throw new PasswordValidationException("Unhandled error encountered: " + e.getMessage(), e);
        }
    }

}
