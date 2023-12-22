import hsa.Console; // or import hsa.*;
import hsa.Message;
import java.awt.*;
import sun.audio.*;
import java.io.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class Instructions {
    AudioStream as;
    int choice = 0;
    private Console c;

    public Instructions(Console con) {
        c = con;
    }

    public void delay() {
        try {
            Thread.sleep(220);
        } catch (Exception e) {}
    }
    public void instr() {
        boolean exit = false;
        try {
            BufferedImage menu_bg = ImageIO.read(new File("menu.png"));
            c.drawImage(menu_bg, 0, 0, null);
        } catch (FileNotFoundException fnf) {
            new Message("File Not Found", "Error");
        } catch (IOException ioe) {
            new Message("Error reading file", "Error");
        } catch (Exception e) {
            new Message("Fatal error", "Error");
        }
        //while(
    }
    public void run() {
        
    }
}
