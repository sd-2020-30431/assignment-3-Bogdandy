package client.serveracess;

import client.business.ItemInformation;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONException;

public class RequestModifyGroceryItem {
    public boolean URLConnectionRequestAddGroceryItem(ItemInformation itemInformation, Long id) throws IOException, JSONException {
        String json = "{\"query\": \"mutation { modifyGroceryItem( id: "+id+", ItemName: \\\""+itemInformation.getItemName()+
                "\\\", CaloricValue: "+itemInformation.getCaloricValue()+", Quantity: "+itemInformation.getQuantity()+
                ", PurchaseDate: \\\""+itemInformation.getPurchaseDate()+"\\\", ExpirationDate: \\\""+itemInformation.getExpirationDate()+"\\\", ConsumptionDate: \\\""+itemInformation.getConsumptionDate()+"\\\" ){ItemName} }\"}";

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

        in.close();
        conn.disconnect();
        return !result.contains("null");
    }
}
