package au.com.totemsoft.ping.idp.handler;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.Generated;
import au.com.totemsoft.ping.domain.UsernameResponse;
import au.com.totemsoft.ping.domain.CustomerRequest;
import au.com.totemsoft.ping.sdk.AbstractHandler;
import au.com.totemsoft.ping.sdk.PluginConfiguration;

@Generated
public class UsernameHandler extends AbstractHandler<UsernameResponse> {

    public UsernameHandler(PluginConfiguration config) {
        super(config);
    }

    @Override
    protected UsernameResponse execute(CustomerRequest request,
        HttpServletRequest req, HttpServletResponse resp) throws IOException {
        final String username = request.getUsername();
        final String clientId = request.getClientId();
        final String accessToken = config.accessToken(username, clientId);
        UsernameResponse result = new UsernameResponse();
        result.setDataRecipient(config.dataRecipient(accessToken));
        return result;
    }

}
