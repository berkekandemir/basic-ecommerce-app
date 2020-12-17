package hw4;
import java.io.*;
import java.util.*;
/**
 * This is where we read the CSV files and update them.
 */
public class CSVReader {
	Scanner users;
	Scanner products;
	UserDatabase userDatabase;
	public CSVReader() {
		try {
			users = new Scanner(new File("users.csv"));
		} catch (FileNotFoundException e) {
			System.out.println("File not found!");
		}
		try {
			products = new Scanner(new File("products.csv"));
		} catch (FileNotFoundException e){
			System.out.println("File not found!");
		}
		userDatabase = new UserDatabase();
	}
	
	public UserDatabase read() {
		userCreator();
		productCreator();
		return userDatabase;
	}
	/**
	 * In this method we create address objects of the users.
	 */
	private List<Address> addressCreator(String[] lineArr) {
		int addressCount = (lineArr.length - 9) / 6;
		List<Address> addressList = new ArrayList<Address>();
		int addressIndex = 9;
		for (int i = 0; i < addressCount; i++){
			Address address = new Address(lineArr[addressIndex], lineArr[addressIndex + 1], lineArr[addressIndex + 2], lineArr[addressIndex + 3], lineArr[addressIndex + 4], lineArr[addressIndex + 5]);
			addressList.add(address);
			addressIndex = addressIndex + 6;
		}
		return addressList;
	}
	/**
	 * This method created user objects. It also uses the address creator method for reusability.
	 * It first creates address objects. Then, contact info objects and lastly the whole user object.
	 */
	private void userCreator() {
		int count = 0;
		while (users.hasNextLine()) {
			if (count == 0) {
				count = 1;
				String line = users.nextLine();
				@SuppressWarnings("unused")
				String[] lineArr = line.split(",");
				continue;
			} else {
				String line = users.nextLine();
				String[] lineArr = line.split(",");
				if (Integer.parseInt(lineArr[0]) == 1) {
					User admin = new AdminUser(lineArr[1], lineArr[2], Double.parseDouble(lineArr[3]));
					userDatabase.addAdmin((AdminUser) admin);
				} else if (Integer.parseInt(lineArr[0]) == 2) {
					List<Address> addressList = addressCreator(lineArr);
					ContactInfo contactInfo = new ContactInfo(lineArr[4], lineArr[5], addressList);
					RegularUser customer = new Customer(lineArr[1], lineArr[2], Double.parseDouble(lineArr[3]), contactInfo); 
					userDatabase.addCustomer((Customer) customer);
				} else if (Integer.parseInt(lineArr[0]) == 3) {
					List<Address> addressList = addressCreator(lineArr);
					Shop shop = new Shop(lineArr[6], lineArr[7], lineArr[8]);
					ContactInfo contactInfo = new ContactInfo(lineArr[4], lineArr[5], addressList);
					RegularUser supplier = new Supplier(lineArr[1], lineArr[2], Double.parseDouble(lineArr[3]), contactInfo, shop);
					userDatabase.addSupplier((Supplier) supplier);
				}
			}
		}
		users.close();
	}
	/**
	 * This method creates the product objects. It creates the objects according to the file and 
	 * add them to their shops according to their types.
	 */
	private void productCreator() {
		int count = 0;
		while (products.hasNextLine()) {
			if (count == 0) {
				count = 1;
				String line = products.nextLine();
				@SuppressWarnings("unused")
				String[] lineArr = line.split(",");
				continue;
			} else {
				String line = products.nextLine();
				String[] lineArr = line.split(",");
				if (lineArr[0].equals("houseware")) {
					Product housewareProduct = new Houseware(lineArr[0], lineArr[1], Double.parseDouble(lineArr[2]), Double.parseDouble(lineArr[3]));
					User userToBeAdded = userDatabase.shopSearch(lineArr[0]);
					((Supplier) userToBeAdded).getShop().addProduct(housewareProduct, Integer.parseInt(lineArr[4]));
				} else if (lineArr[0].equals("accessories")) {
					Product accessoriesProduct = new Accessories(lineArr[0], lineArr[1], Double.parseDouble(lineArr[2]), Double.parseDouble(lineArr[3]));
					User userToBeAdded = userDatabase.shopSearch(lineArr[0]);
					((Supplier) userToBeAdded).getShop().addProduct(accessoriesProduct, Integer.parseInt(lineArr[4]));
				} else if (lineArr[0].equals("electronic")) {
					Product electronicProduct = new Electronics(lineArr[0], lineArr[1], Double.parseDouble(lineArr[2]), Double.parseDouble(lineArr[3]));
					User userToBeAdded = userDatabase.shopSearch(lineArr[0]);
					((Supplier) userToBeAdded).getShop().addProduct(electronicProduct, Integer.parseInt(lineArr[4]));
				} else if (lineArr[0].equals("cosmetic")) {
					Product cosmeticProduct = new Cosmetic(lineArr[0], lineArr[1], Double.parseDouble(lineArr[2]), Double.parseDouble(lineArr[3]));
					User userToBeAdded = userDatabase.shopSearch(lineArr[0]);
					((Supplier) userToBeAdded).getShop().addProduct(cosmeticProduct, Integer.parseInt(lineArr[4]));
				}
			}
		}
		products.close();
	}
	/**
	 * This method updates the CSV file if there is any change.
	 * It takes the changed user object as parameter. Then reads the file and hold the whole file
	 * in an array list. Then it starts to rewrite the file. If it comes to the changing line,
	 * it writes the new info and then keeps writing the unchanged lines to the file.
	 */
	public void CSVEditor(RegularUser regularUser) {
		int type;
		if (regularUser instanceof Customer) {
			type = 2;
		} else {
			type = 3;
		}
		try {
			users = new Scanner(new File("users.csv"));
		} catch (FileNotFoundException e) {
			System.out.println("File not found!");
		}
		List<String> allLines = new ArrayList<String>();
		while (users.hasNextLine()) {
			allLines.add(users.nextLine());
		}
		List<String[]> allLinesSplitted = new ArrayList<String[]>();
		for (int j = 0; j < allLines.size(); j++) {
			allLinesSplitted.add(allLines.get(j).split(","));
		}
		try {
			PrintWriter outputStream = new PrintWriter(new FileOutputStream("users.csv"));
			for (int k = 0; k < allLinesSplitted.size(); k++) {
				if (allLinesSplitted.get(k)[1].equals(regularUser.getUsername())) {
					if (type == 2) {
						outputStream.print(type + "," + regularUser.getUsername() + "," + regularUser.getPassword() + "," + regularUser.getActiveBalance() + "," + regularUser.getContactInfo().getPhoneNumber() + "," + regularUser.getContactInfo().getEmail() + ", , , ,");
					} else {
						outputStream.print(type + "," + regularUser.getUsername() + "," + regularUser.getPassword() + "," + regularUser.getActiveBalance() + "," + regularUser.getContactInfo().getPhoneNumber() + "," + regularUser.getContactInfo().getEmail() + "," + ((Supplier) regularUser).getShop().getCategory() + "," + ((Supplier) regularUser).getShop().getName() + "," + ((Supplier) regularUser).getShop().getTaxNumber() + ",");
					}
					for (Address m : regularUser.getContactInfo().getAddress()) {
						outputStream.print(m.getAddressTitle() + "," + m.getCountry() + "," + m.getCity() + "," + m.getDistrict() + "," + m.getStreet() + "," + m.getDoorNumber() + ",");
					}
					outputStream.print("\n");
				} else {
					for (int n = 0; n < allLinesSplitted.get(k).length; n++) {
						outputStream.print(allLinesSplitted.get(k)[n] + ",");
					}
					outputStream.print("\n");
				}
			}
			outputStream.close();
			users.close();
		} catch (FileNotFoundException e) {
		    System.out.println("File not found to write!");
		}
	}
}
