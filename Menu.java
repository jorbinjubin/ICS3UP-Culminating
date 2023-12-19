import hsa.Console; // or import hsa.*;
import java.awt.*;
import sun.audio.*;
import java.io.*;

public class Menu {
    AudioStream as;
    int choice = 0;
    public void delay() {
	try {
	    Thread.sleep(220);
	} catch(Exception e) {
	}
    }
    public void menuSelect() {
	boolean hasChosen = false;       
	while (!hasChosen) {
	    try {
		if (c.isCharAvail()) {
		    switch (c.getChar()) {
		    case 'w':
			if (choice < 4) {
			    choice++;
			    try {
				as = new AudioStream(new FileInputStream("button.wav"));
			    } catch (Exception e) {}
			    AudioPlayer.player.start(as);
			    delay();
			}
			break;
		    case 's':
			if (choice > 0) {
			    choice--;
			    try {
				as = new AudioStream(new FileInputStream("button.wav"));
			    } catch (Exception e) {}
			    AudioPlayer.player.start(as);
			    delay();
			}
			break;
		    case '\n':
			hasChosen = true;
			break;
		    default:
			break;
		    }
		}
	    } catch (Exception e) {}
	}
	c.setColor(new Color(0,255,255));
	c.fillRect(0,0,300,200);
    }
    public static void main(String[] args) {
	Console c = new Console();
    
    }
}
