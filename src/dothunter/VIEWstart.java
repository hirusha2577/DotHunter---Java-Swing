package dothunter;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class VIEWstart implements  ActionListener {

    JFrame f1;
    JLabel l1, l2, l3, l4, l5, l6;
    JTextField t1;
    JButton b1;
    JRadioButton r1, r2, r3;
    ButtonGroup bg;

    VIEWstart() {

        f1 = new JFrame();
        f1.setSize(300, 365);
        f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f1.setLayout(null);
        f1.setVisible(true);
        
        l6 = new JLabel("DotHunter");
        l6.setBounds(100, 15, 100, 30);
        Font font = new Font("Arial",Font.PLAIN,15);
        l6.setFont(font);

        l1 = new JLabel("Enter name    :");
        l1.setBounds(15, 70, 100, 30);
        l2 = new JLabel("Select colour :");
        l2.setBounds(15, 120, 100, 30);

        t1 = new JTextField();
        t1.setBounds(100, 70, 120, 30);

        l3 = new JLabel();
        l3.setBounds(100, 120, 30, 30);
        l3.setBackground(Color.RED);
        l3.setOpaque(true);
        l4 = new JLabel();
        l4.setBounds(145, 120, 30, 30);
        l4.setBackground(Color.BLACK);
        l4.setOpaque(true);
        l5 = new JLabel();
        l5.setBounds(190, 120, 30, 30);
        l5.setBackground(Color.GREEN);
        l5.setOpaque(true);

        r1 = new JRadioButton("");
        r1.setBounds(105, 160, 30, 30);
        r1.setName("RED");
        r2 = new JRadioButton("");
        r2.setBounds(150, 160, 30, 30);
        r2.setName("BLACK");
        r3 = new JRadioButton("");
        r3.setBounds(195, 160, 30, 30);
        r3.setName("GREEN");

        bg = new ButtonGroup();
        bg.add(r1);
        bg.add(r2);
        bg.add(r3);

        b1 = new JButton("Start");
        b1.setBounds(80, 230, 80, 30);
        b1.addActionListener(this);

        f1.add(l1);
        f1.add(l2);
        f1.add(t1);
        f1.add(l3);
        f1.add(l4);
        f1.add(l5);
        f1.add(l6);
        f1.add(r1);
        f1.add(r2);
        f1.add(r3);
        f1.add(b1);

    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if (r1.isSelected()) {
            f1.dispose();
            Hunter hunter = new Hunter(t1.getText(), r1.getName());
            try {
                new VIEWboard(hunter) ;
            } catch (SoundException ex) {
                Logger.getLogger(VIEWstart.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (r2.isSelected()) {
            Hunter hunter = new Hunter(t1.getText(), r2.getName());
            f1.dispose();
            try {
                new VIEWboard(hunter);
            } catch (SoundException ex) {
                Logger.getLogger(VIEWstart.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (r3.isSelected()) {
            f1.dispose();
            Hunter hunter = new Hunter(t1.getText(), r3.getName());
            try {
                new VIEWboard(hunter);
            } catch (SoundException ex) {
                Logger.getLogger(VIEWstart.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
}
