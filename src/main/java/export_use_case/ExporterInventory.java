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

    public ExporterInventory(Inventory inventory, ExportPresenter presenter, HashMap controllers)  {
        this.inventory = inventory;
        this.presenter = presenter;
        this.controllers = controllers;
    }

    @Override
    public ExportViewModel create(ExportRequestModel exportRequestModel) throws IOException {
        ArrayList<Object> orders = new ArrayList<Object>(inventory.getOrders());
        ArrayList<Object> items = new ArrayList<Object>(inventory.getItems());
        ExportDataWrapper dataWrapper = new ExportDataWrapper(exportRequestModel.getInventorytable(),items, orders);
        Exporter exporter = new Exporter(exportRequestModel.getInventoryName(), dataWrapper);
        exporter.export();
        return null;
    }

}
