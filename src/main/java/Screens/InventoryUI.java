package Screens;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class InventoryUI extends JFrame {

    private static HashMap controllers; //controllers for use cases

    public HashMap getControllers() {
        return controllers;
    }

    public void setControllers(HashMap controllers) {
        InventoryUI.controllers = controllers;
    }

    public InventoryUI(InventoryViewModel inventoryViewModel) {
//        JFrame frame = new JFrame("Inventory Menu");
        this.setTitle("Inventory");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(300, 300);
        this.setVisible(true);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);

        //Creating the MenuBar and adding components
        JMenuBar mb = new JMenuBar();


        //create menu for inventory items
        JMenu InventoryItemsMenu = new JMenu("Inventory Items");

        JMenu addItemSelect = new JMenu("Add New Item");
        InventoryItemsMenu.add(addItemSelect);

        JMenu removeItemSelect = new JMenu("Remove Item");
        InventoryItemsMenu.add(removeItemSelect);


        JMenu orders = new JMenu("Orders");
        JMenu generate_analysis = new JMenu("Generate Analysis");
        JMenu delete_inventory = new JMenu("Delete Inventory");
        JMenu history = new JMenu("Inventory History");
        JMenu sort = new JMenu("Sort");
        mb.add(InventoryItemsMenu);
        mb.add(orders);
        mb.add(generate_analysis);
        mb.add(delete_inventory);
        mb.add(history);
        mb.add(sort);
        JMenuItem m11 = new JMenuItem("Analysis 1");
        JMenuItem m22 = new JMenuItem("Analysis 2");
        JMenuItem sort1 = new JMenuItem("Sort by Name");
        generate_analysis.add(m11);
        generate_analysis.add(m22);
        sort.add(sort1);


        //Add a new item to inventory
        addItemSelect.addMenuListener(new MenuListener() {
            @Override
            public void menuSelected(MenuEvent e) {

            }

            @Override
            public void menuDeselected(MenuEvent e) {

            }

            @Override
            public void menuCanceled(MenuEvent e) {

            }
        });
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

//        history.addMenuListener(new MenuListener() {
//            @Override
////            public void menuSelected(MenuEvent e) {
//////                Inventory inv = new InventoryImportBuilder("test", "src/main/java/exports/serializable_inventory.txt").create();
//////                inv.updateHistory("test");
////                inventory.updateHistory("test");
////                String[] list = inventory.getHistory().toArray(new String[0]);
////                JFrame frame = new JFrame();
////                JList l = new JList<String>(list);
////                frame.add(l);
////                frame.pack();
////                frame.setSize(400, 400);
////                frame.getContentPane().add(BorderLayout.CENTER, l);
////                frame.setVisible(true);
////            }
//
//            @Override
//            public void menuDeselected(MenuEvent e) {
//
//            }
//
//            @Override
//            public void menuCanceled(MenuEvent e) {
//
//            }
//        });

        //Creating the panel at bottom and adding components
        JPanel panel = new JPanel(); // the panel is not visible in output
        // accepts upto 10 characters
        JButton hist = new JButton("History");
        JButton newItem = new JButton("Add New Item");
        JButton removeItem = new JButton("Remove Item");

        // Components Added using Flow Layout
        panel.add(hist);
        panel.add(newItem);
        panel.add(removeItem);

//        hist.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                JFrame frame = new JFrame();
//                String[] list = inventory.getHistory().toArray(new String[0]);
//                JList l = new JList<String>(list);
//                frame.add(l);
//                frame.pack();
//                frame.setSize(400, 400);
//                frame.getContentPane().add(BorderLayout.CENTER, l);
//                frame.setVisible(true);
//            }
//        });


        //action listener for making new item
        newItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddNewItemUI((NewItemController) controllers.get("newItemController"));
            }

            private void removeVisible() {
                InventoryUI.super.setVisible(false);
            }
        });

        //action listener for removing item
//        removeItem.addActionListener((new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                new RemoveItemUI((RemoveItemController) controllers.get("removeItemController"));
//            }
//        }));


        // Table at the Center

        DefaultTableModel model = new DefaultTableModel();
        JTable ta = new JTable(model);
        ta.setShowGrid(true);

        model.addColumn("Name");
        model.addColumn("Quantity");
        model.addColumn("Barcode");

        for (int i = inventoryViewModel.getItemList().length - 1; i >= 0; i--) {
            model.addRow(inventoryViewModel.getItemList()[i]);
        }

        //open item UI for selected item
        ta.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        ListSelectionModel rowSelectionModel = ta.getSelectionModel();
        rowSelectionModel.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                //get barcode of selected item
                String selectedItemBarcode = (String) ta.getValueAt(ta.getSelectedRow(), 2);
                System.out.println("11122");
                if (!e.getValueIsAdjusting()) {

                    new InventoryItemMenu(selectedItemBarcode, controllers);
                }
            }
        });


        JScrollPane scroll = new JScrollPane(ta);
        this.add(scroll);

        //Adding Components to the frame.
        this.getContentPane().add(BorderLayout.SOUTH, panel);
        this.getContentPane().add(BorderLayout.NORTH, mb);
        this.getContentPane().add(BorderLayout.CENTER, scroll);
        this.setVisible(true);
    }
}
