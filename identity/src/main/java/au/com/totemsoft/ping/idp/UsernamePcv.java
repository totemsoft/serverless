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
import au.com.totemsoft.ping.domain.ValidateUsernameResponse;
import au.com.totemsoft.ping.idp.handler.UsernameHandler;
import au.com.totemsoft.ping.sdk.PluginConfiguration;

/**
 * A password credential validator containing a single username and password pair.
 */
public class UsernamePcv implements PasswordCredentialValidator {

    private static final Logger LOG = LogManager.getLogger(UsernamePcv.class);

    public static final String TYPE = "UsernamePcv";

    private static final String DESCRIPTION = "Username PasswordCredentialValidator";

    private PluginConfiguration config;

    private UserService userService;

    public UsernamePcv() {
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
        HandlerRegistry.registerHandler("/identity/login", new UsernameHandler(config));
    }

    /**
     * Validates the given username and password.
     *
     * @param username - username
     * @param clientId - clientId
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
    public AttributeMap processPasswordCredential(String username, String clientId) throws PasswordValidationException {
        LOG.info("Received Username validation request for username: " + username + ", clientId: " + clientId);
        try {
            final ValidateUsernameResponse response = userService.validateUsername(
                config.accessToken(username, clientId), username);
            //
            final Integer errorCode = response.getErrorCode();
            if (errorCode != null) {
                LOG.warn("Username validation failed: " + username + ", with error code: " + errorCode);
                throw new PasswordCredentialValidatorAuthnException(true, PcvConstants.BUSINESS_ERROR.toString());
            }
            //
            LOG.info("User succesfully validated with username: " + username);
            AttributeMap attributeMap = new AttributeMap();
            attributeMap.put(PcvConstants.USERNAME_ATTRIBUTE, new AttributeValue(username));
            attributeMap.put(PcvConstants.CLIENT_ID_ATTRIBUTE, new AttributeValue(clientId));
            // If authentication failed - returns null (an empty map is also OK)
            return attributeMap;
        } catch (PasswordCredentialValidatorAuthnException e) {
            throw e;
        } catch (Exception e) {
            throw new PasswordValidationException(
                "Unhandled error encountered while processing credentials: " + e.getMessage(), e);
        }
    }

}
