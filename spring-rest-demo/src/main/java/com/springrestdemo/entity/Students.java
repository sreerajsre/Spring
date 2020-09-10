package com.springrestdemo.entity;

public class Students {
	
	private String firstName;
	private String lastName;
	

	public Students(String firstName, String lastName) {
		System.out.println("Parameteriesed Constructors");
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	

}
