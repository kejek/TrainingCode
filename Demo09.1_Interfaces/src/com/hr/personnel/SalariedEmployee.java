package com.hr.personnel;

import gov.irs.TaxPayer;
import java.sql.Date;

public class SalariedEmployee
extends Employee
implements TaxPayer {
  // CLASS CONSTANTS
  public static final double TAX_RATE = 0.30;
  
  // INSTANCE VARIABLES
  private double salary;
  
  // CONSTRUCTORS
  public SalariedEmployee() {
    super();
  }

  public SalariedEmployee(String name, Date hireDate) {
    super(name, hireDate);  // pass common data to superclass ctor
  }
  
  public SalariedEmployee(String name, Date hireDate, double salary) {
    super(name, hireDate);  // pass common data to superclass ctor
    setSalary(salary);      // deal with subclass data here
  }
  
  // BEHAVIORAL METHODS
  // DONE: implement pay() method by printing message: <name> is paid salary <value>
  public void pay() {
    System.out.println(getName() + " is paid salary " + getSalary());
  }
  
  // from interface Taxpayer
  public void payTaxes() {
    System.out.println(getName() + " paid taxes of " + (TAX_RATE * getSalary()));
  }
  
  // ACCESSOR METHODS
  public double getSalary() {
    return salary;
  }
  public void setSalary(double salary) {
    this.salary = salary;
  }
  
  public String toString() {
    return super.toString() + ", salary=" + getSalary();
  }
}