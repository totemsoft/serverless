package au.com.totemsoft.ping.idp;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.sourceid.saml20.adapter.conf.Configuration;

import com.pingidentity.sdk.GuiConfigDescriptor;
import com.pingidentity.sdk.PluginDescriptor;
import com.pingidentity.sdk.password.PasswordCredentialValidator;

import au.com.totemsoft.ping.UserService;
import au.com.totemsoft.ping.sdk.PluginConfiguration;

/**
 * A password credential validator containing a single username and password pair.
 */
public abstract class AbstractPcv implements PasswordCredentialValidator {

    protected final Logger log = LogManager.getLogger(getClass());

    protected PluginConfiguration config;

    public void setConfig(PluginConfiguration config) {
        this.config = config;
    }

    protected UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public AbstractPcv(GuiConfigDescriptor guiDescriptor, String type) {
        this.config = new PluginConfiguration(guiDescriptor, type);
    }

    //@Override
    public void configure(Configuration configuration) {
        config.configure(configuration);
        // adapter submit rest api
        if (this.userService == null) {
            this.userService = new UserService(config);
        }
        // adapter handlers
        registerHandlers(config);
    }

    protected void registerHandlers(PluginConfiguration config) {
        // do nothing by default
    }

    //@Override
    public PluginDescriptor getPluginDescriptor() {
        return config.getPluginDescriptor();
    }

}
