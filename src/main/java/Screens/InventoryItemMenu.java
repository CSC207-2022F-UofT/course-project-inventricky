package Screens;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.HashMap;

public class InventoryItemMenu extends JFrame implements ActionListener, ItemListener {

    private JFrame parent;
    private static HashMap controllers; //controllers for use cases
    final static String REMOVEITEMPANEL = "Remove Item";
    final static String UPDATEITEMPANEL = "Update Item Quantity";

    final static String[] REASON_COMBO_BOX_ITEMS = {"bought", "sold", "error"};

    JComboBox reasonComboBox = new JComboBox(REASON_COMBO_BOX_ITEMS);
    JTextField newQty = new JTextField(5);

    String barcode; //barcode of item being operated on


    public static void setControllers(HashMap controllers) {
        InventoryItemMenu.controllers = controllers;
    }


    JPanel cards;

    public InventoryItemMenu(String barcode, HashMap controllers, JFrame parent) {

        this.parent = parent;


        this.controllers = controllers; //set controller map
        this.barcode = barcode;

        //create title
        JLabel title = new JLabel("Item Menu");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        //create combo box for selecting operation on items
        JPanel comboBoxPane = new JPanel();
        String[] comboBoxItems = {REMOVEITEMPANEL, UPDATEITEMPANEL};
        JComboBox comboBox = new JComboBox(comboBoxItems);
        comboBox.setEditable(false);
        comboBox.addItemListener(this);
        comboBoxPane.add(comboBox);

        //remove item card
        JPanel removeItemCard = new JPanel();

        JButton confirmRemove = new JButton("Confirm Remove");
        JButton cancelRemove = new JButton("Cancel");

        confirmRemove.addActionListener(this);
        cancelRemove.addActionListener(this);


        removeItemCard.add(confirmRemove);
        removeItemCard.add(cancelRemove);

        //update qty card
        JPanel updateItemCard = new JPanel();


        JButton confirmUpdate = new JButton("Confirm Update");
        JButton cancelUpdate = new JButton("Cancel");

        confirmUpdate.addActionListener(this);
        cancelUpdate.addActionListener(this);


        LabelTextPanel newQtyPanel = new LabelTextPanel(new JLabel("New Qty"), newQty);


        reasonComboBox.setEditable(false);
        reasonComboBox.addActionListener(this);

        updateItemCard.add(newQtyPanel);
        updateItemCard.add(reasonComboBox);
        updateItemCard.add(confirmUpdate);
        updateItemCard.add(cancelUpdate);

        cards = new JPanel(new CardLayout());

        //Panel for cards
        cards.add(removeItemCard, REMOVEITEMPANEL);
        cards.add(updateItemCard, UPDATEITEMPANEL);
        this.getContentPane().add(comboBoxPane, BorderLayout.PAGE_START);
        this.getContentPane().add(cards, BorderLayout.CENTER);


        this.pack();
        this.setVisible(true);


    }

    //listener for combo box
    @Override
    public void itemStateChanged(ItemEvent evt) {
        CardLayout c = (CardLayout) (cards.getLayout());
        c.show(cards, (String) evt.getItem());
    }

    //listener for button
    @Override
    public void actionPerformed(ActionEvent evt) {
        if (evt.getActionCommand().equals("Cancel")) {
            this.dispose();
        } else if (evt.getActionCommand().equals("Confirm Remove")) {
            RemoveItemController removeItemController = (RemoveItemController) controllers.get("removeItemController");
            removeItemController.create(barcode);

            //dispose old inventory
            parent.dispose();
            this.dispose();
        } else if (evt.getActionCommand().equals("Confirm Update")) {
            UpdateItemQtyController updateItemQtyController = (UpdateItemQtyController) controllers.get("updateItemQtyController");
            updateItemQtyController.create(barcode, (String) reasonComboBox.getSelectedItem(), Double.parseDouble(newQty.getText()));

            //dispose old inventory
            parent.dispose();
            this.dispose();
        }
    }


}
