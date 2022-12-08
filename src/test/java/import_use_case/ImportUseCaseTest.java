package import_use_case;

import Screens.ImportController;
import Screens.ImportInventoryUpdater;
import entities.Inventory;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

public class ImportUseCaseTest {
    /**
     * Tests importUseCase by simulating user input and checking that the imported inventory matches the inventoryTable
     */
    @Test
    public void TestImportUseCase() {
        // Set up for use case similar to what is in main.java
        HashMap<String, Object> controllers = new HashMap<>();
        Inventory inv = new Inventory("test");
        ImportPresenter importPresenter = new ImportInventoryUpdater();
        ImportInventory importInventory = new ImportInventory(inv, importPresenter, controllers);
        ImportController importController = new ImportController(importInventory);
        controllers.put("importController", importController);
        ImportRequestModel importRequestModel = new ImportRequestModel(inv.getName(), "src/test/java/test_files/serializable_inventory.txt");

        // Call to import through use case
        InventoryViewModel inventoryViewModel = importInventory.create(importRequestModel);

        // Checking equality
        for (int i = 0; i < inventoryViewModel.getItemList().length; i++) {
            assert inventoryViewModel.getItemList()[i][0].equals(inv.getItems().get(i).getName());
            assert inventoryViewModel.getItemList()[i][1].equals(String.valueOf(inv.getItems().get(i).getQuantity()));
            assert inventoryViewModel.getItemList()[i][2].equals(String.valueOf(inv.getItems().get(i).getBarcode()));
            assert inventoryViewModel.getItemList()[i][3].equals(String.valueOf(inv.getItems().get(i).getBuyPrice()));
            assert inventoryViewModel.getItemList()[i][4].equals(String.valueOf(inv.getItems().get(i).getSellPrice()));
            assert inventoryViewModel.getItemList()[i][5].equals(String.valueOf(inv.getItems().get(i).getCaseQuantity()));
            assert inventoryViewModel.getItemList()[i][6].equals(String.valueOf(inv.getItems().get(i).getDepartment()));
        }
    }
}
