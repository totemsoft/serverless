package au.com.totemsoft.elixir.survey.v1.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Location.
 */
@ApiModel(description = "Location.")

public class Location   {
  @JsonProperty("reference")
  private UUID reference;

  @JsonProperty("name")
  private String name;

  @JsonProperty("addresses")
  @Valid
  private List<Address> addresses = null;

  public Location reference(UUID reference) {
    this.reference = reference;
    return this;
  }

  /**
   * Reference (Survey Id)
   * @return reference
  */
  @ApiModelProperty(required = true, value = "Reference (Survey Id)")
  @NotNull

  @Valid

  public UUID getReference() {
    return reference;
  }

  public void setReference(UUID reference) {
    this.reference = reference;
  }

  public Location name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Location name
   * @return name
  */
  @ApiModelProperty(required = true, value = "Location name")
  @NotNull


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Location addresses(List<Address> addresses) {
    this.addresses = addresses;
    return this;
  }

  public Location addAddressesItem(Address addressesItem) {
    if (this.addresses == null) {
      this.addresses = new ArrayList<>();
    }
    this.addresses.add(addressesItem);
    return this;
  }

  /**
   * Location addresses
   * @return addresses
  */
  @ApiModelProperty(value = "Location addresses")

  @Valid

  public List<Address> getAddresses() {
    return addresses;
  }

  public void setAddresses(List<Address> addresses) {
    this.addresses = addresses;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Location location = (Location) o;
    return Objects.equals(this.reference, location.reference) &&
        Objects.equals(this.name, location.name) &&
        Objects.equals(this.addresses, location.addresses);
  }

  @Override
  public int hashCode() {
    return Objects.hash(reference, name, addresses);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Location {\n");
    
    sb.append("    reference: ").append(toIndentedString(reference)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    addresses: ").append(toIndentedString(addresses)).append("\n");
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

