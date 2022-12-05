
import Screens.*;
import entities.Analysis;
import entities.AnalysisController;
import entities.Inventory;
import generate_order_use_case.OrderingDsGateway;
import generate_order_use_case.OrderingInputBoundary;
import generate_order_use_case.OrderingInteractor;
import generate_order_use_case.OrderingPresenter;
import import_use_case.ImportInventory;
import import_use_case.ImportPresenter;
import entities.comparator.AnalysisScreenUpdater;
import new_item_use_case.NewItemDsGateway;
import new_item_use_case.NewItemInputBoundary;
import new_item_use_case.NewItemInteractor;
import new_item_use_case.NewItemPresenter;
import receive_order_use_case.ReceivingDsGateway;
import receive_order_use_case.ReceivingInputBoundary;
import receive_order_use_case.ReceivingInteractor;
import receive_order_use_case.ReceivingPresenter;
import remove_item_use_case.RemoveItemDsGateway;
import remove_item_use_case.RemoveItemInputBoundary;
import remove_item_use_case.RemoveItemInteractor;
import remove_item_use_case.RemoveItemPresenter;
import update_item_quantity_use_case.UpdateItemQtyDsGateway;
import update_item_quantity_use_case.UpdateItemQtyInputBoundary;
import update_item_quantity_use_case.UpdateItemQtyInteractor;
import update_item_quantity_use_case.UpdateItemQtyPresenter;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {

        // Build the main program window
//        JFrame application = new JFrame("App");
//        CardLayout cardLayout = new CardLayout();
//        JPanel screens = new JPanel(cardLayout);
//        application.add(screens);

        //create a new blank inventory
        Inventory inv = new Inventory("New Inventory");

        //map of controllers
        //ex. controllers.get("newItemController") = newItemController
        HashMap controllers = new HashMap();





        //setup for New Item use case
        NewItemDsGateway niDatabase = new InventoryDatabase(); //TODO implement this class
        NewItemPresenter newItemPresenter = new NewItemInventoryUpdater();
        NewItemInputBoundary newItemInteractor = new NewItemInteractor(niDatabase, newItemPresenter, inv); //create new use case interactor
        NewItemController newItemController = new NewItemController(newItemInteractor); //create new controller with interactor as param
        controllers.put("newItemController", newItemController);

        //setup for Remove Item use case
        RemoveItemDsGateway riDatabase = new InventoryDatabase(); //TODO implement this class
        RemoveItemPresenter removeItemPresenter= new RemoveItemInventoryUpdater();
        RemoveItemInputBoundary removeItemInteractor = new RemoveItemInteractor(riDatabase, removeItemPresenter, inv);
        RemoveItemController removeItemController = new RemoveItemController(removeItemInteractor);
        controllers.put("removeItemController", removeItemController);

        //setup for Update Item Qty use case
        UpdateItemQtyDsGateway uiDatabase = new InventoryDatabase(); //TODO implement this class
        UpdateItemQtyPresenter updateItemQtyPresenter= new UpdateItemQtyInventoryUpdater();
        UpdateItemQtyInputBoundary updateItemQtyInteractor = new UpdateItemQtyInteractor(uiDatabase, updateItemQtyPresenter, inv);
        UpdateItemQtyController updateItemQtyController = new UpdateItemQtyController(updateItemQtyInteractor);
        controllers.put("updateItemQtyController", updateItemQtyController);

        //Setup for ImportInventory use case
        ImportPresenter importPresenter = new ImportInventoryUpdater();
        ImportInventory importInventory = new ImportInventory(inv, importPresenter, controllers);
        ImportController importController = new ImportController(importInventory);
        controllers.put("importController", importController);

        //setup for Analysis
        AnalysisScreenUpdater analysisScreenPresenter = new AnalysisScreenUpdater();
        Analysis analysis = new Analysis(inv);
        AnalysisController analysisController = new AnalysisController(analysis);
        controllers.put("analysisController", analysisController);

        // setup for Ordering use case
        OrderingDsGateway orderingDsGateway = new InventoryDatabase(); //TODO implement this class
        OrderingPresenter orderingPresenter = new OrderingScreenUpdater();
        OrderingInteractor orderingInteractor = new OrderingInteractor(orderingDsGateway, orderingPresenter, inv,
                controllers, newItemPresenter); //create new use case interactor
        OrderingController orderingController = new OrderingController(orderingInteractor); //create new controller with interactor as param
        controllers.put("orderingController", orderingController);

//       //  setup for Receiving use case
        ReceivingDsGateway receivingDsGateway = new InventoryDatabase(); //TODO implement this class
        ReceivingPresenter receivingPresenter = new ReceivingScreenUpdater();
        ReceivingInteractor receivingInteractor = new ReceivingInteractor(receivingDsGateway, receivingPresenter, inv,
                controllers, updateItemQtyPresenter); //create new use case interactor
        ReceivingController receivingController = new ReceivingController(receivingInteractor); //create new controller with interactor as param
        controllers.put("receivingController", receivingController);

        //scratch
        InventoryViewModel blankViewModel = new InventoryViewModel(new String[][] {});
        inv.updateHistory("New inventory created from scratch");
        //InventoryUI newInventory = new InventoryUI(blankViewModel);
        //newInventory.setControllers(controllers);




        new MainCreationUI(controllers);




        //AddNewItemUI addNewItemUI = new AddNewItemUI(newItemController);
        //screens.add(addNewItemUI, "New Item");
//        cardLayout.show(screens, "Inventory");
//        application.pack();
//        application.setVisible(true);

    }

    //AddNewItemUI
}
