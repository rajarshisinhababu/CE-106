package org.example.component;

public class EmpHierarchy{

  private final Map<Integer,Employee> employeeMap;
  private final Map<Integer,List<Integer>> empHierarchy;
  private int ceo;

  public EmpHierarchy(){
    employeeMap = new HashMap<Integer,Employee>();
    empHierarchy = new HashMap<Integer,List<Integer>>();
  }

  public void createEmployeeHierarchy(List<Employee> employees){

    //put employee details in map by emp-id
    for(Employee employee : employees){
      
      employeeMap.put(employee.getId(),employee);

      //check if the employee is ceo 
      if(employee.getManagerId()==0){
        ceo=employee.getId();
        continue;
      }

      //add the data in the hierarchy
      if(empHierarchy.get(employee.getManagerId))==null){
        List<Integer> empList = new ArrayList<Integer>();
        empList.add(employee.getId);
        empHierarchy.put(employee.getManagerId(),empList);
      }else{
        empHierarchy.get(employee.getManagerid()).add(employee.getId());
      }
      
    }
  }

  
  
}
