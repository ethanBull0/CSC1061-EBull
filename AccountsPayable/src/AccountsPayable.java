import java.util.InputMismatchException;
import java.util.Scanner;

public class AccountsPayable {
	public static void main(String args[]) {
		Employee payableEmployees[] = new Employee[6];
		Scanner scn = new Scanner(System.in);
		System.out.println("I will prompt you to enter data for six employees.");
		for (int i = 0; i < payableEmployees.length; i++) {
			System.out.println(
					"What type of employee is this?\n1.Hourly Employee\n2.Salaried Employee\n3. Comission Employee\n4. Base Plus Comission Employee");
			int choice = scn.nextInt();
			switch (choice) {
			case 1:
				payableEmployees[i] = new HourlyEmployee();
				break;
			case 2:
				payableEmployees[i] = new SalariedEmployee();
				break;
			case 3:
				payableEmployees[i] = new ComissionEmployee();
				break;
			case 4:
				payableEmployees[i] = new BasePlusComissionEmployee();
				break;
			}
			String flush = scn.nextLine();
			System.out.println("Employee " + i + "'s first name");
			payableEmployees[i].setFirstName(scn.nextLine());
			System.out.println("Employee " + i + "'s last name");
			payableEmployees[i].setLastName(scn.nextLine());
			System.out.println("Employee " + i + "'s SSN, enter digit by digit (press Enter between digit.");
			boolean validInput = false;
			int[] SSN = new int[9];
			int j = 0;
			while (!validInput) {
			try {
				for (; j < SSN.length; j++) { 
					int currentNum = scn.nextInt();
					if (currentNum > 9) {
						throw new InputMismatchException();
					}
					SSN[j] = currentNum;
				}
				j = 0;
				validInput = true;
			} catch (InputMismatchException e) {
				System.out.println("Failed to read digit. Please re-enter your given value.");
				scn.nextLine();

			}
			}
			payableEmployees[i].setSSN(SSN);
			System.out.print("Recorded SSN ");
			for (int k : SSN) {
				System.out.print(k);
			}
			System.out.println();
			try {
				switch (choice) {
				case 1:
					System.out.println("Enter Employee " + i + "'s Hourly Wage");
					double hourlyWage = scn.nextDouble();
					((HourlyEmployee) payableEmployees[i]).setHourlyWage(hourlyWage);
					System.out.println("Enter Employee " + i + "'s Hours per Week");
					double hoursPerWeek = scn.nextDouble();
					((HourlyEmployee) payableEmployees[i]).setHours(hoursPerWeek);
					break;
				case 2:
					System.out.println("Enter Employee " + i + "'s Weekly Salary");
					((SalariedEmployee) payableEmployees[i]).setWeeklySalary(scn.nextDouble());
					break;
				case 3:
					System.out.println("Enter Employee " + i + "'s Gross Sales");
					((ComissionEmployee) payableEmployees[i]).setGrossSales(scn.nextInt());
					System.out.println("Enter Employee " + i + "'s Comission Rate (as a percentage)");
					((ComissionEmployee) payableEmployees[i]).setCommissionRate(scn.nextInt());
					break;
				case 4:
					System.out.println("Enter Employee " + i + "'s base pay");
					((BasePlusComissionEmployee) payableEmployees[i]).setBasePay(scn.nextInt());
					System.out.println("Enter Employee " + i + "'s Gross Sales");
					((BasePlusComissionEmployee) payableEmployees[i]).setGrossSales(scn.nextInt());
					System.out.println("Enter Employee " + i + "'s Comission Rate (as a percentage)");
					((BasePlusComissionEmployee) payableEmployees[i]).setCommissionRate(scn.nextInt());
				}
			} catch (NullPointerException e) {
				System.out.println("Unable to fetch given data field for employee " + i);
			}
		}
		for (int i = 0; i < payableEmployees.length; i++) { // 16
			printEmployee(payableEmployees[i]);
		}
		for (int i = 0; i < payableEmployees.length; i++) {
			if (payableEmployees[i] instanceof BasePlusComissionEmployee) {
				((BasePlusComissionEmployee) payableEmployees[i])
						.setBasePay(payableEmployees[i].getPaymentAmount() * 1.10);
			}
		}
		for (int i = 0; i < payableEmployees.length; i++) {
			System.out.println("Employee's First Name: " + payableEmployees[i].getFirstName() + "Payout: "
					+ payableEmployees[i].getPaymentAmount());
		}
	}

	public static void sysoutEmployee(Employee emp) {
		System.out.println(emp.toString());
	}

	public static void printEmployee(Employee emp) {
		System.out.println("Employee " + emp.getFirstName() + " " + emp.getLastName());
		System.out.println("SSN: " + emp.sSNToString());
		System.out.println("Employee's payment amount: " + emp.getPaymentAmount());
	}
}
