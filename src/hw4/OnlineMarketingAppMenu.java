package hw4;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
/**
 * This is the hearth of the app. It contains all the menu operations in it.
 * It calls necessary classes' methods and performs the menu operations
 * according to the user choices.
 */
public class OnlineMarketingAppMenu {
	private CSVReader reader;
	private UserDatabase userDatabase;
	private Scanner keyboard;
	public OnlineMarketingAppMenu() {
		reader = new CSVReader();
		userDatabase = reader.read();
		keyboard  = new Scanner(System.in);
	}
	/**
	 * This is the main method of the class. Only this method is public and
	 * reachable from the outside. In main class, we call this method and run the app.
	 */
	public void menu() throws ProductNotFoundException {
		AdminUser admin = userDatabase.getAdminDatabase().get(0);
		boolean exit = false;
		boolean signOut = false;
		while (!signOut) {
			System.out.println("Which operation do you want to perform?");
			System.out.println("1- SIGN UP");
			System.out.println("2- SIGN IN");
			System.out.println("3- SIGN OUT");
			System.out.print("User input: ");
			int choice = keyboard.nextInt();
			System.out.println("");
			if (choice == 1) {
				signUp();
			} else if (choice == 2) {
				RegularUser regularUser = signIn();
				if (regularUser instanceof Customer) {
					while (!exit) { // If a customer logins the system.
						System.out.println("Which operation do you want to perform?");
						System.out.println("1- DEPOSIT MONEY");
						System.out.println("2- ADD PRODUCT TO BASKET");
						System.out.println("3- REMOVE PRODUCT FROM THE BASKET");
						System.out.println("4- BUY PRODUCT");
						System.out.println("5- RETURN PRODUCT");
						System.out.println("6- ADD NEW ADDRESS");
						System.out.println("7- SIGN OUT");
						System.out.print("User input: ");
						int choice1 = keyboard.nextInt();
						System.out.println("");
						if (choice1 == 1) {
							depositMoney((Customer) regularUser);
						} else if (choice1 == 2) {
							addToBasket((Customer) regularUser);
						} else if (choice1 == 3) {
							removeFromBasket((Customer) regularUser);
						} else if (choice1 == 4) {
							buyProduct((Customer) regularUser, admin);
						} else if (choice1 == 5) {
							returnProduct((Customer) regularUser);
						} else if (choice1 == 6) {
							addNewAddress((Customer) regularUser);
						} else if (choice1 == 7) {
							exit = true;
							signOut = true;
							signOut();
						} else {
							System.out.println("Wrong input!");
						}
					}
				} else if (regularUser instanceof Supplier){
					while (!exit) { // If a supplier logins the system.
						System.out.println("Which operation do you want to perform?");
						System.out.println("1- DEPOSIT MONEY");
						System.out.println("2- ADD NEW ADDRESS");
						System.out.println("3- SIGN OUT");
						System.out.print("User input: ");
						int choice1 = keyboard.nextInt();
						System.out.println("");
						if (choice1 == 1) {
							depositMoney(regularUser);
						} else if (choice1 == 2) {
							addNewAddress(regularUser);
						} else if (choice1 == 3) {
							exit = true;
							signOut = true;
							signOut();
						} else {
							System.out.println("Wrong input!");
						}
					}
				}
			} else if (choice == 3) {
				signOut = true;
				signOut();
			} else {
				System.out.println("Wrong input!");
			}
		}
	}
	/**
	 * This method takes new address inputs and creates new address objects.
	 * At last, it updates the CSV file.
	 */
	private void addNewAddress(RegularUser regularUser) {
		boolean more = true;
		List<Address> addressList = new ArrayList<Address>();
		keyboard.nextLine();
		while (more) {
			System.out.print("Address Title: ");
			String addressTitle = keyboard.nextLine();
			System.out.println("");
			System.out.print("Country: ");
			String country = keyboard.nextLine();
			System.out.println("");
			System.out.print("City: ");
			String city = keyboard.nextLine();
			System.out.println("");
			System.out.print("District: ");
			String district = keyboard.nextLine();
			System.out.println("");
			System.out.print("Street: ");
			String street = keyboard.nextLine();
			System.out.println("");
			System.out.print("Door number: ");
			String doorNumber = keyboard.nextLine();
			System.out.println("");
			Address address = new Address(addressTitle, country, city, district, street, doorNumber);
			addressList.add(address);
			System.out.print("Do you want to add new address?(1- Yes/2- No): ");
			int entry = keyboard.nextInt();
			if (entry == 1) {
				more = true;
			} else if (entry == 2) {
				more = false;
			}
		}
		for (Address i : addressList) {
			regularUser.getContactInfo().getAddress().add(i);
		}
		reader.CSVEditor(regularUser);
	}
	/**
	 * This method creates new user info and object.
	 * At last, it appends the new user info to the CSV file.
	 */
	private void signUp() {
		System.out.println("Only customers can sign up in here!");
		double activeBalance = 0;
		keyboard.nextLine();
		System.out.print("Username: ");
		String username = keyboard.nextLine();
		System.out.println("");
		System.out.print("Password: ");
		String password = keyboard.nextLine();
		System.out.println("");
		System.out.print("Telephone: ");
		String telephone = keyboard.nextLine();
		System.out.println("");
		System.out.print("Email: ");
		String email = keyboard.nextLine();
		System.out.println("");
		boolean more = true;
		List<Address> addressList = new ArrayList<Address>();
		while (more) {
			System.out.print("Address Title: ");
			String addressTitle = keyboard.nextLine();
			System.out.println("");
			System.out.print("Country: ");
			String country = keyboard.nextLine();
			System.out.println("");
			System.out.print("City: ");
			String city = keyboard.nextLine();
			System.out.println("");
			System.out.print("District: ");
			String district = keyboard.nextLine();
			System.out.println("");
			System.out.print("Street: ");
			String street = keyboard.nextLine();
			System.out.println("");
			System.out.print("Door number: ");
			String doorNumber = keyboard.nextLine();
			System.out.println("");
			Address address = new Address(addressTitle, country, city, district, street, doorNumber);
			addressList.add(address);
			System.out.print("Do you want to add new address?(1- Yes/2- No): ");
			int entry = keyboard.nextInt();
			if (entry == 1) {
				more = true;
			} else if (entry == 2) {
				more = false;
			}
		}
		ContactInfo contactInfo = new ContactInfo(telephone, email, addressList);
		RegularUser customer = new Customer(username, password, activeBalance, contactInfo);
		userDatabase.addCustomer((Customer) customer);
		try {
			PrintWriter outputStream = new PrintWriter(new FileOutputStream("users.csv", true));
			outputStream.print("2," + username + "," + password + "," + activeBalance + "," + telephone + "," + email + ", , , ,");
			for (Address i : addressList) {
				outputStream.print(i.getAddressTitle() + "," + i.getCountry() + "," + i.getCity() + "," + i.getDistrict() + "," + i.getStreet() + "," + i.getDoorNumber());
			}
			outputStream.print("\n");
			outputStream.close();
		} catch (FileNotFoundException e) {
		    System.out.println("File not found to write!");
		}
	}
	/**
	 * It takes the username and password info from the console and
	 * checks if there is an account like this. If there is, it returns the user object.
	 */
	private RegularUser signIn() {
		System.out.print("Username: ");
		String username = keyboard.next();
		System.out.println("");
		System.out.print("Password: ");
		String password = keyboard.next();
		System.out.println("");
		Customer customer = userDatabase.signInCustomer(username, password);
		Supplier supplier = userDatabase.signInSupplier(username, password);
		if (customer != null) {
			return customer;
		} else if (supplier != null) {
			return supplier;
		} else {
			System.out.println("Username or password is wrong!");
			return null;
		}
	}
	
	private void signOut() {
		System.out.println("We wish to see you back!");
	}
	/**
	 * It takes the amount to deposit from the user.
	 * Then it updates the file and the user attribute with the new amount.
	 */
	private void depositMoney(RegularUser regularUser) {
		System.out.print("How much money are you going to deposit? ");
		double amount = keyboard.nextDouble();
		System.out.println("");
		regularUser.depositMoney(amount);
		reader.CSVEditor(regularUser);
	}
	/**
	 * It lists the shop products to the user and
	 * according to the choices adds them to the user basket.
	 */
	private void addToBasket(Customer customer) throws ProductNotFoundException {
		System.out.println("Which type of item do you want to buy?");
		System.out.println("1- ACCESSORIES");
		System.out.println("2- COSMETIC");
		System.out.println("3- ELECTRONIC");
		System.out.println("4- HOUSEWARE");
		System.out.print("User input: ");
		int choice = keyboard.nextInt();
		System.out.println("");
		if (choice == 1) {
			Supplier supplier = getSupplierAndPrintShop("accessories");
			basketAdder(customer, supplier);
		} else if (choice == 2) {
			Supplier supplier = getSupplierAndPrintShop("cosmetic");
			basketAdder(customer, supplier);
		} else if (choice == 3) {
			Supplier supplier = getSupplierAndPrintShop("electronic");
			basketAdder(customer, supplier);
		} else if (choice == 4) {
			Supplier supplier = getSupplierAndPrintShop("houseware");
			basketAdder(customer, supplier);
		} else {
			System.out.println("Wrong input!");
		}
	}
	/**
	 * It calls the basket remover method and removes the chosen products from the basket.
	 */
	private void removeFromBasket(Customer customer) throws ProductNotFoundException {
		basketRemover(customer);
	}
	/**
	 * This method gets the supplier of the product type and prints its products. 
	 */
	private Supplier getSupplierAndPrintShop(String type) {
		Supplier supplier = null;
		for (Supplier i : userDatabase.getSupplierDatabase()) {
			if (i.getShop().getCategory().equals(type)) {
				System.out.println(i.getShop());
				supplier = i;
			}
		}
		return supplier;
	}
	/**
	 * This method takes the user choice and adds the wanted product to the basket.
	 */
	private void basketAdder(Customer customer, Supplier supplier) {
		System.out.print("Enter the product number: ");
		int productNum = keyboard.nextInt();
		System.out.println("");
		Product product = supplier.getShop().getKey(productNum);
		int productQuantity = supplier.getShop().getValue(productNum);
		System.out.println("The quantity of the item is: " + productQuantity);
		System.out.print("Enter the quantity to buy: ");
		int quantity = keyboard.nextInt();
		if (quantity <= productQuantity) {
			customer.getBasket().getBasket().addElementToInventory(product, quantity);
		}
	}
	/**
	 * This method takes the user choice and removes the unwanted item from the basket.
	 */
	private void basketRemover(Customer customer) throws ProductNotFoundException {
		System.out.println(customer.getBasket());
		System.out.print("Enter the product number: ");
		int productNum = keyboard.nextInt();
		System.out.println("");
		Product product = customer.getBasket().getKey(productNum);
		int productQuantity = customer.getBasket().getValue(productNum);
		System.out.println("The quantity of the item is: " + productQuantity);
		System.out.print("Enter the quantity to remove: ");
		int quantity = keyboard.nextInt();
		if (quantity < productQuantity) {
			customer.getBasket().getBasket().removeElementFromInventory(product, quantity);
		}
	}	
	/**
	 * This method only gets the supplier of the wanted type.
	 */
	private Supplier getSupplier(String type) {
		Supplier supplier = null;
		for (Supplier i : userDatabase.getSupplierDatabase()) {
			if (i.getShop().getCategory().equals(type)) {
				supplier = i;
			}
		}
		return supplier;
	}
	/**
	 * This method makes the buying operation. It takes calculates the price of the basket,
	 * checks if the user has the necessary amount of money. First, takes the money from the user and lastly, 
	 * it buys the products one by one from their sellers and.
	 */
	private void buyProduct(Customer customer, AdminUser admin) throws ProductNotFoundException {
		System.out.println("You have " + customer.getActiveBalance() + "TL in your wallet.");
		double price = priceCalculator(customer) + cargoCalculator(customer);
		System.out.println("The total price of the basket is " + price + "TL.");
		Set<Product> productSet = customer.getBasket().getBasket().keySet();
		Object[] productArray = productSet.toArray();
		Collection<Integer> quantitySet = customer.getBasket().getBasket().values();
		Object[] quantityArray = quantitySet.toArray();
		if (customer.isFreeShipping()) {
			price = price - cargoCalculator(customer);
			customer.setFreeShipping(false);
		}
		customer.printAddressTitles();
		System.out.print("Select your delivery address: ");
		String addressTitle = keyboard.next();
		System.out.println("");
		@SuppressWarnings("unused")
		Address deliveryAddress = customer.findAddress(addressTitle);
		if (customer.getActiveBalance() >= price) {
			customer.setActiveBalance(customer.getActiveBalance() - price);
			reader.CSVEditor(customer);
			for (int i = 0; i < productArray.length; i++) {
				Supplier supplier = getSupplier(((Product) productArray[i]).getCategory());
				admin.approveSupplier(supplier);
				customer.getBasket().getBasket().removeElementFromInventory(((Product) productArray[i]), ((int) quantityArray[i]));
				customer.getBoughtProductsInventory().addElementToInventory(((Product) productArray[i]), ((int) quantityArray[i]));
				supplier.getShop().removeProduct(((Product) productArray[i]), ((int) quantityArray[i]));
				supplier.getSoldProductsInventory().addElementToInventory(((Product) productArray[i]), ((int) quantityArray[i]));
				supplier.setActiveBalance(supplier.getActiveBalance() + (((Product) productArray[i]).getPrice() * ((int) quantityArray[i])));
				reader.CSVEditor(supplier);
				supplier.makePayment(admin, price);
				supplier.setApprovalStatus(false);
			}
			if (price >= 2000) {
				customer.setFreeShipping(true);
			}
		} else {
			System.out.println("Not enough money!");
		}
	}
	/**
	 * This method calculates the price of the basket.
	 */
	private double priceCalculator(Customer customer) {
		Set<Product> keySet = customer.getBasket().getBasket().getInventory().keySet();
		Object[] keyArray = keySet.toArray();
		Collection<Integer> values= customer.getBasket().getBasket().getInventory().values();
		Object[] valueArray = values.toArray();
		double total = 0;
		for (int i = 0; i < keyArray.length; i++) {
			double price = ((Product) keyArray[i]).getPrice() * ((int) valueArray[i]);
			total = total + price;
		}
		return total;
	}	
	/**
	 * This method calculates the cargo price of the basket items.
	 */
	private double cargoCalculator(Customer customer) {
		Set<Product> keySet = customer.getBasket().getBasket().getInventory().keySet();
		Object[] keyArray = keySet.toArray();
		Collection<Integer> values= customer.getBasket().getBasket().getInventory().values();
		Object[] valueArray = values.toArray();
		double total = 0;
		for (int i = 0; i < keyArray.length; i++) {
			double cargoPrice = ((Product) keyArray[i]).getCargoPrice() * ((int) valueArray[i]);
			total = total + cargoPrice;
		}
		return total;
	}
	/**
	 * This method return the product that bought by the user. It returns only the product price and the products.
	 */
	private void returnProduct(Customer customer) throws ProductNotFoundException {
		System.out.println(customer.getBoughtProductsInventory());
		System.out.print("Enter the product number you want to return: ");
		int returnIndex = keyboard.nextInt();
		System.out.println("");
		Product productToReturn = customer.getBoughtProductsInventory().getKey(returnIndex);
		int productQuantity = customer.getBoughtProductsInventory().getValue(returnIndex);
		System.out.println("The quantity of the item is: " + productQuantity);
		System.out.print("Enter the quantity to buy: ");
		int quantity = keyboard.nextInt();
		if (quantity <= productQuantity) {
			double priceToReturn = productToReturn.getPrice() * quantity;
			customer.getBoughtProductsInventory().removeElementFromInventory(productToReturn, quantity);
			customer.setActiveBalance(customer.getActiveBalance() + priceToReturn);
			reader.CSVEditor(customer);
			Supplier supplier = getSupplier(productToReturn.getCategory());
			supplier.setActiveBalance(supplier.getActiveBalance() - priceToReturn);
			reader.CSVEditor(supplier);
			supplier.getSoldProductsInventory().removeElementFromInventory(productToReturn, quantity);
			supplier.getShop().addProduct(productToReturn, quantity);
		} else {
			System.out.println("Not enough product!");
		}
	}
}
