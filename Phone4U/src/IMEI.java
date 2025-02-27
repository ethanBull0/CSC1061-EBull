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
		for (int i = 0; i < ids.length; i++) {
			int thisInt = Character.getNumericValue(ids[i]);
			if (thisInt > 9) {
				idArr.add(Character.forDigit(thisInt / 10, 10));
				idArr.add(Character.forDigit(thisInt % 10, 10));
				i++;
			} else {
				idArr.add(Character.forDigit(thisInt, 10));
			}
			
		}
		
	}
	
	/**
	 * 
	 * {@summary} Prints the IMEI using sysout, unless it does not exist in which it prints a usage message for genUUID.
	 */
	public void printIMEI() {
			for (Character c : idArr) {
				System.out.print(c);
			}
			System.out.println("\n");
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