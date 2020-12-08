package au.com.totemsoft.ping.idp.api;

import java.util.HashMap;
import java.util.Map;

import lombok.Generated;
import lombok.Getter;
import lombok.Setter;

/**
 * This is the model for the submitUserAttributes API action.
 * It defines the fields that may be included in the POST body for this action.
 */
@Generated
@Getter
@Setter
public class SubmitUserAttributes {

    private String username;

    private Map<String, Object> userAttributes = new HashMap<>();

}
