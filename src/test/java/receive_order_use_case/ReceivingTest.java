package receive_order_use_case;
import Screens.InventoryViewModel;
import Screens.ItemHistoryViewModel;
import entities.Inventory;
import entities.InventoryItem;
import entities.Order;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import update_item_quantity_use_case.UpdateItemQtyPresenter;
import update_item_quantity_use_case.UpdateItemQtyResponseModel;
import javax.swing.*;
import java.time.LocalDate;
import java.util.HashMap;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReceivingTest {
    LocalDate dateToday = LocalDate.now();
    Order order = new Order("Pizza", "12345", true,
            5, 40, 60, 2, "69",
            dateToday.toString(), dateToday.plusDays(5).toString(), "moxies", 5);
    InventoryItem item = new InventoryItem("Pizza", "12345", true, 5, 40, 60,
            2, "69", 0, 0);

    private static Inventory inv;
    static JFrame parent;
    private static final HashMap<String, Object> controllers = new HashMap<>();


    /** Create empty inventory for testing.
     *
     */
    @BeforeAll
    static void createTestData() {
        inv = new Inventory("test");
    }


    /**
     * Test that receiving an order updated item quantity.
     */
    @Test
    void receiveOrder() {
        controllers.put("orderingController", "test");
        ReceivingPresenter presenter = (order, orderHistoryTable, controllers) -> {
            for (InventoryItem item: inv.getItems()){
                if(item.getName().equals(order.getName())){
                    assertEquals(15, item.getQuantity());
                }
            }
            return null;
        };

        UpdateItemQtyPresenter qtyPresenter = new UpdateItemQtyPresenter() {
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
                return null;
            }

            @Override
            public ItemHistoryViewModel prepareHistoryFailView(String error) {
                return null;
            }
        };
        inv.addItem(item);
        inv.addOrder(order);
        ReceivingInputBoundary interactor = new ReceivingInteractor(presenter, inv, controllers, qtyPresenter);
        ReceivingRequestModel inputData = new ReceivingRequestModel("Pizza", dateToday.toString());
        interactor.receiveOrder(inputData, parent, true);
    }
}
