package nbd.clinic.model.vo;

public class MyClinic {
	private int	bookNo;
	private String hospitalName;
	private String doctorMajor;
	private String bookDate;
	private int pharmNo;
	private String bookHistory;
	private int bookPrice;
	private int memberState;
	private int memberNo;
	private String doctorName;
	private String pharmTitle;
	private String pharmAddr;
	private String pharmPhone;
	private String doctorId;

	public String getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(String doctorId) {
		this.doctorId = doctorId;
	}



	public int getMemberNo() {
		return memberNo;
	}



	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}



	public MyClinic(int bookNo, String hospitalName, String doctorMajor, String bookDate, int pharmNo,
			String bookHistory, int bookPrice, int memberState, int memberNo, String doctorName, String pharmTitle,
			String pharmAddr, String pharmPhone) {
		super();
		this.bookNo = bookNo;
		this.hospitalName = hospitalName;
		this.doctorMajor = doctorMajor;
		this.bookDate = bookDate;
		this.pharmNo = pharmNo;
		this.bookHistory = bookHistory;
		this.bookPrice = bookPrice;
		this.memberState = memberState;
		this.memberNo = memberNo;
		this.doctorName = doctorName;
		this.pharmTitle = pharmTitle;
		this.pharmAddr = pharmAddr;
		this.pharmPhone = pharmPhone;
	}



	public MyClinic() {
		super();
		// TODO Auto-generated constructor stub
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

	public String getPharmPhone() {
		return pharmPhone;
	}

	public void setPharmPhone(String pharmPhone) {
		this.pharmPhone = pharmPhone;
	}

	public int getBookNo() {
		return bookNo;
	}
	public void setBookNo(int bookNo) {
		this.bookNo = bookNo;
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
	public String getBookDate() {
		return bookDate;
	}
	public void setBookDate(String bookDate) {
		this.bookDate = bookDate;
	}
	public int getPharmNo() {
		return pharmNo;
	}
	public void setPharmNo(int pharmNo) {
		this.pharmNo = pharmNo;
	}
	public String getBookHistory() {
		return bookHistory;
	}
	public void setBookHistory(String bookHistory) {
		this.bookHistory = bookHistory;
	}
	public int getBookPrice() {
		return bookPrice;
	}
	public void setBookPrice(int bookPrice) {
		this.bookPrice = bookPrice;
	}
	public int getMemberState() {
		return memberState;
	}
	public void setMemberState(int memberState) {
		this.memberState = memberState;
	}
	public String getDoctorName() {
		return doctorName;
	}
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	
	
}
