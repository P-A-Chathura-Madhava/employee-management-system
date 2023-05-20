package lk.ctech.employeemanagementsystem.repo;

import lk.ctech.employeemanagementsystem.model.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepo extends MongoRepository<Employee, Integer> {
}
