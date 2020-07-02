package au.com.totemsoft.openbanking.cds.v1.model;

import java.util.Objects;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * BankingProductV3CardArt
 */

public class BankingProductV3CardArt   {
  @JsonProperty("title")
  private String title;

  @JsonProperty("imageUri")
  private String imageUri;

  public BankingProductV3CardArt title(String title) {
    this.title = title;
    return this;
  }

  /**
   * Display label for the specific image
   * @return title
  */
  @ApiModelProperty(value = "Display label for the specific image")


  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public BankingProductV3CardArt imageUri(String imageUri) {
    this.imageUri = imageUri;
    return this;
  }

  /**
   * URI reference to a PNG, JPG or GIF image with proportions defined by ISO 7810 ID-1 and width no greater than 512 pixels. The URI reference may be a link or url-encoded data URI [RFC 2397](https://tools.ietf.org/html/rfc2397)
   * @return imageUri
  */
  @ApiModelProperty(required = true, value = "URI reference to a PNG, JPG or GIF image with proportions defined by ISO 7810 ID-1 and width no greater than 512 pixels. The URI reference may be a link or url-encoded data URI [RFC 2397](https://tools.ietf.org/html/rfc2397)")
  @NotNull


  public String getImageUri() {
    return imageUri;
  }

  public void setImageUri(String imageUri) {
    this.imageUri = imageUri;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BankingProductV3CardArt bankingProductV3CardArt = (BankingProductV3CardArt) o;
    return Objects.equals(this.title, bankingProductV3CardArt.title) &&
        Objects.equals(this.imageUri, bankingProductV3CardArt.imageUri);
  }

  @Override
  public int hashCode() {
    return Objects.hash(title, imageUri);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BankingProductV3CardArt {\n");
    
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    imageUri: ").append(toIndentedString(imageUri)).append("\n");
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

