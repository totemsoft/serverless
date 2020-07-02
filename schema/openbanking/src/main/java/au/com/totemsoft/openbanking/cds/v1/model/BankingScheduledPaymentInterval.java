package au.com.totemsoft.openbanking.cds.v1.model;

import java.util.Objects;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * BankingScheduledPaymentInterval
 */

public class BankingScheduledPaymentInterval   {
  @JsonProperty("interval")
  private String interval;

  @JsonProperty("dayInInterval")
  private String dayInInterval;

  public BankingScheduledPaymentInterval interval(String interval) {
    this.interval = interval;
    return this;
  }

  /**
   * An interval for the payment. Formatted according to [ISO 8601 Durations](https://en.wikipedia.org/wiki/ISO_8601#Durations)  (excludes recurrence syntax) with components less than a day in length ignored. This duration defines the period between payments starting with nextPaymentDate
   * @return interval
  */
  @ApiModelProperty(required = true, value = "An interval for the payment. Formatted according to [ISO 8601 Durations](https://en.wikipedia.org/wiki/ISO_8601#Durations)  (excludes recurrence syntax) with components less than a day in length ignored. This duration defines the period between payments starting with nextPaymentDate")
  @NotNull


  public String getInterval() {
    return interval;
  }

  public void setInterval(String interval) {
    this.interval = interval;
  }

  public BankingScheduledPaymentInterval dayInInterval(String dayInInterval) {
    this.dayInInterval = dayInInterval;
    return this;
  }

  /**
   * Uses an interval to define the ordinal day within the interval defined by the interval field on which the payment occurs. If the resulting duration is 0 days in length or larger than the number of days in the interval then the payment will occur on the last day of the interval. A duration of 1 day indicates the first day of the interval. If absent the assumed value is P1D. Formatted according to [ISO 8601 Durations](https://en.wikipedia.org/wiki/ISO_8601#Durations) (excludes recurrence syntax) with components less than a day in length ignored. The first day of a week is considered to be Monday.
   * @return dayInInterval
  */
  @ApiModelProperty(value = "Uses an interval to define the ordinal day within the interval defined by the interval field on which the payment occurs. If the resulting duration is 0 days in length or larger than the number of days in the interval then the payment will occur on the last day of the interval. A duration of 1 day indicates the first day of the interval. If absent the assumed value is P1D. Formatted according to [ISO 8601 Durations](https://en.wikipedia.org/wiki/ISO_8601#Durations) (excludes recurrence syntax) with components less than a day in length ignored. The first day of a week is considered to be Monday.")


  public String getDayInInterval() {
    return dayInInterval;
  }

  public void setDayInInterval(String dayInInterval) {
    this.dayInInterval = dayInInterval;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BankingScheduledPaymentInterval bankingScheduledPaymentInterval = (BankingScheduledPaymentInterval) o;
    return Objects.equals(this.interval, bankingScheduledPaymentInterval.interval) &&
        Objects.equals(this.dayInInterval, bankingScheduledPaymentInterval.dayInInterval);
  }

  @Override
  public int hashCode() {
    return Objects.hash(interval, dayInInterval);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BankingScheduledPaymentInterval {\n");
    
    sb.append("    interval: ").append(toIndentedString(interval)).append("\n");
    sb.append("    dayInInterval: ").append(toIndentedString(dayInInterval)).append("\n");
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

