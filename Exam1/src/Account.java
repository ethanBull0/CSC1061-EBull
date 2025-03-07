import java.util.Date;
import java.util.List;
import java.util.ArrayList;

public class Account {
	private int id;
	private double balance;
	private double annualInterestRate;
	private Date dateCreated;
	private String name;
	private List<Transaction> transactions = new ArrayList<Transaction>();
	
	public Account() {
		
	}
	
	public List<Transaction> getTransactions() {
		return transactions;
	}
	
	public Account(int id, double balance) {
		this.id = id;
		this.balance = balance;
		this.dateCreated = new Date();
	}
	public Account(int id, double balance, double annualInterestRate) {
		this.id = id;
		this.balance = balance;
		this.annualInterestRate = annualInterestRate;
		this.dateCreated = new Date();
	}
	public Account(int id, double balance, double annualInterestRate, String name) {
		this.id = id;
		this.balance = balance;
		this.annualInterestRate = annualInterestRate;
		this.dateCreated = new Date();
		this.name = name;
	}

	public String getName() {
		return name;
	}
	public int getID() {
		return id;
	}
	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double getAnnualInterestRate() {
		return annualInterestRate;
	}

	public void setAnnualInterestRate(double annualInterestRate) {
		this.annualInterestRate = annualInterestRate;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public double getMonthlyInterestRate() {
		return annualInterestRate / 12;
	}
	
	public double getMonthlyInterest() {
		return balance * (getMonthlyInterestRate() / 100);
	}
	
	public void withdraw(double amount) {
		balance -= amount;
		transactions.add(new Transaction(new Date(), 'W', amount, balance));
	}
	
	public void deposit(double amount) {
		balance += amount;
		transactions.add(new Transaction(new Date(), 'D', amount, balance));
	}

	@Override
	public String toString() {
		return "[id=" + id + ", balance=" + balance + ", annualInterestRate=" + annualInterestRate
				+ ", dateCreated=" + dateCreated + ", name:" + name + "]";
	}
	
	public String transactionToString() {
		String tToString = "";
		for (Transaction t : transactions) {
			tToString += t.toString();
			tToString += "\n";
		}
		return tToString;
	}
}
