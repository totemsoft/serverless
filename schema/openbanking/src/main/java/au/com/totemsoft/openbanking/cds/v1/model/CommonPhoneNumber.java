package au.com.totemsoft.openbanking.cds.v1.model;

import java.util.Objects;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import io.swagger.annotations.ApiModelProperty;

/**
 * CommonPhoneNumber
 */

public class CommonPhoneNumber   {
  @JsonProperty("isPreferred")
  private Boolean isPreferred;

  /**
   * The purpose of the number as specified by the customer
   */
  public enum PurposeEnum {
    MOBILE("MOBILE"),
    
    HOME("HOME"),
    
    WORK("WORK"),
    
    OTHER("OTHER"),
    
    INTERNATIONAL("INTERNATIONAL"),
    
    UNSPECIFIED("UNSPECIFIED");

    private String value;

    PurposeEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static PurposeEnum fromValue(String value) {
      for (PurposeEnum b : PurposeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  @JsonProperty("purpose")
  private PurposeEnum purpose;

  @JsonProperty("countryCode")
  private String countryCode;

  @JsonProperty("areaCode")
  private String areaCode;

  @JsonProperty("number")
  private String number;

  @JsonProperty("extension")
  private String extension;

  @JsonProperty("fullNumber")
  private String fullNumber;

  public CommonPhoneNumber isPreferred(Boolean isPreferred) {
    this.isPreferred = isPreferred;
    return this;
  }

  /**
   * May be true for one and only one entry to indicate the preferred phone number. Assumed to be 'false' if not present
   * @return isPreferred
  */
  @ApiModelProperty(value = "May be true for one and only one entry to indicate the preferred phone number. Assumed to be 'false' if not present")


  public Boolean getIsPreferred() {
    return isPreferred;
  }

  public void setIsPreferred(Boolean isPreferred) {
    this.isPreferred = isPreferred;
  }

  public CommonPhoneNumber purpose(PurposeEnum purpose) {
    this.purpose = purpose;
    return this;
  }

  /**
   * The purpose of the number as specified by the customer
   * @return purpose
  */
  @ApiModelProperty(required = true, value = "The purpose of the number as specified by the customer")
  @NotNull


  public PurposeEnum getPurpose() {
    return purpose;
  }

  public void setPurpose(PurposeEnum purpose) {
    this.purpose = purpose;
  }

  public CommonPhoneNumber countryCode(String countryCode) {
    this.countryCode = countryCode;
    return this;
  }

  /**
   * If absent, assumed to be Australia (+61). The + should be included
   * @return countryCode
  */
  @ApiModelProperty(value = "If absent, assumed to be Australia (+61). The + should be included")


  public String getCountryCode() {
    return countryCode;
  }

  public void setCountryCode(String countryCode) {
    this.countryCode = countryCode;
  }

  public CommonPhoneNumber areaCode(String areaCode) {
    this.areaCode = areaCode;
    return this;
  }

  /**
   * Required for non Mobile Phones, if field is present and refers to Australian code - the leading 0 should be omitted.
   * @return areaCode
  */
  @ApiModelProperty(value = "Required for non Mobile Phones, if field is present and refers to Australian code - the leading 0 should be omitted.")


  public String getAreaCode() {
    return areaCode;
  }

  public void setAreaCode(String areaCode) {
    this.areaCode = areaCode;
  }

  public CommonPhoneNumber number(String number) {
    this.number = number;
    return this;
  }

  /**
   * The actual phone number, with leading zeros as appropriate
   * @return number
  */
  @ApiModelProperty(required = true, value = "The actual phone number, with leading zeros as appropriate")
  @NotNull


  public String getNumber() {
    return number;
  }

  public void setNumber(String number) {
    this.number = number;
  }

  public CommonPhoneNumber extension(String extension) {
    this.extension = extension;
    return this;
  }

  /**
   * An extension number (if applicable)
   * @return extension
  */
  @ApiModelProperty(value = "An extension number (if applicable)")


  public String getExtension() {
    return extension;
  }

  public void setExtension(String extension) {
    this.extension = extension;
  }

  public CommonPhoneNumber fullNumber(String fullNumber) {
    this.fullNumber = fullNumber;
    return this;
  }

  /**
   * Fully formatted phone number with country code, area code, number and extension incorporated. Formatted according to section 5.1.4. of [RFC 3966](https://www.ietf.org/rfc/rfc3966.txt)
   * @return fullNumber
  */
  @ApiModelProperty(required = true, value = "Fully formatted phone number with country code, area code, number and extension incorporated. Formatted according to section 5.1.4. of [RFC 3966](https://www.ietf.org/rfc/rfc3966.txt)")
  @NotNull


  public String getFullNumber() {
    return fullNumber;
  }

  public void setFullNumber(String fullNumber) {
    this.fullNumber = fullNumber;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CommonPhoneNumber commonPhoneNumber = (CommonPhoneNumber) o;
    return Objects.equals(this.isPreferred, commonPhoneNumber.isPreferred) &&
        Objects.equals(this.purpose, commonPhoneNumber.purpose) &&
        Objects.equals(this.countryCode, commonPhoneNumber.countryCode) &&
        Objects.equals(this.areaCode, commonPhoneNumber.areaCode) &&
        Objects.equals(this.number, commonPhoneNumber.number) &&
        Objects.equals(this.extension, commonPhoneNumber.extension) &&
        Objects.equals(this.fullNumber, commonPhoneNumber.fullNumber);
  }

  @Override
  public int hashCode() {
    return Objects.hash(isPreferred, purpose, countryCode, areaCode, number, extension, fullNumber);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CommonPhoneNumber {\n");
    
    sb.append("    isPreferred: ").append(toIndentedString(isPreferred)).append("\n");
    sb.append("    purpose: ").append(toIndentedString(purpose)).append("\n");
    sb.append("    countryCode: ").append(toIndentedString(countryCode)).append("\n");
    sb.append("    areaCode: ").append(toIndentedString(areaCode)).append("\n");
    sb.append("    number: ").append(toIndentedString(number)).append("\n");
    sb.append("    extension: ").append(toIndentedString(extension)).append("\n");
    sb.append("    fullNumber: ").append(toIndentedString(fullNumber)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

