package nbd.member.model.vo;

public class Member {
	private int memberNo;			// 회원번호
	private String memberId;		// 아이디
	private String memberPw;		// 비밀번호
	private String memberName;		// 이름
	private String memberBirth;		// 생년월일
	private String memberPhone;		// 전화번호
	private String memberAddr;		// 주소
	private String memberEmail;		// 이메일
	private int memberGrade;				// 회원등급 ( 1관리자 2의사 3정회원)
	private String major;
	private String enrollDate;		// 가입일
	private int memberWarning;		// 경고횟수 ( 1경고 2탈퇴 )
	private String memberPhoto;		// 프로필사진
	private String doctorFilePath;
	private String hospitalName;
	private String hospitalAddr;
	
	public Member() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Member(int memberNo, String memberId, String memberPw, String memberName, String memberBirth,
			String memberPhone, String memberAddr, String memberEmail, int memberGrade, String major, String enrollDate,
			int memberWarning, String memberPhoto, String doctorFilePath, String hospitalName, String hospitalAddr) {
		super();
		this.memberNo = memberNo;
		this.memberId = memberId;
		this.memberPw = memberPw;
		this.memberName = memberName;
		this.memberBirth = memberBirth;
		this.memberPhone = memberPhone;
		this.memberAddr = memberAddr;
		this.memberEmail = memberEmail;
		this.memberGrade = memberGrade;
		this.major = major;
		this.enrollDate = enrollDate;
		this.memberWarning = memberWarning;
		this.memberPhoto = memberPhoto;
		this.doctorFilePath = doctorFilePath;
		this.hospitalName = hospitalName;
		this.hospitalAddr = hospitalAddr;
	}

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

	public String getMemberPw() {
		return memberPw;
	}

	public void setMemberPw(String memberPw) {
		this.memberPw = memberPw;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getMemberBirth() {
		return memberBirth;
	}

	public void setMemberBirth(String memberBirth) {
		this.memberBirth = memberBirth;
	}

	public String getMemberPhone() {
		return memberPhone;
	}

	public void setMemberPhone(String memberPhone) {
		this.memberPhone = memberPhone;
	}

	public String getMemberAddr() {
		return memberAddr;
	}

	public void setMemberAddr(String memberAddr) {
		this.memberAddr = memberAddr;
	}

	public String getMemberEmail() {
		return memberEmail;
	}

	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}

	public int getMemberGrade() {
		return memberGrade;
	}

	public void setMemberGrade(int memberGrade) {
		this.memberGrade = memberGrade;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getEnrollDate() {
		return enrollDate;
	}

	public void setEnrollDate(String enrollDate) {
		this.enrollDate = enrollDate;
	}

	public int getMemberWarning() {
		return memberWarning;
	}

	public void setMemberWarning(int memberWarning) {
		this.memberWarning = memberWarning;
	}

	public String getMemberPhoto() {
		return memberPhoto;
	}

	public void setMemberPhoto(String memberPhoto) {
		this.memberPhoto = memberPhoto;
	}

	public String getDoctorFilePath() {
		return doctorFilePath;
	}

	public void setDoctorFilePath(String doctorFilePath) {
		this.doctorFilePath = doctorFilePath;
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

	
}
