package au.com.totemsoft.openbanking.cds.v1.model;

import java.util.Objects;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import io.swagger.annotations.ApiModelProperty;

/**
 * BankingProductConstraint
 */

public class BankingProductConstraint   {
  /**
   * The type of constraint described.  See the next section for an overview of valid values and their meaning
   */
  public enum ConstraintTypeEnum {
    MIN_BALANCE("MIN_BALANCE"),
    
    MAX_BALANCE("MAX_BALANCE"),
    
    OPENING_BALANCE("OPENING_BALANCE"),
    
    MAX_LIMIT("MAX_LIMIT"),
    
    MIN_LIMIT("MIN_LIMIT");

    private String value;

    ConstraintTypeEnum(String value) {
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
    public static ConstraintTypeEnum fromValue(String value) {
      for (ConstraintTypeEnum b : ConstraintTypeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  @JsonProperty("constraintType")
  private ConstraintTypeEnum constraintType;

  @JsonProperty("additionalValue")
  private String additionalValue;

  @JsonProperty("additionalInfo")
  private String additionalInfo;

  @JsonProperty("additionalInfoUri")
  private String additionalInfoUri;

  public BankingProductConstraint constraintType(ConstraintTypeEnum constraintType) {
    this.constraintType = constraintType;
    return this;
  }

  /**
   * The type of constraint described.  See the next section for an overview of valid values and their meaning
   * @return constraintType
  */
  @ApiModelProperty(required = true, value = "The type of constraint described.  See the next section for an overview of valid values and their meaning")
  @NotNull


  public ConstraintTypeEnum getConstraintType() {
    return constraintType;
  }

  public void setConstraintType(ConstraintTypeEnum constraintType) {
    this.constraintType = constraintType;
  }

  public BankingProductConstraint additionalValue(String additionalValue) {
    this.additionalValue = additionalValue;
    return this;
  }

  /**
   * Generic field containing additional information relevant to the [constraintType](#tocSproductconstrainttypedoc) specified.  Whether mandatory or not is dependent on the value of [constraintType](#tocSproductconstrainttypedoc)
   * @return additionalValue
  */
  @ApiModelProperty(value = "Generic field containing additional information relevant to the [constraintType](#tocSproductconstrainttypedoc) specified.  Whether mandatory or not is dependent on the value of [constraintType](#tocSproductconstrainttypedoc)")


  public String getAdditionalValue() {
    return additionalValue;
  }

  public void setAdditionalValue(String additionalValue) {
    this.additionalValue = additionalValue;
  }

  public BankingProductConstraint additionalInfo(String additionalInfo) {
    this.additionalInfo = additionalInfo;
    return this;
  }

  /**
   * Display text providing more information the constraint
   * @return additionalInfo
  */
  @ApiModelProperty(value = "Display text providing more information the constraint")


  public String getAdditionalInfo() {
    return additionalInfo;
  }

  public void setAdditionalInfo(String additionalInfo) {
    this.additionalInfo = additionalInfo;
  }

  public BankingProductConstraint additionalInfoUri(String additionalInfoUri) {
    this.additionalInfoUri = additionalInfoUri;
    return this;
  }

  /**
   * Link to a web page with more information on the constraint
   * @return additionalInfoUri
  */
  @ApiModelProperty(value = "Link to a web page with more information on the constraint")


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
    BankingProductConstraint bankingProductConstraint = (BankingProductConstraint) o;
    return Objects.equals(this.constraintType, bankingProductConstraint.constraintType) &&
        Objects.equals(this.additionalValue, bankingProductConstraint.additionalValue) &&
        Objects.equals(this.additionalInfo, bankingProductConstraint.additionalInfo) &&
        Objects.equals(this.additionalInfoUri, bankingProductConstraint.additionalInfoUri);
  }

  @Override
  public int hashCode() {
    return Objects.hash(constraintType, additionalValue, additionalInfo, additionalInfoUri);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BankingProductConstraint {\n");
    
    sb.append("    constraintType: ").append(toIndentedString(constraintType)).append("\n");
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

