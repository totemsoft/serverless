package au.com.totemsoft.openbanking.cds.v1.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * The category to which a product or account belongs. See [here](#product-categories) for more details
 */
public enum BankingProductCategory {
  
  TRANS_AND_SAVINGS_ACCOUNTS("TRANS_AND_SAVINGS_ACCOUNTS"),
  
  TERM_DEPOSITS("TERM_DEPOSITS"),
  
  TRAVEL_CARDS("TRAVEL_CARDS"),
  
  REGULATED_TRUST_ACCOUNTS("REGULATED_TRUST_ACCOUNTS"),
  
  RESIDENTIAL_MORTGAGES("RESIDENTIAL_MORTGAGES"),
  
  CRED_AND_CHRG_CARDS("CRED_AND_CHRG_CARDS"),
  
  PERS_LOANS("PERS_LOANS"),
  
  MARGIN_LOANS("MARGIN_LOANS"),
  
  LEASES("LEASES"),
  
  TRADE_FINANCE("TRADE_FINANCE"),
  
  OVERDRAFTS("OVERDRAFTS"),
  
  BUSINESS_LOANS("BUSINESS_LOANS");

  private String value;

  BankingProductCategory(String value) {
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
  public static BankingProductCategory fromValue(String value) {
    for (BankingProductCategory b : BankingProductCategory.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }
}

