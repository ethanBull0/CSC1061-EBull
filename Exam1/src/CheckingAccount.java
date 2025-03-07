import java.util.Date;

public class CheckingAccount extends Account {
	
	private int overdraftLimit;
	
	public CheckingAccount() {
		super();
	}
	
	public CheckingAccount(int id, double balance, double annualInterestRate, int overdraftLimit) {
		super(id, balance, annualInterestRate);
		this.overdraftLimit = overdraftLimit;
	}
	
	public CheckingAccount(int id, double balance, double annualInterestRate, int overdraftLimit, String name) {
		super(id, balance, annualInterestRate, name);
		this.overdraftLimit = overdraftLimit;
	}

	
	public int getOverDraftLimit() {
		return overdraftLimit;
	}
	
	@Override
	public void withdraw(double amount) {
		double newBal = super.getBalance() - amount;
		if (newBal < (overdraftLimit * -1)) {
			System.out.println("Withdrawal exceeds overdraft limit!");
		}
		super.setBalance(newBal);
		super.getTransactions().add(new Transaction(new Date(), 'W', amount, super.getBalance()));
	}
	
	@Override
	public String toString() {
		return super.toString() + " [overdraftLimit = " + overdraftLimit + "] ";
	}
	
}
