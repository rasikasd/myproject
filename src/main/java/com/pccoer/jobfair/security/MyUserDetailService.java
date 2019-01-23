package com.pccoer.jobfair.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.pccoer.jobfair.model.User;
import com.pccoer.jobfair.repository.UserRepository;
@Service
public class MyUserDetailService implements UserDetailsService {
	
	@Autowired
	UserRepository repo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = repo.findByUserName(username);
		if(user == null) {
			throw new UsernameNotFoundException("Not found 404");
		}
		return new UserPrincipal(user);
	}

}
