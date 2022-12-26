package nbd.clinic.model.vo;

public class Book {
    private int bookNo; // 예약번호
    private int memberNo; // 예약한사람
    private String bookDate; // 예약한 시간 (현재시간)
    private String bookTime; // 진료받을시간 (선택한시간)
    private String bookDoctor; // 진료할 의사
    private String bookHistory; // 진료내역
    private int memberState; // 환자상태 ( 0:진료대기 1:진료중 2:진료완료 )
    private String hospitalAddr; // 병원주소
    private String hospitalName; // 병원이름
    private String doctorMajor; // 의사전공
    private int bookPrice; // 진료가격
    private String memberPhone; // 고객 핸드폰번호
    private String memberPhoto; // 회원 프로필사진
    private String memberAge;
    private String memberName;
    private String docName;

    public Book() {
        super();
    }

    public Book(int bookNo, int memberNo, String bookDate, String bookTime, String bookDoctor,
            String bookHistory, int memberState, String hospitalAddr, String hospitalName,
            String doctorMajor, int bookPrice, String memberPhone, String memberPhoto,
            String memberAge, String memberName, String docName) {
        super();
        this.bookNo = bookNo;
        this.memberNo = memberNo;
        this.bookDate = bookDate;
        this.bookTime = bookTime;
        this.bookDoctor = bookDoctor;
        this.bookHistory = bookHistory;
        this.memberState = memberState;
        this.hospitalAddr = hospitalAddr;
        this.hospitalName = hospitalName;
        this.doctorMajor = doctorMajor;
        this.bookPrice = bookPrice;
        this.memberPhone = memberPhone;
        this.memberPhoto = memberPhoto;
        this.memberAge = memberAge;
        this.memberName = memberName;
        this.docName = docName;
    }

    public int getBookNo() {
        return bookNo;
    }

    public void setBookNo(int bookNo) {
        this.bookNo = bookNo;
    }

    public int getMemberNo() {
        return memberNo;
    }

    public void setMemberNo(int memberNo) {
        this.memberNo = memberNo;
    }

    public String getBookDate() {
        return bookDate;
    }

    public void setBookDate(String bookDate) {
        this.bookDate = bookDate;
    }

    public String getBookTime() {
        return bookTime;
    }

    public void setBookTime(String bookTime) {
        this.bookTime = bookTime;
    }

    public String getBookDoctor() {
        return bookDoctor;
    }

    public void setBookDoctor(String bookDoctor) {
        this.bookDoctor = bookDoctor;
    }

    public String getBookHistory() {
        return bookHistory;
    }

    public void setBookHistory(String bookHistory) {
        this.bookHistory = bookHistory;
    }

    public int getMemberState() {
        return memberState;
    }

    public void setMemberState(int memberState) {
        this.memberState = memberState;
    }

    public String getHospitalAddr() {
        return hospitalAddr;
    }

    public void setHospitalAddr(String hospitalAddr) {
        this.hospitalAddr = hospitalAddr;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public String getDoctorMajor() {
        return doctorMajor;
    }

    public void setDoctorMajor(String doctorMajor) {
        this.doctorMajor = doctorMajor;
    }

    public int getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(int bookPrice) {
        this.bookPrice = bookPrice;
    }

    public String getMemberPhone() {
        return memberPhone;
    }

    public void setMemberPhone(String memberPhone) {
        this.memberPhone = memberPhone;
    }

    public String getMemberPhoto() {
        return memberPhoto;
    }

    public void setMemberPhoto(String memberPhoto) {
        this.memberPhoto = memberPhoto;
    }

    public String getMemberAge() {
        return memberAge;
    }

    public void setMemberAge(String memberAge) {
        this.memberAge = memberAge;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getDocName() {
        return docName;
    }

    public void setDocName(String docName) {
        this.docName = docName;
    }
}
