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
    
     public void animateLine(int x1, int y1, int x2, int y2, int thickness) {
	int slope = Math.round((y2-y1)/(x2-x1)); //scrapped idea from mycreation
	int dX = x2-x1;
	int dY = y2-y1;
	int length = (int)(Math.sqrt((dX*dX)+(dY*dY)));
	//int xStep = (int)(dX/step);
	for(int i = 0; i < dX; i++) {
	    for(int j = 0; j < thickness; j++) {
		c.drawLine(x1, y1+j, x1+i, y1+j+ i*slope);
		
	    }
	    try { Thread.sleep(50); } catch(Exception e) {}
	}
    }
    public void erase() {
	//150, 150, 724, 460
	c.setColor(board);
	for(int i = 0; i <4; i++) {
	    c.fillRect(160+100*i, 150, 160+80*i,450);
	    delay(100);
	}
    }
    public void fancyprint(String s1, int x, int y, int speed) {
	for (int i = 0; i <= s1.length(); i++) {
	    c.drawString(s1.substring(0, i), x, y);
	    delay(speed);
	}
    }
    //public Tutorial(Console con) {
	//c = con;
    public Tutorial() {
	c = new Console(38,128);
    }
    public void tutorial() {
	Font f = new Font("Consolas", 0, 40);
	c.setColor(Color.black);
	c.fillRoundRect(100, 100, 824, 560, 10,10);
	
	c.setColor(board);
	c.fillRoundRect(150, 150, 724, 460, 10,10);
	
	c.setColor(Color.white);
	c.setFont(f);
	fancyprint("Welcome to bicycle safety!", 220, 300, 20);
	delay(1000);
	erase();
    }
    
    
    public static void main(String[] args) {
	Tutorial t = new Tutorial();
	t.tutorial();
    }
    
}
