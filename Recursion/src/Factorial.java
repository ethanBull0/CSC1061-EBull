
public class Factorial {
	private static long counter = 0;
	private static long[] termArray = new long[200];
	
	
	public static void main(String[] args) {
		int fibNumber = 25;
		System.out.println("Fibonacci sequence entry " + fibNumber + " is " + fibDynamic(fibNumber));
		
		
		System.out.println("Call counter: " + counter);

	}

	public static int factorial(int n) {
		if (n == 0) {
			return 1;
		}
		return n * factorial(n - 1);
	}
	
	public static long fibbonaci(long n) {
		counter++;
		if (n <= 2) {
			return n;
		}
		return  fibbonaci(n - 1) + fibbonaci(n - 2);
	}
	
	public static long fibDynamic(int n) {
		if (n < 2) {
			return n;
		}
		if (termArray[n] > 0) {
			return termArray[n];
		}
		counter++;
		long ans = fibDynamic(n - 1) + fibDynamic(n - 2);
		termArray[n] = ans;
		return ans;
	}
	
	public static long fibIterative(int n) {
		if (n < 2) {
			return n;
		}
		
		
	}
}
