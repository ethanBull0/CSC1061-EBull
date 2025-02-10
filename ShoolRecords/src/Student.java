
public class Student extends Person {
	private Rank status;

	public Student() {
		super();
		status = null;
	}
	public Student(String first, String last, String phoneNum, String email, Rank status) {
		super(first, last, phoneNum, email);
		this.status = status;
	}
	@Override
	public String toString() {
		return "Student [status=" + status + "]";
	}

	public Rank getStatus() {
		return status;
	}

	public void setStatus(Rank status) {
		this.status = status;
	}
}
