package entities;

import Screens.ExportInventoryUpdater;
import Screens.InventoryViewModel;
import export_use_case.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;

public class ExporterTest {
    private InventoryViewModel inventoryViewModel;
    private ArrayList<Object> items;
    private String inventoryname;
    private Inventory inventory;
    private String[][] inventoryTable;

    public ExporterTest() {

        InventoryItem item0 = new InventoryItem("bananas", "12345", true, 10, 2,
                3, 5, "12", 10, 0);
        InventoryItem item1 = new InventoryItem("banana", "12346", true, 10, 2,
                3, 5, "12", 10, 0);
        InventoryItem item2 = new InventoryItem("apple", "12352", false, 1, 4,
                6, 11, "12", 6, 4);
        InventoryItem item3 = new InventoryItem("orange", "12361", true, 7, 7,
                5, 6, "12", 4, 5);
        InventoryItem item4 = new InventoryItem("nectarine", "12373", false, 3, 9,
                4, 9, "12", 2, 4);
        InventoryItem item5 = new InventoryItem("cookies", "12385", true, 5, 3,
                2, 3, "12", 3, 2);
        InventoryItem item6 = new InventoryItem("bread", "12392", false, 7, 1,
                1, 4, "12", 5, 8);
        InventoryItem item7 = new InventoryItem("banana2", "12311", true, 2, 4,
                8, 3, "12", 9, 9);
        InventoryItem item8 = new InventoryItem("computer", "12333", true, 7, 1,
                6, 2, "12", 4, 7);
        InventoryItem item9 = new InventoryItem("mice", "12612", false, 5, 6,
                9, 1, "12", 2, 6);
        InventoryItem item10 = new InventoryItem("cat", "12388", true, 6, 4,
                4, 8, "12", 3, 8);

        items = new ArrayList<>();


        inventoryname = "test1";
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


        inventoryTable = new String[items.size()][7];
        for (int i = 0; i < items.size(); i++) {
            InventoryItem item = (InventoryItem) items.get(i);
            inventoryTable[i] = new String[]{item.getName(), item.getQuantity() + "", item.getBarcode(),
                    item.getBuyPrice() + "", item.getSellPrice() + "",
                    Integer.toString(item.getCaseQuantity()), item.getDepartment()};
        }
        this.inventoryViewModel = new InventoryViewModel(inventoryTable);

        ArrayList<InventoryItem> items2 = new ArrayList<>();
        ArrayList<Order> orders = new ArrayList<>();
        items2.add(item0);
        items2.add(item1);
        items2.add(item2);
        items2.add(item3);
        items2.add(item4);
        items2.add(item5);
        items2.add(item6);
        items2.add(item7);
        items2.add(item8);
        items2.add(item9);
        items2.add(item10);

        inventory = new Inventory(inventoryname, items2, orders);
    }

    /**
     * Asserts that the two files of the exported inventory exists at the specificed location
     * @throws IOException as required by Exporter
     */

    @Test
    public void AssertFilesExist() throws IOException {
        ExportDataWrapper wrapper = new ExportDataWrapper(inventoryViewModel.getItemList(),
                items);
        Exporter exporter = new Exporter(inventoryname, wrapper);
        exporter.export();
        Path p1 = Path.of("src/main/java/exports/" + inventoryname + ".txt");
        File f1 = p1.toFile();
        Path p2 = Path.of("src/main/java/exports/serializable_" + inventoryname + ".txt");
        File f2 = p2.toFile();

        Assertions.assertTrue(f1.exists());
        Assertions.assertTrue(f2.exists());

    }

    /**
     * Tests the exporter direcly by feeding a string and a wrapper.
     * reads the first line of the file to check for correctness
     * @throws IOException as required by Exporter
     */

    @Test
    public void AssertUsrInvCorrect() throws IOException {
        ExportDataWrapper wrapper = new ExportDataWrapper(inventoryViewModel.getItemList(),
                items);
        Exporter exporter = new Exporter(inventoryname, wrapper);
        exporter.export();
        Path p1 = Path.of("src/main/java/exports/" + inventoryname + ".txt");
        File f1 = p1.toFile();
        BufferedReader reader = new BufferedReader(new FileReader(f1));
        String line = reader.readLine();
        line = reader.readLine();
        System.out.println(line);
        String expected = "             bananas                 10.0                12345                  2.0                  3.0                    5                   12 ";

        Assertions.assertEquals(expected, line);
    }

    /**
     * Test the inventory View Model to see if the inventory table contains the right information
     */
    @Test
    public void InventoryViewModel() {
        String[][] inventoryTable = new String[items.size()][7];
        for (int i = 0; i < items.size(); i++) {
            InventoryItem item = (InventoryItem) items.get(i);
            inventoryTable[i] = new String[]{item.getName(), item.getQuantity() + "", item.getBarcode(),
                    item.getBuyPrice() + "", item.getSellPrice() + "",
                    Integer.toString(item.getCaseQuantity()), item.getDepartment()};
        }
        Assertions.assertEquals(inventoryTable[0][0], "bananas");
    }

    /**
     *  Test to see if window opens up correctly when inventory is exported
     * @throws IOException as required by ExporterInventory
     */
    @Test
    public void ExporterInventory() throws IOException {
        ExportPresenter presenter = new ExportInventoryUpdater();
        HashMap controllers = new HashMap();
        ExporterInventory exporterInventory = new ExporterInventory(inventory,presenter, controllers);
        ExportRequestModel exportRequestModel = new ExportRequestModel(inventoryname, inventoryTable);
        exporterInventory.create(exportRequestModel);

        Assertions.assertEquals(inventoryTable[0][0], "bananas");
    }

    /**
     * Test to check if ExportDataWrapper can be instantinted direclty
     */
    @Test
    public void ExportDatWrapper() {
        ExportDataWrapper wrapper = new ExportDataWrapper(inventoryViewModel.getItemList(),
                items);
        inventoryTable = wrapper.getInventorytable();
        wrapper.setInventorytable(inventoryTable);
        ArrayList<Object> array = wrapper.getItems_list();

        Assertions.assertEquals(11, array.size());

    }

}