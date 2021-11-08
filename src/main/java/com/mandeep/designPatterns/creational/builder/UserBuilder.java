package com.mandeep.designPatterns.creational.builder;

public class UserBuilder {

	final String firstName; // mandatory fields
	final String lastName;// mandatory fields
	int age;
	String phone;
	String address;

	public UserBuilder(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public UserBuilder age(int age) {
		this.age = age;
		return this;
	}

	public UserBuilder phone(String phone) {
		this.phone = phone;
		return this;
	}

	public UserBuilder address(String address) {
		this.address = address;
		return this;
	}

	public User build() {
		User user = new User(this);
		return user;

	}
}
