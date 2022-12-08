package remove_item_use_case;

import Screens.InventoryViewModel;

import entities.Inventory;
import entities.InventoryItem;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class RemoveItemInteractorTest {

    private static Inventory inv;

    /** Create inventory with single item for testing.
     *
     */
    @BeforeAll
    static void createTestData() {
        inv = new Inventory("test");
        inv.addItem(new InventoryItem("bananas", "12345", true, 10, 2,
                3, 5, "12", 0, 0));
    }

    /** Test if remove item use case correctly removes given item from inventory.
     *
     */
    @Test
    void removeItem() {

        RemoveItemPresenter presenter = new RemoveItemPresenter() {
            @Override
            public InventoryViewModel prepareSuccessView(RemoveItemResponseModel oldItem, String[][] inventoryTable, String[] inventoryHistory) {
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

        RemoveItemInputBoundary interactor = new RemoveItemInteractor(presenter, inv);
        RemoveItemRequestModel inputData = new RemoveItemRequestModel("12345");
        interactor.removeItem(inputData, true);

    }
}

