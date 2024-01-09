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
            
            
            
            //second part 
            //sixth symbol 
            for(int i = 0; i < 190; i++) {
                c.drawImage(cycleDown, 70, 440+i, null);
                try{Thread.sleep(10); } catch(Exception e) {}
            }
            c.fillRect(45, 610, 62, 115); 
            
            //seventh symbol 
            for(int i = 0; i < 240; i++) {
                c.drawImage(cycleRight, 80+i, 680, null);
                try{Thread.sleep(10); } catch(Exception e) {}
            }
            c.fillRect(320, 680, 85, 45);
            for(int i = 0; i < 280; i++) {
                c.drawImage(cycleUp, 350, 640-i, null);
                try{Thread.sleep(10); } catch(Exception e) {}
            }
            c.fillRect(340, 320, 75, 135);
            
            //eighth symbol 
            for(int i = 0; i < 40; i++) {
                c.drawImage(cycleRight, 450+i, 350, null); 
                try{Thread.sleep(10); } catch(Exception e) {}
            }
            c.fillRect(490, 350, 85, 45); 
            for(int i = 0; i < 220; i++) {
                c.drawImage(cycleDown, 500, 350+i, null); 
                try{Thread.sleep(10); } catch(Exception e) {}
            }
            c.fillRect(470, 570, 85, 150);
            
            
            //ninth symbol
            for(int i = 0; i < 280; i++) {
                c.drawImage(cycleRight, 600 + i, 650, null);
                try{Thread.sleep(10); } catch(Exception e) {}
            }
            c.fillRect(880, 650, 85, 45); 
            for(int i = 0; i < 60; i++) {
                c.drawImage(cycleUp, 890, 550 - i, null); 
                try{Thread.sleep(10); } catch(Exception e) {}
            }
            c.fillRect(880, 480, 80, 120);
            
            //tenth symbol 
            for(int i = 0; i < 130; i++) {
                c.drawImage(cycleDown, 890, 490 + i, null); 
                try{Thread.sleep(10); } catch(Exception e) {}
            }
            c.fillRect(890, 620, 45, 85);
            for(int i = 0; i < 120; i++) {
                c.drawImage(cycleLeft, 890-i, 650, null); 
                try{Thread.sleep(10); } catch(Exception e) {}
            }
            c.fillRect(760, 650, 85, 45);
            for(int i = 0; i < 230; i++) {
                c.drawImage(cycleUp, 740, 640-i, null); 
                try{Thread.sleep(10); } catch(Exception e) {}
            }
            c.fillRect(720, 320, 85, 175);
            
            //exit 
            for(int i = 0; i < 180; i++) {
                c.drawImage(cycleRight, 830+i, 350, null); 
                try{Thread.sleep(10); } catch(Exception e) {}
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
