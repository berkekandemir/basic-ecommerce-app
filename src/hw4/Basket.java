package hw4;

import java.util.Set;
/**
 * Basket class holds the specifications of the basket objects.
 * It holds product objects and uses inventory class to hold objects.
 */
public class Basket<T extends Product> {
	private Inventory<Product> basket;
	
	public Basket() {
		basket = new ProductInventory<Product>();
	}

	public Inventory<Product> getBasket() {
		return basket;
	}

	public void setBasket(Inventory<Product> basket) {
		this.basket = basket;
	}
	
	public String toString() {
		Set<Product> keySet = basket.getInventory().keySet();
		Product[] keyArray = (Product[]) keySet.toArray();
		for (int i = 0; i < keyArray.length; i++) {
			System.out.println((i + 1) + "- " + keyArray[i].getName() + " -- " + keyArray[i].getPrice() + "TL");
		}
		return "";
	}
	
	public Product getKey(int index) {
		return basket.getKey(index);
	}
	
	public int getValue(int index) {
		return basket.getValue(index);
	}
}
