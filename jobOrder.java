package sample.model;

public class jobOrder {
    private String companyName;
    private String jobOrderNo;

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getJobOrderNo() {
        return jobOrderNo;
    }

    public void setJobOrderNo(String jobOrderNo) {
        this.jobOrderNo = jobOrderNo;
    }

    public jobOrder(String companyName, String jobOrderNo) {
        this.companyName = companyName;
        this.jobOrderNo = jobOrderNo;
    }

    @Override
    public String toString() {
        return this.getJobOrderNo();
    }
}
