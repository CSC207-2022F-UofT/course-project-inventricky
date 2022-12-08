package entities;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Objects;

public class InventoryTest {

    @Test
    public void InventoryFromScratchTest() {
        Inventory inv = new Inventory("Test");
        assert (Objects.equals(inv.getHistory().get(0), "Created from scratch on " + LocalDate.now() + "."));
        assert (Objects.equals(inv.getName(), "Test"));
        assert (inv.getItems().isEmpty());
        assert (inv.getOrders().isEmpty());
    }

}