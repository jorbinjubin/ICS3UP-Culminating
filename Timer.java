/*
* Sets 5 minute timer for user to finish the game  
* 2024-01-14
* Justin Jiang and Tsz Fei Wang
* ICS3UP
*/
import hsa.Console;
import java.awt.*;
public class Timer extends Thread {
    private boolean timeUp = false;
    int time = 300; 
    private Console c;
    
    //returns whether or not the time has run out 
    //made byL Justin 
    public boolean timeOver() {
	return timeUp;
    }
    
    //displays the timer when called 
    //made by: Fei 
    public void timer() {
	Game g = new Game(c); 
	if(time > 0) {
	    c.setFont(new Font("Arial", 0, 18));
	    Color pink = new Color(255, 180, 222);
	    c.setColor(pink);
	    c.fillRect(10, 15, 200, 35); 
	    
	    c.setColor(Color.black);
	    c.drawString("Time remaining:        s", 20, 40);
	    String temp = time + "";
	    c.drawString(temp, 155, 40);
	} 
	else timeUp = true; 
    }
    
    //constructor
    //made by: justin
    public Timer(Console con) {
	c = con;
    }
}
