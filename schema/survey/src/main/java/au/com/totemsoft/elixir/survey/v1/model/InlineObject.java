package au.com.totemsoft.elixir.survey.v1.model;

import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.core.io.Resource;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * InlineObject
 */

public class InlineObject   {
  @JsonProperty("fileUpload")
  private Resource fileUpload;

  public InlineObject fileUpload(Resource fileUpload) {
    this.fileUpload = fileUpload;
    return this;
  }

  /**
   * The file to upload.
   * @return fileUpload
  */
  @ApiModelProperty(required = true, value = "The file to upload.")
  @NotNull

  @Valid

  public Resource getFileUpload() {
    return fileUpload;
  }

  public void setFileUpload(Resource fileUpload) {
    this.fileUpload = fileUpload;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    InlineObject inlineObject = (InlineObject) o;
    return Objects.equals(this.fileUpload, inlineObject.fileUpload);
  }

  @Override
  public int hashCode() {
    return Objects.hash(fileUpload);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InlineObject {\n");
    
    sb.append("    fileUpload: ").append(toIndentedString(fileUpload)).append("\n");
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

