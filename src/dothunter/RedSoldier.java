package dothunter;

import javax.swing.JOptionPane;

public class RedSoldier extends Soldier {// soldier class inheritance to RedSoldier class Soldier class = perant class , RedSoldier class = chaild class

    private final int id = 3; // id is constant class  variable
    private String name = "RedSoldier";   // String is immutable 
   

    RedSoldier() {
        //default constructor
       
    }

    @Override
    public void hunt() { // hunt method override
        JOptionPane.showMessageDialog(null, "Killed using a hand",
       "Game over", JOptionPane.ERROR_MESSAGE);
        System.out.println("Killed using a hand");// out put
        System.out.println("Game over");// out put
    }

    @Override
    public String getName() { // geters its return name
        return name;
    }

    @Override
    public int getID() { // geters its return id 
        return id;
    }

}
