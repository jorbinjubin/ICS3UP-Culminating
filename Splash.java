import java.awt.*;
import hsa.Console;
import java.io.*; 
import java.awt.image.*;
import javax.imageio.*;

public class Splash {
  Console c; 
  public void drawCycles() {
        try { // imports image
            BufferedImage cycles = ImageIO.read (new File("cycles.jpg"));
            BufferedImage menuBackground = ImageIO.read (new File("Splash screen background.jpg"));
            c.drawImage(menuBackground, 0, 0, null);
            
            cycles = BufferedImage.getScaledInstance(1024, 768, cycles.SCALE_DEFAULT);
            for(int i = 0; i < 600; i++) {
                c.drawImage(cycles, 0, 600-i, null);
                c.drawImage(menuBackground, 0, 0, null);
                try{Thread.sleep(20); } catch(Exception e) {}
            }
        }
        catch (IOException e) { }

}
