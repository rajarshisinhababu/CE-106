package org.example.component;

import org.example.entity.Employee;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmpHierarchy{

  private final Map<Integer,Employee> employeeMap;
  private final Map<Integer,List<Integer>> empHierarchy;
  private int ceoId;

  public EmpHierarchy(){
    employeeMap = new HashMap<Integer,Employee>();
    empHierarchy = new HashMap<Integer,List<Integer>>();
  }

  /**
  * create employee hierchy from the employee list
  *
  * @param employees
  */
  public void createEmployeeHierarchy(List<Employee> employees){

    //put employee details in map by emp-id
    for(Employee employee : employees){
      
      employeeMap.put(employee.getId(),employee);

      //check if the employee is ceo 
      if(employee.getManagerId()==0){
        ceoId=employee.getId();
        continue;
      }

      //add the data in the hierarchy
      if(empHierarchy.get(employee.getManagerId())==null){
        List<Integer> empList = new ArrayList<Integer>();
        empList.add(employee.getId());
        empHierarchy.put(employee.getManagerId(),empList);
      }else{
        empHierarchy.get(employee.getManagerId()).add(employee.getId());
      }   
    }
  }

  public Map<Integer,Employee> getEmployeeMap(){
    return employeeMap;
  }

  public Map<Integer,List<Integer>> getEmpHierarchy(){
    return empHierarchy;
  }

  public int getCeoId(){
    return ceoId;
  }
  
}
