package dothunter;

import javax.swing.JOptionPane;

public class GreenSoldier extends Soldier { // soldier class inheritance to GreenSoldier class Soldier class = perant class , GreenSoldier class = chaild class

    private final int id = 2; // id is constant class  variable
    private String name = "GreenSoldier"; // String is immutable 

    GreenSoldier() {
        //default constructor
    }

    @Override
    public void hunt() {// hunt method override
         JOptionPane.showMessageDialog(null, "Killed using a knife",
       "Game over", JOptionPane.ERROR_MESSAGE);
        System.out.println("Killed using a knife");// out put
        System.out.println("Game over");// out put
    }

    @Override
    public String getName() {// geters its return name
        return name;
    }

    @Override
    public int getID() {// geters its return id 
        return id;
    }

}
