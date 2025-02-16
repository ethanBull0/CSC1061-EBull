import java.util.ArrayList;
import java.util.List;
import java.io.*;

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
	
	public static void writePerson(Person p) { //reads all persons and its subclasses, cannot write Object
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
			printer.print("," + ((Student)p).getStatus());
		} else if (p instanceof Employee) {
			printer.print("," + ((Employee)p).getDateHired()
					+ "," + ((Employee)p).getOffice()
					+ "," + ((Employee)p).getSalary()
					);
		} else if (p instanceof Faculty) {
			printer.print("," + ((Employee)p).getDateHired()
					+ "," + ((Employee)p).getOffice()
					+ "," + ((Employee)p).getSalary()
					+ "," + ((Faculty)p).getOfficeHours()
					);
		} else if (p instanceof Staff) {
			printer.print("," + ((Employee)p).getDateHired()
					+ "," + ((Employee)p).getOffice()
					+ "," + ((Employee)p).getSalary()
					+ "," + ((Staff)p).getTitle()
					);
		}
		
		
		printer.print("\n");
		printer.flush();
	}
	
	public static void readPerson(File f) {
		BufferedReader reader = null;
		List<Person> personList = new ArrayList<Person>();
		String line = "";
		try {
			reader = new BufferedReader(new FileReader(f));
			try {
				while ((line = reader.readLine()) != null) {
					String[] vals = line.split(",");
					String firstName = vals[1];
					String lastName = vals[2];
					String phoneNumber = vals[3];
					String email = vals[4];
					switch(vals[0]) {
					case "Student":
						break;
					case "Employee":
						break;
					case "Faculty":
						break;
					case "Staff":
						break;
					}
					
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
	}
	
}
