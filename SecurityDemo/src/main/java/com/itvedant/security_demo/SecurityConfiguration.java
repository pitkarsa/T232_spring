package com.itvedant.security_demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {

	// 1. step: without the SecurityConfiguration class, all endpoints were private

	// 2. using SecurityConfiguration , making all endpoints public
	//	@Bean
	//	public SecurityFilterChain configure(HttpSecurity http) throws Exception {
	//		
	//		http.csrf(csrf -> csrf.disable());	
	//		
	//		// all the endpoints are open/ public
	//		
	//		return http.build();
	//	}
	// 3. some endpoints public, some endpoints private
	//	@Bean
	//	public SecurityFilterChain configure(HttpSecurity http) throws Exception {
	//		
	//		http.csrf(csrf -> csrf.disable())
	//		.authorizeHttpRequests(auth -> 
	//		   auth
	//		   .requestMatchers(HttpMethod.POST,"/products").authenticated()
	//		   .requestMatchers(HttpMethod.DELETE,"/products/**").authenticated()
	//		   // /products POST, /products/__ DELETE requests are private
	//		   // rest all endpoints are open
	//				.anyRequest().permitAll()
	//				)
	//		.httpBasic(Customizer.withDefaults());
	//		
	//		return http.build();
	//	}
	//	


	// we set the user name and password in properties


	// 4. role based users - in memory users -
	// properties  to be commented
	//	spring.security.user.name=sam
	//	spring.security.user.password=sam@123

	@Bean
	public PasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public UserDetailsManager userDetails() {
		UserDetails user1 = User
				.withUsername("admin")
				.password(encoder().encode("admin@123"))
				.roles("ADMIN")
				.build();

		UserDetails user2 = User
				.withUsername("amit")
				.password(encoder().encode("amit@123"))
				.roles("USER")
				.build();

		UserDetails user3 = User
				.withUsername("ketan")
				.password(encoder().encode("ketan@123"))
				.roles("ADMIN","USER")
				.build();

		return new InMemoryUserDetailsManager(user1, user2, user3);
	}

	@Bean
	public SecurityFilterChain configure(HttpSecurity http) throws Exception {

		http.csrf(csrf -> csrf.disable())
		.authorizeHttpRequests(auth -> 
		auth
		.requestMatchers(HttpMethod.POST,"/products").hasRole("ADMIN")
		.requestMatchers(HttpMethod.DELETE,"/products/**").hasRole("ADMIN")
		.requestMatchers(HttpMethod.PUT,"/products/**").hasRole("ADMIN")
		// /products POST, /products/__ DELETE,PUT requests are for ADMIN 
		// rest all endpoints are open
		.anyRequest().permitAll()
				)
		.httpBasic(Customizer.withDefaults());

		return http.build();
	}

}
