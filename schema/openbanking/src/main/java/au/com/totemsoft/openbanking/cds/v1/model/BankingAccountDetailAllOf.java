package au.com.totemsoft.openbanking.cds.v1.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import io.swagger.annotations.ApiModelProperty;

/**
 * BankingAccountDetailAllOf
 */

public class BankingAccountDetailAllOf   {
  @JsonProperty("bsb")
  private String bsb;

  @JsonProperty("accountNumber")
  private String accountNumber;

  @JsonProperty("bundleName")
  private String bundleName;

  /**
   * The type of structure to present account specific fields.
   */
  public enum SpecificAccountUTypeEnum {
    TERMDEPOSIT("termDeposit"),
    
    CREDITCARD("creditCard"),
    
    LOAN("loan");

    private String value;

    SpecificAccountUTypeEnum(String value) {
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
    public static SpecificAccountUTypeEnum fromValue(String value) {
      for (SpecificAccountUTypeEnum b : SpecificAccountUTypeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  @JsonProperty("specificAccountUType")
  private SpecificAccountUTypeEnum specificAccountUType;

  @JsonProperty("termDeposit")
  @Valid
  private List<BankingTermDepositAccount> termDeposit = null;

  @JsonProperty("creditCard")
  private BankingCreditCardAccount creditCard;

  @JsonProperty("loan")
  private BankingLoanAccount loan;

  @JsonProperty("depositRate")
  private String depositRate;

  @JsonProperty("lendingRate")
  private String lendingRate;

  @JsonProperty("depositRates")
  @Valid
  private List<BankingProductDepositRate> depositRates = null;

  @JsonProperty("lendingRates")
  @Valid
  private List<BankingProductLendingRate> lendingRates = null;

  @JsonProperty("features")
  @Valid
  private List<BankingProductFeature> features = null;

  @JsonProperty("fees")
  @Valid
  private List<BankingProductFee> fees = null;

  @JsonProperty("addresses")
  @Valid
  private List<CommonPhysicalAddress> addresses = null;

  public BankingAccountDetailAllOf bsb(String bsb) {
    this.bsb = bsb;
    return this;
  }

  /**
   * The unmasked BSB for the account. Is expected to be formatted as digits only with leading zeros included and no punctuation or spaces
   * @return bsb
  */
  @ApiModelProperty(value = "The unmasked BSB for the account. Is expected to be formatted as digits only with leading zeros included and no punctuation or spaces")


  public String getBsb() {
    return bsb;
  }

  public void setBsb(String bsb) {
    this.bsb = bsb;
  }

  public BankingAccountDetailAllOf accountNumber(String accountNumber) {
    this.accountNumber = accountNumber;
    return this;
  }

  /**
   * The unmasked account number for the account. Should not be supplied if the account number is a PAN requiring PCI compliance. Is expected to be formatted as digits only with leading zeros included and no punctuation or spaces
   * @return accountNumber
  */
  @ApiModelProperty(value = "The unmasked account number for the account. Should not be supplied if the account number is a PAN requiring PCI compliance. Is expected to be formatted as digits only with leading zeros included and no punctuation or spaces")


  public String getAccountNumber() {
    return accountNumber;
  }

  public void setAccountNumber(String accountNumber) {
    this.accountNumber = accountNumber;
  }

  public BankingAccountDetailAllOf bundleName(String bundleName) {
    this.bundleName = bundleName;
    return this;
  }

  /**
   * Optional field to indicate if this account is part of a bundle that is providing additional benefit for to the customer
   * @return bundleName
  */
  @ApiModelProperty(value = "Optional field to indicate if this account is part of a bundle that is providing additional benefit for to the customer")


  public String getBundleName() {
    return bundleName;
  }

  public void setBundleName(String bundleName) {
    this.bundleName = bundleName;
  }

  public BankingAccountDetailAllOf specificAccountUType(SpecificAccountUTypeEnum specificAccountUType) {
    this.specificAccountUType = specificAccountUType;
    return this;
  }

  /**
   * The type of structure to present account specific fields.
   * @return specificAccountUType
  */
  @ApiModelProperty(value = "The type of structure to present account specific fields.")


  public SpecificAccountUTypeEnum getSpecificAccountUType() {
    return specificAccountUType;
  }

  public void setSpecificAccountUType(SpecificAccountUTypeEnum specificAccountUType) {
    this.specificAccountUType = specificAccountUType;
  }

  public BankingAccountDetailAllOf termDeposit(List<BankingTermDepositAccount> termDeposit) {
    this.termDeposit = termDeposit;
    return this;
  }

  public BankingAccountDetailAllOf addTermDepositItem(BankingTermDepositAccount termDepositItem) {
    if (this.termDeposit == null) {
      this.termDeposit = new ArrayList<>();
    }
    this.termDeposit.add(termDepositItem);
    return this;
  }

  /**
   * Get termDeposit
   * @return termDeposit
  */
  @ApiModelProperty(value = "")

  @Valid

  public List<BankingTermDepositAccount> getTermDeposit() {
    return termDeposit;
  }

  public void setTermDeposit(List<BankingTermDepositAccount> termDeposit) {
    this.termDeposit = termDeposit;
  }

  public BankingAccountDetailAllOf creditCard(BankingCreditCardAccount creditCard) {
    this.creditCard = creditCard;
    return this;
  }

  /**
   * Get creditCard
   * @return creditCard
  */
  @ApiModelProperty(value = "")

  @Valid

  public BankingCreditCardAccount getCreditCard() {
    return creditCard;
  }

  public void setCreditCard(BankingCreditCardAccount creditCard) {
    this.creditCard = creditCard;
  }

  public BankingAccountDetailAllOf loan(BankingLoanAccount loan) {
    this.loan = loan;
    return this;
  }

  /**
   * Get loan
   * @return loan
  */
  @ApiModelProperty(value = "")

  @Valid

  public BankingLoanAccount getLoan() {
    return loan;
  }

  public void setLoan(BankingLoanAccount loan) {
    this.loan = loan;
  }

  public BankingAccountDetailAllOf depositRate(String depositRate) {
    this.depositRate = depositRate;
    return this;
  }

  /**
   * current rate to calculate interest earned being applied to deposit balances as it stands at the time of the API call
   * @return depositRate
  */
  @ApiModelProperty(value = "current rate to calculate interest earned being applied to deposit balances as it stands at the time of the API call")


  public String getDepositRate() {
    return depositRate;
  }

  public void setDepositRate(String depositRate) {
    this.depositRate = depositRate;
  }

  public BankingAccountDetailAllOf lendingRate(String lendingRate) {
    this.lendingRate = lendingRate;
    return this;
  }

  /**
   * The current rate to calculate interest payable being applied to lending balances as it stands at the time of the API call
   * @return lendingRate
  */
  @ApiModelProperty(value = "The current rate to calculate interest payable being applied to lending balances as it stands at the time of the API call")


  public String getLendingRate() {
    return lendingRate;
  }

  public void setLendingRate(String lendingRate) {
    this.lendingRate = lendingRate;
  }

  public BankingAccountDetailAllOf depositRates(List<BankingProductDepositRate> depositRates) {
    this.depositRates = depositRates;
    return this;
  }

  public BankingAccountDetailAllOf addDepositRatesItem(BankingProductDepositRate depositRatesItem) {
    if (this.depositRates == null) {
      this.depositRates = new ArrayList<>();
    }
    this.depositRates.add(depositRatesItem);
    return this;
  }

  /**
   * Fully described deposit rates for this account based on the equivalent structure in Product Reference
   * @return depositRates
  */
  @ApiModelProperty(value = "Fully described deposit rates for this account based on the equivalent structure in Product Reference")

  @Valid

  public List<BankingProductDepositRate> getDepositRates() {
    return depositRates;
  }

  public void setDepositRates(List<BankingProductDepositRate> depositRates) {
    this.depositRates = depositRates;
  }

  public BankingAccountDetailAllOf lendingRates(List<BankingProductLendingRate> lendingRates) {
    this.lendingRates = lendingRates;
    return this;
  }

  public BankingAccountDetailAllOf addLendingRatesItem(BankingProductLendingRate lendingRatesItem) {
    if (this.lendingRates == null) {
      this.lendingRates = new ArrayList<>();
    }
    this.lendingRates.add(lendingRatesItem);
    return this;
  }

  /**
   * Fully described deposit rates for this account based on the equivalent structure in Product Reference
   * @return lendingRates
  */
  @ApiModelProperty(value = "Fully described deposit rates for this account based on the equivalent structure in Product Reference")

  @Valid

  public List<BankingProductLendingRate> getLendingRates() {
    return lendingRates;
  }

  public void setLendingRates(List<BankingProductLendingRate> lendingRates) {
    this.lendingRates = lendingRates;
  }

  public BankingAccountDetailAllOf features(List<BankingProductFeature> features) {
    this.features = features;
    return this;
  }

  public BankingAccountDetailAllOf addFeaturesItem(BankingProductFeature featuresItem) {
    if (this.features == null) {
      this.features = new ArrayList<>();
    }
    this.features.add(featuresItem);
    return this;
  }

  /**
   * Array of features of the account based on the equivalent structure in Product Reference with the following additional field
   * @return features
  */
  @ApiModelProperty(value = "Array of features of the account based on the equivalent structure in Product Reference with the following additional field")

  @Valid

  public List<BankingProductFeature> getFeatures() {
    return features;
  }

  public void setFeatures(List<BankingProductFeature> features) {
    this.features = features;
  }

  public BankingAccountDetailAllOf fees(List<BankingProductFee> fees) {
    this.fees = fees;
    return this;
  }

  public BankingAccountDetailAllOf addFeesItem(BankingProductFee feesItem) {
    if (this.fees == null) {
      this.fees = new ArrayList<>();
    }
    this.fees.add(feesItem);
    return this;
  }

  /**
   * Fees and charges applicable to the account based on the equivalent structure in Product Reference
   * @return fees
  */
  @ApiModelProperty(value = "Fees and charges applicable to the account based on the equivalent structure in Product Reference")

  @Valid

  public List<BankingProductFee> getFees() {
    return fees;
  }

  public void setFees(List<BankingProductFee> fees) {
    this.fees = fees;
  }

  public BankingAccountDetailAllOf addresses(List<CommonPhysicalAddress> addresses) {
    this.addresses = addresses;
    return this;
  }

  public BankingAccountDetailAllOf addAddressesItem(CommonPhysicalAddress addressesItem) {
    if (this.addresses == null) {
      this.addresses = new ArrayList<>();
    }
    this.addresses.add(addressesItem);
    return this;
  }

  /**
   * The addresses for the account to be used for correspondence
   * @return addresses
  */
  @ApiModelProperty(value = "The addresses for the account to be used for correspondence")

  @Valid

  public List<CommonPhysicalAddress> getAddresses() {
    return addresses;
  }

  public void setAddresses(List<CommonPhysicalAddress> addresses) {
    this.addresses = addresses;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BankingAccountDetailAllOf bankingAccountDetailAllOf = (BankingAccountDetailAllOf) o;
    return Objects.equals(this.bsb, bankingAccountDetailAllOf.bsb) &&
        Objects.equals(this.accountNumber, bankingAccountDetailAllOf.accountNumber) &&
        Objects.equals(this.bundleName, bankingAccountDetailAllOf.bundleName) &&
        Objects.equals(this.specificAccountUType, bankingAccountDetailAllOf.specificAccountUType) &&
        Objects.equals(this.termDeposit, bankingAccountDetailAllOf.termDeposit) &&
        Objects.equals(this.creditCard, bankingAccountDetailAllOf.creditCard) &&
        Objects.equals(this.loan, bankingAccountDetailAllOf.loan) &&
        Objects.equals(this.depositRate, bankingAccountDetailAllOf.depositRate) &&
        Objects.equals(this.lendingRate, bankingAccountDetailAllOf.lendingRate) &&
        Objects.equals(this.depositRates, bankingAccountDetailAllOf.depositRates) &&
        Objects.equals(this.lendingRates, bankingAccountDetailAllOf.lendingRates) &&
        Objects.equals(this.features, bankingAccountDetailAllOf.features) &&
        Objects.equals(this.fees, bankingAccountDetailAllOf.fees) &&
        Objects.equals(this.addresses, bankingAccountDetailAllOf.addresses);
  }

  @Override
  public int hashCode() {
    return Objects.hash(bsb, accountNumber, bundleName, specificAccountUType, termDeposit, creditCard, loan, depositRate, lendingRate, depositRates, lendingRates, features, fees, addresses);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BankingAccountDetailAllOf {\n");
    
    sb.append("    bsb: ").append(toIndentedString(bsb)).append("\n");
    sb.append("    accountNumber: ").append(toIndentedString(accountNumber)).append("\n");
    sb.append("    bundleName: ").append(toIndentedString(bundleName)).append("\n");
    sb.append("    specificAccountUType: ").append(toIndentedString(specificAccountUType)).append("\n");
    sb.append("    termDeposit: ").append(toIndentedString(termDeposit)).append("\n");
    sb.append("    creditCard: ").append(toIndentedString(creditCard)).append("\n");
    sb.append("    loan: ").append(toIndentedString(loan)).append("\n");
    sb.append("    depositRate: ").append(toIndentedString(depositRate)).append("\n");
    sb.append("    lendingRate: ").append(toIndentedString(lendingRate)).append("\n");
    sb.append("    depositRates: ").append(toIndentedString(depositRates)).append("\n");
    sb.append("    lendingRates: ").append(toIndentedString(lendingRates)).append("\n");
    sb.append("    features: ").append(toIndentedString(features)).append("\n");
    sb.append("    fees: ").append(toIndentedString(fees)).append("\n");
    sb.append("    addresses: ").append(toIndentedString(addresses)).append("\n");
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

