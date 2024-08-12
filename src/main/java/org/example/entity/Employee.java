package org.example.entity;

public class Employee{

  private int id;
  private String firstName;
  private String lastName;
  private int salary;
  private int managerId;

  public int getId(){
    return id;
  }
  
  public void setId(int id){
    this.id=id;
  }
  
  public String getFirstName(){
    return firstName;
  }

  public void setFirstName(String firstName){
    this.firstname=firstName;
  }

  public String getLastName(){
    return lastName;
  }

  public void setLastName(String lastName){
    this.lastName=lastName;
  }

  public int getSalary(){
    return salary;
  }

  public void setSalary(int salary){
    this.salary=salary;
  }

  public int getManagerId(){
    return managerId;
  }

  public void setManagerId(int managerId){
    this.managerId=managerId;
  }

  @Override
  public String toString(){
    return id+" "+firstName+" "+lastName+" "+salary+" "+managerId;
  }
    
}
