package client.business;

import java.time.LocalDate;

public class ItemInformation{
    private Long itemId = 0L;
    private final String itemName;
    private final Long itemUserId;
    private final Integer quantity;
    private final Integer caloricValue;
    private final LocalDate purchaseDate;
    private final LocalDate expirationDate;
    private final LocalDate consumptionDate;
    private final Integer tableIndex;
    
    public ItemInformation(Long itemId, Long itemUserId, String itemName, Integer quantity, Integer caloricValue, LocalDate purchaseDate, LocalDate expirationDate, LocalDate consumptionDate, Integer tableIndex){
        this.itemId = itemId;
        this.itemUserId = itemUserId;
        this.itemName = itemName;
        this.quantity = quantity;
        this.caloricValue = caloricValue;
        this.purchaseDate = purchaseDate;
        this.expirationDate = expirationDate;
        this.consumptionDate = consumptionDate;
        this.tableIndex = tableIndex;
    }
    
    public ItemInformation(Long itemUserId, String itemName, Integer quantity, Integer caloricValue, LocalDate purchaseDate, LocalDate expirationDate, LocalDate consumptionDate, Integer tableIndex){
        this.itemUserId = itemUserId;
        this.itemName = itemName;
        this.quantity = quantity;
        this.caloricValue = caloricValue;
        this.purchaseDate = purchaseDate;
        this.expirationDate = expirationDate;
        this.consumptionDate = consumptionDate;
        this.tableIndex = tableIndex;
    }
    
    public Long getItemId(){
        return itemId;
    }
    
    public Long getIdUserList(){
        return itemUserId;
    }
    
    public Integer getTableIndex(){
        return tableIndex;
    }
    
    public String getItemName(){
        return itemName;
    }
    
    public Integer getQuantity(){
        return quantity;
    }
    
    public Integer getCaloricValue(){
        return caloricValue;
    }
    
    public LocalDate getPurchaseDate(){
        return purchaseDate;
    }
    
    public LocalDate getExpirationDate(){
        return expirationDate;
    }
    
    public LocalDate getConsumptionDate(){
        return consumptionDate;
    }
}
