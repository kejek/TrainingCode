package com.hr.personnel;

import java.sql.Date;

public class Employee {
  // INSTANCE VARIABLES
  private String name;
  private Date hireDate;
  
  // CONSTRUCTORS
  public Employee() {
  }
  
  public Employee(String name, Date hireDate) {
    setName(name);
    setHireDate(hireDate);
  }
  
  // BEHAVIORAL METHODS
  public void work() {
    System.out.println(getName() + " working hard since " + getHireDate());
  }
  
  // ACCESSOR METHODS
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  
  public Date getHireDate() {
    return hireDate;
  }
  public void setHireDate(Date hireDate) {
    this.hireDate = hireDate;
  }
  
  public String toString() {
    return "Employee: name=" + getName() + ", hireDate=" + getHireDate();
  }
}