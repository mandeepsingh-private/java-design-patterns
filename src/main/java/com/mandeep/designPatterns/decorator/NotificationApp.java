package com.mandeep.designPatterns.decorator;

public class NotificationApp {
	public static void main(String[] args) {
		Notifier schoolNoteToSend = new School();
		System.out.println("WE will send this note - "
				+ schoolNoteToSend.getNotification());
		// send via email
		schoolNoteToSend = new Email(schoolNoteToSend);
		schoolNoteToSend = new Sms(schoolNoteToSend);
		System.out.println(schoolNoteToSend.getNotification());

		Notifier policeNoteToSend = new Boro();
		System.out.println("WE will send this note - "
				+ policeNoteToSend.getNotification());
		// send via email
		policeNoteToSend = new Email(policeNoteToSend);
		policeNoteToSend = new Sms(policeNoteToSend);
		System.out.println(policeNoteToSend.getNotification());
	}
}

abstract class Notifier {
	String notification = "Empty";

	public String getNotification() {
		return notification;
	}

}

/*
 * Different senders of notification
 */
class School extends Notifier {
	public School() {
		notification = "School Closed Snow day";
	}
}

class Boro extends Notifier {
	public Boro() {
		notification = "Water main break";
	}
}

class Resturant extends Notifier {
	public Resturant() {

		notification = "Free Pizza delivery";
	}
}

/*
 * Different notification types
 */
abstract class NotificationDecorator extends Notifier {
	public abstract String getNotification();
}

class Email extends NotificationDecorator {
	Notifier notifier;

	Email(Notifier notifier) {
		this.notifier = notifier;
	}

	@Override
	public String getNotification() {

		return "** Sending EMAIL Notifcation ** \n"
				+ this.notifier.getNotification();
	}

}

class Sms extends NotificationDecorator {
	Notifier notifier;

	Sms(Notifier notifier) {
		this.notifier = notifier;
	}

	@Override
	public String getNotification() {

		return "** Sending SMS Notifcation **\n"
				+ this.notifier.getNotification();
	}

}

class FacebookNotification extends NotificationDecorator {
	Notifier notifier;

	FacebookNotification(Notifier notifier) {
		this.notifier = notifier;
	}

	@Override
	public String getNotification() {

		return "** Sending Facebook Notifcation **\n"
				+ this.notifier.getNotification();
	}

}