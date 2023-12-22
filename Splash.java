import java.awt.*;
import hsa.*;
import java.io.*; 
import java.awt.image.*;
import javax.imageio.*;

public class Splash{
    Console c;     
    public Splash () {
        c = new Console(38, 128); 
    }
    
    public void drawCycles() {
        try { 
            Image stripes = ImageIO.read (new File("stripes.jpg"));
            Image title = ImageIO.read (new File("title.jpg"));
            Image cycles = ImageIO.read(new File("cycles.jpg")); 
            Image newScreen = ImageIO.read(new File("continue.jpg"));
            stripes = stripes.getScaledInstance(1024, 768, stripes.SCALE_DEFAULT);
            title = title.getScaledInstance(605, 354, title.SCALE_DEFAULT);
            cycles = cycles.getScaledInstance(1020, 200, stripes.SCALE_DEFAULT);
            
            c.drawImage(stripes, 0, 0, null);
            c.drawImage(title, 210, 40, null);
            
            for(int i = 0; i < 160; i++) {
                c.drawImage(cycles, 5, 600-5*i, null);
                c.drawImage(title, 210, 40, null);
                try{Thread.sleep(50); } catch(Exception e) {} 
            }
        }
        catch (FileNotFoundException fnf) {
            new Message("oh noes","error");
        }
        catch(IOException ioe) {
            new Message("farty warty", "error");
        }
        
        c.setColor(Color.white);
        Font f = new Font("Anonymous Pro", 0, 32); 
        c.setFont(f);
        c.drawString("Press any key to continue", 100, 400); 
    }
    public static void main(String[] args) {
        Splash s = new Splash(); 
        s.drawCycles(); 
    }
}
