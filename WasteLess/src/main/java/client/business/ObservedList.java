package client.business;

import java.time.ZoneId;
import java.util.*;

public class ObservedList extends Observable{
    private List<ItemInformation> groceryList;
    private List<ItemInformation> groceryUpcomingList = new ArrayList<>();
    private Date date;
    
    public ObservedList(List<ItemInformation> groceryList){
        this.groceryList = groceryList;
        date = new Date();
        
    }
    
    public void checkDate(){
	ZoneId defaultZoneId = ZoneId.systemDefault();
        boolean successful = true;
                
        for(ItemInformation itemInformation: groceryList){
            Calendar cal1 = Calendar.getInstance();
            Calendar cal2 = Calendar.getInstance();
            Date consumptionDate = Date.from(itemInformation.getConsumptionDate().atStartOfDay(defaultZoneId).toInstant());
            cal1.setTime(consumptionDate);
            cal2.setTime(date);
            if(cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR) &&
                cal1.get(Calendar.DAY_OF_YEAR) == cal2.get(Calendar.DAY_OF_YEAR)){
                successful = false;
                groceryUpcomingList.add(itemInformation);
            }
        }
        
        if(successful == false){
            setChanged();
            notifyObservers(groceryUpcomingList); 
        }
    }
}
