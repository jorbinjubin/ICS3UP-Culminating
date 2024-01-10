import hsa.Console;
import java.awt.*;
import java.io.*;
import java.util.*;
import javax.imageio.*;


public class Game {
    private Console c;
    Console debug = new Console("Debugging Window");
    public Game() {
    //public Game(Console con) {
	//c = con;
	c = new Console(38,128,"a Safety");
    }
    Color road = new Color(96,94,94);
    Color curb = new Color(162,162,161);
    Color lamp_glow = new Color(255,255,10,150);
    Color green = new Color(30,200,30);
    public void drawRoad() {
	c.setColor(green);
	c.fillRect(0,0,1024,760);
	c.setColor(Color.black);
	c.fillRect(0, 200, 1024, 400);
    }
    
    public void barrel(int x) {
	c.setColor(Color.red);
	c.fillOval(x, 140, 30, 30);   
    }
    
    public void drawLight(int x) {
    
    }
    
    public void drawHydrant(int x) {
    
    }
    
    public void drawSign(int num) {
    
    }
    public void drawBike() {
	try{
	    Image cycleRight = ImageIO.read(new File("Bike_ride.png"));
	    cycleRight = cycleRight.getScaledInstance(100, 50, cycleRight.SCALE_DEFAULT);
	    c.drawImage(cycleRight, 500, 520, null);
	}catch(IOException ioe) {}
    }      
    
    public void anim() {
	int barrelX = 1024;
	char ch = ' ';
	double delta = 0;
	while(true) {
	    if(c.isCharAvail()) ch = c.getChar();
	    else {
		if(Math.abs(0-delta) < 0.3) delta = 0; //this just checks if the speed is close enough to zero and stops it.
		if(delta != 0) { //Slowly slows down because gameplay.
		    if(delta > 0) delta -= delta * 0.2 ;
		    if(delta < 0) delta += delta * -0.3 ;
		}
	    }
	    if(ch == 'o') break;
	    if(ch == 'd') delta+=3;
	    if(ch == 'a') delta-=3;
	    if(delta > 10) delta = 10;
	    if(delta < -5) delta = -5;
	    barrelX -= delta;
	    drawRoad();
	    drawBike();
	    debug.println(delta);
	    barrel((int)barrelX);
	    barrel((int)barrelX + 300);
	    barrel((int)barrelX + 600);
	    barrel((int)barrelX + 900);
	    ch = ' ';
	    try{Thread.sleep(48);} catch(Exception e) {}
	    if(c.isCharAvail()) ch = c.getChar();
	    
	}
	c.clear();
	c.println("dieded");
    }
    
    public static void main(String[] args) {
	Game g = new Game();
	g.anim();
    }
}
