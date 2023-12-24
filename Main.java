import java.io.*;
import hsa.Console;
import hsa.Message;
import java.util.*;

public class Main {
    
    int menuChoice = 0;
    Menu m;
    Console c;
    public Main(Menu m, Console con) {
	this.m = m;
	this.c = con;
    }
    public void menu() {
	m.run();
    }
    public void instr() {
	c.clear();
	c.println("entered instructions");
	c.getChar();
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
	
	while(true) {
	    z.menu();
	    if(m.getHasChosen()) {
		if(m.getChoice() == 0) z.instr();
		else if(m.getChoice() == 1) z.play();
		else if(m.getChoice() == 2) z.lb();
		else if (m.getChoice() == 3) break;
	    }
	    m.setHasChosen(false);
	}
	c.clear();
	c.println("goodbye");
	c.getChar();
	z.c.close();
    }        
}
