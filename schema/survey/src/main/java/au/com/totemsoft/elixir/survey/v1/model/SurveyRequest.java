package au.com.totemsoft.elixir.survey.v1.model;

import java.util.Objects;
import java.util.UUID;

import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * SurveyRequest
 */

public class SurveyRequest   {
  @JsonProperty("reference")
  private UUID reference;

  @JsonProperty("folderId")
  private String folderId;

  @JsonProperty("insured")
  private InsuredDetails insured;

  @JsonProperty("survey")
  private String survey;

  public SurveyRequest reference(UUID reference) {
    this.reference = reference;
    return this;
  }

  /**
   * Reference (Survey Id)
   * @return reference
  */
  @ApiModelProperty(value = "Reference (Survey Id)")

  @Valid

  public UUID getReference() {
    return reference;
  }

  public void setReference(UUID reference) {
    this.reference = reference;
  }

  public SurveyRequest folderId(String folderId) {
    this.folderId = folderId;
    return this;
  }

  /**
   * Folder Id
   * @return folderId
  */
  @ApiModelProperty(value = "Folder Id")


  public String getFolderId() {
    return folderId;
  }

  public void setFolderId(String folderId) {
    this.folderId = folderId;
  }

  public SurveyRequest insured(InsuredDetails insured) {
    this.insured = insured;
    return this;
  }

  /**
   * Get insured
   * @return insured
  */
  @ApiModelProperty(value = "")

  @Valid

  public InsuredDetails getInsured() {
    return insured;
  }

  public void setInsured(InsuredDetails insured) {
    this.insured = insured;
  }

  public SurveyRequest survey(String survey) {
    this.survey = survey;
    return this;
  }

  /**
   * Survey JSON Document
   * @return survey
  */
  @ApiModelProperty(value = "Survey JSON Document")


  public String getSurvey() {
    return survey;
  }

  public void setSurvey(String survey) {
    this.survey = survey;
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
        Objects.equals(this.folderId, surveyRequest.folderId) &&
        Objects.equals(this.insured, surveyRequest.insured) &&
        Objects.equals(this.survey, surveyRequest.survey);
  }

  @Override
  public int hashCode() {
    return Objects.hash(reference, folderId, insured, survey);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SurveyRequest {\n");
    
    sb.append("    reference: ").append(toIndentedString(reference)).append("\n");
    sb.append("    folderId: ").append(toIndentedString(folderId)).append("\n");
    sb.append("    insured: ").append(toIndentedString(insured)).append("\n");
    sb.append("    survey: ").append(toIndentedString(survey)).append("\n");
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

