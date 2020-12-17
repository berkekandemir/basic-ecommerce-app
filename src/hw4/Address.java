package hw4;
/**
 * This is the body of the address objects. It holds the specifications of the address objects.
 */
public class Address {
	private String addressTitle;
	private String country;
	private String city;
	private String district;
	private String street;
	private String doorNumber;
	
	public Address(String addressTitle, String country, String city, String district, String street, String doorNumber) {
		this.addressTitle = addressTitle;
		this.country = country;
		this.city = city;
		this.district = district;
		this.street = street;
		this.doorNumber = doorNumber;
	}

	public String getAddressTitle() {
		return addressTitle;
	}

	public void setAddressTitle(String addressTitle) {
		this.addressTitle = addressTitle;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getDoorNumber() {
		return doorNumber;
	}

	public void setDoorNumber(String doorNumber) {
		this.doorNumber = doorNumber;
	}
	
	public String toString() {
		return addressTitle + ": " + street + " " + doorNumber + " " + district + "/" + city + "/" + country;
	}

}
