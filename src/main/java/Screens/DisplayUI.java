package Screens;

import entities.Importer;
import entities.Inventory;
import entities.InventoryItem;
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

public class DisplayUI extends JFrame{

    public DisplayUI(ArrayList<InventoryItem> displayItems) {
//        JFrame frame = new JFrame("Inventory Menu");
        this.setTitle("Items in the Inventory");
        this.setSize(300, 300);
        this.setVisible(true);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);

       
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


        for (int i = displayItems.size() - 1; i >= 0; i--) {
            if(displayItems.get(i).getIsWeight()) {
                model.insertRow(0, new String[]{displayItems.get(i).getName(),
                        String.valueOf(displayItems.get(i).getQuantity()), displayItems.get(i).getBarcode(),
                        String.valueOf(displayItems.get(i).getCaseQuantity()), String.valueOf(displayItems.get(i).getSellPrice()),
                        String.valueOf(displayItems.get(i).getBuyPrice()), String.valueOf(displayItems.get(i).getDepartment()),
                        "Yes"});
            }
            else{
                model.insertRow(0, new String[]{displayItems.get(i).getName(),
                        String.valueOf(displayItems.get(i).getQuantity()), displayItems.get(i).getBarcode(),
                        String.valueOf(displayItems.get(i).getCaseQuantity()), String.valueOf(displayItems.get(i).getSellPrice()),
                        String.valueOf(displayItems.get(i).getBuyPrice()), String.valueOf(displayItems.get(i).getDepartment()),
                        "No"});
            }
        }

        JScrollPane scroll = new JScrollPane(ta);
        this.add(scroll);


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
