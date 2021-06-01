package com.mandeep.designPatterns.creational.singleton;

/*
 * Not a Thread safe operation
 */
public class MultiThreadedSingletonDemoBroken {
	public static void main(String[] args) {
		System.out.println(
				"If you see the same value, then singleton was reused (yay!)"
						+ "\n"
						+ "If you see different values, then 2 singletons were created (booo!!)"
						+ "\n\n" + "RESULT:" + "\n");
		Thread threadFoo = new Thread(new ThreadOne());
		Thread threadBar = new Thread(new ThreadTwo());
		threadFoo.start();
		threadBar.start();
	}

	static class ThreadOne implements Runnable {
		@Override
		public void run() {
			SQlServerDBConnection singleton = SQlServerDBConnection
					.getInstance("JDBC to SQLSERVER - Requesting 1st TIME");
			System.out.println(singleton.url);
		}
	}

	static class ThreadTwo implements Runnable {
		@Override
		public void run() {
			SQlServerDBConnection singleton = SQlServerDBConnection
					.getInstance("JDBC to SQLSERVER - Requesting 2nd TIME");
			System.out.println(singleton.url);
		}
	}
}

final class SQlServerDBConnection {
	private static SQlServerDBConnection instance;
	public String url;

	private SQlServerDBConnection(String url) {
		// The following code emulates slow initialization.
		try {
			Thread.sleep(1000);
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
		this.url = url;
	}

	public static SQlServerDBConnection getInstance(String url) {
		if (instance == null) {
			instance = new SQlServerDBConnection(url);
		}
		return instance;
	}
}