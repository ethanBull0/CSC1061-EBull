
public class Staff extends Employee{
	private String title;
	
	public Staff() {
		super();
	}
	
	public Staff(String first, String last, String phoneNum, String email, String office, double salary, String dateHired, String title) {
		super(first, last, phoneNum, email, office, salary, dateHired);
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "Staff [title=" + title + "]";
	}


}
