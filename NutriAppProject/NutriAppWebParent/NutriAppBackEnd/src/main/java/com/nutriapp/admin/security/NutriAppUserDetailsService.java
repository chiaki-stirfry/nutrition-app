package com.nutriapp.admin.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.nutriapp.admin.user.UserRepository;
import com.nutriapp.common.entity.User;

public class NutriAppUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User user = userRepo.getUserByEmail(email);
		if (user != null) {
			return new NutriAppUserDetails(user);
		}
		
		throw new UsernameNotFoundException("Could not find the user with email: " + email);
	}

}
