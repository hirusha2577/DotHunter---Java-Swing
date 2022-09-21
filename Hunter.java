package dothunter;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Hunter implements interfaceHunter {  // implements keyword is used to implement an interface

    private String name;
    private String color;
    private int xAxis;
    private int yAxis;

    Hunter() { //default constructor
        this.xAxis = 0;
        this.yAxis = 0;
    }

    Hunter(String name, String color) { //overloded constructor
        this.name = name;
        this.color = color;
    }

    @Override
    public void setxPOS(int xAxis) throws SoundException { // setxPOS method . its override method
        if (xAxis >= 250) {
            throw new SoundException("Oh oo!!"); // coustom ecteption masage throw
        } else {
            this.xAxis = xAxis;
        }
    }

    @Override
    public void setyPOS(int yAxis) throws SoundException { // setyPOS method . its override method
        if (yAxis >= 360) {
            throw new SoundException("Oh oo!!"); // coustom ecteption masage throw
        } else {
            this.yAxis = yAxis;
        }
    }

    @Override
    public void move(Hunter hunter) {  // move method . its override method

        this.yAxis = hunter.yAxis;
        this.xAxis = hunter.xAxis;

//        System.out.println("++++++++++++++++++++" + this.yAxis);  // use for testing
//        System.out.println("++++++++++++++++++++" + this.xAxis);
    }

    @Override
    public void hunt(Board board) { // hunt method . its override method
        try {
            board.movehunter();
        } catch (SoundException ex) { // exception handling
            Logger.getLogger(Hunter.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Hunter hunt dots        :" + board.getHunterDotcount());  // output
        System.out.println("Hunter hunt Superdots   :" + board.getHunterSuperDotCount()); // output
        System.out.println("Hunter hunt Soldiers    :" + board.getHunterSoldierCount()); // output

    }

    //setters
    public void setName(String name) {
        this.name = name;
    }

    public void setColor(String color) {
        this.name = name;
    }

    public void setxAxis(int xAxis) {
        this.xAxis = xAxis;
    }

    public void setyAxis(int yAxis) {
        this.yAxis = yAxis;
    }

    //getters
    public String getName() {
        return this.name;
    }

    public String getColor() {
        return this.color;
    }

    public int getxAxis() {
        return this.xAxis;
    }

    public int getyAxis() {
        return this.yAxis;
    }

}
