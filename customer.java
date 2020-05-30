package sample.model;

public class customer {

    private String companyName;
    private String address;
    private String orderNo;
    private String offerNo;

    public customer(String companyName, String address) {
        this.companyName = companyName;
        this.address = address;
    }

    public customer(String orderNo) {
        this.orderNo = orderNo;
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

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getOfferNo() {
        return offerNo;
    }

    public void setOfferNo(String offerNo) {
        this.offerNo = offerNo;
    }
}
