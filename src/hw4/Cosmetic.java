package hw4;
/**
 * This is the body of the cosmetic class.
 * It is just the child of the fast consumption product class but in future there might be 
 * new specifications of the cosmetics so there is an separated class for it.
 */
public class Cosmetic extends FastConsumptionProduct {

	public Cosmetic(String category, String name, double price, double weight) {
		super(category, name, price, weight);
	}

}
