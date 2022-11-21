package entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import useCases.InventoryScratchBuilder;

import java.util.Objects;

public class InventoryTest {

    @Test
    public void InventoryFromScratchTest() {
        Inventory inv = new InventoryScratchBuilder("test").create();
        assert (Objects.equals(inv.getHistory().get(0), "New inventory created from scratch"));
        assert (Objects.equals(inv.getName(), "test"));
        assert (inv.getItems().isEmpty());
        assert (inv.getOrders().isEmpty());
    }

    @Test
    public void InventoryFromImportTest() {
        //TODO: Wait for Dario
    }

    @Test
    public void addItemTest() {
        InventoryItem item = new InventoryItem("banana", true, 12, 2, 5, 2, "47", 50, 0);
        Inventory inv = new InventoryScratchBuilder("test").create();
        inv.addItem(item);
    }
}
