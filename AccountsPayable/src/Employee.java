
public class Employee {
	private String firstName;
	private String lastName;
	private int sSN;
	int pay;
	
	public int getPaymentAmount() {
		return pay;
	}

	public Employee(String firstName, String lastName, int sSN) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.sSN = sSN;
	}

	public Employee() {
		super();
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getSSN() {
		return sSN;
	}

	public void setSSN(int sSN) {
		sSN = sSN;
	}

	@Override
	public String toString() {
		return "Employee [firstName=" + firstName + ", lastName=" + lastName + ", SSN=" + sSN + "]";
	}
	
}
