package useCases;

public class InventoryImportBuilder implements InventoryBuilder {
    private String name;
    private String filename;

    public InventoryImportBuilder(String name, String filename) {
        this.name = name;
        this.filename = filename;
    }

    public void create() {
        //TODO: wait for Dario
    }
}
