
public class Faculty extends Employee{
	private String officeHours;
	private Rank status;
	
	public Faculty() {
		
	}
	public Faculty(String first, String last, String phoneNum, String email, String office,
			double salary, String dateHired, String officeHours, Rank status) {
		super(first, last, phoneNum, email, office, salary, dateHired);
		this.officeHours = officeHours;
		this.status = status;
	}
	public Faculty(String officeHours, Rank status) {
		super();
		this.officeHours = officeHours;
		this.status = status;
	}
	
	public String getOfficeHours() {
		return officeHours;
	}
	public void setOfficeHours(String officeHours) {
		this.officeHours = officeHours;
	}
	public Rank getStatus() {
		return status;
	}
	public void setStatus(Rank status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return super.toString() + " officeHours=" + officeHours + ", status=" + status ;
	}
}
