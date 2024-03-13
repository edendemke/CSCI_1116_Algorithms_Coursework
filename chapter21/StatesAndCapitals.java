/* Author: Eden Demke
 * Date: 3/13/24
 * 
 * (Guess the capitals using maps) Rewrite Programming Exercise 8.37 
 * to store pairs of each state and its capital in a map. Your program 
 * should prompt the user to enter a state and should display the 
 * capital for the state.
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class StatesAndCapitals {
  public static void main(String[] args) {
    String[][] stateCapital = {
      {"Alabama", "Montgomery"},
      {"Alaska", "Juneau"},
      {"Arizona", "Phoenix"},
      {"Arkansas", "Little Rock"},
      {"California", "Sacramento"},
      {"Colorado", "Denver"},
      {"Connecticut", "Hartford"},
      {"Delaware", "Dover"},
      {"Florida", "Tallahassee"},
      {"Georgia", "Atlanta"},
      {"Hawaii", "Honolulu"},
      {"Idaho", "Boise"},
      {"Illinois", "Springfield"},
      {"Indiana", "Indianapolis"},
      {"Iowa", "Des Moines"},
      {"Kansas", "Topeka"},
      {"Kentucky", "Frankfort"},
      {"Louisiana", "Baton Rouge"},
      {"Maine", "Augusta"},
      {"Maryland", "Annapolis"},
      {"Massachusettes", "Boston"},
      {"Michigan", "Lansing"},
      {"Minnesota", "Saint Paul"},
      {"Mississippi", "Jackson"},
      {"Missouri", "Jefferson City"},
      {"Montana", "Helena"},
      {"Nebraska", "Lincoln"},
      {"Nevada", "Carson City"},
      {"New Hampshire", "Concord"},
      {"New Jersey", "Trenton"},
      {"New York", "Albany"},
      {"New Mexico", "Santa Fe"},
      {"North Carolina", "Raleigh"},
      {"North Dakota", "Bismarck"},
      {"Ohio", "Columbus"},
      {"Oklahoma", "Oklahoma City"},
      {"Oregon", "Salem"},
      {"Pennsylvania", "Harrisburg"},
      {"Rhode Island", "Providence"},
      {"South Carolina", "Columbia"},
      {"South Dakota", "Pierre"},
      {"Tennessee", "Nashville"},
      {"Texas", "Austin"},
      {"Utah", "Salt Lake City"},
      {"Vermont", "Montpelier"},
      {"Virginia", "Richmond"},
      {"Washington", "Olympia"},
      {"West Virginia", "Charleston"},
      {"Wisconsin", "Madison"},
      {"Wyoming", "Cheyenne"}
    };

    Scanner input = new Scanner(System.in);
    
    Map<String, String> stateCapitalMap = new HashMap<>();

    for (int i = 0; i < stateCapital.length; i++) {
      stateCapitalMap.put(stateCapital[i][0].toLowerCase(), stateCapital[i][1]);
    }

    System.out.println("Enter name of State: ");
    String state = input.nextLine().trim().toLowerCase();
    
    if(stateCapitalMap.keySet().contains(state)) {
    	System.out.println("The capital is: " + stateCapitalMap.get(state));
    } else {
    	System.out.println(state + " is not in list. Check spelling.");
    }
  }
}