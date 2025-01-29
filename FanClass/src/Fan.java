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
	private int id = 1;
	public static int nextId = 1;
	
	public Fan(int speed, boolean on, double radius, String color) {
		this.speed = speed;
		this.on = on;
		this.radius = radius;
		this.color = color;
		this.id = nextId++;
	}
	
	public Fan() { //include super(); ?
		this.id = nextId++;
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
	public void turnOff() {
		on = false;
	}
	public String speedToString() {
		if (speed == SLOW) {
			return "SLOW";
		} else if (speed == MEDIUM) {
			return "MEDIUM";
		} else if (speed == FAST) {
			return "FAST";
		}
		return "NULL";
	}

	
	public String toString() {
		if (on) {
			return "ID: " + id + " Fan Speed: " + speedToString() + " Color: " +  color + " Radius:" + radius;
		} else {
			return "fan is off";
		}
	}
	
}
