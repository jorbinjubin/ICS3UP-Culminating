/* 
 * Takes user input without pausing the timer in game class 
 * Tsz Fei Wang
 * Teacher: Ms. Krasteva
 * January 14th, 2023
 * 
 * Suggestion and idea from Eric Ning
 */
 
import hsa.Console;

public class Input extends Thread {
    /* Variable Declaration
     */
    private char ch;
    private Console c;
    
    //Constructor
    public Input(Console con) {
	c = con;
    }

    //returns the users character input 
    public char getChar() {
	return ch;
    }
    
    //looks for keyboard input once thread is started
    public void readChar() {
	while(true) {
	    ch = c.getChar(); 
	}
    }
    
    //sets the read character to something else so that if the user presses
    //a key once, it won't be treated like they're holding it down 
    public void setChar(char x) {
	ch = x;
    }
    
    //runs readChar to continuously take user input 
    public void run() {
	readChar();
    }
}
