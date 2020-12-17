package hw4;
/**
 * This is the body of the fast consumption products. It extends the product class and
 * changes the cargo price and factor according to the given values.
 */
public class FastConsumptionProduct extends Product {

	public FastConsumptionProduct(String category, String name, double price, double weight) {
		super(category, name, price, weight);
		setCargoFactor(getCargoFactor() * 3.5);
		setCargoPrice(getCargoFactor() * weight);
	}

}
