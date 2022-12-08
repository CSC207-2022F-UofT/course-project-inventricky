package generate_order_use_case;
import entities.Inventory;
import entities.InventoryItem;
import entities.Order;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;

public class OrderingTest {
        LocalDate dateToday = LocalDate.now();
        Order order = new Order("Pizza", "12345", true,
                5, 40, 60, 2, "69",
                dateToday.toString(), dateToday.plusDays(5).toString(), "moxies", 5);
        InventoryItem item = new InventoryItem("Pizza", true, 5, 40, 60,
                2, "69", 0, 0);

        @Test
        public void OrderingReceivingGetters() {
            Assertions.assertEquals(dateToday.toString(), order.getDateBought());
            Assertions.assertEquals(dateToday.plusDays(5).toString(), order.getEstimatedDate());
            Assertions.assertEquals("moxies", order.getSupplier());
            Assertions.assertEquals(5, order.getOrderCases());
        }

        @Test
        public void OrderingReceivingGenerating() {
            // test if order was added to the inventory

            OrderGenerator newOrder = new OrderGenerator();
            Inventory inventory = new Inventory("Sample");
            inventory.addItem(item);
            Order created = newOrder.registerOrderManual("Pizza", "moxies", 5,
                    inventory);
            Assertions.assertTrue(inventory.getOrders().contains(created));
            Assertions.assertSame("Pizza", inventory.getItems().get(0).getName());
        }
        @Test
        public void OrderingReceivingGenerating3() {
            // test that order objects are distinguishable from each other

            Inventory inventory = new Inventory("Sample");
            OrderGenerator newOrder = new OrderGenerator();
            inventory.addItem(item);
            newOrder.registerOrderManual("Pizza", "moxies", 5,
                    inventory);
            Assertions.assertFalse(inventory.getOrders().contains(order));

        }
    }
