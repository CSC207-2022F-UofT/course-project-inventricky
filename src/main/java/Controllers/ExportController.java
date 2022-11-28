package Controllers;

import Presenters.ExportPresenter;
import entities.Exporter;
import entities.Inventory;

import java.io.IOException;

public class ExportController {

    private final Inventory inventory;
    /**
     * @param inventory to be exported
     * */
    public ExportController(Inventory inventory) {
        this.inventory = inventory;
    }
    /**
     * Creates an exporter and presenter object to export the inventory
     * */
    public void InitiateExport() throws IOException {
        Exporter exporter = new Exporter(inventory);
        exporter.export();
        ExportPresenter presenter = new ExportPresenter();
        presenter.present();
    }

}
