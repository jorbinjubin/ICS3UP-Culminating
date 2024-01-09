import java.awt.*;
import hsa.*;
import java.io.*; 
import java.awt.image.*;
import javax.imageio.*;

public class Maze {
    Console c;  
    int score = 0;   
    Color orange = new Color(255,177,121);  
     
    public Maze (Console con) {
	c = con;
    }
    
    public void drawMaze() {
	try { 
	    Image mazeMap = ImageIO.read (new File("mazeMap.jpg"));
	    Image cycleUp = ImageIO.read(new File("cycleUp.jpg"));
	    Image cycleDown = ImageIO.read(new File("cycleDown.jpg"));
	    Image cycleLeft = ImageIO.read(new File("cycleLeft.jpg"));
	    Image cycleRight = ImageIO.read(new File("cycleRight.jpg"));
	    cycleUp = cycleUp.getScaledInstance(40, 80, cycleUp.SCALE_DEFAULT);
	    cycleRight = cycleRight.getScaledInstance(80, 40, cycleRight.SCALE_DEFAULT);
	    cycleDown = cycleDown.getScaledInstance(40, 80, cycleDown.SCALE_DEFAULT);
	    cycleLeft = cycleLeft.getScaledInstance(80, 40, cycleLeft.SCALE_DEFAULT);
	    
	    c.drawImage(mazeMap, 0, 0, null);
	    
	    c.setColor(orange);
	    
	    //first symbol 
	    for(int i = 0; i < 40; i++) {
		c.drawImage(cycleRight, i, 440, null);
		try{Thread.sleep(3); } catch(Exception e) {}
	    }
	    c.fillRect(40, 440, 85, 45);
	    for(int i = 0; i < 120; i++) {
		c.drawImage(cycleUp, 70, 440-i, null);
		try{Thread.sleep(3); } catch(Exception e) {}
	    }
	    c.fillRect(70, 320, 45, 85);
	    
	    //second symbol
	    for(int i = 0; i < 110; i++) {
		c.drawImage(cycleRight, 70 + i, 320, null); 
		try{Thread.sleep(3); } catch(Exception e) {}
	    }
	    c.fillRect(170, 320, 100, 45);
	    for(int i = 0; i < 160; i++) {
		c.drawImage(cycleDown, 200, 320+i, null); 
		try{Thread.sleep(3); } catch(Exception e) {}
	    }
	    c.fillRect(180, 490, 75, 105);
	    
	    //third symbol
	    for(int i = 0; i < 280; i++) {
		c.drawImage(cycleUp, 200, 480-i, null);
		try{Thread.sleep(3); } catch(Exception e) {}
	    }
	    c.fillRect(190, 190, 65, 95);
	    for(int i = 0; i < 80; i++) {
		c.drawImage(cycleLeft, 190-i, 200, null); 
		try{Thread.sleep(3); } catch(Exception e) {}
	    }
	    c.fillRect(60, 180, 140, 65);
	    
	    //fourth symbol 
	    for(int i = 0; i < 110; i++) {
		c.drawImage(cycleUp, 70, 180-i, null);
		try{Thread.sleep(3); } catch(Exception e) {}
	    }
	    c.fillRect(70, 70, 55, 85);
	    for(int i = 0; i < 330; i++) {
		c.drawImage(cycleRight, 80+i, 70, null);
		try{Thread.sleep(3); } catch(Exception e) {}
	    }
	    c.fillRect(410, 70, 95, 45);
	    for(int i = 0; i < 110; i++) {
		c.drawImage(cycleDown, 435, 70+i, null);
		try{Thread.sleep(3); } catch(Exception e) {}
	    }
	    c.fillRect(430, 180, 55, 85);
	    for(int i = 0; i < 270; i++) {
		c.drawImage(cycleRight, 425+i, 200, null);
		try{Thread.sleep(3); } catch(Exception e) {}
	    }
	    c.fillRect(700, 200, 85, 45); 
	    for(int i = 0; i < 120; i++) {
		c.drawImage(cycleUp, 710, 180-i, null);
		try{Thread.sleep(3); } catch(Exception e) {}
	    }
	    c.fillRect(700, 60, 45, 85);
	    for(int i = 0; i < 60; i++) {
		c.drawImage(cycleLeft, 700-i, 60, null);
		try{Thread.sleep(3); } catch(Exception e) {}
	    }
	    c.fillRect(640, 40, 45, 85);
	    
	    //5th symbol 
	    for(int i = 0; i < 220; i++) {
		c.drawImage(cycleRight, 640+i, 60, null);
		try{Thread.sleep(3); } catch(Exception e) {}
	    }
	    c.fillRect(860, 60, 85, 45);
	    for(int i = 0; i < 60; i++) {
		c.drawImage(cycleDown, 890, 60+i, null);
		try{Thread.sleep(3); } catch(Exception e) {}
	    }
	    c.fillRect(860, 120, 85, 45);
	    
	    //goes in reverse
	    //5th symbol 
	    for(int i = 0; i < 60; i++) {
		c.drawImage(cycleUp, 890, 120-i, null);
		try{Thread.sleep(3); } catch(Exception e) {}
	    }
	    c.fillRect(890, 60, 45, 85);
	    for(int i = 0; i < 160; i++) {
		c.drawImage(cycleLeft, 860-i, 60, null);
		try{Thread.sleep(3); } catch(Exception e) {}
	    }
	    c.fillRect(700, 60, 85, 45);
	    
	    //fourth symbol 
	    for(int i = 0; i < 120; i++) {
		c.drawImage(cycleDown, 710, 60+i, null);
		try{Thread.sleep(3); } catch(Exception e) {}
	    }
	    c.fillRect(700, 180, 45, 85);
	    for(int i = 0; i < 270; i++) {
		c.drawImage(cycleLeft, 695-i, 200, null);
		try{Thread.sleep(3); } catch(Exception e) {}
	    }
	    c.fillRect(420, 200, 85, 45); 
	    for(int i = 0; i < 110; i++) {
		c.drawImage(cycleUp, 435, 180-i, null);
		try{Thread.sleep(3); } catch(Exception e) {}
	    }
	    c.fillRect(430, 70, 55, 85);
	    for(int i = 0; i < 330; i++) {
		c.drawImage(cycleLeft, 410-i, 70, null);
		try{Thread.sleep(3); } catch(Exception e) {}
	    }
	    c.fillRect(80, 70, 95, 45);
	    for(int i = 0; i < 110; i++) {
		c.drawImage(cycleDown, 70, 70+i, null);
		try{Thread.sleep(3); } catch(Exception e) {}
	    }
	    c.fillRect(70, 180, 55, 85);
	    
	    //third symbol
	    for(int i = 0; i < 80; i++) {
		c.drawImage(cycleRight, 110+i, 200, null); 
		try{Thread.sleep(3); } catch(Exception e) {}
	    }
	    c.fillRect(190, 180, 82, 65);
	    for(int i = 0; i < 60; i++) {
		c.drawImage(cycleDown, 200, 200+i, null);
		try{Thread.sleep(3); } catch(Exception e) {}
	    }
	    c.fillRect(190, 260, 82, 65);
	    
	    //second symbol
	    for(int i = 0; i < 110; i++) {
		c.drawImage(cycleLeft, 180-i, 320, null); 
		try{Thread.sleep(3); } catch(Exception e) {}
	    }
	    c.fillRect(60, 320, 85, 45);
	    
	    
	    //first symbol
	    for(int i = 0; i < 120; i++) {
		c.drawImage(cycleDown, 70, 320+i, null);
		try{Thread.sleep(3); } catch(Exception e) {}
	    }
	    c.fillRect(60, 440, 42, 85);
	    
	    //second part 
	    //sixth symbol 
	    for(int i = 0; i < 190; i++) {
		c.drawImage(cycleDown, 70, 440+i, null);
		try{Thread.sleep(3); } catch(Exception e) {}
	    }
	    c.fillRect(45, 610, 62, 115); 
	    
	    //seventh symbol 
	    for(int i = 0; i < 240; i++) {
		c.drawImage(cycleRight, 80+i, 680, null);
		try{Thread.sleep(3); } catch(Exception e) {}
	    }
	    c.fillRect(320, 680, 85, 45);
	    for(int i = 0; i < 280; i++) {
		c.drawImage(cycleUp, 350, 640-i, null);
		try{Thread.sleep(3); } catch(Exception e) {}
	    }
	    c.fillRect(340, 320, 75, 135);
	    
	    //eighth symbol 
	    for(int i = 0; i < 40; i++) {
		c.drawImage(cycleRight, 450+i, 350, null); 
		try{Thread.sleep(3); } catch(Exception e) {}
	    }
	    c.fillRect(490, 350, 85, 45); 
	    for(int i = 0; i < 220; i++) {
		c.drawImage(cycleDown, 500, 350+i, null); 
		try{Thread.sleep(3); } catch(Exception e) {}
	    }
	    c.fillRect(470, 570, 85, 150);
	    
	    
	    //ninth symbol
	    for(int i = 0; i < 280; i++) {
		c.drawImage(cycleRight, 600 + i, 650, null);
		try{Thread.sleep(3); } catch(Exception e) {}
	    }
	    c.fillRect(880, 650, 85, 45); 
	    for(int i = 0; i < 60; i++) {
		c.drawImage(cycleUp, 890, 550 - i, null); 
		try{Thread.sleep(3); } catch(Exception e) {}
	    }
	    c.fillRect(880, 480, 80, 120);
	    
	    //tenth symbol 
	    for(int i = 0; i < 130; i++) {
		c.drawImage(cycleDown, 890, 490 + i, null); 
		try{Thread.sleep(3); } catch(Exception e) {}
	    }
	    c.fillRect(890, 620, 45, 85);
	    for(int i = 0; i < 120; i++) {
		c.drawImage(cycleLeft, 890-i, 650, null); 
		try{Thread.sleep(3); } catch(Exception e) {}
	    }
	    c.fillRect(760, 650, 85, 45);
	    for(int i = 0; i < 230; i++) {
		c.drawImage(cycleUp, 740, 640-i, null); 
		try{Thread.sleep(3); } catch(Exception e) {}
	    }
	    c.fillRect(720, 320, 85, 175);
	    
	    //exit 
	    for(int i = 0; i < 180; i++) {
		c.drawImage(cycleRight, 830+i, 350, null); 
		try{Thread.sleep(3); } catch(Exception e) {}
	    }
	    
	}
	catch (FileNotFoundException fnf) {
	    new Message("File Not Found","error");
	}
	catch(IOException ioe) {
	    new Message("Error reading file", "error");
	}
	
	c.getChar();
    }
    public void run() {
	drawMaze();
    }
}
