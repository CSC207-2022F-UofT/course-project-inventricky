package database_access;

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

    /**
     * Constructor for the exporter class that exports the inventory
     * @param filename the name of the inventory, which will become how the file is named
     * @param dataWrapper object containing the inventory information and items list
     */
    public Exporter(String filename, ExportDataWrapper dataWrapper) {
        this.filename = filename;
        this.dataWrapper = dataWrapper;
    }

    /**
     * Creates two files, one for the user inventory and one with the serialized objects that can be imported
     * inside another inventory management system. The filename contain the name of inventory being exported.
     * Both files are .txt
     * The user inventory file is a table of all the items, readable by humans
     * The serializable inventory contains all the inventory items serialized - not readable by humans
     * @throws IOException as required by the Filewriter clas
     */
    public void export() throws IOException {
        File user_inventory = new File("src/main/java/exports/"+filename+".txt");
        File serializable_inventory = new File("src/main/java/exports/serializable_"+filename+".txt");

        //if scratch inventory, copy temp barcodes to new barcode file
        if (!new File("src/main/java/exports/"+filename+".csv").isFile() || scratchInventory) {
            //for this run of the program, keep overwriting new barcode file
            scratchInventory = true;
            //copy file to exports
            Path pathIn = Paths.get("src/main/java/temp_files/new_inventory_barcodes.csv");
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

        // Creating and wring the serializable importable file
        FileOutputStream fileOutputStream = new FileOutputStream(serializable_inventory);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        for (Object item: dataWrapper.getItems_list()) {
            objectOutputStream.writeObject(item);
            objectOutputStream.reset();
            objectOutputStream.flush();
        }
        objectOutputStream.close();
    }
}
