package Screens;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.HashMap;

public class ItemHistoryScreen extends JFrame {

    private static final HashMap<String, JFrame> openScreens = new HashMap<>();

    public static JFrame getOpenScreen(String barcode) {
        if (!openScreens.containsKey(barcode)) {
            return null;
        }
        return openScreens.get(barcode);
    }

    public ItemHistoryScreen(ItemHistoryViewModel itemHistory) {

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                ItemHistoryScreen.super.dispose();
                openScreens.remove(itemHistory.getItemHistory().get(0).substring(0, 5));
            }
        });
        //store screen in openScreens
        openScreens.put(itemHistory.getItemHistory().get(0).substring(0, 5), this);


        //create new list model for storing history entries
        DefaultListModel<String> listModel = new DefaultListModel<>();

        //populate list model with entries
        for (String entry : itemHistory.getItemHistory()) {

            listModel.addElement(entry);

        }

        JList<String> historyList = new JList<>(listModel);

        this.add(historyList);
        this.setMinimumSize(new Dimension(200, 200));
        this.pack();
        this.setVisible(true);

    }
}
