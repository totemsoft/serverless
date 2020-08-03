package au.com.totemsoft.elixir.survey.v1.model;

import java.util.Objects;
import java.util.UUID;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * UploadResponse
 */

public class UploadResponse   {
  @JsonProperty("reference")
  private UUID reference;

  @JsonProperty("documentId")
  private String documentId;

  @JsonProperty("message")
  private String message;

  public UploadResponse reference(UUID reference) {
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

  public UploadResponse documentId(String documentId) {
    this.documentId = documentId;
    return this;
  }

  /**
   * Document Id
   * @return documentId
  */
  @ApiModelProperty(required = true, value = "Document Id")
  @NotNull


  public String getDocumentId() {
    return documentId;
  }

  public void setDocumentId(String documentId) {
    this.documentId = documentId;
  }

  public UploadResponse message(String message) {
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
    UploadResponse uploadResponse = (UploadResponse) o;
    return Objects.equals(this.reference, uploadResponse.reference) &&
        Objects.equals(this.documentId, uploadResponse.documentId) &&
        Objects.equals(this.message, uploadResponse.message);
  }

  @Override
  public int hashCode() {
    return Objects.hash(reference, documentId, message);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UploadResponse {\n");
    
    sb.append("    reference: ").append(toIndentedString(reference)).append("\n");
    sb.append("    documentId: ").append(toIndentedString(documentId)).append("\n");
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

