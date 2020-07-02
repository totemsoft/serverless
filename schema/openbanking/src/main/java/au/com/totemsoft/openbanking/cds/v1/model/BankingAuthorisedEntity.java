package au.com.totemsoft.openbanking.cds.v1.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * BankingAuthorisedEntity
 */

public class BankingAuthorisedEntity   {
  @JsonProperty("description")
  private String description;

  @JsonProperty("financialInstitution")
  private String financialInstitution;

  @JsonProperty("abn")
  private String abn;

  @JsonProperty("acn")
  private String acn;

  @JsonProperty("arbn")
  private String arbn;

  public BankingAuthorisedEntity description(String description) {
    this.description = description;
    return this;
  }

  /**
   * Description of the authorised entity derived from previously executed direct debits
   * @return description
  */
  @ApiModelProperty(value = "Description of the authorised entity derived from previously executed direct debits")


  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public BankingAuthorisedEntity financialInstitution(String financialInstitution) {
    this.financialInstitution = financialInstitution;
    return this;
  }

  /**
   * Name of the financial institution through which the direct debit will be executed. Is required unless the payment is made via a credit card scheme
   * @return financialInstitution
  */
  @ApiModelProperty(value = "Name of the financial institution through which the direct debit will be executed. Is required unless the payment is made via a credit card scheme")


  public String getFinancialInstitution() {
    return financialInstitution;
  }

  public void setFinancialInstitution(String financialInstitution) {
    this.financialInstitution = financialInstitution;
  }

  public BankingAuthorisedEntity abn(String abn) {
    this.abn = abn;
    return this;
  }

  /**
   * Australian Business Number for the authorised entity
   * @return abn
  */
  @ApiModelProperty(value = "Australian Business Number for the authorised entity")


  public String getAbn() {
    return abn;
  }

  public void setAbn(String abn) {
    this.abn = abn;
  }

  public BankingAuthorisedEntity acn(String acn) {
    this.acn = acn;
    return this;
  }

  /**
   * Australian Company Number for the authorised entity
   * @return acn
  */
  @ApiModelProperty(value = "Australian Company Number for the authorised entity")


  public String getAcn() {
    return acn;
  }

  public void setAcn(String acn) {
    this.acn = acn;
  }

  public BankingAuthorisedEntity arbn(String arbn) {
    this.arbn = arbn;
    return this;
  }

  /**
   * Australian Registered Body Number for the authorised entity
   * @return arbn
  */
  @ApiModelProperty(value = "Australian Registered Body Number for the authorised entity")


  public String getArbn() {
    return arbn;
  }

  public void setArbn(String arbn) {
    this.arbn = arbn;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BankingAuthorisedEntity bankingAuthorisedEntity = (BankingAuthorisedEntity) o;
    return Objects.equals(this.description, bankingAuthorisedEntity.description) &&
        Objects.equals(this.financialInstitution, bankingAuthorisedEntity.financialInstitution) &&
        Objects.equals(this.abn, bankingAuthorisedEntity.abn) &&
        Objects.equals(this.acn, bankingAuthorisedEntity.acn) &&
        Objects.equals(this.arbn, bankingAuthorisedEntity.arbn);
  }

  @Override
  public int hashCode() {
    return Objects.hash(description, financialInstitution, abn, acn, arbn);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BankingAuthorisedEntity {\n");
    
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    financialInstitution: ").append(toIndentedString(financialInstitution)).append("\n");
    sb.append("    abn: ").append(toIndentedString(abn)).append("\n");
    sb.append("    acn: ").append(toIndentedString(acn)).append("\n");
    sb.append("    arbn: ").append(toIndentedString(arbn)).append("\n");
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

