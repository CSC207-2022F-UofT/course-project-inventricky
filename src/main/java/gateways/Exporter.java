package gateways;

import entities.Inventory;
import entities.InventoryItem;

import java.io.*;
import java.util.ArrayList;

public class Exporter  implements Serializable {

    private final Inventory inventory;

    public Exporter(Inventory inventory) {
        this.inventory= inventory;
    }


    public ArrayList<File> export() throws IOException {
        File user_inventory = new File("src/main/java/exports/user_inventory.txt");
        File serializable_inventory = new File("src/main/java/exports/serializable_inventory.txt");

        ArrayList<File> to_return = new ArrayList<File>();

        // Wring the user-readable file
        FileWriter usr_inv = new FileWriter(user_inventory);
        String headers = String.format("%20s %20s %20s %20s %20s %20s %20s %20s \r\n", "Name", "Quantity",
                "Department", "Quantity Sold", "Quantity Bought", "Barcode","CaseQuantity","Sell Price");
        usr_inv.write(headers);
        for (InventoryItem item: inventory.getItems()) {
            String to_print = String.format("%20s %20s %20s %20s %20s %20s %20s %20s \r\n",item.getName(), item.getQuantity(),
                    item.getDepartment(), item.getQuantitySold(),
                    item.getQuantityBought(),item.getBarcode(),
                    item.getCaseQuantity(),item.getSellPrice());
            usr_inv.write(to_print);
        }
        usr_inv.close();

        // Creating and wring the serializable importable file
        FileOutputStream fileOutputStream = new FileOutputStream(serializable_inventory);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        for (InventoryItem item: inventory.getItems()) {
            objectOutputStream.writeObject(item);
            objectOutputStream.reset();
            objectOutputStream.flush();
        }
        objectOutputStream.close();

        // adding both files to an array and returning it
        to_return.add(serializable_inventory);
        to_return.add(user_inventory);

        return to_return;

    }
}
