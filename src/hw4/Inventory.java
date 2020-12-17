package hw4;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
/**
 * This is the abstract body of the inventory objects. It holds the items in an hash map.
 * It has add and remove for items and some getter methods to reach specific elements.
 */
public abstract class Inventory<T> implements IInventory<T> {
	protected Map<T, Integer> inventory;
	
	public Inventory() {
		inventory = new HashMap<T, Integer>();
	}

	public HashMap<T, Integer> getInventory() {
		return (HashMap<T, Integer>) inventory;
	}

	public void setInventory(HashMap<T, Integer> inventory) {
		this.inventory = inventory;
	}
	
	public void addElementToInventory(T product, int quantity) {
		if (!inventory.containsKey(product)) {
			inventory.put(product, quantity);
		} else {
			inventory.replace(product, inventory.get(product) + quantity);
		}
	}
	
	public boolean removeElementFromInventory(T product, int quantity) throws ProductNotFoundException {
		boolean result = false;
		if (!inventory.containsKey(product)) {
			throw new ProductNotFoundException();
		} else {
			if (inventory.get(product) > quantity) {
				inventory.replace(product, inventory.get(product) - quantity);
				result = true;
				return result;
			} else if (inventory.get(product) == quantity) {
				inventory.remove(product);
				result = true;
				return result;
			} else {
				System.out.println("Not enough quantity to remove!");
				return result;
			}
		}
	}
	
	public int size() {
		return inventory.size();
	}
	
	public Set<T> keySet() {
		return inventory.keySet();
	}
	
	public Collection<Integer> values() {
		return inventory.values();
	}
	
	public int getValue(int index) {
		Collection<Integer> values = getInventory().values();
		Object[] valuesArray = values.toArray();
		for (int i = 0; i < index; i++) {
			if (i == (index - 1)) {
				return (int) valuesArray[i];
			}
		} return -1;
	}
	
	@SuppressWarnings("unchecked")
	public Product getKey(int index) {
		Set<Product> keySet = (Set<Product>) getInventory().keySet();
		Object[] keyArray = keySet.toArray();
		for (int i = 0; i < index; i++) {
			if (i == (index - 1)) {
				return (Product) keyArray[i];
			}
		} return null;
	}
}
