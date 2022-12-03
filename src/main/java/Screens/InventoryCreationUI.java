package Screens;

import entities.Inventory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.HashMap;

public class InventoryCreationUI extends JFrame{
    JButton imported = new JButton("Imported");
    JButton scratch = new JButton("Scratch");
    
    public InventoryCreationUI(HashMap controllers) {
        JLabel title = new JLabel("Inventory Creation");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        JPanel buttons = new JPanel();
        buttons.add(imported);
        buttons.add(scratch);


        imported.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame j2 = new ImportUI(controllers);
                this.setVisible();
                j2.setVisible(true);
            }

            private void setVisible() {
                InventoryCreationUI.super.setVisible(false);
            }
        });

        scratch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame j2 = new ScratchUI(controllers);
                this.removeVisible();
                j2.setVisible(true);
            }

            private void removeVisible() {
                InventoryCreationUI.super.setVisible(false);
            }
        });


        JPanel main = new JPanel();
        main.setSize(500, 500);
        main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));

        main.add(title);
        main.add(buttons);
        this.setContentPane(main);

        JTextArea ta = new JTextArea();
        this.add(ta);

        this.pack();
    }
}
