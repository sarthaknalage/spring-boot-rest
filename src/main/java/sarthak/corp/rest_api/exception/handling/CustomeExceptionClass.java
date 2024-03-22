package sarthak.corp.rest_api.exception.handling;

import lombok.Data;

@Data
public class CustomeExceptionClass {
	
	private String excId;
	
	private String msg;
	
	private String location;

}
