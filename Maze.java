/*
* Maze class (level 2) for Bicycle Safety Game
* 2024-01-07
* Tsz Fei Wang
* ICS3UP
*/
import java.awt.*;
import hsa.*;
import java.io.*; 
import java.awt.image.*;
import javax.imageio.*;

public class Maze {
    /*
    * ------------------------------------------------------------------------------------
    * Type             | Name          | Description
    * Color            | orange        | color of the orange background of the maze for hiding visited symbols and bicycle images
    * ------------------------------------------------------------------------------------
    */
    Console c;  
    Color orange = new Color(255,177,121);  
     
    public Maze (Console con) {
	c = con;
    }
    
    //Draws the maze, the cycles, the hardcoded path, and the description for the objects in the maze
    /*
    * ------------------------------------------------------------------------------------
    * Type             | Name          | Description
    * Image            | mazeMap       | base map of the maze
    * Image            | cycleUp       | image of the cycle facing up
    * Image            | cycleDown     | image of the cycle facing down
    * Image            | cycleLeft     | image of the cycle facing left
    * Image            | cycleRight    | image of the cycle facing right
    * Image            | p11           | image explaining first symbol
    * Image            | p12           | image explaining second symbol
    * Image            | p13           | image explaining third symbol
    * Image            | p14           | image explaining fourth symbol
    * Image            | p15           | image explaining fifth symbol
    * Image            | p16           | image explaining sixth symbol
    * Image            | p17           | image explaining seventh symbol
    * Image            | p18           | image explaining eighth symbol
    * Image            | p19           | image explaining ninth symbol
    * Image            | p20           | image explaining tenth symbol 
    * Image            | complete      | image showing the user that the maze has been completed     
    * ------------------------------------------------------------------------------------
    */
    public void drawMaze() {
	try { 
	    Image mazeMap = ImageIO.read (new File("mazeMap.jpg"));
	    Image cycleUp = ImageIO.read(new File("cycleUp.jpg"));
	    Image cycleDown = ImageIO.read(new File("cycleDown.jpg"));
	    Image cycleLeft = ImageIO.read(new File("cycleLeft.jpg"));
	    Image cycleRight = ImageIO.read(new File("cycleRight.jpg"));
	    /* 
	    code for changing size of image from https://stackoverflow.com/questions/5895829/resizing-image-in-java
	    */
	    cycleUp = cycleUp.getScaledInstance(40, 80, cycleUp.SCALE_DEFAULT);
	    cycleRight = cycleRight.getScaledInstance(80, 40, cycleRight.SCALE_DEFAULT);
	    cycleDown = cycleDown.getScaledInstance(40, 80, cycleDown.SCALE_DEFAULT);
	    cycleLeft = cycleLeft.getScaledInstance(80, 40, cycleLeft.SCALE_DEFAULT);
	    
	    //images of the icon descriptions 
	    Image p11 = ImageIO.read (new File("11.jpg"));
	    Image p12 = ImageIO.read (new File("12.jpg"));
	    Image p13 = ImageIO.read (new File("13.jpg"));
	    Image p14 = ImageIO.read (new File("14.jpg"));
	    Image p15 = ImageIO.read (new File("15.jpg"));
	    Image p16 = ImageIO.read (new File("16.jpg"));
	    Image p17 = ImageIO.read (new File("17.jpg"));
	    Image p18 = ImageIO.read (new File("18.jpg"));
	    Image p19 = ImageIO.read (new File("19.jpg"));
	    Image p20 = ImageIO.read (new File("20.jpg"));
	    Image complete = ImageIO.read(new File("mazeComplete.jpg")); 
	    c.drawImage(mazeMap, 0, 0, null);
	    
	    c.setColor(orange);
	    
	    //first symbol bike bell
	    for(int i = 0; i < 40; i++) {
		c.drawImage(cycleRight, i, 440, null);
		try{Thread.sleep(3); } catch(Exception e) {}
	    }
	    c.fillRect(40, 440, 85, 45);
	    for(int i = 0; i < 120; i++) {
		c.drawImage(cycleUp, 70, 440-i, null);
		try{Thread.sleep(3); } catch(Exception e) {}
	    }
	    c.drawImage(p11, 0, 0, null);
	    c.getChar(); 
	    c.drawImage(mazeMap, 0, 0, null); 
	    c.fillRect(70, 320, 45, 95);
	    
	    //second symbol helmet
	    for(int i = 0; i < 110; i++) {
		c.drawImage(cycleRight, 70 + i, 320, null); 
		try{Thread.sleep(3); } catch(Exception e) {}
	    }
	    c.fillRect(170, 320, 100, 45);
	    for(int i = 0; i < 160; i++) {
		c.drawImage(cycleDown, 200, 320+i, null); 
		try{Thread.sleep(3); } catch(Exception e) {}
	    }
	    c.drawImage(p12, 0, 0, null);
	    c.getChar(); 
	    c.drawImage(mazeMap, 0, 0, null); 
	    c.fillRect(70, 320, 45, 95);
	    c.fillRect(180, 490, 75, 120);
	    
	    //third symbol cycle lane
	    for(int i = 0; i < 280; i++) {
		c.drawImage(cycleUp, 200, 480-i, null);
		try{Thread.sleep(3); } catch(Exception e) {}
	    }
	    c.fillRect(190, 190, 65, 95);
	    for(int i = 0; i < 80; i++) {
		c.drawImage(cycleLeft, 190-i, 200, null); 
		try{Thread.sleep(3); } catch(Exception e) {}
	    }
	    c.drawImage(p13, 0, 0, null);
	    c.getChar(); 
	    c.drawImage(mazeMap, 0, 0, null); 
	    c.fillRect(70, 320, 45, 95);
	    c.fillRect(180, 490, 75, 120);
	    c.fillRect(50, 180, 140, 85);
	    
	    //fourth symbol stop sign
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
	    c.drawImage(p14, 0, 0, null);
	    c.getChar(); 
	    c.drawImage(mazeMap, 0, 0, null); 
	    c.fillRect(70, 320, 45, 95);
	    c.fillRect(180, 490, 75, 120);
	    c.fillRect(50, 180, 140, 85);
	    c.fillRect(560, 40, 105, 95);
	    
	    //5th symbol no cycle lane
	    for(int i = 0; i < 220; i++) {
		c.drawImage(cycleRight, 640+i, 60, null);
		try{Thread.sleep(3); } catch(Exception e) {}
	    }
	    c.fillRect(860, 60, 85, 45);
	    for(int i = 0; i < 60; i++) {
		c.drawImage(cycleDown, 890, 60+i, null);
		try{Thread.sleep(3); } catch(Exception e) {}
	    }
	    c.drawImage(p15, 0, 0, null);
	    c.getChar(); 
	    c.drawImage(mazeMap, 0, 0, null); 
	    c.fillRect(70, 320, 45, 95);
	    c.fillRect(180, 490, 75, 120);
	    c.fillRect(50, 180, 140, 85);
	    c.fillRect(560, 40, 105, 95);
	    c.fillRect(850, 160, 105, 80);
	    
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
	    //sixth symbol lights
	    for(int i = 0; i < 190; i++) {
		c.drawImage(cycleDown, 70, 440+i, null);
		try{Thread.sleep(3); } catch(Exception e) {}
	    }
	    c.drawImage(p16, 0, 0, null);
	    c.getChar(); 
	    c.drawImage(mazeMap, 0, 0, null); 
	    c.fillRect(70, 320, 45, 95);
	    c.fillRect(180, 490, 75, 120);
	    c.fillRect(50, 180, 140, 85);
	    c.fillRect(560, 40, 105, 95);
	    c.fillRect(850, 160, 105, 80);
	    c.fillRect(45, 610, 62, 115); 
	    
	    //seventh symbol pediatrician corssing or something
	    for(int i = 0; i < 240; i++) {
		c.drawImage(cycleRight, 80+i, 680, null);
		try{Thread.sleep(3); } catch(Exception e) {}
	    }
	    c.fillRect(320, 680, 85, 45);
	    for(int i = 0; i < 280; i++) {
		c.drawImage(cycleUp, 350, 640-i, null);
		try{Thread.sleep(3); } catch(Exception e) {}
	    }
	    c.drawImage(p17, 0, 0, null);
	    c.getChar(); 
	    c.drawImage(mazeMap, 0, 0, null); 
	    c.fillRect(70, 320, 45, 95);
	    c.fillRect(180, 490, 75, 120);
	    c.fillRect(50, 180, 140, 85);
	    c.fillRect(560, 40, 105, 95);
	    c.fillRect(850, 160, 105, 80);
	    c.fillRect(45, 610, 62, 115);
	    c.fillRect(340, 320, 75, 135); 
	    
	    //eighth symbol do not enter
	    for(int i = 0; i < 40; i++) {
		c.drawImage(cycleRight, 450+i, 350, null); 
		try{Thread.sleep(3); } catch(Exception e) {}
	    }
	    c.fillRect(490, 350, 85, 45); 
	    for(int i = 0; i < 220; i++) {
		c.drawImage(cycleDown, 500, 350+i, null); 
		try{Thread.sleep(3); } catch(Exception e) {}
	    }
	    c.drawImage(p18, 0, 0, null);
	    c.getChar(); 
	    c.drawImage(mazeMap, 0, 0, null); 
	    c.fillRect(70, 320, 45, 95);
	    c.fillRect(180, 490, 75, 120);
	    c.fillRect(50, 180, 140, 85);
	    c.fillRect(560, 40, 105, 95);
	    c.fillRect(850, 160, 105, 80);
	    c.fillRect(45, 610, 62, 115);
	    c.fillRect(340, 320, 75, 135); 
	    c.fillRect(470, 570, 85, 150);
	    
	    //ninth symbol no turning
	    for(int i = 0; i < 280; i++) {
		c.drawImage(cycleRight, 600 + i, 650, null);
		try{Thread.sleep(3); } catch(Exception e) {}
	    }
	    c.fillRect(880, 650, 85, 45); 
	    for(int i = 0; i < 60; i++) {
		c.drawImage(cycleUp, 890, 550 - i, null); 
		try{Thread.sleep(3); } catch(Exception e) {}
	    }
	    c.drawImage(p19, 0, 0, null);
	    c.getChar(); 
	    c.drawImage(mazeMap, 0, 0, null); 
	    c.fillRect(70, 320, 45, 95);
	    c.fillRect(180, 490, 75, 120);
	    c.fillRect(50, 180, 140, 85);
	    c.fillRect(560, 40, 105, 95);
	    c.fillRect(850, 160, 105, 80);
	    c.fillRect(45, 610, 62, 115);
	    c.fillRect(340, 320, 75, 135); 
	    c.fillRect(470, 570, 85, 150);
	    c.fillRect(880, 480, 80, 120);
	    
	    //tenth symbol yield
	    
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
	    c.drawImage(p20, 0, 0, null);
	    c.getChar(); 
	    c.drawImage(mazeMap, 0, 0, null); 
	    c.fillRect(70, 320, 45, 95);
	    c.fillRect(180, 490, 75, 120);
	    c.fillRect(50, 180, 140, 85);
	    c.fillRect(560, 40, 105, 95);
	    c.fillRect(850, 160, 105, 80);
	    c.fillRect(45, 610, 62, 115);
	    c.fillRect(340, 320, 75, 135); 
	    c.fillRect(470, 570, 85, 150);
	    c.fillRect(880, 480, 80, 120);
	    c.fillRect(700, 300, 120, 175);
	    
	    //exit 
	    for(int i = 0; i < 180; i++) {
		c.drawImage(cycleRight, 830+i, 350, null); 
		try{Thread.sleep(3); } catch(Exception e) {}
	    }
	    c.drawImage(complete, 0, 0, null);
	    c.getChar();
	    
	}
	catch (FileNotFoundException fnf) {
	    new Message("File Not Found","error");
	}
	catch(IOException ioe) {
	    new Message("Error reading file", "error");
	}
	
	c.getChar();
    }
    
    //runs drawMaze();
    public void run() {
	drawMaze();
    }
}
