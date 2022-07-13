package com.revature.models;

//What the heck is a DTO?
//Data Transfer Object
//A DTO is meant to model some data coming in from the front end
//An HTTP Handler will take in a JSON Object sent in by the user, containing the username and password
//This HTTP Request data gets sent to the controller, to get turned into a Java object using JSON
//The username data and password the user sends in will be put into this DTO as variables, whihc we'll check in the authService
//You NEVER store a DTO in the database. It's purely for DATA TRANSFER

public class LoginDTO {
	
	//the loginDTO models ONLY the username/password sent in by the user
	private String username;
	private String password;
	
	//We just need one all-args constructor - the user will never just send a username or password or neither
	public LoginDTO(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	

}
