package com.hr.personnel;

import java.sql.Date;

public class SalariedEmployee
extends Employee {
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
  // TODO: implement pay() method by printing message: <name> is paid salary <value>
  public void pay() {
    
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