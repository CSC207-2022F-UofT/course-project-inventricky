package Screens;

import entities.AnalysisController;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

public class InventoryUI extends JFrame {

    private static HashMap<String, Object> controllers; //controllers for use cases

    private static String name; //inventory name

    private static boolean isNew; //true if inventory created from scratch

    private static OrderHistoryViewModel orderViewModel = new OrderHistoryViewModel(new String[][] {});

    public void setName(String name) {
        InventoryUI.name = name;
    }

    public void setControllers(HashMap<String, Object> controllers) {
        InventoryUI.controllers = controllers;
    }

    public void setIsNew(boolean bool) {
        isNew = bool;
    }

    public static void setOrderViewModel(OrderHistoryViewModel orderHistoryViewModel){
        orderViewModel = orderHistoryViewModel;
    }

    public InventoryUI(InventoryViewModel inventoryViewModel) {
//        JFrame frame = new JFrame("Inventory Menu");
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
                        PrintWriter pw = new PrintWriter("src/main/java/temp_files/new_inventory_barcodes_temp.csv");
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
        JMenu filter = new JMenu("Filter");
        JButton search = new JButton("Search");

        mb.add(orders);
        mb.add(generate_analysis);
        mb.add(delete_inventory);
        mb.add(history);
        mb.add(sort);
        mb.add(filter);
        mb.add(search);

        JMenuItem deletion = new JMenuItem("Confirm Delete");
        JMenuItem analysis11 = new JMenuItem("Revenue Breakdown");
        JMenuItem analysis22 = new JMenuItem("Cost Breakdown");
        JMenuItem analysis33 = new JMenuItem("Profit/Loss Calculator");
        generate_analysis.add(analysis11);
        generate_analysis.add(analysis22);
        generate_analysis.add(analysis33);
        delete_inventory.add(deletion);

        JMenuItem orderHistory = new JMenuItem("Order History");
        orders.add(orderHistory);

        orderHistory.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                doOrderHistoryAction();

            }
        });

        analysis11.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AnalysisRevenueBreakdownUI((AnalysisController) controllers.get("analysisController"));
            }
        });

        analysis22.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AnalysisCostsBreakdownUI((AnalysisController) controllers.get("analysisController"));
            }
        });

        analysis33.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AnalysisProfitLossCalculatorUI((AnalysisController) controllers.get("analysisController"));
            }
        });

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


        search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SearchUI(inventoryViewModel, controllers);
            }
        });

        filter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new FilterUI(inventoryViewModel,  controllers);

            }
        });
        sort11.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DisplayController displayController = (DisplayController) controllers.get("displayController");
                displayController.create(inventoryViewModel, "sortName", false);
            }
        });
        sort12.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DisplayController displayController = (DisplayController) controllers.get("displayController");
                displayController.create(inventoryViewModel, "sortName", true);
            }
        });
        sort21.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DisplayController displayController = (DisplayController) controllers.get("displayController");
                displayController.create(inventoryViewModel, "sortBarcode", true);
            }
        });
        sort22.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DisplayController displayController = (DisplayController) controllers.get("displayController");
                displayController.create(inventoryViewModel, "sortBarcode", false);
            }
        });
        sort31.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DisplayController displayController = (DisplayController) controllers.get("displayController");
                displayController.create(inventoryViewModel, "sortBuyPrice", true);
            }
        });
        sort32.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DisplayController displayController = (DisplayController) controllers.get("displayController");
                displayController.create(inventoryViewModel, "sortBuyPrice", false);
            }
        });sort41.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DisplayController displayController = (DisplayController) controllers.get("displayController");
                displayController.create(inventoryViewModel, "sortSellPrice", true);
            }
        });
        sort42.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DisplayController displayController = (DisplayController) controllers.get("displayController");
                displayController.create(inventoryViewModel, "sortSellPrice", false);
            }
        });sort51.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DisplayController displayController = (DisplayController) controllers.get("displayController");
                displayController.create(inventoryViewModel, "sortQuantity", true);
            }
        });
        sort52.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DisplayController displayController = (DisplayController) controllers.get("displayController");
                displayController.create(inventoryViewModel, "sortQuantity", false);
            }
        });
        sort61.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DisplayController displayController = (DisplayController) controllers.get("displayController");
                displayController.create(inventoryViewModel, "sortCaseQuantity", true);
            }
        });
        sort62.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DisplayController displayController = (DisplayController) controllers.get("displayController");
                displayController.create(inventoryViewModel, "sortCaseQuantity", false);
            }
        });

        history.addMenuListener(new MenuListener() {
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
                new MainCreationUI(controllers);
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

        deletion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new DeletionConfirm(invUI, controllers);
            }
        });

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

        export.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                ExportController controller = (ExportController) controllers.get("exportController");
                try {
                    controller.create(name, inventoryViewModel.getItemList());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });


        //action listener for making new item
        newItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                doNewItemAction();



            }
        });

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
        rowSelectionModel.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                //get barcode of selected item
                String selectedItemBarcode = (String) ta.getValueAt(ta.getSelectedRow(), 2);
                if (!e.getValueIsAdjusting()) {

                    doItemMenuAction(selectedItemBarcode);


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
