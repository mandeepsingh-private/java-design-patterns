package com.mandeep.designPatterns.observer;

/*
 * The Observer Pattern defines a one-to-many
dependency between objects so that when one
object changes state, all of its dependents are
notified and updated automatically.
 */
import java.util.ArrayList;
import java.util.Date;

public class NewspaperDelivery {

	public static void main(String[] args) {
		// create newspaper to publish
		Wallstreet wallstreet = new Wallstreet();
		// add house that subscribe to newspaper
		HouseOne house1 = new HouseOne(wallstreet);
		HouseTwo house2 = new HouseTwo(wallstreet);
		wallstreet.setNews(new Date(), "Google buys Redhat");

	}

}

// SUBJECT OR PUBLISHER
interface INewsPublisher {
	public void regsiterSubscriber(INewsSubscriber s);

	public void removeSubscriber(INewsSubscriber s);

	public void notifySubscribers();
}

// OBSERVERS or SUBSCRIBERS
interface INewsSubscriber {
	public void update(Date date, String news);
}

interface IReadNews {
	public void readNews();
}

class Wallstreet implements INewsPublisher {
	private ArrayList<INewsSubscriber> subscribers;
	private Date date;
	private String news;

	public Wallstreet() {

		subscribers = new ArrayList<>();

	}

	@Override
	public void regsiterSubscriber(INewsSubscriber s) {
		subscribers.add(s);
	}

	@Override
	public void removeSubscriber(INewsSubscriber s) {
		int indexToRemove = subscribers.indexOf(s);
		if (indexToRemove > 0) {
			subscribers.remove(indexToRemove);
		}
	}

	@Override
	public void notifySubscribers() {
		for (int i = 0; i < subscribers.size(); i++) {
			subscribers.get(i).update(date, news);
		}

	}

	public void deliverNews() {
		notifySubscribers();
	}

	public void setNews(Date date, String news) {
		this.date = date;
		this.news = news;
		deliverNews();
	}

}

//news paper delivered to house no 1
class HouseOne implements INewsSubscriber, IReadNews {
	private Date date;
	private String news;
	private INewsPublisher newspaper;

	HouseOne(INewsPublisher p) {
		this.newspaper = p;
		p.regsiterSubscriber(this);

	}

	@Override
	public void readNews() {
		System.out.println("House 1 - Date : " + this.date + " news: " + news);

	}

	@Override
	public void update(Date date, String news) {
		this.date = date;
		this.news = news;
		readNews();
	}

}

//news paper delivered to house no 2
class HouseTwo implements INewsSubscriber, IReadNews {
	private Date date;
	private String news;
	private INewsPublisher newspaper;

	HouseTwo(INewsPublisher p) {
		this.newspaper = p;
		p.regsiterSubscriber(this);

	}

	@Override
	public void readNews() {
		System.out.println("House 2 - Date : " + this.date + " news: " + news);

	}

	@Override
	public void update(Date date, String news) {
		this.date = date;
		this.news = news;
		readNews();
	}

}