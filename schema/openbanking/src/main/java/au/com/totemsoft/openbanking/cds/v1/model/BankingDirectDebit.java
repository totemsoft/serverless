package au.com.totemsoft.openbanking.cds.v1.model;

import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * BankingDirectDebit
 */

public class BankingDirectDebit   {
  @JsonProperty("accountId")
  private String accountId;

  @JsonProperty("authorisedEntity")
  private BankingAuthorisedEntity authorisedEntity;

  @JsonProperty("lastDebitDateTime")
  private String lastDebitDateTime;

  @JsonProperty("lastDebitAmount")
  private String lastDebitAmount;

  public BankingDirectDebit accountId(String accountId) {
    this.accountId = accountId;
    return this;
  }

  /**
   * A unique ID of the account adhering to the standards for ID permanence.
   * @return accountId
  */
  @ApiModelProperty(required = true, value = "A unique ID of the account adhering to the standards for ID permanence.")
  @NotNull


  public String getAccountId() {
    return accountId;
  }

  public void setAccountId(String accountId) {
    this.accountId = accountId;
  }

  public BankingDirectDebit authorisedEntity(BankingAuthorisedEntity authorisedEntity) {
    this.authorisedEntity = authorisedEntity;
    return this;
  }

  /**
   * Get authorisedEntity
   * @return authorisedEntity
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid

  public BankingAuthorisedEntity getAuthorisedEntity() {
    return authorisedEntity;
  }

  public void setAuthorisedEntity(BankingAuthorisedEntity authorisedEntity) {
    this.authorisedEntity = authorisedEntity;
  }

  public BankingDirectDebit lastDebitDateTime(String lastDebitDateTime) {
    this.lastDebitDateTime = lastDebitDateTime;
    return this;
  }

  /**
   * The date and time of the last debit executed under this authorisation
   * @return lastDebitDateTime
  */
  @ApiModelProperty(value = "The date and time of the last debit executed under this authorisation")


  public String getLastDebitDateTime() {
    return lastDebitDateTime;
  }

  public void setLastDebitDateTime(String lastDebitDateTime) {
    this.lastDebitDateTime = lastDebitDateTime;
  }

  public BankingDirectDebit lastDebitAmount(String lastDebitAmount) {
    this.lastDebitAmount = lastDebitAmount;
    return this;
  }

  /**
   * The amount of the last debit executed under this authorisation
   * @return lastDebitAmount
  */
  @ApiModelProperty(value = "The amount of the last debit executed under this authorisation")


  public String getLastDebitAmount() {
    return lastDebitAmount;
  }

  public void setLastDebitAmount(String lastDebitAmount) {
    this.lastDebitAmount = lastDebitAmount;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BankingDirectDebit bankingDirectDebit = (BankingDirectDebit) o;
    return Objects.equals(this.accountId, bankingDirectDebit.accountId) &&
        Objects.equals(this.authorisedEntity, bankingDirectDebit.authorisedEntity) &&
        Objects.equals(this.lastDebitDateTime, bankingDirectDebit.lastDebitDateTime) &&
        Objects.equals(this.lastDebitAmount, bankingDirectDebit.lastDebitAmount);
  }

  @Override
  public int hashCode() {
    return Objects.hash(accountId, authorisedEntity, lastDebitDateTime, lastDebitAmount);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BankingDirectDebit {\n");
    
    sb.append("    accountId: ").append(toIndentedString(accountId)).append("\n");
    sb.append("    authorisedEntity: ").append(toIndentedString(authorisedEntity)).append("\n");
    sb.append("    lastDebitDateTime: ").append(toIndentedString(lastDebitDateTime)).append("\n");
    sb.append("    lastDebitAmount: ").append(toIndentedString(lastDebitAmount)).append("\n");
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

