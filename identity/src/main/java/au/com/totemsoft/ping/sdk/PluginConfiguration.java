package au.com.totemsoft.ping.sdk;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.sourceid.saml20.adapter.conf.Configuration;
import org.sourceid.saml20.adapter.gui.ClientCertKeypairFieldDescriptor;
import org.sourceid.saml20.adapter.gui.TextFieldDescriptor;
import org.sourceid.saml20.adapter.gui.validation.impl.RequiredFieldValidator;
import org.sourceid.saml20.adapter.gui.validation.impl.URLValidator;

import com.pingidentity.sdk.GuiConfigDescriptor;
import com.pingidentity.sdk.Plugin;
import com.pingidentity.sdk.PluginDescriptor;
import com.pingidentity.sdk.oauth20.AccessTokenIssuer;

import au.com.totemsoft.ping.PcvConstants;
import lombok.Getter;
import lombok.Setter;

/**
 * A password credential validator containing a single username and password pair.
 */
@Getter
public class PluginConfiguration implements Plugin, PcvConstants {

    private static final Logger LOG = LogManager.getLogger(PluginConfiguration.class);

    private Configuration configuration;

    private PluginDescriptor pluginDescriptor;

    // FORM_TEMPLATE_NAME
    private String formTemplateName;

    // SVC_URL
    private String baseAddress;

    // CLIENT_CERT
    private String keyStoreAlias;

    // CLIENT_ID (Dynamic Client Registration)
    // com.pingidentity.adapter.input.parameter.oauth.client.id=<OAuth Client Id>
    @Setter
    private String clientId;   // IN_PARAMETER_NAME_OAUTH_CLIENT_ID

    // com.pingidentity.adapter.input.parameter.application.name=<OAuth Client Name>
    @Setter
    private String clientName; // IN_PARAMETER_NAME_APPLICATION_NAME

    // ACCESS_TOKEN_MANAGER=<ATM>
    private String tokenManagerId;

    // SCOPE
    private String scope;

    // LDAP_DATA_STORE
    private String ldapDatastore;

    public PluginConfiguration() {
        super(); // required by PF SDK
    }

    public PluginConfiguration(GuiConfigDescriptor guiDescriptor, String type) {
        init(guiDescriptor);

        Set<String> contract = new HashSet<>();
        contract.add(USERNAME_ATTRIBUTE);
        contract.add(CLIENT_ID_ATTRIBUTE);

        // Create an plugin descriptor 
        this.pluginDescriptor = new PluginDescriptor(type, this, guiDescriptor);
        this.pluginDescriptor.setAttributeContractSet(contract);
        this.pluginDescriptor.setSupportsExtendedContract(true);
    }

    private void init(GuiConfigDescriptor guiDescriptor) {
        TextFieldDescriptor serviceDetails = new TextFieldDescriptor(SVC_URL, SVC_URL_DESC);
        serviceDetails.addValidator(new RequiredFieldValidator());
        serviceDetails.addValidator(new URLValidator(true));
        //serviceDetails.setDefaultValue("https://???/");
        guiDescriptor.addField(serviceDetails);

        ClientCertKeypairFieldDescriptor clientKey = new ClientCertKeypairFieldDescriptor(CLIENT_CERT, CLIENT_CERT_DESC);
        clientKey.addValidator(new RequiredFieldValidator());
        //clientKey.setDefaultValue("???");
        guiDescriptor.addField(clientKey);

        TextFieldDescriptor tokenManagerDetails = new TextFieldDescriptor(ACCESS_TOKEN_MANAGER, ACCESS_TOKEN_MANAGER_DESC);
        tokenManagerDetails.addValidator(new RequiredFieldValidator());
        //tokenManagerDetails.setDefaultValue("???");
        guiDescriptor.addField(tokenManagerDetails);

        TextFieldDescriptor scopeDetails = new TextFieldDescriptor(SCOPE, SCOPE_DESC);
        scopeDetails.addValidator(new RequiredFieldValidator());
        guiDescriptor.addField(scopeDetails);
    }

    /**
     * This method is called by the PingFederate server to push configuration
     * values entered by the administrator via the dynamically rendered GUI
     * configuration screen in the PingFederate administration console. Your
     * implementation should use the {@link Configuration} parameter to
     * configure its own internal state as needed. <br/>
     * <br/>
     * Each time the PingFederate server creates a new instance of your plugin
     * implementation this method will be invoked with the proper configuration.
     * All concurrency issues are handled in the server so you don't need to
     * worry about them here. The server doesn't allow access to your plugin
     * implementation instance until after creation and configuration is
     * completed.
     *
     * @param configuration
     *     the Configuration object constructed from the values entered by the user via the GUI.
     */
    @Override
    public void configure(Configuration configuration) {
        this.configuration = configuration;
        this.formTemplateName = configuration.getFieldValue(FORM_TEMPLATE_NAME);
        this.baseAddress = configuration.getFieldValue(SVC_URL);
        if (this.baseAddress != null && !this.baseAddress.endsWith("/")) {
            this.baseAddress += "/";
        }
        this.keyStoreAlias = configuration.getFieldValue(CLIENT_CERT);
        this.tokenManagerId = configuration.getFieldValue(ACCESS_TOKEN_MANAGER);
        this.scope = configuration.getFieldValue(SCOPE);
        //
        this.ldapDatastore = configuration.getFieldValue(LDAP_DATA_STORE);
        //
        LOG.info(
            String.format("baseAddress=%s, keyStoreAlias=%s, clientId=%s, tokenManagerId=%s, scope=%s, ldapDatastore=%s",
            baseAddress, keyStoreAlias, clientId, tokenManagerId, scope, ldapDatastore));
    }

    private String clientId(final String clientId) {
        if (StringUtils.isBlank(clientId)) {
            //LOG.info(">>> Using saved clientId: " + this.clientId);
            return this.clientId;
        }
        this.clientId = clientId;
        return this.clientId;
    }

    public String accessToken(String username, String clientId) {
        clientId = clientId(clientId);
        //
        Map<String, Object> attributes = new HashMap<>();
        final String sub = StringUtils.isNotBlank(username) ? username : "unknown";
        attributes.put("sub", sub);
        attributes.put("subject", sub);
        String accessToken = AccessTokenIssuer.issueToken(
            attributes,
            scope,
            clientId,
            tokenManagerId);
        LOG.info(String.format("[%s] scope=%s, clientId=%s, tokenManagerId=%s",
            username, scope, clientId, tokenManagerId));
        return accessToken;
    }

    public String dataRecipient(String accessToken) {
        // use JwtClaims subject (from accessToken)
        /*
        try {
            ClientStorageManager csm = new NoOpClientStorageManager();
            ClientData data = csm.getClient(this.clientId);
            return data.getName();
        } catch (Exception e) {
            LOG.error("dataRecipient: " + e.getMessage());
        }
        */
        return clientName != null ? clientName : clientId;
    }

}
