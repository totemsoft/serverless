package au.com.totemsoft.ping.idp;

import org.sourceid.saml20.adapter.attribute.AttributeValue;
import org.sourceid.util.log.AttributeMap;
import org.sourceid.websso.servlet.adapter.HandlerRegistry;

import com.pingidentity.sdk.GuiConfigDescriptor;
import com.pingidentity.sdk.password.PasswordCredentialValidatorAuthnException;
import com.pingidentity.sdk.password.PasswordValidationException;

import lombok.Generated;

import au.com.totemsoft.ping.PcvConstants;
import au.com.totemsoft.ping.domain.ValidateUsernameResponse;
import au.com.totemsoft.ping.idp.handler.UsernameHandler;
import au.com.totemsoft.ping.sdk.PluginConfiguration;

/**
 * A password credential validator containing a single username and password pair.
 */
public class UsernamePcv extends AbstractPcv {

    public static final String TYPE = "UsernamePcv";

    public UsernamePcv() {
        super(new GuiConfigDescriptor(TYPE), TYPE);
    }

    @Override
    protected void registerHandlers(PluginConfiguration config) {
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
    @Generated
    @Override
    public AttributeMap processPasswordCredential(String username, String clientId) throws PasswordValidationException {
        log.info("Received Username validation request for username: " + username + ", clientId: " + clientId);
        try {
            final ValidateUsernameResponse response = userService.validateUsername(
                config.accessToken(username, clientId), username);
            //
            final Integer errorCode = response.getErrorCode();
            if (errorCode != null) {
                log.warn("Username validation failed: " + username + ", with error code: " + errorCode);
                throw new PasswordCredentialValidatorAuthnException(true, PcvConstants.BUSINESS_ERROR.toString());
            }
            //
            log.info("User succesfully validated with username: " + username);
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
