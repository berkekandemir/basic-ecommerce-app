package hw4;
/**
 * This is the body of the user objects. It holds their specifications as attributes.
 */
public abstract class User {
	private String username;
	private String password;
	private double activeBalance;
	
	public User(String username, String password) {
		this.username = username;
		this.password = password;
		activeBalance = 0;
	}
	public User(String username, String password, double activeBalance) {
		this.username = username;
		this.password = password;
		this.activeBalance = activeBalance;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public double getActiveBalance() {
		return activeBalance;
	}
	public void setActiveBalance(double activeBalance) {
		this.activeBalance = activeBalance;
	}
	public void depositMoney(double amount) {
		activeBalance = activeBalance + amount;
	}
}
