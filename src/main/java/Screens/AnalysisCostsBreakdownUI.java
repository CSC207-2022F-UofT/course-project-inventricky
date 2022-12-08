package Screens;

import javax.swing.*;

public class AnalysisCostsBreakdownUI extends JFrame{
    /**
     * This UI calls the controller to make the costs breakdown feature
     * @param controller this UI takes the AnalysisController as a parameter
     */
    public AnalysisCostsBreakdownUI(AnalysisController controller){
        controller.makeCostsArray();
    }
}
