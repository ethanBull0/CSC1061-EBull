
import java.util.ArrayDeque;

public class Test {
	public static void main(String[] args) {
		ArrayDeque<String> stack = new ArrayDeque<>();
		String[] strings = new String[4];
		while (s != null) {
			strings[0].has
			s = s.substring(0, s.length() );
			if (s.substring(s.length() - 1).equals("(")) {
				stack.push("(");
			} else if (s.substring(s.length() - 1).equals(")")) {
				stack.pop();
			} else {
				System.out.println("unbalanced");
				System.exit(-1);
			}
			System.out.println("balanced");
		}
	}
}
