
public class SalariedEmployee extends Employee {
	
	private int weeklySalary;
	
	public SalariedEmployee(String firstName, String lastName, int sSN) {
		super(firstName, lastName, sSN);
	}

	@Override
	public int getPaymentAmount() {
		return weeklySalary;
	}
}
