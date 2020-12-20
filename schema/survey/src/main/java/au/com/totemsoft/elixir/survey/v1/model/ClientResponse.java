package au.com.totemsoft.elixir.survey.v1.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Client details
 */
@ApiModel(description = "Client details")

public class ClientResponse   {
  @JsonProperty("company")
  private String company;

  @JsonProperty("tradingName")
  private String tradingName;

  @JsonProperty("firstName")
  private String firstName;

  @JsonProperty("lastName")
  private String lastName;

  @JsonProperty("email")
  private String email;

  @JsonProperty("position")
  private String position;

  @JsonProperty("phones")
  @Valid
  private List<Phone> phones = null;

  @JsonProperty("addresses")
  @Valid
  private List<Address> addresses = null;

  @JsonProperty("locations")
  @Valid
  private List<Location> locations = null;

  @JsonProperty("requestedBy")
  private String requestedBy;

  public ClientResponse company(String company) {
    this.company = company;
    return this;
  }

  /**
   * Client's company name (has to be unique)
   * @return company
  */
  @ApiModelProperty(required = true, value = "Client's company name (has to be unique)")
  @NotNull


  public String getCompany() {
    return company;
  }

  public void setCompany(String company) {
    this.company = company;
  }

  public ClientResponse tradingName(String tradingName) {
    this.tradingName = tradingName;
    return this;
  }

  /**
   * Client's trading name
   * @return tradingName
  */
  @ApiModelProperty(value = "Client's trading name")


  public String getTradingName() {
    return tradingName;
  }

  public void setTradingName(String tradingName) {
    this.tradingName = tradingName;
  }

  public ClientResponse firstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  /**
   * Client's firstname
   * @return firstName
  */
  @ApiModelProperty(required = true, value = "Client's firstname")
  @NotNull


  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public ClientResponse lastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  /**
   * Client's surname
   * @return lastName
  */
  @ApiModelProperty(required = true, value = "Client's surname")
  @NotNull


  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public ClientResponse email(String email) {
    this.email = email;
    return this;
  }

  /**
   * Client's email
   * @return email
  */
  @ApiModelProperty(required = true, value = "Client's email")
  @NotNull


  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public ClientResponse position(String position) {
    this.position = position;
    return this;
  }

  /**
   * Client's position
   * @return position
  */
  @ApiModelProperty(value = "Client's position")


  public String getPosition() {
    return position;
  }

  public void setPosition(String position) {
    this.position = position;
  }

  public ClientResponse phones(List<Phone> phones) {
    this.phones = phones;
    return this;
  }

  public ClientResponse addPhonesItem(Phone phonesItem) {
    if (this.phones == null) {
      this.phones = new ArrayList<>();
    }
    this.phones.add(phonesItem);
    return this;
  }

  /**
   * Client's phones
   * @return phones
  */
  @ApiModelProperty(value = "Client's phones")

  @Valid

  public List<Phone> getPhones() {
    return phones;
  }

  public void setPhones(List<Phone> phones) {
    this.phones = phones;
  }

  public ClientResponse addresses(List<Address> addresses) {
    this.addresses = addresses;
    return this;
  }

  public ClientResponse addAddressesItem(Address addressesItem) {
    if (this.addresses == null) {
      this.addresses = new ArrayList<>();
    }
    this.addresses.add(addressesItem);
    return this;
  }

  /**
   * Client's addresses
   * @return addresses
  */
  @ApiModelProperty(value = "Client's addresses")

  @Valid

  public List<Address> getAddresses() {
    return addresses;
  }

  public void setAddresses(List<Address> addresses) {
    this.addresses = addresses;
  }

  public ClientResponse locations(List<Location> locations) {
    this.locations = locations;
    return this;
  }

  public ClientResponse addLocationsItem(Location locationsItem) {
    if (this.locations == null) {
      this.locations = new ArrayList<>();
    }
    this.locations.add(locationsItem);
    return this;
  }

  /**
   * Client's locations
   * @return locations
  */
  @ApiModelProperty(value = "Client's locations")

  @Valid

  public List<Location> getLocations() {
    return locations;
  }

  public void setLocations(List<Location> locations) {
    this.locations = locations;
  }

  public ClientResponse requestedBy(String requestedBy) {
    this.requestedBy = requestedBy;
    return this;
  }

  /**
   * Requested by (usually JWT Payload sub)
   * @return requestedBy
  */
  @ApiModelProperty(value = "Requested by (usually JWT Payload sub)")


  public String getRequestedBy() {
    return requestedBy;
  }

  public void setRequestedBy(String requestedBy) {
    this.requestedBy = requestedBy;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ClientResponse clientResponse = (ClientResponse) o;
    return Objects.equals(this.company, clientResponse.company) &&
        Objects.equals(this.tradingName, clientResponse.tradingName) &&
        Objects.equals(this.firstName, clientResponse.firstName) &&
        Objects.equals(this.lastName, clientResponse.lastName) &&
        Objects.equals(this.email, clientResponse.email) &&
        Objects.equals(this.position, clientResponse.position) &&
        Objects.equals(this.phones, clientResponse.phones) &&
        Objects.equals(this.addresses, clientResponse.addresses) &&
        Objects.equals(this.locations, clientResponse.locations) &&
        Objects.equals(this.requestedBy, clientResponse.requestedBy);
  }

  @Override
  public int hashCode() {
    return Objects.hash(company, tradingName, firstName, lastName, email, position, phones, addresses, locations, requestedBy);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ClientResponse {\n");
    
    sb.append("    company: ").append(toIndentedString(company)).append("\n");
    sb.append("    tradingName: ").append(toIndentedString(tradingName)).append("\n");
    sb.append("    firstName: ").append(toIndentedString(firstName)).append("\n");
    sb.append("    lastName: ").append(toIndentedString(lastName)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    position: ").append(toIndentedString(position)).append("\n");
    sb.append("    phones: ").append(toIndentedString(phones)).append("\n");
    sb.append("    addresses: ").append(toIndentedString(addresses)).append("\n");
    sb.append("    locations: ").append(toIndentedString(locations)).append("\n");
    sb.append("    requestedBy: ").append(toIndentedString(requestedBy)).append("\n");
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

