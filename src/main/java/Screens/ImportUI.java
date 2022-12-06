package Screens;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class ImportUI extends JFrame {
    JTextField fileName = new JTextField(15);
    ImportController importController;

    public ImportUI(HashMap controllers) {
        this.setTitle("Import Menu");
        JLabel title = new JLabel("Import");
        this.setSize(400, 100);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.setVisible(true);
        this.importController = (ImportController) controllers.get("importController");

        JButton create = new JButton("Create");
        JButton cancel = new JButton("Cancel");
        JButton search = new JButton("Search For File");

        JPanel buttons = new JPanel();
        buttons.add(search);
        buttons.add(cancel);

        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame j2 = new MainCreationUI(controllers);
                this.setVisible();
                j2.setVisible(true);
            }

            private void setVisible() {
                ImportUI.super.setVisible(false);
            }
        });

        search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FileSearchUI fileSearch = new FileSearchUI();
                if (fileSearch.response == JFileChooser.APPROVE_OPTION) {
//                    importController.create(invName.getText(), fileSearch.getSelectedFile().getPath());
                    String title = fileSearch.getSelectedFile().getName();
                    importController.create(title.substring(13,title.length() - 4), fileSearch.getSelectedFile().getPath());
                    this.dispose();
                }
            }

            private void dispose() {
                ImportUI.super.dispose();
            }
        });

        JPanel main = new JPanel();
        main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));

        main.add(title);
        main.add(buttons);
        this.setContentPane(main);
    }

}
