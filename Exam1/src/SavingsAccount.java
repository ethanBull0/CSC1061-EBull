
public class SavingsAccount extends Account {

	private int minimumBalance;
	
	public SavingsAccount() {
		super();
	}
	
	public SavingsAccount(int id, double balance, double annualInterestRate, int minimumBalance) {
		super(id, balance, annualInterestRate);
		this.minimumBalance = minimumBalance;
	}
	
	@Override
	public String toString() {
		return super.toString() + " [minimumBalance = " + minimumBalance + "] ";
	}
	
	@Override
	public void withdraw(double amount) {
		double newBal = super.getBalance() - amount;
		if (newBal < minimumBalance) {
			System.out.println("Cannot withdraw past minimum balance!");
		}
		super.setBalance(newBal);
	}
}
