
public class TestFan extends Fan{


	public static void main(String[] args) {
		Fan fan1 = new Fan(SLOW, true, 10, "yellow");
		Fan fan2 = new Fan(MEDIUM, false, 5, "blue");
		fan1.turnOn();
		fan2.turnOn();
		System.out.println(fan1.toString());
		System.out.println(fan2.toString());
	}

}