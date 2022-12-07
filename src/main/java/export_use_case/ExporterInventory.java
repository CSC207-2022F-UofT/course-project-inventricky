package export_use_case;

import Screens.ExportViewModel;
import entities.Inventory;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class ExporterInventory implements ExportInputBoundary{
    private final Inventory inventory;
    final ExportPresenter presenter;
    HashMap controllers;

    /**
     * Contructor for the Exporter Inventory class
     * @param inventory the entire inventory object that needs to be exported
     * @param presenter the presenter (confirmation button) class for the exporting screen
     * @param controllers the controllers to activate the required classes to export
     */

    public ExporterInventory(Inventory inventory, ExportPresenter presenter, HashMap controllers)  {
        this.inventory = inventory;
        this.presenter = presenter;
        this.controllers = controllers;
    }

    /**
     * Overrides abstract method inside the ExportViewModel. Calls the export class and then the presenter
     * for the "export successful" screen
     * @param exportRequestModel Export Request Model; a class that connects this layer to the entities
     * @return the "export successful" screen
     * @throws IOException as required by the Exporter class
     */
    @Override
    public ExportViewModel create(ExportRequestModel exportRequestModel) throws IOException {
        ArrayList<Object> items = new ArrayList<>(inventory.getItems());
        ExportDataWrapper dataWrapper = new ExportDataWrapper(exportRequestModel.getInventorytable(),items);
        Exporter exporter = new Exporter(exportRequestModel.getInventoryName(), dataWrapper);
        exporter.export();
        return presenter.PrepareSuccessView();
    }

}
