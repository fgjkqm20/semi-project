package nbd.qna.model.vo;

public class Qna {
    private String memberId; // 작성자
    private int infoNo; // 글번호
    private String infoTitle; // 글제목
    private String infoContent; // 글내용
    private int infoCount; // 조회수
    private String infoDate; // 작성일
    private String filePath; // 첨부파일
    private String fileName;
    private int commentCnt;// 댓글 갯수

    public Qna() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Qna(String memberId, int infoNo, String infoTitle, String infoContent, int infoCount,
            String infoDate, String filePath, String fileName, int commentCnt) {
        super();
        this.memberId = memberId;
        this.infoNo = infoNo;
        this.infoTitle = infoTitle;
        this.infoContent = infoContent;
        this.infoCount = infoCount;
        this.infoDate = infoDate;
        this.filePath = filePath;
        this.fileName = fileName;
        this.commentCnt = commentCnt;
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

    public String getQnaContentBr() { // textarea content부분에 내용쓸대 엔터 칠 수 있도록 get터를 만들어주고
                                      // noticeview.jsp content변경
        return infoContent.replace("\r\n", "<br>");
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

    public int getCommentCnt() {
        return commentCnt;
    }

    public void setCommentCnt(int commentCnt) {
        this.commentCnt = commentCnt;
    }

}
