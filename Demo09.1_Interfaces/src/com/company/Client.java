package com.company;

import gov.irs.IRS;

public class Client {

  public static void main(String[] args) {
    // create the IRS
    IRS irs = new IRS();
        
    // create the Corporation
    Corporation corp = new Corporation();
    
    // register the Corporation with the IRS
    irs.register(corp);
    
    // IRS collects taxes
    System.out.println("IRS collects taxes");
    irs.collectTaxes();
  }
}