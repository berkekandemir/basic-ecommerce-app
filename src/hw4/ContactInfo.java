package hw4;

import java.util.List;
/**
 * This is the body of contact info objects. We hold the contact info in an object to encapsulate them.
 */
public class ContactInfo {
	private String phoneNumber;
	private String email;
	private List<Address> address;
	public ContactInfo(String phoneNumber, String email, List<Address> address) {
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.address = address;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public List<Address> getAddress() {
		return address;
	}
	public void setAddress(List<Address> address) {
		this.address = address;
	}
	
}
