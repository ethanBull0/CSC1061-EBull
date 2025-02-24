import java.util.ArrayList;
import java.util.UUID;

public class IMEI { //instance
	
	/**
	 * 
	 * @return Generates a UUID, converts it to a String, then to an array of chars,
	 * where each char is converted from hex to a decimal int, then added to the ArrayList
	 * of chars as a char.
	 */
	public ArrayList<Character> genUUID() {
		ArrayList<Character> idArr = new ArrayList<Character>();
		UUID id = UUID.randomUUID();
		String idString = id.toString().replace("-", "");
		char[] ids = idString.toCharArray();
		for (char c : ids) {
			int thisInt = Character.getNumericValue(c);
			idArr.add((char) thisInt);
		}
		return idArr;
		
	}

}