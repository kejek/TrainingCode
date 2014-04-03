package com.company;

import gov.irs.TaxPayer;

public class Corporation
implements TaxPayer {
  
  // from interface Taxpayer
  public void payTaxes() {
    System.out.println("Corporation paid no taxes - we lobbied hard and it worked");
  }
}