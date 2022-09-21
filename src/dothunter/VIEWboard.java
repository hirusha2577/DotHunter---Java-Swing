/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dothunter;

import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;

public class VIEWboard implements KeyListener, ActionListener {

    Hunter hunter;
    Board board;

    private JFrame f1;
    private JPanel p1;
    private JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12, l13, l14, l15, l16;

    int XdeleteDot[] = new int[97];
    int YdeleteDot[] = new int[97];
    int XdeleteSuperDot[] = new int[3];
    int YdeleteSuperDot[] = new int[3];

    private String dot[][] = new String[360][250];
    private String newdot[][] = new String[360][250];

    private String soldier[][] = new String[360][250];
    private String newsoldier[][] = new String[360][250];

    JPanel[] superdotarray = new JPanel[3];
    JPanel[] dotarray = new JPanel[97];
    JPanel[] soldierarray = new JPanel[97];

    private JTextField t1, t2;
    private JButton b1;

    int superdotcount = 0;
    int dotcount = 0;
    int soldiercount = 0;

    private int hunterDotcount = 0;
    private int hunterSuperDotCount = 0;
    private int hunterSoldierCount = 0;

    Color hunterColor;
    Color soldierColor;
    Color dotColor;
    Color SuperDotColor;

    VIEWboard() {

    }

    VIEWboard(Hunter hunter) throws SoundException {

        this.hunter = hunter;

        f1 = new JFrame();
        f1.setSize(600, 445);
        f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f1.setLayout(null);
        f1.setVisible(true);

        l1 = new JLabel();
        l1.setBounds(20, 20, 250, 360);
        l1.setBackground(Color.gray);
        l1.setOpaque(true);

        if (this.hunter.getColor() == "RED") {
            hunterColor = Color.RED;
        }
        if (this.hunter.getColor() == "BLACK") {
            hunterColor = Color.BLACK;
        }
        if (this.hunter.getColor() == "GREEN") {
            hunterColor = Color.GREEN;
        }

        l2 = new JLabel("Hunter Name    :");
        l2.setBounds(310, 30, 100, 30);
        l3 = new JLabel(this.hunter.getName());
        l3.setBounds(420, 30, 100, 30);

        l4 = new JLabel("Hunter Colour  :");
        l4.setBounds(310, 66, 100, 30);
        l5 = new JLabel();
        l5.setBounds(420, 70, 20, 20);
        l5.setBackground(hunterColor);
        l5.setOpaque(true);

        l6 = new JLabel("Set x :");
        l6.setBounds(310, 120, 60, 25);
        l7 = new JLabel("Set y :");
        l7.setBounds(310, 160, 60, 25);
        t1 = new JTextField();
        t1.setBounds(360, 122, 100, 25);
        t2 = new JTextField();
        t2.setBounds(360, 162, 100, 25);

        b1 = new JButton("Set Hunter");
        b1.setBounds(310, 200, 100, 26);
        b1.addActionListener(this);
        
        l14 = new JLabel();
        l14.setBounds(310, 127, 10, 10);
        l14.setBackground(Color.PINK);
        l14.setOpaque(true);
        l14.setVisible(false);
        l8 = new JLabel("hunt dot     : ");
        l8.setBounds(330, 120, 100, 25);
        l8.setVisible(false);
        l9 = new JLabel("0");
        l9.setBounds(440, 120, 50, 25);
        l9.setVisible(false);

        l15 = new JLabel();
        l15.setBounds(310, 157, 10, 10);
        l15.setBackground(Color.ORANGE);
        l15.setOpaque(true);
        l15.setVisible(false);
        l10 = new JLabel("hunt SuperDot : ");
        l10.setBounds(330, 150, 100, 25);
        l10.setVisible(false);
        l11 = new JLabel("0");
        l11.setBounds(440, 150, 50, 25);
        l11.setVisible(false);

        l16 = new JLabel();
        l16.setBounds(310, 187, 10, 10);
        l16.setBackground(Color.BLUE);
        l16.setOpaque(true);
        l16.setVisible(false);
        l12 = new JLabel("hunt Soldier : ");
        l12.setBounds(330, 180, 100, 25);
        l12.setVisible(false);
        l13 = new JLabel("0");
        l13.setBounds(440, 180, 50, 25);
        l13.setVisible(false);

        //  Board
        p1 = new JPanel();
        p1.setBounds(this.hunter.getxAxis(), this.hunter.getyAxis(), 5, 5);
        p1.setBackground(hunterColor);

        Soldier threeSoldier[] = {new BlueSoldier(), new BlueSoldier(), new RedSoldier()};
        this.board = new Board("superDot", hunter, threeSoldier);

        dot = board.getBoarddot();
        for (int y = 0; y < 360; y++) {
            for (int x = 0; x < 250; x++) {
                newdot[y][x] = dot[y][x];
            }

        }

        this.dot();

        soldier = board.getBoardsoldier();
        for (int y = 0; y < 360; y++) {
            for (int x = 0; x < 250; x++) {
                newsoldier[y][x] = soldier[y][x];
            }

        }

        //soldier set to board
        for (int y = 0; y < 360; y++) {
            for (int x = 0; x < 250; x++) {

                if (newsoldier[y][x] != null) {

                    if (soldiercount < 3) {
                        soldierarray[soldiercount] = new JPanel();
                        soldierarray[soldiercount].setBounds(x, y, 5, 5);
                        soldierarray[soldiercount].setBackground(Color.BLUE);
                        soldierarray[soldiercount].setName("soldier");
                        l1.add(soldierarray[soldiercount]);
                        soldiercount = soldiercount + 1;
                    }
                }

            }

        }

        f1.add(l1);

        f1.add(l2);
        f1.add(l3);
        f1.add(l4);
        f1.add(l5);
        f1.add(l6);
        f1.add(l7);
        f1.add(l8);
        f1.add(l9);
        f1.add(l10);
        f1.add(l11);
        f1.add(l12);
        f1.add(l13);
        f1.add(l14);
        f1.add(l15);
        f1.add(l16);

        f1.add(b1);

        f1.add(t1);
        f1.add(t2);

        l1.add(p1);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        this.hunter.setxAxis(Integer.parseInt(t1.getText()));
        this.hunter.setyAxis(Integer.parseInt(t2.getText()));

        p1.setLocation(this.hunter.getxAxis(), this.hunter.getyAxis());

        l6.setVisible(false);
        l7.setVisible(false);
        t1.setVisible(false);
        t2.setVisible(false);
        b1.setVisible(false);

        l8.setVisible(true);
        l9.setVisible(true);
        l10.setVisible(true);
        l11.setVisible(true);
        l12.setVisible(true);
        l13.setVisible(true);
        l14.setVisible(true);
        l15.setVisible(true);
        l16.setVisible(true);

        board.movesoldier();
        this.soldiersMove();
        f1.addKeyListener(this);
    }

    void soldiersMove() {
        int count = 0;
        for (int y = 0; y < 360; y++) {
            for (int x = 0; x < 250; x++) {
                if (newdot[y][x] == null) {
                    if (count < 3) {
                        board.init();
                        soldierarray[count].setLocation(board.getxAxisRandom(), board.getyAxisRandom());
                        count = count + 1;
                    }
                }
            }

        }
    }

    int countSoldier = 0;

    void hunterHunt() {

        if ("dot".equals(newdot[this.hunter.getyAxis()][this.hunter.getxAxis()])) {
            newdot[this.hunter.getyAxis()][this.hunter.getxAxis()] = null;
            hunterDotcount = hunterDotcount + 1;
            System.out.println("DOT :" + hunterDotcount);
            l9.setText(String.valueOf(hunterDotcount));
            for (int c = 0; c < 97; c++) { // hunter hunt dot
                if (this.hunter.getyAxis() == YdeleteDot[c] && this.hunter.getxAxis() == XdeleteDot[c]) {
                    l1.remove(dotarray[c]);
                }
            }

        }

        if ("superdot".equals(newdot[this.hunter.getyAxis()][this.hunter.getxAxis()])) {
            newdot[this.hunter.getyAxis()][this.hunter.getxAxis()] = null;
            hunterSuperDotCount = hunterSuperDotCount + 1;
            System.out.println("Super :" + hunterSuperDotCount);
            l11.setText(String.valueOf(hunterSuperDotCount));
            for (int c = 0; c < 3; c++) { // hunter hunt dot
                if (this.hunter.getyAxis() == YdeleteSuperDot[c] && this.hunter.getxAxis() == XdeleteSuperDot[c]) {
                    l1.remove(superdotarray[c]);
                    l1.remove(soldierarray[countSoldier]);
                    countSoldier = countSoldier + 1;
                    l13.setText(String.valueOf(countSoldier));
                }
            }

        }

        String soldierType[] = {"BlueSoldier", "GreenSoldier", "RedSoldier"}; // one D array 

        Soldier boardSoldier[] = new Soldier[3];
        boardSoldier = this.board.getSoldier();

        String objSoldier[] = {boardSoldier[0].getName(), boardSoldier[1].getName(), boardSoldier[2].getName()};

        for (int w = 0; w < 3; w++) {
            if (newsoldier[this.hunter.getyAxis()][this.hunter.getxAxis()] == soldierType[w]) { // kill the hynter
                for (int n = 0; n < 3; n++) {
                    if (boardSoldier[n].getName() == objSoldier[n]) {
                        boardSoldier[n].hunt();
                        System.exit(n);
                    }
                }
            }
        }

        if (hunterDotcount == 97 && hunterSuperDotCount == 3) {
            JOptionPane.showMessageDialog(null, "You win !!!!!",
                    "Happy", JOptionPane.ERROR_MESSAGE);
            System.out.println("Win !!!!");
        }

    }

    @Override
    public void keyTyped(KeyEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {

        int keyCode = e.getKeyCode();
        //    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

        switch (keyCode) {
            case KeyEvent.VK_UP:// handle up  /////////////////////////////////////////////////////////////
                if (this.hunter.getyAxis() < 0 || this.hunter.getyAxis() > 360) {
                    JOptionPane.showMessageDialog(null, "Oh oo!!",
                            "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    board.movesoldier();
                    this.soldiersMove();
                    this.hunter.setyAxis(this.hunter.getyAxis() - 1);
                    p1.setLocation(this.hunter.getxAxis(), this.hunter.getyAxis());
                    this.hunterHunt();
//                System.out.println("x :" + this.hunter.getxAxis() + "   " + "y :" + this.hunter.getyAxis());
//                System.out.println("hunter hunt dot                  " + hunterDotcount);
//                System.out.println("hunter hunt Superdot             " + hunterSuperDotCount);
                }
                break;
            case KeyEvent.VK_DOWN:// handle down /////////////////////////////////////////////////////////////
                if (this.hunter.getyAxis() < 0 || this.hunter.getyAxis() > 360) {
                    JOptionPane.showMessageDialog(null, "Oh oo!!",
                            "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    board.movesoldier();
                    this.soldiersMove();
                    this.hunter.setyAxis(this.hunter.getyAxis() + 1);
                    p1.setLocation(this.hunter.getxAxis(), this.hunter.getyAxis());
                    this.hunterHunt();
//                System.out.println("x :" + this.hunter.getxAxis() + "   " + "y :" + this.hunter.getyAxis());
//                System.out.println("hunter hunt dot                  " + hunterDotcount);
//                System.out.println("hunter hunt Superdot             " + hunterSuperDotCount);
                }
                break;
            case KeyEvent.VK_LEFT:// handle left /////////////////////////////////////////////////////////////
                if (this.hunter.getxAxis() < 0 || this.hunter.getxAxis() > 250) {
                    JOptionPane.showMessageDialog(null, "Oh oo!!",
                            "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    board.movesoldier();
                    this.soldiersMove();
                    this.hunter.setxAxis(this.hunter.getxAxis() - 1);
                    p1.setLocation(this.hunter.getxAxis(), this.hunter.getyAxis());
                    this.hunterHunt();
//                System.out.println("x :" + this.hunter.getxAxis() + "   " + "y :" + this.hunter.getyAxis());
//                System.out.println("hunter hunt dot                  " + hunterDotcount);
//                System.out.println("hunter hunt Superdot             " + hunterSuperDotCount);
                }
                break;
            case KeyEvent.VK_RIGHT:// handle right /////////////////////////////////////////////////////////////
                if (this.hunter.getxAxis() < 0 || this.hunter.getxAxis() > 250) {
                    JOptionPane.showMessageDialog(null, "Oh oo!!",
                            "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    board.movesoldier();
                    this.soldiersMove();
                    this.hunter.setxAxis(this.hunter.getxAxis() + 1);
                    p1.setLocation(this.hunter.getxAxis(), this.hunter.getyAxis());
                    this.hunterHunt();
//                System.out.println("x :" + this.hunter.getxAxis() + "   " + "y :" + this.hunter.getyAxis());
//                System.out.println("hunter hunt dot                  " + hunterDotcount);
//                System.out.println("hunter hunt Superdot             " + hunterSuperDotCount);
                }
                break;
            default:
                System.out.println("incorect key");
        }
    }

    void dot() {
        //superdot and dot set to board
        for (int y = 0; y < 360; y++) {
            for (int x = 0; x < 250; x++) {
                if ("superdot".equals(newdot[y][x])) {
                    if (superdotcount < 3) {
                        XdeleteSuperDot[superdotcount] = x;
                        YdeleteSuperDot[superdotcount] = y;
                        superdotarray[superdotcount] = new JPanel();
                        superdotarray[superdotcount].setBounds(x, y, 5, 5);
                        superdotarray[superdotcount].setBackground(Color.ORANGE);
                        superdotarray[superdotcount].setName("superdot");
                        l1.add(superdotarray[superdotcount]);
                        superdotcount = superdotcount + 1;
                    }

                }
                if ("dot".equals(newdot[y][x])) {

                    XdeleteDot[dotcount] = x;
                    YdeleteDot[dotcount] = y;

                    dotarray[dotcount] = new JPanel();
                    dotarray[dotcount].setBounds(x, y, 5, 5);
                    dotarray[dotcount].setBackground(Color.PINK);
                    dotarray[dotcount].setName("dot");
                    l1.add(dotarray[dotcount]);

                    dotcount = dotcount + 1;

                }
            }

        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Color getHunterColor() {
        return hunterColor;
    }

    public void setHunterColor(Color hunterColor) {
        this.hunterColor = hunterColor;
    }

    public Color getSoldierColor() {
        return soldierColor;
    }

    public void setSoldierColor(Color soldierColor) {
        this.soldierColor = soldierColor;
    }

    public Color getDotColor() {
        return dotColor;
    }

    public void setDotColor(Color dotColor) {
        this.dotColor = dotColor;
    }

    public Color getSuperDotColor() {
        return SuperDotColor;
    }

    public void setSuperDotColor(Color SuperDotColor) {
        this.SuperDotColor = SuperDotColor;
    }

}
