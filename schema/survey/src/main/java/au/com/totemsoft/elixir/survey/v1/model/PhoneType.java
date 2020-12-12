package au.com.totemsoft.elixir.survey.v1.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Phone types
 */
public enum PhoneType {
  
  FAX("FAX"),
  
  MOBILE("MOBILE"),
  
  WORK("WORK");

  private String value;

  PhoneType(String value) {
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
  public static PhoneType fromValue(String value) {
    for (PhoneType b : PhoneType.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }
}

