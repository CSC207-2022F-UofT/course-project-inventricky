package Screens;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainCreationUI extends JFrame {

    public MainCreationUI() {
//        JFrame frame = new JFrame("Main Menu");
        JPanel panel = new JPanel();
        JButton button = new JButton("Create New Inventory");
        panel.add(button);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(200, 200);

        this.setVisible(true);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame j2 = new InventoryCreationUI(); //FIX
                this.setVisible();
                j2.setSize(400, 400);
                j2.setVisible(true);
            }

            private void setVisible() {
                MainCreationUI.super.setVisible(false);
            }
        });
        this.getContentPane().add(BorderLayout.CENTER, panel);
    }
}
