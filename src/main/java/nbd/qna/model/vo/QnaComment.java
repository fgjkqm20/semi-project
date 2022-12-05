package nbd.qna.model.vo;

public class QnaComment {
	private String memberId;		// 아이디(작성자)
	private int infoNo;				// 글번호 (어떤공지사항의 댓글인지)
	private int commentNo;			// 댓글번호
	private String commentContent;	// 댓글내용
	private String commentDate;		// 댓글작성일
	
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public int getInfoNo() {
		return infoNo;
	}
	public void setInfoNo(int infoNo) {
		this.infoNo = infoNo;
	}
	public int getCommentNo() {
		return commentNo;
	}
	public void setCommentNo(int commentNo) {
		this.commentNo = commentNo;
	}
	public String getCommentContent() {
		return commentContent;
	}
	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}
	
	public String getQnaCommentContentBr() { //comment textarea에 엔터칠 수 있게 
		return commentContent.replace("\r\n", "<br>");
	}
	
	public String getCommentDate() {
		return commentDate;
	}
	public void setCommentDate(String commentDate) {
		this.commentDate = commentDate;
	}
	public QnaComment( String memberId, int infoNo, int commentNo, String commentContent,
			String commentDate) {
		super();

		this.memberId = memberId;
		this.infoNo = infoNo;
		this.commentNo = commentNo;
		this.commentContent = commentContent;
		this.commentDate = commentDate;
	}
	public QnaComment() {
		super();
		// TODO Auto-generated constructor stub
	}
}
