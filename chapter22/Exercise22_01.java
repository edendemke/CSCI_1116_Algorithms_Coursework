import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

/* Author: Eden Demke
 * Date: 3/19/24
 * 
 * (Maximum consecutive increasingly ordered substring) 
 * Write a program that prompts the user to enter a string 
 * and displays the maximum consecutive increasingly ordered 
 * substring. Analyze the time complexity of your program.
 */
public class Exercise22_01 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter a string: ");
		String userString = input.next();
		
		System.out.print("Maximum consecutive substring is \"");
		List<Character> substring = findSubstring(userString);
		
		for(Character e: substring) {
			System.out.print(e);
		}
		
		System.out.print("\"");
	}
	
	public static List<Character> findSubstring(String userString) {
		char[] charArray = userString.toCharArray();
		List<Character> charArrayList = new ArrayList<>();
		int longestSubstring = 1;
		
		if(userString.length() <= 0) {
			System.out.println("Error: string must be longer than zero characters.");
		} else {
			int currentSubstring = 1;
			
			for(int i = 1; i < charArray.length; i++) {
				if(charArray[i] > charArray[i - 1]) { //if current character is higher in alphabet than previous character
					currentSubstring++;					
				} else {
					if(currentSubstring > longestSubstring) { //if this is the longest substring
						longestSubstring = currentSubstring;
						currentSubstring = 1;
						
						charArrayList.clear();
						
						for(int k = longestSubstring; k > 0; k--) {
							charArrayList.add(charArray[i - k]);
						}
					} else {
						currentSubstring = 1;
					}
				}
			}
		}
		
		return charArrayList;
	}
}
