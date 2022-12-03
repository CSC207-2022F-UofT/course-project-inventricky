package Screens;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ItemHistoryScreen extends JFrame {

    public ItemHistoryScreen(ItemHistoryViewModel itemHistory) {

        //create new list model for storing history entries
        DefaultListModel<String> listModel = new DefaultListModel<String>();

        //populate list model with entries
        for (String entry : itemHistory.getItemHistory()) {

            listModel.addElement(entry);

        }

        JList<String> historyList = new JList<String>(listModel);

        this.add(historyList);
        this.setMinimumSize(new Dimension(200, 200));
        this.pack();
        this.setVisible(true);

    }
}
