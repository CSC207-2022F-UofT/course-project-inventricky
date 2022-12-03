package Screens;
import entities.Inventory;
import entities.Order;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

public class OrderWindowUI extends JFrame implements ActionListener{
//    private boolean itemAdded;

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

    public OrderWindowUI(OrderingController controller) {

        //default item not added
//        this.itemAdded = false;

        //create new JPanel
        JPanel panel = new JPanel();

        //set size of frame
        this.setSize(400, 400);


        this.orderController = controller;

        //create title
        JLabel title = new JLabel("Place Order");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);



        //this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);   //close button exits inventory app


        //create text fields for inputting new item details

        LabelTextPanel namePanel = new LabelTextPanel(new JLabel("Name"), name);
        LabelTextPanel supplierPanel = new LabelTextPanel(new JLabel("Supplier"), supplier);
        LabelTextPanel casesPanel = new LabelTextPanel(new JLabel("Cases"), cases);
        LabelTextPanel isWeightPanel = new LabelTextPanel(new JLabel("isWeight"), isWeight);

        LabelTextPanel buyPricePanel = new LabelTextPanel(new JLabel("Buy Price"), buyPrice);

        LabelTextPanel sellPricePanel = new LabelTextPanel(new JLabel("Sell Price"), sellPrice);

        LabelTextPanel caseQuantityPanel = new LabelTextPanel(new JLabel("Case Quantity"), caseQuantity);

        LabelTextPanel departmentPanel = new LabelTextPanel(new JLabel("Department"), department);

        //option to confirm item or cancel item creation
        JButton confirm = new JButton("Confirm");
        JButton cancel = new JButton("cancel");

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
        panel.add(isWeightPanel);
        panel.add(buyPricePanel);
        panel.add(sellPricePanel);
        panel.add(caseQuantityPanel);
        panel.add(departmentPanel);
        panel.add(buttons);

        this.getContentPane().add(panel);
        this.setVisible(true);


    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        if (evt.getActionCommand().equals("Cancel")) {
            Inventory inv = new Inventory("poo pee");
            JFrame j3 = new OrderHistoryUI(inv);
            this.dispose();
            j3.setVisible(true);
        }




//        user has clicked button to create item, with all the parameters filled
//        orderController.create(name.getText(), Boolean.parseBoolean(isWeight.getText()),
//                Double.parseDouble(quantity.getText()), Double.parseDouble(buyPrice.getText()), Double.parseDouble(sellPrice.getText()),
//                Integer.parseInt(caseQuantity.getText()), department.getText());


    }
    public static void main(String[] args) {
        LocalDate dateToday = LocalDate.now();
        OrderingController controller = new OrderingController();
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
        new OrderWindowUI(controller);
    }
}
