package au.com.totemsoft.openbanking.cds.v1.model;

import java.util.Objects;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import io.swagger.annotations.ApiModelProperty;

/**
 * BankingDomesticPayeePayId
 */

public class BankingDomesticPayeePayId   {
  @JsonProperty("name")
  private String name;

  @JsonProperty("identifier")
  private String identifier;

  /**
   * The type of the PayID
   */
  public enum TypeEnum {
    EMAIL("EMAIL"),
    
    TELEPHONE("TELEPHONE"),
    
    ABN("ABN"),
    
    ORG_IDENTIFIER("ORG_IDENTIFIER");

    private String value;

    TypeEnum(String value) {
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
    public static TypeEnum fromValue(String value) {
      for (TypeEnum b : TypeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  @JsonProperty("type")
  private TypeEnum type;

  public BankingDomesticPayeePayId name(String name) {
    this.name = name;
    return this;
  }

  /**
   * The name assigned to the PayID by the owner of the PayID
   * @return name
  */
  @ApiModelProperty(value = "The name assigned to the PayID by the owner of the PayID")


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public BankingDomesticPayeePayId identifier(String identifier) {
    this.identifier = identifier;
    return this;
  }

  /**
   * The identifier of the PayID (dependent on type)
   * @return identifier
  */
  @ApiModelProperty(required = true, value = "The identifier of the PayID (dependent on type)")
  @NotNull


  public String getIdentifier() {
    return identifier;
  }

  public void setIdentifier(String identifier) {
    this.identifier = identifier;
  }

  public BankingDomesticPayeePayId type(TypeEnum type) {
    this.type = type;
    return this;
  }

  /**
   * The type of the PayID
   * @return type
  */
  @ApiModelProperty(required = true, value = "The type of the PayID")
  @NotNull


  public TypeEnum getType() {
    return type;
  }

  public void setType(TypeEnum type) {
    this.type = type;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BankingDomesticPayeePayId bankingDomesticPayeePayId = (BankingDomesticPayeePayId) o;
    return Objects.equals(this.name, bankingDomesticPayeePayId.name) &&
        Objects.equals(this.identifier, bankingDomesticPayeePayId.identifier) &&
        Objects.equals(this.type, bankingDomesticPayeePayId.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, identifier, type);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BankingDomesticPayeePayId {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    identifier: ").append(toIndentedString(identifier)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
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

