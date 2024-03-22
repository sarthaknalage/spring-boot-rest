package b2b.consumer;

import org.apache.catalina.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping(value = "/b2b")
public class BusinessController {
	private String uri="http://localhost:8080/sarthak";
	private RestTemplate restTemplate;
	public BusinessController() {
		restTemplate=new RestTemplate();
	
	}
	
	@GetMapping("/user")
	ResponseEntity<User> getUserDetails(@RequestParam Integer id)
	{	uri.concat("/user?id="+id);
		ResponseEntity<User> entity= restTemplate.getForEntity(uri,User.class);
		return ResponseEntity.status(entity.getStatusCodeValue()).body(entity.getBody());
	}
	
}
