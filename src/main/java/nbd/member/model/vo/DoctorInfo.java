package nbd.member.model.vo;

public class DoctorInfo {
	private double doctorStar;
	private int clinicCount;
	private int totalReview;
	private int totalAnswer;
	
	
	public int getTotalReview() {
		return totalReview;
	}
	public void setTotalReview(int totalReview) {
		this.totalReview = totalReview;
	}
	public int getTotalAnswer() {
		return totalAnswer;
	}
	public void setTotalAnswer(int totalAnswer) {
		this.totalAnswer = totalAnswer;
	}
	public void setDoctorStar(double doctorStar) {
		this.doctorStar = doctorStar;
	}
	public DoctorInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DoctorInfo(double doctorStar, int clinicCount, int totalReview, int totalAnswer) {
		super();
		this.doctorStar = doctorStar;
		this.clinicCount = clinicCount;
		this.totalReview = totalReview;
		this.totalAnswer = totalAnswer;
	}
	public double getDoctorStar() {
		return doctorStar;
	}
	public void setDoctorStar(int doctorStar) {
		this.doctorStar = doctorStar;
	}
	public int getClinicCount() {
		return clinicCount;
	}
	public void setClinicCount(int clinicCount) {
		this.clinicCount = clinicCount;
	}

}
