package client.business;

public class ReportDataStructure {
    private String itemName;
    private int tableIndex;
    private int quantity;
    private int criteria;
    private int year;
    private int calories;
    
    public ReportDataStructure(String itemName, int tableIndex, int quantity, int calories, int criteria, int year){
        this.itemName = itemName;
        this.quantity = quantity;
        this.tableIndex = tableIndex;
        this.criteria = criteria;
        this.year = year;
        this.calories = calories;
    }
    
    public String getItemName() {
        return itemName;
    }

    public int getTableIndex() {
        return tableIndex;
    }

    public int getCalories() {
        return calories;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getCriteria() {
        return criteria;
    }

    public int getYear() {
        return year;
    }
        
}
