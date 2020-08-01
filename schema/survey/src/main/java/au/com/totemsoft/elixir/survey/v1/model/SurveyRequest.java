package au.com.totemsoft.elixir.survey.v1.model;

import java.util.Objects;
import java.util.UUID;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * SurveyRequest
 */

public class SurveyRequest   {
  @JsonProperty("reference")
  private UUID reference;

  @JsonProperty("details")
  private InsuredDetails details;

  public SurveyRequest reference(UUID reference) {
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

  public SurveyRequest details(InsuredDetails details) {
    this.details = details;
    return this;
  }

  /**
   * Get details
   * @return details
  */
  @ApiModelProperty(value = "")

  @Valid

  public InsuredDetails getDetails() {
    return details;
  }

  public void setDetails(InsuredDetails details) {
    this.details = details;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SurveyRequest surveyRequest = (SurveyRequest) o;
    return Objects.equals(this.reference, surveyRequest.reference) &&
        Objects.equals(this.details, surveyRequest.details);
  }

  @Override
  public int hashCode() {
    return Objects.hash(reference, details);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SurveyRequest {\n");
    
    sb.append("    reference: ").append(toIndentedString(reference)).append("\n");
    sb.append("    details: ").append(toIndentedString(details)).append("\n");
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

