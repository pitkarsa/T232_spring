package com.itvedant.shopkart.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.itvedant.shopkart.models.User;
import com.itvedant.shopkart.models.UserDto;
import com.itvedant.shopkart.repositories.UserRepository;


@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private PasswordEncoder encoder;

	public User registerUser(UserDto dto) {
		// 1. check if the email is unique
		// 2. create the user object, setting the user
		// 3. encrypt the password
		// 4. save the user in db
		
		if(userRepository.existsByEmail(dto.getEmail())) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Please register using another email");
		}
		
		User user = new User();
		user.setUsername(dto.getUsername());
		user.setEmail(dto.getEmail());
		user.setMobile(dto.getMobile());
		if(dto.getRoles()==null) {
			user.setRoles(Arrays.asList("ROLE_USER"));
		}
		else {
			user.setRoles(dto.getRoles());
		}
		user.setPassword(encoder.encode(dto.getPassword()));
		
		User savedUser = userRepository.save(user);
		return savedUser;
	}
}
