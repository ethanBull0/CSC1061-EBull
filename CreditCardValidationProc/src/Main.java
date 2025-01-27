
public class Main {

	public static void main(String[] args) {

	}
	
	//Return true if card number is valid
	public static boolean isValid(long number) {
		
	}
	
	//Get result from step 2
	public static int sumOfDoubleEvenPlace(long number) {
		int sum = 0;
		while (number > 0) {
			sum += (number % 10);
			number /= 10;
		}
		return sum;
	}
	
	//Return this number if it is a single digit, otherwise
	//return sum of two digits
	public static int getDigit(int number) {
		if (number > 10) {
			return (number % 10) + (number / 10);
		} else {
			return number;
		}
	}
	
	//Return sum of odd-place digits in number
	public static int sumOfOddPlace(long number) {
		
	}
	
	//Return true if digit d is a prefix for number
	public static boolean prefixMatched(long number, int d) {
		
	}
	
	//Return number of digits in d
	public static int getSize(long d) {
		
	}
	
	//return first k number of digits from number.
	//If number of digits in number is less than k, return number
	public static long getPrefix(long number, int k) {
		
	}
	

}
