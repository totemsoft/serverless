package au.com.totemsoft.openbanking.cds.v1.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * ResponseBankingTransactionListData
 */

public class ResponseBankingTransactionListData   {
  @JsonProperty("transactions")
  @Valid
  private List<BankingTransaction> transactions = new ArrayList<>();

  public ResponseBankingTransactionListData transactions(List<BankingTransaction> transactions) {
    this.transactions = transactions;
    return this;
  }

  public ResponseBankingTransactionListData addTransactionsItem(BankingTransaction transactionsItem) {
    this.transactions.add(transactionsItem);
    return this;
  }

  /**
   * Get transactions
   * @return transactions
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid

  public List<BankingTransaction> getTransactions() {
    return transactions;
  }

  public void setTransactions(List<BankingTransaction> transactions) {
    this.transactions = transactions;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ResponseBankingTransactionListData responseBankingTransactionListData = (ResponseBankingTransactionListData) o;
    return Objects.equals(this.transactions, responseBankingTransactionListData.transactions);
  }

  @Override
  public int hashCode() {
    return Objects.hash(transactions);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ResponseBankingTransactionListData {\n");
    
    sb.append("    transactions: ").append(toIndentedString(transactions)).append("\n");
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

