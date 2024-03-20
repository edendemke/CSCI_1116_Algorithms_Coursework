/* Author: Eden Demke
 * Date: 3/20/2024
 * 
 * (Pattern matching ) Write a program that prompts the user 
 * to enter two strings and tests whether the second string 
 * is a substring of the first string. Suppose the neighboring 
 * characters in the string are distinct.  (Don’t use the 
 * indexOf method in the String class.) Analyze the time 
 * complexity of your algorithm. Your algorithm needs to be 
 * at least O(n) time.
 */
import java.util.Scanner;

public class Exercise22_03 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter first string: ");
		String firstString = input.nextLine();
		
		System.out.print("Enter second string: ");
		String potentialSubstring = input.nextLine();

		int lengthOfSubstring = potentialSubstring.length();
		int substringIndexCount = 0;
				
		for (int i = 0; i < firstString.length() && substringIndexCount < lengthOfSubstring; i++) {
			if (firstString.charAt(i) == potentialSubstring.charAt(substringIndexCount)) {
				substringIndexCount++;
				System.out.println(substringIndexCount);
			} else {
				continue;
			}						
		}
		
		if (substringIndexCount == lengthOfSubstring) {
			System.out.println("String 2 is a substring of String 1!!");
		} else {
			System.out.println("no match");
		}
	}
}