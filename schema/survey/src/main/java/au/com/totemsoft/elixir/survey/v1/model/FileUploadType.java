package au.com.totemsoft.elixir.survey.v1.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * File Upload Types
 */
public enum FileUploadType {
  
  SURVEY("SURVEY"),
  
  DOCUMENT("DOCUMENT");

  private String value;

  FileUploadType(String value) {
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
  public static FileUploadType fromValue(String value) {
    for (FileUploadType b : FileUploadType.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }
}

