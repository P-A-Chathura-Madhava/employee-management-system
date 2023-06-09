package lk.ctech.employeemanagementsystem.controller;

import lk.ctech.employeemanagementsystem.model.Employee;
import lk.ctech.employeemanagementsystem.dto.Response;
import lk.ctech.employeemanagementsystem.service.EmployeeService;
import lk.ctech.employeemanagementsystem.util.VarList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employee_management_system")
@CrossOrigin
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private Response response;

    @PostMapping("/saveEmployee")
    public ResponseEntity saveEmployee(@RequestBody Employee employee){
        try {
            String result = employeeService.saveEmployee(employee);
            if (result.equals("00")){
                response.setCode(VarList.RSP_SUCCESS);
                response.setMessage("Success");
                response.setContent(employee);
                return new ResponseEntity(response, HttpStatus.ACCEPTED);
            } else if (result.equals("06")) {
                response.setCode(VarList.RSP_DUPLICATED);
                response.setMessage("Registered Employee");
                response.setContent(employee);
                return new ResponseEntity(response, HttpStatus.BAD_REQUEST);
            }else {
                response.setCode(VarList.RSP_ERROR);
                response.setMessage("Error");
                response.setContent(null);
                return new ResponseEntity(response, HttpStatus.BAD_REQUEST);
            }
        }catch (Exception ex){
            response.setCode(VarList.RSP_ERROR);
            response.setMessage(ex.getMessage());
            response.setContent(null);
            return new ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping("/updateEmployee")
    public ResponseEntity updateEmployee(@RequestBody Employee employee){
        try {
            String result = employeeService.updateEmployee(employee);
            if (result.equals("00")){
                response.setCode(VarList.RSP_SUCCESS);
                response.setMessage("Success");
                response.setContent(employee);
                return new ResponseEntity(response, HttpStatus.ACCEPTED);
            } else if (result.equals("01")) {
                response.setCode(VarList.RSP_NO_DATA_FOUND);
                response.setMessage("Not a registered Employee");
                response.setContent(employee);
                return new ResponseEntity(response, HttpStatus.BAD_REQUEST);
            }else {
                response.setCode(VarList.RSP_ERROR);
                response.setMessage("Error");
                response.setContent(null);
                return new ResponseEntity(response, HttpStatus.BAD_REQUEST);
            }
        }catch (Exception ex){
            response.setCode(VarList.RSP_ERROR);
            response.setMessage("Error");
            response.setContent(null);
            return new ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/getAllEmployees")
    public ResponseEntity getAllEmployees(){
        try{
            List<Employee> employeeList = employeeService.getAllEmployees();
            response.setCode(VarList.RSP_SUCCESS);
            response.setMessage("Success");
            response.setContent(employeeList);
            return new ResponseEntity(response, HttpStatus.ACCEPTED);
        }catch (Exception ex){
            response.setCode(VarList.RSP_ERROR);
            response.setMessage("Error");
            response.setContent(null);
            return new ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/searchEmployeeById/{id}")
    public ResponseEntity searchEmployeeById(@PathVariable int id){
        try {
            Employee result = employeeService.searchEmployeeById(id);
            if (result != null){
                response.setCode(VarList.RSP_SUCCESS);
                response.setMessage("Success");
                response.setContent(result);
                return new ResponseEntity(response, HttpStatus.ACCEPTED);
            }else {
                response.setCode(VarList.RSP_NO_DATA_FOUND);
                response.setMessage("Employee not found");
                response.setContent(null);
                return new ResponseEntity(response, HttpStatus.NO_CONTENT);
            }
        }catch (Exception ex){
            response.setCode(VarList.RSP_ERROR);
            response.setMessage("Error");
            response.setContent(null);
            return new ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("/deleteEmployeeById/{id}")
    public ResponseEntity deleteEmployeeById(@PathVariable int id){
        try {
            String result = employeeService.deleteEmployeeById(id);
            if (result.equals("00")){
                response.setCode(VarList.RSP_SUCCESS);
                response.setMessage("Success");
                response.setContent(null);
                return new ResponseEntity(response, HttpStatus.ACCEPTED);
            }else {
                response.setCode(VarList.RSP_NO_DATA_FOUND);
                response.setMessage("Employee not found");
                response.setContent(null);
                return new ResponseEntity(response, HttpStatus.BAD_REQUEST);
            }
        }catch (Exception ex){
            response.setCode(VarList.RSP_ERROR);
            response.setMessage("Error");
            response.setContent(null);
            return new ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
