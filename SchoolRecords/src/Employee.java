
public class Employee extends Person {
	private String office;
	private double salary;
	private String dateHired;

	public Employee() {
		
	}
	
	public Employee(String first, String last, String phoneNum, String email, String office, double salary, String dateHired) {
		super(first, last, phoneNum, email);
		this.office = office;
		this.salary = salary;
		this.dateHired = dateHired;
	}
	
	public String getOffice() {
		return office;
	}
	
	public void setOffice(String office) {
		this.office = office;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public String getDateHired() {
		return dateHired;
	}
	public void setDateHired(String dateHired) {
		this.dateHired = dateHired;
	}
	@Override
	public String toString() {
		return super.toString() +  "office=" + office + ", salary=" + salary + ", dateHired=" + dateHired + " " ;
	}
}
