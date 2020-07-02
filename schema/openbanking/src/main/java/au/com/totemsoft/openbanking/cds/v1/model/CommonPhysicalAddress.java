package au.com.totemsoft.openbanking.cds.v1.model;

import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import io.swagger.annotations.ApiModelProperty;

/**
 * CommonPhysicalAddress
 */

public class CommonPhysicalAddress   {
  /**
   * The type of address object present
   */
  public enum AddressUTypeEnum {
    SIMPLE("simple"),
    
    PAF("paf");

    private String value;

    AddressUTypeEnum(String value) {
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
    public static AddressUTypeEnum fromValue(String value) {
      for (AddressUTypeEnum b : AddressUTypeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  @JsonProperty("addressUType")
  private AddressUTypeEnum addressUType;

  @JsonProperty("simple")
  private CommonSimpleAddress simple;

  @JsonProperty("paf")
  private CommonPAFAddress paf;

  public CommonPhysicalAddress addressUType(AddressUTypeEnum addressUType) {
    this.addressUType = addressUType;
    return this;
  }

  /**
   * The type of address object present
   * @return addressUType
  */
  @ApiModelProperty(required = true, value = "The type of address object present")
  @NotNull


  public AddressUTypeEnum getAddressUType() {
    return addressUType;
  }

  public void setAddressUType(AddressUTypeEnum addressUType) {
    this.addressUType = addressUType;
  }

  public CommonPhysicalAddress simple(CommonSimpleAddress simple) {
    this.simple = simple;
    return this;
  }

  /**
   * Get simple
   * @return simple
  */
  @ApiModelProperty(value = "")

  @Valid

  public CommonSimpleAddress getSimple() {
    return simple;
  }

  public void setSimple(CommonSimpleAddress simple) {
    this.simple = simple;
  }

  public CommonPhysicalAddress paf(CommonPAFAddress paf) {
    this.paf = paf;
    return this;
  }

  /**
   * Get paf
   * @return paf
  */
  @ApiModelProperty(value = "")

  @Valid

  public CommonPAFAddress getPaf() {
    return paf;
  }

  public void setPaf(CommonPAFAddress paf) {
    this.paf = paf;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CommonPhysicalAddress commonPhysicalAddress = (CommonPhysicalAddress) o;
    return Objects.equals(this.addressUType, commonPhysicalAddress.addressUType) &&
        Objects.equals(this.simple, commonPhysicalAddress.simple) &&
        Objects.equals(this.paf, commonPhysicalAddress.paf);
  }

  @Override
  public int hashCode() {
    return Objects.hash(addressUType, simple, paf);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CommonPhysicalAddress {\n");
    
    sb.append("    addressUType: ").append(toIndentedString(addressUType)).append("\n");
    sb.append("    simple: ").append(toIndentedString(simple)).append("\n");
    sb.append("    paf: ").append(toIndentedString(paf)).append("\n");
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

