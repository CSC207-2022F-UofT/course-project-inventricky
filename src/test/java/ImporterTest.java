package entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class ImporterTest {
    @BeforeAll
    static void makeTestData() {
    }

    @Test
    public void importToListSerializableTest() {
        Inventory inv = new Inventory("Test");
        Importer importer = new Importer("src/main/java/exports/serializable_inventory.txt", inv);
    }

}