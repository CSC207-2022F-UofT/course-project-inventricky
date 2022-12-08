package database_access;

import java.io.File;

public class Deleter {

    public void deleteInventory(String invName) {
        File file1 = new File("src/main/java/exports/serializable_" + invName + ".txt");
        File file2 = new File("src/main/java/exports/" + invName + ".csv");
        File file3 = new File("src/main/java/exports/" + invName + ".txt");

        file1.delete();
        file2.delete();
        file3.delete();
    }
}
