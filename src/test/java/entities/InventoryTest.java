package entities;

import org.junit.jupiter.api.Test;

import java.util.Objects;

public class InventoryTest {

    @Test
    public void InventoryFromScratchTest() {
        //Create a Scratch Inventory
        Inventory inv = new Inventory("Test");
        assert (Objects.equals(inv.getName(), "Test"));
        assert (inv.getItems().isEmpty());
        assert (inv.getOrders().isEmpty());
    }

}