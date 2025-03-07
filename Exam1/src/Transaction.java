import java.util.Date;

public class Transaction {
	private Date date;
	private char transactionType;
	private double amount;
	private double newBalance;
	
	public Transaction(Date date, char transactionType, double amount, double newBalance) {
		super();
		this.date = date;
		this.transactionType = transactionType;
		this.amount = amount;
		this.newBalance = newBalance;
	}

	public Date getDate() {
		return date;
	}
	
	public char getTransactionType() {
		return transactionType;
	}
	
	public double getAmount() {
		return amount;
	}
	
	public double getNewBalance() {
		return newBalance;
	}
	
	
	@Override
	public String toString() {
		return "Transaction [date=" + date + ", transactionType=" + transactionType + ", amount=" + amount
				+ ", newBalance=" + newBalance + "]";
	}
	
	
}
