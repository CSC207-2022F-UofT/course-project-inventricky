package Screens;

import entities.Inventory;
import entities.InventoryItem;
import entities.Order;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import javax.swing.table.DefaultTableModel;

public class OrderHistoryUI extends JFrame {

    Inventory inv = new Inventory("poo pee");

    OrderingController controller = new OrderingController();


    public OrderHistoryUI(Inventory inventory){
        JPanel panel = new JPanel();
        JButton button = new JButton("Place Order");
        this.add(panel);
        panel.add(button);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1000, 1000);
        this.setVisible(true);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame j2 = new OrderWindowUI(controller);
                this.dispose();
                j2.setVisible(true);
            }

            private void dispose() {
                OrderHistoryUI.super.dispose();
            }
        });

        DefaultTableModel model = new DefaultTableModel();
        JTable ta = new JTable(model);
        ta.setShowGrid(false);
        model.addColumn("Name");
        model.addColumn("Barcode");
        model.addColumn("Date Bought");
        model.addColumn("Estimated Date");
        model.addColumn("Date Received");
        model.addColumn("Supplier");
        model.addColumn("Cases Bought");

        for (int i = inventory.getItems().size() - 1; i >= 0; i--) {
            model.insertRow(0, new String[]{inventory.getItems().get(i).getName(), String.valueOf(inventory.getItems().get(i).getQuantity()), inventory.getItems().get(i).getBarcode()});
        }

        JScrollPane scroll = new JScrollPane(ta);
        this.add(scroll);

        //Adding Components to the frame.
        this.getContentPane().add(BorderLayout.SOUTH, panel);
        this.getContentPane().add(BorderLayout.CENTER, scroll);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        LocalDate dateToday = LocalDate.now();
        Inventory inv = new Inventory("pee pee");
        inv.addOrder(new Order("Pizza", "12345", true,
                5, 40, 60, 2, "69",
                dateToday.toString(), dateToday.plusDays(5).toString(), "moxies", 5));
        inv.addOrder(new Order("goop", "12346", true,
                1, 41, 70, 3, "62",
                dateToday.toString(), dateToday.plusDays(5).toString(), "mos", 9));
        inv.addOrder(new Order("poop", "12145", true,
                8, 48, 30, 2, "99",
                dateToday.toString(), dateToday.plusDays(5).toString(), "ies", 20));
        new OrderHistoryUI(inv);
    }


}
