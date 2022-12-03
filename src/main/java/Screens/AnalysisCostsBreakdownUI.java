package Screens;

import entities.*;

import javax.swing.*;
import java.util.ArrayList;

public class AnalysisCostsBreakdownUI extends JFrame{
    /**
     * This UI calls the controller to make the costs breakdown feature
     * @param controller this UI takes the AnalysisController as a parameter
     */
    public AnalysisCostsBreakdownUI(AnalysisController controller){
        controller.makeCostsArray();
    }
}
