package au.com.totemsoft.openbanking.cds.v1.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import io.swagger.annotations.ApiModelProperty;

/**
 * BankingProductLendingRate
 */

public class BankingProductLendingRate   {
  /**
   * The type of rate (fixed, variable, etc). See the next section for an overview of valid values and their meaning
   */
  public enum LendingRateTypeEnum {
    FIXED("FIXED"),
    
    VARIABLE("VARIABLE"),
    
    INTRODUCTORY("INTRODUCTORY"),
    
    DISCOUNT("DISCOUNT"),
    
    PENALTY("PENALTY"),
    
    FLOATING("FLOATING"),
    
    MARKET_LINKED("MARKET_LINKED"),
    
    CASH_ADVANCE("CASH_ADVANCE"),
    
    PURCHASE("PURCHASE"),
    
    BUNDLE_DISCOUNT_FIXED("BUNDLE_DISCOUNT_FIXED"),
    
    BUNDLE_DISCOUNT_VARIABLE("BUNDLE_DISCOUNT_VARIABLE");

    private String value;

    LendingRateTypeEnum(String value) {
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
    public static LendingRateTypeEnum fromValue(String value) {
      for (LendingRateTypeEnum b : LendingRateTypeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  @JsonProperty("lendingRateType")
  private LendingRateTypeEnum lendingRateType;

  @JsonProperty("rate")
  private String rate;

  @JsonProperty("comparisonRate")
  private String comparisonRate;

  @JsonProperty("calculationFrequency")
  private String calculationFrequency;

  @JsonProperty("applicationFrequency")
  private String applicationFrequency;

  /**
   * When loan payments are due to be paid within each period. The investment benefit of earlier payments affect the rate that can be offered
   */
  public enum InterestPaymentDueEnum {
    ARREARS("IN_ARREARS"),
    
    ADVANCE("IN_ADVANCE");

    private String value;

    InterestPaymentDueEnum(String value) {
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
    public static InterestPaymentDueEnum fromValue(String value) {
      for (InterestPaymentDueEnum b : InterestPaymentDueEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  @JsonProperty("interestPaymentDue")
  private InterestPaymentDueEnum interestPaymentDue;

  /**
   * Options in place for repayments. If absent, the lending rate is applicable to all repayment types
   */
  public enum RepaymentTypeEnum {
    INTEREST_ONLY("INTEREST_ONLY"),
    
    PRINCIPAL_AND_INTEREST("PRINCIPAL_AND_INTEREST");

    private String value;

    RepaymentTypeEnum(String value) {
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
    public static RepaymentTypeEnum fromValue(String value) {
      for (RepaymentTypeEnum b : RepaymentTypeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  @JsonProperty("repaymentType")
  private RepaymentTypeEnum repaymentType;

  /**
   * The reason for taking out the loan. If absent, the lending rate is applicable to all loan purposes
   */
  public enum LoanPurposeEnum {
    OWNER_OCCUPIED("OWNER_OCCUPIED"),
    
    INVESTMENT("INVESTMENT");

    private String value;

    LoanPurposeEnum(String value) {
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
    public static LoanPurposeEnum fromValue(String value) {
      for (LoanPurposeEnum b : LoanPurposeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  @JsonProperty("loanPurpose")
  private LoanPurposeEnum loanPurpose;

  @JsonProperty("tiers")
  @Valid
  private List<BankingProductRateTierV3> tiers = null;

  @JsonProperty("additionalValue")
  private String additionalValue;

  @JsonProperty("additionalInfo")
  private String additionalInfo;

  @JsonProperty("additionalInfoUri")
  private String additionalInfoUri;

  public BankingProductLendingRate lendingRateType(LendingRateTypeEnum lendingRateType) {
    this.lendingRateType = lendingRateType;
    return this;
  }

  /**
   * The type of rate (fixed, variable, etc). See the next section for an overview of valid values and their meaning
   * @return lendingRateType
  */
  @ApiModelProperty(required = true, value = "The type of rate (fixed, variable, etc). See the next section for an overview of valid values and their meaning")
  @NotNull


  public LendingRateTypeEnum getLendingRateType() {
    return lendingRateType;
  }

  public void setLendingRateType(LendingRateTypeEnum lendingRateType) {
    this.lendingRateType = lendingRateType;
  }

  public BankingProductLendingRate rate(String rate) {
    this.rate = rate;
    return this;
  }

  /**
   * The rate to be applied
   * @return rate
  */
  @ApiModelProperty(required = true, value = "The rate to be applied")
  @NotNull


  public String getRate() {
    return rate;
  }

  public void setRate(String rate) {
    this.rate = rate;
  }

  public BankingProductLendingRate comparisonRate(String comparisonRate) {
    this.comparisonRate = comparisonRate;
    return this;
  }

  /**
   * A comparison rate equivalent for this rate
   * @return comparisonRate
  */
  @ApiModelProperty(value = "A comparison rate equivalent for this rate")


  public String getComparisonRate() {
    return comparisonRate;
  }

  public void setComparisonRate(String comparisonRate) {
    this.comparisonRate = comparisonRate;
  }

  public BankingProductLendingRate calculationFrequency(String calculationFrequency) {
    this.calculationFrequency = calculationFrequency;
    return this;
  }

  /**
   * The period after which the rate is applied to the balance to calculate the amount due for the period. Calculation of the amount is often daily (as balances may change) but accumulated until the total amount is 'applied' to the account (see applicationFrequency). Formatted according to [ISO 8601 Durations](https://en.wikipedia.org/wiki/ISO_8601#Durations) (excludes recurrence syntax)
   * @return calculationFrequency
  */
  @ApiModelProperty(value = "The period after which the rate is applied to the balance to calculate the amount due for the period. Calculation of the amount is often daily (as balances may change) but accumulated until the total amount is 'applied' to the account (see applicationFrequency). Formatted according to [ISO 8601 Durations](https://en.wikipedia.org/wiki/ISO_8601#Durations) (excludes recurrence syntax)")


  public String getCalculationFrequency() {
    return calculationFrequency;
  }

  public void setCalculationFrequency(String calculationFrequency) {
    this.calculationFrequency = calculationFrequency;
  }

  public BankingProductLendingRate applicationFrequency(String applicationFrequency) {
    this.applicationFrequency = applicationFrequency;
    return this;
  }

  /**
   * The period after which the calculated amount(s) (see calculationFrequency) are 'applied' (i.e. debited or credited) to the account. Formatted according to [ISO 8601 Durations](https://en.wikipedia.org/wiki/ISO_8601#Durations) (excludes recurrence syntax)
   * @return applicationFrequency
  */
  @ApiModelProperty(value = "The period after which the calculated amount(s) (see calculationFrequency) are 'applied' (i.e. debited or credited) to the account. Formatted according to [ISO 8601 Durations](https://en.wikipedia.org/wiki/ISO_8601#Durations) (excludes recurrence syntax)")


  public String getApplicationFrequency() {
    return applicationFrequency;
  }

  public void setApplicationFrequency(String applicationFrequency) {
    this.applicationFrequency = applicationFrequency;
  }

  public BankingProductLendingRate interestPaymentDue(InterestPaymentDueEnum interestPaymentDue) {
    this.interestPaymentDue = interestPaymentDue;
    return this;
  }

  /**
   * When loan payments are due to be paid within each period. The investment benefit of earlier payments affect the rate that can be offered
   * @return interestPaymentDue
  */
  @ApiModelProperty(value = "When loan payments are due to be paid within each period. The investment benefit of earlier payments affect the rate that can be offered")


  public InterestPaymentDueEnum getInterestPaymentDue() {
    return interestPaymentDue;
  }

  public void setInterestPaymentDue(InterestPaymentDueEnum interestPaymentDue) {
    this.interestPaymentDue = interestPaymentDue;
  }

  public BankingProductLendingRate repaymentType(RepaymentTypeEnum repaymentType) {
    this.repaymentType = repaymentType;
    return this;
  }

  /**
   * Options in place for repayments. If absent, the lending rate is applicable to all repayment types
   * @return repaymentType
  */
  @ApiModelProperty(value = "Options in place for repayments. If absent, the lending rate is applicable to all repayment types")


  public RepaymentTypeEnum getRepaymentType() {
    return repaymentType;
  }

  public void setRepaymentType(RepaymentTypeEnum repaymentType) {
    this.repaymentType = repaymentType;
  }

  public BankingProductLendingRate loanPurpose(LoanPurposeEnum loanPurpose) {
    this.loanPurpose = loanPurpose;
    return this;
  }

  /**
   * The reason for taking out the loan. If absent, the lending rate is applicable to all loan purposes
   * @return loanPurpose
  */
  @ApiModelProperty(value = "The reason for taking out the loan. If absent, the lending rate is applicable to all loan purposes")


  public LoanPurposeEnum getLoanPurpose() {
    return loanPurpose;
  }

  public void setLoanPurpose(LoanPurposeEnum loanPurpose) {
    this.loanPurpose = loanPurpose;
  }

  public BankingProductLendingRate tiers(List<BankingProductRateTierV3> tiers) {
    this.tiers = tiers;
    return this;
  }

  public BankingProductLendingRate addTiersItem(BankingProductRateTierV3 tiersItem) {
    if (this.tiers == null) {
      this.tiers = new ArrayList<>();
    }
    this.tiers.add(tiersItem);
    return this;
  }

  /**
   * Rate tiers applicable for this rate
   * @return tiers
  */
  @ApiModelProperty(value = "Rate tiers applicable for this rate")

  @Valid

  public List<BankingProductRateTierV3> getTiers() {
    return tiers;
  }

  public void setTiers(List<BankingProductRateTierV3> tiers) {
    this.tiers = tiers;
  }

  public BankingProductLendingRate additionalValue(String additionalValue) {
    this.additionalValue = additionalValue;
    return this;
  }

  /**
   * Generic field containing additional information relevant to the [lendingRateType](#tocSproductlendingratetypedoc) specified. Whether mandatory or not is dependent on the value of [lendingRateType](#tocSproductlendingratetypedoc)
   * @return additionalValue
  */
  @ApiModelProperty(value = "Generic field containing additional information relevant to the [lendingRateType](#tocSproductlendingratetypedoc) specified. Whether mandatory or not is dependent on the value of [lendingRateType](#tocSproductlendingratetypedoc)")


  public String getAdditionalValue() {
    return additionalValue;
  }

  public void setAdditionalValue(String additionalValue) {
    this.additionalValue = additionalValue;
  }

  public BankingProductLendingRate additionalInfo(String additionalInfo) {
    this.additionalInfo = additionalInfo;
    return this;
  }

  /**
   * Display text providing more information on the rate.
   * @return additionalInfo
  */
  @ApiModelProperty(value = "Display text providing more information on the rate.")


  public String getAdditionalInfo() {
    return additionalInfo;
  }

  public void setAdditionalInfo(String additionalInfo) {
    this.additionalInfo = additionalInfo;
  }

  public BankingProductLendingRate additionalInfoUri(String additionalInfoUri) {
    this.additionalInfoUri = additionalInfoUri;
    return this;
  }

  /**
   * Link to a web page with more information on this rate
   * @return additionalInfoUri
  */
  @ApiModelProperty(value = "Link to a web page with more information on this rate")


  public String getAdditionalInfoUri() {
    return additionalInfoUri;
  }

  public void setAdditionalInfoUri(String additionalInfoUri) {
    this.additionalInfoUri = additionalInfoUri;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BankingProductLendingRate bankingProductLendingRate = (BankingProductLendingRate) o;
    return Objects.equals(this.lendingRateType, bankingProductLendingRate.lendingRateType) &&
        Objects.equals(this.rate, bankingProductLendingRate.rate) &&
        Objects.equals(this.comparisonRate, bankingProductLendingRate.comparisonRate) &&
        Objects.equals(this.calculationFrequency, bankingProductLendingRate.calculationFrequency) &&
        Objects.equals(this.applicationFrequency, bankingProductLendingRate.applicationFrequency) &&
        Objects.equals(this.interestPaymentDue, bankingProductLendingRate.interestPaymentDue) &&
        Objects.equals(this.repaymentType, bankingProductLendingRate.repaymentType) &&
        Objects.equals(this.loanPurpose, bankingProductLendingRate.loanPurpose) &&
        Objects.equals(this.tiers, bankingProductLendingRate.tiers) &&
        Objects.equals(this.additionalValue, bankingProductLendingRate.additionalValue) &&
        Objects.equals(this.additionalInfo, bankingProductLendingRate.additionalInfo) &&
        Objects.equals(this.additionalInfoUri, bankingProductLendingRate.additionalInfoUri);
  }

  @Override
  public int hashCode() {
    return Objects.hash(lendingRateType, rate, comparisonRate, calculationFrequency, applicationFrequency, interestPaymentDue, repaymentType, loanPurpose, tiers, additionalValue, additionalInfo, additionalInfoUri);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BankingProductLendingRate {\n");
    
    sb.append("    lendingRateType: ").append(toIndentedString(lendingRateType)).append("\n");
    sb.append("    rate: ").append(toIndentedString(rate)).append("\n");
    sb.append("    comparisonRate: ").append(toIndentedString(comparisonRate)).append("\n");
    sb.append("    calculationFrequency: ").append(toIndentedString(calculationFrequency)).append("\n");
    sb.append("    applicationFrequency: ").append(toIndentedString(applicationFrequency)).append("\n");
    sb.append("    interestPaymentDue: ").append(toIndentedString(interestPaymentDue)).append("\n");
    sb.append("    repaymentType: ").append(toIndentedString(repaymentType)).append("\n");
    sb.append("    loanPurpose: ").append(toIndentedString(loanPurpose)).append("\n");
    sb.append("    tiers: ").append(toIndentedString(tiers)).append("\n");
    sb.append("    additionalValue: ").append(toIndentedString(additionalValue)).append("\n");
    sb.append("    additionalInfo: ").append(toIndentedString(additionalInfo)).append("\n");
    sb.append("    additionalInfoUri: ").append(toIndentedString(additionalInfoUri)).append("\n");
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

