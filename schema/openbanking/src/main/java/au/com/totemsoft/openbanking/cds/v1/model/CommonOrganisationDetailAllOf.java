package au.com.totemsoft.openbanking.cds.v1.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * CommonOrganisationDetailAllOf
 */

public class CommonOrganisationDetailAllOf   {
  @JsonProperty("physicalAddresses")
  @Valid
  private List<CommonPhysicalAddressWithPurpose> physicalAddresses = new ArrayList<>();

  public CommonOrganisationDetailAllOf physicalAddresses(List<CommonPhysicalAddressWithPurpose> physicalAddresses) {
    this.physicalAddresses = physicalAddresses;
    return this;
  }

  public CommonOrganisationDetailAllOf addPhysicalAddressesItem(CommonPhysicalAddressWithPurpose physicalAddressesItem) {
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
    CommonOrganisationDetailAllOf commonOrganisationDetailAllOf = (CommonOrganisationDetailAllOf) o;
    return Objects.equals(this.physicalAddresses, commonOrganisationDetailAllOf.physicalAddresses);
  }

  @Override
  public int hashCode() {
    return Objects.hash(physicalAddresses);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CommonOrganisationDetailAllOf {\n");
    
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

