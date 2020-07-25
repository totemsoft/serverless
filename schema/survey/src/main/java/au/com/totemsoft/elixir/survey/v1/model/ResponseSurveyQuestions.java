package au.com.totemsoft.elixir.survey.v1.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * ResponseSurveyQuestions
 */

public class ResponseSurveyQuestions   {
  @JsonProperty("surveyId")
  private String surveyId;

  @JsonProperty("questions")
  @Valid
  private List<Question> questions = new ArrayList<>();

  public ResponseSurveyQuestions surveyId(String surveyId) {
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

  public ResponseSurveyQuestions questions(List<Question> questions) {
    this.questions = questions;
    return this;
  }

  public ResponseSurveyQuestions addQuestionsItem(Question questionsItem) {
    this.questions.add(questionsItem);
    return this;
  }

  /**
   * The list of questions returned. If the filter results in an empty set then this array may have no records.
   * @return questions
  */
  @ApiModelProperty(required = true, value = "The list of questions returned. If the filter results in an empty set then this array may have no records.")
  @NotNull

  @Valid

  public List<Question> getQuestions() {
    return questions;
  }

  public void setQuestions(List<Question> questions) {
    this.questions = questions;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ResponseSurveyQuestions responseSurveyQuestions = (ResponseSurveyQuestions) o;
    return Objects.equals(this.surveyId, responseSurveyQuestions.surveyId) &&
        Objects.equals(this.questions, responseSurveyQuestions.questions);
  }

  @Override
  public int hashCode() {
    return Objects.hash(surveyId, questions);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ResponseSurveyQuestions {\n");
    
    sb.append("    surveyId: ").append(toIndentedString(surveyId)).append("\n");
    sb.append("    questions: ").append(toIndentedString(questions)).append("\n");
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

