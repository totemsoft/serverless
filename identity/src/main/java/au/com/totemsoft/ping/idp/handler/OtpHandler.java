package au.com.totemsoft.ping.idp.handler;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import au.com.totemsoft.ping.UserService;
import au.com.totemsoft.ping.domain.CustomerRequest;
import au.com.totemsoft.ping.domain.OtpResponse;
import au.com.totemsoft.ping.domain.SendOtpResponse;
import au.com.totemsoft.ping.sdk.AbstractHandler;
import au.com.totemsoft.ping.sdk.PluginConfiguration;
import lombok.Generated;

@Generated
public class OtpHandler extends AbstractHandler<OtpResponse> {

    private UserService userService;

    public OtpHandler(PluginConfiguration config) {
        super(config);
        this.userService = new UserService(config);
    }

    @Override
    protected OtpResponse execute(CustomerRequest request,
        HttpServletRequest req, HttpServletResponse resp) throws IOException {
        final String username = request.getUsername();
        final String clientId = request.getClientId();
        final String accessToken = config.accessToken(username, clientId);
        SendOtpResponse response = userService.sendOtp(accessToken, username);
        log.info("sendOtp response: " + response);
        // otp screen data
        OtpResponse result = new OtpResponse();
        result.setDataRecipient(config.dataRecipient(accessToken));
        result.setStatusCode(response.getStatusCode());
        result.setErrorCode(response.getErrorCode());
        result.setMaskedMobileNumber(response.getMaskedMobileNumber());
        result.setNumberOfAttempts(response.getNumberOfAttempts());
        result.setExpiryDate(response.getExpiryDate());
        result.setOtpGens(response.getOtpGens());
        result.setOtpDataId(response.getOtpDataId());
        //
        return result;
    }

}
