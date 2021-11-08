package com.mandeep.designPatterns.creational.builder;

public class UserDemo {
	public static void main(String[] args) {

		UserBuilder userBuilder = new UserBuilder("John", "Rambo");
		User userOne = userBuilder.age(50).phone("999-999-999")
				.address("hollywood").build();
		System.out.println(userOne.getFirstName());
	}
}
