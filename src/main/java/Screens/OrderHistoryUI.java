package Screens;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalDate;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class OrderHistoryUI extends JFrame implements ActionListener{
    OrderingController orderController;
    ReceivingController receiveController;
    DefaultTableModel model = new DefaultTableModel();
    JTable table = new JTable(model);
    static String selectedOrderName;
    static String selectedCasesBought;
    static JFrame parent;
    public static void setParent(JFrame parent3) {
        parent = parent3;
    }
    static String dateReceived;

    /**
     * Construct a new screen for displaying all orders.
     * @param orderViewModel        order view model to update order history.
     * @param orderController       order use case controller.
     * @param receiveController     receive use case controller.
     */
    public OrderHistoryUI(OrderHistoryViewModel orderViewModel, OrderingController orderController,
                          ReceivingController receiveController) {
        // create panel, buttons, title
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        this.setSize(700, 1000);
        JLabel title = new JLabel("Order History");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        JButton button = new JButton("Place Order");
        JButton receivingButton = new JButton("Receive Order");
        JPanel buttons = new JPanel();
        buttons.add(button);
        buttons.add(receivingButton);
        button.addActionListener(this);
        receivingButton.addActionListener(this);

        // add columns
        table.setShowGrid(false);
        model.addColumn("Name");
        model.addColumn("Barcode");
        model.addColumn("Date Bought");
        model.addColumn("Estimated Date");
        model.addColumn("Date Received");
        model.addColumn("Supplier");
        model.addColumn("Cases Bought");
        panel.add(buttons);

        this.orderController = orderController;
        this.receiveController = receiveController;

        // add orders to table
        for (int i = orderViewModel.getOrderList().length - 1; i >= 0; i--) {
            model.addRow(orderViewModel.getOrderList()[i]);
        }
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        ListSelectionModel rowSelectionModel = table.getSelectionModel();
        rowSelectionModel.addListSelectionListener(new ListSelectionListener() {

            /**
             * When a row is clicked within the order history table, store the order name and cases bought
             * and set the date received.
             * @param e the event that characterizes the change.
             */
            @Override
            public void valueChanged(ListSelectionEvent e) {
                selectedOrderName = (String) table.getValueAt(table.getSelectedRow(), 0);
                selectedCasesBought = (String) table.getValueAt(table.getSelectedRow(), 6);
                dateReceived = LocalDate.now().toString();

            }
        });


        JScrollPane scroll = new JScrollPane(table);
        this.add(scroll);

        //Adding Components to the frame.
        this.getContentPane().add(BorderLayout.SOUTH, panel);
        this.getContentPane().add(BorderLayout.CENTER, scroll);
        this.getContentPane().add(BorderLayout.NORTH, title);
        this.setVisible(true);

    }

    /**
     * If the user clicks the button, "Place Order", close the order history screen and open the order window
     * screen. If the user clicks the button, "Receive Order", check if the order has not been received yet and if so,
     * receive the order.
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Place Order")) {
            new OrderWindowUI(orderController, parent);
            this.dispose();
        }
        else if(e.getActionCommand().equals("Receive Order")){
            if(selectedOrderName != null && table.getValueAt(table.getSelectedRow(), 4).equals("")){
                InventoryUI.setOrderViewModel(receiveController.updateShipmentStatus(selectedOrderName,
                        dateReceived, parent));
                this.dispose();

            }
        }
    }

}
