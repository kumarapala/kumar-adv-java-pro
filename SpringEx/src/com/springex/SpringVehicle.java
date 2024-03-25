package com.springex;

import org.springframework.beans.factory.annotation.Autowired;

public class SpringVehicle {
	
	@Autowired
	private Speaker speaker;
	
	@Autowired
	private Tyres tyres;
	
	public void makeVehicle()
	{	speaker.makeSound();
		tyres.rotate();
	}
}