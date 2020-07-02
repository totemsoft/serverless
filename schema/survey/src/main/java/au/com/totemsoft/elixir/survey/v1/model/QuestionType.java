package au.com.totemsoft.elixir.survey.v1.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Question Types
 */
public enum QuestionType {
  
  TEXT("TEXT"),
  
  RADIOGROUP("RADIOGROUP"),
  
  DROPDOWN("DROPDOWN"),
  
  CHECKBOXES("CHECKBOXES"),
  
  BOOLEAN("BOOLEAN"),
  
  COMMENT("COMMENT");

  private String value;

  QuestionType(String value) {
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
  public static QuestionType fromValue(String value) {
    for (QuestionType b : QuestionType.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }
}

