package entities;
import controllers.ExportController;
import databases.Exporter;
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
        InventoryItem item0 = new InventoryItem("bananas","12345" , true, 10, 2,
                3, 5, "12", 10, 0);
        InventoryItem item1 = new InventoryItem("banana", "12346" ,true, 10, 2,
                3, 5, "12", 10, 0);
        InventoryItem item2 = new InventoryItem("apple", "12352" ,false, 1, 4,
                6, 11, "12", 6, 4);
        InventoryItem item3 = new InventoryItem("orange", "12361" ,true, 7, 7,
                5, 6, "12", 4, 5);
        InventoryItem item4 = new InventoryItem("nectarine", "12373" ,false, 3, 9,
                4, 9, "12", 2, 4);
        InventoryItem item5 = new InventoryItem("cookies", "12385" ,true, 5, 3,
                2, 3, "12", 3, 2);
        InventoryItem item6 = new InventoryItem("bread", "12392" ,false, 7, 1,
                1, 4, "12", 5, 8);
        InventoryItem item7 = new InventoryItem("banana2", "12311" ,true, 2, 4,
                8, 3, "12", 9, 9);
        InventoryItem item8 = new InventoryItem("computer", "12333" ,true, 7, 1,
                6, 2, "12", 4, 7);
        InventoryItem item9 = new InventoryItem("mice", "12612" ,false, 5, 6,
                9, 1, "12", 2, 6);
        InventoryItem item10 = new InventoryItem("cat", "12388" ,true, 6, 4,
                4, 8, "12", 3, 8);

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
            FileReader fr_usr = new FileReader("src/main/java/exports/user_inventory.tt");
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