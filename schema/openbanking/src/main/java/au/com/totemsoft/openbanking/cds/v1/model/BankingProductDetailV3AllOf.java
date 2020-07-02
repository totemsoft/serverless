package au.com.totemsoft.openbanking.cds.v1.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * BankingProductDetailV3AllOf
 */

public class BankingProductDetailV3AllOf   {
  @JsonProperty("bundles")
  @Valid
  private List<BankingProductBundle> bundles = null;

  @JsonProperty("features")
  @Valid
  private List<BankingProductFeature> features = null;

  @JsonProperty("constraints")
  @Valid
  private List<BankingProductConstraint> constraints = null;

  @JsonProperty("eligibility")
  @Valid
  private List<BankingProductEligibility> eligibility = null;

  @JsonProperty("fees")
  @Valid
  private List<BankingProductFee> fees = null;

  @JsonProperty("depositRates")
  @Valid
  private List<BankingProductDepositRate> depositRates = null;

  @JsonProperty("lendingRates")
  @Valid
  private List<BankingProductLendingRate> lendingRates = null;

  public BankingProductDetailV3AllOf bundles(List<BankingProductBundle> bundles) {
    this.bundles = bundles;
    return this;
  }

  public BankingProductDetailV3AllOf addBundlesItem(BankingProductBundle bundlesItem) {
    if (this.bundles == null) {
      this.bundles = new ArrayList<>();
    }
    this.bundles.add(bundlesItem);
    return this;
  }

  /**
   * An array of bundles that this product participates in.  Each bundle is described by free form information but also by a list of product IDs of the other products that are included in the bundle.  It is assumed that the current product is included in the bundle also
   * @return bundles
  */
  @ApiModelProperty(value = "An array of bundles that this product participates in.  Each bundle is described by free form information but also by a list of product IDs of the other products that are included in the bundle.  It is assumed that the current product is included in the bundle also")

  @Valid

  public List<BankingProductBundle> getBundles() {
    return bundles;
  }

  public void setBundles(List<BankingProductBundle> bundles) {
    this.bundles = bundles;
  }

  public BankingProductDetailV3AllOf features(List<BankingProductFeature> features) {
    this.features = features;
    return this;
  }

  public BankingProductDetailV3AllOf addFeaturesItem(BankingProductFeature featuresItem) {
    if (this.features == null) {
      this.features = new ArrayList<>();
    }
    this.features.add(featuresItem);
    return this;
  }

  /**
   * Array of features available for the product
   * @return features
  */
  @ApiModelProperty(value = "Array of features available for the product")

  @Valid

  public List<BankingProductFeature> getFeatures() {
    return features;
  }

  public void setFeatures(List<BankingProductFeature> features) {
    this.features = features;
  }

  public BankingProductDetailV3AllOf constraints(List<BankingProductConstraint> constraints) {
    this.constraints = constraints;
    return this;
  }

  public BankingProductDetailV3AllOf addConstraintsItem(BankingProductConstraint constraintsItem) {
    if (this.constraints == null) {
      this.constraints = new ArrayList<>();
    }
    this.constraints.add(constraintsItem);
    return this;
  }

  /**
   * Constraints on the application for or operation of the product such as minimum balances or limit thresholds
   * @return constraints
  */
  @ApiModelProperty(value = "Constraints on the application for or operation of the product such as minimum balances or limit thresholds")

  @Valid

  public List<BankingProductConstraint> getConstraints() {
    return constraints;
  }

  public void setConstraints(List<BankingProductConstraint> constraints) {
    this.constraints = constraints;
  }

  public BankingProductDetailV3AllOf eligibility(List<BankingProductEligibility> eligibility) {
    this.eligibility = eligibility;
    return this;
  }

  public BankingProductDetailV3AllOf addEligibilityItem(BankingProductEligibility eligibilityItem) {
    if (this.eligibility == null) {
      this.eligibility = new ArrayList<>();
    }
    this.eligibility.add(eligibilityItem);
    return this;
  }

  /**
   * Eligibility criteria for the product
   * @return eligibility
  */
  @ApiModelProperty(value = "Eligibility criteria for the product")

  @Valid

  public List<BankingProductEligibility> getEligibility() {
    return eligibility;
  }

  public void setEligibility(List<BankingProductEligibility> eligibility) {
    this.eligibility = eligibility;
  }

  public BankingProductDetailV3AllOf fees(List<BankingProductFee> fees) {
    this.fees = fees;
    return this;
  }

  public BankingProductDetailV3AllOf addFeesItem(BankingProductFee feesItem) {
    if (this.fees == null) {
      this.fees = new ArrayList<>();
    }
    this.fees.add(feesItem);
    return this;
  }

  /**
   * Fees applicable for the product
   * @return fees
  */
  @ApiModelProperty(value = "Fees applicable for the product")

  @Valid

  public List<BankingProductFee> getFees() {
    return fees;
  }

  public void setFees(List<BankingProductFee> fees) {
    this.fees = fees;
  }

  public BankingProductDetailV3AllOf depositRates(List<BankingProductDepositRate> depositRates) {
    this.depositRates = depositRates;
    return this;
  }

  public BankingProductDetailV3AllOf addDepositRatesItem(BankingProductDepositRate depositRatesItem) {
    if (this.depositRates == null) {
      this.depositRates = new ArrayList<>();
    }
    this.depositRates.add(depositRatesItem);
    return this;
  }

  /**
   * Interest rates available for deposits
   * @return depositRates
  */
  @ApiModelProperty(value = "Interest rates available for deposits")

  @Valid

  public List<BankingProductDepositRate> getDepositRates() {
    return depositRates;
  }

  public void setDepositRates(List<BankingProductDepositRate> depositRates) {
    this.depositRates = depositRates;
  }

  public BankingProductDetailV3AllOf lendingRates(List<BankingProductLendingRate> lendingRates) {
    this.lendingRates = lendingRates;
    return this;
  }

  public BankingProductDetailV3AllOf addLendingRatesItem(BankingProductLendingRate lendingRatesItem) {
    if (this.lendingRates == null) {
      this.lendingRates = new ArrayList<>();
    }
    this.lendingRates.add(lendingRatesItem);
    return this;
  }

  /**
   * Interest rates charged against lending balances
   * @return lendingRates
  */
  @ApiModelProperty(value = "Interest rates charged against lending balances")

  @Valid

  public List<BankingProductLendingRate> getLendingRates() {
    return lendingRates;
  }

  public void setLendingRates(List<BankingProductLendingRate> lendingRates) {
    this.lendingRates = lendingRates;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BankingProductDetailV3AllOf bankingProductDetailV3AllOf = (BankingProductDetailV3AllOf) o;
    return Objects.equals(this.bundles, bankingProductDetailV3AllOf.bundles) &&
        Objects.equals(this.features, bankingProductDetailV3AllOf.features) &&
        Objects.equals(this.constraints, bankingProductDetailV3AllOf.constraints) &&
        Objects.equals(this.eligibility, bankingProductDetailV3AllOf.eligibility) &&
        Objects.equals(this.fees, bankingProductDetailV3AllOf.fees) &&
        Objects.equals(this.depositRates, bankingProductDetailV3AllOf.depositRates) &&
        Objects.equals(this.lendingRates, bankingProductDetailV3AllOf.lendingRates);
  }

  @Override
  public int hashCode() {
    return Objects.hash(bundles, features, constraints, eligibility, fees, depositRates, lendingRates);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BankingProductDetailV3AllOf {\n");
    
    sb.append("    bundles: ").append(toIndentedString(bundles)).append("\n");
    sb.append("    features: ").append(toIndentedString(features)).append("\n");
    sb.append("    constraints: ").append(toIndentedString(constraints)).append("\n");
    sb.append("    eligibility: ").append(toIndentedString(eligibility)).append("\n");
    sb.append("    fees: ").append(toIndentedString(fees)).append("\n");
    sb.append("    depositRates: ").append(toIndentedString(depositRates)).append("\n");
    sb.append("    lendingRates: ").append(toIndentedString(lendingRates)).append("\n");
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

