
public class HourlyEmployee extends Employee {
	private double hourlyWage;
	private int hours;
	public HourlyEmployee(String firstName, String lastName, int sSN, int hourlyWage, int hours) {
		super(firstName, lastName, sSN);
		this.hourlyWage = hourlyWage;
		this.hours = hours;
	}
	public double getHourlyWage() {
		return hourlyWage;
	}
	public void setHourlyWage(int hourlyWage) {
		this.hourlyWage = hourlyWage;
	}
	public int getHours() {
		return hours;
	}
	public void setHours(int hours) {
		this.hours = hours;
	}
	@Override
	public double getPaymentAmount() {
		return (double)hourlyWage * hours;
	}
	@Override
	public String toString() {
		return "HourlyEmployee [hourlyWage=" + hourlyWage + ", hours=" + hours + "], " + super.toString();
	}
	
}
