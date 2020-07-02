package au.com.totemsoft.openbanking.cds.v1.model;

import java.util.Objects;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * BankingTransactionDetailAllOfExtendedDataX2p101Payload
 */

public class BankingTransactionDetailAllOfExtendedDataX2p101Payload   {
  @JsonProperty("extendedDescription")
  private String extendedDescription;

  @JsonProperty("endToEndId")
  private String endToEndId;

  @JsonProperty("purposeCode")
  private String purposeCode;

  public BankingTransactionDetailAllOfExtendedDataX2p101Payload extendedDescription(String extendedDescription) {
    this.extendedDescription = extendedDescription;
    return this;
  }

  /**
   * An extended string description. Only present if specified by the extensionUType field
   * @return extendedDescription
  */
  @ApiModelProperty(required = true, value = "An extended string description. Only present if specified by the extensionUType field")
  @NotNull


  public String getExtendedDescription() {
    return extendedDescription;
  }

  public void setExtendedDescription(String extendedDescription) {
    this.extendedDescription = extendedDescription;
  }

  public BankingTransactionDetailAllOfExtendedDataX2p101Payload endToEndId(String endToEndId) {
    this.endToEndId = endToEndId;
    return this;
  }

  /**
   * An end to end ID for the payment created at initiation
   * @return endToEndId
  */
  @ApiModelProperty(value = "An end to end ID for the payment created at initiation")


  public String getEndToEndId() {
    return endToEndId;
  }

  public void setEndToEndId(String endToEndId) {
    this.endToEndId = endToEndId;
  }

  public BankingTransactionDetailAllOfExtendedDataX2p101Payload purposeCode(String purposeCode) {
    this.purposeCode = purposeCode;
    return this;
  }

  /**
   * Purpose of the payment.  Format is defined by NPP standards for the x2p1.01 overlay service
   * @return purposeCode
  */
  @ApiModelProperty(value = "Purpose of the payment.  Format is defined by NPP standards for the x2p1.01 overlay service")


  public String getPurposeCode() {
    return purposeCode;
  }

  public void setPurposeCode(String purposeCode) {
    this.purposeCode = purposeCode;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BankingTransactionDetailAllOfExtendedDataX2p101Payload bankingTransactionDetailAllOfExtendedDataX2p101Payload = (BankingTransactionDetailAllOfExtendedDataX2p101Payload) o;
    return Objects.equals(this.extendedDescription, bankingTransactionDetailAllOfExtendedDataX2p101Payload.extendedDescription) &&
        Objects.equals(this.endToEndId, bankingTransactionDetailAllOfExtendedDataX2p101Payload.endToEndId) &&
        Objects.equals(this.purposeCode, bankingTransactionDetailAllOfExtendedDataX2p101Payload.purposeCode);
  }

  @Override
  public int hashCode() {
    return Objects.hash(extendedDescription, endToEndId, purposeCode);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BankingTransactionDetailAllOfExtendedDataX2p101Payload {\n");
    
    sb.append("    extendedDescription: ").append(toIndentedString(extendedDescription)).append("\n");
    sb.append("    endToEndId: ").append(toIndentedString(endToEndId)).append("\n");
    sb.append("    purposeCode: ").append(toIndentedString(purposeCode)).append("\n");
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

