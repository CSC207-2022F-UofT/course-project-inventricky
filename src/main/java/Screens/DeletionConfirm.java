package Screens;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class DeletionConfirm extends JFrame {

    public DeletionConfirm(InventoryUI parent, HashMap controllers) {
        this.setTitle("Confirm Delete");
        setVisible(true);
        setSize(300,300);
        JPanel panel = new JPanel();
        JLabel title = new JLabel("Are you sure you want to delete the inventory? This action cannot be undone.");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        JButton confirmDelete = new JButton("Delete");
        panel.add(title);
        panel.add(confirmDelete);
        this.add(panel);

        confirmDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                this.dispose();
                parent.dispose();
                new MainCreationUI(controllers);
            }

            private void dispose() {
                DeletionConfirm.super.dispose();
            }
        });
    }
}
