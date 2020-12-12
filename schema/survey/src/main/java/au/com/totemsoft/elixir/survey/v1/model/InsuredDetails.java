package au.com.totemsoft.elixir.survey.v1.model;

import java.util.Objects;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Insured details
 */
@ApiModel(description = "Insured details")

public class InsuredDetails   {
  @JsonProperty("firstname")
  private String firstname;

  @JsonProperty("surname")
  private String surname;

  @JsonProperty("mobile")
  private String mobile;

  @JsonProperty("email")
  private String email;

  @JsonProperty("companyName")
  private String companyName;

  @JsonProperty("tradingName")
  private String tradingName;

  @JsonProperty("position")
  private String position;

  public InsuredDetails firstname(String firstname) {
    this.firstname = firstname;
    return this;
  }

  /**
   * Insured name
   * @return firstname
  */
  @ApiModelProperty(value = "Insured name")


  public String getFirstname() {
    return firstname;
  }

  public void setFirstname(String firstname) {
    this.firstname = firstname;
  }

  public InsuredDetails surname(String surname) {
    this.surname = surname;
    return this;
  }

  /**
   * Insured surname
   * @return surname
  */
  @ApiModelProperty(value = "Insured surname")


  public String getSurname() {
    return surname;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }

  public InsuredDetails mobile(String mobile) {
    this.mobile = mobile;
    return this;
  }

  /**
   * Insured mobile
   * @return mobile
  */
  @ApiModelProperty(value = "Insured mobile")


  public String getMobile() {
    return mobile;
  }

  public void setMobile(String mobile) {
    this.mobile = mobile;
  }

  public InsuredDetails email(String email) {
    this.email = email;
    return this;
  }

  /**
   * Insured email
   * @return email
  */
  @ApiModelProperty(required = true, value = "Insured email")
  @NotNull


  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public InsuredDetails companyName(String companyName) {
    this.companyName = companyName;
    return this;
  }

  /**
   * Insured company name
   * @return companyName
  */
  @ApiModelProperty(value = "Insured company name")


  public String getCompanyName() {
    return companyName;
  }

  public void setCompanyName(String companyName) {
    this.companyName = companyName;
  }

  public InsuredDetails tradingName(String tradingName) {
    this.tradingName = tradingName;
    return this;
  }

  /**
   * Insured trading name
   * @return tradingName
  */
  @ApiModelProperty(value = "Insured trading name")


  public String getTradingName() {
    return tradingName;
  }

  public void setTradingName(String tradingName) {
    this.tradingName = tradingName;
  }

  public InsuredDetails position(String position) {
    this.position = position;
    return this;
  }

  /**
   * Insured position
   * @return position
  */
  @ApiModelProperty(value = "Insured position")


  public String getPosition() {
    return position;
  }

  public void setPosition(String position) {
    this.position = position;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    InsuredDetails insuredDetails = (InsuredDetails) o;
    return Objects.equals(this.firstname, insuredDetails.firstname) &&
        Objects.equals(this.surname, insuredDetails.surname) &&
        Objects.equals(this.mobile, insuredDetails.mobile) &&
        Objects.equals(this.email, insuredDetails.email) &&
        Objects.equals(this.companyName, insuredDetails.companyName) &&
        Objects.equals(this.tradingName, insuredDetails.tradingName) &&
        Objects.equals(this.position, insuredDetails.position);
  }

  @Override
  public int hashCode() {
    return Objects.hash(firstname, surname, mobile, email, companyName, tradingName, position);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InsuredDetails {\n");
    
    sb.append("    firstname: ").append(toIndentedString(firstname)).append("\n");
    sb.append("    surname: ").append(toIndentedString(surname)).append("\n");
    sb.append("    mobile: ").append(toIndentedString(mobile)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    companyName: ").append(toIndentedString(companyName)).append("\n");
    sb.append("    tradingName: ").append(toIndentedString(tradingName)).append("\n");
    sb.append("    position: ").append(toIndentedString(position)).append("\n");
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

