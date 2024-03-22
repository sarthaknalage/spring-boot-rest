package sarthak.corp.rest_api.requestMapping;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Component
//@RestController
public class RestControllerVintage {
	
	@GetMapping("/show")
	public ResponseEntity<String> showMsg() {
		ResponseEntity<String> entity=new ResponseEntity<>("Hello",HttpStatus.OK); 
		return entity;
	}
	
	@RequestMapping(value = "/show1",method = RequestMethod.GET)
	@ResponseBody public String showMsg1() {
		return "Jay Shree RAM ,from sarthak Nalage";
	}

}
