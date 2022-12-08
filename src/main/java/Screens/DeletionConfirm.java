package Screens;

import delete_inventory_use_case.DeleteInventoryInputBoundary;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class DeletionConfirm extends JFrame {

    /** A JFrame to confirm the deletion of an inventory.
     * @param parent The InventoryUI associated with the deletion.
     * @param controllers The associated controllers.
     */
    public DeletionConfirm(InventoryUI parent, HashMap controllers) {
        this.setTitle("Confirm Delete");
        setVisible(true);
        setSize(500,100);
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
                DeletionController deletionController = (DeletionController) controllers.get("deletionController");
                deletionController.deleteInventory(parent.getName());
            }

            private void dispose() {
                DeletionConfirm.super.dispose();
            }
        });
    }
}
