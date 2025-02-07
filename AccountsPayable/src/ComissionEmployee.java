
public class ComissionEmployee extends Employee {

	private int grossSales;
	private int commissionRate;
	
	public ComissionEmployee() {
		
	}
	public ComissionEmployee(String firstName, String lastName, int[] sSN, int grossSales, int commissionRate) {
		super(firstName, lastName, sSN);
		this.grossSales = grossSales;
		this.commissionRate = commissionRate;
	}

	public int getGrossSales() {
		return grossSales;
	}

	public void setGrossSales(int grossSales) {
		this.grossSales = grossSales;
	}

	public int getCommissionRate() {
		return commissionRate;
	}

	public void setCommissionRate(int commissionRate) {
		this.commissionRate = commissionRate;
	}
	
	@Override
	public double getPaymentAmount() {
		return grossSales * (commissionRate / 100);
	}
	
	@Override
	public String toString() {
		return "ComissionEmployee [grossSales=" + grossSales + ", commissionRate=" + commissionRate + "], " + super.toString();
	}


}
