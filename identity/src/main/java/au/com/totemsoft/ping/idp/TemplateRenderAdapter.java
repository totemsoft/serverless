package au.com.totemsoft.ping.idp;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.sourceid.saml20.adapter.AuthnAdapterException;
import org.sourceid.saml20.adapter.attribute.AttributeValue;
import org.sourceid.saml20.adapter.conf.Configuration;
import org.sourceid.saml20.adapter.gui.AdapterConfigurationGuiDescriptor;
import org.sourceid.saml20.adapter.gui.TextFieldDescriptor;
import org.sourceid.saml20.adapter.gui.validation.impl.RequiredFieldValidator;
import org.sourceid.saml20.adapter.idp.authn.AuthnPolicy;
import org.sourceid.saml20.adapter.idp.authn.IdpAuthnAdapterDescriptor;

import com.pingidentity.sdk.AuthnAdapterResponse;
import com.pingidentity.sdk.AuthnAdapterResponse.AUTHN_STATUS;
import com.pingidentity.sdk.IdpAuthenticationAdapterV2;
import com.pingidentity.sdk.api.authn.AuthnApiPlugin;
import com.pingidentity.sdk.api.authn.spec.PluginApiSpec;
import com.pingidentity.sdk.locale.LanguagePackMessages;
import com.pingidentity.sdk.locale.LocaleUtil;
import com.pingidentity.sdk.template.TemplateRendererUtil;
import com.pingidentity.sdk.template.TemplateRendererUtilException;

import au.com.totemsoft.ping.PcvConstants;
import au.com.totemsoft.ping.UserService;
import au.com.totemsoft.ping.idp.api.StateSpec;
import au.com.totemsoft.ping.idp.api.SubmitUserAttributes;
import au.com.totemsoft.ping.sdk.PluginConfiguration;

public class TemplateRenderAdapter implements IdpAuthenticationAdapterV2, AuthnApiPlugin, PcvConstants {

    private static final Logger LOG = LogManager.getLogger(TemplateRenderAdapter.class);

    public static final String TYPE = "" + TemplateRenderAdapter.class.getSimpleName();

    private static final String DESCRIPTION = "HTML Template Render Adapter";

    private PluginConfiguration config;

    private IdpAuthnAdapterDescriptor descriptor;

    private Set<String> extendedAttr;

    private UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public TemplateRenderAdapter() {
        final AdapterConfigurationGuiDescriptor guiDescriptor = new AdapterConfigurationGuiDescriptor(DESCRIPTION);
        this.config = new PluginConfiguration(this, TYPE, DESCRIPTION);

        // config field(s)
        this.config.getFields().forEach(f -> guiDescriptor.addField(f));

        // extra config field(s)
        TextFieldDescriptor formTemplate = new TextFieldDescriptor(FORM_TEMPLATE_NAME, FORM_TEMPLATE_NAME_DESC);
        formTemplate.addValidator(new RequiredFieldValidator());
        formTemplate.setDefaultValue("html.form.login.template.html");
        guiDescriptor.addField(formTemplate);
        //
        TextFieldDescriptor ldapDatastoreDetails = new TextFieldDescriptor(LDAP_DATA_STORE, LDAP_DATA_STORE_DESC);
        ldapDatastoreDetails.addValidator(new RequiredFieldValidator());
        ldapDatastoreDetails.setDefaultValue("DATASTORE_ID");
        guiDescriptor.addField(ldapDatastoreDetails);

        Set<String> contract = new HashSet<>();
        contract.add(USERNAME_ATTRIBUTE);

        // Create an Idp adapter descriptor 
        this.descriptor = new IdpAuthnAdapterDescriptor(this, TYPE, contract, true, guiDescriptor, false);
    }

    /**
     * This method is called by the PingFederate server to push configuration values entered by the administrator via
     * the dynamically rendered GUI configuration screen in the PingFederate administration console. Your implementation
     * should use the {@link Configuration} parameter to configure its own internal state as needed. The tables and
     * fields available in the Configuration object will correspond to the tables and fields defined on the
     * {@link org.sourceid.saml20.adapter.gui.AdapterConfigurationGuiDescriptor} on the AuthnAdapterDescriptor returned
     * by the {@link #getAdapterDescriptor()} method of this class.
     * Each time the PingFederate server creates a new instance of your adapter implementation this method will be
     * invoked with the proper configuration. All concurrency issues are handled in the server so you don't need to
     * worry about them here. The server doesn't allow access to your adapter implementation instance until after
     * creation and configuration is completed.
     *
     * @param configuration
     *            the Configuration object constructed from the values entered by the user via the GUI.
     */ 
    @Override
    public void configure(Configuration configuration) {
        config.configure(configuration);
        this.extendedAttr = configuration.getAdditionalAttrNames();
        // adapter submit rest api
        if (this.userService == null) {
            this.userService = new UserService(config);
        }
        // adapter handlers
        registerHandlers(config);
    }

    /**
     * Handlers, eg called on page render event.
     */
    protected void registerHandlers(PluginConfiguration config) {
        //
    }

    /**
     * The PingFederate server will invoke this method on your adapter implementation
     * to discover metadata about the implementation.
     * This included the adapter's attribute contract and a description of what configuration fields to
     * render in the GUI.
     *
     * @return an IdpAuthnAdapterDescriptor object that describes this IdP adapter implementation.
     */
    @Override
    public IdpAuthnAdapterDescriptor getAdapterDescriptor() {
        return this.descriptor;
    }

    /**
     * This method is used to retrieve information about the adapter (e.g. AuthnContext).
     *
     * @return a map
     */
    @Override
    public Map<String, Object> getAdapterInfo() {
        return null;
    }

    /**
     * This is an extended method that the PingFederate server will invoke during processing of a single sign-on
     * transaction to lookup information about an authenticated security context or session for a user at the external
     * application or authentication provider service.
     * In this example, the adapter simply saves the username and extended attribute values into a Map that is put into
     * its response.  It also calls a helper method to render the input form.
     * @param req
     *      the HttpServletRequest can be used to read cookies, parameters, headers, etc. It can also be used to
     *      find out more about the request like the full URL the request was made to. Accessing the HttpSession
     *      from the request is not recommended and doing so is deprecated. Use
     *      {@link org.sourceid.saml20.adapter.state.SessionStateSupport} as an alternative.
     * @param resp
     *      the HttpServletResponse. The response can be used to facilitate an asynchronous interaction. Sending a
     *      client side redirect or writing (and flushing) custom content to the response are two ways that an
     *      invocation of this method allows for the adapter to take control of the user agent. Note that if
     *      control of the user agent is taken in this way, then the agent must eventually be returned to the
     *      <code>resumePath</code> endpoint at the PingFederate server to complete the protocol transaction.
     * @param inParameters
     *      A map that contains a set of input parameters. The input parameters provided are detailed in
     *      {@link IdpAuthenticationAdapterV2}, prefixed with <code>IN_PARAMETER_NAME_*</code> i.e.
     *      {@link IdpAuthenticationAdapterV2#IN_PARAMETER_NAME_RESUME_PATH}.
     * @return {@link AuthnAdapterResponse} The return value should not be null.
     * @throws AuthnAdapterException
     *      for any unexpected runtime problem that the implementation cannot handle.
     * @throws IOException
     *      for any problem with I/O (typically any operation that writes to the HttpServletResponse).
     */
    @Override
    public AuthnAdapterResponse lookupAuthN(HttpServletRequest req, HttpServletResponse resp,
        Map<String, Object> inParameters)
        throws AuthnAdapterException, IOException {
        //
        config.setClientId((String) inParameters.get(IN_PARAMETER_NAME_OAUTH_CLIENT_ID));
        config.setClientName((String) inParameters.get(IN_PARAMETER_NAME_APPLICATION_NAME));
        //
        AuthnAdapterResponse authnAdapterResponse = new AuthnAdapterResponse();
        // Handle Submit
        if (isSubmitAttributesRequest(req)) {
            SubmitUserAttributes submitted = getSubmittedAttributes(req, inParameters);
            //
            final String adapter = (String) inParameters.get(IN_PARAMETER_NAME_INSTANCE_ID);
            LOG.info("Submit adapter: " + adapter);
            //
            Map<String, Object> attributeMap = new HashMap<>();
            attributeMap.put(USERNAME_ATTRIBUTE, submitted.getUsername());
            for (String key : extendedAttr) {
                attributeMap.put(key, submitted.getUserAttributes().get(key));
            }
            // Set the authn instant to the current time.
            attributeMap.put(AUTHN_INSTANT_ATTRIBUTE_NAME, System.currentTimeMillis());

            LOG.info("lookupAuthN Submit: " + inParameters + "\nattributeMap: " + attributeMap);
            authnAdapterResponse.setAttributeMap(attributeMap);
            authnAdapterResponse.setAuthnStatus(AUTHN_STATUS.SUCCESS);
            return authnAdapterResponse;
        }

        // Handle Cancel
        if (isCancelRequest(req)) {
            LOG.info("lookupAuthN Cancel: " + inParameters);
            authnAdapterResponse.setErrorMessage("User clicked Cancel");
            authnAdapterResponse.setAuthnStatus(AUTHN_STATUS.FAILURE);
            return authnAdapterResponse;
        }

        // Render the response
        LOG.info("lookupAuthN Render: " + inParameters);
        renderResponse(req, resp, inParameters);
        authnAdapterResponse.setAuthnStatus(AUTHN_STATUS.IN_PROGRESS);
        return authnAdapterResponse;
    }

    @SuppressWarnings("rawtypes")
    @Override
    public Map lookupAuthN(HttpServletRequest req, HttpServletResponse resp,
        String partnerSpEntityId, AuthnPolicy authnPolicy, String resumePath)
        throws AuthnAdapterException, IOException {
        throw new UnsupportedOperationException();
    }

    /**
     * Retrieve the submitted username and user attributes from the request.
     * This method handles both API requests and form submissions.
     *
     * @param req
     *      The servlet request.
     * @param inParameters
     *      A map that contains a set of input parameters. The input parameters provided are detailed in
     *      {@link IdpAuthenticationAdapterV2}, prefixed with <code>IN_PARAMETER_NAME_*</code> i.e.
     *      {@link IdpAuthenticationAdapterV2#IN_PARAMETER_NAME_RESUME_PATH}.
     * @return
     *      An object containing the submitted username and user attributes from the request.
     * @throws AuthnAdapterException
     *      If an unexpected error occurs while trying to retrieve fields from the request.
     */
    private SubmitUserAttributes getSubmittedAttributes(HttpServletRequest req, Map<String, Object> inParameters)
        throws AuthnAdapterException {
        SubmitUserAttributes result = new SubmitUserAttributes();
        //
        final String username;
        if (req.getParameter(USERNAME_ATTRIBUTE) != null) {
            username = req.getParameter(USERNAME_ATTRIBUTE);
        } else {
            @SuppressWarnings("unchecked")
            final Map<String, AttributeValue> chained = (Map<String, AttributeValue>)
                inParameters.get(IN_PARAMETER_NAME_CHAINED_ATTRIBUTES);
            if (chained.containsKey(USERNAME_ATTRIBUTE)) {
                username = chained.get(USERNAME_ATTRIBUTE).getValue();
                inParameters.put(IN_PARAMETER_NAME_USERID, username);
            } else {
                username = (String) inParameters.get(IN_PARAMETER_NAME_USERID);
            }
        }
        result.setUsername(username);
        //
        for (String key : extendedAttr) {
            result.getUserAttributes().put(key, req.getParameter(key));
        }
        //
        return result;
    }

    /**
     * Determine if the user chose "Submit".
     */
    private boolean isSubmitAttributesRequest(HttpServletRequest req) {
        return StringUtils.isNotBlank(req.getParameter("pf.ok"));
    }

    /**
     * Determine if the user chose "Cancel".
     */
    private boolean isCancelRequest(HttpServletRequest req) {
        return StringUtils.isNotBlank(req.getParameter("pf.cancel"));
    }

    /**
     * This is a helper method that renders the template form via {@link TemplateRendererUtil} class.
     * @param req
     *      the HttpServletRequest can be used to read cookies, parameters, headers, etc. It can also be used to
     *      find out more about the request like the full URL the request was made to. Accessing the HttpSession
     *      from the request is not recommended and doing so is deprecated. Use
     *      {@link org.sourceid.saml20.adapter.state.SessionStateSupport} as an alternative.
     * @param resp
     *      the HttpServletResponse. The response can be used to facilitate an asynchronous interaction.
     *      Sending a client side redirect or writing (and flushing) custom content to the response are two ways
     *      that an invocation of this method allows for the adapter to take control of the user agent.
     *      Note that if control of the user agent is taken in this way, then the agent must eventually be returned
     *      to the <code>resumePath</code> endpoint at the PingFederate server to complete the protocol transaction.
     * @param inParameters
     *      A map that contains a set of input parameters. The input parameters provided are detailed in
     *      {@link IdpAuthenticationAdapterV2}, prefixed with <code>IN_PARAMETER_NAME_*</code> i.e.
     *      {@link IdpAuthenticationAdapterV2#IN_PARAMETER_NAME_RESUME_PATH}.
     * @throws AuthnAdapterException
     *      for any unexpected runtime problem that the implementation cannot handle.
     */
    private void renderResponse(HttpServletRequest req, HttpServletResponse resp, Map<String, Object> inParameters)
        throws AuthnAdapterException {
        LOG.info("inParameters => " + inParameters);
        //LOG.info("extendedAttr => " + extendedAttr);
        //
        @SuppressWarnings("unchecked")
        final Map<String, AttributeValue> chained = (Map<String, AttributeValue>)
            inParameters.get(IN_PARAMETER_NAME_CHAINED_ATTRIBUTES);
        //LOG.info("chainedAttr => " + chained);
        //
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("extendedAttr", extendedAttr);
        //
        params.put("resumePath", inParameters.get(IN_PARAMETER_NAME_RESUME_PATH));
        params.put("url", inParameters.get(IN_PARAMETER_NAME_RESUME_PATH));
        //
        params.put("name", "pf.username");
        final String username;
        if (chained.containsKey(USERNAME_ATTRIBUTE)) {
            username = chained.get(USERNAME_ATTRIBUTE).getValue();
            inParameters.put(IN_PARAMETER_NAME_USERID, username);
        } else {
            username = (String) inParameters.get(IN_PARAMETER_NAME_USERID);
        }
        params.put(USERNAME_ATTRIBUTE, username);
        //
        //params.put("pass", "pf.pass");
        //
        params.put("ok", "pf.ok");
        params.put("cancel", "pf.cancel");
        //
        String adapterId = inParameters.get(IN_PARAMETER_NAME_INSTANCE_ID).toString();
        params.put("adapterIdField", "pf.adapterId");
        params.put("adapterId", adapterId);

        // Load attribute-form-template.properties file and store it in the map.
        // Note on internationalization, if a language properties file like attribute-from-template_fr.properties
        // is created then a corresponding PingFederate properties needs to also be created
        // (i.e. pingfederate-messages_fr.properties).
        Locale userLocale = LocaleUtil.getUserLocale(req);
        LanguagePackMessages lpm = new LanguagePackMessages("attribute-form-template", userLocale);
        params.put("pluginTemplateMessages", lpm);

        try {
            TemplateRendererUtil.render(req, resp, config.getFormTemplateName(), params);
        } catch (TemplateRendererUtilException e) {
            throw new AuthnAdapterException(e);
        }
    }

    /**
     * This is the method that the PingFederate server will invoke during processing of a single logout to terminate a
     * security context for a user at the external application or authentication provider service.
     * Here no extra action is needed to logout so simply return true.
     * @param authnIdentifiers
     *      the map of authentication identifiers originally returned to the PingFederate server by the
     *      {@link #lookupAuthN} method. This enables the adapter to associate a security context or session
     *      returned by lookupAuthN with the invocation of this logout method.
     * @param req
     *      the HttpServletRequest can be used to read cookies, parameters, headers, etc. It can also be used to
     *      find out more about the request like the full URL the request was made to.
     * @param resp
     *      the HttpServletResponse. The response can be used to facilitate an asynchronous interaction. Sending a
     *      client side redirect or writing (and flushing) custom content to the response are two ways that an
     *      invocation of this method allows for the adapter to take control of the user agent. Note that if
     *      control of the user agent is taken in this way, then the agent must eventually be returned to the
     *      <code>resumePath</code> endpoint at the PingFederate server to complete the protocol transaction.
     * @param resumePath
     *      the relative URL that the user agent needs to return to, if the implementation of this method
     *      invocation needs to operate asynchronously. If this method operates synchronously, this parameter can
     *      be ignored. The resumePath is the full path portion of the URL - everything after hostname and port.
     *      If the hostname, port, or protocol are needed, they can be derived using the HttpServletRequest.
     * @return a boolean indicating if the logout was successful.
     * @throws AuthnAdapterException
     *      for any unexpected runtime problem that the implementation cannot handle.
     * @throws IOException
     *      for any problem with I/O (typically any operation that writes to the HttpServletResponse will throw
     *      an IOException.
     */
    @SuppressWarnings("rawtypes")
    @Override
    public boolean logoutAuthN(Map authnIdentifiers, HttpServletRequest req, HttpServletResponse resp, String resumePath)
        throws AuthnAdapterException, IOException {
        return true;
    }

    /**
     * For an API-capable plugin, this method returns a description of the API supported by the plugin,
     * including each of the possible API states that it supports.
     * The result of this method is used by PingFederate in generating API documentation.
     * @return An object that describes the adapter's API.
     */
    @Override
    public PluginApiSpec getApiSpec() {
        return new PluginApiSpec(Arrays.asList(StateSpec.USER_ATTRIBUTES_REQUIRED));
    }

}
