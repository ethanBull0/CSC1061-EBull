
public class AccountTest {

	public static void main(String[] args) {
		Account myChecking = new CheckingAccount(1111, 2000, 0.5, 200);
		myChecking.withdraw(2100);
		myChecking.deposit(3000);
		
		System.out.println(myChecking.toString());
		
		Account mySavings = new SavingsAccount(1100, 500, 1.0, 200);
		mySavings.withdraw(200);
		
		System.out.println(mySavings.toString());
		
		Account georgesChecking = new CheckingAccount(2222, 1000, 1.5, 200, "George");
		
		georgesChecking.deposit(30);
		georgesChecking.deposit(40);
		georgesChecking.deposit(50);
		georgesChecking.withdraw(5);
		georgesChecking.withdraw(4);
		georgesChecking.withdraw(2);
		
		System.out.println(georgesChecking.toString());
		System.out.println(georgesChecking.getName() +"'s transactions: ");
		System.out.print(georgesChecking.transactionToString());
		System.out.print("End of " + georgesChecking.getName() + "'s transactions.");
		
	}

}
