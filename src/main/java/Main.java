
import Screens.AddNewItemUI;
import Screens.InventoryDatabase;
import Screens.NewItemAddedScreen;
import Screens.NewItemController;
import new_item_use_case.NewItemDsGateway;
import new_item_use_case.NewItemInputBoundary;
import new_item_use_case.NewItemInteractor;
import new_item_use_case.NewItemPresenter;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {

        // Build the main program window
        JFrame application = new JFrame("App");
        CardLayout cardLayout = new CardLayout();
        JPanel screens = new JPanel(cardLayout);
        application.add(screens);

        //new MainCreationUI();

        //inventory database
        NewItemDsGateway database = new InventoryDatabase(); //TODO implement this class

        NewItemPresenter presenter = new NewItemAddedScreen();
        NewItemInputBoundary interactor = new NewItemInteractor(database, presenter); //create new use case interactor
        NewItemController newItemController = new NewItemController(interactor); //create new controller with interactor as param

        AddNewItemUI addNewItemUI = new AddNewItemUI(newItemController);
        screens.add(addNewItemUI, "New Item");
        cardLayout.show(screens, "New Item");
        application.pack();
        application.setVisible(true);

    }

    //AddNewItemUI
}
