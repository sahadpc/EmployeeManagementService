package com.springemp.jwtconfig;


import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;


import com.springemp.jwtentity.UserCred;
import com.springemp.jwtrepository.UserCredRepository;

@Component
public class CustomUserDetailService implements UserDetailsService {

	@Autowired
	private UserCredRepository credRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<UserCred> credential = credRepository.findByName(username);
		return credential.map(CustomUserDetails::new).orElseThrow(()->new UsernameNotFoundException("The Username not found"));
		
	}
}
