import java.awt.*;
import hsa.*;
import java.io.*; 
import java.awt.image.*;
import javax.imageio.*;

public class Maze {
    Console c;  
    int score = 0;   
    Font f = new Font("Arial", 1, 54); 
     
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
            cycleUp = cycleUp.getScaledInstance(50, 20, cycleUp.SCALE_DEFAULT);
            c.drawImage(mazeMap, 0, 0, null);
            for(int i = 0; i < 20; i++) {
                c.drawImage(cycleUp, 20, 300-i, null); 
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
