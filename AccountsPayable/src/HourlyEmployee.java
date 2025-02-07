
public class HourlyEmployee extends Employee {
	private double hourlyWage;
	private double hours;
	public HourlyEmployee(String firstName, String lastName, int[] sSN, int hourlyWage, int hours) {
		super(firstName, lastName, sSN);
		this.hourlyWage = hourlyWage;
		this.hours = hours;
	}
	public HourlyEmployee() {
		// TODO Auto-generated constructor stub
	}
	public double getHourlyWage() {
		return hourlyWage;
	}
	public void setHourlyWage(double hourlyWage) {
		this.hourlyWage = hourlyWage;
	}
	public double getHours() {
		return hours;
	}
	public void setHours(double hours) {
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
