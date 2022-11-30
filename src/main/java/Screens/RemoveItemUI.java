package Screens;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RemoveItemUI extends JFrame implements ActionListener {

    JTextField barcode = new JTextField(15); //barcode of item to be removed

    RemoveItemController removeItemController; //controller

    public RemoveItemUI(RemoveItemController controller) {

        //create new JPanel
        JPanel panel = new JPanel();

        //set size of frame
        this.setSize(200, 200);


        this.removeItemController = controller;

        //create title
        JLabel title = new JLabel("Remove Item");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        //create text fields for inputting new item details

        LabelTextPanel barcodePanel = new LabelTextPanel(new JLabel("Barcode:"), barcode);

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
        panel.add(barcodePanel);
        panel.add(buttons);

        this.getContentPane().add(panel);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        if (evt.getActionCommand().equals("cancel")) {

        }
        //user has clicked button to remove item, with all the parameters filled
        removeItemController.create(barcode.getText());
    }
}
