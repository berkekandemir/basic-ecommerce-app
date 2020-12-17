package hw4;
/**
 * This is the body of the product objects. It holds its specifications as attributes.
 */
public class Product {
	private String category;
	private String name;
	private double price;
	private double weight;
	private double cargoFactor;
	private double cargoPrice;
	
	public Product(String category, String name, double price, double weight) {
		this.category = category;
		this.name = name;
		this.price = price;
		this.weight = weight;
		cargoFactor = 2;
		cargoPrice = cargoFactor * weight;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public double getCargoFactor() {
		return cargoFactor;
	}

	public void setCargoFactor(double cargoFactor) {
		this.cargoFactor = cargoFactor;
	}

	public double getCargoPrice() {
		return cargoPrice;
	}

	public void setCargoPrice(double cargoPrice) {
		this.cargoPrice = cargoPrice;
	}
	public String toString() {
		return name + " -- " + price + "TL";
	}
}
