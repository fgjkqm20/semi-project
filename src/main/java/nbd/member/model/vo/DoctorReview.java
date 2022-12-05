package nbd.member.model.vo;

public class DoctorReview {
	private int reviewNo;
	private String doctorId;
	private String doctorComment;
	private int bookNo;
	private String bookDate;
	private String memberId;
	private int starMark;
	
	public DoctorReview() {
		super();
		// TODO Auto-generated constructor stub
	}


	public DoctorReview(int reviewNo, String doctorId, String doctorComment, int bookNo, String memberId,
			int starMark) {
		super();
		this.reviewNo = reviewNo;
		this.doctorId = doctorId;
		this.doctorComment = doctorComment;
		this.bookNo = bookNo;
		this.memberId = memberId;
		this.starMark = starMark;
	}


	public int getReviewNo() {
		return reviewNo;
	}


	public void setReviewNo(int reviewNo) {
		this.reviewNo = reviewNo;
	}


	public String getDoctorId() {
		return doctorId;
	}


	public void setDoctorId(String doctorId) {
		this.doctorId = doctorId;
	}


	public String getDoctorComment() {
		return doctorComment;
	}


	public void setDoctorComment(String doctorComment) {
		this.doctorComment = doctorComment;
	}


	public int getBookNo() {
		return bookNo;
	}


	public void setBookNo(int bookNo) {
		this.bookNo = bookNo;
	}


	public String getMemberId() {
		return memberId;
	}


	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}


	public int getStarMark() {
		return starMark;
	}


	public void setStarMark(int starMark) {
		this.starMark = starMark;
	}


	public void setBookDate(String bookDate) {
		this.bookDate = bookDate;
	}
	
	public String getBookDate() {
		return bookDate;
	}
	
}
