package com.metacube.training;

/**
 * This class contains properties of Person
 * 
 * @author Mohit Sharma
 *
 */
public class Person {
	private String type;

	public void setType(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}

	public void checkType() {
		System.out.println(type);
	}
}