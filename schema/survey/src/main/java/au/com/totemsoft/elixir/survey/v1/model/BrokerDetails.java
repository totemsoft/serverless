package au.com.totemsoft.elixir.survey.v1.model;

import java.util.Objects;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Broker details
 */
@ApiModel(description = "Broker details")

public class BrokerDetails   {
  @JsonProperty("id")
  private String id;

  @JsonProperty("client")
  private String client;

  public BrokerDetails id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Broker Id
   * @return id
  */
  @ApiModelProperty(value = "Broker Id")


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public BrokerDetails client(String client) {
    this.client = client;
    return this;
  }

  /**
   * Broker Client
   * @return client
  */
  @ApiModelProperty(required = true, value = "Broker Client")
  @NotNull


  public String getClient() {
    return client;
  }

  public void setClient(String client) {
    this.client = client;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BrokerDetails brokerDetails = (BrokerDetails) o;
    return Objects.equals(this.id, brokerDetails.id) &&
        Objects.equals(this.client, brokerDetails.client);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, client);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BrokerDetails {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    client: ").append(toIndentedString(client)).append("\n");
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

