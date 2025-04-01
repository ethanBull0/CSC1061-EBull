
public class Factorial {

	public static void main(String[] args) {
		System.out.println(factorial(15));
		System.out.println(fibbonaci(50));

	}

	public static int factorial(int n) {
		if (n == 0) {
			return 1;
		}
		return n * factorial(n - 1);
	}
	
	public static int fibbonaci(long n) {
		if (n == 0) {
			return 0;
		}
		if (n == 1) {
			return 1;
		}
		return  fibbonaci(n - 1) + fibbonaci(n - 2);
	}
}
