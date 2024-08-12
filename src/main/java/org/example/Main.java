package org.example;

import org.example.component.EmpHierarchy;
import org.example.component.EmployeeService;
import org.example.entity.Employee;
import org.example.util.Constants;
import java.util.list;

/**
* Main class to run the employee management application
**/
public class Main{

  public static void main(String[] args){

  //load employee data from csv
  List<Employee> employees = new EmployeeService().loadEmployeeDataFromCSV(Constants.CSV_FILE_ADDRESS);

  //create the employee hierarchy
  EmpHierarchy empHierarchy = new EmpHierarchy();
  empHierarchy.createEmployeeHierarchy(employees);

  //get underpaid/overpaid managers
  EmployeeService employeeService = new EmployeeService();
  employeeService.getPayDifference(empHierarchy);

  //get employees who have more than 4 managers
  System.out.println();
  employeeService.getEmployeeWithMostHierarchy(empHierarchy);
  }
}
