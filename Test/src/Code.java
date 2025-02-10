import java.util.Date;

class A {
	public A() {
		System.out.println("A invoked");
	}
	public int Hello(int h) {
		return h;
	}
	public double Hello(int h) {
		return h;
	}
}

class B extends A {
	public B() {
		System.out.println("B invoked");
	}
	public void print() {
		System.out.println("hello world");
	}
}
public class Code extends B {
	
	public static void main(String[] args) {
		Code c = new Code();
		
	}
	
}
