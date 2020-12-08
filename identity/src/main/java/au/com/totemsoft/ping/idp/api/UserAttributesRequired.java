package au.com.totemsoft.ping.idp.api;

import java.util.ArrayList;
import java.util.List;

import lombok.Generated;
import lombok.Getter;
import lombok.Setter;

/**
 * This is the model for the USER_ATTRIBUTES_REQUIRED state.
 * It defines the fields that are returned to the API client in a GET response for this state.
 */
@Generated
@Getter
@Setter
public class UserAttributesRequired {

    private List<String> attributeNames = new ArrayList<>();

}
