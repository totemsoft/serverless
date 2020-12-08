package au.com.totemsoft.ping.domain;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import au.com.totemsoft.ping.databind.LocalDateTimeDeserializer;
import au.com.totemsoft.ping.databind.LocalDateTimeSerializer;
import lombok.Generated;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Generated
@Getter
@Setter
@ToString(callSuper = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class OtpResponse extends AbstractResponse {

    private String maskedMobileNumber;

    private Integer numberOfAttempts;

    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime expiryDate;

    private Integer otpGens;

    private Long otpDataId;

}
