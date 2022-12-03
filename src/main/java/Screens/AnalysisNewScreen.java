package Screens;

import javax.swing.*;

public class AnalysisNewScreen extends JFrame {
    /**
     * This creates a new screen using JFrame
     * @param list the list contains the data to output
     */
    public AnalysisNewScreen(String[] list){
        JList l = new JList<>(list);
        this.add(l);
        this.setSize(600,400);
        // this.setDefaultCloseOperation(EXIT_ON_CLOSE); used for testing only
        this.setVisible(true);

    }
}
