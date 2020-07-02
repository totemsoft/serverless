package au.com.totemsoft.openbanking.cds.v1.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Object that contains links to additional information on specific topics
 */
@ApiModel(description = "Object that contains links to additional information on specific topics")

public class BankingProductV3AdditionalInformation   {
  @JsonProperty("overviewUri")
  private String overviewUri;

  @JsonProperty("termsUri")
  private String termsUri;

  @JsonProperty("eligibilityUri")
  private String eligibilityUri;

  @JsonProperty("feesAndPricingUri")
  private String feesAndPricingUri;

  @JsonProperty("bundleUri")
  private String bundleUri;

  public BankingProductV3AdditionalInformation overviewUri(String overviewUri) {
    this.overviewUri = overviewUri;
    return this;
  }

  /**
   * General overview of the product
   * @return overviewUri
  */
  @ApiModelProperty(value = "General overview of the product")


  public String getOverviewUri() {
    return overviewUri;
  }

  public void setOverviewUri(String overviewUri) {
    this.overviewUri = overviewUri;
  }

  public BankingProductV3AdditionalInformation termsUri(String termsUri) {
    this.termsUri = termsUri;
    return this;
  }

  /**
   * Terms and conditions for the product
   * @return termsUri
  */
  @ApiModelProperty(value = "Terms and conditions for the product")


  public String getTermsUri() {
    return termsUri;
  }

  public void setTermsUri(String termsUri) {
    this.termsUri = termsUri;
  }

  public BankingProductV3AdditionalInformation eligibilityUri(String eligibilityUri) {
    this.eligibilityUri = eligibilityUri;
    return this;
  }

  /**
   * Eligibility rules and criteria for the product
   * @return eligibilityUri
  */
  @ApiModelProperty(value = "Eligibility rules and criteria for the product")


  public String getEligibilityUri() {
    return eligibilityUri;
  }

  public void setEligibilityUri(String eligibilityUri) {
    this.eligibilityUri = eligibilityUri;
  }

  public BankingProductV3AdditionalInformation feesAndPricingUri(String feesAndPricingUri) {
    this.feesAndPricingUri = feesAndPricingUri;
    return this;
  }

  /**
   * Description of fees, pricing, discounts, exemptions and bonuses for the product
   * @return feesAndPricingUri
  */
  @ApiModelProperty(value = "Description of fees, pricing, discounts, exemptions and bonuses for the product")


  public String getFeesAndPricingUri() {
    return feesAndPricingUri;
  }

  public void setFeesAndPricingUri(String feesAndPricingUri) {
    this.feesAndPricingUri = feesAndPricingUri;
  }

  public BankingProductV3AdditionalInformation bundleUri(String bundleUri) {
    this.bundleUri = bundleUri;
    return this;
  }

  /**
   * Description of a bundle that this product can be part of
   * @return bundleUri
  */
  @ApiModelProperty(value = "Description of a bundle that this product can be part of")


  public String getBundleUri() {
    return bundleUri;
  }

  public void setBundleUri(String bundleUri) {
    this.bundleUri = bundleUri;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BankingProductV3AdditionalInformation bankingProductV3AdditionalInformation = (BankingProductV3AdditionalInformation) o;
    return Objects.equals(this.overviewUri, bankingProductV3AdditionalInformation.overviewUri) &&
        Objects.equals(this.termsUri, bankingProductV3AdditionalInformation.termsUri) &&
        Objects.equals(this.eligibilityUri, bankingProductV3AdditionalInformation.eligibilityUri) &&
        Objects.equals(this.feesAndPricingUri, bankingProductV3AdditionalInformation.feesAndPricingUri) &&
        Objects.equals(this.bundleUri, bankingProductV3AdditionalInformation.bundleUri);
  }

  @Override
  public int hashCode() {
    return Objects.hash(overviewUri, termsUri, eligibilityUri, feesAndPricingUri, bundleUri);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BankingProductV3AdditionalInformation {\n");
    
    sb.append("    overviewUri: ").append(toIndentedString(overviewUri)).append("\n");
    sb.append("    termsUri: ").append(toIndentedString(termsUri)).append("\n");
    sb.append("    eligibilityUri: ").append(toIndentedString(eligibilityUri)).append("\n");
    sb.append("    feesAndPricingUri: ").append(toIndentedString(feesAndPricingUri)).append("\n");
    sb.append("    bundleUri: ").append(toIndentedString(bundleUri)).append("\n");
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

