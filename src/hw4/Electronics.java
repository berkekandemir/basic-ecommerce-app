package hw4;
/**
 * This is the body of the electronics class.
 * It is just the child of the product class but in future there might be 
 * new specifications of the electronics so there is an separated class for it.
 */
public class Electronics extends Product {

	public Electronics(String category, String name, double price, double weight) {
		super(category, name, price, weight);
	}
}
