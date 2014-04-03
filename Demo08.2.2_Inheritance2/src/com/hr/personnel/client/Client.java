package com.hr.personnel.client;

import java.sql.Date;
import com.hr.personnel.Department;
import com.hr.personnel.Employee;
import com.hr.personnel.HourlyEmployee;
import com.hr.personnel.SalariedEmployee;

public class Client {

  public static void main(String[] args) {
    // create Department object
    Department dept = new Department("Sales", "Seattle");
    System.out.println(dept);
    
    // add Employees to it
    dept.addEmployee(new Employee("Jason", Date.valueOf("1990-08-24")));
    dept.addEmployee(new Employee("Tina", Date.valueOf("2000-02-02")));
    
    // DONE: add an HourlyEmployee and a SalariedEmployee to it
    dept.addEmployee(new HourlyEmployee("John", Date.valueOf("2010-10-11"), 25, 40));
    dept.addEmployee(new SalariedEmployee("Jane", Date.valueOf("2005-07-01"), 50000));
    
    // list its Employees
    System.out.println("\nList employees:");
    dept.listEmployees();
    
    // make its Employees work
    System.out.println("\nMake employees work:");
    dept.workEmployees();
    
    // pay the Employees
    System.out.println("\nPay employees:");
    dept.payEmployees();
  }
}