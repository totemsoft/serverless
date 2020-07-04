package au.com.totemsoft.elixir.survey.v1.model;

import java.util.Objects;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * ResponseUpload
 */

public class ResponseUpload   {
  @JsonProperty("surveyId")
  private String surveyId;

  public ResponseUpload surveyId(String surveyId) {
    this.surveyId = surveyId;
    return this;
  }

  /**
   * Survey Id
   * @return surveyId
  */
  @ApiModelProperty(required = true, value = "Survey Id")
  @NotNull


  public String getSurveyId() {
    return surveyId;
  }

  public void setSurveyId(String surveyId) {
    this.surveyId = surveyId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ResponseUpload responseUpload = (ResponseUpload) o;
    return Objects.equals(this.surveyId, responseUpload.surveyId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(surveyId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ResponseUpload {\n");
    
    sb.append("    surveyId: ").append(toIndentedString(surveyId)).append("\n");
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
