package gov.irs;

public class IRS {
  // INSTANCE VARIABLES
  private TaxPayer[] payers = new TaxPayer[100];
  private int currentIndex = 0;  // for dealing with array
  
  // BEHAVIORAL METHODS
  public void collectTaxes() {
    for (int i = 0; i < currentIndex; i++) {
      payers[i].payTaxes();
    }
  }
  
  // helper method to add a Taxpayer to the array
  public void register(TaxPayer payer) {
    payers[currentIndex++] = payer;
  }
}