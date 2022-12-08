
package Screens;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class FilterUI extends JFrame {

    /**
     *
     * @param inventoryViewModel contains the items in the inventory
     * @param controllers map of controllers needed
     */
    public FilterUI(InventoryViewModel inventoryViewModel, HashMap controllers){

            JFrame f = new JFrame("Filter");
            //set size and location of frame
            f.setSize(390, 300);
            f.setLocation(100, 150);
            //set look and feel
            JLabel labelM = new JLabel("Enter department number to filter by:");
            labelM.setBounds(50, 50, 500, 30);
            JTextField motto1 = new JTextField();
            //set size of the text box
            motto1.setBounds(50, 100, 200, 30);
            //add elements to the frame
            f.add(labelM);
            f.add(motto1);
            f.setLayout(null);
            f.setVisible(true);

            JButton button = new JButton("Filter");
            button.setBounds(20, 150, 80, 30);
            f.add(button);

            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    f.setVisible(false);
                    f.dispose();
                    DisplayController displayController = (DisplayController) controllers.get("displayController");
                    displayController.create(inventoryViewModel, "filterDepartment", motto1.getText());
                }
            });
        }
}

