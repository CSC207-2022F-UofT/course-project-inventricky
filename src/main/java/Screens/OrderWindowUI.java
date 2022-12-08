package Screens;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OrderWindowUI extends JFrame implements ActionListener{

    boolean weightValue = false;
    //text fields for user input
    JTextField name = new JTextField(15);
    JTextField supplier = new JTextField(15);
    JTextField cases = new JTextField(15);
    JTextField isWeight = new JTextField(15); //can be "true" or "false"
    //double 2 decimal places if isWeight true
    JTextField buyPrice = new JTextField(15);
    JTextField sellPrice = new JTextField(15);
    JTextField caseQuantity = new JTextField(15);
    JTextField department = new JTextField(15);
    OrderingController orderController; //controller
    JFrame parent;

    /**
     * Construct a new screen for ordering a new item.
     * @param controller    new order use case controller.
     * @param parent        previous order history screen.
     */

    public OrderWindowUI(OrderingController controller, JFrame parent) {

        //create new JPanel
        JPanel panel = new JPanel();

        //set size of frame
        this.setSize(400, 400);

        this.parent = parent;
        this.orderController = controller;

        //create title
        JLabel title = new JLabel("Place Order");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        //create text fields for inputting new order details

        LabelTextPanel namePanel = new LabelTextPanel(new JLabel("Name"), name);
        LabelTextPanel supplierPanel = new LabelTextPanel(new JLabel("Supplier"), supplier);
        LabelTextPanel casesPanel = new LabelTextPanel(new JLabel("Cases"), cases);

        LabelTextPanel buyPricePanel = new LabelTextPanel(new JLabel("Buy Price"), buyPrice);

        LabelTextPanel sellPricePanel = new LabelTextPanel(new JLabel("Sell Price"), sellPrice);

        LabelTextPanel caseQuantityPanel = new LabelTextPanel(new JLabel("Case Quantity"), caseQuantity);

        LabelTextPanel departmentPanel = new LabelTextPanel(new JLabel("Department"), department);

        ButtonSelector weight = new ButtonSelector();

        weight.setTitle(new JLabel("Sorted by Weight     "));

        weight.t.addActionListener(new ActionListener() {

            /**
             * Set weightValue to true when "True" button is pressed.
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                weightValue = true;
            }
        });

        weight.f.addActionListener(new ActionListener() {

            /**
             * Set weightValue to false when "False" button is pressed.
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                weightValue = false;
            }
        });

        //option to confirm order or cancel order creation
        JButton confirm = new JButton("Confirm");
        JButton cancel = new JButton("Cancel");

        JPanel buttons = new JPanel();
        buttons.add(confirm);
        buttons.add(cancel);

        confirm.addActionListener(this);
        cancel.addActionListener(this);

        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        panel.add(title);
        panel.add(namePanel);
        panel.add(supplierPanel);
        panel.add(casesPanel);
        panel.add(weight);
        panel.add(buyPricePanel);
        panel.add(sellPricePanel);
        panel.add(caseQuantityPanel);
        panel.add(departmentPanel);
        panel.add(buttons);

        this.getContentPane().add(panel);
        this.setVisible(true);


    }

    /**
     * If "Cancel" button is pressed, close the order window screen. Otherwise, add order to inventory.
     * @param evt the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent evt) {
        if (evt.getActionCommand().equals("Cancel")) {
            this.dispose();
            return;
        }
        InventoryUI.setOrderViewModel(orderController.addOrder(name.getText(), Boolean.parseBoolean(isWeight.getText()), Double.parseDouble(buyPrice.getText()),
                Double.parseDouble(sellPrice.getText()), Integer.parseInt(caseQuantity.getText()),
                department.getText(), supplier.getText(), Integer.parseInt(cases.getText()), parent));
        this.dispose();
    }
}
