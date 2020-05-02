package client.business;

import java.util.*;
import javax.swing.JOptionPane;


public class ListObserver implements Observer{
    private List<ItemInformation> groceryList;
    private boolean notifications = true;
    
    @Override
    public void update(Observable o, Object arg) {
        if(notifications){
            groceryList = (List<ItemInformation>) arg;
            String message = "Did you finish eating these items?\n";
            
            for(ItemInformation itemInformation: groceryList){
                message += "List "+itemInformation.getTableIndex()+": "+itemInformation.getItemName()+"\n";
            }
            
            int input = JOptionPane.showConfirmDialog(null, message);

            if(input == 0){
                input = JOptionPane.showConfirmDialog(null, "Do you want to still be notified in this session?");

                if(input == 1){
                    notifications = false;
                }
            }else if(input == 1){
                input = JOptionPane.showConfirmDialog(null, "We recommend that if you are still going to consume these items that you extend the duration.\nIf not please look for a local food bank and donate them.\nDo you want to still be notified in this session?");
                
                if(input == 1){
                    notifications = false;
                }
            }
        }
    }
}
