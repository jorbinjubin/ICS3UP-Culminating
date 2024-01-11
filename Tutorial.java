import hsa.Console;
import java.awt.*;

public class Tutorial {
    private Console c;
    
    Color board = new Color(0,100,0);
    public void delay(int ms) {
	try {
	    Thread.sleep(ms);
	}catch(Exception e){}
    }
    public void drawCircle(int x, int y, int rad, Color col) {
	for(int i = 0; i <= 36; i++) {
	    c.setColor(col);
	    c.fillArc(x-rad/2,y-rad/2,rad,rad, 0, 10*i);
	    c.setColor(board);
	    c.fillArc(x-(rad-16)/2,y-(rad-16)/2,rad-16,rad-16, 0, 10*i);
	    delay(20);
	}
    }
    
    /*
    
    TODO: Finish this method which draws a line in sections to mimic it being actually drawn by hand
    
    public void drawLine(int x1, int y1, int x2, int y2, int thickness, int step) {
	double slope = (y2-y1)/(x2-x1); //scrapped idea from mycreation
	int dX = x2-x1;
	int dY = y2-y1;
	int length = (int)(Math.sqrt((dX*dX)+(dY*dY)));
	int xStep = (int)(dX/step);
	for(int i = 0; i < xStep; i++) {
	    for(int j = 0; j < thickness; j++) {
		
		delay(100);
		
	    }
	}
	c.drawLine(x1,y1,x2,y2);
    }
    */
    
    public void erase() {
    
    }
    
    //public Tutorial(Console con) {
	//c = con;
    public Tutorial() {
	c = new Console(38,128);
    }
    public void tutorial() {
	c.setColor(Color.black);
	c.fillRoundRect(100, 100, 824, 560, 10,10);
	
	c.setColor(board);
	c.fillRoundRect(150, 150, 724, 460, 10,10);
	
	c.setColor(Color.black);
	drawCircle(500,400,200, Color.white);
    }
    
    
    public static void main(String[] args) {
	Tutorial t = new Tutorial();
	t.tutorial();
    }
    
}
