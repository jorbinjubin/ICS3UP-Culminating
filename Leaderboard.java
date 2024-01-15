/*
* Leaderboard class for Bicycle Safety Game
* 2024-01-11
* Tsz Fei Wang
* ICS3UP
*/
import java.awt.*;
import hsa.*;
import java.io.*; 
import java.awt.image.*;
import javax.imageio.*;

public class Leaderboard {
    /*
    * ------------------------------------------------------------------------------------
    * Type             | Name          | Description
    * int[]            | scores        | stores top 10 scores 
    * String[]         | saveScore     | stores the username corresponding to each of the top 10 scores
    * String           | user          | stores individual user name
    * int              | corect        | stores the number of questions a user got correct
    * int              | time          | stores amount of time in ms a users run took
    * Console          | c             | console
    * ------------------------------------------------------------------------------------
    */
    Console c;   
    int[] scores = new int[10]; 
    String[] names = new String[10]; 
    String user; int correct; int time; 
    
    //constructor
    public Leaderboard (Console con) {
	c = con;
    }
    
    //creates an object of the Game class to access variables from that class
    //by calling getter methods from Game, and then saving those values to variables here
    public void getInfo() {
	Game g = new Game(c); 
	user = g.getUsername();
	correct =  g.getNumCorrect();
	time = g.getTime();
    }
    
    //reads information on the current highschores board from the file highscores.txt, and compares the scores to the
    //score of the user who just saved theirs. If the current user has a place on the scoreboard, updates highscores.txt file
    //with the new information. 
    /*
    * ------------------------------------------------------------------------------------
    * Type             | Name          | Description
    * String           | line          | retrieves line from file and stores line thats going to be printed to file
    * String           | temp          | temporary storage for the integer portion of line, to convert to integer
    * PrintWriter      | pw            | writes to highscores.txt file
    * BufferedReader   | br            | reads from highscores.txt file
    * int              | score         | stores the users score
    * ------------------------------------------------------------------------------------
    */
    public void calculateLeaderboard() {
	try {
	    BufferedReader br = new BufferedReader (new FileReader("highscores.txt")); 
	    String line; 
	    String temp;
	    int score = 1000*correct - (time - 300)/10;
	    getInfo(); 
	    
	    for(int i = 0; i < 10; i++) {
		line = br.readLine(); 
		//if there hasnt been 10 play throughs yet and some positions have no score
		if(line.equals(null)) {
		    line = "unknown,0000"; 
		}
		
		names[i] = line.substring(0, line.indexOf(",")); 
		temp = line.substring(line.indexOf(",")+1);
		scores[i] = Integer.parseInt(temp); 
	    }
	    
	    br.close(); 
	    
	    //searches through the scores array to find where the user would place
	    //if the user makes top 10, shifts everyone below them down 1 and puts them in their respective place
	    for(int i = 0; i < 10; i++) {
		if(score > scores[i]) {
		    for(int j = 9; j > i; j--) {
			scores[j] = scores[j-1];
			names[j] = names[j-1];
		    }
		    scores[i] = score; 
		    names[i] = user;
		    break; 
		}
	    }
	    
	    //writes the new top 10 to highscores.txt
	    PrintWriter pw = new PrintWriter(new FileWriter("highscores.txt")); 
	    for(int i = 0; i < 10; i++) {
		if(scores[i] == 0) line = names[i] + ",----"; 
		else line = names[i] + "," + scores[i];
		pw.println(line);
	    }
	    pw.close();
	}
	catch (FileNotFoundException e) {
	    new Message("File Not Found", "Error!"); 
	}
	catch (IOException ioe) {
	    new Message("File Error", "Error!");
	}
	catch (Exception e) {
	    new Message("Unknown error", "Error!");
	}
    }
    
    //draws the leaderboard for the user to see 
    /*
    * ------------------------------------------------------------------------------------
    * Type             | Name          | Description
    * BufferedReader   | br            | reads from highscores.txt
    * Image            | leaderboard   | image of background of the leaderboard
    * String[][]       | scores        | stores usernames and the score corresponding to that username
    * String[]         | temp          | temporarily stores the name and score of 1 user at a time 
    * ------------------------------------------------------------------------------------
    */
    public void drawLB() {
	try {
	    BufferedReader br = new BufferedReader(new FileReader("highscores.txt"));
	    Image leaderboard = ImageIO.read(new File("leaderboard.jpg")); 
	    String[][] scores = new String[2][10];
	    String[] temp = new String[2];
	    int digits; 
	    
	    c.setFont(new Font("Arial", 1, 32)); 
	    c.setColor(Color.black);
	    c.drawImage(leaderboard, 0, 0, null); 
	    
	    for(int i = 0; i < 10; i++) {   
		temp = br.readLine().split(",");
		scores[0][i] = temp[0];
		scores[1][i] = temp[1];
		digits = temp[1].length();
		while(digits < 4) { temp[1] = "0" + temp[1]; digits++; }  
		if(i==9) c.drawString((i+1)+". ", 215, 240+46*i); 
		else c.drawString((i+1)+". ", 230, 240+46*i); 
		c.drawString(temp[0], 270, 240+46*i); 
		c.drawString(temp[1], 700, 240+46*i); 
	    }
	    
	    br.close();
	}
	catch(FileNotFoundException fnf) {
	    new Message("File Not Found", "Error!");
	}
	catch(IOException ioe) {
	    new Message("File Error");
	}
    }
}
