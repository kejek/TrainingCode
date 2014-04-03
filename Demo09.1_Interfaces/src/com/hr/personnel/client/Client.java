package com.hr.personnel.client;

import gov.irs.IRS;
import java.sql.Date;
import com.hr.personnel.HourlyEmployee;
import com.hr.personnel.SalariedEmployee;

public class Client {

  public static void main(String[] args) {
    // create the IRS
    IRS irs = new IRS();
    
    // create Employees (Hourly or Salaried), and register them with the IRS
    irs.register(new HourlyEmployee("Jason", Date.valueOf("1990-08-24"), 30, 40));
    irs.register(new SalariedEmployee("Tina", Date.valueOf("2000-02-02"), 45000));
    irs.register(new HourlyEmployee("John", Date.valueOf("2010-10-11"), 25, 40));
    irs.register(new SalariedEmployee("Jane", Date.valueOf("2005-07-01"), 50000));
        
    // IRS collects taxes
    System.out.println("IRS collects taxes");
    irs.collectTaxes();
  }
}