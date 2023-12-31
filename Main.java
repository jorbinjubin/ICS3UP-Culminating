import java.io.*;
import hsa.Console;
import hsa.Message;
import java.util.*;

public class Main {
    
    //declaration
    int menuChoice = 0;
    Menu m;
    //console variable
    Console c;
    
    //constructor 
    public Main(Menu m, Console con) {
	//Sets object variables using the 'this' keyword, thanks to Phil Huang for the suggestion
	//For some reason, this is the only way it works
	this.m = m;
	this.c = con;
    }
    
    public void menu(int x) {
	if(x == 1) m.menuSelect();
	else if(x==2) m.menu2Select();
    }
    
    public void splash() {
	Splash s = new Splash(c);
	s.run();
    }
    public void instr() {
	Instructions i = new Instructions(c); 
	i.run();
    }
    public void maze() {
	Maze m = new Maze(c); 
	m.run();
    }

    public void play() {
	c.clear();
	c.println("entered play");
	c.getChar();
    }
    
    public void lb() {
	c.clear();
	c.println("entered leaderboard");
	c.getChar();
    }
    
    public static void main(String[] args) {
	Console c = new Console(38,128,"Bicycle Safety"); //1024 by 760;
	Menu m = new Menu(c);
	Main z = new Main(m, c);
	//z.splash();
	while(true) {
	    z.menu(1);
	    if(m.getHasChosen1()) {
		if(m.getChoice() == 0) z.instr();
		 else if(m.getChoice() == 1) { 
		    z.menu(2);
		    m.setHasChosen1(false);
		    if(m.getHasChosen2()) {
			if(m.getChoice() == 0) z.maze();  
			else if(m.getChoice() == 1) z.play(); 
			else if(m.getChoice() == 2) continue; 
			else if(m.getChoice() == 3) break;
		    }
		 }
		 else if(m.getChoice() == 2) z.lb();
		 else if (m.getChoice() == 3) break;
	    }
	    m.setHasChosen1(false);
	}
	c.clear();
	c.println("goodbye");
	c.getChar();
	z.c.close();
	
    }        
}
