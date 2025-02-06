import java.util.Scanner;
public class AccountsPayable {
	public static void main(String args[]) {
		Employee payableEmployees[] = new Employee[6];
		Scanner scn = new Scanner(System.in);
		System.out.println("I will prompt you to enter data for six employees.");
		for (int i = 0; i < payableEmployees.length; i++) {
			System.out.println("What type of employee is this?\n1.Hourly Employee\n2.Salaried Employee\n3. Comission Employee\n4. Base Plus Comission Employee");
			int choice = scn.nextInt();
			switch(choice) {
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
			System.out.println("Employee " + i + "'s first name");
			payableEmployees[i].setFirstName(scn.nextLine());
			System.out.println("Employee " + i +"'s last name");
			payableEmployees[i].setLastName(scn.nextLine());
			System.out.println("Employee " + i +"'s SSN");
			payableEmployees[i].setSSN(scn.nextInt());
			
			try {
			switch (choice) {
			case 1:
				System.out.println("Enter Employee " + i + "'s Hourly Wage");
				double hourlyWage = scn.nextDouble();
				((HourlyEmployee) payableEmployees[i]).setHourlyWage(scn.nextDouble());
				System.out.println("Enter Employee " + i + "'s Hours per Week");
				((HourlyEmployee) payableEmployees[i]).setHours(scn.nextInt());
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
		for (int i = 0; i < payableEmployees.length; i++) { //16
			printEmployee(payableEmployees[i]);
		}
		for (int i = 0; i < payableEmployees.length; i++) {
			if (payableEmployees[i] instanceof BasePlusComissionEmployee) {
				((BasePlusComissionEmployee) payableEmployees[i]).setBasePay(payableEmployees[i].getPaymentAmount() * 1.10);
			}
		}
	}
	
	public static void sysoutEmployee(Employee emp) {
		System.out.println(emp.toString());
	}
	public static void printEmployee(Employee emp) {
		System.out.println("Employee " + emp.getFirstName() + " " + emp.getLastName());
		System.out.println("SSN: " + emp.getSSN());
		System.out.println("Employee's payment amount: " + emp.getPaymentAmount());
	}
}
