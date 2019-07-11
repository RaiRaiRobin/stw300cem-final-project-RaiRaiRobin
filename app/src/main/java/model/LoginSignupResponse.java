package model;

public class LoginSignupResponse {

    private String message;
    private int status;

    private String token;
    private String name;
    private info info;
    private String photo;

    private String gender;



    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getMessage(){return message;}
    public int getStatus(){return status;}

    public String getUser_type(){
        return info.getUser_type();
    }
    public String getGender(){return info.getGender();}
    public String getEmail(){return info.getEmail();}
    public String getFname(){return info.getFirstName();}
    public String getMname(){return info.getMiddleName();}
    public String getLname(){return info.getLastName();}

    public String name(){
        return name;
    }

    public String getPhoto(){
        return info.getPhoto();
    }
}
