package hw4;

import java.util.Set;
/**
 * This is the body of the shop objects. It holds the products using the product inventory class.
 */
public class Shop {
	private String category;
	private String name;
	private String taxNumber;
	private ProductInventory<Product> productInventory;
	
	public Shop(String category, String name, String taxNumber) {
		this.category = category;
		this.name = name;
		this.taxNumber = taxNumber;
		productInventory = new ProductInventory<Product>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTaxNumber() {
		return taxNumber;
	}

	public void setTaxNumber(String taxNumber) {
		this.taxNumber = taxNumber;
	}

	public ProductInventory<Product> getProductInventory() {
		return productInventory;
	}

	public void setProductInventory(ProductInventory<Product> productInventory) {
		this.productInventory = productInventory;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	public void addProduct(Product product, int quantity) {
		productInventory.addElementToInventory(product, quantity);
	}
	public void removeProduct(Product product, int quantity) throws ProductNotFoundException {
		productInventory.removeElementFromInventory(product, quantity);
	}
	
	public String toString() {
		Set<Product> keySet = productInventory.getInventory().keySet();
		Object[] keyArray = keySet.toArray();
		for (int i = 0; i < keyArray.length; i++) {
			System.out.println((i + 1) + "- " + ((Product) keyArray[i]).getName() + " -- " + ((Product) keyArray[i]).getPrice() + "TL");
		}
		return "";
	}
	
	public Product getKey(int index) {
		return productInventory.getKey(index);
	}
	public int getValue(int index) {
		return productInventory.getValue(index);
	}
}
