package sample.model;

import java.time.LocalDate;

public class user {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String DOB;
    private String certificateExpiration;

    public user(){

    }

    public user(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public user(String firstName, String lastName, String email, String password, String DOB, String certificateExpiration) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.DOB = DOB;
        this.certificateExpiration = certificateExpiration;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
