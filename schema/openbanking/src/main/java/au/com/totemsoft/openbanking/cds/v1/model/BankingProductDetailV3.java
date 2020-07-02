package au.com.totemsoft.openbanking.cds.v1.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * BankingProductDetailV3
 */

public class BankingProductDetailV3   {
  @JsonProperty("productId")
  private String productId;

  @JsonProperty("effectiveFrom")
  private String effectiveFrom;

  @JsonProperty("effectiveTo")
  private String effectiveTo;

  @JsonProperty("lastUpdated")
  private String lastUpdated;

  @JsonProperty("productCategory")
  private BankingProductCategory productCategory;

  @JsonProperty("name")
  private String name;

  @JsonProperty("description")
  private String description;

  @JsonProperty("brand")
  private String brand;

  @JsonProperty("brandName")
  private String brandName;

  @JsonProperty("applicationUri")
  private String applicationUri;

  @JsonProperty("isTailored")
  private Boolean isTailored;

  @JsonProperty("additionalInformation")
  private BankingProductV3AdditionalInformation additionalInformation;

  @JsonProperty("cardArt")
  @Valid
  private List<BankingProductV3CardArt> cardArt = null;

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

  public BankingProductDetailV3 productId(String productId) {
    this.productId = productId;
    return this;
  }

  /**
   * A data holder specific unique identifier for this product. This identifier must be unique to a product but does not otherwise need to adhere to ID permanence guidelines.
   * @return productId
  */
  @ApiModelProperty(required = true, value = "A data holder specific unique identifier for this product. This identifier must be unique to a product but does not otherwise need to adhere to ID permanence guidelines.")
  @NotNull


  public String getProductId() {
    return productId;
  }

  public void setProductId(String productId) {
    this.productId = productId;
  }

  public BankingProductDetailV3 effectiveFrom(String effectiveFrom) {
    this.effectiveFrom = effectiveFrom;
    return this;
  }

  /**
   * The date and time from which this product is effective (ie. is available for origination).  Used to enable the articulation of products to the regime before they are available for customers to originate
   * @return effectiveFrom
  */
  @ApiModelProperty(value = "The date and time from which this product is effective (ie. is available for origination).  Used to enable the articulation of products to the regime before they are available for customers to originate")


  public String getEffectiveFrom() {
    return effectiveFrom;
  }

  public void setEffectiveFrom(String effectiveFrom) {
    this.effectiveFrom = effectiveFrom;
  }

  public BankingProductDetailV3 effectiveTo(String effectiveTo) {
    this.effectiveTo = effectiveTo;
    return this;
  }

  /**
   * The date and time at which this product will be retired and will no longer be offered.  Used to enable the managed deprecation of products
   * @return effectiveTo
  */
  @ApiModelProperty(value = "The date and time at which this product will be retired and will no longer be offered.  Used to enable the managed deprecation of products")


  public String getEffectiveTo() {
    return effectiveTo;
  }

  public void setEffectiveTo(String effectiveTo) {
    this.effectiveTo = effectiveTo;
  }

  public BankingProductDetailV3 lastUpdated(String lastUpdated) {
    this.lastUpdated = lastUpdated;
    return this;
  }

  /**
   * The last date and time that the information for this product was changed (or the creation date for the product if it has never been altered)
   * @return lastUpdated
  */
  @ApiModelProperty(required = true, value = "The last date and time that the information for this product was changed (or the creation date for the product if it has never been altered)")
  @NotNull


  public String getLastUpdated() {
    return lastUpdated;
  }

  public void setLastUpdated(String lastUpdated) {
    this.lastUpdated = lastUpdated;
  }

  public BankingProductDetailV3 productCategory(BankingProductCategory productCategory) {
    this.productCategory = productCategory;
    return this;
  }

  /**
   * Get productCategory
   * @return productCategory
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid

  public BankingProductCategory getProductCategory() {
    return productCategory;
  }

  public void setProductCategory(BankingProductCategory productCategory) {
    this.productCategory = productCategory;
  }

  public BankingProductDetailV3 name(String name) {
    this.name = name;
    return this;
  }

  /**
   * The display name of the product
   * @return name
  */
  @ApiModelProperty(required = true, value = "The display name of the product")
  @NotNull


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public BankingProductDetailV3 description(String description) {
    this.description = description;
    return this;
  }

  /**
   * A description of the product
   * @return description
  */
  @ApiModelProperty(required = true, value = "A description of the product")
  @NotNull


  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public BankingProductDetailV3 brand(String brand) {
    this.brand = brand;
    return this;
  }

  /**
   * A label of the brand for the product. Able to be used for filtering. For data holders with single brands this value is still required
   * @return brand
  */
  @ApiModelProperty(required = true, value = "A label of the brand for the product. Able to be used for filtering. For data holders with single brands this value is still required")
  @NotNull


  public String getBrand() {
    return brand;
  }

  public void setBrand(String brand) {
    this.brand = brand;
  }

  public BankingProductDetailV3 brandName(String brandName) {
    this.brandName = brandName;
    return this;
  }

  /**
   * An optional display name of the brand
   * @return brandName
  */
  @ApiModelProperty(value = "An optional display name of the brand")


  public String getBrandName() {
    return brandName;
  }

  public void setBrandName(String brandName) {
    this.brandName = brandName;
  }

  public BankingProductDetailV3 applicationUri(String applicationUri) {
    this.applicationUri = applicationUri;
    return this;
  }

  /**
   * A link to an application web page where this product can be applied for.
   * @return applicationUri
  */
  @ApiModelProperty(value = "A link to an application web page where this product can be applied for.")


  public String getApplicationUri() {
    return applicationUri;
  }

  public void setApplicationUri(String applicationUri) {
    this.applicationUri = applicationUri;
  }

  public BankingProductDetailV3 isTailored(Boolean isTailored) {
    this.isTailored = isTailored;
    return this;
  }

  /**
   * Indicates whether the product is specifically tailored to a circumstance.  In this case fees and prices are significantly negotiated depending on context. While all products are open to a degree of tailoring this flag indicates that tailoring is expected and thus that the provision of specific fees and rates is not applicable
   * @return isTailored
  */
  @ApiModelProperty(required = true, value = "Indicates whether the product is specifically tailored to a circumstance.  In this case fees and prices are significantly negotiated depending on context. While all products are open to a degree of tailoring this flag indicates that tailoring is expected and thus that the provision of specific fees and rates is not applicable")
  @NotNull


  public Boolean getIsTailored() {
    return isTailored;
  }

  public void setIsTailored(Boolean isTailored) {
    this.isTailored = isTailored;
  }

  public BankingProductDetailV3 additionalInformation(BankingProductV3AdditionalInformation additionalInformation) {
    this.additionalInformation = additionalInformation;
    return this;
  }

  /**
   * Get additionalInformation
   * @return additionalInformation
  */
  @ApiModelProperty(value = "")

  @Valid

  public BankingProductV3AdditionalInformation getAdditionalInformation() {
    return additionalInformation;
  }

  public void setAdditionalInformation(BankingProductV3AdditionalInformation additionalInformation) {
    this.additionalInformation = additionalInformation;
  }

  public BankingProductDetailV3 cardArt(List<BankingProductV3CardArt> cardArt) {
    this.cardArt = cardArt;
    return this;
  }

  public BankingProductDetailV3 addCardArtItem(BankingProductV3CardArt cardArtItem) {
    if (this.cardArt == null) {
      this.cardArt = new ArrayList<>();
    }
    this.cardArt.add(cardArtItem);
    return this;
  }

  /**
   * An array of card art images
   * @return cardArt
  */
  @ApiModelProperty(value = "An array of card art images")

  @Valid

  public List<BankingProductV3CardArt> getCardArt() {
    return cardArt;
  }

  public void setCardArt(List<BankingProductV3CardArt> cardArt) {
    this.cardArt = cardArt;
  }

  public BankingProductDetailV3 bundles(List<BankingProductBundle> bundles) {
    this.bundles = bundles;
    return this;
  }

  public BankingProductDetailV3 addBundlesItem(BankingProductBundle bundlesItem) {
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

  public BankingProductDetailV3 features(List<BankingProductFeature> features) {
    this.features = features;
    return this;
  }

  public BankingProductDetailV3 addFeaturesItem(BankingProductFeature featuresItem) {
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

  public BankingProductDetailV3 constraints(List<BankingProductConstraint> constraints) {
    this.constraints = constraints;
    return this;
  }

  public BankingProductDetailV3 addConstraintsItem(BankingProductConstraint constraintsItem) {
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

  public BankingProductDetailV3 eligibility(List<BankingProductEligibility> eligibility) {
    this.eligibility = eligibility;
    return this;
  }

  public BankingProductDetailV3 addEligibilityItem(BankingProductEligibility eligibilityItem) {
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

  public BankingProductDetailV3 fees(List<BankingProductFee> fees) {
    this.fees = fees;
    return this;
  }

  public BankingProductDetailV3 addFeesItem(BankingProductFee feesItem) {
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

  public BankingProductDetailV3 depositRates(List<BankingProductDepositRate> depositRates) {
    this.depositRates = depositRates;
    return this;
  }

  public BankingProductDetailV3 addDepositRatesItem(BankingProductDepositRate depositRatesItem) {
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

  public BankingProductDetailV3 lendingRates(List<BankingProductLendingRate> lendingRates) {
    this.lendingRates = lendingRates;
    return this;
  }

  public BankingProductDetailV3 addLendingRatesItem(BankingProductLendingRate lendingRatesItem) {
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
    BankingProductDetailV3 bankingProductDetailV3 = (BankingProductDetailV3) o;
    return Objects.equals(this.productId, bankingProductDetailV3.productId) &&
        Objects.equals(this.effectiveFrom, bankingProductDetailV3.effectiveFrom) &&
        Objects.equals(this.effectiveTo, bankingProductDetailV3.effectiveTo) &&
        Objects.equals(this.lastUpdated, bankingProductDetailV3.lastUpdated) &&
        Objects.equals(this.productCategory, bankingProductDetailV3.productCategory) &&
        Objects.equals(this.name, bankingProductDetailV3.name) &&
        Objects.equals(this.description, bankingProductDetailV3.description) &&
        Objects.equals(this.brand, bankingProductDetailV3.brand) &&
        Objects.equals(this.brandName, bankingProductDetailV3.brandName) &&
        Objects.equals(this.applicationUri, bankingProductDetailV3.applicationUri) &&
        Objects.equals(this.isTailored, bankingProductDetailV3.isTailored) &&
        Objects.equals(this.additionalInformation, bankingProductDetailV3.additionalInformation) &&
        Objects.equals(this.cardArt, bankingProductDetailV3.cardArt) &&
        Objects.equals(this.bundles, bankingProductDetailV3.bundles) &&
        Objects.equals(this.features, bankingProductDetailV3.features) &&
        Objects.equals(this.constraints, bankingProductDetailV3.constraints) &&
        Objects.equals(this.eligibility, bankingProductDetailV3.eligibility) &&
        Objects.equals(this.fees, bankingProductDetailV3.fees) &&
        Objects.equals(this.depositRates, bankingProductDetailV3.depositRates) &&
        Objects.equals(this.lendingRates, bankingProductDetailV3.lendingRates);
  }

  @Override
  public int hashCode() {
    return Objects.hash(productId, effectiveFrom, effectiveTo, lastUpdated, productCategory, name, description, brand, brandName, applicationUri, isTailored, additionalInformation, cardArt, bundles, features, constraints, eligibility, fees, depositRates, lendingRates);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BankingProductDetailV3 {\n");
    
    sb.append("    productId: ").append(toIndentedString(productId)).append("\n");
    sb.append("    effectiveFrom: ").append(toIndentedString(effectiveFrom)).append("\n");
    sb.append("    effectiveTo: ").append(toIndentedString(effectiveTo)).append("\n");
    sb.append("    lastUpdated: ").append(toIndentedString(lastUpdated)).append("\n");
    sb.append("    productCategory: ").append(toIndentedString(productCategory)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    brand: ").append(toIndentedString(brand)).append("\n");
    sb.append("    brandName: ").append(toIndentedString(brandName)).append("\n");
    sb.append("    applicationUri: ").append(toIndentedString(applicationUri)).append("\n");
    sb.append("    isTailored: ").append(toIndentedString(isTailored)).append("\n");
    sb.append("    additionalInformation: ").append(toIndentedString(additionalInformation)).append("\n");
    sb.append("    cardArt: ").append(toIndentedString(cardArt)).append("\n");
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

