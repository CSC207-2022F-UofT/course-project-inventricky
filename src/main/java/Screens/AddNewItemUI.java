package Screens;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddNewItemUI extends JPanel implements ActionListener{

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

    public AddNewItemUI(NewItemController controller) {

        this.newItemController = controller;

        //create title
        JLabel title = new JLabel("Add New Item");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

//        //set size of panel
//        this.setSize(200, 400);

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

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
        this.add(namePanel);
        this.add(isWeightPanel);
        this.add(quantityPanel);
        this.add(buyPricePanel);
        this.add(sellPricePanel);
        this.add(caseQuantityPanel);
        this.add(departmentPanel);
        this.add(buttons);

        }

    @Override
    public void actionPerformed(ActionEvent evt) {
        if (evt.getActionCommand().equals("cancel")) {

        }

        //user has clicked button to create item, with all the parameters filled
        newItemController.create(name.getText(), Boolean.parseBoolean(isWeight.getText()),
                Integer.parseInt(quantity.getText()), Double.parseDouble(buyPrice.getText()), Double.parseDouble(sellPrice.getText()),
                Integer.parseInt(caseQuantity.getText()), department.getText());


    }
}
