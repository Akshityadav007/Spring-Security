package com.example.secureapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service // 5.d)
public class MyUserDetailsService implements UserDetailsService {
	
	@Autowired											// 5.a)
	private UserRepository repo;						// 5.a)
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		// 5.a)
		User user = repo.findByUsername(username);								
		if(user==null) {
			throw new UsernameNotFoundException("User 404");
		}
		
		return new UserPrincipal(user);					// 5.c)
	}

}
