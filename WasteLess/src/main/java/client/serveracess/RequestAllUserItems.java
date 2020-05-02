package client.serveracess;

import client.business.ItemInformation;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONException;

public class RequestAllUserItems {
    private final List<ItemInformation> groceryItems = new ArrayList<>();
    
    public List<ItemInformation> URLConnectionRequestGroceryList(Long id) throws IOException, JSONException, ParseException {
        String json = "{\"query\": \"query { userAllItems( idUserList: "+id+"){id, idUserList, ListNo, ItemName, Quantity, CaloricValue, PurchaseDate, ExpirationDate, ConsumptionDate}}\"}";

        URL url = new URL("http://localhost:8080/graphql");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setConnectTimeout(5000);
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
        conn.addRequestProperty("Accept", "application/json");
        conn.setDoOutput(true);
        conn.setDoInput(true);

        OutputStream os = conn.getOutputStream();
        os.write(json.getBytes("UTF-8"));
        os.close();
        
        // read the response
        InputStream in = new BufferedInputStream(conn.getInputStream());
        String result = org.apache.commons.io.IOUtils.toString(in, "UTF-8");
        
        try{
            String[] ids = StringUtils.substringsBetween(result, "{\"id\":", ",");
            String[] idUserLists = StringUtils.substringsBetween(result, "\"idUserList\":", ",");
            String[] listNos = StringUtils.substringsBetween(result, "\"ListNo\":", ",");
            String[] itemNames = StringUtils.substringsBetween(result, "\"ItemName\":\"", "\",");
            String[] quantities = StringUtils.substringsBetween(result, "\"Quantity\":", ",");
            String[] caloricValues = StringUtils.substringsBetween(result, "\"CaloricValue\":", ",");
            String[] purchaseDates = StringUtils.substringsBetween(result, "\"PurchaseDate\":\"", "\",");
            String[] expirationDates = StringUtils.substringsBetween(result, "\"ExpirationDate\":\"", "\",");
            String[] consumptionDates = StringUtils.substringsBetween(result, "\"ConsumptionDate\":\"", "\"}");

            DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            for(int i = 0; i<ids.length;i++){
                LocalDate purchaseDate = LocalDate.parse(purchaseDates[i]);
                LocalDate expirationDate = LocalDate.parse(expirationDates[i]);
                LocalDate consumptionDate = LocalDate.parse(consumptionDates[i]);
                ItemInformation itemInformation = new ItemInformation(Long.parseLong(ids[i]), Long.parseLong(idUserLists[i]), itemNames[i], Integer.parseInt(quantities[i]),Integer.parseInt(caloricValues[i]), purchaseDate, expirationDate, consumptionDate, Integer.parseInt(listNos[i]));
                groceryItems.add(itemInformation);
            }
            return groceryItems;
        }catch(NullPointerException ex){
            return null;
        }finally{
            in.close();
            conn.disconnect();
        }
    }
}
