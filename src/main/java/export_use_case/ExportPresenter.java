package export_use_case;

import Screens.ExportViewModel;

public interface ExportPresenter {
    /**
     * Abasract Interface that connects the UI to the exporter. Responsible for calling the PrepareSuccessView
     * to present the "export successful" screen.
     */

    ExportViewModel PrepareSuccessView();
    }

