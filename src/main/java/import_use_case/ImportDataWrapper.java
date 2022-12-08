package import_use_case;

import java.util.ArrayList;

public class ImportDataWrapper {
    private final ArrayList<Object> list;

    /**
     * Initializes importDataWrapper
     *
     * @param importList list of inventory items from imported inventory
     */

    public ImportDataWrapper(ArrayList<Object> importList) {
        this.list = importList;
    }

    public ArrayList<Object> getList() {
        return this.list;
    }
}





