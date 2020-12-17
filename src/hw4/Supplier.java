package hw4;
/**
 * This is the body of the supplier objects. It holds its specifications and its inventories in it.
 */
public class Supplier extends RegularUser {
	private Shop shop;
	private Inventory<Product> soldProductsInventory;
	private boolean approvalStatus;
	public Supplier(String username, String password, double activeBalance, ContactInfo contactInfo, Shop shop) {
		super(username, password, activeBalance, contactInfo);
		this.shop = shop;
		soldProductsInventory = new ProductInventory<Product>();
		approvalStatus = false;
	}
	public Shop getShop() {
		return shop;
	}
	public void setShop(Shop shop) {
		this.shop = shop;
	}
	public Inventory<Product> getSoldProductsInventory() {
		return soldProductsInventory;
	}
	public void setSoldProductsInventory(Inventory<Product> soldProductsInventory) {
		this.soldProductsInventory = soldProductsInventory;
	}
	public boolean getApprovalStatus() {
		return approvalStatus;
	}
	public void setApprovalStatus(boolean approvalStatus) {
		this.approvalStatus = approvalStatus;
	}
	public void makePayment(AdminUser admin, double price) {
		admin.setActiveBalance(admin.getActiveBalance() + (price * 2 / 100));
		setActiveBalance(getActiveBalance() - (price * 2/ 100));
	}
}
