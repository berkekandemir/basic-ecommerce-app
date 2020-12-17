package hw4;
/**
 * This is the body of the customer objects. It holds its specifications and its inventories in it.
 */
public class Customer extends RegularUser {
	private Inventory<Product> boughtProductsInventory;
	private Basket<Product> basket;
	private boolean freeShipping;
	
	public Customer(String username, String password, double activeBalance, ContactInfo contactInfo) {
		super(username, password, activeBalance, contactInfo);
		boughtProductsInventory = new ProductInventory<Product>();
		basket = new Basket<Product>();
		freeShipping = false;
	}
	public Inventory<Product> getBoughtProductsInventory() {
		return boughtProductsInventory;
	}
	public void setBoughtProductsInventory(Inventory<Product> boughtProductsInventory) {
		this.boughtProductsInventory = boughtProductsInventory;
	}
	public Basket<Product> getBasket() {
		return basket;
	}
	public void setBasket(Basket<Product> basket) {
		this.basket = basket;
	}
	public boolean isFreeShipping() {
		return freeShipping;
	}
	public void setFreeShipping(boolean freeShipping) {
		this.freeShipping = freeShipping;
	}
}
