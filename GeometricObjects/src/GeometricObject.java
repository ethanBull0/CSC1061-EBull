import java.util.Date;

public class GeometricObject {
	private String color = "white";
	private boolean isFilled = true;
	private Date creationDate;
	
	public GeometricObject() {
		super();
	}
	
	public GeometricObject(String color, boolean isFilled) {
		super();
		this.color = color;
		this.isFilled = isFilled;
	}
	
	public String getColor() {
		return color;
	}
	
	public void setColor() {
		this.color = color;
	}
	
	public boolean getIsFilled() {
		return isFilled;
	}
	
	public void setIsFilled() {
		this.isFilled = isFilled;
	}
	
	public Date getCreationDate() {
		return creationDate;
	}
	
	public String toString() {
		return "Geometric Object [color=" + color + ", isFilled=" + isFilled + ", Creation Date=" + creationDate + "]";
	}
}
