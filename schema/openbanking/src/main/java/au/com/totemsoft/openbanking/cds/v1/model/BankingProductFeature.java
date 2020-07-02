package au.com.totemsoft.openbanking.cds.v1.model;

import java.util.Objects;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import io.swagger.annotations.ApiModelProperty;

/**
 * BankingProductFeature
 */

public class BankingProductFeature   {
  /**
   * The type of feature described
   */
  public enum FeatureTypeEnum {
    CARD_ACCESS("CARD_ACCESS"),
    
    ADDITIONAL_CARDS("ADDITIONAL_CARDS"),
    
    UNLIMITED_TXNS("UNLIMITED_TXNS"),
    
    FREE_TXNS("FREE_TXNS"),
    
    FREE_TXNS_ALLOWANCE("FREE_TXNS_ALLOWANCE"),
    
    LOYALTY_PROGRAM("LOYALTY_PROGRAM"),
    
    OFFSET("OFFSET"),
    
    OVERDRAFT("OVERDRAFT"),
    
    REDRAW("REDRAW"),
    
    INSURANCE("INSURANCE"),
    
    BALANCE_TRANSFERS("BALANCE_TRANSFERS"),
    
    INTEREST_FREE("INTEREST_FREE"),
    
    INTEREST_FREE_TRANSFERS("INTEREST_FREE_TRANSFERS"),
    
    DIGITAL_WALLET("DIGITAL_WALLET"),
    
    DIGITAL_BANKING("DIGITAL_BANKING"),
    
    NPP_PAYID("NPP_PAYID"),
    
    NPP_ENABLED("NPP_ENABLED"),
    
    DONATE_INTEREST("DONATE_INTEREST"),
    
    BILL_PAYMENT("BILL_PAYMENT"),
    
    COMPLEMENTARY_PRODUCT_DISCOUNTS("COMPLEMENTARY_PRODUCT_DISCOUNTS"),
    
    BONUS_REWARDS("BONUS_REWARDS"),
    
    NOTIFICATIONS("NOTIFICATIONS"),
    
    OTHER("OTHER");

    private String value;

    FeatureTypeEnum(String value) {
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
    public static FeatureTypeEnum fromValue(String value) {
      for (FeatureTypeEnum b : FeatureTypeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  @JsonProperty("featureType")
  private FeatureTypeEnum featureType;

  @JsonProperty("additionalValue")
  private String additionalValue;

  @JsonProperty("additionalInfo")
  private String additionalInfo;

  @JsonProperty("additionalInfoUri")
  private String additionalInfoUri;

  public BankingProductFeature featureType(FeatureTypeEnum featureType) {
    this.featureType = featureType;
    return this;
  }

  /**
   * The type of feature described
   * @return featureType
  */
  @ApiModelProperty(required = true, value = "The type of feature described")
  @NotNull


  public FeatureTypeEnum getFeatureType() {
    return featureType;
  }

  public void setFeatureType(FeatureTypeEnum featureType) {
    this.featureType = featureType;
  }

  public BankingProductFeature additionalValue(String additionalValue) {
    this.additionalValue = additionalValue;
    return this;
  }

  /**
   * Generic field containing additional information relevant to the [featureType](#tocSproductfeaturetypedoc) specified. Whether mandatory or not is dependent on the value of the [featureType.](#tocSproductfeaturetypedoc)
   * @return additionalValue
  */
  @ApiModelProperty(value = "Generic field containing additional information relevant to the [featureType](#tocSproductfeaturetypedoc) specified. Whether mandatory or not is dependent on the value of the [featureType.](#tocSproductfeaturetypedoc)")


  public String getAdditionalValue() {
    return additionalValue;
  }

  public void setAdditionalValue(String additionalValue) {
    this.additionalValue = additionalValue;
  }

  public BankingProductFeature additionalInfo(String additionalInfo) {
    this.additionalInfo = additionalInfo;
    return this;
  }

  /**
   * Display text providing more information on the feature. Mandatory if the [feature type](#tocSproductfeaturetypedoc) is set to OTHER
   * @return additionalInfo
  */
  @ApiModelProperty(value = "Display text providing more information on the feature. Mandatory if the [feature type](#tocSproductfeaturetypedoc) is set to OTHER")


  public String getAdditionalInfo() {
    return additionalInfo;
  }

  public void setAdditionalInfo(String additionalInfo) {
    this.additionalInfo = additionalInfo;
  }

  public BankingProductFeature additionalInfoUri(String additionalInfoUri) {
    this.additionalInfoUri = additionalInfoUri;
    return this;
  }

  /**
   * Link to a web page with more information on this feature
   * @return additionalInfoUri
  */
  @ApiModelProperty(value = "Link to a web page with more information on this feature")


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
    BankingProductFeature bankingProductFeature = (BankingProductFeature) o;
    return Objects.equals(this.featureType, bankingProductFeature.featureType) &&
        Objects.equals(this.additionalValue, bankingProductFeature.additionalValue) &&
        Objects.equals(this.additionalInfo, bankingProductFeature.additionalInfo) &&
        Objects.equals(this.additionalInfoUri, bankingProductFeature.additionalInfoUri);
  }

  @Override
  public int hashCode() {
    return Objects.hash(featureType, additionalValue, additionalInfo, additionalInfoUri);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BankingProductFeature {\n");
    
    sb.append("    featureType: ").append(toIndentedString(featureType)).append("\n");
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

