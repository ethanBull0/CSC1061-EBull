import java.util.List;
import java.util.LinkedList;

public class Fan {
	public static final int SLOW = 1;
	public static final int MEDIUM = 2;
	public static final int FAST = 3;
	
	private static int speed = SLOW;
	private static boolean on = false;
	private static double radius = 5;
	private static String color = "blue";
	private static int id;
	
	public Fan() {
		super();
	}
	
	public Fan(int speed, boolean on, double radius, String color) {
		this.id += 1; //unsure how to go about ids
	}
	
	public static int getSpeed() {
		return speed;
	}
	public static void setSpeed(int speed) {
		Fan.speed = speed;
	}
	public static boolean isOn() {
		return on;
	}
	public static void setOn(boolean on) {
		Fan.on = on;
	}
	public static double getRadius() {
		return radius;
	}
	public static void setRadius(double radius) {
		Fan.radius = radius;
	}
	public static String getColor() {
		return color;
	}
	public static void setColor(String color) {
		Fan.color = color;
	}
	
	public static void setId() {
			// user cannot set id
	}
	
	
	public String toString() {
		if (on) {
			return "ID: " + id + " Fan Speed: " + speed + " Color: " +  color + " Radius:" + radius;
		} else {
			return "fan is off";
		}
	}
	
}
