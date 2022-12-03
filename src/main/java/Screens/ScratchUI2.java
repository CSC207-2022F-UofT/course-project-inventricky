package Screens;

import entities.Inventory;
import useCases.InventoryScratchBuilder;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ScratchUI2 extends JFrame{
    JTextField invName = new JTextField(15);

    public ScratchUI2() {
        this.setTitle("New Inventory Menu");
        JLabel title = new JLabel("New Inventory");
        this.setSize(400, 400);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.setVisible(true);

        TextPanel invInfo = new TextPanel(new JLabel("Inventory Name"), invName);

        JButton create = new JButton("Create");
        JButton cancel = new JButton("Cancel");

        JPanel buttons = new JPanel();
        buttons.add(create);
        buttons.add(cancel);

        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame j2 = new MainCreationUI();
                j2.setDefaultCloseOperation(EXIT_ON_CLOSE);
                this.setVisible();
                j2.setVisible(true);
            }

            private void setVisible() {
                ScratchUI2.super.setVisible(false);
            }
        });

        create.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Inventory inv = new InventoryScratchBuilder(invName.getText()).create();
                JFrame j2 = new InventoryUI(inv);
                j2.setSize(400,400);
                this.setVisible();
                j2.setVisible(true);
            }

            private void setVisible() {
                ScratchUI2.super.setVisible(false);
            }
        });

        JPanel main = new JPanel();
        main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));

        main.add(title);
        main.add(invInfo);
        main.add(buttons);
        this.setContentPane(main);
    }
}
