package nbd.member.model.vo;

public class AdminInfo {
	private double totalWrite;
	private double totalMember;
	private double totalDoctor;
	private double totalReservation;
	private int todayWrite;
	private int todayMember;
	private int todayDoctor;
	private int todayReservation;
	public AdminInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public AdminInfo(double totalWrite, double totalMember, double totalDoctor, double totalReservation, int todayWrite,
			int todayMember, int todayDoctor, int todayReservation) {
		super();
		this.totalWrite = totalWrite;
		this.totalMember = totalMember;
		this.totalDoctor = totalDoctor;
		this.totalReservation = totalReservation;
		this.todayWrite = todayWrite;
		this.todayMember = todayMember;
		this.todayDoctor = todayDoctor;
		this.todayReservation = todayReservation;
	}
	public double getTotalWrite() {
		return totalWrite;
	}
	public void setTotalWrite(double totalWrite) {
		this.totalWrite = totalWrite;
	}
	public double getTotalMember() {
		return totalMember;
	}
	public void setTotalMember(double totalMember) {
		this.totalMember = totalMember;
	}
	public double getTotalDoctor() {
		return totalDoctor;
	}
	public void setTotalDoctor(double totalDoctor) {
		this.totalDoctor = totalDoctor;
	}
	public double getTotalReservation() {
		return totalReservation;
	}
	public void setTotalReservation(double totalReservation) {
		this.totalReservation = totalReservation;
	}
	public int getTodayWrite() {
		return todayWrite;
	}
	public void setTodayWrite(int todayWrite) {
		this.todayWrite = todayWrite;
	}
	public int getTodayMember() {
		return todayMember;
	}
	public void setTodayMember(int todayMember) {
		this.todayMember = todayMember;
	}
	public int getTodayDoctor() {
		return todayDoctor;
	}
	public void setTodayDoctor(int todayDoctor) {
		this.todayDoctor = todayDoctor;
	}
	public int getTodayReservation() {
		return todayReservation;
	}
	public void setTodayReservation(int todayReservation) {
		this.todayReservation = todayReservation;
	}
	
}
