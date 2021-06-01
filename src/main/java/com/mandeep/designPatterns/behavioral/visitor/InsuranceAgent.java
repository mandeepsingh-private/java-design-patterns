package com.mandeep.designPatterns.behavioral.visitor;

import java.util.ArrayList;
import java.util.List;
/*
 * Imagine a seasoned insurance agent who’s eager to get new customers. 
 * He can visit every building in a neighborhood, trying to sell insurance
to everyone he meets. Depending on the type of organization that occupies 
the building, he can offer specialized insurance policies:

If it’s a residential building, he sells medical insurance.
If it’s a bank, he sells theft insurance.
If it’s a coffee shop, he sells fire and flood insurance.

Instead of writing if then else logic we use the visitor pattern
 */

public class InsuranceAgent {
	public static void main(String[] args) {

		List<IBuyer> buyers = new ArrayList<IBuyer>();
		buyers.add(new Bank());
		buyers.add(new ResidentialHome());
		buyers.add(new CoffeeShop());
		InsuranceVisitor visitor = new SellInsurance();
		for (IBuyer b : buyers) {
			b.accept(visitor);
		}
	}
}

interface InsuranceVisitor {
	void visit(CoffeeShop A);

	void visit(Bank A);

	void visit(ResidentialHome A);
}

interface IBuyer {
	void accept(InsuranceVisitor v);
}

class CoffeeShop implements IBuyer {

	@Override
	public void accept(InsuranceVisitor v) {
		v.visit(this);

	}

}

class Bank implements IBuyer {

	@Override
	public void accept(InsuranceVisitor v) {
		v.visit(this);

	}

}

class ResidentialHome implements IBuyer {

	@Override
	public void accept(InsuranceVisitor v) {
		v.visit(this);

	}

}

class SellInsurance implements InsuranceVisitor {

	@Override
	public void visit(CoffeeShop A) {
		System.out.println("CoffeeShop: Selling fire and flood insurance");

	}

	@Override
	public void visit(Bank A) {
		System.out.println("Bank: Selling theft insurance");

	}

	@Override
	public void visit(ResidentialHome A) {
		System.out.println(
				"ResidentialHome: Selling car, home and medical insurance");

	}

}
