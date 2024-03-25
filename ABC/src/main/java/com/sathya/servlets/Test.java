package com.sathya.servlets;

import java.util.ArrayList;

public class Test {
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) {
		ArrayList al = new ArrayList();
		al.add(10);
		al.add("ratan");
	}
}

@FunctionalInterface
interface Greeting
{	void greet();
}


class Parent{
	public void getNumberOfEmployees() {
		
	}
}
class Child extends Parent 
{
	@Override
	public void getNumberOfEmployees() {
	
	}
}