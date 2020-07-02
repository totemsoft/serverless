package au.com.totemsoft.openbanking.cds.v1.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * CommonPersonDetail
 */

public class CommonPersonDetail   {
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

  @JsonProperty("phoneNumbers")
  @Valid
  private List<CommonPhoneNumber> phoneNumbers = new ArrayList<>();

  @JsonProperty("emailAddresses")
  @Valid
  private List<CommonEmailAddress> emailAddresses = new ArrayList<>();

  @JsonProperty("physicalAddresses")
  @Valid
  private List<CommonPhysicalAddressWithPurpose> physicalAddresses = new ArrayList<>();

  public CommonPersonDetail lastUpdateTime(String lastUpdateTime) {
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

  public CommonPersonDetail firstName(String firstName) {
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

  public CommonPersonDetail lastName(String lastName) {
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

  public CommonPersonDetail middleNames(List<String> middleNames) {
    this.middleNames = middleNames;
    return this;
  }

  public CommonPersonDetail addMiddleNamesItem(String middleNamesItem) {
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

  public CommonPersonDetail prefix(String prefix) {
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

  public CommonPersonDetail suffix(String suffix) {
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

  public CommonPersonDetail occupationCode(String occupationCode) {
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

  public CommonPersonDetail phoneNumbers(List<CommonPhoneNumber> phoneNumbers) {
    this.phoneNumbers = phoneNumbers;
    return this;
  }

  public CommonPersonDetail addPhoneNumbersItem(CommonPhoneNumber phoneNumbersItem) {
    this.phoneNumbers.add(phoneNumbersItem);
    return this;
  }

  /**
   * Array is mandatory but may be empty if no phone numbers are held
   * @return phoneNumbers
  */
  @ApiModelProperty(required = true, value = "Array is mandatory but may be empty if no phone numbers are held")
  @NotNull

  @Valid

  public List<CommonPhoneNumber> getPhoneNumbers() {
    return phoneNumbers;
  }

  public void setPhoneNumbers(List<CommonPhoneNumber> phoneNumbers) {
    this.phoneNumbers = phoneNumbers;
  }

  public CommonPersonDetail emailAddresses(List<CommonEmailAddress> emailAddresses) {
    this.emailAddresses = emailAddresses;
    return this;
  }

  public CommonPersonDetail addEmailAddressesItem(CommonEmailAddress emailAddressesItem) {
    this.emailAddresses.add(emailAddressesItem);
    return this;
  }

  /**
   * May be empty
   * @return emailAddresses
  */
  @ApiModelProperty(required = true, value = "May be empty")
  @NotNull

  @Valid

  public List<CommonEmailAddress> getEmailAddresses() {
    return emailAddresses;
  }

  public void setEmailAddresses(List<CommonEmailAddress> emailAddresses) {
    this.emailAddresses = emailAddresses;
  }

  public CommonPersonDetail physicalAddresses(List<CommonPhysicalAddressWithPurpose> physicalAddresses) {
    this.physicalAddresses = physicalAddresses;
    return this;
  }

  public CommonPersonDetail addPhysicalAddressesItem(CommonPhysicalAddressWithPurpose physicalAddressesItem) {
    this.physicalAddresses.add(physicalAddressesItem);
    return this;
  }

  /**
   * Must contain at least one address. One and only one address may have the purpose of REGISTERED. Zero or one, and no more than one, record may have the purpose of MAIL. If zero then the REGISTERED address is to be used for mail
   * @return physicalAddresses
  */
  @ApiModelProperty(required = true, value = "Must contain at least one address. One and only one address may have the purpose of REGISTERED. Zero or one, and no more than one, record may have the purpose of MAIL. If zero then the REGISTERED address is to be used for mail")
  @NotNull

  @Valid

  public List<CommonPhysicalAddressWithPurpose> getPhysicalAddresses() {
    return physicalAddresses;
  }

  public void setPhysicalAddresses(List<CommonPhysicalAddressWithPurpose> physicalAddresses) {
    this.physicalAddresses = physicalAddresses;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CommonPersonDetail commonPersonDetail = (CommonPersonDetail) o;
    return Objects.equals(this.lastUpdateTime, commonPersonDetail.lastUpdateTime) &&
        Objects.equals(this.firstName, commonPersonDetail.firstName) &&
        Objects.equals(this.lastName, commonPersonDetail.lastName) &&
        Objects.equals(this.middleNames, commonPersonDetail.middleNames) &&
        Objects.equals(this.prefix, commonPersonDetail.prefix) &&
        Objects.equals(this.suffix, commonPersonDetail.suffix) &&
        Objects.equals(this.occupationCode, commonPersonDetail.occupationCode) &&
        Objects.equals(this.phoneNumbers, commonPersonDetail.phoneNumbers) &&
        Objects.equals(this.emailAddresses, commonPersonDetail.emailAddresses) &&
        Objects.equals(this.physicalAddresses, commonPersonDetail.physicalAddresses);
  }

  @Override
  public int hashCode() {
    return Objects.hash(lastUpdateTime, firstName, lastName, middleNames, prefix, suffix, occupationCode, phoneNumbers, emailAddresses, physicalAddresses);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CommonPersonDetail {\n");
    
    sb.append("    lastUpdateTime: ").append(toIndentedString(lastUpdateTime)).append("\n");
    sb.append("    firstName: ").append(toIndentedString(firstName)).append("\n");
    sb.append("    lastName: ").append(toIndentedString(lastName)).append("\n");
    sb.append("    middleNames: ").append(toIndentedString(middleNames)).append("\n");
    sb.append("    prefix: ").append(toIndentedString(prefix)).append("\n");
    sb.append("    suffix: ").append(toIndentedString(suffix)).append("\n");
    sb.append("    occupationCode: ").append(toIndentedString(occupationCode)).append("\n");
    sb.append("    phoneNumbers: ").append(toIndentedString(phoneNumbers)).append("\n");
    sb.append("    emailAddresses: ").append(toIndentedString(emailAddresses)).append("\n");
    sb.append("    physicalAddresses: ").append(toIndentedString(physicalAddresses)).append("\n");
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

