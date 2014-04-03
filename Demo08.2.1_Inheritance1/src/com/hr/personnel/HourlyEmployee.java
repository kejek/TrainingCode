package com.hr.personnel;

import java.sql.Date;

public class HourlyEmployee
extends Employee {
  // INSTANCE VARIABLES
  private double rate;
  private double hours;
  
  // CONSTRUCTORS
  public HourlyEmployee() {
  }
  
  public HourlyEmployee(String name, Date hireDate) {
    setName(name);
    setHireDate(hireDate);
  }
  
  public HourlyEmployee(String name, Date hireDate, double rate, double hours) {
    setName(name);
    setHireDate(hireDate);
    setRate(rate);
    setHours(hours);
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
    return "HourlyEmployee: name=" + getName() + ", hireDate=" + getHireDate() +
      ", rate=" + getRate() + ", hours=" + getHours();
  }  
}