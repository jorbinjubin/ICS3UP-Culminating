import hsa.Console;
import java.awt.*;
import java.io.*;
import java.util.*;
import javax.imageio.*;


public class Game {
    private Console c;
    public Game() {
    //public Game(Console con) {
	//c = con;
	c = new Console(38,128,"a Safety");
    }
    Color greb = new Color(30,200,30);
    public void drawRoad() {
	c.setColor(greb);
	c.fillRect(0,0,1024,760);
	c.setColor(Color.black);
	c.fillRect(0, 150, 1024, 470);
    }
    public void barrel(int x) {
	c.setColor(Color.red);
	c.fillOval(x, 300, 30, 30);   
    }
    public void drawBike() {
	try{
	    Image cycleRight = ImageIO.read(new File("cycleRight.jpg"));
	    cycleRight = cycleRight.getScaledInstance(100, 50, cycleRight.SCALE_DEFAULT);
	    c.drawImage(cycleRight, 500, 300, null);
	}catch(IOException ioe) {}
    }      
   
    public void anim() {
	int barrelX = 1024;
	char ch = ' ';
	double delta = 0;
	while(true) {
	    if(c.isCharAvail()) {
		ch = c.getChar();
	    }
	    else {
		tkit.goTowards(delta, 0, 0.3, 0.5);
		/* 
		Not implemented yet, need to steal this from godot
		*/
	    }
	    if(ch == 'o') break;
	    if(ch == 'd') delta+=3;
	    if(ch == 'a') delta-=3;
	    if(delta > 10) delta = 10;
	    if(delta < -10) delta = -10;
	    barrelX -= delta;
	    drawRoad();
	    drawBike();
	    barrel((int)barrelX);
	    if(barrelX < 000) {
		break;
	    }
	    try{Thread.sleep(100);} catch(Exception e) {}
	}
	c.clear();
	c.println("dieded");
    }
    
    public static void main(String[] args) {
	Game g = new Game();
	g.anim();
    }
}
