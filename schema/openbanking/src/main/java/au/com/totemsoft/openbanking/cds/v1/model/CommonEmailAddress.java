package au.com.totemsoft.openbanking.cds.v1.model;

import java.util.Objects;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import io.swagger.annotations.ApiModelProperty;

/**
 * CommonEmailAddress
 */

public class CommonEmailAddress   {
  @JsonProperty("isPreferred")
  private Boolean isPreferred;

  /**
   * The purpose for the email, as specified by the customer (Enumeration)
   */
  public enum PurposeEnum {
    WORK("WORK"),
    
    HOME("HOME"),
    
    OTHER("OTHER"),
    
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

  @JsonProperty("address")
  private String address;

  public CommonEmailAddress isPreferred(Boolean isPreferred) {
    this.isPreferred = isPreferred;
    return this;
  }

  /**
   * May be true for one and only one email record in the collection. Denotes the default email address
   * @return isPreferred
  */
  @ApiModelProperty(value = "May be true for one and only one email record in the collection. Denotes the default email address")


  public Boolean getIsPreferred() {
    return isPreferred;
  }

  public void setIsPreferred(Boolean isPreferred) {
    this.isPreferred = isPreferred;
  }

  public CommonEmailAddress purpose(PurposeEnum purpose) {
    this.purpose = purpose;
    return this;
  }

  /**
   * The purpose for the email, as specified by the customer (Enumeration)
   * @return purpose
  */
  @ApiModelProperty(required = true, value = "The purpose for the email, as specified by the customer (Enumeration)")
  @NotNull


  public PurposeEnum getPurpose() {
    return purpose;
  }

  public void setPurpose(PurposeEnum purpose) {
    this.purpose = purpose;
  }

  public CommonEmailAddress address(String address) {
    this.address = address;
    return this;
  }

  /**
   * A correctly formatted email address, as defined by the addr_spec format in [RFC 5322](https://www.ietf.org/rfc/rfc5322.txt)
   * @return address
  */
  @ApiModelProperty(required = true, value = "A correctly formatted email address, as defined by the addr_spec format in [RFC 5322](https://www.ietf.org/rfc/rfc5322.txt)")
  @NotNull


  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CommonEmailAddress commonEmailAddress = (CommonEmailAddress) o;
    return Objects.equals(this.isPreferred, commonEmailAddress.isPreferred) &&
        Objects.equals(this.purpose, commonEmailAddress.purpose) &&
        Objects.equals(this.address, commonEmailAddress.address);
  }

  @Override
  public int hashCode() {
    return Objects.hash(isPreferred, purpose, address);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CommonEmailAddress {\n");
    
    sb.append("    isPreferred: ").append(toIndentedString(isPreferred)).append("\n");
    sb.append("    purpose: ").append(toIndentedString(purpose)).append("\n");
    sb.append("    address: ").append(toIndentedString(address)).append("\n");
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

