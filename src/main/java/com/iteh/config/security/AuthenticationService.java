package com.iteh.config.security;

import com.iteh.dao.UserDao;
import com.iteh.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class AuthenticationService implements UserDetailsService {
	
	@Autowired
	private UserDao userDao;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userDao.getByUsername(username);
		GrantedAuthority authority = new SimpleGrantedAuthority(user.getRole().getName());
		UserDetails userDetails = new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(), Arrays.asList(authority));
		return userDetails;
	}
	
}