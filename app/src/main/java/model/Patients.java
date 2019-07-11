package model;

public class Patients {
    private String name;
    private String email;
    private int imageId;

    public Patients(String name, String email, int imageId){
        this.name = name;
        this.email = email;
        this.imageId = imageId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }
}
