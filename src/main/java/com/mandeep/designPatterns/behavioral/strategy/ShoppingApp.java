package com.mandeep.designPatterns.behavioral.strategy;

/**
 * 
 * The Strategy Pattern defines a family of algorithms, encapsulates each one,
 * and makes them interchangeable. Strategy lets the algorithm vary
 * independently from clients that use it.
 *
 */

public class ShoppingApp {

	public static void main(String[] args) {
		Payment payment = new Payment(new CreditCard());
		payment.pay(1000.0);
		payment.setPaymentType(new Paypal());
		payment.pay(2000.0);
	}

}

class Payment {
	private PayStrategy paymentType;

	public Payment(PayStrategy paymentType) {
		this.paymentType = paymentType;
	}

	public PayStrategy getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(PayStrategy paymentType) {
		this.paymentType = paymentType;
	}

	void pay(Double amount) {
		paymentType.collectPayment(amount);
	}

}

interface PayStrategy {
	void display();

	void collectPayment(Double Amount);
}

/*
 * Algorithm 1 for payment
 */
class Paypal implements PayStrategy {
	private Double amount;

	public void display() {
		// include methods to get paypal details
		System.out.println(
				"Collecting payments via paypal of amount: " + this.amount);

	}

	public void collectPayment(Double amount) {
		this.amount = amount;
		display();

	}

}
/*
 * Algorithm 2 for payment
 */

class CreditCard implements PayStrategy {
	private Double amount;

	public void display() {
		// include methods to get credit card details
		System.out.println(
				"Collecting payments via creditCard of amount: " + this.amount);

	}

	public void collectPayment(Double amount) {
		this.amount = amount;
		display();

	}

}