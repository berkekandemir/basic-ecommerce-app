package hw4;
/**
 * This is the interface for the inventory class.
 */
public interface IInventory<T> {
	public void addElementToInventory(T item, int quantity);
	public boolean removeElementFromInventory(T item, int quantity) throws ProductNotFoundException;
}
