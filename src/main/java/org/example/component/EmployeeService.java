package org.example.component;

public class EmployeeService{

  public void getPayDifference(EmpHierarchy empHierarchy){

    EmployeeUtil employeeUtil = new EmployeeUtil();

    for(Integer managerId : empHierarchy.getEmployeeHierarchy().keySet()){

      //get all the subordinates of a manager
      List<Integer> subOrdinates = empHierarchy.getEmployeeHierarchy().get(managerId);

      if(subOrdinates.isEmpty())continue;

      int totalSalary = subordinates.stream().
                        mapToInt(empId -> empHierarchy.getEmployeeMap().get(empId).getSalary()).
                        sum();
      int managerSalary = empHierarchy.getEmployeeMap().get(managerId).getSalary();
      int avgSubSalary = totalSubSalary/subOrdinates.size();
      int underPaidSal = avgSubSalary + (int) (avgSalary * 0.2);
      int overPaidSal = avgSubSalary + (int) (avgSalary * 0.5);
      int salaryPercent = employeeUtil.calPercentage(managerSalary,avgSubSalary);

      if(managerSalary < underPaidSal && salaryPercent < Constants.MIN_MANAGER_SALARY_PERCENTAGE){
        System.out.println("Manager Id :"+employeeUtil.getEmpNamefromId(managerId,empHierarchy)+" is underpaid by "+ (underPaidSal - managerSal));      
      }else if(managerSalary> overPaidSal && salaryPercent > Constants.MAX_MANAGER_SALARY_PERCENTAGE){
        System.out.println("Manager Id:"+employeeUtil.getEmpnameFromId(managerId,empHierarchy)+ " is overpaid by "+ (managerSal- overPaidSal));
      }
    }
    
  }
}
