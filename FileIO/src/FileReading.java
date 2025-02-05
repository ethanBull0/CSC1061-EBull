
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReading {

	public static void main (String[] args) {
		File myFile = new File("file1.txt");
		try {
			Scanner input = new Scanner(myFile);
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
}
