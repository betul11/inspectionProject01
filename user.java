package sample.model;

import java.time.LocalDate;

public class user {
    private String firstName;
    private String lastName;
    private String email;
    private String DOB;
    private String certificateExpiration;
    private String level;
    //github linki: https://github.com/betul11/inspectionProject01


    public user(){

    }

    public user(String email) {
        this.email = email;
    }

    public user(String firstName, String lastName, String email, String DOB, String certificateExpiration,String level) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.DOB = DOB;
        this.certificateExpiration = certificateExpiration;
        this.level = level;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getLevel() {
        return level;
    }
    public void setLevel(String level) {
        this.level = level;
    }





    public void setDOB(String DOB) {
        this.DOB = DOB;
    }
    public String getDOB(){
        return this.DOB;
    }

    public String getCertificateExpiration() {
        return certificateExpiration;
    }

    public void setCertificateExpiration(String certificateExpiration) {
        this.certificateExpiration = certificateExpiration;
    }

}
