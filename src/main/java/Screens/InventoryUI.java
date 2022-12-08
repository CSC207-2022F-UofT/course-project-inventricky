package Screens;

import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class InventoryUI extends JFrame {

    private static String historyFirst;

    private static HashMap<String, Object> controllers; //controllers for use cases

    private static String name; //inventory name

    private static boolean isNew; //true if inventory created from scratch

    private static OrderHistoryViewModel orderViewModel = new OrderHistoryViewModel(new String[][] {});

    /** Sets inventory name.
     * @param name New name of the Inventory.
     */
    public void setName(String name) {
        InventoryUI.name = name;
    }

    /** Sets the controller.
     * @param controllers The controllers to be set.
     */
    public void setControllers(HashMap<String, Object> controllers) {
        InventoryUI.controllers = controllers;
    }

    /** Sets the isNew boolean.
     * @param bool Whether the inventory is new.
     */
    public void setIsNew(boolean bool) {
        isNew = bool;
    }

    /** Sets order view model.
     * @param orderHistoryViewModel Order view model to be set.
     */
    public static void setOrderViewModel(OrderHistoryViewModel orderHistoryViewModel){
        orderViewModel = orderHistoryViewModel;
    }

    /** Returns the name of the inventory.
     * @return Inventory name.
     */
    public static String getInvName() {
        return name;
    }

    /** Sets the inital event for iventory history.
     * @param historyFirstLine The first event of inventory history.
     */
    public static void setHistoryFirst(String historyFirstLine) {
        historyFirst = historyFirstLine;
    }

    /**
     * Initializes an InventoryUI for the inventory. This UI is responsible for displaying items as well as the options for
     * Orders, Analysis, etc.
     */
    public InventoryUI(InventoryViewModel inventoryViewModel) {

        this.setTitle(name);
        InventoryUI invUI = this;

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {

                //If window is closed and the inventory is a new inventory, clear temporary barcode file
                if (isNew) {
                    try {
                        //overwrite file
                        PrintWriter pw = new PrintWriter("src/main/java/temp_files/new_inventory_barcodes.csv");
                        pw.close();
                    } catch (FileNotFoundException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            }
        });

        this.setSize(300, 300);
        this.setVisible(true);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);

        //Creating the MenuBar and adding components
        JMenuBar mb = new JMenuBar();


        JMenu orders = new JMenu("Orders");
        JMenu generate_analysis = new JMenu("Generate Analysis");
        JMenu delete_inventory = new JMenu("Delete Inventory");
        JMenu sort = new JMenu("Sort");
        JMenu filter1 = new JMenu("Filter");
        JMenu search1 = new JMenu("Search");
        JMenuItem filter = new JMenuItem("Filter");
        JMenuItem search = new JMenuItem("Search");

        mb.add(orders);
        mb.add(generate_analysis);
        mb.add(delete_inventory);
        mb.add(sort);
        mb.add(filter1);
        mb.add(search1);

        JMenuItem deletion = new JMenuItem("Confirm Delete");
        JMenuItem analysis11 = new JMenuItem("Revenue Breakdown");
        JMenuItem analysis22 = new JMenuItem("Cost Breakdown");
        JMenuItem analysis33 = new JMenuItem("Profit/Loss Calculator");
        generate_analysis.add(analysis11);
        generate_analysis.add(analysis22);
        generate_analysis.add(analysis33);
        delete_inventory.add(deletion);
        filter1.add(filter);
        search1.add(search);

        JMenuItem orderHistory = new JMenuItem("Order History");
        orders.add(orderHistory);

        orderHistory.addActionListener(e -> doOrderHistoryAction());

        analysis11.addActionListener(e -> new AnalysisRevenueBreakdownUI((AnalysisController) controllers.get("analysisController")));

        analysis22.addActionListener(e -> new AnalysisCostsBreakdownUI((AnalysisController) controllers.get("analysisController")));

        analysis33.addActionListener(e -> new AnalysisProfitLossCalculatorUI((AnalysisController) controllers.get("analysisController")));

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


        search.addActionListener(e -> new SearchUI(inventoryViewModel, controllers));

        filter.addActionListener(e -> new FilterUI(inventoryViewModel,  controllers));
        sort11.addActionListener(e -> {
            DisplayController displayController = (DisplayController) controllers.get("displayController");
            displayController.create(inventoryViewModel, "sortName", true);
        });
        sort12.addActionListener(e -> {
            DisplayController displayController = (DisplayController) controllers.get("displayController");
            displayController.create(inventoryViewModel, "sortName", false);
        });
        sort21.addActionListener(e -> {
            DisplayController displayController = (DisplayController) controllers.get("displayController");
            displayController.create(inventoryViewModel, "sortBarcode", false);
        });
        sort22.addActionListener(e -> {
            DisplayController displayController = (DisplayController) controllers.get("displayController");
            displayController.create(inventoryViewModel, "sortBarcode", true);
        });
        sort31.addActionListener(e -> {
            DisplayController displayController = (DisplayController) controllers.get("displayController");
            displayController.create(inventoryViewModel, "sortBuyPrice", false);
        });
        sort32.addActionListener(e -> {
            DisplayController displayController = (DisplayController) controllers.get("displayController");
            displayController.create(inventoryViewModel, "sortBuyPrice", true);
        });sort41.addActionListener(e -> {
            DisplayController displayController = (DisplayController) controllers.get("displayController");
            displayController.create(inventoryViewModel, "sortSellPrice", false);
        });
        sort42.addActionListener(e -> {
            DisplayController displayController = (DisplayController) controllers.get("displayController");
            displayController.create(inventoryViewModel, "sortSellPrice", true);
        });sort51.addActionListener(e -> {
            DisplayController displayController = (DisplayController) controllers.get("displayController");
            displayController.create(inventoryViewModel, "sortQuantity", false);
        });
        sort52.addActionListener(e -> {
            DisplayController displayController = (DisplayController) controllers.get("displayController");
            displayController.create(inventoryViewModel, "sortQuantity", true);
        });
        sort61.addActionListener(e -> {
            DisplayController displayController = (DisplayController) controllers.get("displayController");
            displayController.create(inventoryViewModel, "sortCaseQuantity", false);
        });
        sort62.addActionListener(e -> {
            DisplayController displayController = (DisplayController) controllers.get("displayController");
            displayController.create(inventoryViewModel, "sortCaseQuantity", true);
        });

        deletion.addActionListener(e -> new DeletionConfirm(invUI, controllers));

        //Creating the panel at bottom and adding components
        JPanel panel = new JPanel(); // the panel is not visible in output
        // accepts upto 10 characters
        JButton hist = new JButton("History");
        JButton newItem = new JButton("Add New Item");
        JButton export = new JButton("Export");


        // Components Added using Flow Layout
        panel.add(hist);
        panel.add(newItem);
        panel.add(export);

        hist.addActionListener(e -> {
            JFrame frame = new JFrame();
            ArrayList<String> stringList = new ArrayList<>(Arrays.asList(inventoryViewModel.getInventoryHistory()));
            stringList.add(0, historyFirst);
            String[] list = stringList.toArray(new String[0]);
            JList<String> l = new JList<>(list);
            frame.add(l);
            frame.pack();
            frame.setSize(400, 400);
            frame.getContentPane().add(BorderLayout.CENTER, l);
            frame.setVisible(true);
        });

        export.addActionListener(actionEvent -> {
            ExportController controller = (ExportController) controllers.get("exportController");
            try {
                controller.create(name, inventoryViewModel.getItemList());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });


        //action listener for making new item
        newItem.addActionListener(e -> doNewItemAction());

        // Table at the Center

        DefaultTableModel model = new DefaultTableModel();
        JTable ta = new JTable(model);
        ta.setShowGrid(true);

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

        //open item UI for selected item
        ta.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        ListSelectionModel rowSelectionModel = ta.getSelectionModel();
        rowSelectionModel.addListSelectionListener(e -> {
            //get barcode of selected item
            String selectedItemBarcode = (String) ta.getValueAt(ta.getSelectedRow(), 2);
            if (!e.getValueIsAdjusting()) {

                doItemMenuAction(selectedItemBarcode);


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

    private void doNewItemAction() {
        new AddNewItemUI((NewItemController) controllers.get("newItemController"), this);
    }

    private void doItemMenuAction(String selectedItemBarcode) {
        new InventoryItemMenu(selectedItemBarcode, controllers, this);
    }

    public void refresh() {
        this.setTitle(name);
        SwingUtilities.updateComponentTreeUI(this);


    }

    private void doOrderHistoryAction() {
        new OrderHistoryUI(orderViewModel, (OrderingController) controllers.get("orderingController"),
                (ReceivingController) controllers.get("receivingController"));
        OrderHistoryUI.setParent(this);
    }
}
