import java.util.Arrays;

public class FinancialInstitutionTest {

	public static void main(String[] args) {
		FinancialInstitution[] fiInsts = new FinancialInstitution[3];
		
		fiInsts[0] = new Bank("Capital One", 1, 10200076, null, 29.9);
		fiInsts[1] = new Bank("Capital One", 1, 10200076, null, 29.9);
		fiInsts[2] = new Bank("Capital One", 1, 10200076, null, 29.9);
		
		for (FinancialInstitution fi : fiInsts) {
			System.out.println(fi);
		}
		
		Arrays.sort(fiInsts);
	}
}
