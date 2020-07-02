package au.com.totemsoft.openbanking.cds.v1.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * ResponseBankingDirectDebitAuthorisationListData
 */

public class ResponseBankingDirectDebitAuthorisationListData   {
  @JsonProperty("directDebitAuthorisations")
  @Valid
  private List<BankingDirectDebit> directDebitAuthorisations = new ArrayList<>();

  public ResponseBankingDirectDebitAuthorisationListData directDebitAuthorisations(List<BankingDirectDebit> directDebitAuthorisations) {
    this.directDebitAuthorisations = directDebitAuthorisations;
    return this;
  }

  public ResponseBankingDirectDebitAuthorisationListData addDirectDebitAuthorisationsItem(BankingDirectDebit directDebitAuthorisationsItem) {
    this.directDebitAuthorisations.add(directDebitAuthorisationsItem);
    return this;
  }

  /**
   * The list of authorisations returned
   * @return directDebitAuthorisations
  */
  @ApiModelProperty(required = true, value = "The list of authorisations returned")
  @NotNull

  @Valid

  public List<BankingDirectDebit> getDirectDebitAuthorisations() {
    return directDebitAuthorisations;
  }

  public void setDirectDebitAuthorisations(List<BankingDirectDebit> directDebitAuthorisations) {
    this.directDebitAuthorisations = directDebitAuthorisations;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ResponseBankingDirectDebitAuthorisationListData responseBankingDirectDebitAuthorisationListData = (ResponseBankingDirectDebitAuthorisationListData) o;
    return Objects.equals(this.directDebitAuthorisations, responseBankingDirectDebitAuthorisationListData.directDebitAuthorisations);
  }

  @Override
  public int hashCode() {
    return Objects.hash(directDebitAuthorisations);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ResponseBankingDirectDebitAuthorisationListData {\n");
    
    sb.append("    directDebitAuthorisations: ").append(toIndentedString(directDebitAuthorisations)).append("\n");
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

