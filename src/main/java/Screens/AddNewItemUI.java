package Screens;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddNewItemUI extends JFrame implements ActionListener{

    private JFrame parent; //parent InventoryUI

    //text fields for user input
    JTextField name = new JTextField(15);
    JTextField isWeight = new JTextField(15); //can be "true" or "false"
    //double 2 decimal places if isWeight true
    JTextField quantity = new JTextField(15);
    JTextField buyPrice = new JTextField(15);
    JTextField sellPrice = new JTextField(15);
    JTextField caseQuantity = new JTextField(15);
    JTextField department = new JTextField(15);




    NewItemController newItemController; //controller

    public AddNewItemUI(NewItemController controller, JFrame parent) {

        this.parent = parent; //set parent

        //create new JPanel
        JPanel panel = new JPanel();

        //set size of frame
        this.setSize(400, 400);


        this.newItemController = controller;

        //create title
        JLabel title = new JLabel("Add New Item");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);



        //this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);   //close button exits inventory app
        

        //create text fields for inputting new item details

        LabelTextPanel namePanel = new LabelTextPanel(new JLabel("name input"), name);

        LabelTextPanel isWeightPanel = new LabelTextPanel(new JLabel("isWeight input"), isWeight);

        LabelTextPanel quantityPanel = new LabelTextPanel(new JLabel("quantity input"), quantity);

        LabelTextPanel buyPricePanel = new LabelTextPanel(new JLabel("buyPrice input"), buyPrice);

        LabelTextPanel sellPricePanel = new LabelTextPanel(new JLabel("sellPrice input"), sellPrice);

        LabelTextPanel caseQuantityPanel = new LabelTextPanel(new JLabel("caseQuantity input"), caseQuantity);

        LabelTextPanel departmentPanel = new LabelTextPanel(new JLabel("department input"), department);

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
        panel.add(isWeightPanel);
        panel.add(quantityPanel);
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
        if (evt.getActionCommand().equals("cancel")) {
            this.dispose();
        }


        //user has clicked button to create item, with all the parameters filled
        newItemController.create(name.getText(), Boolean.parseBoolean(isWeight.getText()),
                Double.parseDouble(quantity.getText()), Double.parseDouble(buyPrice.getText()), Double.parseDouble(sellPrice.getText()),
                Integer.parseInt(caseQuantity.getText()), department.getText());

        //dispose old inventory
        parent.dispose();
        this.dispose();

    }
}
