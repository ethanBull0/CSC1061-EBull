import java.util.Map;
import java.util.Set;

public class MyHashMapTest {
	
	public static void main(String[] args) {
	Map<String, Integer> map = new MyHashMap<>();
	
	map.put("1", 1);
	map.put("2", 2);
	map.put("3", 3);
	
	
	printMap(map);
	
	}
	public static void printMap(Map pmap) {
		Set<Map.Entry<String, Integer>> entries = pmap.entrySet();
		
		
		for (Map.Entry<String, Integer> entry : entries) {
			System.out.println("(" + entry.getKey() + ", " + entry.getValue() + ") ");
		}
		System.out.println();
		}
}
