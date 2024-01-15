/*
* Splash class for Bicycle Safety Game
* 2024-01-07
* Tsz Fei Wang
* ICS3UP
*/
import java.awt.*;
import hsa.*;
import java.io.*; 
import java.awt.image.*;
import javax.imageio.*;

public class Splash{
    /*
    * variable declaration
    * ------------------------------------------------------------------------------------
    * Type          | Name          | Description
    * Console       | c             | allows the console to be used to draw
    * ------------------------------------------------------------------------------------
    */
    Console c;    
    
    // constructor 
    public Splash (Console con) {
	c = con;
    }
    
    // draws the splash screen
    public void drawCycles() {
	try { 
	    // gets the images
	    Image stripes = ImageIO.read (new File("stripes.jpg"));
	    Image title = ImageIO.read (new File("title.jpg"));
	    Image cycles = ImageIO.read(new File("cycles.jpg")); 
	    Image newScreen = ImageIO.read(new File("continue.jpg"));
	    stripes = stripes.getScaledInstance(1024, 768, stripes.SCALE_DEFAULT);
	    title = title.getScaledInstance(605, 354, title.SCALE_DEFAULT);
	    cycles = cycles.getScaledInstance(1020, 200, cycles.SCALE_DEFAULT);
	    newScreen = newScreen.getScaledInstance(1024, 768, newScreen.SCALE_DEFAULT);
	    
	    // draws the stripes and the title
	    c.drawImage(stripes, 0, 0, null);
	    c.drawImage(title, 210, 40, null);
	    
	    // animated part
	    for(int i = 0; i < 160; i++) {
		c.drawImage(cycles, 1, 600-5*i, null);
		c.drawImage(title, 210, 40, null);
		try{Thread.sleep(50); } catch(Exception e) {} 
	    }
	    
	    // draws the next screen
	    c.drawImage(newScreen, 0, 0, null);
	}
	catch (FileNotFoundException fnf) {
	    new Message("File Not Found","error");
	}
	catch(IOException ioe) {
	    new Message("Error reading file", "error");
	}
	
	// pauses the program until the user presses a key
	c.getChar();
    }
    
    // runs drawCycles
    public void run() {
	drawCycles();
    }
}
