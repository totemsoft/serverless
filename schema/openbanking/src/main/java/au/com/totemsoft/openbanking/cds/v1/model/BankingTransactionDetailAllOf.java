package au.com.totemsoft.openbanking.cds.v1.model;

import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * BankingTransactionDetailAllOf
 */

public class BankingTransactionDetailAllOf   {
  @JsonProperty("extendedData")
  private BankingTransactionDetailAllOfExtendedData extendedData;

  public BankingTransactionDetailAllOf extendedData(BankingTransactionDetailAllOfExtendedData extendedData) {
    this.extendedData = extendedData;
    return this;
  }

  /**
   * Get extendedData
   * @return extendedData
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid

  public BankingTransactionDetailAllOfExtendedData getExtendedData() {
    return extendedData;
  }

  public void setExtendedData(BankingTransactionDetailAllOfExtendedData extendedData) {
    this.extendedData = extendedData;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BankingTransactionDetailAllOf bankingTransactionDetailAllOf = (BankingTransactionDetailAllOf) o;
    return Objects.equals(this.extendedData, bankingTransactionDetailAllOf.extendedData);
  }

  @Override
  public int hashCode() {
    return Objects.hash(extendedData);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BankingTransactionDetailAllOf {\n");
    
    sb.append("    extendedData: ").append(toIndentedString(extendedData)).append("\n");
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

