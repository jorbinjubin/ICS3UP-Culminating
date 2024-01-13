/* 
* Tutorial (Level 1) of Bicycle Safety Game
* Mostly Justin
* 2024-01-09
* ICS3UP
*/

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
	for(int i = 0; i < (int)(dX/2); i++) {
	    for(int j = 0; j < thickness; j++) {
		c.drawLine(x1, y1+j, x1+2*i, y1+j+ 2*i*slope);
		
	    }
	    try { Thread.sleep(10); } catch(Exception e) {}
	}
    }
    public void erase() {
	//150, 150, 724, 460
	c.setColor(board);
	for(int i = 0; i <4; i++) {
	    c.fillRect(160+100*i, 150, 160+80*i,450);
	    delay(100);
	}
	c.fillRect(850, 160, 23, 440);
    }
    public void fancyprint(String s1, int x, int y, int speed) {
	for (int i = 0; i <= s1.length(); i++) {
	    c.drawString(s1.substring(0, i), x, y);
	    delay(speed);
	}
    }
    public Tutorial(Console con) {
	c = con;
    }
    public void tutorial() {
	Font f = new Font("Consolas", 0, 40);
	Font f2 = new Font("Consolas", 0, 24);
	Font f3 = new Font("Consolas", 0, 72);
	Font f4 = new Font("Consolas", 0, 20);
	c.setColor(Color.black);
	c.fillRoundRect(100, 100, 824, 560, 10,10);
	
	c.setColor(board);
	c.fillRoundRect(150, 150, 724, 460, 10,10);
	
	c.setColor(Color.white);
	c.setFont(f);
	fancyprint("Welcome to bicycle safety!", 220, 300, 20);
	delay(1000);
	c.setFont(f2);
	erase();
	c.setColor(Color.white);
	fancyprint("This game will teach everything you need to know about", 165, 280,20);
	c.setFont(f3);
	fancyprint("Bicycle Safety!", 220, 380, 20);

	drawCircle(410, 530, 100, Color.white); //wheel left
	drawCircle(610, 530, 100, Color.white); //wheel right
	c.setColor(Color.white);
	animateLine(410, 530, 523, 530, 6);
	animateLine(410, 530, 480, 460, 6);
	animateLine(410, 530, 480, 460, 7);
	animateLine(478, 462, 590, 460, 6);
	animateLine(520, 530, 590, 460, 7);
	for(int i = 0; i < 6; i++) {
	    c.drawLine(610+i, 530, 570+i, 420);
	    delay(10);
	}
	for(int i = 0; i < 6; i++) {
	    c.drawLine(480+i,460, 521+i, 529);
	    delay(10);
	}
	animateLine(533, 420, 573, 420,6);
	delay(1000);
	erase();
	c.setColor(Color.white);
	c.setFont(f2);
	fancyprint("In this game, you will be tested on:",250,300,20);
	fancyprint("- Road Signs", 250, 330, 20);
	fancyprint("- Road Laws", 250, 360, 20);
	fancyprint("- Bike Safety Gear", 250, 390, 20);
	delay(1000);
	erase();
	c.setColor(Color.white);
	c.setFont(f4);
	fancyprint("Bicycle safety is important to know to ride a bike safely.", 160, 300, 20);    
	fancyprint("When you're out riding a bike, make sure to follow the rules", 160, 320, 20);
	fancyprint("that are taught in this game, such as wearing proper equipment", 160, 340, 20);
	fancyprint("following road signs, and making sure it's safe to cross roads.", 160, 360, 20);
	erase();
	c.setColor(Color.white);
	c.setFont(f3);
	fancyprint("That's it!", 310, 300, 20);
	c.setFont(f);
	fancyprint("Good luck, have fun", 300, 380, 20);
	c.setFont(f2);
	fancyprint("Press any key to return to main menu...", 260, 430, 20);
	c.getChar();
    }
    
    public void run() {
	t.tutorial();
    }
    
}
