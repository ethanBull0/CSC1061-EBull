import java.io.File;
import java.util.ArrayList;

public class TestSchoolRecords extends Database {

	public static void main(String[] args) {
		ArrayList<Person> people = new ArrayList<Person>();
		Person ethan = new Student("Ethan", "B.", "970-111-1111", "ethan@mail.com", Rank.SOPHOMORE);
		people.add(ethan);
		Person brooklyn = new Student("Brooklyn", "F.", "303-111-1111", "brooklyn@mail.com", Rank.SOPHOMORE);
		people.add(brooklyn);
		Person mrCool = new Faculty("John", "Cool", "123-456-7890", "justacoolguy@mail.com", "BP", 34864.23, "05/01/2020", "11:30AM-12:30PM BP125 Tues and Thur", Rank.SENIOR);
		people.add(mrCool);
		Person mrChad = new Faculty("Chad", "S.", "333-333-9870", "chad@mail.com", "AP", 34864.23, "05/01/2020", "11:30AM-12:30PM BP125 Tues and Thur", Rank.SENIOR);
		people.add(mrChad);
		Person bigGuy = new Staff("Big", "Guy", "570-865-2456", "biggie@mail.com", "LBP", 86543.35, "03/13/1999", "Chairman");
		people.add(bigGuy);
		Person smallFry = new Staff("Small", "Fry", "989-222-3456", "dunce@mail.com", "CP", 10, "02/24/2025", "Grunt");
		people.add(smallFry);
		
		for (Person p : people) {
			writePerson(p);
		}
		
		ArrayList<Person> peopleRead = readPerson(new File(getFilePath()));
		peopleRead.forEach(person -> System.out.println(person));
		//File peopleFile = new File("PersonDatabase.csv");
		//readPerson(peopleFile);
	}

}
