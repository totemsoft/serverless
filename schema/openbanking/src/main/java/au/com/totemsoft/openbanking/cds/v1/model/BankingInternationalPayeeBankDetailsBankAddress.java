package au.com.totemsoft.openbanking.cds.v1.model;

import java.util.Objects;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * BankingInternationalPayeeBankDetailsBankAddress
 */

public class BankingInternationalPayeeBankDetailsBankAddress   {
  @JsonProperty("name")
  private String name;

  @JsonProperty("address")
  private String address;

  public BankingInternationalPayeeBankDetailsBankAddress name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Name of the recipient Bank
   * @return name
  */
  @ApiModelProperty(required = true, value = "Name of the recipient Bank")
  @NotNull


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public BankingInternationalPayeeBankDetailsBankAddress address(String address) {
    this.address = address;
    return this;
  }

  /**
   * Address of the recipient Bank
   * @return address
  */
  @ApiModelProperty(required = true, value = "Address of the recipient Bank")
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
    BankingInternationalPayeeBankDetailsBankAddress bankingInternationalPayeeBankDetailsBankAddress = (BankingInternationalPayeeBankDetailsBankAddress) o;
    return Objects.equals(this.name, bankingInternationalPayeeBankDetailsBankAddress.name) &&
        Objects.equals(this.address, bankingInternationalPayeeBankDetailsBankAddress.address);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, address);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BankingInternationalPayeeBankDetailsBankAddress {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
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

