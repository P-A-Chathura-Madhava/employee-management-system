package lk.ctech.employeemanagementsystem.service;

import lk.ctech.employeemanagementsystem.model.Employee;
import lk.ctech.employeemanagementsystem.repo.EmployeeRepo;
import lk.ctech.employeemanagementsystem.util.VarList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepo employeeRepo;


    @Override
    public String saveEmployee(Employee employee) {
        if (employeeRepo.existsById(employee.getId())){
            return VarList.RSP_DUPLICATED;
        }else {
            employeeRepo.save(employee);
            return VarList.RSP_SUCCESS;
        }
    }

    @Override
    public String updateEmployee(Employee employee) {
        if (employeeRepo.existsById(employee.getId())){
            employeeRepo.save(employee);
            return VarList.RSP_SUCCESS;
        }else {
            return VarList.RSP_NO_DATA_FOUND;
        }
    }
}
