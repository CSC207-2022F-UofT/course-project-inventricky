package Screens;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class DisplayUI extends JFrame{


    /**
     *
     * @param inventoryViewModel Contains the items that are to be displayed
     */
    public DisplayUI(InventoryViewModel inventoryViewModel) {
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
        model.addColumn("Buy Price");
        model.addColumn("Sell Price");
        model.addColumn("Case Quantity");
        model.addColumn("Department");

        for (int i = inventoryViewModel.getItemList().length - 1; i >= 0; i--) {
            model.addRow(inventoryViewModel.getItemList()[i]);
        }


        JScrollPane scroll = new JScrollPane(ta);
        this.add(scroll);


    }


}
