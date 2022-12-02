package import_use_case;

import java.util.ArrayList;

public class ImportDataWrapper {
    private ArrayList<Object> list;

    public ImportDataWrapper(ArrayList<Object> importList) {
        this.list = importList;
    }

    public void setList(ArrayList<Object> importList) {
        this.list = importList;
    }

    public ArrayList<Object> getList() {
        return this.list;
    }
}
