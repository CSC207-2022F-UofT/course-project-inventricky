package entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import generate_order_use_case.OrderGenerator;
import receive_order_use_case.OrderReceiver;

import java.time.LocalDate;

class OrderingReceivingTests {
LocalDate dateToday = LocalDate.now();
    Order order = new Order("Pizza", "12345", true,
            5, 40, 60, 2, "69",
            dateToday.toString(), dateToday.plusDays(5).toString(), "moxies", 5);

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
        // test if the order's item was added to inventory

        OrderGenerator newOrder = new OrderGenerator();
        Inventory inventory = new Inventory("Sample");
        Order created = newOrder.registerOrderManual("Pizza", "moxies", 5,
                inventory, true, 40, 60, 2,
                "69");
        Assertions.assertTrue(inventory.getOrders().contains(created));
        Assertions.assertSame("Pizza", inventory.getItems().get(0).getName());
    }

    @Test
    public void OrderingReceivingGenerating2() {
        // test if only one item was added to inventory
        // test that both orders were added to inventory

        Inventory inventory = new Inventory("Sample");
        OrderGenerator newOrder = new OrderGenerator();
        newOrder.registerOrderManual("Pizza", "moxies", 5,
                inventory, true, 40, 60, 2,
                "69");
        newOrder.registerOrderManual("Pizza", "moxies", 20, inventory, true,
                40, 60, 2, "69");
        Assertions.assertEquals(1, inventory.getItems().size());
        Assertions.assertEquals(2, inventory.getOrders().size());

    }
    @Test
    public void OrderingReceivingGenerating3() {
        // test that order objects are distinguishable from each other

        Inventory inventory = new Inventory("Sample");
        OrderGenerator newOrder = new OrderGenerator();
        newOrder.registerOrderManual("Pizza", "moxies", 5,
                inventory, true, 40, 60, 2,
                "69");
        Assertions.assertFalse(inventory.getOrders().contains(order));

    }

    @Test
    public void OrderingReceivingReceived() {
        // test that the order's shipping status changed to Received
        // test that the received date was updated

        Inventory inventory = new Inventory("Sample");
        OrderGenerator newOrder = new OrderGenerator();
        Order created = newOrder.registerOrderManual("Pizza", "moxies", 5,
                inventory, true, 40, 60, 2,
                "69");
        Assertions.assertSame("Inbound Order", created.checkShipmentStatus());
        Assertions.assertEquals("", created.getDateReceived());
        OrderReceiver receivedOrder = new OrderReceiver();
        receivedOrder.receiveOrder(created, inventory, "2022-12-07");
        Assertions.assertSame("Received", created.checkShipmentStatus());
        Assertions.assertSame("2022-12-07", created.getDateReceived());
        Assertions.assertEquals(dateToday.plusDays(5).toString(), created.getEstimatedDate());

    }

    @Test
    public void OrderingReceivingReceived2() {
        // test that the quantity of a newly added item from a new order is 0.0
        // test that the quantity of an existing item was updated after receiving an order of the item

        Inventory inventory = new Inventory("Sample");
        OrderGenerator newOrder = new OrderGenerator();
        Order firstOrder = newOrder.registerOrderManual("Pizza", "moxies", 5,
                inventory, true, 40, 60, 2,
                "69");
        Order secondOrder = newOrder.registerOrderManual("Pizza", "moxies", 20, inventory, true,
                40, 60, 2, "69");
        Assertions.assertEquals(0.0, inventory.getItems().get(0).getQuantity());
        OrderReceiver receivedOrder = new OrderReceiver();
        receivedOrder.receiveOrder(firstOrder, inventory, "2022-12-07");
        double firstQty = inventory.getItems().get(0).getQuantity();
        Assertions.assertEquals(firstOrder.getOrderCases() * firstOrder.getCaseQuantity(), firstQty);
        Assertions.assertEquals(10, firstQty);
        receivedOrder.receiveOrder(secondOrder, inventory, "2022-12-07");
        double expectedQty = inventory.getItems().get(0).getQuantity();
        Assertions.assertEquals(expectedQty, firstQty + secondOrder.getOrderCases() * secondOrder.getCaseQuantity());
        Assertions.assertEquals(50, firstQty + secondOrder.getOrderCases() * secondOrder.getCaseQuantity());
    }

    @Test
    public void OrderingReceivingReceived3() {
        // test that the quantity of an existing item was updated while a different item is in the inventory

        Inventory inventory = new Inventory("Sample");
        OrderGenerator newOrder = new OrderGenerator();
        Order firstOrder = newOrder.registerOrderManual("Pizza", "moxies", 5,
                inventory, true, 40, 60, 2,
                "69");
        Order secondOrder = newOrder.registerOrderManual("Pineapple", "moxies", 20, inventory, true,
                40, 60, 2, "69");
        Order thirdOrder = newOrder.registerOrderManual("Pineapple", "moxies", 5, inventory, true,
                40, 60, 2, "69");
        OrderReceiver receivedOrder = new OrderReceiver();
        receivedOrder.receiveOrder(firstOrder, inventory, "2022-12-07");
        receivedOrder.receiveOrder(secondOrder, inventory, "2022-12-07");
        receivedOrder.receiveOrder(thirdOrder, inventory, "2022-12-07");
        double expectedQty = (secondOrder.getOrderCases() * secondOrder.getCaseQuantity()) +
                (thirdOrder.getOrderCases() * thirdOrder.getCaseQuantity());
        Assertions.assertEquals(expectedQty, inventory.getItems().get(1).getQuantity());
        Assertions.assertEquals(50, inventory.getItems().get(1).getQuantity());

    }
}


