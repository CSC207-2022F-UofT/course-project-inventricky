package new_item_use_case;

import Screens.InventoryViewModel;

import entities.Inventory;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class NewItemInteractorTest {

    private static Inventory inv;

    /** Create empty inventory for testing.
     *
     */
    @BeforeAll
    static void createTestData() {
        inv = new Inventory("test");
    }

    /** Test if new item use case correctly adds a new item to inventory.
     *
     */
    @Test
    void newItem() {

        NewItemPresenter presenter = new NewItemPresenter() {
            @Override
            public InventoryViewModel prepareSuccessView(NewItemResponseModel newItem, String[][] inventoryTable) {
                assertEquals("banana", newItem.getName());
                assertEquals("12345", newItem.getBarcode());
                assertEquals(inv.getItems().get(0).getBarcode(), "12345");

                return null;
            }

            @Override
            public NewItemResponseModel prepareFailView(String error) {
                fail("Use case failure is unexpected.");
                return null;
            }
        };

        NewItemInputBoundary interactor = new NewItemInteractor(presenter, inv);
        NewItemRequestModel inputData = new NewItemRequestModel("banana", false, 12, 13, 14, 15, "10");
        interactor.addItem(inputData, true);
    }
}
