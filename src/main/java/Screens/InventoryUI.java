package Screens;

import entities.*;
import useCases.InventoryImportBuilder;

import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class InventoryUI extends JFrame{

    public InventoryUI(Inventory inventory) {
//        JFrame frame = new JFrame("Inventory Menu");
        this.setTitle(inventory.getName() + " Inventory Menu");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(300, 300);
        this.setVisible(true);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);

        //Creating the MenuBar and adding components
        JMenuBar mb = new JMenuBar();
        JMenu m1 = new JMenu("Inventory Items");
        JMenu orders = new JMenu("Orders");
        JMenu generate_analysis = new JMenu("Generate Analysis");
        JMenu delete_inventory = new JMenu("Delete Inventory");
        JMenu history = new JMenu("Inventory History");
        JMenu sort = new JMenu("Sort");
        JMenu filter = new JMenu("Filter");
        JButton search = new JButton("Search");
        mb.add(m1);
        mb.add(orders);
        mb.add(generate_analysis);
        mb.add(delete_inventory);
        mb.add(history);
        mb.add(sort);
        mb.add(filter);
        mb.add(search);
        JMenuItem filter1 = new JMenuItem("Items Sold by Weight");
        JMenuItem filter2 = new JMenuItem("Items Sold by Quantity");
        JMenuItem filter3 = new JMenuItem("Filter by Department");
        JMenuItem m11 = new JMenuItem("Analysis 1");
        JMenuItem m22 = new JMenuItem("Analysis 2");
        JMenu sort1 = new JMenu("Sort by Name");
        JMenu sort2 = new JMenu("Sort by Barcode");
        JMenu sort3 = new JMenu("Sort by Buy Price");
        JMenu sort4 = new JMenu("Sort by Sell Price");
        JMenu sort5 = new JMenu("Sort by Quantity");
        JMenu sort6 = new JMenu("Sort by Case Quantity");
        JMenuItem sort11 = new JMenuItem("Reverse Alphabetical");
        JMenuItem sort12 = new JMenuItem("Alphabetical");
        JMenuItem sort21 = new JMenuItem("Low to High");
        JMenuItem sort22 = new JMenuItem("High to Low");
        JMenuItem sort31 = new JMenuItem("Low to High");
        JMenuItem sort32 = new JMenuItem("High to Low");
        JMenuItem sort41 = new JMenuItem("Low to High");
        JMenuItem sort42 = new JMenuItem("High to Low");
        JMenuItem sort51 = new JMenuItem("Low to High");
        JMenuItem sort52 = new JMenuItem("High to Low");
        JMenuItem sort61 = new JMenuItem("Low to High");
        JMenuItem sort62 = new JMenuItem("High to Low");
        generate_analysis.add(m11);
        generate_analysis.add(m22);
        filter.add(filter1);
        filter.add(filter2);
        filter.add(filter3);
        sort.add(sort1);
        sort.add(sort2);
        sort.add(sort3);
        sort.add(sort4);
        sort.add(sort5);
        sort.add(sort6);
        sort1.add(sort11);
        sort1.add(sort12);
        sort2.add(sort21);
        sort2.add(sort22);
        sort3.add(sort31);
        sort3.add(sort32);
        sort4.add(sort41);
        sort4.add(sort42);
        sort5.add(sort51);
        sort5.add(sort52);
        sort6.add(sort61);
        sort6.add(sort62);

        Sort sorty = new Sort();
        Filter filtery = new Filter();

        search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SearchUI(inventory.getItems());
            }
        });

        filter1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new DisplayUI(filtery.filterByWeight(inventory.getItems(), true));
            }
        });
        filter2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new DisplayUI(filtery.filterByWeight(inventory.getItems(), false));
            }
        });
        filter3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new FilterUI(inventory.getItems());

            }
        });
        sort11.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new DisplayUI(sorty.sortName(inventory.getItems() ,false));
            }
        });
        sort12.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new DisplayUI(sorty.sortName(inventory.getItems() ,true));
            }
        });
        sort21.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new DisplayUI(sorty.sortBarcode(inventory.getItems() ,true));
            }
        });
        sort22.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new DisplayUI(sorty.sortBarcode(inventory.getItems() ,false));
            }
        });
        sort31.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new DisplayUI(sorty.sortBuyPrice(inventory.getItems() ,true));
            }
        });
        sort32.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new DisplayUI(sorty.sortBuyPrice(inventory.getItems() ,false));
            }
        });sort41.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new DisplayUI(sorty.sortSellPrice(inventory.getItems() ,true));
            }
        });
        sort42.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new DisplayUI(sorty.sortSellPrice(inventory.getItems() ,false));
            }
        });sort51.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new DisplayUI(sorty.sortQuantity(inventory.getItems() ,true));
            }
        });
        sort52.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new DisplayUI(sorty.sortQuantity(inventory.getItems() ,false));
            }
        });
        sort61.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new DisplayUI(sorty.sortCaseQuantity(inventory.getItems() ,true));
            }
        });
        sort62.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new DisplayUI(sorty.sortCaseQuantity(inventory.getItems() ,false));
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

        history.addMenuListener(new MenuListener() {
            @Override
            public void menuSelected(MenuEvent e) {
//                Inventory inv = new InventoryImportBuilder("test", "src/main/java/exports/serializable_inventory.txt").create();
//                inv.updateHistory("test");
                inventory.updateHistory("test");
                String[] list = inventory.getHistory().toArray(new String[0]);
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
        JButton hist = new JButton("History");
        JButton newitem = new JButton("Add New Item");

        // Components Added using Flow Layout
        panel.add(hist);
        panel.add(newitem);

        hist.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame();
                String[] list = inventory.getHistory().toArray(new String[0]);
                JList l = new JList<String>(list);
                frame.add(l);
                frame.pack();
                frame.setSize(400, 400);
                frame.getContentPane().add(BorderLayout.CENTER, l);
                frame.setVisible(true);
            }
        });

        newitem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InventoryItem item0 = new InventoryItem("bananasss","183" , true, 10, 2,
                        3, 5, "1", 10, 0);
                InventoryItem item1 = new InventoryItem("a banana","182" , false, 5, 1,
                        2, 4, "2", 1, 1);
                InventoryItem item2 = new InventoryItem("apple", "2", false, 1, 4,
                        6, 11, "2", 6, 4);
                InventoryItem item3 = new InventoryItem("orange", "3",true, 7, 7,
                        5, 6, "4", 4, 5);
                InventoryItem item4 = new InventoryItem("nectarine", "4",false, 12, 9,
                        4, 9, "3", 2, 4);
                InventoryItem item5 = new InventoryItem("cookies", "5",true, 3, 3,
                        2, 3, "1", 3, 2);
                InventoryItem item6 = new InventoryItem("bread", "6",false, 11, 1,
                        1, 4, "3", 5, 8);
                InventoryItem item7 = new InventoryItem("banana", "7",true, 2, 4,
                        8, 3, "1", 9, 9);
                InventoryItem item8 = new InventoryItem("computer", "8",true, 4, 1,
                        6, 2, "1", 4, 7);
                InventoryItem item9 = new InventoryItem("mice", "9",false, 5, 6,
                        9, 1, "1", 2, 6);
                InventoryItem item10 = new InventoryItem("bags", "10",true, 6, 4,
                        4, 8, "1", 3, 8);
                inventory.addItem(item0);
                inventory.addItem(item1);
                inventory.addItem(item2);
                inventory.addItem(item3);
                inventory.addItem(item4);
                inventory.addItem(item5);
                inventory.addItem(item6);
                inventory.addItem(item7);
                inventory.addItem(item8);
                inventory.addItem(item9);
                inventory.addItem(item10);



                this.removeVisible();
                new InventoryUI(inventory);
            }

            private void removeVisible() {
                InventoryUI.super.setVisible(false);
            }
        });

        // Table at the Center

        DefaultTableModel model = new DefaultTableModel();
        JTable ta = new JTable(model);
        ta.setShowGrid(false);
        model.addColumn("Name");
        model.addColumn("Quantity");
        model.addColumn("Barcode");
        model.addColumn("Case Quantity");
        model.addColumn("Sell Price");
        model.addColumn("Buy Price");
        model.addColumn("Department");
        model.addColumn("Sold by Weight");


        for (int i = inventory.getItems().size() - 1; i >= 0; i--) {
            if(inventory.getItems().get(i).getIsWeight()) {
                model.insertRow(0, new String[]{inventory.getItems().get(i).getName(),
                        String.valueOf(inventory.getItems().get(i).getQuantity()), inventory.getItems().get(i).getBarcode(),
                String.valueOf(inventory.getItems().get(i).getCaseQuantity()), String.valueOf(inventory.getItems().get(i).getSellPrice()),
                        String.valueOf(inventory.getItems().get(i).getBuyPrice()), String.valueOf(inventory.getItems().get(i).getDepartment()),
                        "Yes"});
            }
            else{
                model.insertRow(0, new String[]{inventory.getItems().get(i).getName(),
                        String.valueOf(inventory.getItems().get(i).getQuantity()), inventory.getItems().get(i).getBarcode(),
                        String.valueOf(inventory.getItems().get(i).getCaseQuantity()), String.valueOf(inventory.getItems().get(i).getSellPrice()),
                        String.valueOf(inventory.getItems().get(i).getBuyPrice()), String.valueOf(inventory.getItems().get(i).getDepartment()),
                        "No"});
            }
        }

        JScrollPane scroll = new JScrollPane(ta);
        this.add(scroll);

        //Adding Components to the frame.
        this.getContentPane().add(BorderLayout.SOUTH, panel);
        this.getContentPane().add(BorderLayout.NORTH, mb);
        this.getContentPane().add(BorderLayout.CENTER, scroll);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        JFileChooser j = new JFileChooser();
        frame.add(j);
        frame.setSize(300,300);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setVisible(true);
        String d = j.getSelectedFile().getName();
        System.out.println(d);
    }
}
