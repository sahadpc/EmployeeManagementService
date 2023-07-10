package com.springemp.jwtcontroller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springemp.jwtentity.UserCred;
import com.springemp.jwtmodel.AuthRequest;
import com.springemp.jwtservice.AuthService;

@RestController
@RequestMapping("/auth")
public class AuthController {
	
	@Autowired
	private AuthService authService;
	
	@Autowired
	private AuthenticationManager authenticationManager; 
	
	@PostMapping("/register")
	public String saveUser(@RequestBody UserCred user) {
		
		return authService.saveUser(user);
	}
	
	@PostMapping("/generate")
	public String getToken(@RequestBody AuthRequest authRequest) {
		Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword()));
		if(authenticate.isAuthenticated()) {
			return authService.generateToken(authRequest.getUserName());
		}
		else {
			throw new RuntimeException("Access Denied");
		}
	}
	
	@PostMapping("/validate")
	public String validate(@RequestParam("token") String token) {
		authService.validateToken(token);
		return "token is valid";
	}


}
