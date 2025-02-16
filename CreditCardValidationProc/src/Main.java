import java.util.Scanner;

public class Main {
	final static int AMEX = 37;
	final static int VISA = 4;
	final static int MASTER = 5;
	final static int DISCOVER = 6;
	public static void main(String[] args) {
		long myNum = 4388576018402626L;
		System.out.println(sumOfDoubleEvenPlace(myNum));
		System.out.println(sumOfOddPlace(myNum));
		System.out.println(prefixMatched(myNum, VISA));
	}
	
	//Return true if card number is valid
	//public static boolean isValid(long number) {
	//		int evenSum = sumOfDoubleEvenPlace(number);
	//	
	//}
	
	public static int sumOfDoubleEvenPlace(long n) {
		long number = (long) (n / 10);
		int sum = 0;
		int thisDigit = 0;
		while (number > 0) {
			int digit = (int)(number % 10);
			thisDigit = getDigit(digit);
			
			sum += thisDigit;
			number /= 100;
		}
		return sum;
	}
	
	//Return this number if it is a single digit, otherwise
	//return sum of two digits
	public static int getDigit(int digit) {
		if (digit * 2 >= 10) {
			digit = ((digit * 2) % 10) + ((digit * 2) / 10);
		} else {
			digit *= 2;
	}
		return digit;
	}
	
	//Return sum of odd-place digits in number
	public static int sumOfOddPlace(long number) {
		int sum = 0;
		while (number > 0) {
			sum += (int)(number % 10);
			number /= 100;
		}
		return sum;
	}
//	
//	//Return true if digit d is a prefix for number
	public static boolean prefixMatched(long number, int d) {
		int dLen = 1;
		while (d > 0) {
			dLen *= 10;
			d /= 10;
		}
		System.out.println(dLen + "'s place");
		while (number > dLen) {
			number /= 10;
		}
		
		System.out.println(number);
		if (number == d) {
			return true;
		} else {
		return false;
		}
	}
//	
//	//Return number of digits in d
	public static int getSize(long d) {
		int count = 0;
		while (d > 0) {
			count++;
			d /= 10;
		}
		return count;
	}
//	
//	//return first k number of digits from number.
//	//If number of digits in number is less than k, return number
	public static long getPrefix(long number, int k) {
		Scanner scn = new Scanner(System.in);
		int countVal = 0;
		boolean doCountReverse = false;
		while (countVal != 1 || countVal != 2) {
			System.out.println("Count in reverse (1) or forward (2)?");
			countVal = scn.nextInt();
		}
		if (countVal == 1) {
			
		} else if (countVal == 2) {
			
		}
	}
	
	}
