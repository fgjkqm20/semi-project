package nbd.member.model.vo;

public class DoctorComment {
    private int doctorNo; // 의사의 회원번호
    private String doctorId; // 의사아이디
    private int doctorComStar; // 의사한테 준 별점
    private String doctorComment; // 의사한테 준 후기멘트

    public int getDoctorNo() {
        return doctorNo;
    }

    public void setDoctorNo(int doctorNo) {
        this.doctorNo = doctorNo;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    public int getDoctorComStar() {
        return doctorComStar;
    }

    public void setDoctorComStar(int doctorComStar) {
        this.doctorComStar = doctorComStar;
    }

    public String getDoctorComment() {
        return doctorComment;
    }

    public void setDoctorComment(String doctorComment) {
        this.doctorComment = doctorComment;
    }

    public DoctorComment(int doctorNo, String doctorId, int doctorComStar, String doctorComment) {
        super();
        this.doctorNo = doctorNo;
        this.doctorId = doctorId;
        this.doctorComStar = doctorComStar;
        this.doctorComment = doctorComment;
    }

    public DoctorComment() {
        super();
        // TODO Auto-generated constructor stub
    }
}
