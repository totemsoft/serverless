package au.com.totemsoft.openbanking.cds.v1.model;

import java.util.Objects;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import io.swagger.annotations.ApiModelProperty;

/**
 * BankingProductEligibility
 */

public class BankingProductEligibility   {
  /**
   * The type of eligibility criteria described.  See the next section for an overview of valid values and their meaning
   */
  public enum EligibilityTypeEnum {
    BUSINESS("BUSINESS"),
    
    PENSION_RECIPIENT("PENSION_RECIPIENT"),
    
    MIN_AGE("MIN_AGE"),
    
    MAX_AGE("MAX_AGE"),
    
    MIN_INCOME("MIN_INCOME"),
    
    MIN_TURNOVER("MIN_TURNOVER"),
    
    STAFF("STAFF"),
    
    STUDENT("STUDENT"),
    
    EMPLOYMENT_STATUS("EMPLOYMENT_STATUS"),
    
    RESIDENCY_STATUS("RESIDENCY_STATUS"),
    
    NATURAL_PERSON("NATURAL_PERSON"),
    
    OTHER("OTHER");

    private String value;

    EligibilityTypeEnum(String value) {
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
    public static EligibilityTypeEnum fromValue(String value) {
      for (EligibilityTypeEnum b : EligibilityTypeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  @JsonProperty("eligibilityType")
  private EligibilityTypeEnum eligibilityType;

  @JsonProperty("additionalValue")
  private String additionalValue;

  @JsonProperty("additionalInfo")
  private String additionalInfo;

  @JsonProperty("additionalInfoUri")
  private String additionalInfoUri;

  public BankingProductEligibility eligibilityType(EligibilityTypeEnum eligibilityType) {
    this.eligibilityType = eligibilityType;
    return this;
  }

  /**
   * The type of eligibility criteria described.  See the next section for an overview of valid values and their meaning
   * @return eligibilityType
  */
  @ApiModelProperty(required = true, value = "The type of eligibility criteria described.  See the next section for an overview of valid values and their meaning")
  @NotNull


  public EligibilityTypeEnum getEligibilityType() {
    return eligibilityType;
  }

  public void setEligibilityType(EligibilityTypeEnum eligibilityType) {
    this.eligibilityType = eligibilityType;
  }

  public BankingProductEligibility additionalValue(String additionalValue) {
    this.additionalValue = additionalValue;
    return this;
  }

  /**
   * Generic field containing additional information relevant to the [eligibilityType](#tocSproducteligibilitytypedoc) specified. Whether mandatory or not is dependent on the value of [eligibilityType](#tocSproducteligibilitytypedoc)
   * @return additionalValue
  */
  @ApiModelProperty(value = "Generic field containing additional information relevant to the [eligibilityType](#tocSproducteligibilitytypedoc) specified. Whether mandatory or not is dependent on the value of [eligibilityType](#tocSproducteligibilitytypedoc)")


  public String getAdditionalValue() {
    return additionalValue;
  }

  public void setAdditionalValue(String additionalValue) {
    this.additionalValue = additionalValue;
  }

  public BankingProductEligibility additionalInfo(String additionalInfo) {
    this.additionalInfo = additionalInfo;
    return this;
  }

  /**
   * Display text providing more information on the [eligibility](#tocSproducteligibilitytypedoc) criteria. Mandatory if the field is set to OTHER
   * @return additionalInfo
  */
  @ApiModelProperty(value = "Display text providing more information on the [eligibility](#tocSproducteligibilitytypedoc) criteria. Mandatory if the field is set to OTHER")


  public String getAdditionalInfo() {
    return additionalInfo;
  }

  public void setAdditionalInfo(String additionalInfo) {
    this.additionalInfo = additionalInfo;
  }

  public BankingProductEligibility additionalInfoUri(String additionalInfoUri) {
    this.additionalInfoUri = additionalInfoUri;
    return this;
  }

  /**
   * Link to a web page with more information on this eligibility criteria
   * @return additionalInfoUri
  */
  @ApiModelProperty(value = "Link to a web page with more information on this eligibility criteria")


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
    BankingProductEligibility bankingProductEligibility = (BankingProductEligibility) o;
    return Objects.equals(this.eligibilityType, bankingProductEligibility.eligibilityType) &&
        Objects.equals(this.additionalValue, bankingProductEligibility.additionalValue) &&
        Objects.equals(this.additionalInfo, bankingProductEligibility.additionalInfo) &&
        Objects.equals(this.additionalInfoUri, bankingProductEligibility.additionalInfoUri);
  }

  @Override
  public int hashCode() {
    return Objects.hash(eligibilityType, additionalValue, additionalInfo, additionalInfoUri);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BankingProductEligibility {\n");
    
    sb.append("    eligibilityType: ").append(toIndentedString(eligibilityType)).append("\n");
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

