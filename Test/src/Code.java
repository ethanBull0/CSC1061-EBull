import java.util.ArrayList;
import java.util.List;

	
public class Code {
	
	public static void main(String[] args) {
		ArrayList<String> lol = new ArrayList<>();
		lol.add("a");
		ArrayList<String> two = lol;
		lol.add("e");
		two.add("i");
		System.out.println(two);
		}
}
		

		


