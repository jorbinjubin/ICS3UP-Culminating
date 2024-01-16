/*
* Instructions class for Bicycle Safety Game
* 2024-01-09
* Tsz Fei Wang
* ICS3UP
*/ 
import java.awt.*;
import hsa.*;
import java.io.*; 
import java.awt.image.*;
import javax.imageio.*;
import java.awt.image.BufferedImage;

public class Instructions {
    /*
    * ------------------------------------------------------------------------------------
    * Type             | Name          | Description
    * Console          | c             | console
    * ------------------------------------------------------------------------------------
    */
    Console c; 
    
    //Constructor
    public Instructions (Console con) {
	c = con;
    }
    
    //displays first page of instructions on how to give input and lets user test their input
    /*
    * ------------------------------------------------------------------------------------
    * Type             | Name          | Description
    * Image            | WASD          | base image of W A S D keys
    * Image            | W             | stores image of the W A S D keys with the W key pressed
    * Image            | A             | stores image of the W A S D keys with the A key pressed
    * Image            | S             | stores image of the W A S D keys with the S key pressed
    * Image            | D             | stores image of the W A S D keys with the D key pressed
    * char             | ch            | stores user input for testing if it works
    * ------------------------------------------------------------------------------------
    */
    public void instruct1() {
	try { 
	    BufferedImage instruct = ImageIO.read (new File("instruct.jpg"));
	    Image WASD = ImageIO.read(new File("WASD.jpg"));
	    Image W = ImageIO.read(new File("W pressed WASD.jpg"));
	    Image A = ImageIO.read(new File("A pressed WASD.jpg"));
	    Image S = ImageIO.read(new File("S pressed WASD.jpg"));
	    Image D = ImageIO.read(new File("D pressed WASD.jpg"));
	    W = W.getScaledInstance(170, 128, W.SCALE_DEFAULT);
	    A = A.getScaledInstance(170, 128, W.SCALE_DEFAULT);
	    S = S.getScaledInstance(170, 128, W.SCALE_DEFAULT);
	    D = D.getScaledInstance(170, 128, W.SCALE_DEFAULT);
	    WASD = WASD.getScaledInstance(170, 128, WASD.SCALE_DEFAULT);
	    
	    char ch; 
	    c.setColor(Color.black); 
	    
	    c.drawImage(instruct, 0, 0, null);
	    c.drawImage(WASD, 100, 450, null);
	    ch = c.getChar(); 
	    ch = Character.toUpperCase(ch);
	    
	    while(ch == 'W' || ch == 'A' || ch == 'S' || ch == 'D') {
		if(ch=='W') c.drawImage(W, 100, 450, null);
		if(ch == 'A') c.drawImage(A, 100, 450, null);
		if(ch == 'S') c.drawImage(S, 100, 450, null);
		if(ch == 'D') c.drawImage(D, 100, 450, null);
		try { Thread.sleep(100); } catch(Exception e) {} 
		c.drawImage(WASD, 100, 450, null);
		ch = c.getChar(); 
		ch = Character.toUpperCase(ch); 
	    }
	}
	catch (FileNotFoundException fnf) {
	    new Message("File Not Found","error");
	}
	catch(IOException ioe) {
	    new Message("Error reading file", "error");
	}
    }
    
    //displays second page of instructions on how to navigate the maze of learning
    /*
    * ------------------------------------------------------------------------------------
    * Type             | Name          | Description
    * image            | instruct2     | image for instructions for the maze of learning
    * ------------------------------------------------------------------------------------
    */
    public void instruct2() {
	while (c.isCharAvail()) c.getChar();
	try { 
	    BufferedImage instruct2 = ImageIO.read (new File("learning.jpg"));
	    c.drawImage(instruct2, 0, 0, null);   
	}
	catch (FileNotFoundException fnf) {
	    new Message("File Not Found","error");
	}
	catch(IOException ioe) {
	    new Message("Error reading file", "error");
	}
	c.getChar();
    }
    
    //displays third page of instructions on how to play the game of testing
    /*
    * ------------------------------------------------------------------------------------
    * Type             | Name          | Description
    * image            | instruct3     | image for instructions for the game of testing
    * ------------------------------------------------------------------------------------
    */
    public void instruct3() {
	while (c.isCharAvail()) c.getChar();
	try { 
	    BufferedImage instruct3 = ImageIO.read (new File("testing.jpg"));
	    c.drawImage(instruct3, 0, 0, null);   
	}
	catch (FileNotFoundException fnf) {
	    new Message("File Not Found","error");
	}
	catch(IOException ioe) {
	    new Message("Error reading file", "error");
	}
	c.getChar();
    }
    
    //runs instructions
    public void run() {
	instruct1();
	instruct2();
	instruct3();
    }
}
