package entities.comparator;

import Screens.AnalysisNewScreen;
import analysis_use_case.NewAnalysisPresenter;

import javax.swing.*;

public class AnalysisScreenUpdater implements NewAnalysisPresenter {
    /**
     * Updates the screen implementing the NewAnalysisPresenter
     * @param list the list contains the data to be displayed on the screen
     */
    public void showArray(String[] list){
        new AnalysisNewScreen(list);
    }
}
