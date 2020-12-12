package au.com.totemsoft.elixir.survey.v1.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Address type
 */
public enum AddressType {
  
  STREET("STREET"),
  
  POSTAL("POSTAL");

  private String value;

  AddressType(String value) {
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
  public static AddressType fromValue(String value) {
    for (AddressType b : AddressType.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }
}

