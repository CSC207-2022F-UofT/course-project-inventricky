
import Screens.*;
import entities.Inventory;
import new_item_use_case.NewItemDsGateway;
import new_item_use_case.NewItemInputBoundary;
import new_item_use_case.NewItemInteractor;
import new_item_use_case.NewItemPresenter;
import remove_item_use_case.RemoveItemDsGateway;
import remove_item_use_case.RemoveItemInputBoundary;
import remove_item_use_case.RemoveItemInteractor;
import remove_item_use_case.RemoveItemPresenter;

import java.lang.reflect.Array;
import java.util.ArrayList;
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


        //TODO select whether you want to import or start from scratch

        //scratch
        inv.updateHistory("New inventory created from scratch");
        new InventoryMenuUI(controllers);


        //new MainCreationUI();




        //AddNewItemUI addNewItemUI = new AddNewItemUI(newItemController);
        //screens.add(addNewItemUI, "New Item");
//        cardLayout.show(screens, "Inventory");
//        application.pack();
//        application.setVisible(true);

    }

    //AddNewItemUI
}
