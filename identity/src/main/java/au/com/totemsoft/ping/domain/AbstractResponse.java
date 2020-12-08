package au.com.totemsoft.ping.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Generated;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Generated
@Getter
@Setter
@ToString
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public abstract class AbstractResponse {

    private String dataRecipient;

    private String scope;

    private String userId;

    private Integer statusCode;

    @JsonIgnore
    private Integer errorCode;

}
