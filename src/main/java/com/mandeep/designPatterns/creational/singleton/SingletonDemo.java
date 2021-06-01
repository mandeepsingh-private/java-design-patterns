package com.mandeep.designPatterns.creational.singleton;

/*
 * Single threaded Demo Naive singleton
 * Mainly used when we want to keep one connection to Database instead of multiple
 * 1. Convert the constructor of class which initiated BD connection private
 * 2. Create get instance method
 */
public class SingletonDemo {
	public static void main(String[] args) {
		System.out.println(
				"If you see the same value, then singleton was reused (yay!)"
						+ "\n"
						+ "If you see different values, then 2 singletons were created (booo!!)"
						+ "\n\n" + "RESULT:" + "\n");
		OracleDBConnection singleton = OracleDBConnection
				.getInstance("JDBC to ORACLE - Requesting 1st TIME");
		OracleDBConnection anotherSingleton = OracleDBConnection
				.getInstance("JDBC to ORACLE - Requesting 2nd TIME");
		System.out.println(singleton.url);
		System.out.println(anotherSingleton.url);
	}

}

final class OracleDBConnection {
	private static OracleDBConnection instance;
	public String url;

	private OracleDBConnection(String url) {
		// The following code emulates slow initialization.
		try {
			Thread.sleep(1000);
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
		this.url = url;
	}

	public static OracleDBConnection getInstance(String url) {
		if (instance == null) {
			instance = new OracleDBConnection(url);
		}
		return instance;
	}
}