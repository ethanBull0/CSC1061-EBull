
public class Student extends Person {
	private Rank Status;

	public Student() {
		super();
		Status = null;
	}
	public Student(String first, String last, String phoneNum, String email, Rank status) {
		super(first, last, phoneNum, email);
		this.Status = status;
	}
	@Override
	public String toString() {
		return   super.toString() + "status=" + Status;
	}

	public Rank getStatus() {
		return Status;
	}

	public void setStatus(Rank Status) {
		this.Status = Status;
	}
}
