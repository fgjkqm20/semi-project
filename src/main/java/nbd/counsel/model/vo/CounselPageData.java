package nbd.counsel.model.vo;

import java.util.ArrayList;

public class CounselPageData {
    private ArrayList<Counsel> list;
    private String pageNavi;

    public CounselPageData() {
        super();
    }

    public CounselPageData(ArrayList<Counsel> list, String pageNavi) {
        super();
        this.list = list;
        this.pageNavi = pageNavi;
    }

    public ArrayList<Counsel> getList() {
        return list;
    }

    public void setList(ArrayList<Counsel> list) {
        this.list = list;
    }

    public String getPageNavi() {
        return pageNavi;
    }

    public void setPageNavi(String pageNavi) {
        this.pageNavi = pageNavi;
    }
}
