package Screens;

import javax.swing.*;

public class AnalysisProfitLossCalculatorUI extends JFrame {
    /**
     * This UI calls the controller to make the profit/loss calculation feature
     * @param controller this UI takes the AnalysisController as a parameter
     */
    public AnalysisProfitLossCalculatorUI(AnalysisController controller){
        controller.makeProfitLossArray();
    }
}
