package org.example.util;


/**
* Utility class for the Employee related operations
*/
public class EmployeeUtil{

  public int calPercentage(int managerSalary, int subordinateSalary){
    return Math.abs(managerSalary-subordinateSalary)*100 / managerSalary;
  }

  public String getEmpNameFromId(int empId, EmpHierarchy empHierarchy){
    Employee emp =   empHierarchy.getEmployeeMap().get(empId);

    if(emp==null) return null;

    return emp.getFirstName() + " " + emp.getLastName();
  }
}
