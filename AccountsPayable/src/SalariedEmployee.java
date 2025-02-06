
public class SalariedEmployee extends Employee {
	
	private double weeklySalary;
	
	public SalariedEmployee() {
		
	}
	public SalariedEmployee(String firstName, String lastName, int sSN, int weeklySalary) {
		super(firstName, lastName, sSN);
		this.weeklySalary = weeklySalary;
	}

	public double getWeeklySalary() {
		return weeklySalary;
	}

	public void setWeeklySalary(double weeklySalary) {
		this.weeklySalary = weeklySalary;
	}
	
	@Override
	public double getPaymentAmount() {
		return weeklySalary;
	}

	@Override
	public String toString() {
		return "SalariedEmployee [weeklySalary=" + weeklySalary + ", " + super.toString() + "]";
	}
	
	

	
}
