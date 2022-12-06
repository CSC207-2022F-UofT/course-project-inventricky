package new_item_use_case;
//Input data
//DONE
public class NewItemRequestModel {

    private String name;
    private boolean isWeight;
    private double quantity;
    private double buyPrice;
    private double sellPrice;
    private int caseQuantity;
    private String department;

    /** Construct new item request model object
     *
     * @param name          name of item to be added.
     * @param isWeight      true if item to be added quantified in kg.
     * @param quantity      quantity of item to be added.
     * @param buyPrice      buy price of item to be added.
     * @param sellPrice     sell price of item to be added.
     * @param caseQuantity  quantity per case of item.
     * @param department    department number of item.
     */
    public NewItemRequestModel(String name, boolean isWeight, double quantity, double buyPrice, double sellPrice,
                               int caseQuantity, String department) {
        this.name = name;
        this.isWeight = isWeight;
        this.quantity = quantity;
        this.buyPrice = buyPrice;
        this.sellPrice = sellPrice;
        this.caseQuantity = caseQuantity;
        this.department = department;
    }

    String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    boolean getIsWeight() {
        return isWeight;
    }

    void setIsWeight(boolean isWeight) {
        this.isWeight = isWeight;
    }

    double getQuantity() {
        return quantity;
    }

    void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    double getBuyPrice() {
        return buyPrice;
    }

    void setBuyPrice(double buyPrice) {
        this.buyPrice = buyPrice;
    }

    double getSellPrice() {
        return sellPrice;
    }

    void setSellPrice(double sellPrice) {
        this.sellPrice = sellPrice;
    }

    int getCaseQuantity() {
        return caseQuantity;
    }

    void setCaseQuantity(int caseQuantity) {
        this.caseQuantity = caseQuantity;
    }

    String getDepartment() {
        return department;
    }

    void setDepartment(String department) {
        this.department = department;
    }
}
