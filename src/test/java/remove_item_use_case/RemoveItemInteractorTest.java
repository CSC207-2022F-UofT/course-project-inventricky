package remove_item_use_case;

import Screens.InventoryDatabase;
import Screens.InventoryViewModel;

import entities.Inventory;
import entities.InventoryItem;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class RemoveItemInteractorTest {

    private static Inventory inv;

    @BeforeAll
    static void createTestData() {
        inv = new Inventory("test");
        inv.addItem(new InventoryItem("bananas", "12345", true, 10, 2,
                3, 5, "12", 0, 0));
    }

    @Test
    void removeItem() {

        RemoveItemPresenter presenter = new RemoveItemPresenter() {
            @Override
            public InventoryViewModel prepareSuccessView(RemoveItemResponseModel oldItem, String[][] inventoryTable) {
                assertEquals("bananas", oldItem.getName());
                assertEquals("12345", oldItem.getBarcode());
                assert (inv.getItems().isEmpty());

                return null;
            }

            @Override
            public RemoveItemResponseModel prepareFailView(String error) {
                fail("Use case failure is unexpected.");
                return null;
            }
        };

        RemoveItemDsGateway riDatabase = new InventoryDatabase();

        RemoveItemInputBoundary interactor = new RemoveItemInteractor(riDatabase, presenter, inv);
        RemoveItemRequestModel inputData = new RemoveItemRequestModel("12345");
        interactor.removeItem(inputData, true);

    }
}
