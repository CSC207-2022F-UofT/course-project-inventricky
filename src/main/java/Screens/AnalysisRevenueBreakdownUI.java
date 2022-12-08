package Screens;

import javax.swing.*;

public class AnalysisRevenueBreakdownUI extends JFrame {
    /**
     * This UI calls the controller to do the revenue breakdown feature
     * @param controller this UI takes the AnalysisController as a parameter
     */
    public AnalysisRevenueBreakdownUI(AnalysisController controller){
        controller.makeRevenueArray();
    }
}
