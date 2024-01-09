import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
public class KeyInput implements KeyListener { 
    /*
    * Takes heavy inspiration and mostly based on this Stack
    overflow post
    * https://stackoverflow.com/questions/13042504/keypressed-event-in-java
    * Specifically the response from Jake Stoeffler
    */
    private int scn;
    public KeyInput(int scene) {
	scn = scene;
	Menu m = new Menu;
	Game g = new Game;
    }
    
    public void keyTyped(KeyEvent e) {
	// Invoked when a key has been typed.
    }

    public void keyPressed(KeyEvent e) {
	// Invoked when a key has been pressed.
	switch(scn) {
	    case 1:
	    case 2:
	    if (e.getKeyCode() == KeyEvent.VK_W || e.getKeyCode() == KeyEvent.VK_K) {
		
	    }
	    break;
	    case 3:
	    if (e.getKeyCode() == KeyEvent.VK_ACCEPT) {
		
	    }
	}
    }

    public void keyReleased(KeyEvent e) {
	// Invoked when a key has been released.
    }
}
