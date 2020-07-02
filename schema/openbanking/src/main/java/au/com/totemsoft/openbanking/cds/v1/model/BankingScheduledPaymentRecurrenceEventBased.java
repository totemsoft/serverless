package au.com.totemsoft.openbanking.cds.v1.model;

import java.util.Objects;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Indicates that the schedule of payments is defined according to an external event that cannot be predetermined. Mandatory if recurrenceUType is set to eventBased
 */
@ApiModel(description = "Indicates that the schedule of payments is defined according to an external event that cannot be predetermined. Mandatory if recurrenceUType is set to eventBased")

public class BankingScheduledPaymentRecurrenceEventBased   {
  @JsonProperty("description")
  private String description;

  public BankingScheduledPaymentRecurrenceEventBased description(String description) {
    this.description = description;
    return this;
  }

  /**
   * Description of the event and conditions that will result in the payment. Expected to be formatted for display to a customer
   * @return description
  */
  @ApiModelProperty(required = true, value = "Description of the event and conditions that will result in the payment. Expected to be formatted for display to a customer")
  @NotNull


  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BankingScheduledPaymentRecurrenceEventBased bankingScheduledPaymentRecurrenceEventBased = (BankingScheduledPaymentRecurrenceEventBased) o;
    return Objects.equals(this.description, bankingScheduledPaymentRecurrenceEventBased.description);
  }

  @Override
  public int hashCode() {
    return Objects.hash(description);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BankingScheduledPaymentRecurrenceEventBased {\n");
    
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
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

