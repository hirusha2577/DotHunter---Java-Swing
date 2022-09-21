package dothunter;

import java.util.Random;
import java.util.Scanner;

public class Board implements interfaceBoard {  //implements keyword is used to implement an interface

    private String superDot;
    private Hunter hunter;
    private Soldier soldier[];


    private int xAxisRandom;
    private int yAxisRandom;
    
    private int DeletexAxis;
    private int  DeleteyAxis;

    private int hunterDotcount = 0;
    private int hunterSuperDotCount = 0;
    private int hunterSoldierCount = 0;

    private int myDotcount = 0;
    private int mysuperDotCount = 0;
    private int mySoldierCount = 0;

    String boarddot[][] = new String[360][250];
    String boardsoldier[][] = new String[360][250];

    private String[][] maze = new String[360][250]; // maze is two dimensional array

    private String SoldierType[] = {"BlueSoldier", "GreenSoldier", "RedSoldier"}; // one D array 

    Random random = new Random(); // Random class "java.util.Random"
    Scanner s = new Scanner(System.in); // Scanner class

    Board() {
        //default constructor
    }

    Board(String superDot, Hunter hunter, Soldier soldier[]) throws SoundException { //overloded constructor

        this.superDot = superDot;
        this.hunter = hunter;
        this.soldier = soldier;
        
        

       

        //place maze to dots and superDots
        for (int x = 0; x < 100; x++) {
            init();
            if (yAxisRandom == 0 && xAxisRandom == 0) { // dot or superDot cant axis 0,0 position
                init(); // call  iniit metho to genarate 2 random numbers
            } else {
                if (mysuperDotCount < 3) {
                    init();
                    maze[yAxisRandom][xAxisRandom] = this.superDot.toLowerCase(); // all String convert to lower case
                    boarddot[yAxisRandom][xAxisRandom] = this.superDot.toLowerCase();
                    init(); // call  iniit metho to genarate 2 random numbers
                    mysuperDotCount = mysuperDotCount + 1; // mysuperDotCount increment
                } else {
                    if (maze[yAxisRandom][xAxisRandom] == null) { // check the null if postion is  null spech and place it
                        maze[yAxisRandom][xAxisRandom] = "dot";
                        boarddot[yAxisRandom][xAxisRandom] = "dot";
                        myDotcount = myDotcount + 1;  // used for testing
                        init(); // call  iniit metho to genarate 2 random numbers
                    } else {
                        init(); // call  iniit metho to genarate 2 random numbers
                    }

                }

            }
        }

        this.movesoldier(); // movesoldier method use place soldier and randomly move to soldier

        maze[this.hunter.getyAxis()][this.hunter.getxAxis()] = "hunter"; // program start hunter postion is 0,0

        System.out.println("Board is ready and three soldiers and the hunter is positioned in the board"); //output

//        for (int y = 0; y < 360; y++) {           //    use fot testing********************************
//            for (int x = 0; x < 250; x++) {
//
//                if (maze[y][x] == null) {
//                    continue;
//                } else {
//                    System.out.println("x:" + x + "  " + "y:" + y + "      " + maze[y][x]);
//
//                }
//
//            }
//        }
//        System.out.println("dot             " + myDotcount);
//        System.out.println("superDot        " + mysuperDotCount);
//        System.out.println("All dot         " + (myDotcount + mysuperDotCount));
//        System.out.println("Soilder         " + mySoldierCount);
//        System.out.println("x:" + this.hunter.getxAxis() + "  " + "y:" + this.hunter.getyAxis() + "  Hunter postion         " + maze[this.hunter.getyAxis()][this.hunter.getxAxis()]);
        // this.movehunter();
    }

    public void movehunter() throws SoundException {

       // System.out.println("Hunter is moveing ,  X:" + this.hunter.getxAxis() + "  Y:" + this.hunter.getyAxis()); //output

         // one D array.its use identify the object

//        for (int y = 0; y < 360; y++) {
//            for (int x = 0; x < 250; x++) {

                if (maze[this.hunter.getyAxis()][this.hunter.getxAxis()] == "dot") { //if  hunter hunt the dot
                    boarddot[this.hunter.getyAxis()][this.hunter.getxAxis()] = null;
                    hunterDotcount = hunterDotcount + 1;
                    this.DeletexAxis = this.hunter.getxAxis();
                    this.DeleteyAxis = this.hunter.getyAxis();
           
                }
                 System.out.println("hunter hunt dot             " + hunterDotcount);
//                if (maze[this.hunter.getyAxis()][this.hunter.getxAxis()] == this.superDot.toLowerCase()) { // all String convert to lower case
//                    System.out.println("Hunting SuperDot");                                                // if hunter hunt the superDots
//                    hunterSuperDotCount = hunterSuperDotCount + 1;
//                    for (int yy = 0; yy < 360; yy++) {
//                        for (int xx = 0; xx < 250; xx++) {
//
//                            if (maze[yy][xx] == SoldierType[0] || maze[yy][xx] == SoldierType[1] || maze[yy][xx] == SoldierType[2]) {
//                                maze[yy][xx] = null; // kill the soldier
//                                keyPressed(s.nextInt());
//                                // move funtion ekat call wenna one ilaga eka awidinna
//                                break;
//                            }
//
//                        }
//                    }
//                }
//                for (int w = 0; w < 3; w++) {
//                    if (maze[this.hunter.getyAxis()][this.hunter.getxAxis()] == SoldierType[w]) { // kill the hynter
//                        for (int n = 0; n < 3; n++) {
//                            if (this.soldier[n].getName() == objSoldier[n]) {
//                                this.soldier[n].hunt();
//                                System.out.println("Game over");
//                                System.exit(n);
//                            }
//                        }
//                    }
//                }
//                keyPressed(s.nextInt());
//            }
//        }
    }

    public void movesoldier() {
  
        for (int s = 0; s < 90000; s++) {
            if (yAxisRandom == 0 && xAxisRandom == 0) { // soldiers cant potion 0,0
                init();
            } else {
                if (mySoldierCount < 3) {
                    if (maze[yAxisRandom][xAxisRandom] == null) {
                        maze[yAxisRandom][xAxisRandom] = this.soldier[mySoldierCount].getName();
                        boardsoldier[yAxisRandom][xAxisRandom] = this.soldier[mySoldierCount].getName();
                        mySoldierCount = mySoldierCount + 1;
                        init();
                    } else {
                        init();
                    }
                } else {
                    break;
                }
            }
        }
    }
    

    @Override
    public void keyPressed(int key) throws SoundException {

        switch (key) {
            case 1:
                // handle up  

                this.movesoldier();
                maze[this.hunter.getyAxis()][this.hunter.getxAxis()] = null;
                this.hunter.setyAxis((this.hunter.getyAxis()) + 1);
                if (this.hunter.getyAxis() >= 360) {
                    throw new SoundException("Oh oo!!");
                }
                maze[this.hunter.getyAxis()][this.hunter.getxAxis()] = "hunter";
                System.out.println("Hunter is moveing ,  X:" + this.hunter.getxAxis() + "  Y:" + this.hunter.getyAxis());
                break;
            case 2:
                // handle down 

                this.movesoldier();
                maze[this.hunter.getyAxis()][this.hunter.getxAxis()] = null;
                this.hunter.setyAxis((this.hunter.getyAxis()) + 1);
                if (this.hunter.getyAxis() < 0) {
                    throw new SoundException("Oh oo!!");
                }
                maze[this.hunter.getyAxis()][this.hunter.getxAxis()] = "hunter";
                System.out.println("Hunter is moveing ,  X:" + this.hunter.getxAxis() + "  Y:" + this.hunter.getyAxis());
                break;
            case 3:
                // handle left

                this.movesoldier();
                maze[this.hunter.getyAxis()][this.hunter.getxAxis()] = null;
                this.hunter.setxAxis(this.hunter.getxAxis() - 1);
                if (this.hunter.getxAxis() < 0) {
                    throw new SoundException("Oh oo!!");
                }
                maze[this.hunter.getyAxis()][this.hunter.getxAxis()] = "hunter";
                System.out.println("Hunter is moveing ,  X:" + this.hunter.getxAxis() + "  Y:" + this.hunter.getyAxis());
                break;
            case 4:
                // handle right

                this.movesoldier();
                maze[this.hunter.getyAxis()][this.hunter.getxAxis()] = null;
                this.hunter.setxAxis(this.hunter.getxAxis() + 1);
                if (this.hunter.getxAxis() >= 250) {
                    throw new SoundException("Oh oo!!");
                }
                maze[this.hunter.getyAxis()][this.hunter.getxAxis()] = "hunter";
                System.out.println("Hunter is moveing ,  X:" + this.hunter.getxAxis() + "  Y:" + this.hunter.getyAxis());
                break;
            default:
                System.out.println("incorect key");
        }
    }

    @Override
    public void init() {
        yAxisRandom = random.nextInt(360);//random number genarater
        xAxisRandom = random.nextInt(250);//random number genarater
    }

    //getters
    public int getHunterDotcount() {
        return this.hunterDotcount;
    }

    public int getHunterSuperDotCount() {
        return this.hunterSuperDotCount;
    }

    public int getHunterSoldierCount() {
        return this.hunterSoldierCount;
    }

    public String[][] getBoarddot() {
        return boarddot;
    }

    public void setBoarddot(String[][] boarddot) {
        this.boarddot = boarddot;
    }

    public String[][] getBoardsoldier() {
        return boardsoldier;
    }

    public void setBoardsoldier(String[][] boardsoldier) {
        this.boardsoldier = boardsoldier;
    }

    public int getxAxisRandom() {
        return xAxisRandom;
    }

    public void setxAxisRandom(int xAxisRandom) {
        this.xAxisRandom = xAxisRandom;
    }

    public int getyAxisRandom() {
        return yAxisRandom;
    }

    public void setyAxisRandom(int yAxisRandom) {
        this.yAxisRandom = yAxisRandom;
    }

    public int getDeletexAxis() {
        return DeletexAxis;
    }

    public void setDeletexAxis(int DeletexAxis) {
        this.DeletexAxis = DeletexAxis;
    }

    public int getDeleteyAxis() {
        return DeleteyAxis;
    }

    public void setDeleteyAxis(int DeleteyAxis) {
        this.DeleteyAxis = DeleteyAxis;
    }

    public String[] getSoldierType() {
        return SoldierType;
    }

    public void setSoldierType(String[] SoldierType) {
        this.SoldierType = SoldierType;
    }

   

    public Soldier[] getSoldier() {
        return soldier;
    }

    public void setSoldier(Soldier[] soldier) {
        this.soldier = soldier;
    }
    

}
