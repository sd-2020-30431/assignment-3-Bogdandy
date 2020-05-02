package client.business;

public class UserDataStructure{
    private Long idUser;
    private final String username;
    private final String password;
    private final String phoneNumber;
    private final String emailAddress;
    private final String passCheck;
    
    public UserDataStructure(String username, String password, String emailAddress, String phoneNumber, String passCheck){
        this.username = username;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.passCheck = passCheck;
    }
    
    public UserDataStructure(String username, String password){
        this.username = username;
        this.password = password;
        this.passCheck = password;
        this.phoneNumber = null;
        this.emailAddress = null;
    }
    
    public Long getIdUser(){
        return idUser;
    }
    
    public void setIdUser(Long idUser){
        this.idUser = idUser;
    }
    
    public String getUsername(){
        return username;
    }
    
    public String getPassCheck(){
        return passCheck;
    }
    
    public String getPassword(){
        return password;
    }
    
    public String getPhoneNumber(){
        return phoneNumber;
    }
    
    public String getEmailAddress(){
        return emailAddress;
    }
}