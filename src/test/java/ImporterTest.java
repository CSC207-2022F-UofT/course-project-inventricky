import entities.Importer;
import entities.Inventory;
import entities.InventoryItem;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class ImporterTest {

    @Test
    public void importToListSerializableTest() {
        // Initialize inventory that was exported to serializable_inventory.txt
        Inventory inv1 = new Inventory("Test 1");

        InventoryItem item0 = new InventoryItem("bananas","123" , true, 10, 2,
                3, 5, "1", 10, 0);
        InventoryItem item1 = new InventoryItem("banana", "1234" ,true, 10, 2,
                3, 5, "1", 10, 0);
        InventoryItem item2 = new InventoryItem("apple", "1235" ,false, 1, 4,
                6, 11, "2", 6, 4);
        InventoryItem item3 = new InventoryItem("orange", "1236" ,true, 7, 7,
                5, 6, "4", 4, 5);
        InventoryItem item4 = new InventoryItem("nectarine", "1237" ,false, 3, 9,
                4, 9, "3", 2, 4);
        InventoryItem item5 = new InventoryItem("cookies", "1238" ,true, 5, 3,
                2, 3, "1", 3, 2);
        InventoryItem item6 = new InventoryItem("bread", "1239" ,false, 7, 1,
                1, 4, "3", 5, 8);
        InventoryItem item7 = new InventoryItem("banana2", "1231" ,true, 2, 4,
                8, 3, "1", 9, 9);
        InventoryItem item8 = new InventoryItem("computer", "12333" ,true, 7, 1,
                6, 2, "1", 4, 7);
        InventoryItem item9 = new InventoryItem("mice", "12311" ,false, 5, 6,
                9, 1, "1", 2, 6);
        InventoryItem item10 = new InventoryItem("cat", "12388" ,true, 6, 4,
                4, 8, "1", 3, 8);

        ArrayList<InventoryItem> items = new ArrayList<>();
        items.add(item0);
        items.add(item1);
        items.add(item2);
        items.add(item3);
        items.add(item4);
        items.add(item5);
        items.add(item6);
        items.add(item7);
        items.add(item8);
        items.add(item9);
        items.add(item10);

        inv1.setItems(items);

        // Test for equality with import from file
        Inventory inv = new Inventory("Test");
        Importer importer = new Importer("src/main/java/exports/serializable_inventory.txt", inv);
        importer.importSerializable();

        for (int i = 0; i < inv.getItems().size(); i++) {
            Assertions.assertEquals(inv.getItems().get(i).getName(), inv1.getItems().get(i).getName());
            Assertions.assertEquals(inv.getItems().get(i).getBarcode(), inv1.getItems().get(i).getBarcode());
            Assertions.assertEquals(inv.getItems().get(i).getIsWeight(), inv1.getItems().get(i).getIsWeight());
            Assertions.assertEquals(inv.getItems().get(i).getQuantity(), inv1.getItems().get(i).getQuantity());
            Assertions.assertEquals(inv.getItems().get(i).getBuyPrice(), inv1.getItems().get(i).getBuyPrice());
            Assertions.assertEquals(inv.getItems().get(i).getSellPrice(), inv1.getItems().get(i).getSellPrice());
            Assertions.assertEquals(inv.getItems().get(i).getCaseQuantity(), inv1.getItems().get(i).getCaseQuantity());
            Assertions.assertEquals(inv.getItems().get(i).getDepartment(), inv1.getItems().get(i).getDepartment());
            Assertions.assertEquals(inv.getItems().get(i).getQuantityBought(), inv1.getItems().get(i).getQuantityBought());
            Assertions.assertEquals(inv.getItems().get(i).getQuantitySold(), inv1.getItems().get(i).getQuantitySold());
        }
    }
}
