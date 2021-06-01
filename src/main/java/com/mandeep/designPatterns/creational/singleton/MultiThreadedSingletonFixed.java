package com.mandeep.designPatterns.creational.singleton;

public class MultiThreadedSingletonFixed {
	public static void main(String[] args) {
        System.out.println("If you see the same value, then singleton was reused (yay!)" + "\n" +
                "If you see different values, then 2 singletons were created (booo!!)" + "\n\n" +
                "RESULT:" + "\n");
        Thread threadFoo = new Thread(new ThreadOne());
        Thread threadBar = new Thread(new ThreadTwo());
        threadFoo.start();
        threadBar.start();
    }

    static class ThreadOne implements Runnable {
        @Override
        public void run() {
        	MongoDbConnection singleton = MongoDbConnection.getInstance("FOO");
            System.out.println(singleton.value);
        }
    }

    static class ThreadTwo implements Runnable {
        @Override
        public void run() {
        	MongoDbConnection singleton = MongoDbConnection.getInstance("BAR");
            System.out.println(singleton.value);
        }
    }
}

final class MongoDbConnection {
	// The field must be declared volatile so that double check lock would work
	// correctly.
	private static volatile MongoDbConnection instance;

	public String value;

	private MongoDbConnection(String value) {
		this.value = value;
	}

	public static MongoDbConnection getInstance(String value) {
		// The approach taken here is called double-checked locking (DCL). It
		// exists to prevent race condition between multiple threads that may
		// attempt to get singleton instance at the same time, creating separate
		// instances as a result.
		//
		// It may seem that having the `result` variable here is completely
		// pointless. There is, however, a very important caveat when
		// implementing double-checked locking in Java, which is solved by
		// introducing this local variable.
		//
		// You can read more info DCL issues in Java here:
		// https://refactoring.guru/java-dcl-issue
		MongoDbConnection result = instance;
		if (result != null) {
			return result;
		}
		synchronized (MongoDbConnection.class) {
			if (instance == null) {
				instance = new MongoDbConnection(value);
			}
			return instance;
		}
	}
}