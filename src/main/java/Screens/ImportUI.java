package Screens;

import entities.Inventory;
import useCases.InventoryImportBuilder;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ImportUI extends JFrame {
    JTextField invName = new JTextField(15);
    JTextField fileName = new JTextField(15);

    public ImportUI() {
        this.setTitle("Import Menu");
        JLabel title = new JLabel("Import");
        this.setSize(400, 400);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.setVisible(true);

        LabelTextPanel invInfo = new LabelTextPanel(
                new JLabel("Inventory Name"), invName);
        LabelTextPanel passwordInfo = new LabelTextPanel(
                new JLabel("File Name"), fileName);

        JButton create = new JButton("Create");
        JButton cancel = new JButton("Cancel");

        JPanel buttons = new JPanel();
        buttons.add(create);
        buttons.add(cancel);

        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame j2 = new MainCreationUI();
                this.setVisible();
                j2.setVisible(true);
            }

            private void setVisible() {
                ImportUI.super.setVisible(false);
            }
        });

        create.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Inventory inv = new InventoryImportBuilder(invName.getText(), fileName.getText()).create();
                //JFrame j2 = new InventoryUI(inv);
                JFrame j2 = new ScratchUI();
                j2.setSize(400,400);
                this.setVisible();
                j2.setVisible(true);

//                JFrame f = new JFrame();
//                f.setSize(300, 300);
//                String[] list = {fileName.getText()};
//                JList l = new JList<String>(list);
//                f.add(l);
//                f.setVisible(true);
            }

            private void setVisible() {
                ImportUI.super.setVisible(false);
            }
        });

        JPanel main = new JPanel();
        main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));

        main.add(title);
        main.add(invInfo);
        main.add(passwordInfo);
        main.add(buttons);
        this.setContentPane(main);

//        this.pack();
    }

    public static void main(String[] args) {
        new ImportUI();
    }
}
