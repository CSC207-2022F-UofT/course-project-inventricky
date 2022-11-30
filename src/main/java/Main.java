
import Screens.*;
import entities.Inventory;
import new_item_use_case.NewItemDsGateway;
import new_item_use_case.NewItemInputBoundary;
import new_item_use_case.NewItemInteractor;
import new_item_use_case.NewItemPresenter;

public class Main {
    public static void main(String[] args) {

        // Build the main program window
//        JFrame application = new JFrame("App");
//        CardLayout cardLayout = new CardLayout();
//        JPanel screens = new JPanel(cardLayout);
//        application.add(screens);

        //create a new blank inventory
        Inventory inv = new Inventory("New Inventory");

        //inventory database
        NewItemDsGateway database = new InventoryDatabase(); //TODO implement this class

        //setup for New Item use case
        NewItemPresenter presenter = new NewItemInventoryUpdater();
        NewItemInputBoundary interactor = new NewItemInteractor(database, presenter, inv); //create new use case interactor
        NewItemController newItemController = new NewItemController(interactor); //create new controller with interactor as param



        //TODO select whether you want to import or start from scratch

        //scratch
        inv.updateHistory("New inventory created from scratch");
        new InventoryMenuUI(newItemController);


        //new MainCreationUI();




        //AddNewItemUI addNewItemUI = new AddNewItemUI(newItemController);
        //screens.add(addNewItemUI, "New Item");
//        cardLayout.show(screens, "Inventory");
//        application.pack();
//        application.setVisible(true);

    }

    //AddNewItemUI
}
