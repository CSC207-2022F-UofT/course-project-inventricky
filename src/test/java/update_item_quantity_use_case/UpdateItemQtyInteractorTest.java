package update_item_quantity_use_case;

import Screens.InventoryViewModel;
import Screens.ItemHistoryViewModel;
import entities.Inventory;
import entities.InventoryItem;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UpdateItemQtyInteractorTest {

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

    /** Test if update item use case correctly updates item when quantity is bought.
     *
     */
    @Test
    @Order(1)
    void UpdateQtyBought() {


        UpdateItemQtyPresenter presenter = new UpdateItemQtyPresenter() {
            @Override
            public InventoryViewModel prepareQtySuccessView(UpdateItemQtyResponseModel item, String[][] inventoryTable, String[] inventoryHistory) {
                assertEquals("bananas", item.getName());
                assertEquals("12345", item.getBarcode());
                assertEquals(" Bought 13.0", item.getItemHistory().get(1).substring(16));
                assertEquals(13.0, inv.getItems().get(0).getQuantityBought());
                assertEquals(23.0, inv.getItems().get(0).getQuantity());

                return null;
            }

            @Override
            public InventoryViewModel prepareQtyFailView(String error) {
                fail("Use case failure is unexpected.");
                return null;
            }

            @Override
            public ItemHistoryViewModel prepareHistorySuccessView(UpdateItemQtyResponseModel item) {
                return null;
            }

            @Override
            public ItemHistoryViewModel prepareHistoryFailView(String error) {
                return null;
            }
        };

        UpdateItemQtyInputBoundary interactor = new UpdateItemQtyInteractor(presenter, inv);
        UpdateItemQtyRequestModel inputData = new UpdateItemQtyRequestModel("12345", "Bought", 13);
        interactor.updateQty(inputData);


    }

    /** Test if update item use case correctly updates item when quantity is bought.
     *
     */
    @Test
    @Order(2)
    void UpdateQtySold() {


        UpdateItemQtyPresenter presenter = new UpdateItemQtyPresenter() {
            @Override
            public InventoryViewModel prepareQtySuccessView(UpdateItemQtyResponseModel item, String[][] inventoryTable, String[] inventoryHistory) {
                assertEquals("bananas", item.getName());
                assertEquals("12345", item.getBarcode());
                assertEquals(" Sold 14.0", item.getItemHistory().get(2).substring(16));
                assertEquals(14.0, inv.getItems().get(0).getQuantitySold());
                assertEquals(9.0, inv.getItems().get(0).getQuantity());

                return null;
            }

            @Override
            public InventoryViewModel prepareQtyFailView(String error) {
                fail("Use case failure is unexpected.");
                return null;
            }

            @Override
            public ItemHistoryViewModel prepareHistorySuccessView(UpdateItemQtyResponseModel item) {
                return null;
            }

            @Override
            public ItemHistoryViewModel prepareHistoryFailView(String error) {
                return null;
            }
        };

        UpdateItemQtyInputBoundary interactor = new UpdateItemQtyInteractor(presenter, inv);
        UpdateItemQtyRequestModel soldData = new UpdateItemQtyRequestModel("12345", "Sold", 14);
        interactor.updateQty(soldData);
    }

    /** Test if update item use case correctly updates item when quantity is bought.
     *
     */
    @Test
    @Order(3)
    void UpdateQtyError() {


        UpdateItemQtyPresenter presenter = new UpdateItemQtyPresenter() {
            @Override
            public InventoryViewModel prepareQtySuccessView(UpdateItemQtyResponseModel item, String[][] inventoryTable, String[] inventoryHistory) {
                assertEquals("bananas", item.getName());
                assertEquals("12345", item.getBarcode());
                assertEquals(" Error: Adjusted quantity to 11.0", item.getItemHistory().get(3).substring(16));
                assertEquals(11.0, inv.getItems().get(0).getQuantity());

                return null;
            }

            @Override
            public InventoryViewModel prepareQtyFailView(String error) {
                fail("Use case failure is unexpected.");
                return null;
            }

            @Override
            public ItemHistoryViewModel prepareHistorySuccessView(UpdateItemQtyResponseModel item) {
                return null;
            }

            @Override
            public ItemHistoryViewModel prepareHistoryFailView(String error) {
                return null;
            }
        };

        UpdateItemQtyInputBoundary interactor = new UpdateItemQtyInteractor(presenter, inv);
        UpdateItemQtyRequestModel errorData = new UpdateItemQtyRequestModel("12345", "Error", 11);
        interactor.updateQty(errorData);
    }

    /** Test if update item use case correctly gets item history.
     *
     */
    @Test
    @Order(4)
    void GetItemHistory() {


        UpdateItemQtyPresenter presenter = new UpdateItemQtyPresenter() {
            @Override
            public InventoryViewModel prepareQtySuccessView(UpdateItemQtyResponseModel item, String[][] inventoryTable, String[] inventoryHistory) {
                return null;
            }

            @Override
            public InventoryViewModel prepareQtyFailView(String error) {
                return null;
            }

            @Override
            public ItemHistoryViewModel prepareHistorySuccessView(UpdateItemQtyResponseModel item) {
                assertEquals("bananas", item.getName());
                assertEquals("12345", item.getBarcode());
                assertEquals(" Bought 11.0", item.getItemHistory().get(3).substring(16));
                return null;
            }

            @Override
            public ItemHistoryViewModel prepareHistoryFailView(String error) {
                fail("Use case failure is unexpected.");
                return null;
            }
        };

        UpdateItemQtyInputBoundary interactor = new UpdateItemQtyInteractor(presenter, inv);
        UpdateItemQtyRequestModel historyData = new UpdateItemQtyRequestModel("12345", "Bought", 11);
        interactor.updateQty(historyData);
    }
}

