/*
* Game class (level 3) for Bicycle Safety Game
* 2024-01-12
* Justin Jiang and Tsz Fei Wang
* ICS3UP
*/
import hsa.Console;
import java.awt.*;
import java.io.*;
import java.util.*;
import javax.imageio.*;
import hsa.Message;

public class Game {
    /*
    * ------------------------------------------------------------------------------------
    * Type             | Name          | Description
    * int              | correct       | number of questions the user got correct
    * int              | checkTime     | stores the time in seconds the user took to complete the game
    * String           | username      | stores the useres username
    * char             | saveScore     | stores the users choice in whether or not to save their score (on the leaderboard)
    * Color            | road          | color of the road (gray)
    * Color            | curb          | color of the sidewalk (lighter gray)
    * Color            | green         | color of the grass (green)
    * ------------------------------------------------------------------------------------
    */
    private Console c;
    int correct = 0;
    int checkTime = 0;
    String username = "";
    char saveScore = ' '; 
    Color road = new Color(105, 105, 105);
    Color curb = new Color(162, 162, 161);
    Color lamp_glow = new Color(255, 255, 10, 150);
    Color green = new Color(30, 200, 30);
    
    //constructor
    public Game(Console con) {
	c = con;
    }
    
    //convenience function for pausing the program for a specified amount of time
    //made by: Justin
    public void delay(int ms) {
	try {
	    Thread.sleep(ms);
	} catch (Exception e) {}
    }
    
    //'fancily' prints a string one character at a time
    //made by: Justin
    public void fancyprint(String s1, int x, int y, int speed) {
	for (int i = 0; i <= s1.length(); i++) {
	    c.drawString(s1.substring(0, i), x, y);
	    delay(speed);
	}
    }
    
    //draws the bicycle 
    //made by: Fei  
    public void drawBike(int direction, int y) {
	try {
	    if(direction == 1) {
		Image cycleRight = ImageIO.read(new File("cycleRight2.jpg"));
		cycleRight = cycleRight.getScaledInstance(100, 50, cycleRight.SCALE_DEFAULT);
		c.drawImage(cycleRight, 500, 520 + y, null);
	    } 
	    if(direction == 2) {
		Image cycleUp = ImageIO.read(new File("cycleUp2.jpg"));
		cycleUp = cycleUp.getScaledInstance(50, 100, cycleUp.SCALE_DEFAULT);
		c.drawImage(cycleUp, 500, 520 + y, null);
	    } 
	    if(direction == 3) {
		Image cycleDown = ImageIO.read(new File("cycleDown2.jpg"));
		cycleDown = cycleDown.getScaledInstance(50, 100, cycleDown.SCALE_DEFAULT);
		c.drawImage(cycleDown, 500, 520 + y, null);
	    } 
	} catch (IOException ioe) {}
    }
    
    //cene of first question inside the house 
    public void house() {
	Image houseDoor;
	c.setColor(new Color(91, 46, 13));
	c.fillRect(0, 0, 1024, 760);
	try {
	    houseDoor = ImageIO.read(new File("houseq1.jpg"));
	    c.drawImage(houseDoor, 0, 0, null);
	} catch (FileNotFoundException fnf) {
	    new Message("Image file not found", "Error!");
	} catch (IOException ioe) {
	    new Message("File Error", "Error!");
	} catch (Exception e) {
	    new Message("Unknown Error", "Error!");
	}

	c.setColor(new Color(91, 46, 13));
	c.fillRect(0, 0, 1024, 60);
	Font f = new Font("Consolas", 0, 30);
	c.setFont(f);
	c.setColor(new Color(255, 20, 20));
	fancyprint("Press any key to continue...", 280, 40, 20);

	c.getChar();
	c.setColor(new Color(91, 46, 13));
	c.fillRect(0, 0, 1024, 760);

	try {
	    Image houseQuestion = ImageIO.read(new File("selected0.jpg"));
	    c.drawImage(houseQuestion, 0, 0, null);
	} catch (FileNotFoundException fnf) {
	    new Message("Image file not found", "Error!");
	} catch (IOException ioe) {
	    new Message("File Error", "Error!");
	} catch (Exception e) {
	    new Message("Unknown Error", "Error!");
	}

	c.setColor(Color.red);
	int choice = 0;
	int chosens = 0;
	int[] chosen = new int[3];

	Image[] images = new Image[7];
	try { //preloading images into an array
	    for (int i = 0; i < 7; i++) {
		images[i] = ImageIO.read(new File("selected" + i + ".jpg"));
	    }
	} catch (FileNotFoundException fnf) {
	    new Message("Image file not found", "Error!");
	} catch (IOException ioe) {
	    new Message("File Error", "Error!");
	} catch (Exception e) {
	    new Message("Unknown Error", "Error!");
	}

	while (chosens < 3) {
	    if (c.isCharAvail()) {
		switch (c.getChar()) {
		case 'a':
		case 'h':
		    if (choice > 0) choice--;
		    break;
		case 'd':
		case 'l':
		    if (choice < 6) choice++;
		    break;
		default:
		    break;
		case '\n':
		    chosen[chosens] = choice;
		    chosens++;
		    if(choice == 0) correct++; 
		    break;
		}
		c.drawImage(images[choice], 0, 0, null);
	    }
	}
	c.clear();
	try {
	    Image houseimage = ImageIO.read(new File("houseq1.jpg"));
	    c.drawImage(houseimage, 0, 0, null);
	} catch (FileNotFoundException fnf) {
	    new Message("Image file not found", "Error!");
	} catch (IOException ioe) {
	    new Message("File Error", "Error!");
	} catch (Exception e) {
	    new Message("Unknown Error", "Error!");
	}
	c.setColor(new Color(189,224,254));
	c.fillRect(0, 0, 1024, 1000);
	
	c.setColor(Color.black);
	fancyprint("Alright, now we're ready to go", 270, 360, 20);
	fancyprint("Press any key to continue...", 280, 405, 20);
    }

    //animation for bicycle on the road 
    //made by: Fei and Justin
    public void game() {
      
	int x = 0;
	try { 
	    Image road = ImageIO.read(new File("Road.jpg"));
	    Image end = ImageIO.read(new File("sadBlahaj.jpg")); 
	    Image sign1 = ImageIO.read(new File("warning pedestrians.jpg"));
	    Image sign2 = ImageIO.read(new File("no right turns.jpg"));
	    Image sign3 = ImageIO.read(new File("no bicycles allowed.jpg"));
	    Image sign4 = ImageIO.read(new File("yield.jpg"));
	    Image sign5 = ImageIO.read(new File("do not enter.jpg"));
	    Image sign6 = ImageIO.read(new File("bicycles only.jpg"));
	    Image crosswalk = ImageIO.read(new File("crosswalk.jpg")); 
	    
	    /* 
	    code for changing size of image from https://stackoverflow.com/questions/5895829/resizing-image-in-java
	    */
	    sign1 = sign1.getScaledInstance(80, 80, sign1.SCALE_DEFAULT);
	    sign2 = sign2.getScaledInstance(80, 80, sign2.SCALE_DEFAULT);
	    sign3 = sign3.getScaledInstance(80, 80, sign3.SCALE_DEFAULT);
	    sign4 = sign4.getScaledInstance(80, 80, sign4.SCALE_DEFAULT);
	    sign5 = sign5.getScaledInstance(80, 80, sign5.SCALE_DEFAULT);
	    sign6 = sign6.getScaledInstance(80, 80, sign6.SCALE_DEFAULT);
	    crosswalk = crosswalk.getScaledInstance(300, 454, crosswalk.SCALE_DEFAULT);
	    c.drawImage(road, 0, 0, null);
	    
	    Input i = new Input(c);
	    Timer t = new Timer(c);

	    i.start();
	    int bikeY = 0;
	    while(true) {
		//if times up
		if (t.timeOver()) break;
		char ch = i.getChar();
		if (ch == 'd' || ch == 'D') {
		    c.drawImage(road, x % 1024 - 1024, 0, null);
		    c.drawImage(road, x % 1024, 0, null);
		    c.drawImage(road, x%1024 + 1024, 0, null);
		    drawBike(1, bikeY);
		    x -= 10;
		}
		else if (ch == 'a' || ch == 'D') {
		    c.drawImage(road, x % 1024 - 1024, 0, null);
		    c.drawImage(road, x % 1024, 0, null);
		    c.drawImage(road, x%1024 + 1024, 0, null);
		    drawBike(1, bikeY);
		    x += 1;
		}
		else if(ch == 'w' || ch == 'W') {
		    c.drawImage(road, x % 1024 - 1024, 0, null);
		    c.drawImage(road, x % 1024, 0, null);
		    c.drawImage(road, x%1024 + 1024, 0, null);
		    bikeY-=3;
		    drawBike(2, bikeY);
		}
		else if(ch == 's' || ch == 'S') {
		    c.drawImage(road, x % 1024 - 1024, 0, null);
		    c.drawImage(road, x % 1024, 0, null);
		    c.drawImage(road, x%1024 + 1024, 0, null);
		    bikeY+=3;
		    drawBike(3, bikeY);
		}
		else if (ch == '\n') {
		    break;
		}
		i.setChar((char)0); //setting to null character (ASCII \0x0000) Source: https://www.asciitable.com/
		
		//each sign starts at 750, decreases as x decreases
		if( x <= -5120) {
		    c.drawImage(sign6, 1024+x+5120, 680, null); 
		}
		
		else if(x <= -4096) c.drawImage(sign5, 1024+x+4096, 680, null);
		else if(x <= -3072) c.drawImage(sign4, 1024+x+3072, 680, null);
		else if(x <= -2048) c.drawImage(sign3, 1024+x+2048, 680, null);
		else if(x <= -1024) {
		    c.drawImage(sign2, 2048+x, 680, null);
		    c.setColor(new Color(105, 105, 105));
		    c.fillRect(2148 + x, 600, 400, 200);
		    if(x < -1500 && x > -1900) {
			if(bikeY > 20) {//insert fail condition here for array
			    new Message("You went into the turn", "Fail");
			    bikeY = 0; 
			    drawBike(1, bikeY);
			}
		    }
		    
		}
		else if(x <= 0) {
		    c.drawImage(sign1, 1024+x, 680, null);
		    c.drawImage(crosswalk, 1024+x+5120+60, 680, null); 
		}
		    
		t.timer(); 
		System.out.println(x + " " + bikeY);
		try {Thread.sleep(50);} catch(Exception e) {}
		checkTime += 50; 
		if(checkTime%1000 == 0) t.time--;
		
	    }     
	    i.stop();
	    c.drawImage(end, 0, 0, null);
	    c.getChar(); 
	}
	catch(IOException e) {}
    }
    
    //shows user their score and time elapsed, saves their username 
    //made by: Fei
    public void saveUser() {
	try {
	    Image results = ImageIO.read(new File("results.jpg"));
	    c.drawImage(results, 0, 0, null);
	    c.setFont(new Font("Arial", 0, 54));
	    String userScore;

	    if (correct == 0) userScore = "0000";
	    else userScore = (1000 * correct - (checkTime - 300) / 10) + "";
	    String timeTaken = checkTime + "";

	    c.drawString(userScore, 580, 300);
	    c.drawString(timeTaken, 640, 395);

	    c.setFont(new Font("Arial", 0, 32));

	    while (true) {
		char ch = c.getChar();
		if (ch == '\n' && username.length() >= 1) break;
		if (ch == 8) {
		    if (username.length() == 0) {
			new Message("There are no characters to delete.", "Error");
			continue;
		    } else {
			username = username.substring(0, username.length() - 1);
			c.setColor(new Color(255, 177, 121));
			c.fillRect(500, 420, 350, 100);
			c.setColor(Color.black);
			c.drawString(username, 500, 478);
			continue;
		    }
		}

		while (!Character.isLetterOrDigit(ch)) {
		    new Message("Please use alphanumerical characters.", "Error!");
		    ch = c.getChar();
		}

		while (ch == '\n' && username.length() < 1) {
		    new Message("Username too short!", "Error!");
		    ch = c.getChar();
		}

		while (username.length() == 20) {
		    new Message("Username has reached maximum length.", "Error!");
		    ch = c.getChar();
		}

		if (ch != 8 && ch != '\n') username += ch;
		c.setColor(new Color(255, 177, 121));
		c.fillRect(500, 420, 350, 100);
		c.setColor(Color.black);
		c.drawString(username, 500, 478);
	    }

	    saveScore = c.getChar();
	} catch (FileNotFoundException fnf) {
	    new Message("File Not Found", "Error!");
	} catch (IOException ioe) {
	    new Message("File Error", "Error!");
	}
    }

    public String getUsername() {
	return username;
    }

    public int getNumCorrect() {
	return correct;
    }

    public int getTime() {
	return checkTime;
    }

    public void run() {
	//house();
	game();
	saveUser();
	saveUser();
    }
 
}
