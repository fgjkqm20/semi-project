package nbd.member.model.vo;

public class Doctor {
    private int doctorNo; // 의사의 회원번호
    private String doctorId; // 의사의 아이디
    private String doctorMajor; // 의사 전공
    private int doctorAvgStar; // 의사가 받은 평균 평점
    private String hospitalName; // 의사가 근무하는 병원 이름
    private String hospitalAddr; // 의사가 근무하는 병원 주소
    private String doctorName;
    private String doctorPhoto;
    private String doctorWork;
    private String doctorDate;
    private String historyStartYear;
    private String historyEndYear;

    public Doctor() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Doctor(int doctorNo, String doctorId, String doctorMajor, int doctorAvgStar,
            String hospitalName, String hospitalAddr, String doctorName, String doctorPhoto,
            String doctorWork, String doctorDate, String historyStartYear, String historyEndYear) {
        super();
        this.doctorNo = doctorNo;
        this.doctorId = doctorId;
        this.doctorMajor = doctorMajor;
        this.doctorAvgStar = doctorAvgStar;
        this.hospitalName = hospitalName;
        this.hospitalAddr = hospitalAddr;
        this.doctorName = doctorName;
        this.doctorPhoto = doctorPhoto;
        this.doctorWork = doctorWork;
        this.doctorDate = doctorDate;
        this.historyStartYear = historyStartYear;
        this.historyEndYear = historyEndYear;
    }

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

    public String getDoctorMajor() {
        return doctorMajor;
    }

    public void setDoctorMajor(String doctorMajor) {
        this.doctorMajor = doctorMajor;
    }

    public int getDoctorAvgStar() {
        return doctorAvgStar;
    }

    public void setDoctorAvgStar(int doctorAvgStar) {
        this.doctorAvgStar = doctorAvgStar;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public String getHospitalAddr() {
        return hospitalAddr;
    }

    public void setHospitalAddr(String hospitalAddr) {
        this.hospitalAddr = hospitalAddr;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getDoctorPhoto() {
        return doctorPhoto;
    }

    public void setDoctorPhoto(String doctorPhoto) {
        this.doctorPhoto = doctorPhoto;
    }

    public String getDoctorWork() {
        return doctorWork;
    }

    public void setDoctorWork(String doctorWork) {
        this.doctorWork = doctorWork;
    }

    public String getDoctorDate() {
        return doctorDate;
    }

    public void setDoctorDate(String doctorDate) {
        this.doctorDate = doctorDate;
    }

    public String getHistoryStartYear() {
        return historyStartYear;
    }

    public void setHistoryStartYear(String historyStartYear) {
        this.historyStartYear = historyStartYear;
    }

    public String getHistoryEndYear() {
        return historyEndYear;
    }

    public void setHistoryEndYear(String historyEndYear) {
        this.historyEndYear = historyEndYear;
    }


}
