
public class Rectangle extends GeometricObject {
	private double length;
	private double width;
	
	public Rectangle() {
		super("Black", false);
		length = 1.0;
		width = 1.0;
	}

	public Rectangle(double length, double width) {
		super("Black", false);
		this.length = length;
		this.width = width;
	}

	@Override
	public String toString() {
		return "Rectangle [length=" + length + ", width=" + width + "]";
	}

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}
	
	public double getArea() {
		return length * width;
	}
	
	public double getPerimeter() {
		return 2 * (width + length);
	}
	
}
