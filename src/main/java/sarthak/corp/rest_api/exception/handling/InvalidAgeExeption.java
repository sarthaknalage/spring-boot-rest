package sarthak.corp.rest_api.exception.handling;

public class InvalidAgeExeption extends RuntimeException {
	
	public InvalidAgeExeption() {
		super("Plz enter the Correct Age !!");
	}
	
	public InvalidAgeExeption(String exceptionAns) {
		super(exceptionAns);
	}

}
