import java.io.File;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

public class FileWriting {
	
	public static void main(String[] args) {
	File myFile = new File("file1.txt");
	if (!myFile.exists()) {
		try {
		myFile.createNewFile();
		} catch (IOException e) {
			System.out.println(e.getMessage());
			System.exit(-1);
		}
	}
	
	PrintWriter printer = null;
	try {
		printer = new PrintWriter(new FileWriter(myFile, true)); //true = append, false = don't append
	} catch (IOException e) {
		System.out.println(e.getMessage());
		e.printStackTrace();
	}
	printer.append("Hello World!\n"); //overrides entire file, so you don't get a new line every run.
	//printer.printf("The answer is %d", 5);
	//printer.flush();
	printer.close();
	}
	
}
