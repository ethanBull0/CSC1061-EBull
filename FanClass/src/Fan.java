import java.util.List;
import java.util.LinkedList;

public class Fan {
	public static final int SLOW = 1;
	public static final int MEDIUM = 2;
	public static final int FAST = 3;
	
	private int speed = SLOW;
	private boolean on = false;
	private double radius = 5;
	private String color = "blue";
	private static int id;
	
	public Fan(int speed, boolean on, double radius, String color) {
		id += 1; //unsure how to go about ids. given this code, id should increment every time a fan object is created
	}
	
	public Fan() { //include super(); ?
		id += 1;
	}
	
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public boolean isOn() {
		return on;
	}
	public void setOn(boolean on) {
		this.on = on;
	}
	public double getRadius() {
		return radius;
	}
	public void setRadius(double radius) {
		this.radius = radius;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getId() {
		return id;
	}
	public static void setId() {
			// user cannot set id
	}
	public void turnOn() {
		on = true;
	}
	
	public String toString() {
		if (on) {
			return "ID: " + id + " Fan Speed: " + speed + " Color: " +  color + " Radius:" + radius;
		} else {
			return "fan is off";
		}
	}
	
}
