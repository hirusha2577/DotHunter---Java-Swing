package dothunter;

public class BlueSoldier extends Soldier { // soldier class inheritance to BlueSoldier class Soldier class = perant class , BlueSoldier class = chaild class

    private final int id = 1; // id is constant class  variable
    private String name; // String is immutable 
    private String color = "Blue";

    BlueSoldier() {
        //default constructor
        this.name = color.concat(soldier); //String concatenation 
    }

    @Override
    public void hunt() { // hunt method override 
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
