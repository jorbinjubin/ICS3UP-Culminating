/*
* Main class for Bicycle Safety Game
* Level 1: Tutorial, explains what playing the game will do and the content in the game. 
* Level 2: Maze of learning, the user watches a bicycle navigate a maze and encountering  
* explaining road signs and equipment that is important for them to know.
* Level 3: The user is a cyclist, and has to make decisions based on what they learned
* in the maze to adhere to bicycle safety and road laws. 
* 2024-01-07
* Justin Jiang, Tsz Fei Wang
* ICS3UP
*/ 

import java.io.*;
import hsa.Console;
import hsa.Message;
import java.util.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class BicycleSafety {    
    /*
    * ------------------------------------------------------------------------------------
    * Type             | Name          | Description
    * int              | menuChoice    | saves user choice of what to do in the main menu
    * int              | saveScore     | stores the user choice of whether or not to save their score
    * Menu             | m             | object of the menu class
    * Console          | c             | console
    * ------------------------------------------------------------------------------------
    */
    
    //declaration
    int menuChoice = 0;
    Menu m;
    //console variable
    Console c;
    int saveScore; 
    
    //constructor 
    public BicycleSafety() {
	c = new Console(38,128,"Bicycle Safety"); //1024 by 760;
    }
    
    public BicycleSafety(Menu m, Console con) {
	//Sets object variables using the 'this' keyword, thanks to Phil Huang for the suggestion
	//For some reason, this is the only way it works
	this.m = m;
	c = con;
	//Console c = new Console(38,128,"Bicycle Safety"); //1024 by 760;
    }
    
    //creates an object of the tutorial class and runs it
    //Variables: 
    //Tutorial t - object of Tutorial class
    public void tutorial() {
	Tutorial t = new Tutorial(c);
	t.run();
    }
    
    //calls methods from the menu class for the user to select choices from the menu
    public void menu(int x) {
	if(x == 1) m.menuSelect();
	else if(x==2) m.menu2Select();
    }
    
    //creates an object of the splash class and runs it
    //Variables: 
    //Splash s - object of splash class
    public void splash() {
	Splash s = new Splash(c);
	s.run();
    }
    
    //creates an object of the instructions class and runs it
    //Variables: 
    //Instructions i - object of Instructions class
    public void instr() {
	Instructions i = new Instructions(c); 
	i.run();
    }
    
    //creates an object of the maze class and runs it
    //Variables: 
    //Tutorial m - object of maze class
    public void maze() {
	Maze m = new Maze(c); 
	m.run();
    }
    
    //creates an object of the game class and runs it, then saves the users choice on whether or not to save their score from the game class into the global savescore variable
    //Variables: 
    //Game g - object of the game class 
    public void play() {
	c.clear();
	Game g = new Game(c); 
	g.run();
	saveScore = g.saveScore;
    }
    
    //imports and draws credits image
    public void goodbye() {
	try { BufferedImage credits = ImageIO.read(new File("credits.jpg")); 
	c.drawImage(credits, 0, 0, null); }
	catch(IOException e) {}
    }
    
    //creates an object of the leaderboard class and runs methods from the class based on its given parameters
    //Variables: 
    //Leaderboard lb - object of the leaderboard class
    public void lb(int i) {
	Leaderboard lb = new Leaderboard(c);
	if(i==0) lb.drawLB(); 
	else if(i==1) lb.calculateLeaderboard();
	c.getChar();
    }
    
    //runs all classes in program
    public static void main(String[] args) {
	BicycleSafety b = new BicycleSafety();
	Menu m = new Menu(b.c);
	BicycleSafety z = new BicycleSafety(m, b.c);
	
	z.splash();
	while(true) {
	    z.menu(1);
	    if(m.getHasChosen1()) {
		if(m.getChoice() == 0) z.instr();
		 else if(m.getChoice() == 1) { 
		    z.menu(2);
		    m.setHasChosen1(false);
		    if(m.getHasChosen2()) {
			if(m.getChoice() == 0) z.tutorial();
			else if(m.getChoice() == 1) z.maze();
			else if(m.getChoice() == 2) {
			    z.play();
			    if(z.saveScore == 'y') z.lb(1);
			    else continue;
			} 
			else if(m.getChoice() == 3) break;
		    }
		 }
		 else if(m.getChoice() == 2) z.lb(0);
		 else if (m.getChoice() == 3) break;
	    }
	    m.setHasChosen1(false);
	}
	z.c.clear();
	z.goodbye(); 
	z.c.getChar();
	z.c.close();
	
    }        
}
