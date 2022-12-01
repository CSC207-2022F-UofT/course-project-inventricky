package Screens;

import entities.Filter;
import entities.InventoryItem;
import entities.Search;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SearchUI extends JFrame{

    public SearchUI(ArrayList<InventoryItem> items) {

        JFrame f = new JFrame("Search");
        //set size and location of frame
        f.setSize(390, 300);
        f.setLocation(100, 150);
        //set look and feel
        JLabel labelM = new JLabel("Enter what to search by:");
        labelM.setBounds(50, 50, 500, 30);
        JTextField motto1 = new JTextField();
        //set size of the text box
        motto1.setBounds(50, 100, 200, 30);
        //add elements to the frame
        f.add(labelM);
        f.add(motto1);
        f.setLayout(null);
        f.setVisible(true);

        JButton button = new JButton("Search");
        button.setBounds(20, 150, 80, 30);
        f.add(button);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.setVisible(false);
                f.dispose();
                Search search = new Search();
                new DisplayUI(search.searchResults(items, motto1.getText()));
            }
        });
    }
}
