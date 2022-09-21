package dothunter;

public class GreenSoldier extends Soldier { // soldier class inheritance to GreenSoldier class Soldier class = perant class , GreenSoldier class = chaild class

    private final int id = 2; // id is constant class  variable
    private String name; // String is immutable 
    private String color = "Green";

    GreenSoldier() {
        //default constructor
        this.name = color.concat(soldier); //String concatenation 
    }

    @Override
    public void hunt() {// hunt method override
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
