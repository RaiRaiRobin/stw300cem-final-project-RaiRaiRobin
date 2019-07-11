package model;

public class Patients {

    private String id;
    private String first_name;
    private String last_name;
    private String middle_name;
    private String gender;
    private String address;
    private String dob;
    private String email;
    private String phone;
    private String photo;
    private String user_type;
    private String createdAt;


    public Patients(int id,String first_name, String last_name,String middle_name,String gender,String adddress,String dob,String email,String phone,String photo,String user_type,String createdAt){

    }


    public String getId() {
        return id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getMiddle_name() {
        return middle_name;
    }

    public String getGender() {
        return gender;
    }

    public String getAddress() {
        return address;
    }

    public String getDob() {
        return dob;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getPhoto() {
        return photo;
    }

    public String getUser_type() {
        return user_type;
    }

    public String getCreatedAt() {
        return createdAt;
    }
}
