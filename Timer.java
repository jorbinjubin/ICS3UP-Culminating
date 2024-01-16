/*
* Sets 5 minute timer for user to finish the game  
* 2024-01-14
* Justin Jiang and Tsz Fei Wang
* ICS3UP
*/
import hsa.Console;
import java.awt.*;
public class Timer extends Thread {
    /*
    * Variable Declaration
    * -------------------------------------------------------------------------------------------
    * Type             | Name          | Description
    * private boolean  | timeUp        | whether the time is up or not (initially set to false)
    * private Console  | c             | allows console to be used
    * int              | time          | current time (initially set to 300 seconds)
    * -------------------------------------------------------------------------------------------
    */
    private boolean timeUp = false;
    int time = 300; 
    private Console c;
    
    //returns whether or not the time has run out 
    //made by Justin 
    public boolean timeOver() {
	return timeUp;
    }
    
    //displays the timer when called 
    //made by: Fei 
    public void timer() {
	// if there is time left 
	if(time > 0) {
	    // timer background
	    Color pink = new Color(255, 180, 222);
	    c.setColor(pink);
	    c.fillRect(10, 15, 200, 35); 
	    
	    // displays time remaining
	    c.setFont(new Font("Arial", 0, 18));
	    c.setColor(Color.black);
	    c.drawString("Time remaining:        s", 20, 40);
	    String temp = time + "";
	    c.drawString(temp, 155, 40);
	} 
	else timeUp = true; // otherwise no time left
    }
    
    //constructor
    //made by: justin
    public Timer(Console con) {
	c = con;
    }
}
