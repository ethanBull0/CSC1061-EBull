import java.util.ArrayList;
import java.util.List;

	
public class Code {
	
	public static void main(String[] args) {
		System.out.println(factorial(8));
	}
	
	public static long factorial(int n) {
		if (n == 0 || n == 1) {
			return 1;
		} else {
		
		return factorial(n - 2) * factorial(n - 1);
		}
	}
}
		

		


