package com.styam;

import java.util.ArrayList;

public class Test {
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) {
		ArrayList objs = new ArrayList();
		objs.add(10);
		objs.add("ratan");
		
	}
}

@FunctionalInterface
interface Greeting{
	void greet();
}


class Parent 
{	public void getNumberOfEmployees() {
		
	}
}
class Child extends Parent 
{
	@Override
	public void getNumberOfEmployees() {
		
	}
}