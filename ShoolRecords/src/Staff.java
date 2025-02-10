
public class Staff extends Employee{
	private String title;
	
	public Staff(String title) {
		super();
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
