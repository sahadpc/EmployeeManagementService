package com.springemp.jwtservice;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.springemp.jwtentity.UserCred;
import com.springemp.jwtrepository.UserCredRepository;

@Service
public class AuthService {

	@Autowired
	private UserCredRepository credRepository; 
	
	@Autowired
	private PasswordEncoder encoder; 
	
	@Autowired
	private JwtService jwtService;
	
	
	
	public String saveUser(UserCred user) {
		user.setPassword(encoder.encode(user.getPassword()));
		credRepository.save(user);
		return "User Added Succesfully";
	}
	
	public String generateToken(String userName) {
		
			 return jwtService.generateToken(userName);
		
			
		
	}
	
	public void validateToken(String token) {
		jwtService.validateToken(token);
		
	}
}
