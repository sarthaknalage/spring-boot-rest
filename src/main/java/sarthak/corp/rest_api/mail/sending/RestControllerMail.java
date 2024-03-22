package sarthak.corp.rest_api.mail.sending;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/saveStudentMail")
public class RestControllerMail {
	
	@Autowired
	ServiceImpl serviceImpl;
	
	@PostMapping(value = "/save", consumes = "application/json", produces="application/json")
	ResponseEntity<Student> saveStudentObject(@RequestBody Student std){
		if(std==null) {
			return ResponseEntity.status(HttpStatus.FAILED_DEPENDENCY).body(null);
		}
		serviceImpl.save(std);
		return ResponseEntity.status(HttpStatus.OK).body(std);
	}
	
}
