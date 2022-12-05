package nbd.member.model.vo;

public class MemberInfo {
	
	private int totalBook;
	private int totalQuestion;
	public MemberInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MemberInfo(int totalBook, int totalQuestion) {
		super();
		this.totalBook = totalBook;
		this.totalQuestion = totalQuestion;
	}
	public int getTotalBook() {
		return totalBook;
	}
	public void setTotalBook(int totalBook) {
		this.totalBook = totalBook;
	}
	public int getTotalQuestion() {
		return totalQuestion;
	}
	public void setTotalQuestion(int totalQuestion) {
		this.totalQuestion = totalQuestion;
	}
	
	
}
