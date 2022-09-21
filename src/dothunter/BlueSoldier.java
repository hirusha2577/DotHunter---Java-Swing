package dothunter;

import javax.swing.JOptionPane;

public class BlueSoldier extends Soldier { // soldier class inheritance to BlueSoldier class Soldier class = perant class , BlueSoldier class = chaild class

    private final int id = 1; // id is constant class  variable
    private String name = "BlueSoldier"; // String is immutable 
   

    BlueSoldier() {
        //default constructor
       
    }

    @Override
    public void hunt() { // hunt method override 
       JOptionPane.showMessageDialog(null, "Killed using a gun",
       "Game over", JOptionPane.ERROR_MESSAGE);
        System.out.println("Killed using a gun"); // out put
        System.out.println("Game over"); //out put    
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
