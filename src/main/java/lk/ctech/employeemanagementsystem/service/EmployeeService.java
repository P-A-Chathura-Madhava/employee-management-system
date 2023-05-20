package lk.ctech.employeemanagementsystem.service;

import lk.ctech.employeemanagementsystem.model.Employee;

public interface EmployeeService {
    String saveEmployee(Employee employee);
    String updateEmployee(Employee employee);
}
