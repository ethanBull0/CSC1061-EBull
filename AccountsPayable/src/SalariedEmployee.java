
public class SalariedEmployee extends Employee {
	
	private int weeklySalary;
	
	public SalariedEmployee(String firstName, String lastName, int sSN, int weeklySalary) {
		super(firstName, lastName, sSN);
		this.weeklySalary = weeklySalary;
	}

	public int getWeeklySalary() {
		return weeklySalary;
	}

	public void setWeeklySalary(int weeklySalary) {
		this.weeklySalary = weeklySalary;
	}
	
	@Override
	public int getPaymentAmount() {
		return weeklySalary;
	}
	
	@Override
	public String toString() {
		return "SalariedEmployee [weeklySalary=" + weeklySalary + "]";
	}

	
}
