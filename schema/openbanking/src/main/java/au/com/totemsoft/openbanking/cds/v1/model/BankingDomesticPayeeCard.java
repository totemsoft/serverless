package au.com.totemsoft.openbanking.cds.v1.model;

import java.util.Objects;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * BankingDomesticPayeeCard
 */

public class BankingDomesticPayeeCard   {
  @JsonProperty("cardNumber")
  private String cardNumber;

  public BankingDomesticPayeeCard cardNumber(String cardNumber) {
    this.cardNumber = cardNumber;
    return this;
  }

  /**
   * Name of the account to pay to
   * @return cardNumber
  */
  @ApiModelProperty(required = true, value = "Name of the account to pay to")
  @NotNull


  public String getCardNumber() {
    return cardNumber;
  }

  public void setCardNumber(String cardNumber) {
    this.cardNumber = cardNumber;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BankingDomesticPayeeCard bankingDomesticPayeeCard = (BankingDomesticPayeeCard) o;
    return Objects.equals(this.cardNumber, bankingDomesticPayeeCard.cardNumber);
  }

  @Override
  public int hashCode() {
    return Objects.hash(cardNumber);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BankingDomesticPayeeCard {\n");
    
    sb.append("    cardNumber: ").append(toIndentedString(cardNumber)).append("\n");
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

