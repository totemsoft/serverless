package au.com.totemsoft.openbanking.cds.v1.model;

import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import io.swagger.annotations.ApiModelProperty;

/**
 * ResponseCommonCustomerDetailData
 */

public class ResponseCommonCustomerDetailData   {
  /**
   * The type of customer object that is present
   */
  public enum CustomerUTypeEnum {
    PERSON("person"),
    
    ORGANISATION("organisation");

    private String value;

    CustomerUTypeEnum(String value) {
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
    public static CustomerUTypeEnum fromValue(String value) {
      for (CustomerUTypeEnum b : CustomerUTypeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  @JsonProperty("customerUType")
  private CustomerUTypeEnum customerUType;

  @JsonProperty("person")
  private CommonPersonDetail person = null;

  @JsonProperty("organisation")
  private CommonOrganisationDetail organisation = null;

  public ResponseCommonCustomerDetailData customerUType(CustomerUTypeEnum customerUType) {
    this.customerUType = customerUType;
    return this;
  }

  /**
   * The type of customer object that is present
   * @return customerUType
  */
  @ApiModelProperty(required = true, value = "The type of customer object that is present")
  @NotNull


  public CustomerUTypeEnum getCustomerUType() {
    return customerUType;
  }

  public void setCustomerUType(CustomerUTypeEnum customerUType) {
    this.customerUType = customerUType;
  }

  public ResponseCommonCustomerDetailData person(CommonPersonDetail person) {
    this.person = person;
    return this;
  }

  /**
   * Get person
   * @return person
  */
  @ApiModelProperty(value = "")

  @Valid

  public CommonPersonDetail getPerson() {
    return person;
  }

  public void setPerson(CommonPersonDetail person) {
    this.person = person;
  }

  public ResponseCommonCustomerDetailData organisation(CommonOrganisationDetail organisation) {
    this.organisation = organisation;
    return this;
  }

  /**
   * Get organisation
   * @return organisation
  */
  @ApiModelProperty(value = "")

  @Valid

  public CommonOrganisationDetail getOrganisation() {
    return organisation;
  }

  public void setOrganisation(CommonOrganisationDetail organisation) {
    this.organisation = organisation;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ResponseCommonCustomerDetailData responseCommonCustomerDetailData = (ResponseCommonCustomerDetailData) o;
    return Objects.equals(this.customerUType, responseCommonCustomerDetailData.customerUType) &&
        Objects.equals(this.person, responseCommonCustomerDetailData.person) &&
        Objects.equals(this.organisation, responseCommonCustomerDetailData.organisation);
  }

  @Override
  public int hashCode() {
    return Objects.hash(customerUType, person, organisation);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ResponseCommonCustomerDetailData {\n");
    
    sb.append("    customerUType: ").append(toIndentedString(customerUType)).append("\n");
    sb.append("    person: ").append(toIndentedString(person)).append("\n");
    sb.append("    organisation: ").append(toIndentedString(organisation)).append("\n");
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

