package hw4;
/**
 * This is the body of admin objects. It is a child of user class and has the approve
 * method to approve a supplier to sell items.
 */
public class AdminUser extends User {

	public AdminUser(String username, String password, double activeBalance) {
		super(username, password, activeBalance);
		
	}
	public boolean approveSupplier(Supplier supplier) {
		boolean result = false;
		supplier.setApprovalStatus(true);
		if (supplier.getApprovalStatus() == true) {
			result = true;
		}
		return result;
	}
}
