package au.com.totemsoft.openbanking.cds.v1.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * ResponseBankingAccountsBalanceListData
 */

public class ResponseBankingAccountsBalanceListData   {
  @JsonProperty("balances")
  @Valid
  private List<BankingBalance> balances = new ArrayList<>();

  public ResponseBankingAccountsBalanceListData balances(List<BankingBalance> balances) {
    this.balances = balances;
    return this;
  }

  public ResponseBankingAccountsBalanceListData addBalancesItem(BankingBalance balancesItem) {
    this.balances.add(balancesItem);
    return this;
  }

  /**
   * The list of balances returned
   * @return balances
  */
  @ApiModelProperty(required = true, value = "The list of balances returned")
  @NotNull

  @Valid

  public List<BankingBalance> getBalances() {
    return balances;
  }

  public void setBalances(List<BankingBalance> balances) {
    this.balances = balances;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ResponseBankingAccountsBalanceListData responseBankingAccountsBalanceListData = (ResponseBankingAccountsBalanceListData) o;
    return Objects.equals(this.balances, responseBankingAccountsBalanceListData.balances);
  }

  @Override
  public int hashCode() {
    return Objects.hash(balances);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ResponseBankingAccountsBalanceListData {\n");
    
    sb.append("    balances: ").append(toIndentedString(balances)).append("\n");
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

