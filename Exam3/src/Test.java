
import java.util.ArrayDeque;

public class Test {
	public static void main(String[] args) {
		ArrayDeque<String> stack = new ArrayDeque<>();
		String s = "())(())";
		while (s != null) {
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
