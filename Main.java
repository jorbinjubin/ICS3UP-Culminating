import java.io.*;
import hsa.Console;
import hsa.Message;
import java.util.*;

public class Main {
    Console c;
    int menuChoice = 0;
    public Menu m;
    public Main() {
        c = new Console(38,128,"Bicycle Safety"); //1024 by 760
    }
    
    public void menu() {
        m = new Menu(c);
        m.run();
    }
    public void instr() {
        c.clear();
        c.println("entered instructions");
        c.getChar();
    }
    public void play() {
        c.clear();
        c.println("entered play");
        c.getChar();
    }
    public void lb() {
        c.clear();
        c.println("entered leaderboard");
        c.getChar();
    }
    
    public static void main(String[] args) {
        Main z = new Main();
        while(true) {
            z.menu();
            if(Menu.hasChosen) {
                if(Menu.choice == 0) z.instr();
                else if(Menu.choice == 1) z.play();
                else if(Menu.choice == 2) z.lb();
                //exit is covered in menu();
            }
            Menu.hasChosen = false;
        }
    }        
}
