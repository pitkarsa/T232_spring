package com.itvedant.basics.di;

import org.springframework.stereotype.Component;

@Component
public class Engine {

	public Engine() {
		System.out.println("Engine bean created");
	}
	public void startEngine() {
		System.out.println("Engine started");
	}
}


