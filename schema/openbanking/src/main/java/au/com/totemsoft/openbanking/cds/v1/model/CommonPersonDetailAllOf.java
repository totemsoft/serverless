package au.com.totemsoft.openbanking.cds.v1.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * CommonPersonDetailAllOf
 */

public class CommonPersonDetailAllOf   {
  @JsonProperty("phoneNumbers")
  @Valid
  private List<CommonPhoneNumber> phoneNumbers = new ArrayList<>();

  @JsonProperty("emailAddresses")
  @Valid
  private List<CommonEmailAddress> emailAddresses = new ArrayList<>();

  @JsonProperty("physicalAddresses")
  @Valid
  private List<CommonPhysicalAddressWithPurpose> physicalAddresses = new ArrayList<>();

  public CommonPersonDetailAllOf phoneNumbers(List<CommonPhoneNumber> phoneNumbers) {
    this.phoneNumbers = phoneNumbers;
    return this;
  }

  public CommonPersonDetailAllOf addPhoneNumbersItem(CommonPhoneNumber phoneNumbersItem) {
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

  public CommonPersonDetailAllOf emailAddresses(List<CommonEmailAddress> emailAddresses) {
    this.emailAddresses = emailAddresses;
    return this;
  }

  public CommonPersonDetailAllOf addEmailAddressesItem(CommonEmailAddress emailAddressesItem) {
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

  public CommonPersonDetailAllOf physicalAddresses(List<CommonPhysicalAddressWithPurpose> physicalAddresses) {
    this.physicalAddresses = physicalAddresses;
    return this;
  }

  public CommonPersonDetailAllOf addPhysicalAddressesItem(CommonPhysicalAddressWithPurpose physicalAddressesItem) {
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
    CommonPersonDetailAllOf commonPersonDetailAllOf = (CommonPersonDetailAllOf) o;
    return Objects.equals(this.phoneNumbers, commonPersonDetailAllOf.phoneNumbers) &&
        Objects.equals(this.emailAddresses, commonPersonDetailAllOf.emailAddresses) &&
        Objects.equals(this.physicalAddresses, commonPersonDetailAllOf.physicalAddresses);
  }

  @Override
  public int hashCode() {
    return Objects.hash(phoneNumbers, emailAddresses, physicalAddresses);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CommonPersonDetailAllOf {\n");
    
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

