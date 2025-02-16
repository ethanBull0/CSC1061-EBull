import java.util.ArrayList;
import java.io.File;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Database {

	private static String filePath = "PersonDatabase.csv";
	private static File outFile = new File(filePath);
	private static PrintWriter printer;
	
	public Database() {
		if (printer == null) {
			try {
				printer = new PrintWriter(outFile);
			} catch (FileNotFoundException e) {
				System.out.println("failed to create printwriter");
			}
		}
	}
	
	public void writePerson(Person p) { //reads all persons and its subclasses, cannot write Object
		if (printer == null) {
			try {
				printer = new PrintWriter(outFile);
			} catch (FileNotFoundException e) {
				System.out.println("failed to create printwriter");
			}
		}
		
		printer.print(p.getClass().getName()
				+ "," + p.getName()
				+ "," + p.getAddress()
				+ "," + p.getPhoneNumber()
				+ "," + p.getEmailAddress()
				);
		if (p instanceof Student) {
			printer.print(((Student)p).getStatus());
		} else if (p instanceof Employee) {
			printer.print(((Employee)p).getDateHired()
					+ "," + ((Employee)p).getOffice()
					+ "," + ((Employee)p).getSalary()
					);
		} else if (p instanceof Faculty) {
			printer.print(((Employee)p).getDateHired()
					+ "," + ((Employee)p).getOffice()
					+ "," + ((Employee)p).getSalary()
					+ "," + ((Faculty)p).getOfficeHours()
					);
		} else if (p instanceof Staff) {
			printer.print(((Employee)p).getDateHired()
					+ "," + ((Employee)p).getOffice()
					+ "," + ((Employee)p).getSalary()
					+ "," + ((Staff)p).getTitle()
					);
		}
		
		
		printer.print("\n");
		printer.flush();
	}
	
	public void readPerson(File f) {
		ArrayList<Person> personList = new ArrayList<Person>();
		try {
			FileReader read = new FileReader(f);
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	
}
