package Screens;

import export_use_case.ExportPresenter;

public class ExportInventoryUpdater implements ExportPresenter {
    /**
     * Class that implements abstract interface of Export Presenter
     * Calls the ExportSuccesfullUI class that displays the "export successful" screen
     * @return null
     */
    @Override
    public ExportViewModel PrepareSuccessView() {
        ExportSuccessfulUI succesfullUI = new ExportSuccessfulUI();
        succesfullUI.present();
        return null;
    }
}
