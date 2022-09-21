/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dothunter;

/**
 *
 * @author Hirusha
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DemoKey implements KeyListener{
    
   
    private int key;
    
    JFrame frame;
    JLabel label;
    
    DemoKey(){
        frame = new JFrame();
        frame.setSize(250,360);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.addKeyListener(this);
    }

    @Override
    public void keyTyped(KeyEvent e) {
       
       
    }

    @Override
    public void keyPressed(KeyEvent e) {
        key = e.getKeyCode();
        System.out.println(key);
    }

    @Override
    public void keyReleased(KeyEvent e) {
       
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public JFrame getFrame() {
        return frame;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    
    
}
