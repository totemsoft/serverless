package au.com.totemsoft.openbanking.cds.v1.model;

import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Object containing the detail of the schedule for the payment
 */
@ApiModel(description = "Object containing the detail of the schedule for the payment")

public class BankingScheduledPaymentRecurrence   {
  @JsonProperty("nextPaymentDate")
  private String nextPaymentDate;

  /**
   * The type of recurrence used to define the schedule
   */
  public enum RecurrenceUTypeEnum {
    ONCEOFF("onceOff"),
    
    INTERVALSCHEDULE("intervalSchedule"),
    
    LASTWEEKDAY("lastWeekDay"),
    
    EVENTBASED("eventBased");

    private String value;

    RecurrenceUTypeEnum(String value) {
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
    public static RecurrenceUTypeEnum fromValue(String value) {
      for (RecurrenceUTypeEnum b : RecurrenceUTypeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  @JsonProperty("recurrenceUType")
  private RecurrenceUTypeEnum recurrenceUType;

  @JsonProperty("onceOff")
  private BankingScheduledPaymentRecurrenceOnceOff onceOff;

  @JsonProperty("intervalSchedule")
  private BankingScheduledPaymentRecurrenceIntervalSchedule intervalSchedule;

  @JsonProperty("lastWeekDay")
  private BankingScheduledPaymentRecurrenceLastWeekday lastWeekDay;

  @JsonProperty("eventBased")
  private BankingScheduledPaymentRecurrenceEventBased eventBased;

  public BankingScheduledPaymentRecurrence nextPaymentDate(String nextPaymentDate) {
    this.nextPaymentDate = nextPaymentDate;
    return this;
  }

  /**
   * The date of the next payment under the recurrence schedule
   * @return nextPaymentDate
  */
  @ApiModelProperty(value = "The date of the next payment under the recurrence schedule")


  public String getNextPaymentDate() {
    return nextPaymentDate;
  }

  public void setNextPaymentDate(String nextPaymentDate) {
    this.nextPaymentDate = nextPaymentDate;
  }

  public BankingScheduledPaymentRecurrence recurrenceUType(RecurrenceUTypeEnum recurrenceUType) {
    this.recurrenceUType = recurrenceUType;
    return this;
  }

  /**
   * The type of recurrence used to define the schedule
   * @return recurrenceUType
  */
  @ApiModelProperty(required = true, value = "The type of recurrence used to define the schedule")
  @NotNull


  public RecurrenceUTypeEnum getRecurrenceUType() {
    return recurrenceUType;
  }

  public void setRecurrenceUType(RecurrenceUTypeEnum recurrenceUType) {
    this.recurrenceUType = recurrenceUType;
  }

  public BankingScheduledPaymentRecurrence onceOff(BankingScheduledPaymentRecurrenceOnceOff onceOff) {
    this.onceOff = onceOff;
    return this;
  }

  /**
   * Get onceOff
   * @return onceOff
  */
  @ApiModelProperty(value = "")

  @Valid

  public BankingScheduledPaymentRecurrenceOnceOff getOnceOff() {
    return onceOff;
  }

  public void setOnceOff(BankingScheduledPaymentRecurrenceOnceOff onceOff) {
    this.onceOff = onceOff;
  }

  public BankingScheduledPaymentRecurrence intervalSchedule(BankingScheduledPaymentRecurrenceIntervalSchedule intervalSchedule) {
    this.intervalSchedule = intervalSchedule;
    return this;
  }

  /**
   * Get intervalSchedule
   * @return intervalSchedule
  */
  @ApiModelProperty(value = "")

  @Valid

  public BankingScheduledPaymentRecurrenceIntervalSchedule getIntervalSchedule() {
    return intervalSchedule;
  }

  public void setIntervalSchedule(BankingScheduledPaymentRecurrenceIntervalSchedule intervalSchedule) {
    this.intervalSchedule = intervalSchedule;
  }

  public BankingScheduledPaymentRecurrence lastWeekDay(BankingScheduledPaymentRecurrenceLastWeekday lastWeekDay) {
    this.lastWeekDay = lastWeekDay;
    return this;
  }

  /**
   * Get lastWeekDay
   * @return lastWeekDay
  */
  @ApiModelProperty(value = "")

  @Valid

  public BankingScheduledPaymentRecurrenceLastWeekday getLastWeekDay() {
    return lastWeekDay;
  }

  public void setLastWeekDay(BankingScheduledPaymentRecurrenceLastWeekday lastWeekDay) {
    this.lastWeekDay = lastWeekDay;
  }

  public BankingScheduledPaymentRecurrence eventBased(BankingScheduledPaymentRecurrenceEventBased eventBased) {
    this.eventBased = eventBased;
    return this;
  }

  /**
   * Get eventBased
   * @return eventBased
  */
  @ApiModelProperty(value = "")

  @Valid

  public BankingScheduledPaymentRecurrenceEventBased getEventBased() {
    return eventBased;
  }

  public void setEventBased(BankingScheduledPaymentRecurrenceEventBased eventBased) {
    this.eventBased = eventBased;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BankingScheduledPaymentRecurrence bankingScheduledPaymentRecurrence = (BankingScheduledPaymentRecurrence) o;
    return Objects.equals(this.nextPaymentDate, bankingScheduledPaymentRecurrence.nextPaymentDate) &&
        Objects.equals(this.recurrenceUType, bankingScheduledPaymentRecurrence.recurrenceUType) &&
        Objects.equals(this.onceOff, bankingScheduledPaymentRecurrence.onceOff) &&
        Objects.equals(this.intervalSchedule, bankingScheduledPaymentRecurrence.intervalSchedule) &&
        Objects.equals(this.lastWeekDay, bankingScheduledPaymentRecurrence.lastWeekDay) &&
        Objects.equals(this.eventBased, bankingScheduledPaymentRecurrence.eventBased);
  }

  @Override
  public int hashCode() {
    return Objects.hash(nextPaymentDate, recurrenceUType, onceOff, intervalSchedule, lastWeekDay, eventBased);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BankingScheduledPaymentRecurrence {\n");
    
    sb.append("    nextPaymentDate: ").append(toIndentedString(nextPaymentDate)).append("\n");
    sb.append("    recurrenceUType: ").append(toIndentedString(recurrenceUType)).append("\n");
    sb.append("    onceOff: ").append(toIndentedString(onceOff)).append("\n");
    sb.append("    intervalSchedule: ").append(toIndentedString(intervalSchedule)).append("\n");
    sb.append("    lastWeekDay: ").append(toIndentedString(lastWeekDay)).append("\n");
    sb.append("    eventBased: ").append(toIndentedString(eventBased)).append("\n");
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

