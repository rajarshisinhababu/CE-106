package org.example.component;

import org.example.entity.Employee;
import org.example.util.Constants;
import org.example.util.CsvReader;
import org.example.util.EmployeeUtil;
import java.io.IOException;
import java.util.*;

public class EmployeeService{

  /**
  * calculate the pay difference of each manager and print if there are overpaid or underpaid
  * that every manager earns at least 20% more than the average salary of its direct subordinates, but no more than 50% more than that average.
  *
  * @param empHierarchy
  */
  public void getPayDifference(EmpHierarchy empHierarchy){

    EmployeeUtil employeeUtil = new EmployeeUtil();

    for(Integer managerId : empHierarchy.getEmpHierarchy().keySet()){

      //get all the subordinates of a manager
      List<Integer> subordinates = empHierarchy.getEmpHierarchy().get(managerId);

      if(subordinates.isEmpty())continue;

      int totalSubSalary = subordinates.stream().
                        mapToInt(empId -> empHierarchy.getEmployeeMap().get(empId).getSalary()).
                        sum();
      int managerSalary = empHierarchy.getEmployeeMap().get(managerId).getSalary();
      int avgSubSalary = totalSubSalary/subordinates.size();
      int underPaidSal = avgSubSalary + (int) (avgSubSalary * 0.2);
      int overPaidSal = avgSubSalary + (int) (avgSubSalary * 0.5);
      int salaryPercent = employeeUtil.calPercentage(managerSalary,avgSubSalary);

      if(managerSalary < underPaidSal && salaryPercent < Constants.MIN_MANAGER_SALARY_PERCENTAGE){
        System.out.println("Manager Id :"+employeeUtil.getEmpNameFromId(managerId,empHierarchy)+" is underpaid by "+ (underPaidSal - managerSalary));      
      }else if(managerSalary> overPaidSal && salaryPercent > Constants.MAX_MANAGER_SALARY_PERCENTAGE){
        System.out.println("Manager Id:"+employeeUtil.getEmpNameFromId(managerId,empHierarchy)+ " is overpaid by "+ (managerSalary- overPaidSal));
      }    
  }
}

  /**
  * identify all employees who have more than 4 manager between them and CEO
  *
  * @param empHierarchy
  */
  public void getEmployeeWithMostHierarchy(EmpHierarchy empHierarchy){

    EmployeeUtil employeeUtil = new EmployeeUtil();
    Queue<Integer> queue = new LinkedList<>();
    Set<Integer> visited = new HashSet<>();
    Map<Integer,Integer> deapth = new HashMap<Integer,Integer>();
    int ceoId = empHierarchy.getCeoId();
    queue.add(ceoId);
    visited.add(ceoId);
    deapth.put(ceoId,0);
    while(!queue.isEmpty()){
      int currentNode = queue.poll();
      List<Integer> neighbours = empHierarchy.getEmpHierarchy().get(currentNode);
      if(neighbours!=null){
        for(int neighbour : neighbours){
          if(!visited.contains(neighbour)){
            visited.add(neighbour);
            queue.add(neighbour);
            deapth.put(neighbour,deapth.get(currentNode)+1);
            if(deapth.get(neighbour) > Constants.MAX_HIERARCHY_LEVEL)
              System.out.println("Employee : "+employeeUtil.getEmpNameFromId(neighbour,empHierarchy)+" has a reporting line longer by " + deapth.get(neighbour)+ "level");
          }
        }
      }
    }
  }

  /**
  * load employee data from CSV file
  *
  * @param filePath
  * @return list of employees, or null if file not found
  */
  public List<Employee> loadEmployeeDataFromCSV(String filePath){
    try{
      return new CsvReader().readCsv(filePath);
    }catch(IOException e){
        System.out.println("CSV file path not found");
        return null;
    }
  }
}
