package sarthak.corp.rest_api.exception.handling;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CentralExceptionHandling {
	
	@ExceptionHandler(value = NullPointerException.class)
	public ResponseEntity<CustomeExceptionClass> getNullPointerException(NullPointerException exception){
		CustomeExceptionClass exc=new CustomeExceptionClass();
		exc.setExcId("123-a1");
		exc.setLocation(exception.getLocalizedMessage());
		exc.setMsg(exception.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(exc);
}
	
	@ExceptionHandler(value = ClassCastException.class)
	public ResponseEntity<CustomeExceptionClass> handleCastException(Exception exception){
		CustomeExceptionClass custome=new CustomeExceptionClass();
		custome.setExcId(HttpStatus.EXPECTATION_FAILED.toString());
		custome.setLocation(exception.getLocalizedMessage());
		custome.setMsg(exception.getMessage());
		return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(custome);
	}
	@ExceptionHandler(value = InvalidAgeExeption.class)
	public ResponseEntity<CustomeExceptionClass> handleAgeException(InvalidAgeExeption exception){
		CustomeExceptionClass custome=new CustomeExceptionClass();
		custome.setExcId("saro-1");
		custome.setLocation(exception.getLocalizedMessage());
		custome.setMsg(exception.getMessage());
		
		return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(custome);
	}
}

