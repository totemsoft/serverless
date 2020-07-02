package au.com.totemsoft.openbanking.cds.v1.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * ResponseBankingPayeeListData
 */

public class ResponseBankingPayeeListData   {
  @JsonProperty("payees")
  @Valid
  private List<BankingPayee> payees = new ArrayList<>();

  public ResponseBankingPayeeListData payees(List<BankingPayee> payees) {
    this.payees = payees;
    return this;
  }

  public ResponseBankingPayeeListData addPayeesItem(BankingPayee payeesItem) {
    this.payees.add(payeesItem);
    return this;
  }

  /**
   * The list of payees returned
   * @return payees
  */
  @ApiModelProperty(required = true, value = "The list of payees returned")
  @NotNull

  @Valid

  public List<BankingPayee> getPayees() {
    return payees;
  }

  public void setPayees(List<BankingPayee> payees) {
    this.payees = payees;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ResponseBankingPayeeListData responseBankingPayeeListData = (ResponseBankingPayeeListData) o;
    return Objects.equals(this.payees, responseBankingPayeeListData.payees);
  }

  @Override
  public int hashCode() {
    return Objects.hash(payees);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ResponseBankingPayeeListData {\n");
    
    sb.append("    payees: ").append(toIndentedString(payees)).append("\n");
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

