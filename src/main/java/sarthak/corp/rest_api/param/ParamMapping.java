package sarthak.corp.rest_api.param;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sarthak")
public class ParamMapping {

	
	@GetMapping("/user")
	public ResponseEntity<User> showUser(@RequestParam Integer id){
		User user =new User();
		user.setUserId(id);
		user.setUserName("sarthak");
		user.setUserDesignation("SDE");
		user.setUserSalary(2400022.0);
		return new ResponseEntity<User>(user,HttpStatus.OK);
	}
	
	@PostMapping(value = "/validate", consumes = "application/xml", produces = "application/json")
	public ResponseEntity<User> validateUser(@RequestBody User user){
//		return  new ResponseEntity<User>(user,HttpStatus.OK);
		return ResponseEntity.status(HttpStatus.OK).body(user);
		
	}
	
	
	@GetMapping(value="/path/{id1}/{name1}")
	public ResponseEntity<User> showDetails(@PathVariable("id1") Integer id, @PathVariable(value = "name1") String name){
		return ResponseEntity.status(HttpStatus.OK).body(new User(id,name,"SDE-1",2312412.43));
	}
}
