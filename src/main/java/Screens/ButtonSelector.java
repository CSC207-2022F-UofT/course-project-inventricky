package Screens;

import javax.swing.*;
import java.awt.*;

public class ButtonSelector extends JPanel {
    JButton t = new JButton("True");
    JButton f = new JButton("False");
    JLabel title = new JLabel("Sorted by Weight         ");

    /**
     * Creates a JPanel of two buttons wil a True and False option.
     */
     public ButtonSelector() {
         JPanel p = new JPanel();
         p.add(t);
         p.add(f);
         this.add(title);
         this.add(p);
         this.setVisible(true);
     }
    /** Sets a new title for the ButtonSelector.
     * @param title The new JLabel of the JPanel.
     */
    public void setTitle(JLabel title) {
        this.title = title;
    }
}
