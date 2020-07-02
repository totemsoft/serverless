package au.com.totemsoft.openbanking.cds.v1.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * ResponseErrorList
 */

public class ResponseErrorList   {
  @JsonProperty("errors")
  @Valid
  private List<ResponseErrorListErrors> errors = new ArrayList<>();

  public ResponseErrorList errors(List<ResponseErrorListErrors> errors) {
    this.errors = errors;
    return this;
  }

  public ResponseErrorList addErrorsItem(ResponseErrorListErrors errorsItem) {
    this.errors.add(errorsItem);
    return this;
  }

  /**
   * Get errors
   * @return errors
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid

  public List<ResponseErrorListErrors> getErrors() {
    return errors;
  }

  public void setErrors(List<ResponseErrorListErrors> errors) {
    this.errors = errors;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ResponseErrorList responseErrorList = (ResponseErrorList) o;
    return Objects.equals(this.errors, responseErrorList.errors);
  }

  @Override
  public int hashCode() {
    return Objects.hash(errors);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ResponseErrorList {\n");
    
    sb.append("    errors: ").append(toIndentedString(errors)).append("\n");
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

