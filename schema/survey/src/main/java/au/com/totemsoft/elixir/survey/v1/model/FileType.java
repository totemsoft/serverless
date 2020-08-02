package au.com.totemsoft.elixir.survey.v1.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * File Type
 */
public enum FileType {
  
  SURVEY("SURVEY"),
  
  DOCUMENT("DOCUMENT");

  private String value;

  FileType(String value) {
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
  public static FileType fromValue(String value) {
    for (FileType b : FileType.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }
}

