package au.com.totemsoft.ping.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Generated;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Generated
@Getter
@Setter
@ToString
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class CustomerRequest {

    @JsonProperty("clientId")
    private String clientId;

    @JsonProperty("username")
    private String username;

}
