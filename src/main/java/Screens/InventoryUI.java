package Screens;

import entities.Importer;
import entities.Inventory;
import entities.InventoryItem;
import useCases.InventoryImportBuilder;

import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;

public class InventoryUI extends JFrame{

    public InventoryUI() {
//        JFrame frame = new JFrame("Inventory Menu");
        this.setTitle("Inventory Menu");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(300, 300);
        this.setVisible(true);

        //Creating the MenuBar and adding components
        JMenuBar mb = new JMenuBar();
        JMenu m1 = new JMenu("Inventory Items");
        JMenu orders = new JMenu("Orders");
        JMenu generate_analysis = new JMenu("Generate Analysis");
        JMenu delete_inventory = new JMenu("Delete Inventory");
        JMenu history = new JMenu("Inventory History");
        mb.add(m1);
        mb.add(orders);
        mb.add(generate_analysis);
        mb.add(delete_inventory);
        mb.add(history);
        JMenuItem m11 = new JMenuItem("Open");
        JMenuItem m22 = new JMenuItem("Save as");
        m1.add(m11);
        m1.add(m22);

        delete_inventory.addMenuListener(new MenuListener() {
            @Override
            public void menuSelected(MenuEvent e) {
                this.removeVisible();
                new MainCreationUI();
            }

            private void removeVisible() {
                InventoryUI.super.setVisible(false);
            }

            @Override
            public void menuDeselected(MenuEvent e) {

            }

            @Override
            public void menuCanceled(MenuEvent e) {

            }
        });

        history.addMenuListener(new MenuListener() {
            @Override
            public void menuSelected(MenuEvent e) {
                Inventory inv = new InventoryImportBuilder("test", "src/main/java/exports/serializable_inventory.txt").create();
                inv.updateHistory("test");
                String[] list = inv.getHistory().toArray(new String[0]);
                JFrame frame = new JFrame();
                JList l = new JList<String>(list);
                frame.add(l);
                frame.pack();
                frame.setSize(400, 400);
                frame.getContentPane().add(BorderLayout.CENTER, l);
                frame.setVisible(true);
            }

            @Override
            public void menuDeselected(MenuEvent e) {

            }

            @Override
            public void menuCanceled(MenuEvent e) {

            }
        });

        //Creating the panel at bottom and adding components
        JPanel panel = new JPanel(); // the panel is not visible in output
        // accepts upto 10 characters
        JButton send = new JButton("Create New Inventory");
        JButton hist = new JButton("History");
        send.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame j2 = new JFrame();
                j2.setSize(400,400);
                j2.setVisible(true);
            }
        });
        // Components Added using Flow Layout
        panel.add(send);
        panel.add(hist);

        hist.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                String[] list = {"one", "two"};
                JFrame frame = new JFrame();
                Inventory inv = new InventoryImportBuilder("test", "src/main/java/exports/serializable_inventory.txt").create();
                inv.addItem(new InventoryItem("bananas","123" , true, 10, 2,
                        3, 5, "1", 10, 0));
                String[] list = inv.getHistory().toArray(new String[0]);
                JList l = new JList<String>(list);
                frame.add(l);
                frame.pack();
                frame.setSize(400, 400);
                frame.getContentPane().add(BorderLayout.CENTER, l);
                frame.setVisible(true);
            }
        });

        // Text Area at the Center
        JTextArea ta = new JTextArea();

        //Adding Components to the frame.
        this.getContentPane().add(BorderLayout.SOUTH, panel);
        this.getContentPane().add(BorderLayout.NORTH, mb);
        this.getContentPane().add(BorderLayout.CENTER, ta);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new InventoryUI();
    }

}
