package entities;

import java.io.*;
import java.util.ArrayList;

public class Importer1 implements Serializable {
    private Inventory inventory;
    private final String filename;
    private String delimiter = ";";

    public Importer1(String fileToImport, Inventory givenInventory) {
        this.filename = fileToImport;
        this.inventory = givenInventory;
    }

    public Importer1(String fileToImport, Inventory givenInventory, String delimiter) {
        this.filename = fileToImport;
        this.inventory = givenInventory;
        this.delimiter = delimiter;
    }

    /**
     * Imports csv representation of inventory and returns an ArrayList containing each line in a sublist.
     *
     * @return ArrayList made up of sub-lists, each holding a line of the .csv split by delimiter.
     */

//    public List<List> importToListcsv() {
//        List<List> importList = new ArrayList<>();
//        // Converting path string to path
//        Path filePath = Paths.get(this.filename);
//
//        // Creating a BufferedReader and using an Exception to catch an IOException
//        try(BufferedReader reader = Files.newBufferedReader(filePath, StandardCharsets.US_ASCII)) {
//            // First Line
//            String line = reader.readLine();
//            // Breaks when there is no next line
//            while (line != null) {
//                // Splits line of csv file into array based on given delimiter
//                String[] readStuff = line.split(delimiter);
//                // Temporary list to store line and copy into what is to be returned
//                List<String> copyList = new ArrayList<>();
//                for (String str : readStuff) {
//                    copyList.add(str);
//                }
//                importList.add(copyList);
//                // Goes to next line
//                line = reader.readLine();
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return importList;
//    }

    /**
     * Deserializes inventory data and checks whether each deserialized item is an InventoryItem or and Order.
     * Items are put into this.inventory either in the collection of Orders or InventoryItems.
     */

    public void importSerializable() {
        // Initialize empty array for returning
        ArrayList<InventoryItem> importList = new ArrayList<>();
        ArrayList<Order> orderList = new ArrayList<>();
        try {
            // New input and output stream are initialized
            FileInputStream fis = new FileInputStream(this.filename);
            ObjectInputStream ois = new ObjectInputStream(fis);
            // Reading file
            try {
                while(true) {
                    Object obj = ois.readObject();
                    if (obj instanceof InventoryItem) {
                        importList.add((InventoryItem) obj);
                    } else {
                        orderList.add((Order) obj);
                    }
                }
            } catch (EOFException e) {
                this.inventory.setItems(importList);
                this.inventory.setOrders(orderList);
            }
            // Close input and output streams
            fis.close();
            ois.close();
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Inventory inventory1 = new Inventory("Test");
        Importer1 imp = new Importer1("src/main/java/exports/serializable_inventory.txt", inventory1);
        imp.importSerializable();
        System.out.println(inventory1.getItems());
    }

}
