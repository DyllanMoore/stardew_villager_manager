package com.revature.controllers;


import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.revature.models.LoginDTO;
import com.revature.services.AuthService;

import io.javalin.http.Handler;

public class AuthController {

	//we need an AuthService, remember the service layer sits between the Controllers and DAOs
	AuthService as = new AuthService();
	
	//empty HTTP Session object that will be filled upon successfully login
	static HttpSession ses;
	
	//we need a loginHandler to take in login data, make a login DTO and send it to the service
	//if login is successful the service sends back a String which we use in our return (ctx.result())
	//we test whether the login service method returns null or a string
	//also a session will be created when the user logins successfully
	
	//login will be a post request, check insert employeeHandler if any of this syntax confuses you
	public Handler loginHandler = (ctx) -> {
		
		String body = ctx.body();
		Gson gson = new Gson();
		
		LoginDTO lDTO = gson.fromJson(body, LoginDTO.class);
		
		String loginUsername = as.login(lDTO.getUsername(), lDTO.getPassword()); //this will either retrun aString or Null
		
		if( loginUsername != null) { //if login is successful...
			
			ses = ctx.req.getSession(); //this is how we create new sessions
			
			ctx.result("welcome " + loginUsername);
			ctx.status(202);
		} else {
			ctx.status(401);//401 stands for "unauthorized
		}
	};
	
	
	
	
}
