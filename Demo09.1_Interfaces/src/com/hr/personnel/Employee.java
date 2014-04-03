package com.hr.personnel;

import java.sql.Date;

// make class abstract
public abstract class Employee {
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
  
  // make pay() method abstract
  public abstract void pay();
  
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
    return getClass().getName() + ": name=" + getName() + ", hireDate=" + getHireDate();
  }
}