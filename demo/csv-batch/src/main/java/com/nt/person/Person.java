package com.nt.person;

public record Person(String firstName,String lastName) {

	public void Systrace() {
		
	System.out.println("Person.Systrace() records");

	}
}
