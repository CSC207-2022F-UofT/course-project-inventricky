package Screens;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.HashMap;
import java.util.Objects;

public class InventoryItemMenu extends JFrame implements ActionListener, ItemListener {

    private final JFrame parent;
    private static HashMap<String, Object> controllers; //controllers for use cases
    final static String REMOVEITEMPANEL = "Remove Item";
    final static String UPDATEITEMPANEL = "Update Item Quantity";

    final static String[] REASON_COMBO_BOX_ITEMS = {"Bought", "Sold", "Error"};

    JComboBox<String> reasonComboBox = new JComboBox<String>(REASON_COMBO_BOX_ITEMS);
    JTextField qtyInput = new JTextField(5);

    String barcode; //barcode of item being operated on

    /** Static method for setting controller map class variable.
     *
     * @param controllers   mapping of controller names to controllers.
     */
    public static void setControllers(HashMap<String, Object> controllers) {
        InventoryItemMenu.controllers = controllers;
    }


    JPanel cards;

    /** Construct new inventory item menu screen for selected item.
     *
     * @param barcode           barcode of selected item.
     * @param controllerMap     mapping of controller names to controllers.
     * @param parent            parent InventoryUI screen.
     */
    public InventoryItemMenu(String barcode, HashMap<String, Object> controllerMap, JFrame parent) {

        this.parent = parent;


        controllers = controllerMap; //set controller map
        this.barcode = barcode;

        //create title
        JLabel title = new JLabel("Item Menu");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        //create combo box for selecting operation on items
        JPanel comboBoxPane = new JPanel();
        String[] comboBoxItems = {REMOVEITEMPANEL, UPDATEITEMPANEL};
        JComboBox<String> comboBox = new JComboBox<String>(comboBoxItems);
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
        JButton getItemHistory = new JButton("Get Item History");

        confirmUpdate.addActionListener(this);
        cancelUpdate.addActionListener(this);
        getItemHistory.addActionListener(this);


        LabelTextPanel newQtyPanel = new LabelTextPanel(new JLabel(), qtyInput);


        reasonComboBox.setEditable(false);
        reasonComboBox.addActionListener(this);

        updateItemCard.add(newQtyPanel);
        updateItemCard.add(reasonComboBox);
        updateItemCard.add(confirmUpdate);
        updateItemCard.add(cancelUpdate);
        updateItemCard.add(getItemHistory);

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

    /** Invoked when combo box option is selected.
     *
     * @param evt the event to be processed
     */
    @Override
    public void itemStateChanged(ItemEvent evt) {
        CardLayout c = (CardLayout) (cards.getLayout());
        c.show(cards, (String) evt.getItem());
    }

    //listener for button

    /** Invoked when button is clicked.
     *
     * @param evt the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent evt) {
        if (evt.getActionCommand().equals("Cancel")) {
            this.dispose();
        } else if (evt.getActionCommand().equals("Confirm Remove")) {
            RemoveItemController removeItemController = (RemoveItemController) controllers.get("removeItemController");
            removeItemController.removeItem(barcode);

            //dispose old inventory
            parent.dispose();
            this.dispose();
        } else if (evt.getActionCommand().equals("Confirm Update")) {
            UpdateItemQtyController updateItemQtyController = (UpdateItemQtyController) controllers.get("updateItemQtyController");
            updateItemQtyController.update(barcode, (String) reasonComboBox.getSelectedItem(), Double.parseDouble(qtyInput.getText()));

            //if item history is open
            if (ItemHistoryScreen.getOpenScreen(barcode) != null) {
                //dispose screen
                Objects.requireNonNull(ItemHistoryScreen.getOpenScreen(barcode)).dispose();
                //draw new item history screen
                updateItemQtyController.update(barcode, "history", 1.0);
            }

            //dispose old inventory
            parent.dispose();
            this.dispose();
        } else if (evt.getActionCommand().equals("Get Item History")) {
            UpdateItemQtyController updateItemQtyController = (UpdateItemQtyController) controllers.get("updateItemQtyController");
            updateItemQtyController.update(barcode, "history", 1.0);



        }

    }


}

