package au.com.totemsoft.openbanking.cds.v1.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * CommonPerson
 */

public class CommonPerson   {
  @JsonProperty("lastUpdateTime")
  private String lastUpdateTime;

  @JsonProperty("firstName")
  private String firstName;

  @JsonProperty("lastName")
  private String lastName;

  @JsonProperty("middleNames")
  @Valid
  private List<String> middleNames = new ArrayList<>();

  @JsonProperty("prefix")
  private String prefix;

  @JsonProperty("suffix")
  private String suffix;

  @JsonProperty("occupationCode")
  private String occupationCode;

  public CommonPerson lastUpdateTime(String lastUpdateTime) {
    this.lastUpdateTime = lastUpdateTime;
    return this;
  }

  /**
   * The date and time that this record was last updated by the customer.  If no update has occurred then this date should reflect the initial creation date for the data
   * @return lastUpdateTime
  */
  @ApiModelProperty(value = "The date and time that this record was last updated by the customer.  If no update has occurred then this date should reflect the initial creation date for the data")


  public String getLastUpdateTime() {
    return lastUpdateTime;
  }

  public void setLastUpdateTime(String lastUpdateTime) {
    this.lastUpdateTime = lastUpdateTime;
  }

  public CommonPerson firstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  /**
   * For people with single names this field need not be present.  The single name should be in the lastName field
   * @return firstName
  */
  @ApiModelProperty(value = "For people with single names this field need not be present.  The single name should be in the lastName field")


  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public CommonPerson lastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  /**
   * For people with single names the single name should be in this field
   * @return lastName
  */
  @ApiModelProperty(required = true, value = "For people with single names the single name should be in this field")
  @NotNull


  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public CommonPerson middleNames(List<String> middleNames) {
    this.middleNames = middleNames;
    return this;
  }

  public CommonPerson addMiddleNamesItem(String middleNamesItem) {
    this.middleNames.add(middleNamesItem);
    return this;
  }

  /**
   * Field is mandatory but array may be empty
   * @return middleNames
  */
  @ApiModelProperty(required = true, value = "Field is mandatory but array may be empty")
  @NotNull


  public List<String> getMiddleNames() {
    return middleNames;
  }

  public void setMiddleNames(List<String> middleNames) {
    this.middleNames = middleNames;
  }

  public CommonPerson prefix(String prefix) {
    this.prefix = prefix;
    return this;
  }

  /**
   * Also known as title or salutation.  The prefix to the name (e.g. Mr, Mrs, Ms, Miss, Sir, etc)
   * @return prefix
  */
  @ApiModelProperty(value = "Also known as title or salutation.  The prefix to the name (e.g. Mr, Mrs, Ms, Miss, Sir, etc)")


  public String getPrefix() {
    return prefix;
  }

  public void setPrefix(String prefix) {
    this.prefix = prefix;
  }

  public CommonPerson suffix(String suffix) {
    this.suffix = suffix;
    return this;
  }

  /**
   * Used for a trailing suffix to the name (e.g. Jr)
   * @return suffix
  */
  @ApiModelProperty(value = "Used for a trailing suffix to the name (e.g. Jr)")


  public String getSuffix() {
    return suffix;
  }

  public void setSuffix(String suffix) {
    this.suffix = suffix;
  }

  public CommonPerson occupationCode(String occupationCode) {
    this.occupationCode = occupationCode;
    return this;
  }

  /**
   * Value is a valid [ANZSCO v1.2](http://www.abs.gov.au/ANZSCO) Standard Occupation classification.
   * @return occupationCode
  */
  @ApiModelProperty(value = "Value is a valid [ANZSCO v1.2](http://www.abs.gov.au/ANZSCO) Standard Occupation classification.")


  public String getOccupationCode() {
    return occupationCode;
  }

  public void setOccupationCode(String occupationCode) {
    this.occupationCode = occupationCode;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CommonPerson commonPerson = (CommonPerson) o;
    return Objects.equals(this.lastUpdateTime, commonPerson.lastUpdateTime) &&
        Objects.equals(this.firstName, commonPerson.firstName) &&
        Objects.equals(this.lastName, commonPerson.lastName) &&
        Objects.equals(this.middleNames, commonPerson.middleNames) &&
        Objects.equals(this.prefix, commonPerson.prefix) &&
        Objects.equals(this.suffix, commonPerson.suffix) &&
        Objects.equals(this.occupationCode, commonPerson.occupationCode);
  }

  @Override
  public int hashCode() {
    return Objects.hash(lastUpdateTime, firstName, lastName, middleNames, prefix, suffix, occupationCode);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CommonPerson {\n");
    
    sb.append("    lastUpdateTime: ").append(toIndentedString(lastUpdateTime)).append("\n");
    sb.append("    firstName: ").append(toIndentedString(firstName)).append("\n");
    sb.append("    lastName: ").append(toIndentedString(lastName)).append("\n");
    sb.append("    middleNames: ").append(toIndentedString(middleNames)).append("\n");
    sb.append("    prefix: ").append(toIndentedString(prefix)).append("\n");
    sb.append("    suffix: ").append(toIndentedString(suffix)).append("\n");
    sb.append("    occupationCode: ").append(toIndentedString(occupationCode)).append("\n");
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

