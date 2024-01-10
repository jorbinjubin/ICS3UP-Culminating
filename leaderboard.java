import java.awt.*;
import hsa.*;
import java.io.*; 
import java.awt.image.*;
import javax.imageio.*;

public class Leaderboard {
    Console c;     
    public Leaderboard (Console con) {
        c = con;
    }
    
    public void saveUserScore(String user, int correct, long time) {
        try {
             
            BufferedReader br = new BufferedReader(new FileReader("highscores.txt")); 
            String line; 
            int[] scores = new int[10]; 
            int[] names = new int[10]; 
            String written; 
            
            int score = 1000*correct - (time - 60)/10;
            
            for(int i = 0; i < 10; i++) {
                line = br.readLine(); 
                if(line == null) {
                    line = "unknown,0000"; 
                }
                names[i] = line.substring(0, line.indexOf(",")); 
                scores[i] = line.substring(line.indexOf(",")+1); 
            }
            
            for(int i = 0; i < 10; i++) {
                if(score > scores[i]) {
                    for(int j = 9; j >= i; j--) {
                        scores[j] = scores[j-1];
                        names[j] = names[j-1];
                    }
                    scores[i] = score; 
                    names[i] = user;
                    break; 
                }
            }
            
            for(int i = 0; i < 10; i++) {
                written = names[i] + "," + scores[i]
                br.println(written);
            }
            
            br.close()
        }
        catch (FileNotFoundException e) {
            new Message("File Not Found", "Error!"); 
        }
        catch (IOException ioe) {
            new Message("Failed to read from file", "Error!");
        }
        catch (Exception e) {
            new Message("An unknown error occured", "Error!"_;
        }
    }
}
