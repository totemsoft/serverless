package au.com.totemsoft.openbanking.cds.v1.model;

import java.util.Objects;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import io.swagger.annotations.ApiModelProperty;

/**
 * BankingTermDepositAccount
 */

public class BankingTermDepositAccount   {
  @JsonProperty("lodgementDate")
  private String lodgementDate;

  @JsonProperty("maturityDate")
  private String maturityDate;

  @JsonProperty("maturityAmount")
  private String maturityAmount;

  @JsonProperty("maturityCurrency")
  private String maturityCurrency;

  /**
   * Current instructions on action to be taken at maturity
   */
  public enum MaturityInstructionsEnum {
    ROLLED_OVER("ROLLED_OVER"),
    
    PAID_OUT_AT_MATURITY("PAID_OUT_AT_MATURITY");

    private String value;

    MaturityInstructionsEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static MaturityInstructionsEnum fromValue(String value) {
      for (MaturityInstructionsEnum b : MaturityInstructionsEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  @JsonProperty("maturityInstructions")
  private MaturityInstructionsEnum maturityInstructions;

  public BankingTermDepositAccount lodgementDate(String lodgementDate) {
    this.lodgementDate = lodgementDate;
    return this;
  }

  /**
   * The lodgement date of the original deposit
   * @return lodgementDate
  */
  @ApiModelProperty(required = true, value = "The lodgement date of the original deposit")
  @NotNull


  public String getLodgementDate() {
    return lodgementDate;
  }

  public void setLodgementDate(String lodgementDate) {
    this.lodgementDate = lodgementDate;
  }

  public BankingTermDepositAccount maturityDate(String maturityDate) {
    this.maturityDate = maturityDate;
    return this;
  }

  /**
   * Maturity date for the term deposit
   * @return maturityDate
  */
  @ApiModelProperty(required = true, value = "Maturity date for the term deposit")
  @NotNull


  public String getMaturityDate() {
    return maturityDate;
  }

  public void setMaturityDate(String maturityDate) {
    this.maturityDate = maturityDate;
  }

  public BankingTermDepositAccount maturityAmount(String maturityAmount) {
    this.maturityAmount = maturityAmount;
    return this;
  }

  /**
   * Amount to be paid upon maturity. If absent it implies the amount to paid is variable and cannot currently be calculated
   * @return maturityAmount
  */
  @ApiModelProperty(value = "Amount to be paid upon maturity. If absent it implies the amount to paid is variable and cannot currently be calculated")


  public String getMaturityAmount() {
    return maturityAmount;
  }

  public void setMaturityAmount(String maturityAmount) {
    this.maturityAmount = maturityAmount;
  }

  public BankingTermDepositAccount maturityCurrency(String maturityCurrency) {
    this.maturityCurrency = maturityCurrency;
    return this;
  }

  /**
   * If absent assumes AUD
   * @return maturityCurrency
  */
  @ApiModelProperty(value = "If absent assumes AUD")


  public String getMaturityCurrency() {
    return maturityCurrency;
  }

  public void setMaturityCurrency(String maturityCurrency) {
    this.maturityCurrency = maturityCurrency;
  }

  public BankingTermDepositAccount maturityInstructions(MaturityInstructionsEnum maturityInstructions) {
    this.maturityInstructions = maturityInstructions;
    return this;
  }

  /**
   * Current instructions on action to be taken at maturity
   * @return maturityInstructions
  */
  @ApiModelProperty(required = true, value = "Current instructions on action to be taken at maturity")
  @NotNull


  public MaturityInstructionsEnum getMaturityInstructions() {
    return maturityInstructions;
  }

  public void setMaturityInstructions(MaturityInstructionsEnum maturityInstructions) {
    this.maturityInstructions = maturityInstructions;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BankingTermDepositAccount bankingTermDepositAccount = (BankingTermDepositAccount) o;
    return Objects.equals(this.lodgementDate, bankingTermDepositAccount.lodgementDate) &&
        Objects.equals(this.maturityDate, bankingTermDepositAccount.maturityDate) &&
        Objects.equals(this.maturityAmount, bankingTermDepositAccount.maturityAmount) &&
        Objects.equals(this.maturityCurrency, bankingTermDepositAccount.maturityCurrency) &&
        Objects.equals(this.maturityInstructions, bankingTermDepositAccount.maturityInstructions);
  }

  @Override
  public int hashCode() {
    return Objects.hash(lodgementDate, maturityDate, maturityAmount, maturityCurrency, maturityInstructions);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BankingTermDepositAccount {\n");
    
    sb.append("    lodgementDate: ").append(toIndentedString(lodgementDate)).append("\n");
    sb.append("    maturityDate: ").append(toIndentedString(maturityDate)).append("\n");
    sb.append("    maturityAmount: ").append(toIndentedString(maturityAmount)).append("\n");
    sb.append("    maturityCurrency: ").append(toIndentedString(maturityCurrency)).append("\n");
    sb.append("    maturityInstructions: ").append(toIndentedString(maturityInstructions)).append("\n");
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

