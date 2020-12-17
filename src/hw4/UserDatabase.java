package hw4;

import java.util.ArrayList;
import java.util.List;
/**
 * This is the body of the user database. It holds all the user info in it.
 * It also checks the sign in info if it corrects or not.
 */
public class UserDatabase {
	private List<Customer> customerDatabase;
	private List<Supplier> supplierDatabase;
	private List<AdminUser> adminDatabase;
	
	public UserDatabase() {
		customerDatabase = new ArrayList<Customer>();
		supplierDatabase = new ArrayList<Supplier>();
		adminDatabase = new ArrayList<AdminUser>();
		
	}
	
	public List<Customer> getCustomerDatabase() {
		return customerDatabase;
	}

	public void setCustomerDatabase(List<Customer> customerDatabase) {
		this.customerDatabase = customerDatabase;
	}

	public List<Supplier> getSupplierDatabase() {
		return supplierDatabase;
	}

	public void setSupplierDatabase(List<Supplier> supplierDatabase) {
		this.supplierDatabase = supplierDatabase;
	}

	public List<AdminUser> getAdminDatabase() {
		return adminDatabase;
	}

	public void setAdminDatabase(List<AdminUser> adminDatabase) {
		this.adminDatabase = adminDatabase;
	}

	public void addCustomer(Customer customer) {
		customerDatabase.add(customer);
	}
	public boolean removeCustomer(Customer customer) {
		return customerDatabase.remove(customer);
	}
	public void addSupplier(Supplier supplier) {
		supplierDatabase.add(supplier);
	}
	public boolean removesupplier(Supplier supplier) {
		return supplierDatabase.remove(supplier);
	}
	public void addAdmin(AdminUser admin) {
		adminDatabase.add(admin);
	}
	public boolean removeAdmin(AdminUser admin) {
		return adminDatabase.remove(admin);
	}
	public User searchCustomer(Customer customer) {
		for (User i : customerDatabase) {
			i.getUsername().equals(customer.getUsername());
			return i;
		}
		return null;
	}
	public User shopSearch(String category) {
		for (int i = 0; i < supplierDatabase.size(); i++) {
			if (supplierDatabase.get(i) instanceof Supplier) {
				if (supplierDatabase.get(i).getShop().getCategory().equals(category)) {
					return supplierDatabase.get(i);
				}
			}
		}
		return null;
	}
	
	public Customer signInCustomer(String username, String password) {
		for (Customer i : customerDatabase) {
			if ((i.getUsername().equals(username)) && (i.getPassword().equals(password))) {
				return i;
			}
		}
		return null;
	}
	public Supplier signInSupplier(String username, String password) {
		for (Supplier i : supplierDatabase) {
			if ((i.getUsername().equals(username)) && (i.getPassword().equals(password))) {
				return i;
			}
		}
		return null;
	}
}
