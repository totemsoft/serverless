package au.com.totemsoft.openbanking.cds.v1.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import io.swagger.annotations.ApiModelProperty;

/**
 * BankingAccountDetail
 */

public class BankingAccountDetail   {
  @JsonProperty("accountId")
  private String accountId;

  @JsonProperty("creationDate")
  private String creationDate;

  @JsonProperty("displayName")
  private String displayName;

  @JsonProperty("nickname")
  private String nickname;

  /**
   * Open or closed status for the account. If not present then OPEN is assumed
   */
  public enum OpenStatusEnum {
    OPEN("OPEN"),
    
    CLOSED("CLOSED");

    private String value;

    OpenStatusEnum(String value) {
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
    public static OpenStatusEnum fromValue(String value) {
      for (OpenStatusEnum b : OpenStatusEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  @JsonProperty("openStatus")
  private OpenStatusEnum openStatus = OpenStatusEnum.OPEN;

  @JsonProperty("isOwned")
  private Boolean isOwned = true;

  @JsonProperty("maskedNumber")
  private String maskedNumber;

  @JsonProperty("productCategory")
  private BankingProductCategory productCategory;

  @JsonProperty("productName")
  private String productName;

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

  public BankingAccountDetail accountId(String accountId) {
    this.accountId = accountId;
    return this;
  }

  /**
   * A unique ID of the account adhering to the standards for ID permanence
   * @return accountId
  */
  @ApiModelProperty(required = true, value = "A unique ID of the account adhering to the standards for ID permanence")
  @NotNull


  public String getAccountId() {
    return accountId;
  }

  public void setAccountId(String accountId) {
    this.accountId = accountId;
  }

  public BankingAccountDetail creationDate(String creationDate) {
    this.creationDate = creationDate;
    return this;
  }

  /**
   * Date that the account was created (if known)
   * @return creationDate
  */
  @ApiModelProperty(value = "Date that the account was created (if known)")


  public String getCreationDate() {
    return creationDate;
  }

  public void setCreationDate(String creationDate) {
    this.creationDate = creationDate;
  }

  public BankingAccountDetail displayName(String displayName) {
    this.displayName = displayName;
    return this;
  }

  /**
   * The display name of the account as defined by the bank. This should not incorporate account numbers or PANs. If it does the values should be masked according to the rules of the MaskedAccountString common type.
   * @return displayName
  */
  @ApiModelProperty(required = true, value = "The display name of the account as defined by the bank. This should not incorporate account numbers or PANs. If it does the values should be masked according to the rules of the MaskedAccountString common type.")
  @NotNull


  public String getDisplayName() {
    return displayName;
  }

  public void setDisplayName(String displayName) {
    this.displayName = displayName;
  }

  public BankingAccountDetail nickname(String nickname) {
    this.nickname = nickname;
    return this;
  }

  /**
   * A customer supplied nick name for the account
   * @return nickname
  */
  @ApiModelProperty(value = "A customer supplied nick name for the account")


  public String getNickname() {
    return nickname;
  }

  public void setNickname(String nickname) {
    this.nickname = nickname;
  }

  public BankingAccountDetail openStatus(OpenStatusEnum openStatus) {
    this.openStatus = openStatus;
    return this;
  }

  /**
   * Open or closed status for the account. If not present then OPEN is assumed
   * @return openStatus
  */
  @ApiModelProperty(value = "Open or closed status for the account. If not present then OPEN is assumed")


  public OpenStatusEnum getOpenStatus() {
    return openStatus;
  }

  public void setOpenStatus(OpenStatusEnum openStatus) {
    this.openStatus = openStatus;
  }

  public BankingAccountDetail isOwned(Boolean isOwned) {
    this.isOwned = isOwned;
    return this;
  }

  /**
   * Flag indicating that the customer associated with the authorisation is an owner of the account. Does not indicate sole ownership, however. If not present then 'true' is assumed
   * @return isOwned
  */
  @ApiModelProperty(value = "Flag indicating that the customer associated with the authorisation is an owner of the account. Does not indicate sole ownership, however. If not present then 'true' is assumed")


  public Boolean getIsOwned() {
    return isOwned;
  }

  public void setIsOwned(Boolean isOwned) {
    this.isOwned = isOwned;
  }

  public BankingAccountDetail maskedNumber(String maskedNumber) {
    this.maskedNumber = maskedNumber;
    return this;
  }

  /**
   * A masked version of the account. Whether BSB/Account Number, Credit Card PAN or another number
   * @return maskedNumber
  */
  @ApiModelProperty(required = true, value = "A masked version of the account. Whether BSB/Account Number, Credit Card PAN or another number")
  @NotNull


  public String getMaskedNumber() {
    return maskedNumber;
  }

  public void setMaskedNumber(String maskedNumber) {
    this.maskedNumber = maskedNumber;
  }

  public BankingAccountDetail productCategory(BankingProductCategory productCategory) {
    this.productCategory = productCategory;
    return this;
  }

  /**
   * Get productCategory
   * @return productCategory
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid

  public BankingProductCategory getProductCategory() {
    return productCategory;
  }

  public void setProductCategory(BankingProductCategory productCategory) {
    this.productCategory = productCategory;
  }

  public BankingAccountDetail productName(String productName) {
    this.productName = productName;
    return this;
  }

  /**
   * The unique identifier of the account as defined by the data holder (akin to model number for the account)
   * @return productName
  */
  @ApiModelProperty(required = true, value = "The unique identifier of the account as defined by the data holder (akin to model number for the account)")
  @NotNull


  public String getProductName() {
    return productName;
  }

  public void setProductName(String productName) {
    this.productName = productName;
  }

  public BankingAccountDetail bsb(String bsb) {
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

  public BankingAccountDetail accountNumber(String accountNumber) {
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

  public BankingAccountDetail bundleName(String bundleName) {
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

  public BankingAccountDetail specificAccountUType(SpecificAccountUTypeEnum specificAccountUType) {
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

  public BankingAccountDetail termDeposit(List<BankingTermDepositAccount> termDeposit) {
    this.termDeposit = termDeposit;
    return this;
  }

  public BankingAccountDetail addTermDepositItem(BankingTermDepositAccount termDepositItem) {
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

  public BankingAccountDetail creditCard(BankingCreditCardAccount creditCard) {
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

  public BankingAccountDetail loan(BankingLoanAccount loan) {
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

  public BankingAccountDetail depositRate(String depositRate) {
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

  public BankingAccountDetail lendingRate(String lendingRate) {
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

  public BankingAccountDetail depositRates(List<BankingProductDepositRate> depositRates) {
    this.depositRates = depositRates;
    return this;
  }

  public BankingAccountDetail addDepositRatesItem(BankingProductDepositRate depositRatesItem) {
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

  public BankingAccountDetail lendingRates(List<BankingProductLendingRate> lendingRates) {
    this.lendingRates = lendingRates;
    return this;
  }

  public BankingAccountDetail addLendingRatesItem(BankingProductLendingRate lendingRatesItem) {
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

  public BankingAccountDetail features(List<BankingProductFeature> features) {
    this.features = features;
    return this;
  }

  public BankingAccountDetail addFeaturesItem(BankingProductFeature featuresItem) {
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

  public BankingAccountDetail fees(List<BankingProductFee> fees) {
    this.fees = fees;
    return this;
  }

  public BankingAccountDetail addFeesItem(BankingProductFee feesItem) {
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

  public BankingAccountDetail addresses(List<CommonPhysicalAddress> addresses) {
    this.addresses = addresses;
    return this;
  }

  public BankingAccountDetail addAddressesItem(CommonPhysicalAddress addressesItem) {
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
    BankingAccountDetail bankingAccountDetail = (BankingAccountDetail) o;
    return Objects.equals(this.accountId, bankingAccountDetail.accountId) &&
        Objects.equals(this.creationDate, bankingAccountDetail.creationDate) &&
        Objects.equals(this.displayName, bankingAccountDetail.displayName) &&
        Objects.equals(this.nickname, bankingAccountDetail.nickname) &&
        Objects.equals(this.openStatus, bankingAccountDetail.openStatus) &&
        Objects.equals(this.isOwned, bankingAccountDetail.isOwned) &&
        Objects.equals(this.maskedNumber, bankingAccountDetail.maskedNumber) &&
        Objects.equals(this.productCategory, bankingAccountDetail.productCategory) &&
        Objects.equals(this.productName, bankingAccountDetail.productName) &&
        Objects.equals(this.bsb, bankingAccountDetail.bsb) &&
        Objects.equals(this.accountNumber, bankingAccountDetail.accountNumber) &&
        Objects.equals(this.bundleName, bankingAccountDetail.bundleName) &&
        Objects.equals(this.specificAccountUType, bankingAccountDetail.specificAccountUType) &&
        Objects.equals(this.termDeposit, bankingAccountDetail.termDeposit) &&
        Objects.equals(this.creditCard, bankingAccountDetail.creditCard) &&
        Objects.equals(this.loan, bankingAccountDetail.loan) &&
        Objects.equals(this.depositRate, bankingAccountDetail.depositRate) &&
        Objects.equals(this.lendingRate, bankingAccountDetail.lendingRate) &&
        Objects.equals(this.depositRates, bankingAccountDetail.depositRates) &&
        Objects.equals(this.lendingRates, bankingAccountDetail.lendingRates) &&
        Objects.equals(this.features, bankingAccountDetail.features) &&
        Objects.equals(this.fees, bankingAccountDetail.fees) &&
        Objects.equals(this.addresses, bankingAccountDetail.addresses);
  }

  @Override
  public int hashCode() {
    return Objects.hash(accountId, creationDate, displayName, nickname, openStatus, isOwned, maskedNumber, productCategory, productName, bsb, accountNumber, bundleName, specificAccountUType, termDeposit, creditCard, loan, depositRate, lendingRate, depositRates, lendingRates, features, fees, addresses);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BankingAccountDetail {\n");
    
    sb.append("    accountId: ").append(toIndentedString(accountId)).append("\n");
    sb.append("    creationDate: ").append(toIndentedString(creationDate)).append("\n");
    sb.append("    displayName: ").append(toIndentedString(displayName)).append("\n");
    sb.append("    nickname: ").append(toIndentedString(nickname)).append("\n");
    sb.append("    openStatus: ").append(toIndentedString(openStatus)).append("\n");
    sb.append("    isOwned: ").append(toIndentedString(isOwned)).append("\n");
    sb.append("    maskedNumber: ").append(toIndentedString(maskedNumber)).append("\n");
    sb.append("    productCategory: ").append(toIndentedString(productCategory)).append("\n");
    sb.append("    productName: ").append(toIndentedString(productName)).append("\n");
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

