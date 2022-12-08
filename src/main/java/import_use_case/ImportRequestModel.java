package import_use_case;

public class ImportRequestModel {
    private final String invName;
    private final String fileName;

    /**
     * Initializes importRequestModel
     *
     * @param invName name of inventory
     * @param fileName string of filename to import
     */

    public ImportRequestModel(String invName, String fileName) {
        this.invName = invName;
        this.fileName = fileName;
    }

    public String getInvName() {
        return invName;
    }

    public String getFileName() {
        return fileName;
    }

}





