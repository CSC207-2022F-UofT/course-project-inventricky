package Export;

import entities.Exporter;
import entities.Inventory;

import java.io.IOException;

public class ExportController {

    public ExportController(Inventory inventory) throws IOException {
        Exporter exporter = new Exporter(inventory);
        exporter.export();
        ExportPresenter presenter = new ExportPresenter();
        presenter.present();

    }



}
