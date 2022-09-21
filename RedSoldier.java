package dothunter;

public class RedSoldier extends Soldier {// soldier class inheritance to RedSoldier class Soldier class = perant class , RedSoldier class = chaild class

    private final int id = 3; // id is constant class  variable
    private String name;   // String is immutable 
    private String color = "Red";

    RedSoldier() {
        //default constructor
        this.name = color.concat(soldier); //String concatenation 
    }

    @Override
    public void hunt() { // hunt method override
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
