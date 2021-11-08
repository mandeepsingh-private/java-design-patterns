package com.mandeep.designPatterns.creational.builder;

public class User {
	private final String firstName;
	private final String lastName;
	private int age;
	private String phone;
	private String address;

	public User(UserBuilder builder) {
		super();
		this.firstName = builder.firstName;
		this.lastName = builder.lastName;
		this.age = builder.age;
		this.phone = builder.phone;
		this.address = builder.address;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public int getAge() {
		return age;
	}

	public String getPhone() {
		return phone;
	}

	public String getAddress() {
		return address;
	}

}
