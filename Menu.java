import hsa.Console; // or import hsa.*;
import hsa.Message;
import java.awt.*;
import sun.audio.*;
import java.io.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class Menu {
    AudioStream as;
    int choice = 0;
    private Console c;
    boolean hasChosen = false;
    public Menu(Console con) {
        c = con;
    }
    
    //Getter method because java.
    public int getChoice() {
        return choice;
    }
    //Getter and setter methods for hasChosen
    public boolean getHasChosen() {
        return hasChosen;
    }
    public void setHasChosen(boolean b) {
        hasChosen = b;
    }
    
    public void delay() {
        try {
            Thread.sleep(220);
        } catch (Exception e) {}
    }
    
    private void drawOutline(int n) {
        c.setColor(new Color(150, 150, 150));
        for(int i = 0; i < 10; i++) {
            c.drawRect(0+i, 149+152*n+i, 1024-2*i, 160-2*i); // grrrrr
        }
    }
    
    public void menuSelect() {
        while (!hasChosen) {
            if (c.isCharAvail()) {
                switch (c.getChar()) {
                case 'j':
                case 's':
                    if (choice < 3) {
                        choice++;
                        try {
                            as = new AudioStream(new FileInputStream("button.wav"));
                        } catch (Exception e) {}
                        AudioPlayer.player.start(as);
                    }
                    break;
                case 'k':
                case 'w':
                    if(choice > 0) {
                        choice--;
                        try {
                            as = new AudioStream(new FileInputStream("button.wav"));
                        } catch (Exception e) {}
                        AudioPlayer.player.start(as);
                    }
                    break;
                case '\n':
                    hasChosen = true;
                    break;
                default:
                    break;
                }
            }
            
            try {
                BufferedImage menu_bg = ImageIO.read(new File("menu.jpg"));
                c.drawImage(menu_bg, 0, 0, null);
            } catch (FileNotFoundException fnf) {
                new Message("File Not Found", "Error");
            } catch (IOException ioe) {
                new Message("Error reading file", "Error");
            }
            drawOutline(choice);
        }
    }
    public void run() {
        menuSelect();
    }
}
