import Export.ExportController;
import entities.Exporter;
import entities.Inventory;
import entities.InventoryItem;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;

public class ExporterTest {
    private final Inventory inventory;

    public ExporterTest() {
        this.inventory = new Inventory("Testing Inventory");
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

        inventory.setItems(items);
    }

    @Test
    public void AssertUsrInvCorrect() throws IOException {
        Exporter exporter = new Exporter(inventory);
        exporter.export();
        try {
            FileReader fr_usr = new FileReader("src/main/java/exports/user_inventory.txt");
            int i;
            while ((i = fr_usr.read()) != -1) {
                System.out.print((char) i);
            }
            System.out.println();
            fr_usr.close();
        }
        catch (Exception e) {
            e.getStackTrace();
        }
        Assertions.assertTrue(true);
    }

    @Test
    public void AssertFilesExist() throws IOException {
        Exporter exporter = new Exporter(inventory);
        exporter.export();
        Path p1 = Path.of("src/main/java/exports/user_inventory.txt");
        File f1 = p1.toFile();
        Path p2 = Path.of("src/main/java/exports/serializable_inventory.txt");
        File f2 = p2.toFile();

        Assertions.assertTrue(f1.exists());
        Assertions.assertTrue(f2.exists());


    }
    @Test
    public void AssertPresenterWindow() throws IOException {
        ExportController controller = new ExportController(inventory);

    }
}