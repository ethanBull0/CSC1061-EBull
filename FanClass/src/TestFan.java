
public class TestFan extends Fan{


	public static void main(String[] args) {
		Fan fan1 = new Fan(SLOW, true, 10, "yellow", 0);
		Fan fan2 = new Fan(MEDIUM, false, 5, "blue", 0);
		System.out.println(fan1.toString());
		System.out.println(fan2.toString());
	}

}