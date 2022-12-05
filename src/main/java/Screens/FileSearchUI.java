package Screens;

import javax.swing.*;

public class FileSearchUI extends JFileChooser {
    int response = this.showOpenDialog(null);

    public FileSearchUI() {
        this.setSize(300,300);
        this.setVisible(true);
    }
}
