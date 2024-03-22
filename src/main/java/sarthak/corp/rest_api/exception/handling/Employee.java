package sarthak.corp.rest_api.exception.handling;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "employee_rest")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
	
	@Id
	private Integer employeeId;
	
	@Column(name="employee_name")
	private String employeeName;

	private Double employeeSalary;
}
