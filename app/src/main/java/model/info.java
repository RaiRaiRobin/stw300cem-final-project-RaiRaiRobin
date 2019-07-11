package model;

public class info {

    private int id;
    private String FirstName;
    private String first_name;

    private String MiddleName;
    private String middle_name;

    private String LastName;
    private String last_name;

    private String Gender;
    private String gender;

    private String Address;
    private String address;

    private String DOB;
    private String dob;

    private String Phone;
    private String phone;

    private String Email;
    public String email;

    private String Password;
    private String password;

    public String user_type;
    public String photo;
    public String Photo;



    public info( String first_name, String middle_name, String last_name, String gender, String address, String dob , String phone, String Email, String Password) {
        this.FirstName=first_name;
        this.MiddleName=middle_name;
        this.LastName=last_name;
        this.Gender=gender;
        this.Address=address;
        this.DOB=dob;
        this.Phone=phone;
        this.Email=Email;
        this.Password=Password;
        this.Photo="asdad";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return first_name;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getMiddleName() {
        return middle_name;
    }

    public void setMiddleName(String middleName) {
        MiddleName = middleName;
    }

    public String getLastName() {
        return last_name;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getDOB() {
        return dob;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        Photo = photo;
    }

    public String getUser_type() {
        return user_type;
    }

}
