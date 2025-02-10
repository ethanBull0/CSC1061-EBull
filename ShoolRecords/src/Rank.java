
public class Rank {
	private String r;
	
	
	public Rank(String r) {
		if (r.equals("Freshman") || r.equals("Sophomore") || r.equals("Junior") || r.equals("Senior") ||
				r.equals("Freshman".toLowerCase()) || r.equals("Sophomore".toLowerCase()) || r.equals("Junior".toLowerCase()) || r.equals("Senior".toLowerCase()))
		this.r = r;
		else
			System.out.println("Could not create rank out of string " + r + ". Try freshman, sohpomore, junior, or senior");
	}
}
