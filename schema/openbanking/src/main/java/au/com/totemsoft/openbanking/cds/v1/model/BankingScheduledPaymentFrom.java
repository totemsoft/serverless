package au.com.totemsoft.openbanking.cds.v1.model;

import java.util.Objects;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Object containing details of the source of the payment. Currently only specifies an account ID but provided as an object to facilitate future extensibility and consistency with the to object
 */
@ApiModel(description = "Object containing details of the source of the payment. Currently only specifies an account ID but provided as an object to facilitate future extensibility and consistency with the to object")

public class BankingScheduledPaymentFrom   {
  @JsonProperty("accountId")
  private String accountId;

  public BankingScheduledPaymentFrom accountId(String accountId) {
    this.accountId = accountId;
    return this;
  }

  /**
   * ID of the account that is the source of funds for the payment
   * @return accountId
  */
  @ApiModelProperty(required = true, value = "ID of the account that is the source of funds for the payment")
  @NotNull


  public String getAccountId() {
    return accountId;
  }

  public void setAccountId(String accountId) {
    this.accountId = accountId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BankingScheduledPaymentFrom bankingScheduledPaymentFrom = (BankingScheduledPaymentFrom) o;
    return Objects.equals(this.accountId, bankingScheduledPaymentFrom.accountId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(accountId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BankingScheduledPaymentFrom {\n");
    
    sb.append("    accountId: ").append(toIndentedString(accountId)).append("\n");
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

