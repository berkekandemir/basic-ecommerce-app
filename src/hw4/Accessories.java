package hw4;
/**
 * This is the body of the accessories class.
 * It is just the child of the fragile product class but in future there might be 
 * new specifications of the accessories so there is an separated class for it.
 */
public class Accessories extends FragileProduct {

	public Accessories(String category, String name, double price, double weight) {
		super(category, name, price, weight);
	}
	
}
