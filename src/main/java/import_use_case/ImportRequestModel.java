package import_use_case;

public class ImportRequestModel {
    private String invName;
    private String fileName;

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

    public void setInvName(String invName) {
        this.invName = invName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
