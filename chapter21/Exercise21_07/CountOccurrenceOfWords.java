/* Author: Eden Demke
 * Date: 3/13/24
 * 
 * (Revise Listing 21.9) Rewrite Listing 21.9 with the map variable as a HashMap. 
 * The program should display the words in ascending order of occurrence counts.
 * 
 * (Hint: Create a class named WordOccurrence that implements the Comparable interface. 
 * The class contains two fields, word and count. The compareTo method compares the counts. 
 * For each pair in the hash set in Listing 21.9, create an instance of WordOccurrence 
 * and store it in an array list. Sort the array list using the Collections.sort method. 
 * What would be wrong if you stored the instances of WordOccurrence in a tree set?)
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class CountOccurrenceOfWords {
	public static void main(String[] args) {
		// Set text in a string
		String text = "Good morning. Have a good class. " +
			"Have a good visit. Have fun!";

		// Create a TreeMap to hold words as key and count as value
		Map<String, Integer> map = new HashMap();
		
		ArrayList<WordOccurrence> wordOccurList = new ArrayList<>();

		String[] words = text.split("[\\s+\\p{P}]");
		for (int i = 0; i < words.length; i++) {
			String key = words[i].toLowerCase();
			
			if (key.length() > 0) {
				wordOccurList.add(new WordOccurrence(key, 0));
				
				if (!map.containsKey(key)) {
					map.put(key, 1);
				}
				else {
					int value = map.get(key);
					value++;
					map.put(key, value);
				}
			}
		}
		
		for (int i = 0; i < wordOccurList.size(); i++) {
			wordOccurList.get(i).setCount(map.get(wordOccurList.get(i).getWord()));
		}
		
		Collections.sort(wordOccurList);
		
		System.out.println(wordOccurList);		
	}
}