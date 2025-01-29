
public class Destination {
	private String address;
	private String city;
	private String state;
	
	public Destination(String address, String city, String state) {
		super();
		this.address = address;
		this.city = city;
		this.state = state;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	@Override
	public String toString() {
		return "Destination [address=" + address + ", city=" + city + ", state=" + state + "]";
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
}
