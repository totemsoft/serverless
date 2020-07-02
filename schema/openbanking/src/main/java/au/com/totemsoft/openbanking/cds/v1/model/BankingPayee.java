package au.com.totemsoft.openbanking.cds.v1.model;

import java.util.Objects;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import io.swagger.annotations.ApiModelProperty;

/**
 * BankingPayee
 */

public class BankingPayee   {
  @JsonProperty("payeeId")
  private String payeeId;

  @JsonProperty("nickname")
  private String nickname;

  @JsonProperty("description")
  private String description;

  /**
   * The type of payee. DOMESTIC means a registered payee for domestic payments including NPP. INTERNATIONAL means a registered payee for international payments. BILLER means a registered payee for BPAY
   */
  public enum TypeEnum {
    DOMESTIC("DOMESTIC"),
    
    INTERNATIONAL("INTERNATIONAL"),
    
    BILLER("BILLER");

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

  @JsonProperty("creationDate")
  private String creationDate;

  public BankingPayee payeeId(String payeeId) {
    this.payeeId = payeeId;
    return this;
  }

  /**
   * ID of the payee adhering to the rules of ID permanence
   * @return payeeId
  */
  @ApiModelProperty(required = true, value = "ID of the payee adhering to the rules of ID permanence")
  @NotNull


  public String getPayeeId() {
    return payeeId;
  }

  public void setPayeeId(String payeeId) {
    this.payeeId = payeeId;
  }

  public BankingPayee nickname(String nickname) {
    this.nickname = nickname;
    return this;
  }

  /**
   * The short display name of the payee as provided by the customer
   * @return nickname
  */
  @ApiModelProperty(required = true, value = "The short display name of the payee as provided by the customer")
  @NotNull


  public String getNickname() {
    return nickname;
  }

  public void setNickname(String nickname) {
    this.nickname = nickname;
  }

  public BankingPayee description(String description) {
    this.description = description;
    return this;
  }

  /**
   * A description of the payee provided by the customer
   * @return description
  */
  @ApiModelProperty(value = "A description of the payee provided by the customer")


  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public BankingPayee type(TypeEnum type) {
    this.type = type;
    return this;
  }

  /**
   * The type of payee. DOMESTIC means a registered payee for domestic payments including NPP. INTERNATIONAL means a registered payee for international payments. BILLER means a registered payee for BPAY
   * @return type
  */
  @ApiModelProperty(required = true, value = "The type of payee. DOMESTIC means a registered payee for domestic payments including NPP. INTERNATIONAL means a registered payee for international payments. BILLER means a registered payee for BPAY")
  @NotNull


  public TypeEnum getType() {
    return type;
  }

  public void setType(TypeEnum type) {
    this.type = type;
  }

  public BankingPayee creationDate(String creationDate) {
    this.creationDate = creationDate;
    return this;
  }

  /**
   * The date the payee was created by the customer
   * @return creationDate
  */
  @ApiModelProperty(value = "The date the payee was created by the customer")


  public String getCreationDate() {
    return creationDate;
  }

  public void setCreationDate(String creationDate) {
    this.creationDate = creationDate;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BankingPayee bankingPayee = (BankingPayee) o;
    return Objects.equals(this.payeeId, bankingPayee.payeeId) &&
        Objects.equals(this.nickname, bankingPayee.nickname) &&
        Objects.equals(this.description, bankingPayee.description) &&
        Objects.equals(this.type, bankingPayee.type) &&
        Objects.equals(this.creationDate, bankingPayee.creationDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(payeeId, nickname, description, type, creationDate);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BankingPayee {\n");
    
    sb.append("    payeeId: ").append(toIndentedString(payeeId)).append("\n");
    sb.append("    nickname: ").append(toIndentedString(nickname)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    creationDate: ").append(toIndentedString(creationDate)).append("\n");
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

