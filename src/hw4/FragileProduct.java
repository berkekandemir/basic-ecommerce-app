package hw4;
/**
 * This is the body of the fragile products. It extends the product class and
 * changes the cargo price and factor according to the given values.
 */
public class FragileProduct extends Product {

	public FragileProduct(String category, String name, double price, double weight) {
		super(category, name, price, weight);
		setCargoFactor(getCargoFactor() * 4.5);
		setCargoPrice(getCargoFactor() * weight);
	}

}
