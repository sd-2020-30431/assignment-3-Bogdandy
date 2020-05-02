package client.business;

public class ItemChecker {
    private ItemInformation data;
    
    public ItemChecker(ItemInformation data){
        this.data = data;
    }
    
    public boolean checkItemName(){
        if(data.getItemName() == null)
            return false;
        if(data.getItemName().compareTo("")==0 || data.getItemName().length()<3 || data.getItemName().length()>80)
            return false;
        return true;
    }
    
    public boolean checkQuantity(){
        if(data.getQuantity() == 0)
            return false;
        return true;
    }
    
    public boolean checkCaloricValue(){
        if(data.getCaloricValue() == 0)
            return false;
        return true;
    }
    
    public boolean checkPurchaseDate(){
        if(data.getPurchaseDate().compareTo(data.getExpirationDate()) > 0 || 
                data.getPurchaseDate().compareTo(data.getConsumptionDate()) > 0)
            return false;
        return true;
    } 
    
    public boolean checkConsumptionDate(){
        if(data.getConsumptionDate().compareTo(data.getExpirationDate()) > 0 ||
                data.getConsumptionDate().compareTo(data.getPurchaseDate()) < 0)
            return false;
        return true;
    } 
    
     public boolean checkExpirationDate(){
        if(data.getExpirationDate().compareTo(data.getPurchaseDate()) < 0 ||
                data.getExpirationDate().compareTo(data.getConsumptionDate()) < 0)
            return false;
        return true;
    } 
     
     public boolean checkItemInformation(){
         return (checkItemName() && checkQuantity() && checkCaloricValue() &&
                 checkPurchaseDate()&& checkExpirationDate() && checkConsumptionDate());
     }
}
