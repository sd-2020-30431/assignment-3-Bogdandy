package client.business;

import java.util.regex.Pattern; 

public class AccountChecker {
    private UserDataStructure data;
    
    public AccountChecker(UserDataStructure data){
        this.data = data;
    }
    
    public boolean checkPassword(){
        if(data.getPassword().compareTo("")==0 || data.getPassword().length()<5 || data.getPassword().length()>80)
            return false;
        if(data.getPassword().compareTo(data.getPassCheck())!=0)
            return false;
        return true;
    }
    
    public boolean checkEmailAddress(){
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+ 
                            "[a-zA-Z0-9_+&*-]+)*@" + 
                            "(?:[a-zA-Z0-9-]+\\.)+[a-z" + 
                            "A-Z]{2,7}$"; 
                              
        Pattern pat = Pattern.compile(emailRegex); 
        if (data.getEmailAddress().compareTo("")==0) 
            return false; 
        return pat.matcher(data.getEmailAddress()).matches(); 
    }
    
    public boolean checkUsername(){
        return !(data.getUsername().compareTo("")==0 || data.getUsername().length()<5 || data.getUsername().length()>80);
    }
    
    public boolean checkPhoneNumber(){
        if(data.getPhoneNumber().compareTo("")==0 ||  data.getPhoneNumber().length() < 9)
            return false;
        return data.getPhoneNumber().matches("[0-9]+");
    }
    
    public boolean checkAllFields(){
        if(data.getEmailAddress() == null)
            return (checkUsername() && checkPassword());
        return (checkUsername() && checkPassword() && checkEmailAddress() && checkPhoneNumber());
    }
}
