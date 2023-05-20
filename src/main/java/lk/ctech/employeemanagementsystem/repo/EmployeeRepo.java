package lk.ctech.employeemanagementsystem.repo;

import lk.ctech.employeemanagementsystem.model.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EmployeeRepo extends MongoRepository<Employee, Integer> {
}
