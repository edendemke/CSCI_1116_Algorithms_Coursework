/* Author: Eden Demke
 * Date: 3/14/24
 * 
 * (Baby name popularity ranking) Write a program that enables the user to 
 * select a year, gender, and enter a name to display the ranking of the 
 * name for the selected year and gender. Assume the data files are stored 
 * at http://liveexample.pearsoncmg.com/data/babynamesranking2001.txt, and 
 * http://liveexample.pearsoncmg.com/data/babynamesranking2010.txt. To 
 * achieve the best efficiency, create two arrays for boy’s names and girl’s 
 * names, respectively. Each array has 10 elements for 10 years. Each element 
 * is a map that stores a name and its ranking in a pair with the name as the key.
 */

package application;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Exercise21_11 extends Application {
  private static Map<String, Integer>[] mapForBoy = new HashMap[10];
  private static Map<String, Integer>[] mapForGirl = new HashMap[10];
  
  private static String urlString2001 = "https://liveexample.pearsoncmg.com/data/babynamesranking2001.txt";
  private static String urlString2002 = "https://liveexample.pearsoncmg.com/data/babynamesranking2002.txt";
  private static String urlString2003 = "https://liveexample.pearsoncmg.com/data/babynamesranking2003.txt";
  private static String urlString2004 = "https://liveexample.pearsoncmg.com/data/babynamesranking2004.txt";
  private static String urlString2005 = "https://liveexample.pearsoncmg.com/data/babynamesranking2005.txt";
  private static String urlString2006 = "https://liveexample.pearsoncmg.com/data/babynamesranking2006.txt";
  private static String urlString2007 = "https://liveexample.pearsoncmg.com/data/babynamesranking2007.txt";
  private static String urlString2008 = "https://liveexample.pearsoncmg.com/data/babynamesranking2008.txt";
  private static String urlString2009 = "https://liveexample.pearsoncmg.com/data/babynamesranking2009.txt";
  private static String urlString2010 = "https://liveexample.pearsoncmg.com/data/babynamesranking2010.txt";
  
  private Button btFindRanking = new Button("Find Ranking");
  private ComboBox<Integer> cboYear = new ComboBox<>();
  private ComboBox<String> cboGender = new ComboBox<>();
  private TextField tfName = new TextField();
  private Label lblResult = new Label();
  
  @Override // Override the start method in the Application class
  public void start(Stage primaryStage) {
    GridPane gridPane = new GridPane();
    gridPane.add(new Label("Select a year:"), 0, 0);
    gridPane.add(new Label("Boy or girl?"), 0, 1);
    gridPane.add(new Label("Enter a name:"), 0, 2);
    gridPane.add(cboYear, 1, 0);
    gridPane.add(cboGender, 1, 1);
    gridPane.add(tfName, 1, 2);
    gridPane.add(btFindRanking, 1, 3);
    gridPane.setAlignment(Pos.CENTER);
    gridPane.setHgap(5);
    gridPane.setVgap(5);
    
    btFindRanking.setOnAction(e -> {
    	String name = tfName.getText().toLowerCase();
    	String gender = "";
    	int rank = 0;
    	int year = cboYear.getValue();
    	
    	fillMapArray();
    	
    	if (cboGender.getValue().equals("Male")) {
    		gender = "Boy";
    		rank = mapForBoy[(year - 2001)].get(name);
    	} else {
    		gender = "Girl";
    		rank = mapForGirl[(year - 2001)].get(name);
    	}

    	lblResult.setText(gender + " name " + name + " is ranked #" + rank + " in year " + year);
    });
  
    BorderPane borderPane = new BorderPane();
    borderPane.setCenter(gridPane);
    borderPane.setBottom(lblResult);
    BorderPane.setAlignment(lblResult, Pos.CENTER);

    // Create a scene and place it in the stage
    Scene scene = new Scene(borderPane, 370, 160);
    primaryStage.setTitle("Exercise21_11"); // Set the stage title
    primaryStage.setScene(scene); // Place the scene in the stage
    primaryStage.show(); // Display the stage

    for (int year = 2001; year <= 2010; year++) {
      cboYear.getItems().add(year);
    }
    cboYear.setValue(2001);
        
    cboGender.getItems().addAll("Male", "Female");
    cboGender.setValue("Male");
    
  }
  
  public static void fillMapArray() {
	  try {
		  URL[] urlArray = new URL[] {
				  new URL(urlString2001),
				  new URL(urlString2002),
				  new URL(urlString2003),
				  new URL(urlString2004),
				  new URL(urlString2005),
				  new URL(urlString2006),
				  new URL(urlString2007),
				  new URL(urlString2008),
				  new URL(urlString2009),
				  new URL(urlString2010),
		  };
		  
		  for (int i = 0; i < urlArray.length; i++) {
			  Scanner input = new Scanner(urlArray[i].openStream());
			  mapForBoy[i] = new HashMap<>();
			  mapForGirl[i] = new HashMap<>();
			  
			  while (input.hasNext()) {
				  //process text from URL
				  int rank = 0;
				  int random = 0;
				  String boyName = "";
				  String girlName = "";
				  
				  rank = input.nextInt();
				  boyName = input.next().toLowerCase();
				  random = input.nextInt();
				  girlName = input.next().toLowerCase();
				  random = input.nextInt();

				  mapForBoy[i].put(boyName, rank);
				  mapForGirl[i].put(girlName, rank);
			  }
		  }
	  } catch (MalformedURLException ex) {
		  ex.printStackTrace();
	  } catch (IOException ex) {
		  ex.printStackTrace();
	  }  
  }

  /**
   * The main method is only needed for the IDE with limited
   * JavaFX support. Not needed for running from the command line.
   */
  public static void main(String[] args) {
    launch(args);
  }
}
