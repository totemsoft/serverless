package au.com.totemsoft.openbanking.cds.v1.model;

import java.util.Objects;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Indicates that the schedule of payments is defined according to the last occurrence of a specific weekday in an interval. Mandatory if recurrenceUType is set to lastWeekDay
 */
@ApiModel(description = "Indicates that the schedule of payments is defined according to the last occurrence of a specific weekday in an interval. Mandatory if recurrenceUType is set to lastWeekDay")

public class BankingScheduledPaymentRecurrenceLastWeekday   {
  @JsonProperty("finalPaymentDate")
  private String finalPaymentDate;

  @JsonProperty("paymentsRemaining")
  private Integer paymentsRemaining;

  @JsonProperty("interval")
  private String interval;

  /**
   * The weekDay specified. The payment will occur on the last occurrence of this weekday in the interval.
   */
  public enum LastWeekDayEnum {
    MON("MON"),
    
    TUE("TUE"),
    
    WED("WED"),
    
    THU("THU"),
    
    FRI("FRI"),
    
    SAT("SAT"),
    
    SUN("SUN");

    private String value;

    LastWeekDayEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static LastWeekDayEnum fromValue(String value) {
      for (LastWeekDayEnum b : LastWeekDayEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  @JsonProperty("lastWeekDay")
  private LastWeekDayEnum lastWeekDay;

  /**
   * Enumerated field giving the treatment where a scheduled payment date is not a business day. If absent assumed to be ON.<br/>**AFTER** - If a scheduled payment date is a non-business day the payment will be made on the first business day after the scheduled payment date.<br/>**BEFORE** - If a scheduled payment date is a non-business day the payment will be made on the first business day before the scheduled payment date.<br/>**ON** - If a scheduled payment date is a non-business day the payment will be made on that day regardless.<br/>**ONLY** - Payments only occur on business days. If a scheduled payment date is a non-business day the payment will be ignored
   */
  public enum NonBusinessDayTreatmentEnum {
    AFTER("AFTER"),
    
    BEFORE("BEFORE"),
    
    ON("ON"),
    
    ONLY("ONLY");

    private String value;

    NonBusinessDayTreatmentEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static NonBusinessDayTreatmentEnum fromValue(String value) {
      for (NonBusinessDayTreatmentEnum b : NonBusinessDayTreatmentEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  @JsonProperty("nonBusinessDayTreatment")
  private NonBusinessDayTreatmentEnum nonBusinessDayTreatment = NonBusinessDayTreatmentEnum.ON;

  public BankingScheduledPaymentRecurrenceLastWeekday finalPaymentDate(String finalPaymentDate) {
    this.finalPaymentDate = finalPaymentDate;
    return this;
  }

  /**
   * The limit date after which no more payments should be made using this schedule. If both finalPaymentDate and paymentsRemaining are present then payments will stop according to the most constraining value. If neither field is present the payments will continue indefinitely
   * @return finalPaymentDate
  */
  @ApiModelProperty(value = "The limit date after which no more payments should be made using this schedule. If both finalPaymentDate and paymentsRemaining are present then payments will stop according to the most constraining value. If neither field is present the payments will continue indefinitely")


  public String getFinalPaymentDate() {
    return finalPaymentDate;
  }

  public void setFinalPaymentDate(String finalPaymentDate) {
    this.finalPaymentDate = finalPaymentDate;
  }

  public BankingScheduledPaymentRecurrenceLastWeekday paymentsRemaining(Integer paymentsRemaining) {
    this.paymentsRemaining = paymentsRemaining;
    return this;
  }

  /**
   * Indicates the number of payments remaining in the schedule. If both finalPaymentDate and paymentsRemaining are present then payments will stop according to the most constraining value. If neither field is present the payments will continue indefinitely
   * @return paymentsRemaining
  */
  @ApiModelProperty(value = "Indicates the number of payments remaining in the schedule. If both finalPaymentDate and paymentsRemaining are present then payments will stop according to the most constraining value. If neither field is present the payments will continue indefinitely")


  public Integer getPaymentsRemaining() {
    return paymentsRemaining;
  }

  public void setPaymentsRemaining(Integer paymentsRemaining) {
    this.paymentsRemaining = paymentsRemaining;
  }

  public BankingScheduledPaymentRecurrenceLastWeekday interval(String interval) {
    this.interval = interval;
    return this;
  }

  /**
   * The interval for the payment. Formatted according to [ISO 8601 Durations](https://en.wikipedia.org/wiki/ISO_8601#Durations) (excludes recurrence syntax) with components less than a day in length ignored. This duration defines the period between payments starting with nextPaymentDate
   * @return interval
  */
  @ApiModelProperty(required = true, value = "The interval for the payment. Formatted according to [ISO 8601 Durations](https://en.wikipedia.org/wiki/ISO_8601#Durations) (excludes recurrence syntax) with components less than a day in length ignored. This duration defines the period between payments starting with nextPaymentDate")
  @NotNull


  public String getInterval() {
    return interval;
  }

  public void setInterval(String interval) {
    this.interval = interval;
  }

  public BankingScheduledPaymentRecurrenceLastWeekday lastWeekDay(LastWeekDayEnum lastWeekDay) {
    this.lastWeekDay = lastWeekDay;
    return this;
  }

  /**
   * The weekDay specified. The payment will occur on the last occurrence of this weekday in the interval.
   * @return lastWeekDay
  */
  @ApiModelProperty(required = true, value = "The weekDay specified. The payment will occur on the last occurrence of this weekday in the interval.")
  @NotNull


  public LastWeekDayEnum getLastWeekDay() {
    return lastWeekDay;
  }

  public void setLastWeekDay(LastWeekDayEnum lastWeekDay) {
    this.lastWeekDay = lastWeekDay;
  }

  public BankingScheduledPaymentRecurrenceLastWeekday nonBusinessDayTreatment(NonBusinessDayTreatmentEnum nonBusinessDayTreatment) {
    this.nonBusinessDayTreatment = nonBusinessDayTreatment;
    return this;
  }

  /**
   * Enumerated field giving the treatment where a scheduled payment date is not a business day. If absent assumed to be ON.<br/>**AFTER** - If a scheduled payment date is a non-business day the payment will be made on the first business day after the scheduled payment date.<br/>**BEFORE** - If a scheduled payment date is a non-business day the payment will be made on the first business day before the scheduled payment date.<br/>**ON** - If a scheduled payment date is a non-business day the payment will be made on that day regardless.<br/>**ONLY** - Payments only occur on business days. If a scheduled payment date is a non-business day the payment will be ignored
   * @return nonBusinessDayTreatment
  */
  @ApiModelProperty(value = "Enumerated field giving the treatment where a scheduled payment date is not a business day. If absent assumed to be ON.<br/>**AFTER** - If a scheduled payment date is a non-business day the payment will be made on the first business day after the scheduled payment date.<br/>**BEFORE** - If a scheduled payment date is a non-business day the payment will be made on the first business day before the scheduled payment date.<br/>**ON** - If a scheduled payment date is a non-business day the payment will be made on that day regardless.<br/>**ONLY** - Payments only occur on business days. If a scheduled payment date is a non-business day the payment will be ignored")


  public NonBusinessDayTreatmentEnum getNonBusinessDayTreatment() {
    return nonBusinessDayTreatment;
  }

  public void setNonBusinessDayTreatment(NonBusinessDayTreatmentEnum nonBusinessDayTreatment) {
    this.nonBusinessDayTreatment = nonBusinessDayTreatment;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BankingScheduledPaymentRecurrenceLastWeekday bankingScheduledPaymentRecurrenceLastWeekday = (BankingScheduledPaymentRecurrenceLastWeekday) o;
    return Objects.equals(this.finalPaymentDate, bankingScheduledPaymentRecurrenceLastWeekday.finalPaymentDate) &&
        Objects.equals(this.paymentsRemaining, bankingScheduledPaymentRecurrenceLastWeekday.paymentsRemaining) &&
        Objects.equals(this.interval, bankingScheduledPaymentRecurrenceLastWeekday.interval) &&
        Objects.equals(this.lastWeekDay, bankingScheduledPaymentRecurrenceLastWeekday.lastWeekDay) &&
        Objects.equals(this.nonBusinessDayTreatment, bankingScheduledPaymentRecurrenceLastWeekday.nonBusinessDayTreatment);
  }

  @Override
  public int hashCode() {
    return Objects.hash(finalPaymentDate, paymentsRemaining, interval, lastWeekDay, nonBusinessDayTreatment);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BankingScheduledPaymentRecurrenceLastWeekday {\n");
    
    sb.append("    finalPaymentDate: ").append(toIndentedString(finalPaymentDate)).append("\n");
    sb.append("    paymentsRemaining: ").append(toIndentedString(paymentsRemaining)).append("\n");
    sb.append("    interval: ").append(toIndentedString(interval)).append("\n");
    sb.append("    lastWeekDay: ").append(toIndentedString(lastWeekDay)).append("\n");
    sb.append("    nonBusinessDayTreatment: ").append(toIndentedString(nonBusinessDayTreatment)).append("\n");
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

