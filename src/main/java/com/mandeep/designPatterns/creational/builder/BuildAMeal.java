package com.mandeep.designPatterns.creational.builder;

public class BuildAMeal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MealBuilder builder = new MealBuilder();
		builder.setMealType(MealType.PIZZA);
		builder.setDrinks(Drinks.JUICE);
		Meal meal = builder.createMeal();
		System.out.println("Ordered Meal: " + meal.getMealType());
		System.out.println("Ordered Drinks: " + meal.getDrinks());
		// you only set what u need in meal rest stays null
		System.out.println("Ordered Dessert: " + meal.getDesserts());
	}

}

/**
 * Builder interface defines all possible ways to configure a product.
 */
interface IBuilder {
	void setMealType(MealType type);

	void setDrinks(Drinks drinks);

	void setDessert(Desserts desserts);

	void setToy(Toy toy);

	void setSides(SideDish sideDish);

}

enum MealType {
	VEGGIE_BURGER, PIZZA, NOODLES
}

enum Drinks {
	COKE, PEPSI, JUICE, OOZIE
}

enum Desserts {
	VANILLA_ICECREAM, MANGO_CAKE, CHOCLATE_CAKE
}

enum Toy {
	LION, DONKEY, ELEPHANT, CAR, BUS
}

enum SideDish {
	CHIPS, FIRES, FARMER_SALAD
}

class MealBuilder implements IBuilder {
	MealType mealType;
	Drinks drinks;
	Desserts desserts;
	Toy toy;
	SideDish sideDish;

	@Override
	public void setMealType(MealType type) {
		this.mealType = type;

	}

	@Override
	public void setDrinks(Drinks drinks) {
		this.drinks = drinks;

	}

	@Override
	public void setDessert(Desserts desserts) {
		this.desserts = desserts;

	}

	@Override
	public void setToy(Toy toy) {
		this.toy = toy;

	}

	@Override
	public void setSides(SideDish sideDish) {
		this.sideDish = sideDish;

	}

	public Meal createMeal() {
		return new Meal(this.mealType, this.drinks, this.desserts, this.toy,
				this.sideDish);

	}

}

class Meal {
	private final MealType mealType;
	private final Drinks drinks;

	public Toy getToy() {
		return toy;
	}

	public SideDish getSideDish() {
		return sideDish;
	}

	private final Desserts desserts;
	private final Toy toy;
	private final SideDish sideDish;

	public Meal(MealType mealType, Drinks drinks, Desserts desserts, Toy toy,
			SideDish sideDish) {
		super();
		this.mealType = mealType;
		this.drinks = drinks;
		this.desserts = desserts;
		this.toy = toy;
		this.sideDish = sideDish;
	}

	public MealType getMealType() {
		return mealType;
	}

	public Drinks getDrinks() {
		return drinks;
	}

	public Desserts getDesserts() {
		return desserts;
	}

}