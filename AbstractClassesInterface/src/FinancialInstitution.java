
public abstract class FinancialInstitution implements Comparable<FinancialInstitution>{
	private String FIName;
	private long fiId;
	private long routingNumber;
	private Address address;
	
	public FinancialInstitution() {
		
	}
	
	public FinancialInstitution(String FIName, long fiId, long routingNumber, Address address) {
		this.FIName = FIName;
		this.fiId = fiId;
		this.routingNumber = routingNumber;
		this.address = address;
	}
	
	public abstract double getInterestRate();
	
	public String getFIName() {
		return FIName;
	}
	public void setFIName(String fIName) {
		FIName = fIName;
	}
	public long getFiId() {
		return fiId;
	}
	public void setFiId(long fiId) {
		this.fiId = fiId;
	}
	public long getRoutingNumber() {
		return routingNumber;
	}
	public void setRoutingNumber(long routingNumber) {
		this.routingNumber = routingNumber;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	@Override
	public int compareTo(FinancialInstitution fi) {
		if (fiId < fi.fiId) {
			return -1;
		} else if (fiId > fi.fiId) {
			return +1;
		}
		return 0;
	}
	
}
