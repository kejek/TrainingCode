package com.hr.personnel;

import java.sql.Date;

public class SalariedEmployee
extends Employee {
  // INSTANCE VARIABLES
  private double salary;
  
  // CONSTRUCTORS
  public SalariedEmployee() {
  }

  public SalariedEmployee(String name, Date hireDate) {
    setName(name);
    setHireDate(hireDate);
  }
  
  public SalariedEmployee(String name, Date hireDate, double salary) {
    setName(name);
    setHireDate(hireDate);
    setSalary(salary);
  }
  
  // ACCESSOR METHODS
  public double getSalary() {
    return salary;
  }
  public void setSalary(double salary) {
    this.salary = salary;
  }
  
  public String toString() {
    return "SalariedEmployee: name=" + getName() + ", hireDate=" + getHireDate() +
      ", salary=" + getSalary();
  }
}