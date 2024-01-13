import java.awt.*;
import hsa.*;
import java.io.*; 
import java.awt.image.*;
import javax.imageio.*;

public class Leaderboard {
    Console c;   
    int[] scores = new int[10]; 
    String[] names = new String[10]; 
    String user; int correct; int time; 
    
    public Leaderboard (Console con) {
        c = con;
    }
    
    public void getInfo() {
        Game g = new Game(c); 
        user = g.getUsername();
        correct =  g.getNumCorrect();
        time = g.getTime();
    }
    
    public void calculateLeaderboard() {
        try {
            BufferedReader br = new BufferedReader (new FileReader("highscores.txt")); 
            String line; 
            String temp;
            int score = 1000*correct - (time - 30000)/10000;
            getInfo(); 
            
            for(int i = 0; i < 10; i++) {
                line = br.readLine(); 
                if(line.equals(null)) {
                    line = "unknown,0000"; 
                }
                names[i] = line.substring(0, line.indexOf(",")); 
                temp = line.substring(line.indexOf(",")+1);
                if(temp.equals("----")) temp = "0"; 
                scores[i] = Integer.parseInt(temp); 
            }
            
            for(int i = 0; i < 10; i++) {
                if(score > scores[i]) {
                    for(int j = 9; j > i; j--) {
                        scores[j] = scores[j-1];
                        names[j] = names[j-1];
                    }
                    scores[i] = score; 
                    names[i] = user;
                    break; 
                }
            }
        }
        catch (FileNotFoundException e) {
            new Message("File Not Found", "Error!"); 
        }
        catch (IOException ioe) {
            new Message("File Error", "Error!");
        }
        catch (Exception e) {
            new Message("Unknown error", "Error!");
        }
    }
    
    public void writeScore() throws IOException {
        try { 
            String line; 
            PrintWriter pw = new PrintWriter(new FileWriter("highscores.txt")); 
            for(int i = 0; i < 10; i++) {
                if(scores[i] == 0) line = names[i] + ",----"; 
                else line = names[i] + "," + scores[i];
                pw.println(line);
            }
            pw.close();
        }
        catch (FileNotFoundException e) {
            new Message("File Not Found", "Error!"); 
        }
        catch (IOException ioe) {
            new Message("File Error", "Error!");
        }
        catch (Exception e) {
            new Message("Unknown error", "Error!");
        }
    }
    
    public void drawLB() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("highscores.txt"));
            Image leaderboard = ImageIO.read(new File("leaderboard.jpg")); 
            String[][] scores = new String[2][10];
            String[] temp = new String[2];
            int digits; 
            
            c.setFont(new Font("Arial", 1, 32)); 
            c.setColor(Color.black);
            c.drawImage(leaderboard, 0, 0, null); 
            
            for(int i = 0; i < 10; i++) {   
                temp = br.readLine().split(",");
                scores[0][i] = temp[0];
                scores[1][i] = temp[1];
                digits = temp[1].length();
                while(digits < 4) { temp[1] = "0" + temp[1]; digits++; }  
                if(i==9) c.drawString((i+1)+". ", 215, 240+46*i); 
                else c.drawString((i+1)+". ", 230, 240+46*i); 
                c.drawString(temp[0], 270, 240+46*i); 
                c.drawString(temp[1], 700, 240+46*i); 
            }
        }
        catch(FileNotFoundException fnf) {
            new Message("File Not Found", "Error!");
        }
        catch(IOException ioe) {
            new Message("File Error");
        }
    }
    
    public void run() {
        drawLB();
        //calculateLeaderboard();
        //writeScore();
    }
}
