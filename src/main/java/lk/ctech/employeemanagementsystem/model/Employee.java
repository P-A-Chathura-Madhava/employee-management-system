package lk.ctech.employeemanagementsystem.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@Document(collection = "Employee")
public class Employee {
    @Id
    private int id;
    private String name;
    private String address;
    private String contact;
}
