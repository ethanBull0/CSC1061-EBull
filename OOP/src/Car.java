
public class Car {
	
	
	private Wheel[] wheels = new Wheel[4];
	public static void setWheels(Wheel[]wheels) {
		for (int i = 0; i < wheels; i++) {
			this.wheels[i] = wheels[i];
		}
	}
}
