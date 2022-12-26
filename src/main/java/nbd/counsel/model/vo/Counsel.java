package nbd.counsel.model.vo;

public class Counsel {
    private String memberId; // 작성자
    private int counselNo; // 글번호
    private String counselTitle; // 글제목
    private String counselSubject; // 글진료과목
    private String counselContent; // 글내용
    private int counselCount; // 글조회수
    private String counselDate; // 글작성일
    private int counselAnswer; // 답변완료여부 ( 0답변없음 1답변완료)
    private String filePath; // 첨부파일
    private String fileName;

    public Counsel() {
        super();
    }

    public Counsel(String memberId, int counselNo, String counselTitle, String counselSubject,
            String counselContent, int counselCount, String counselDate, int counselAnswer,
            String filePath, String fileName) {
        super();
        this.memberId = memberId;
        this.counselNo = counselNo;
        this.counselTitle = counselTitle;
        this.counselSubject = counselSubject;
        this.counselContent = counselContent;
        this.counselCount = counselCount;
        this.counselDate = counselDate;
        this.counselAnswer = counselAnswer;
        this.filePath = filePath;
        this.fileName = fileName;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public int getCounselNo() {
        return counselNo;
    }

    public void setCounselNo(int counselNo) {
        this.counselNo = counselNo;
    }

    public String getCounselTitle() {
        return counselTitle;
    }

    public void setCounselTitle(String counselTitle) {
        this.counselTitle = counselTitle;
    }

    public String getCounselSubject() {
        return counselSubject;
    }

    public void setCounselSubject(String counselSubject) {
        this.counselSubject = counselSubject;
    }

    public String getCounselContent() {
        return counselContent;
    }

    public void setCounselContent(String counselContent) {
        this.counselContent = counselContent;
    }

    public int getCounselCount() {
        return counselCount;
    }

    public void setCounselCount(int counselCount) {
        this.counselCount = counselCount;
    }

    public String getCounselDate() {
        return counselDate;
    }

    public void setCounselDate(String counselDate) {
        this.counselDate = counselDate;
    }

    public int getCounselAnswer() {
        return counselAnswer;
    }

    public void setCounselAnswer(int counselAnswer) {
        this.counselAnswer = counselAnswer;
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
}
