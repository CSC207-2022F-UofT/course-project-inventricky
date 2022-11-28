package entities;

import java.io.*;

public class Exporter  implements Serializable {


    private final Inventory inventory;
    /**
     * @param inventory inventory to be exported
     * */

    public Exporter(Inventory inventory) {
        this.inventory= inventory;
    }
    /**
     * Creates two text files, one for the serialized inventory item and one for the user to read and keep as a backup
     * */

    public void export() throws IOException {
        File user_inventory = new File("src/main/java/exports/user_inventory.txt");
        File order_inventory = new File("src/main/java/exports/order_inventory.txt");
        File serializable_inventory = new File("src/main/java/exports/serializable_inventory.txt");

        //ArrayList<File> to_return = new ArrayList<File>();

        // Wring the user_inventory file
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

        // Wring the order_inventory file
        FileWriter ord_inv = new FileWriter(order_inventory);
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
        ord_inv.close();

        // Creating and wring the serializable importable file
        FileOutputStream fileOutputStream = new FileOutputStream(serializable_inventory);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        for (InventoryItem item: inventory.getItems()) {
            objectOutputStream.writeObject(item);
            objectOutputStream.reset();
            objectOutputStream.flush();
        }
        for (Order order: inventory.getOrders()) {
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
