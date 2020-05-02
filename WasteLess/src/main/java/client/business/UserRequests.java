package client.business;

import client.serveracess.RequestLogInQuery;
import client.serveracess.RequestSignUpQuery;
import java.io.IOException;
import org.apache.commons.lang3.StringUtils;

public class UserRequests {
    public Long LogInRequest(String username, String password) throws IOException{ 
        String result = new RequestLogInQuery().URLConnectionRequestLogIn(username, password);
        
        if(!result.contains("null")){
            String id = StringUtils.substringBetween(result, "\"id\":", "}");
            return Long.parseLong(id);
        }else{
            return null;
        }
    }
    public Boolean SignUpRequest(UserDataStructure userDataStructure) throws IOException{
        String result = new RequestSignUpQuery().URLConnectionRequestSignUp(userDataStructure);
        
        if(result.contains(userDataStructure.getUsername())){
            return true;
        }
        
        return false;
    }
}
