package client.business;

import java.io.IOException;
import java.text.ParseException;
import java.util.*;
import javax.swing.JOptionPane;
import org.json.JSONException;

public class CheckList extends TimerTask{
    private ObservedList observedList;
    private final Long id;
    private final GroceryItemRequests groceryItemRequests;
    private final ListObserver listObserver;
    
    public CheckList(Long id, GroceryItemRequests groceryItemRequests){
        this.id=id;
        this.groceryItemRequests = groceryItemRequests;
        listObserver = new ListObserver();
    }
    
    @Override
    public void run(){
        try {
            observedList = new ObservedList(groceryItemRequests.retrieveAllUserItems(id));
        } catch (IOException | JSONException | ParseException ex) {
            JOptionPane.showMessageDialog(null, "Something went wrong!\nService provider may be down!", "Warning", JOptionPane.WARNING_MESSAGE);
        }
            observedList.addObserver(listObserver);
            observedList.checkDate();
       }
}
