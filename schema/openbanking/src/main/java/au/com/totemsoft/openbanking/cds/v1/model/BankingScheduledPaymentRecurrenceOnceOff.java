package au.com.totemsoft.openbanking.cds.v1.model;

import java.util.Objects;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Indicates that the payment is a once off payment on a specific future date. Mandatory if recurrenceUType is set to onceOff
 */
@ApiModel(description = "Indicates that the payment is a once off payment on a specific future date. Mandatory if recurrenceUType is set to onceOff")

public class BankingScheduledPaymentRecurrenceOnceOff   {
  @JsonProperty("paymentDate")
  private String paymentDate;

  public BankingScheduledPaymentRecurrenceOnceOff paymentDate(String paymentDate) {
    this.paymentDate = paymentDate;
    return this;
  }

  /**
   * The scheduled date for the once off payment
   * @return paymentDate
  */
  @ApiModelProperty(required = true, value = "The scheduled date for the once off payment")
  @NotNull


  public String getPaymentDate() {
    return paymentDate;
  }

  public void setPaymentDate(String paymentDate) {
    this.paymentDate = paymentDate;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BankingScheduledPaymentRecurrenceOnceOff bankingScheduledPaymentRecurrenceOnceOff = (BankingScheduledPaymentRecurrenceOnceOff) o;
    return Objects.equals(this.paymentDate, bankingScheduledPaymentRecurrenceOnceOff.paymentDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(paymentDate);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BankingScheduledPaymentRecurrenceOnceOff {\n");
    
    sb.append("    paymentDate: ").append(toIndentedString(paymentDate)).append("\n");
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

