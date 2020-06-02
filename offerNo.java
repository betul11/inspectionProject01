package sample.model;

public class offerNo {
    private String companyName;
    private String offerNo;


    public offerNo(String companyName, String offerNo) {
        this.companyName = companyName;
        this.offerNo = offerNo;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getOfferNo() {
        return offerNo;
    }

    public void setOfferNo(String offerNo) {
        this.offerNo = offerNo;
    }
    @Override
    public String toString() {
        return this.getOfferNo();
    }
}
