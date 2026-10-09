package com.itvedant.basics.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Car {
	/* 
	// Core java approach 
	
	Engine engine;
	
	public Car() {
		this.engine = new Engine();
		this.startCar();// wrong approach
	}
	
	
	*/
	
	/*
	// 1. constructor injection
	private Engine engine;// dependency
	
	@Autowired // optional
	public Car(Engine engine) {
		this.engine = engine;
		System.out.println("Car bean is configured with engine dependency");
		this.startCar();
	}
	public void startCar() {
		engine.startEngine();
		System.out.println("Car is started");
	}	
	
	*/
	
	/*
	// 2. setter injection
	private Engine engine;
	
	@Autowired
	public void setEngine(Engine engine) {
		System.out.println("Setter DI");
		this.engine = engine;
		this.startCar();
	}


	public void startCar() {
		engine.startEngine();
		System.out.println("Car is started");
	}	
	*/
	
	
	// Field injection
	@Autowired
	private Engine engine;
	
}







