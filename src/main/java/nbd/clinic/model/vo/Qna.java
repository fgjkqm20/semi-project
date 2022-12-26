package nbd.clinic.model.vo;

public class Qna {
    private int memberNo; // 회원번호
    private String memberId; // 작성자
    private int infoNo; // 글번호
    private String infoTitle; // 글제목
    private String infoContent; // 글내용
    private int infoCount; // 조회수
    private String infoDate; // 작성일
    private String filePath; // 첨부파일
    private String fileName;

    public int getMemberNo() {
        return memberNo;
    }

    public void setMemberNo(int memberNo) {
        this.memberNo = memberNo;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public int getInfoNo() {
        return infoNo;
    }

    public void setInfoNo(int infoNo) {
        this.infoNo = infoNo;
    }

    public String getInfoTitle() {
        return infoTitle;
    }

    public void setInfoTitle(String infoTitle) {
        this.infoTitle = infoTitle;
    }

    public String getInfoContent() {
        return infoContent;
    }

    public void setInfoContent(String infoContent) {
        this.infoContent = infoContent;
    }

    public int getInfoCount() {
        return infoCount;
    }

    public void setInfoCount(int infoCount) {
        this.infoCount = infoCount;
    }

    public String getInfoDate() {
        return infoDate;
    }

    public void setInfoDate(String infoDate) {
        this.infoDate = infoDate;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Qna(int memberNo, String memberId, int infoNo, String infoTitle, String infoContent,
            int infoCount, String infoDate, String filePath, String fileName) {
        super();
        this.memberNo = memberNo;
        this.memberId = memberId;
        this.infoNo = infoNo;
        this.infoTitle = infoTitle;
        this.infoContent = infoContent;
        this.infoCount = infoCount;
        this.infoDate = infoDate;
        this.filePath = filePath;
        this.fileName = fileName;
    }

    public Qna() {
        super();
        // TODO Auto-generated constructor stub
    }
}
