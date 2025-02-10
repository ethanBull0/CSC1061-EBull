import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Database {
	static final String fileName = "Database.csv";
	static File outFile = new File(fileName);
	static PrintWriter printer;
	
	public static void WriteGeometricOBject(GeometricObject g) {
		if (printer == null) {
			try {
				printer = new PrintWriter(outFile);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	
	printer.print(g.getClass().getName());
}
}
