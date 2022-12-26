package nbd.search.model.vo;

public class Search {
    private int pharmNo;
    private String pharmPhone;
    private String pharmTitle;
    private String pharmAddr;

    public Search() {
        super();
    }

    public Search(int pharmNo, String pharmPhone, String pharmTitle, String pharmAddr) {
        super();
        this.pharmNo = pharmNo;
        this.pharmPhone = pharmPhone;
        this.pharmTitle = pharmTitle;
        this.pharmAddr = pharmAddr;
    }

    public int getPharmNo() {
        return pharmNo;
    }

    public void setPharmNo(int pharmNo) {
        this.pharmNo = pharmNo;
    }

    public String getPharmPhone() {
        return pharmPhone;
    }

    public void setPharmPhone(String pharmPhone) {
        this.pharmPhone = pharmPhone;
    }

    public String getPharmTitle() {
        return pharmTitle;
    }

    public void setPharmTitle(String pharmTitle) {
        this.pharmTitle = pharmTitle;
    }

    public String getPharmAddr() {
        return pharmAddr;
    }

    public void setPharmAddr(String pharmAddr) {
        this.pharmAddr = pharmAddr;
    }

}
