import java.util.Scanner;
public class AccountsPayable {
	public static void main(String args[]) {
		Employee payableEmployees[] = new Employee[6];
		Scanner scn = new Scanner(System.in);
		System.out.println("I will prompt you to enter data for six employees.");
		for (int i = 0; i < payableEmployees.length; i++) {
			System.out.println("Employee " + i + "'s first name");
			payableEmployees[i].setFirstName(scn.nextLine());
			System.out.println("Employee " + i +"'s last name");
			payableEmployees[i].setLastName(scn.nextLine());
			System.out.println("Employee " + i +"'s SSN");
			payableEmployees[i].setSSN(scn.nextInt());
			System.out.println("What type of employee is this?\n1.Hourly Employee\n2.Salaried Employee\n3. Comission Employee\n4. Base Plus Comission Employee");
			int choice = scn.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Enter Employee " + i + "'s Hourly Wage");
			}
		}
	}
}
