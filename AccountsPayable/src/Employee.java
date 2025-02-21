
public class Employee {
	private String firstName;
	private String lastName;
	private int[] sSN = new int[9];
	int pay;
	/**
	 * 
	 * @return Payment amount
	 */
	public double getPaymentAmount() {
		return pay;
	}

	public Employee(String firstName, String lastName, int[] sSN) {
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

	public int[] getSSN() {
		return sSN;
	}

	public void setSSN(int[] sSN) {
		while (sSN.length != 9) {
			System.out.println("Incorrect SSN length, please try setting SSN again.");
		}
		this.sSN = sSN;
	}

	public String sSNToString() {
		String sSNString = "";
		for (int i : sSN) {
			sSNString += i;
		}
		return sSNString;
	}
	@Override
	public String toString() {
		return "Employee [firstName=" + firstName + ", lastName=" + lastName + ", SSN=" + sSNToString() + "]";
	}
	
}
