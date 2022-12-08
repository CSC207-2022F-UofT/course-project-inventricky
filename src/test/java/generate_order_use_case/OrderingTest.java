package generate_order_use_case;
import entities.Inventory;
import entities.InventoryItem;
import entities.Order;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class OrderingTest {
        InventoryItem item = new InventoryItem("Pizza", true, 5, 40, 60,
                2, "69", 0, 0);

    /**
     * Test if order was added to the inventory.
     */
    @Test
        public void OrderingReceivingGenerating() {

            OrderGenerator newOrder = new OrderGenerator();
            Inventory inventory = new Inventory("Sample");
            inventory.addItem(item);
            Order created = newOrder.registerOrderManual("Pizza", "moxies", 5,
                    inventory);
            Assertions.assertTrue(inventory.getOrders().contains(created));
            Assertions.assertSame("Pizza", inventory.getItems().get(0).getName());
        }

    }
