package Screens;

import javax.swing.*;
import java.awt.*;

public class ExportSuccessfulUI {
    /**
     * Presents the pop-up screen (by generating the button, message, and returning to main menu upon closure)
     * after the inventory is exported successfully
     */
    public void present() {
        JFrame frame = new JFrame("Export Successful");
        JButton button = new JButton("<html>Inventory exported successfully.<br />Click to return to main menu</html>");
        button.setFont(new Font("Arial", Font.PLAIN, 40));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(button);
        button.addActionListener(e -> frame.dispose());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(600, 300));
        frame.getContentPane().setBackground(Color.ORANGE);
        frame.pack();
        frame.setVisible(true);
    }

}
