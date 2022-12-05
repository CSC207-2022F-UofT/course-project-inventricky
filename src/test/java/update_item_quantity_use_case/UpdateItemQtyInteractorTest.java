package update_item_quantity_use_case;

import Screens.InventoryDatabase;
import Screens.InventoryViewModel;
import Screens.ItemHistoryViewModel;
import entities.Inventory;
import entities.InventoryItem;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UpdateItemQtyInteractorTest {

    private static Inventory inv;

    @BeforeAll
    static void createTestData() {
        inv = new Inventory("test");
        inv.addItem(new InventoryItem("bananas", "12345", true, 10, 2,
                3, 5, "12", 0, 0));
    }

    @Test
    @Order(1)
    void UpdateQtyBought() {


        UpdateItemQtyPresenter presenter = new UpdateItemQtyPresenter() {
            @Override
            public InventoryViewModel prepareQtySuccessView(UpdateItemQtyResponseModel item, String[][] inventoryTable) {
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

        UpdateItemQtyDsGateway uiDatabase = new InventoryDatabase();

        UpdateItemQtyInputBoundary interactor = new UpdateItemQtyInteractor(uiDatabase, presenter, inv);
        UpdateItemQtyRequestModel inputData = new UpdateItemQtyRequestModel("12345", "bought", 13);
        interactor.UpdateQty(inputData);


    }

    @Test
    @Order(2)
    void UpdateQtySold() {


        UpdateItemQtyPresenter presenter = new UpdateItemQtyPresenter() {
            @Override
            public InventoryViewModel prepareQtySuccessView(UpdateItemQtyResponseModel item, String[][] inventoryTable) {
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

        UpdateItemQtyDsGateway uiDatabase = new InventoryDatabase();

        UpdateItemQtyInputBoundary interactor = new UpdateItemQtyInteractor(uiDatabase, presenter, inv);
        UpdateItemQtyRequestModel soldData = new UpdateItemQtyRequestModel("12345", "sold", 14);
        interactor.UpdateQty(soldData);
    }

    @Test
    @Order(3)
    void UpdateQtyError() {


        UpdateItemQtyPresenter presenter = new UpdateItemQtyPresenter() {
            @Override
            public InventoryViewModel prepareQtySuccessView(UpdateItemQtyResponseModel item, String[][] inventoryTable) {
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

        UpdateItemQtyDsGateway uiDatabase = new InventoryDatabase();

        UpdateItemQtyInputBoundary interactor = new UpdateItemQtyInteractor(uiDatabase, presenter, inv);
        UpdateItemQtyRequestModel errorData = new UpdateItemQtyRequestModel("12345", "error", 11);
        interactor.UpdateQty(errorData);
    }

    @Test
    @Order(4)
    void GetItemHistory() {


        UpdateItemQtyPresenter presenter = new UpdateItemQtyPresenter() {
            @Override
            public InventoryViewModel prepareQtySuccessView(UpdateItemQtyResponseModel item, String[][] inventoryTable) {
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

        UpdateItemQtyDsGateway uiDatabase = new InventoryDatabase();

        UpdateItemQtyInputBoundary interactor = new UpdateItemQtyInteractor(uiDatabase, presenter, inv);
        UpdateItemQtyRequestModel historyData = new UpdateItemQtyRequestModel("12345", "bought", 11);
        interactor.UpdateQty(historyData);
    }
}