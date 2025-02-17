
public class Bank extends FinancialInstitution {
	private double interestRate;
	
	
	
	public Bank(String FIName, long fiId, long routingNumber, Address address, double interestRate) {
		super();
		this.interestRate = interestRate;
	}



	@Override
	public double getInterestRate() {
		return interestRate;
	}
}
