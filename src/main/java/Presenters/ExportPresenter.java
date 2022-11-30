package Presenters;

import javax.swing.*;
import java.awt.*;

public class ExportPresenter {
    /**
     * Presents the message to the user that the inventory was exported successfully
     *
     */
    public void present() {
        JFrame frame = new JFrame("Export Successful");
        JButton button = new JButton("<html>Export Successful;<br />Click to return to menu</html>");
        button.setFont(new Font("Arial", Font.PLAIN, 40));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(button);
        button.addActionListener(e -> frame.dispose());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(550, 300));
        frame.getContentPane().setBackground(Color.ORANGE);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        ExportPresenter presenter = new ExportPresenter();
        presenter.present();
    }
}
