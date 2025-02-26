import java.util.ArrayList;
import java.util.UUID;

public class IMEI { //instance
	private ArrayList<Character> idArr = new ArrayList<Character>();
	/**
	 * 
	 * {@summary} Generates a UUID, converts it to a String, then to an array of chars,
	 * where each char is converted from hex to a decimal int, then added to the ArrayList
	 * of chars as a char.
	 */
	public void genUUID() {
		UUID id = UUID.randomUUID();
		String idString = id.toString().replace("-", "");
		char[] ids = idString.toCharArray();
		for (char c : ids) {
			int thisInt = Character.getNumericValue(c);
			idArr.add((char) thisInt);
		}
		System.out.print("generated UUID: ");
		printIMEI(idArr);
		
	}
	
	/**
	 * 
	 * {@summary} Prints the IMEI using sysout, unless it does not exist in which it prints a usage message for genUUID.
	 */
	public void printIMEI(ArrayList<Character> chars) {
		if (idArr.equals(null)) {
			System.out.println("Generate an IMEI by using _____.genUUID()");
		} else {
			for(Character c : chars) {
				System.out.println(c);
			}
		}
	}
	
	public ArrayList<Character> getIMEI() {
		return idArr;
	}
	
	@Override
	public String toString() {
		String str = "";
		for (Character c : idArr) {
			str += c;
		}
		return str;
	}
	

}