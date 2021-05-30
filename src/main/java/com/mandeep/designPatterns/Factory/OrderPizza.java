package com.mandeep.designPatterns.Factory;

import java.util.ArrayList;

public class OrderPizza {

	public static void main(String[] args) {
		// Create differnt stores
		PizzaStore nyStore = new NYPizzaStore();
		PizzaStore chicagoStore = new ChicagoPizzaStore();
		// Then use one one store to make Ethan’s order.
		Pizza pizza = nyStore.orderPizza("cheese");
		System.out.println("Ethan ordered a " + pizza.getName() + "\n");
		pizza = chicagoStore.orderPizza("veggie");
		System.out.println("Joel ordered a " + pizza.getName() + "\n");
	}

}

/*
 * CREATOR OR FACTORY
 */

abstract class PizzaStore {
	public Pizza orderPizza(String orderType) {
		Pizza pizza;
		// call the factory based on order type
		pizza = createPizza(orderType);
		pizza.prepare();
		pizza.bake();
		pizza.cut();
		pizza.box();
		return pizza;
	}

	abstract Pizza createPizza(String type);
}

/*
 * NY Factory
 */
class NYPizzaStore extends PizzaStore {
	Pizza createPizza(String item) {
		if (item.equals("cheese")) {
			return new NYStyleCheesePizza();
		} else if (item.equals("veggie")) {
			return new NYStyleVeggiePizza();
		} else if (item.equals("clam")) {
			return new NYStyleClamPizza();
		} else if (item.equals("pepperoni")) {
			return new NYStylePepperoniPizza();
		} else
			return null;
	}
}

/*
 * Chicago Factory
 */
class ChicagoPizzaStore extends PizzaStore {
	Pizza createPizza(String item) {
		if (item.equals("cheese")) {
			return new ChicagoStyleCheesePizza();
		} else if (item.equals("veggie")) {
			return new ChicagoStyleVeggiePizza();
		} else if (item.equals("clam")) {
			return new ChicagoStyleClamPizza();
		} else if (item.equals("pepperoni")) {
			return new ChicagoStylePepperoniPizza();
		} else
			return null;
	}
}

/*
 * PRODUCTS TO MAKE
 */
abstract class Pizza {
	String name;
	String dough;
	String sauce;
	ArrayList<String> toppings = new ArrayList<String>();

	void prepare() {
		System.out.println("Preparing " + name);
		System.out.println("Tossing dough...");
		System.out.println("Adding sauce...");
		System.out.println("Adding toppings: ");
		for (int i = 0; i < toppings.size(); i++) {
			System.out.println(" " + toppings.get(i));
		}
	}

	// The abstract class provide some basic defaults for baking, cutting and
	// boxing.
	void bake() {
		System.out.println("Bake for 25 minutes at 350");
	}

	// Preparation follows a number of steps in a particular sequence.
	void cut() {
		System.out.println("Cutting the pizza into diagonal slices");
	}

	void box() {
		System.out.println("Place pizza in official PizzaStore box");
	}

	public String getName() {
		return name;
	}
}

class NYStyleCheesePizza extends Pizza {
	public NYStyleCheesePizza() {
		name = "NY Style Sauce and Cheese Pizza";
		dough = "Thin Crust Dough";
		sauce = "Marinara Sauce";
		// The NY Pizza has its own
		// marinara style sauce and thin crust.
		toppings.add("Grated Reggiano Cheese");
	}
}

class NYStyleVeggiePizza extends Pizza {
	public NYStyleVeggiePizza() {
		name = "NY Style Sauce and Cheese Veggie Pizza";
		dough = "Thin Crust Dough";
		sauce = "Marinara Sauce";
		// The NY Pizza has its own
		// marinara style sauce and thin crust.
		toppings.add("Grated Reggiano Cheese");
		toppings.add("Onion");
		toppings.add("Green Peppers");
		toppings.add("Spinach");
	}
}

class NYStyleClamPizza extends Pizza {
	public NYStyleClamPizza() {
		name = "NY Style Sauce and Cheese clam Pizza";
		dough = "Thin Crust Dough";
		sauce = "Marinara Sauce";
		// The NY Pizza has its own
		// marinara style sauce and thin crust.
		toppings.add("Grated Reggiano Cheese");
		toppings.add("Clam");
	}
}

class NYStylePepperoniPizza extends Pizza {
	public NYStylePepperoniPizza() {
		name = "NY Style Sauce and Cheese pepperoni Pizza";
		dough = "Thin Crust Dough";
		sauce = "Marinara Sauce";
		// The NY Pizza has its own
		// marinara style sauce and thin crust.
		toppings.add("Grated Reggiano Cheese");
		toppings.add("pepperoni");
	}
}

class ChicagoStyleCheesePizza extends Pizza {
	public ChicagoStyleCheesePizza() {
		name = "Chicago Style Sauce and Cheese Pizza";
		dough = "Thin Crust Dough";
		sauce = "Marinara Sauce";
		// The NY Pizza has its own
		// marinara style sauce and thin crust.
		toppings.add("Grated Reggiano Cheese");
	}
}

class ChicagoStyleVeggiePizza extends Pizza {
	public ChicagoStyleVeggiePizza() {
		name = "Chicago Style Sauce and Cheese Veggie Pizza";
		dough = "Thin Crust Dough";
		sauce = "Marinara Sauce";
		// The NY Pizza has its own
		// marinara style sauce and thin crust.
		toppings.add("Grated Reggiano Cheese");
		toppings.add("Onion");
		toppings.add("Green Peppers");
		toppings.add("Spinach");
	}
}

class ChicagoStyleClamPizza extends Pizza {
	public ChicagoStyleClamPizza() {
		name = "Chicago Style Sauce and Cheese clam Pizza";
		dough = "Thin Crust Dough";
		sauce = "Marinara Sauce";
		// The NY Pizza has its own
		// marinara style sauce and thin crust.
		toppings.add("Grated Reggiano Cheese");
		toppings.add("Clam");
	}
}

class ChicagoStylePepperoniPizza extends Pizza {
	public ChicagoStylePepperoniPizza() {
		name = "Chicago Style Sauce and Cheese pepperoni Pizza";
		dough = "Thin Crust Dough";
		sauce = "Marinara Sauce";
		// The NY Pizza has its own
		// marinara style sauce and thin crust.
		toppings.add("Grated Reggiano Cheese");
		toppings.add("pepperoni");
	}
}