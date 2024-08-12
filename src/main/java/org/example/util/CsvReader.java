package org.example.util;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.example.entity.Employee;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CsvReader{

  public List<Employee> readCsv(String path) throws IOException {

    //get the csv parser from the path
    CSVParser parser = getCsvParser(path);

    //parse the csvfile and return the list of employess
    return parseCsv(parser);
  }

  private List<Employee> parseCSV(CSVParser parser){

    List<Employee> employees = new ArrayList<Employee>();

    for(CSVRecord record : parser){
      Employee employee = new Employee();
      employee.setId(Integer.ParseInt(record.get(EmployeeHeaders.id.name())));
      employee.setFirstName();

      employees.add(employee);
    }
  }

  private CSVParser getCSVParser(String path) throws IOException {
    Reader reader = Files.newBufferedReader(Paths.get(path));

    return new CSVParser(reader , CSVFormat.DEFAULT
                         .withFirstRecordAsHeader()
                         .withIgnoreheaderCase()
                         .withTrim());
  }

  private int getManagerId(CSVRecord record){
      String managerId=record.get(EmployeeHeaders.managerId.name());
      return (managerId==null || managerId.isEmpty()) ? 0 : Integer.parseInt(managerId);
  }

  private enum EmployeeHeader {
    id,firstName,lastName,salary,managerId
  }

}
