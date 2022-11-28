package Screens;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ImportUI extends JFrame {
    JTextField username = new JTextField(15);
    /**
     * The password
     */
    JPasswordField password = new JPasswordField(15);

    public ImportUI() {
//        JFrame frame = new JFrame("Import Menu");
        this.setTitle("Import Menu");
        JLabel title = new JLabel("Import");
        this.setSize(400, 400);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.setVisible(true);

        TextPanel usernameInfo = new TextPanel(
                new JLabel("Inventory Name"), username);
        TextPanel passwordInfo = new TextPanel(
                new JLabel("File Name"), password);

        JButton create = new JButton("Create");
        JButton cancel = new JButton("Cancel");

        JPanel buttons = new JPanel();
        buttons.add(create);
        buttons.add(cancel);

        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame j2 = new MainCreationUI();
                j2.setDefaultCloseOperation(EXIT_ON_CLOSE);
                this.setVisible();
                j2.setVisible(true);
            }

            private void setVisible() {
                ImportUI.super.setVisible(false);
            }
        });

        create.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame j2 = new JFrame();
                j2.setSize(400,400);
                this.setVisible();
                j2.setVisible(true);
            }

            private void setVisible() {
                ImportUI.super.setVisible(false);
            }
        });

        JPanel main = new JPanel();
        main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));

        main.add(title);
        main.add(usernameInfo);
        main.add(passwordInfo);
        main.add(buttons);
        this.setContentPane(main);

//        this.pack();
    }

    public static void main(String[] args) {
        new ImportUI();
    }
}
