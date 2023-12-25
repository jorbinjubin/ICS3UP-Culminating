import java.awt.*;
import hsa.*;
import java.io.*; 
import java.awt.image.*;
import javax.imageio.*;
import java.awt.image.BufferedImage;

public class Instructions {
    Console c;     
    public Instructions (Console con) {
        c = con;
    }
    
    public void instruct1() {
        try { 
            BufferedImage instruct = ImageIO.read (new File("instruct.jpg"));
            char ch; 
            String t; 
            
            Font f = new Font("Arial", 1, 54); 
            Color pink = new Color(255,180,221); 
            c.setFont(f); 
            c.setColor(Color.black); 
            
            c.drawImage(instruct, 0, 0, null);
            ch = c.getChar(); 
            ch = Character.toUpperCase(ch);
            while(ch == 'W' || ch == 'A' || ch == 'S' || ch == 'D') {
                t = ch + ""; 
                c.setColor(Color.black); 
                c.drawString(t, 140, 560); 
                
                ch = c.getChar(); 
                ch = Character.toUpperCase(ch);
                
                c.setColor(pink); 
                c.fillRect(135, 520, 60, 60); 
            }
        }
        catch (FileNotFoundException fnf) {
            new Message("File Not Found","error");
        }
        catch(IOException ioe) {
            new Message("Error reading file", "error");
        }
    }
    
    public void instruct2() {
        try { 
            BufferedImage instruct2 = ImageIO.read (new File("learning.jpg"));
            c.drawImage(instruct2, 0, 0, null);   
        }
        catch (FileNotFoundException fnf) {
            new Message("File Not Found","error");
        }
        catch(IOException ioe) {
            new Message("Error reading file", "error");
        }
        c.getChar();
    }
    
    public void instruct3() {
        try { 
            BufferedImage instruct3 = ImageIO.read (new File("testing.jpg"));
            c.drawImage(instruct3, 0, 0, null);   
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
        instruct1();
        instruct2();
        instruct3();
    }
}
