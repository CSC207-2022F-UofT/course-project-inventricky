package entities;

import java.io.*;

public class Exporter {
    public Exporter(Inventory inventory) throws IOException {
        File user_inventory = new File("user_inventory.txt");
        File serializable_inventory = new File("serializable_inventory.txt");

        FileWriter usr_inv = new FileWriter(user_inventory);
        for (Item item: inventory.getItems()) {
            usr_inv.write(String.valueOf(item));
        }
        usr_inv.close();

        FileOutputStream fileOutputStream = new FileOutputStream(serializable_inventory);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        for (Item item: inventory.getItems()) {
            objectOutputStream.writeObject(item);
            objectOutputStream.flush();
        }
        objectOutputStream.close();

    }
}
