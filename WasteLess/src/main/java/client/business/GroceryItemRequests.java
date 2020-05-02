package client.business;

import client.serveracess.*;
import java.io.IOException;
import java.text.ParseException;
import java.util.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import org.json.JSONException;

public class GroceryItemRequests {
    private List<ItemInformation> groceryItems = new ArrayList<>();
    
    public TableModel retrieveListItems(Long id, int listNo) throws IOException, JSONException, ParseException{
        DefaultTableModel tblModel = new DefaultTableModel(){
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
        };

        String[] columnNames = {"Item Name", "Quantity", "Calorie", "Purchase Date", "Expiration Date", "Consumption Date"}; 
        tblModel.setColumnIdentifiers(columnNames);
        
        groceryItems = new RequestGroceryListQuery().URLConnectionRequestGroceryList(id, listNo);
        if(groceryItems != null)
            for (ItemInformation itemInformation: groceryItems){
                    if(itemInformation.getTableIndex() == listNo)
                        tblModel.addRow(new Object[]{
                            itemInformation.getItemName(),
                            itemInformation.getQuantity(),
                            itemInformation.getCaloricValue(),
                            itemInformation.getPurchaseDate(),
                            itemInformation.getExpirationDate(),
                            itemInformation.getConsumptionDate()});
                }
        
        return tblModel;
    }
    
    public boolean clearList(Long id, int ListNo) throws IOException{
        return new RequestListClearQuery().URLConnectionRequestListClear(id, ListNo);
    }
    
    public boolean addNewGroceryItem(ItemInformation itemInformation) throws IOException{
        return new RequestAddGroceryItem().URLConnectionRequestAddGroceryItem(itemInformation);
    }
    
    public boolean removeGroceryItem(int position) throws IOException{
        return new RequestRemoveGroceryItemQuery().URLConnectionRequestRemoveGroceryItem(groceryItems.get(position).getItemId());
    }
    
    public boolean modifyGroceryItem(ItemInformation itemInformation, int position) throws IOException{
        return new RequestModifyGroceryItem().URLConnectionRequestAddGroceryItem(itemInformation, groceryItems.get(position).getItemId());
    }
    
    public boolean searchGroceryItem(Long id, int listNo, String itemName) throws IOException{
        return new RequestSearchGroceryItem().URLConnectionRequestSearchGroceryItem(id, listNo, itemName);
    }
    
    public void createReport(Long id, int listNo, String reportChoice) throws IOException, JSONException, ParseException{
        List<ItemInformation> groceryList = new RequestAllUserItems().URLConnectionRequestGroceryList(id);
        
        AbstractFactory abstractFactory;
        abstractFactory = ReportProvider.getFactory(reportChoice);
        abstractFactory.create(reportChoice, groceryList);
    }
    
    public List<ItemInformation> retrieveAllUserItems(Long id) throws IOException, JSONException, ParseException{
        return new RequestAllUserItems().URLConnectionRequestGroceryList(id);
    }
}
