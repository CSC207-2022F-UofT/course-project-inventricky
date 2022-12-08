import display_use_case.DisplayInputBoundary;
import display_use_case.DisplayInteractor;
import display_use_case.DisplayPresenter;
import Screens.*;
import analysis_use_case.Analysis;
import delete_inventory_use_case.DeleteInventoryInputBoundary;
import delete_inventory_use_case.DeleteInventoryInteractor;
import delete_inventory_use_case.DeleteInventoryPresenter;
import entities.Inventory;
import export_use_case.ExportInputBoundary;
import export_use_case.ExportPresenter;
import export_use_case.ExporterInventory;
import generate_order_use_case.OrderingInteractor;
import generate_order_use_case.OrderingPresenter;
import import_use_case.ImportInventory;
import import_use_case.ImportPresenter;
import new_item_use_case.NewItemInputBoundary;
import new_item_use_case.NewItemInteractor;
import new_item_use_case.NewItemPresenter;
import receive_order_use_case.ReceivingInteractor;
import receive_order_use_case.ReceivingPresenter;
import remove_item_use_case.RemoveItemInputBoundary;
import remove_item_use_case.RemoveItemInteractor;
import remove_item_use_case.RemoveItemPresenter;
import update_item_quantity_use_case.UpdateItemQtyInputBoundary;
import update_item_quantity_use_case.UpdateItemQtyInteractor;
import update_item_quantity_use_case.UpdateItemQtyPresenter;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {

        //create a new blank inventory
        Inventory inv = new Inventory("New Inventory");

        //map of controllers
        //ex. controllers.get("newItemController") = newItemController
        HashMap<String, Object> controllers = new HashMap<>();

        DisplayPresenter displayPresenter = new DisplayInventoryUpdater();
        DisplayInputBoundary displayInteractor = new DisplayInteractor(displayPresenter); //create new use case interactor
        DisplayController displayController = new DisplayController(displayInteractor); //create new controller with interactor as param
        controllers.put("displayController", displayController);

        //setup for New Item use case
        NewItemPresenter newItemPresenter = new NewItemInventoryUpdater();
        NewItemInputBoundary newItemInteractor = new NewItemInteractor(newItemPresenter, inv); //create new use case interactor
        NewItemController newItemController = new NewItemController(newItemInteractor); //create new controller with interactor as param
        controllers.put("newItemController", newItemController);

        //setup for Remove Item use case
        RemoveItemPresenter removeItemPresenter = new RemoveItemInventoryUpdater();
        RemoveItemInputBoundary removeItemInteractor = new RemoveItemInteractor(removeItemPresenter, inv);
        RemoveItemController removeItemController = new RemoveItemController(removeItemInteractor);
        controllers.put("removeItemController", removeItemController);

        //setup for Update Item Qty use case
        UpdateItemQtyPresenter updateItemQtyPresenter = new UpdateItemQtyInventoryUpdater();
        UpdateItemQtyInputBoundary updateItemQtyInteractor = new UpdateItemQtyInteractor(updateItemQtyPresenter, inv);
        UpdateItemQtyController updateItemQtyController = new UpdateItemQtyController(updateItemQtyInteractor);
        controllers.put("updateItemQtyController", updateItemQtyController);

        //Setup for ImportInventory use case
        ImportPresenter importPresenter = new ImportInventoryUpdater();
        ImportInventory importInventory = new ImportInventory(inv, importPresenter, controllers);
        ImportController importController = new ImportController(importInventory);
        controllers.put("importController", importController);

        //setup for Analysis
        Analysis analysis = new Analysis(inv);
        AnalysisController analysisController = new AnalysisController(analysis);
        controllers.put("analysisController", analysisController);

        // setup for Ordering use case
        OrderingPresenter orderingPresenter = new OrderingScreenUpdater();
        OrderingInteractor orderingInteractor = new OrderingInteractor(orderingPresenter, inv,
                controllers, newItemPresenter); //create new use case interactor
        OrderingController orderingController = new OrderingController(orderingInteractor); //create new controller with interactor as param
        controllers.put("orderingController", orderingController);

        //setup for Receiving use case
        ReceivingPresenter receivingPresenter = new ReceivingScreenUpdater();
        ReceivingInteractor receivingInteractor = new ReceivingInteractor(receivingPresenter, inv,
                controllers, updateItemQtyPresenter); //create new use case interactor
        ReceivingController receivingController = new ReceivingController(receivingInteractor); //create new controller with interactor as param
        controllers.put("receivingController", receivingController);

        //Setup for ExportInventory use case
        ExportPresenter exporterPresenter = new ExportInventoryUpdater();
        ExportInputBoundary exportInventory = new ExporterInventory(inv, exporterPresenter, controllers);
        ExportController exportController = new ExportController(exportInventory);
        controllers.put("exportController", exportController);

        //Setup for DeleteInventory use case
        DeleteInventoryPresenter deleteInventoryUpdater = new DeleteInventoryUpdater();
        DeleteInventoryInputBoundary deleteInventoryInteractor = new DeleteInventoryInteractor(deleteInventoryUpdater, controllers);
        DeletionController deleteController = new DeletionController(deleteInventoryInteractor);
        controllers.put("deletionController", deleteController);


        new MainCreationUI(controllers);

    }

}