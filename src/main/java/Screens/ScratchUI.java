package Screens;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.HashMap;

public class ScratchUI extends JFrame{
    JTextField invName = new JTextField(15);

    public ScratchUI(HashMap controllers) {
        this.setTitle("New Inventory Menu");
        JLabel title = new JLabel("New Inventory");
        this.setSize(400, 400);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.setVisible(true);

        LabelTextPanel invInfo = new LabelTextPanel(new JLabel("Inventory Name"), invName);

        JButton create = new JButton("Create");
        JButton cancel = new JButton("Cancel");

        JPanel buttons = new JPanel();
        buttons.add(create);
        buttons.add(cancel);

        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame j2 = new MainCreationUI(controllers);
                j2.setDefaultCloseOperation(EXIT_ON_CLOSE);
                this.setVisible();
                j2.setVisible(true);
            }

            private void setVisible() {
                ScratchUI.super.setVisible(false);
            }
        });

        create.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InventoryViewModel blankViewModel = new InventoryViewModel(new String[][] {}, new String[]{});
                InventoryUI.setHistoryFirst("Created from scratch on " + LocalDate.now() + ".");
                InventoryUI newInventory = new InventoryUI(blankViewModel);
                newInventory.setIsNew(true);
                newInventory.setControllers(controllers);
                newInventory.setName(invName.getText());
                newInventory.refresh();
                this.setVisible();
            }

            private void setVisible() {
                ScratchUI.super.setVisible(false);
            }
        });

        JPanel main = new JPanel();
        main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));

        main.add(title);
        main.add(invInfo);
        main.add(buttons);
        this.setContentPane(main);
    }
}
