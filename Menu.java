/* 
* Menu class for Bicycle Safety Game
* 2024-01-12
* Justin Jiang
* ICS3UP
* This class draws the main menu for our program
*/

import hsa.Console; // or import hsa.*;
import hsa.Message;
import java.awt.*;
import sun.audio.*;
import java.io.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class Menu {
    /*
    * ------------------------------------------------------------------------------------
    * Type             | Name          | Description
    * AudioStream      | as            | allows audio to be played
    * int              | choice        | the user's menu choice
    * private Console  | c             | allows the console to be used
    * boolean          | hasChosen1    | boolean variable to check whether they chose something in menu 1
    * boolean          | hasChosen2    | boolean variable to check whether they chose something in menu 2
    * ------------------------------------------------------------------------------------
    */
    AudioStream as;
    int choice = 0;
    private Console c;
    boolean hasChosen1 = false;
    boolean hasChosen2 = false;
    public Menu(Console con) {
	c = con;
    }
    
    // getter method to access int choice
    public int getChoice() {
	return choice;
    }
    
    // getter method to access boolean hasChosen1 
    public boolean getHasChosen1() {
	return hasChosen1;
    }
    
    // setter method to set boolean hasChosen1 to b
    public void setHasChosen1(boolean b) {
	hasChosen1 = b;
    }
    
    // getter method to access boolean hasChosen1 
    public boolean getHasChosen2() {
	return hasChosen2;
    }
    
    // adds a delay of 220 milliseconds
    public void delay() {
	try {
	    Thread.sleep(220);
	} catch (Exception e) {}
    }
    
    // draws an outline using drawRect
    private void drawOutline(int n) {
	c.setColor(new Color(150, 150, 150));
	for(int i = 0; i < 10; i++) {
	    c.drawRect(0+i, 149+152*n+i, 1024-2*i, 160-2*i);
	}
    }
    
    // method to select which choice in the menu
    public void menuSelect() {
    
	// while the user has not selected anything yet
	while (!hasChosen1) {
	    if (c.isCharAvail()) {
		switch (c.getChar()) {
		case 'j':
		case 's':
		    if (choice < 3) {
			choice++;
			try {
			    as = new AudioStream(new FileInputStream("button.wav"));
			} catch (Exception e) {}
			//AudioPlayer.player.start(as);
		    }
		    break;
		case 'k':
		case 'w':
		    if(choice > 0) {
			choice--;
			try {
			    as = new AudioStream(new FileInputStream("button.wav"));
			} catch (Exception e) {}
			//AudioPlayer.player.start(as);
		    }
		    break;
		case '\n':
		    hasChosen1 = true;
		    break;
		default:
		    break;
		}
	    }
	    
	    // draws the background of the menu
	    try {
		BufferedImage menu_bg = ImageIO.read(new File("menu.jpg"));
		c.drawImage(menu_bg, 0, 0, null);
	    } catch (FileNotFoundException fnf) {
		new Message("File Not Found", "Error");
	    } catch (IOException ioe) {
		new Message("Error reading file", "Error");
	    }
	    
	    // draws a border
	    drawOutline(choice);
	}
    }
    
    // method to select which choice in the second menu
    public void menu2Select() {
	hasChosen2 = false;
	
	// while the user has not selected anything yet
	while (!hasChosen2) {
	    if (c.isCharAvail()) {
		switch (c.getChar()) {
		case 'j':
		case 's':
		    if (choice < 3) {
			choice++;
			try {
			    as = new AudioStream(new FileInputStream("button.wav"));
			} catch (Exception e) {}
			//AudioPlayer.player.start(as);
		    }
		    break;
		case 'k':
		case 'w':
		    if(choice > 0) {
			choice--;
			try {
			    as = new AudioStream(new FileInputStream("button.wav"));
			} catch (Exception e) {}
			//AudioPlayer.player.start(as);
		    }
		    break;
		case '\n':
		    hasChosen2 = true;
		    break;
		default:
		    break;
		}
	    }
	    
	    // draws the background of the menu
	    try {
		BufferedImage menu2 = ImageIO.read(new File("menu2.jpg"));
		c.drawImage(menu2, 0, 0, null);
	    } catch (FileNotFoundException fnf) {
		new Message("File Not Found", "Error");
	    } catch (IOException ioe) {
		new Message("Error reading file", "Error");
	    }
	    
	    // draws a border
	    drawOutline(choice);
	}
    }
   
}
