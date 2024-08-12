package org.example.util;

public class Constants{

  // Path to the employee CSV file
  public static final String CSV_FILE_ADDRESS="src/main/resources/employee.csv";

  // Minimum percentage difference between manager and subordinates' average salary
  public static final int MIN_MANAGER_SALARY_PERCENTAGE=20;

  // Maximum percentage difference between manager and subordinates' average salary
  public static final int MAX_MANAGER_SALARY_PERCENTAGE=50;

  // Maximum hierarchy level allowed between an employee and the CEO
  public static final int MAX_HIERARCHY_LEVEL=4;
}
