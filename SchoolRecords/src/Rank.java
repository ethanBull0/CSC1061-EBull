
public enum Rank {
	FRESHMAN(1),
	SOPHOMORE(2),
	JUNIOR(3),
	SENIOR(4);
	
	private final int year;
	
	Rank(int year) {
		this.year = year;
	}

	public int getYear() {
		return year;
	}
	
	
}