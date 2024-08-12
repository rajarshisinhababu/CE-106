package org.example.component;

import org.example.entity.Employee;
import org.example.util.Constants;
import org.example.util.CsvReader;
import org.example.util.EmployeeUtil;
import java.io.IOException;
import java.util.*;

public class EmployeeService{

  public void getPayDifference(EmpHierarchy empHierarchy){

    EmployeeUtil employeeUtil = new EmployeeUtil();

    for(Integer managerId : empHierarchy.getEmpHierarchy().keySet()){

      //get all the subordinates of a manager
      List<Integer> subordinates = empHierarchy.getEmpHierarchy().get(managerId);

      if(subOrdinates.isEmpty())continue;

      int totalSubSalary = subordinates.stream().
                        mapToInt(empId -> empHierarchy.getEmployeeMap().get(empId).getSalary()).
                        sum();
      int managerSalary = empHierarchy.getEmployeeMap().get(managerId).getSalary();
      int avgSubSalary = totalSubSalary/subOrdinates.size();
      int underPaidSal = avgSubSalary + (int) (avgSubSalary * 0.2);
      int overPaidSal = avgSubSalary + (int) (avgSubSalary * 0.5);
      int salaryPercent = employeeUtil.calPercentage(managerSalary,avgSubSalary);

      if(managerSalary < underPaidSal && salaryPercent < Constants.MIN_MANAGER_SALARY_PERCENTAGE){
        System.out.println("Manager Id :"+employeeUtil.getEmpNamefromId(managerId,empHierarchy)+" is underpaid by "+ (underPaidSal - managerSalary));      
      }else if(managerSalary> overPaidSal && salaryPercent > Constants.MAX_MANAGER_SALARY_PERCENTAGE){
        System.out.println("Manager Id:"+employeeUtil.getEmpnameFromId(managerId,empHierarchy)+ " is overpaid by "+ (managerSalary- overPaidSal));
      }    
  }
}
  
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

  public List<Employee> loadEmployeeFromCSVFile(String filePath){
    try{
      return new CsvReader().readCsv(filePath);
    }catch(IOException e){
        System.out.println("CSV file path not found");
        return ;
    }
  }
}
