
public class Person {
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String emailAddress;
	
	public Person() {
		
	}
	
	public Person(String name, String address, String phoneNumber, String emailAddress) {
		super();
		this.firstName = name;
		this.lastName = address;
		this.phoneNumber = phoneNumber;
		this.emailAddress = emailAddress;
	}

	
	public String getName() {
		return firstName;
	}
	public void setName(String name) {
		this.firstName = name;
	}
	public String getAddress() {
		return lastName;
	}
	public void setAddress(String address) {
		this.lastName = address;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	@Override
	public String toString() {
		return "firstName=" + firstName + ", lastName=" + lastName + ", phoneNumber=" + phoneNumber + ", emailAddress="
				+ emailAddress + " ";
	}
}
