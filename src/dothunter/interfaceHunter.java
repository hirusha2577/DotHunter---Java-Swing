package dothunter;

interface interfaceHunter { // this is interface
    // interface is an abstract class

    void setxPOS(int x) throws SoundException;

    void setyPOS(int y) throws SoundException;

    void move(Hunter hunter);

    void hunt(Board board);

    String getName();

    String getColor();

    int getxAxis();

    int getyAxis();
}
