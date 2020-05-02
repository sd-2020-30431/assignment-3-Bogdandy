package client.serveracess;

import client.business.UserDataStructure;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONException;

public class RequestSignUpQuery {
    public String URLConnectionRequestSignUp(UserDataStructure userDataStructure) throws IOException, JSONException {
        String json = "{\"query\": \"mutation newUser{newUser( Username: \\\""+userDataStructure.getUsername()+
                "\\\", Password: \\\""+userDataStructure.getPassword()+"\\\", Email: \\\""+userDataStructure.getEmailAddress()+
                "\\\", Phone:\\\""+userDataStructure.getPhoneNumber()+"\\\" ) { Username }}\"}";

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
        return result;
    }
}
