import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Database {

	private static String filePath = "PersonDatabase.csv";
	private static File outFile = new File(filePath);
	private static PrintWriter printer;
	
	public void writePerson(Person p) { //reads all persons and its subclasses, cannot write Object
		if (printer == null) {
			try {
				printer = new PrintWriter(outFile);
			} catch (FileNotFoundException e) {
				System.out.println("failed to create printwriter");
			}
		}
		
		printer.print(p.getClass().getName());
		if (p instanceof Student) {
			
		} else if (p instanceof Employee) {
			
		} else if (p instanceof Faculty) {
			
		} else if (p instanceof Staff) {
			
		}
		
		
		printer.print("\n");
		printer.flush();
	}
	
	
}
