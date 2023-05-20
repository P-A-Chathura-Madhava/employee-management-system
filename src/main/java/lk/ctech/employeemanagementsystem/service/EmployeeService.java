package lk.ctech.employeemanagementsystem.service;

import lk.ctech.employeemanagementsystem.model.Employee;

import java.util.List;

public interface EmployeeService {
    String saveEmployee(Employee employee);
    String updateEmployee(Employee employee);
    List<Employee> getAllEmployees();
    Employee searchEmployeeById(int id);
    String deleteEmployeeById(int id);
}
