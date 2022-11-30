package Screens;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

//view
public class InventoryView extends JFrame {

    public InventoryView(InventoryViewModel inventoryViewModel) {
        this.setTitle("Inventory");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(300, 300);
        this.setVisible(true);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);

        //Creating the panel at bottom and adding components
        JPanel panel = new JPanel(); // the panel is not visible in output

        // Table at the Center

        DefaultTableModel model = new DefaultTableModel();
        JTable ta = new JTable(model);
        ta.setShowGrid(false);
        model.addColumn("Name");
        model.addColumn("Quantity");
        model.addColumn("Barcode");

        for (int i = inventoryViewModel.getItemList().length - 1; i >= 0; i--) {
            model.insertRow(0, inventoryViewModel.getItemList()[i]);
        }
            JScrollPane scroll = new JScrollPane(ta);
            this.add(scroll);

            //Adding Components to the frame.
            this.getContentPane().add(BorderLayout.SOUTH, panel);
            this.getContentPane().add(BorderLayout.CENTER, scroll);
            this.setVisible(true);
        }
    }

