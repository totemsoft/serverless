package au.com.totemsoft.elixir.survey.v1.model;

import java.util.Objects;
import java.util.UUID;

import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * SurveyResponse
 */

public class SurveyResponse   {
  @JsonProperty("reference")
  private UUID reference;

  @JsonProperty("folderId")
  private String folderId;

  @JsonProperty("broker")
  private BrokerDetails broker;

  @JsonProperty("insured")
  private InsuredDetails insured;

  @JsonProperty("survey")
  private String survey;

  @JsonProperty("message")
  private String message;

  public SurveyResponse reference(UUID reference) {
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

  public SurveyResponse folderId(String folderId) {
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

  public SurveyResponse broker(BrokerDetails broker) {
    this.broker = broker;
    return this;
  }

  /**
   * Get broker
   * @return broker
  */
  @ApiModelProperty(value = "")

  @Valid

  public BrokerDetails getBroker() {
    return broker;
  }

  public void setBroker(BrokerDetails broker) {
    this.broker = broker;
  }

  public SurveyResponse insured(InsuredDetails insured) {
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

  public SurveyResponse survey(String survey) {
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

  public SurveyResponse message(String message) {
    this.message = message;
    return this;
  }

  /**
   * Message (could be error)
   * @return message
  */
  @ApiModelProperty(value = "Message (could be error)")


  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SurveyResponse surveyResponse = (SurveyResponse) o;
    return Objects.equals(this.reference, surveyResponse.reference) &&
        Objects.equals(this.folderId, surveyResponse.folderId) &&
        Objects.equals(this.broker, surveyResponse.broker) &&
        Objects.equals(this.insured, surveyResponse.insured) &&
        Objects.equals(this.survey, surveyResponse.survey) &&
        Objects.equals(this.message, surveyResponse.message);
  }

  @Override
  public int hashCode() {
    return Objects.hash(reference, folderId, broker, insured, survey, message);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SurveyResponse {\n");
    
    sb.append("    reference: ").append(toIndentedString(reference)).append("\n");
    sb.append("    folderId: ").append(toIndentedString(folderId)).append("\n");
    sb.append("    broker: ").append(toIndentedString(broker)).append("\n");
    sb.append("    insured: ").append(toIndentedString(insured)).append("\n");
    sb.append("    survey: ").append(toIndentedString(survey)).append("\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
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

