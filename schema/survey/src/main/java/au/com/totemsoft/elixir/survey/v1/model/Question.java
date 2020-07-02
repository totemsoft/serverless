package au.com.totemsoft.elixir.survey.v1.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * Question
 */

public class Question   {
  @JsonProperty("type")
  private QuestionType type;

  @JsonProperty("text")
  private String text;

  @JsonProperty("answers")
  @Valid
  private List<Answer> answers = new ArrayList<>();

  public Question type(QuestionType type) {
    this.type = type;
    return this;
  }

  /**
   * Get type
   * @return type
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid

  public QuestionType getType() {
    return type;
  }

  public void setType(QuestionType type) {
    this.type = type;
  }

  public Question text(String text) {
    this.text = text;
    return this;
  }

  /**
   * Question text
   * @return text
  */
  @ApiModelProperty(required = true, value = "Question text")
  @NotNull


  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public Question answers(List<Answer> answers) {
    this.answers = answers;
    return this;
  }

  public Question addAnswersItem(Answer answersItem) {
    this.answers.add(answersItem);
    return this;
  }

  /**
   * An array of question answers
   * @return answers
  */
  @ApiModelProperty(required = true, value = "An array of question answers")
  @NotNull

  @Valid

  public List<Answer> getAnswers() {
    return answers;
  }

  public void setAnswers(List<Answer> answers) {
    this.answers = answers;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Question question = (Question) o;
    return Objects.equals(this.type, question.type) &&
        Objects.equals(this.text, question.text) &&
        Objects.equals(this.answers, question.answers);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, text, answers);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Question {\n");
    
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    text: ").append(toIndentedString(text)).append("\n");
    sb.append("    answers: ").append(toIndentedString(answers)).append("\n");
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

