package nbd.counsel.model.vo;

public class CounselViewData {
	private Counsel c;
	private CounselComment comment;
	
	public CounselViewData() {
		super();
	}
	public CounselViewData(Counsel c, CounselComment comment) {
		super();
		this.c = c;
		this.comment = comment;
	}
	
	public Counsel getC() {
		return c;
	}
	public void setC(Counsel c) {
		this.c = c;
	}
	public CounselComment getCommentList() {
		return comment;
	}
	public void setCommentList(CounselComment comment) {
		this.comment = comment;
	}
}
