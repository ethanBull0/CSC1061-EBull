
public class Package {

	private Destination destination;
	private double weight;
	private double costPerKg;
	private String status;
	private static int trackingNumber;
	
	public int generateTrackingNum() { //use Random to generate tracking number
		
	}
	
	public String getStatus() {
		return status;
	}
	
	public void updateStatus(String status) {
		this.status = status;
	}
	
	public int getTrackingNumber() {
		return trackingNumber;
	}
	
	public double calculateCost() {
		
	}
	
	public String toString() {
		return destination.toString() + " Weight: " + weight + " Cost Per Kg: " + costPerKg + " Status: " + status + " Tracking Number: " + trackingNumber + "\"";
	}
}
