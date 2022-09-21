package dothunter;

import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) throws SoundException {
        Scanner s = new Scanner(System.in); // this is scanner class "s" Scanner classis object
        Hunter hunter = new Hunter("Hirusha", "Black"); // call and values pass Hunter class agument constructor 
        Soldier threeSoldier[] = {new BlueSoldier(), new BlueSoldier(), new RedSoldier()}; // refernce claas is Soldier . threeSoldier is a object array .

        Board board = new Board("superDot", hunter, threeSoldier); // call and values pass Board class agument constructor
        System.out.println("Use the keyboard up,down,left,right arrow keys to move the hunter");
        hunter.setxPOS(s.nextInt()); //call setxPOS method and pass keyboard input to argument
        hunter.setyPOS(s.nextInt()); //call setyPOS method and pass keyboard input to argument
        hunter.move(hunter); //call move method 
        hunter.hunt(board);  //call hunt method
        threeSoldier[2].hunt();
    }

}
