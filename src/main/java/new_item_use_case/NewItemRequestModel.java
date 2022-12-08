package new_item_use_case;
//Input data
//DONE
public class NewItemRequestModel {

    private final String name;
    private final boolean isWeight;
    private final double quantity;
    private final double buyPrice;
    private final double sellPrice;
    private final int caseQuantity;
    private final String department;

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

    boolean getIsWeight() {
        return isWeight;
    }

    double getQuantity() {
        return quantity;
    }

    double getBuyPrice() {
        return buyPrice;
    }

    double getSellPrice() {
        return sellPrice;
    }

    int getCaseQuantity() {
        return caseQuantity;
    }

    String getDepartment() {
        return department;
    }

}
