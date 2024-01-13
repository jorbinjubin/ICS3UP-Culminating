import hsa.Console;
import java.awt.*;
import java.io.*;
import java.util.*;
import javax.imageio.*;
import hsa.Message;

public class Game {
    private Console c;
    int score = 0;
    int time = 0;
    Console debug = new Console("Debugging Window");
    public void delay(int ms) {
	try {
	    Thread.sleep(ms);
	} catch (Exception e) {}
    }
    public void fancyprint(String s1, int x, int y, int speed) {
	for (int i = 0; i <= s1.length(); i++) {
	    c.drawString(s1.substring(0, i), x, y);
	    delay(speed);
	}
    }

    public Game() {
	//public Game(Console con) {
	//c = con;
	c = new Console(38, 128, "a Safety");
    }
    Color road = new Color(105, 105, 105);
    Color curb = new Color(162, 162, 161);
    Color lamp_glow = new Color(255, 255, 10, 150);
    Color green = new Color(30, 200, 30);
    public void drawRoad() {
	c.setColor(green);
	c.fillRect(0, 0, 1024, 760);
	c.setColor(road);
	c.fillRect(0, 200, 1024, 400);
	c.setColor(curb);
	c.fillRect(0, 157, 1024, 43);
    }

    public void drawLight(int x) {
	try {
	    Image lightTop = ImageIO.read(new File("StreetLampTop.jpeg"));
	    Image lightBot = ImageIO.read(new File("StreetLampBottom.jpeg"));
	    c.drawImage(lightTop, x + 30, 94, null);
	} catch (IOException ioe) {}
    }

    public void drawHydrant(int x) {

    }

    public void drawSign(int num) {
	Image[] signs = {};

    }

    public void house() {
	Image houseDoor;
	c.setColor(new Color(91, 46, 13));
	c.fillRect(0, 0, 1024, 760);
	try {
	    houseDoor = ImageIO.read(new File("house.jpg"));
	    c.drawImage(houseDoor, 0, 0, null);
	} catch (FileNotFoundException fnf) {
	    new Message("Image file not found", "Error!");
	} catch (IOException ioe) {
	    new Message("File Error", "Error!");
	} catch (Exception e) {
	    new Message("Unknown Error", "Error!");
	}

	c.setColor(new Color(91, 46, 13));
	c.fillRect(0, 0, 1024, 100);
	Font f = new Font("Consolas", 0, 30);
	c.setFont(f);
	c.setColor(new Color(255, 20, 20));
	fancyprint("Press any key to continue...", 280, 250, 20);

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
		    break;
		}
		c.drawImage(images[choice], 0, 0, null);
	    }
	}
	c.clear();
	try {
	    Image houseimage = ImageIO.read(new File("house.jpg"));
	    c.drawImage(houseimage, 0, 0, null);
	} catch (FileNotFoundException fnf) {
	    new Message("Image file not found", "Error!");
	} catch (IOException ioe) {
	    new Message("File Error", "Error!");
	} catch (Exception e) {
	    new Message("Unknown Error", "Error!");
	}
	c.setColor(new Color(91, 46, 13));
	c.fillRect(0, 0, 1024, 100);
	
	
	fancyprint("Alright, now we're ready to go", 270, 230, 20);
	fancyprint("Press any key to continue...", 280, 255, 20);
    }
    public void drawBike() {
	try {
	    Image cycleRight = ImageIO.read(new File("Bike_ride.jpeg"));
	    cycleRight = cycleRight.getScaledInstance(100, 50, cycleRight.SCALE_DEFAULT);
	    c.drawImage(cycleRight, 500, 520, null);
	} catch (IOException ioe) {}
    }

    public void anim() {
	house();
	c.getChar();
	int globalX = 1024;
	char ch = ' ';
	double delta = 0;
	while (true) {
	    if (c.isCharAvail()) ch = c.getChar();
	    else {
		if (Math.abs(0 - delta) < 0.3) delta = 0; //this just checks if the speed is close enough to zero and stops it.
		if (delta != 0) { //Slowly slows down because gameplay.
		    if (delta > 0) delta -= delta * 0.2;
		    if (delta < 0) delta += delta * -0.3;
		}
	    }
	    if (ch == 'o') break;
	    if (ch == 'd') delta += 3;
	    if (ch == 'a') delta -= 3;
	    if (delta > 10) delta = 10;
	    if (delta < -5) delta = -5;
	    globalX -= delta;
	    drawRoad();
	    drawBike();
	    debug.println(delta);
	    drawLight((int) globalX);
	    drawLight((int) globalX + 300);
	    drawLight((int) globalX + 600);
	    drawLight((int) globalX + 900);
	    drawLight((int) globalX + 1200);
	    drawLight((int) globalX + 1500);
	    ch = ' ';
	    try {
		Thread.sleep(48);
	    } catch (Exception e) {}
	    if (c.isCharAvail()) ch = c.getChar();

	}
	c.clear();
	c.println("dieded");
    }

    public void saveUser() {
	try {
	    Image results = ImageIO.read(new File("results.jpg"));
	    c.drawImage(results, 0, 0, null);
	    c.setFont(new Font("Times New Roman", 0, 32));
	    String userScore = score + "";
	    String timeTaken = time / 1000 + "";
	    String username = "";

	    c.drawString(userScore, 600, 290);
	    c.drawString(timeTaken, 600, 390);

	    c.setFont(new Font("Times New Roman", 0, 24));
	    while (true) {
		char ch = c.getChar();
		if (ch == '\n') break;
		if (!Character.isLetterOrDigit(ch)) throw new Exception();
		else username += ch;
		c.drawString(username, 600, 500);
	    }
	} catch (IOException e) {} catch (Exception e) {}
    }

    public static void main(String[] args) {
	Game g = new Game();
	g.anim();
    }
}
