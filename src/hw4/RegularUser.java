package hw4;
/**
 * This is the body of the regular user objects. It holds their specifications as attributes.
 */
public abstract class RegularUser extends User {
	private ContactInfo contactInfo;
	
	public RegularUser(String username, String password, double activeBalance, ContactInfo contactInfo) {
		super(username, password, activeBalance);
		this.contactInfo = contactInfo;
	}
	public ContactInfo getContactInfo() {
		return contactInfo;
	}
	public void setContactInfo(ContactInfo contactInfo) {
		this.contactInfo = contactInfo;
	}
	public Address findAddress(String title) {
		for (Address i : contactInfo.getAddress()) {
			if (i.getAddressTitle().equals(title)) {
				return i;
			}
		}
		System.out.println("Address not found!");
		return null;
	}
	public void printAddressTitles() {
		for (Address i : contactInfo.getAddress()) {
			System.out.println(i.getAddressTitle());
		}
	}
}
