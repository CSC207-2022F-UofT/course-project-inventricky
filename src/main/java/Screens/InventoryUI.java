package Screens;

import entities.Inventory;
import entities.InventoryItem;

import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        mb.add(m1);
        mb.add(orders);
        mb.add(generate_analysis);
        mb.add(delete_inventory);
        mb.add(history);
        mb.add(sort);
        JMenuItem analysis11 = new JMenuItem("Revenue Breakdown");
        JMenuItem analysis22 = new JMenuItem("Cost Breakdown");
        JMenuItem analysis33 = new JMenuItem("Profit/Loss Calculator");
        JMenuItem sort1 = new JMenuItem("Sort by Name");
        generate_analysis.add(analysis11);
        generate_analysis.add(analysis22);
        generate_analysis.add(analysis33);
        sort.add(sort1);

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

        analysis11.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AnalysisRevenueBreakdownUI(inventory);
            }
        });

        analysis22.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AnalysisCostsBreakdownUI(inventory);
            }
        });

        analysis33.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AnalysisProfitLossCalculatorUI(inventory);
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
                inventory.addItem(item0);
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

        for (int i = inventory.getItems().size() - 1; i >= 0; i--) {
            model.insertRow(0, new String[]{inventory.getItems().get(i).getName(), String.valueOf(inventory.getItems().get(i).getQuantity()), inventory.getItems().get(i).getBarcode()});
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
