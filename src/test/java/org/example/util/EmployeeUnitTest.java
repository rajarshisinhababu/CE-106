package org.example.util;

import org.example.component.EmpHierarchy;
import org.example.entity.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.unit.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

class EmployeeUnitTest{

  private EmployeeUtil employeeUtil;
  private EmpHiearchy empHieararchy;

  @BeforeEach
  void setup(){
    empHierarchy = new EmpHierarchy();
    employeeUtil = new EmployeeUtil();
    Employee emp1 = new Employee();
    emp1.setId(1);
    emp1.setFirstName("John");
    emp1.setLastName("Doe");
    emp1.setSalary(1000);
    emp1.setManager(0);
    Employee emp2 = new Employee();
    emp2.setId(2);
    emp2.setFirstName("Jane");
    emp2.setLastName("Smith");
    emp2.setSalary(800);
    emp2.setManagerId(1);
    List<Employee> employees = List.of(empp1,emp2);
    empHiearchy.createEmployeeHieararchy(employee);
  }

  @Test
  void calPercentage_shoudReturnCorrectPerOfDiff(){
      int result = employeeUtil.calPercentage(1000,1000);
      assertEqual(0,result);
  }

  @Test
  void calPercentage_shoulReturnZerodSalaryEqual(){
      int result = employeeUtil.calPercentage(1000,1000);
      assertEqual(0,result);
  }

  @Test
  void calPercentage_shouldReturnCorrectPercentageWhenManagerSalaryLess(){
    int result = employeeUti.calPercent(800,1000);
    assertEqual(25,result);
  }

  @Test
  void getEmpFromId_shouldReturnCorrectEmpName(){
    String result = empUtil.getEmpNameFromId(1,empHierarchy);
    assertEquals("John Doe", result);
  }

  @Test
  void getEmpFromId_shouldReturnNullWhenNotFound(){
    String result = empUtil.getEmpNameFromId(19,empHiearchy);
    assertEquals(null,result);
  }

}
