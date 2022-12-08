package Screens;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddNewItemUI extends JFrame implements ActionListener{

    JFrame parent; //parent InventoryUI

    //text fields for user input
    JTextField name = new JTextField(15);
    JTextField buyPrice = new JTextField(15);
    JTextField sellPrice = new JTextField(15);
    JTextField caseQuantity = new JTextField(15);
    JTextField department = new JTextField(15);

    boolean weightValue = false;




    NewItemController newItemController; //controller

    /** Construct a new screen for adding a new item to inventory.
     *
     * @param controller    new item use case controller.
     * @param parent        parent InventoryUI screen.
     */
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

        LabelTextPanel namePanel = new LabelTextPanel(new JLabel("Name                        "), name);

        LabelTextPanel buyPricePanel = new LabelTextPanel(new JLabel("Price Bought            "), buyPrice);

        LabelTextPanel sellPricePanel = new LabelTextPanel(new JLabel("Selling Price            "), sellPrice);

        LabelTextPanel caseQuantityPanel = new LabelTextPanel(new JLabel("Case Quantity          "), caseQuantity);

        LabelTextPanel departmentPanel = new LabelTextPanel(new JLabel("Department Number"), department);

        ButtonSelector weight = new ButtonSelector();

        weight.t.addActionListener(e -> weightValue = true);

        weight.f.addActionListener(e -> weightValue = false);


        //option to confirm item or cancel item creation
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
        panel.add(weight);
        panel.add(buyPricePanel);
        panel.add(sellPricePanel);
        panel.add(caseQuantityPanel);
        panel.add(departmentPanel);
        panel.add(buttons);

        this.getContentPane().add(panel);
        this.setVisible(true);


        }

    /** Invoked when button is clicked.
     *
     * @param evt the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent evt) {
        if (evt.getActionCommand().equals("cancel")) {
            this.dispose();
        }


        //user has clicked button to create item, with all the parameters filled
        newItemController.addItem(name.getText(), weightValue,
                Double.parseDouble(buyPrice.getText()), Double.parseDouble(sellPrice.getText()),
                Integer.parseInt(caseQuantity.getText()), department.getText());

        //dispose old inventory
        parent.dispose();
        this.dispose();

    }
}

