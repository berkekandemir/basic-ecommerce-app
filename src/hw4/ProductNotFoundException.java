package hw4;
/**
 * This is for the situation that the product is not found.
 *
 */
@SuppressWarnings("serial")
public class ProductNotFoundException extends Exception {

	public ProductNotFoundException() {
		super("Product is not found in the inventory!");
	}

	public ProductNotFoundException(String message) {
		super(message);
	}

}
