import java.awt.*;
import hsa.*;
import java.io.*; 
import java.awt.image.*;
import javax.imageio.*;

public class Splash{
    Console c;     
    public Splash (Console con) {
        c = con;
    }
    
    public void drawCycles() {
        try { 
            Image stripes = ImageIO.read (new File("stripes.jpg"));
            Image title = ImageIO.read (new File("title.jpg"));
            Image cycles = ImageIO.read(new File("cycles.jpg")); 
            Image newScreen = ImageIO.read(new File("continue.jpg"));
            stripes = stripes.getScaledInstance(1024, 768, stripes.SCALE_DEFAULT);
            title = title.getScaledInstance(605, 354, title.SCALE_DEFAULT);
            cycles = cycles.getScaledInstance(1020, 200, cycles.SCALE_DEFAULT);
            newScreen = newScreen.getScaledInstance(1024, 768, newScreen.SCALE_DEFAULT);
            
            c.drawImage(stripes, 0, 0, null);
            c.drawImage(title, 210, 40, null);
            
            for(int i = 0; i < 160; i++) {
                c.drawImage(cycles, 1, 600-5*i, null);
                c.drawImage(title, 210, 40, null);
                try{Thread.sleep(50); } catch(Exception e) {} 
            }
            
            c.drawImage(newScreen, 0, 0, null);
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
        drawCycles();
    }
}
