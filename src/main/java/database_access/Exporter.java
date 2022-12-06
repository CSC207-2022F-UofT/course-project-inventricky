package database_access;

import entities.InventoryItem;
import export_use_case.ExportDataWrapper;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class Exporter  implements Serializable {

    private static boolean scratchInventory;
    private final String filename;
    ExportDataWrapper dataWrapper;

    public Exporter(String filename, ExportDataWrapper dataWrapper) {
        this.filename = filename;
        this.dataWrapper = dataWrapper;
    }

    /**
     * Creates two text files, one for the serialized inventory item and one for the user to read and keep as a backup
     * */

    public void export() throws IOException {
        File user_inventory = new File("src/main/java/exports/"+filename+".txt");
        File order_inventory = new File("src/main/java/exports/order_inventory.txt");
        File serializable_inventory = new File("src/main/java/exports/serializable_"+filename+".txt");

        //if scratch inventory, copy temp barcodes to new barcode file
        if (!new File("src/main/java/exports/"+filename+".csv").isFile() || scratchInventory) {
            //for this run of the program, keep overwriting new barcode file
            scratchInventory = true;
            //copy file to exports
            Path pathIn = Paths.get("src/main/java/temp_files/new_inventory_barcodes_temp.csv");
            Path pathOut = Paths.get("src/main/java/exports/"+filename+".csv");
            Files.copy(pathIn, pathOut, StandardCopyOption.REPLACE_EXISTING);

        }



        //ArrayList<File> to_return = new ArrayList<File>();

        // Wring the user_inventory file
        FileWriter usr_inv = new FileWriter(user_inventory);
        String headers = String.format("%20s %20s %20s %20s %20s %20s %20s \r\n", "Name", "Quantity",
                "Barcode","BuyPrice","Sell Price", "CaseQuantity","Department");
        usr_inv.write(headers);
        for (int i = 0; i <  dataWrapper.getInventorytable().length; i++) {
                String[] row = dataWrapper.getInventorytable()[i];
                String to_print = String.format("%20s %20s %20s %20s %20s %20s %20s \r\n", row[0], row[1],
                        row[2], row[3],row[4],row[5],row[6]);
                usr_inv.write(to_print);
        }
        usr_inv.close();

        // Wring the order_inventory file
        /*FileWriter ord_inv = new FileWriter(order_inventory);
        String headers2 = String.format("%20s %20s %20s %20s %20s %20s %20s %20s %20s %20s %20s \r\n",
                "Name", "Quantity", "Department", "Barcode","CaseQuantity",
                "Sell Price","dateBought", "estimatedDate", "dateReceived","supplier","cases");
        ord_inv.write(headers2);
        for (Order order: inventory.getOrders()) {
            String to_print = String.format("%20s %20s %20s %20s %20s %20s %20s %20s %20s %20s %20s \r\n",order.getName(), order.getQuantity(),
                    order.getDepartment(),order.getBarcode(), order.getCaseQuantity(),order.getSellPrice(),
                    order.getDateBought(), order.getEstimatedDate(), order.getDateReceived(), order.getSupplier(), order.getOrderCases());
            ord_inv.write(to_print);
        }
        ord_inv.close();*/

        // Creating and wring the serializable importable file
        FileOutputStream fileOutputStream = new FileOutputStream(serializable_inventory);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        for (Object item: dataWrapper.getItems_list()) {
            objectOutputStream.writeObject(item);
            objectOutputStream.reset();
            objectOutputStream.flush();
        }
        for (Object order: dataWrapper.getOrders_list()) {
            objectOutputStream.writeObject(order);
            objectOutputStream.reset();
            objectOutputStream.flush();
        }

        objectOutputStream.close();

        /*
         adding both files to an array and returning it
         to_return.add(serializable_inventory);
         to_return.add(user_inventory);
        */

    }
}
