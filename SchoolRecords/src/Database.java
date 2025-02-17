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
	
	public static String getFilePath() {
		return filePath;
	}

	public static void setFilePath(String filePath) {
		Database.filePath = filePath;
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
		if (p instanceof Staff) {
	        printer.print("," + ((Staff) p).getDateHired()
	                + "," + ((Staff) p).getOffice()
	                + "," + ((Staff) p).getSalary()
	                + "," + ((Staff) p).getTitle()
	        );
	    } else if (p instanceof Faculty) {
	        printer.print("," + ((Faculty) p).getDateHired()
	                + "," + ((Faculty) p).getOffice()
	                + "," + ((Faculty) p).getSalary()
	                + "," + ((Faculty) p).getOfficeHours()
	                + "," + ((Faculty) p).getStatus()
	        );
	    } else if (p instanceof Employee) {
	        printer.print("," + ((Employee) p).getDateHired()
	                + "," + ((Employee) p).getOffice()
	                + "," + ((Employee) p).getSalary()
	        );
	    } else if (p instanceof Student) {
	        printer.print("," + ((Student) p).getStatus());
	    }
		printer.print("\n");
		printer.flush();
	}
	
	public static ArrayList<Person> readPerson(File f) {
		BufferedReader reader = null;
		ArrayList<Person> personList = new ArrayList<Person>();
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
						Rank stuRank = Rank.valueOf(vals[5]);
						Person stuPerson = new Student(firstName, lastName, phoneNumber, email, stuRank);
						personList.add(stuPerson);
						break;
					case "Employee":
						String empDateHired = vals[5];
						String empOffice = vals[6];
						double empSalary = Double.parseDouble(vals[7]);
						Person empPerson = new Employee(firstName, lastName, phoneNumber, email, empOffice, empSalary, empDateHired);
						personList.add(empPerson);
						break;
					case "Faculty":
						String facDateHired = vals[5];
						String facOffice = vals[6];
						double facSalary = Double.parseDouble(vals[7]);
						String facOfficeHours = vals[8];
						Rank facRank = Rank.valueOf(vals[9]); //impl. parseRank
						Person facPerson = new Faculty(firstName, lastName, phoneNumber, email, facOffice, facSalary, facDateHired, facOfficeHours, facRank);
						personList.add(facPerson);
						break;
					case "Staff":
						String staDateHired = vals[5];
						String staOffice = vals[6];
						double staSalary = Double.parseDouble(vals[7]);
						String staTitle = vals[8];
						Person staPerson = new Staff(firstName, lastName, phoneNumber, email, staOffice, staSalary, staDateHired, staTitle);
						personList.add(staPerson);
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
		return personList;
	}
	
}
