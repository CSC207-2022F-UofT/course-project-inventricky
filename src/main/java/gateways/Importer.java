package gateways;

import java.io.*;
import java.util.ArrayList;

public class Importer implements Serializable {
    private final String filename;

    public Importer(String fileToImport) {
        this.filename = fileToImport;
    }

    /**
     * Deserializes inventory data and checks whether each deserialized item is an InventoryItem or and Order.
     * Items are put into this.inventory either in the collection of Orders or InventoryItems.
     */

    public ArrayList<Object> importSerializable() {
        // Initialize empty array for returning
        ArrayList<Object> objectList = new ArrayList<>();
        try {
            // New input and output stream are initialized
            FileInputStream fis = new FileInputStream(this.filename);
            ObjectInputStream ois = new ObjectInputStream(fis);
            // Reading file
            try {
                while(true) {
                    Object obj = ois.readObject();
                    objectList.add(obj);
                }
            } catch (EOFException e) {}
            // Close input and output streams
            fis.close();
            ois.close();
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
        return objectList;
    }

    public static void main(String[] args) {
        Importer imp = new Importer("src/main/java/exports/serializable_inventory.txt");
        System.out.println(imp.importSerializable());
    }

}
