package com.itvedant.shopkart.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import com.itvedant.shopkart.models.User;
import com.itvedant.shopkart.models.UserProjection;

@RepositoryRestResource(excerptProjection = UserProjection.class)
public interface UserRepository extends JpaRepository<User, Integer>{

	@RestResource(exported = false)
	public User save(User user);// to disable POST request on /users from outside
	
	public boolean existsByEmail(String email);
	
	public Optional<User> findByEmail(String email);
}
