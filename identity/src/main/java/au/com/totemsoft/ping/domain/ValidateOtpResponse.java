package au.com.totemsoft.ping.domain;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Generated;
import lombok.Getter;
import lombok.Setter;

@Generated
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ValidateOtpResponse extends AbstractResponse {

    private int numberOfAttempts;

}
