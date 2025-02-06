
public class BasePlusComissionEmployee extends ComissionEmployee {
	
	double basePay;
	
	public BasePlusComissionEmployee() {
		
	}
	
	public BasePlusComissionEmployee(String firstName, String lastName, int sSN, int grossSales, int commissionRate, int basePay) {
		super(firstName, lastName, sSN, grossSales, commissionRate);
		this.basePay = basePay;
		// TODO Auto-generated constructor stub
	}

	public double getBasePay() {
		return basePay;
	}

	public void setBasePay(double basePay) {
		this.basePay = basePay;
	}
	
	@Override
	public double getPaymentAmount() {
		return basePay + this.getCommissionRate();
	}

	@Override
	public String toString() {
		return "BasePlusCommissionEmployee [basePay=" + basePay + ", " + super.toString() + ", getFirstName()=" + getFirstName() + ", getLastName()="
				+ getLastName() + ", getSSN()=" + getSSN() + "]";
	}

	
}
