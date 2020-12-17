package hw4;

import java.util.Map;
import java.util.Set;
/**
 * This is the body of the product inventory objects. It uses inventory class to hold items.
 * It takes product objects in it.
 */
public class ProductInventory<T extends Product> extends Inventory<T>{
	
	public ProductInventory() {
		super();
	}
	
	public Product find(String product) throws ProductNotFoundException {
		for (Map.Entry<T, Integer> entry : inventory.entrySet()) {
			if (entry.getKey().getName().equals(product)) {
				return entry.getKey();
			}
		}
		throw new ProductNotFoundException();
	}
	
	@SuppressWarnings("unchecked")
	public String toString() {
		Set<Product> keySet = (Set<Product>) getInventory().keySet();
		Object[] keyArray = keySet.toArray();
		for (int i = 0; i < keyArray.length; i++) {
			System.out.println((i + 1) + "- " + ((Product) keyArray[i]).getName() + " -- " + ((Product) keyArray[i]).getPrice() + "TL");
		}
		return "";
	}
}
