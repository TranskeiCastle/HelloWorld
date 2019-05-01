package collection;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class CountOccurrenceOfWords {
	public static void main(String[] args) {
		// Set text in a String
		String text = "Good morning. Have a good class. " + "Have a good visit. Have fun!";

		// Create a TreeMap to hold words as key and count as value
		TreeMap<String, Integer> map = new TreeMap<>();
		// Get all of words
		String[] words = text.split("[ \n\t\r.,;:!?(){]");
		for (int i = 0; i < words.length; i++) {
			String key = words[i].toLowerCase();
			if (key.length() > 0) {
				if (map.get(key) == null) {
					map.put(key, 1);
				} else {
					int value = map.get(key).intValue();
					value++;
					map.put(key, value);
				}
			}
		}
		// Get all entries into a set
		Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
		// Get key and value from each entry
		for (Map.Entry<String, Integer> entry : entrySet) {
			System.out.println(entry.getKey() + "\t" + entry.getValue());
		}
		// [a, class, fun, good, have, morning, visit]
		System.out.println(map.keySet());
		// [2, 1, 1, 3, 3, 1, 1]
		System.out.println(map.values());
	}
}
