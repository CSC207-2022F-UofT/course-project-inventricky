package Screens;

import javax.swing.*;

public class FileSearchUI extends JFileChooser {
    int response = this.showOpenDialog(null);

    /**
     * Creates a FileSearchUI for the user to select a file to import.
     */
    public FileSearchUI() {
        this.setSize(300,300);
        this.setVisible(true);
    }
}
