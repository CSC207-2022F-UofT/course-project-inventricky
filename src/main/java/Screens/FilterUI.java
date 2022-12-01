
package Screens;

import entities.Filter;
import entities.Inventory;
import entities.InventoryItem;
import useCases.InventoryScratchBuilder;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class FilterUI extends JFrame {

        public FilterUI(ArrayList<InventoryItem> items){

            JFrame f = new JFrame("Filter");
            //set size and location of frame
            f.setSize(390, 300);
            f.setLocation(100, 150);
            //set look and feel
            JLabel labelM = new JLabel("Enter department number to filter by:");
            labelM.setBounds(50, 50, 500, 30);
            JTextField motto1 = new JTextField();
            //set size of the text box
            motto1.setBounds(50, 100, 200, 30);
            //add elements to the frame
            f.add(labelM);
            f.add(motto1);
            f.setLayout(null);
            f.setVisible(true);

            JButton button = new JButton("Filter");
            button.setBounds(20, 150, 80, 30);
            f.add(button);

            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    f.setVisible(false);
                    f.dispose();
                    Filter filtery = new Filter();
                    new DisplayUI(filtery.filterDepartment(items, motto1.getText()));
                }
            });
        }
}
