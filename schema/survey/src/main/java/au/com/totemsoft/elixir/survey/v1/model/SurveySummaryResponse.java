package au.com.totemsoft.elixir.survey.v1.model;

import java.util.Objects;
import java.util.UUID;

import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Survey Summary details.
 */
@ApiModel(description = "Survey Summary details.")

public class SurveySummaryResponse   {
  @JsonProperty("reference")
  private UUID reference;

  @JsonProperty("folderId")
  private String folderId;

  @JsonProperty("message")
  private String message;

  public SurveySummaryResponse reference(UUID reference) {
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

  public SurveySummaryResponse folderId(String folderId) {
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

  public SurveySummaryResponse message(String message) {
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
    SurveySummaryResponse surveySummaryResponse = (SurveySummaryResponse) o;
    return Objects.equals(this.reference, surveySummaryResponse.reference) &&
        Objects.equals(this.folderId, surveySummaryResponse.folderId) &&
        Objects.equals(this.message, surveySummaryResponse.message);
  }

  @Override
  public int hashCode() {
    return Objects.hash(reference, folderId, message);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SurveySummaryResponse {\n");
    
    sb.append("    reference: ").append(toIndentedString(reference)).append("\n");
    sb.append("    folderId: ").append(toIndentedString(folderId)).append("\n");
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

