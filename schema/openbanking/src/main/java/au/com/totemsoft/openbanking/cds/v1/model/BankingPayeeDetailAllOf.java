package au.com.totemsoft.openbanking.cds.v1.model;

import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import io.swagger.annotations.ApiModelProperty;

/**
 * BankingPayeeDetailAllOf
 */

public class BankingPayeeDetailAllOf   {
  /**
   * Type of object included that describes the payee in detail
   */
  public enum PayeeUTypeEnum {
    DOMESTIC("domestic"),
    
    BILLER("biller"),
    
    INTERNATIONAL("international");

    private String value;

    PayeeUTypeEnum(String value) {
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
    public static PayeeUTypeEnum fromValue(String value) {
      for (PayeeUTypeEnum b : PayeeUTypeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  @JsonProperty("payeeUType")
  private PayeeUTypeEnum payeeUType;

  @JsonProperty("domestic")
  private BankingDomesticPayee domestic;

  @JsonProperty("biller")
  private BankingBillerPayee biller;

  @JsonProperty("international")
  private BankingInternationalPayee international;

  public BankingPayeeDetailAllOf payeeUType(PayeeUTypeEnum payeeUType) {
    this.payeeUType = payeeUType;
    return this;
  }

  /**
   * Type of object included that describes the payee in detail
   * @return payeeUType
  */
  @ApiModelProperty(required = true, value = "Type of object included that describes the payee in detail")
  @NotNull


  public PayeeUTypeEnum getPayeeUType() {
    return payeeUType;
  }

  public void setPayeeUType(PayeeUTypeEnum payeeUType) {
    this.payeeUType = payeeUType;
  }

  public BankingPayeeDetailAllOf domestic(BankingDomesticPayee domestic) {
    this.domestic = domestic;
    return this;
  }

  /**
   * Get domestic
   * @return domestic
  */
  @ApiModelProperty(value = "")

  @Valid

  public BankingDomesticPayee getDomestic() {
    return domestic;
  }

  public void setDomestic(BankingDomesticPayee domestic) {
    this.domestic = domestic;
  }

  public BankingPayeeDetailAllOf biller(BankingBillerPayee biller) {
    this.biller = biller;
    return this;
  }

  /**
   * Get biller
   * @return biller
  */
  @ApiModelProperty(value = "")

  @Valid

  public BankingBillerPayee getBiller() {
    return biller;
  }

  public void setBiller(BankingBillerPayee biller) {
    this.biller = biller;
  }

  public BankingPayeeDetailAllOf international(BankingInternationalPayee international) {
    this.international = international;
    return this;
  }

  /**
   * Get international
   * @return international
  */
  @ApiModelProperty(value = "")

  @Valid

  public BankingInternationalPayee getInternational() {
    return international;
  }

  public void setInternational(BankingInternationalPayee international) {
    this.international = international;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BankingPayeeDetailAllOf bankingPayeeDetailAllOf = (BankingPayeeDetailAllOf) o;
    return Objects.equals(this.payeeUType, bankingPayeeDetailAllOf.payeeUType) &&
        Objects.equals(this.domestic, bankingPayeeDetailAllOf.domestic) &&
        Objects.equals(this.biller, bankingPayeeDetailAllOf.biller) &&
        Objects.equals(this.international, bankingPayeeDetailAllOf.international);
  }

  @Override
  public int hashCode() {
    return Objects.hash(payeeUType, domestic, biller, international);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BankingPayeeDetailAllOf {\n");
    
    sb.append("    payeeUType: ").append(toIndentedString(payeeUType)).append("\n");
    sb.append("    domestic: ").append(toIndentedString(domestic)).append("\n");
    sb.append("    biller: ").append(toIndentedString(biller)).append("\n");
    sb.append("    international: ").append(toIndentedString(international)).append("\n");
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

