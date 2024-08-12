package org.example.util;

import org.example.component.EmpHierarchy;
import org.example.entity.Employee;

/**
* Utility class for the Employee related operations
*/
public class EmployeeUtil{

  /**
 * Calculate the percentage difference between manager and subordinates salary.
 *
 * @param managerSalary      the salary of the manager
 * @param subordinatesSalary the total salary of the subordinates
 * @return the percentage difference between manager and subordinates salary
 */
  public int calPercentage(int managerSalary, int subordinateSalary){
    return Math.abs(managerSalary-subordinateSalary)*100 / managerSalary;
  }

  /**
 * Get employee name from employee id.
 *
 * @param empId        the employee id
 * @param empHierarchy the employee hierarchy containing employee details
 * @return the full name of the employee
 */
  public String getEmpNameFromId(int empId, EmpHierarchy empHierarchy){
    Employee emp =   empHierarchy.getEmployeeMap().get(empId);

    if(emp==null) return null;

    return emp.getFirstName() + " " + emp.getLastName();
  }
}
