package Screens;

import javax.swing.*;
import java.awt.*;

public class ButtonSelector extends JPanel {
    JButton t = new JButton("True");
    JButton f = new JButton("False");
    JLabel title = new JLabel("Sorted by Weight         ");

     public ButtonSelector() {
         JPanel p = new JPanel();
         p.add(t);
         p.add(f);
         this.add(title);
         this.add(p);
         this.setVisible(true);
     }

    public void setTitle(JLabel title) {
        this.title = title;
    }
}
