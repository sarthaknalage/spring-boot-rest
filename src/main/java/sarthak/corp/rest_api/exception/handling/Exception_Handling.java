package sarthak.corp.rest_api.exception.handling;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
// Here it need to communicating with dao layer
//  by autowiring concept and do the operations
/*
 * STEPS: NEED TO FOLLOW
 * 1. create the dao/persist layer by extending the CrudRepository.
 * 2. create interface Service layer and consisting the Autowired of dao layer is able to do the operations.
 * 3. Here in the controller layer it need to be do Autowired of serice layer and do the operations 
 */
@RestController
@RequestMapping("/exception")
public class Exception_Handling {
	List<Employee> list=new ArrayList<>();
	
	
	public Exception_Handling() {
		list=List.of(
				new Employee(10,"sarthak",1343232.23)
				);
	}
	@PostMapping("/save")
	public ResponseEntity<String> saveUser(@RequestBody Employee employee)
	{	
		if(employee==null) {
			throw new NullPointerException();
		}
		list.add(employee);
//		return new ResponseEntity<String>("Done",HttpStatus.OK);
		return ResponseEntity.status(HttpStatus.OK).body("done");
		
		
	}
	
	@GetMapping("/employee/{id}")
	public ResponseEntity<Employee> getEmployee(@PathVariable("id") Integer empId){
		Employee emp=null;
		if(empId<0) {
			throw new InvalidAgeExeption();
		}
		ListIterator<Employee> itr=list.listIterator();
		while(itr.hasNext()) {
			emp=itr.next();
			if(emp.getEmployeeId().equals(empId)) {
				return ResponseEntity.status(HttpStatus.OK).body(emp);
			}
		}
		return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(emp);
	}


}
