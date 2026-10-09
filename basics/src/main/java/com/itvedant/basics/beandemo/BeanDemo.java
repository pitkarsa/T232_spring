package com.itvedant.basics.beandemo;

import java.util.Scanner;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
// tells spring to check and execute all @Bean methods
public class BeanDemo {

	@Bean // spring will execute @Bean method, and stores the 
	// returned bean in spring container for memory management(sharing)
	public Scanner getScanner() {
		//System.out.println("scanner bean is created");
		Scanner sc = new Scanner(System.in); 
		return sc;
	}	
}
