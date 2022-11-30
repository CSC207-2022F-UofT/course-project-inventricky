package Screens;

import javax.swing.*;

// Frameworks/Drivers layer

public class TextPanel extends JPanel {
    public TextPanel(JLabel label, JTextField textField) {
        this.add(label);
        this.add(textField);
    }
}
