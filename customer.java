package sample.model;

public class customer {

    private String companyName;
    private String address;




    public customer(String companyName, String address) {
        this.companyName = companyName;
        this.address = address;
    }

    public customer() {

    }


    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return this.getCompanyName();
    }




}
