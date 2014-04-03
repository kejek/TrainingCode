package com.hr.personnel;

import gov.irs.TaxPayer;
import java.sql.Date;

public class HourlyEmployee
extends Employee
implements TaxPayer {
  // CLASS CONSTANTS
  public static final double TAX_RATE = 0.25;
  
  // INSTANCE VARIABLES
  private double rate;
  private double hours;
  
  // CONSTRUCTORS
  public HourlyEmployee() {
    super();
  }
  
  public HourlyEmployee(String name, Date hireDate) {
    super(name, hireDate);  // pass common data to superclass ctor
  }
  
  public HourlyEmployee(String name, Date hireDate, double rate, double hours) {
    super(name, hireDate);  // pass common data to superclass ctor
    setRate(rate);          // deal with subclass data here
    setHours(hours);
  }
  
  // BEHAVIORAL METHODS
  // DONE: implement pay() method by printing message: <name> is paid hourly <value>
  public void pay() {
    System.out.println(getName() + " is paid hourly " + (getRate() * getHours()));
  }
  
  // from interface Taxpayer
  public void payTaxes() {
    System.out.println(getName() + " paid taxes of " + TAX_RATE * (getRate() * getHours()));
  }
  
  // ACCESSOR METHODS
  public double getRate() {
    return rate;
  }
  public void setRate(double rate) {
    this.rate = rate;
  }
  
  public double getHours() {
    return hours;
  }
  public void setHours(double hours) {
    this.hours = hours;
  }
  
  public String toString() {
    return super.toString() + ", rate=" + getRate() + ", hours=" + getHours();
  }
}