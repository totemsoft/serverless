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
 * BankingProductDepositRate
 */

public class BankingProductDepositRate   {
  /**
   * The type of rate (base, bonus, etc). See the next section for an overview of valid values and their meaning
   */
  public enum DepositRateTypeEnum {
    FIXED("FIXED"),
    
    BONUS("BONUS"),
    
    BUNDLE_BONUS("BUNDLE_BONUS"),
    
    VARIABLE("VARIABLE"),
    
    INTRODUCTORY("INTRODUCTORY"),
    
    FLOATING("FLOATING"),
    
    MARKET_LINKED("MARKET_LINKED");

    private String value;

    DepositRateTypeEnum(String value) {
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
    public static DepositRateTypeEnum fromValue(String value) {
      for (DepositRateTypeEnum b : DepositRateTypeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  @JsonProperty("depositRateType")
  private DepositRateTypeEnum depositRateType;

  @JsonProperty("rate")
  private String rate;

  @JsonProperty("calculationFrequency")
  private String calculationFrequency;

  @JsonProperty("applicationFrequency")
  private String applicationFrequency;

  @JsonProperty("tiers")
  @Valid
  private List<BankingProductRateTierV3> tiers = null;

  @JsonProperty("additionalValue")
  private String additionalValue;

  @JsonProperty("additionalInfo")
  private String additionalInfo;

  @JsonProperty("additionalInfoUri")
  private String additionalInfoUri;

  public BankingProductDepositRate depositRateType(DepositRateTypeEnum depositRateType) {
    this.depositRateType = depositRateType;
    return this;
  }

  /**
   * The type of rate (base, bonus, etc). See the next section for an overview of valid values and their meaning
   * @return depositRateType
  */
  @ApiModelProperty(required = true, value = "The type of rate (base, bonus, etc). See the next section for an overview of valid values and their meaning")
  @NotNull


  public DepositRateTypeEnum getDepositRateType() {
    return depositRateType;
  }

  public void setDepositRateType(DepositRateTypeEnum depositRateType) {
    this.depositRateType = depositRateType;
  }

  public BankingProductDepositRate rate(String rate) {
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

  public BankingProductDepositRate calculationFrequency(String calculationFrequency) {
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

  public BankingProductDepositRate applicationFrequency(String applicationFrequency) {
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

  public BankingProductDepositRate tiers(List<BankingProductRateTierV3> tiers) {
    this.tiers = tiers;
    return this;
  }

  public BankingProductDepositRate addTiersItem(BankingProductRateTierV3 tiersItem) {
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

  public BankingProductDepositRate additionalValue(String additionalValue) {
    this.additionalValue = additionalValue;
    return this;
  }

  /**
   * Generic field containing additional information relevant to the [depositRateType](#tocSproductdepositratetypedoc) specified. Whether mandatory or not is dependent on the value of [depositRateType](#tocSproductdepositratetypedoc)
   * @return additionalValue
  */
  @ApiModelProperty(value = "Generic field containing additional information relevant to the [depositRateType](#tocSproductdepositratetypedoc) specified. Whether mandatory or not is dependent on the value of [depositRateType](#tocSproductdepositratetypedoc)")


  public String getAdditionalValue() {
    return additionalValue;
  }

  public void setAdditionalValue(String additionalValue) {
    this.additionalValue = additionalValue;
  }

  public BankingProductDepositRate additionalInfo(String additionalInfo) {
    this.additionalInfo = additionalInfo;
    return this;
  }

  /**
   * Display text providing more information on the rate
   * @return additionalInfo
  */
  @ApiModelProperty(value = "Display text providing more information on the rate")


  public String getAdditionalInfo() {
    return additionalInfo;
  }

  public void setAdditionalInfo(String additionalInfo) {
    this.additionalInfo = additionalInfo;
  }

  public BankingProductDepositRate additionalInfoUri(String additionalInfoUri) {
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
    BankingProductDepositRate bankingProductDepositRate = (BankingProductDepositRate) o;
    return Objects.equals(this.depositRateType, bankingProductDepositRate.depositRateType) &&
        Objects.equals(this.rate, bankingProductDepositRate.rate) &&
        Objects.equals(this.calculationFrequency, bankingProductDepositRate.calculationFrequency) &&
        Objects.equals(this.applicationFrequency, bankingProductDepositRate.applicationFrequency) &&
        Objects.equals(this.tiers, bankingProductDepositRate.tiers) &&
        Objects.equals(this.additionalValue, bankingProductDepositRate.additionalValue) &&
        Objects.equals(this.additionalInfo, bankingProductDepositRate.additionalInfo) &&
        Objects.equals(this.additionalInfoUri, bankingProductDepositRate.additionalInfoUri);
  }

  @Override
  public int hashCode() {
    return Objects.hash(depositRateType, rate, calculationFrequency, applicationFrequency, tiers, additionalValue, additionalInfo, additionalInfoUri);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BankingProductDepositRate {\n");
    
    sb.append("    depositRateType: ").append(toIndentedString(depositRateType)).append("\n");
    sb.append("    rate: ").append(toIndentedString(rate)).append("\n");
    sb.append("    calculationFrequency: ").append(toIndentedString(calculationFrequency)).append("\n");
    sb.append("    applicationFrequency: ").append(toIndentedString(applicationFrequency)).append("\n");
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

