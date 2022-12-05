package nbd.counsel.model.vo;

public class CounselComment {
	private int commentNo;				// 댓글 번호
	private int commentWriterNo;		// 댓글 작성자 회원 번호
	private String commentWriterName;	// 댓글 작성자 이름
	private String commentContent;		// 댓글 내용
	private String commentDate;			// 댓글 작성일
	private int counselNo;				// 게시물 번호
	
	public CounselComment() {
		super();
	}
	public CounselComment(int commentNo, int commentWriterNo, String commentWriterName, String commentContent,
			String commentDate, int counselNo) {
		super();
		this.commentNo = commentNo;
		this.commentWriterNo = commentWriterNo;
		this.commentWriterName = commentWriterName;
		this.commentContent = commentContent;
		this.commentDate = commentDate;
		this.counselNo = counselNo;
	}
	
	public int getCommentNo() {
		return commentNo;
	}
	public void setCommentNo(int commentNo) {
		this.commentNo = commentNo;
	}
	public int getCommentWriterNo() {
		return commentWriterNo;
	}
	public void setCommentWriterNo(int commentWriterNo) {
		this.commentWriterNo = commentWriterNo;
	}
	public String getCommentWriterName() {
		return commentWriterName;
	}
	public void setCommentWriterName(String commentWriterName) {
		this.commentWriterName = commentWriterName;
	}
	public String getCommentContent() {
		return commentContent;
	}
	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}
	public String getCommentDate() {
		return commentDate;
	}
	public void setCommentDate(String commentDate) {
		this.commentDate = commentDate;
	}
	public int getCounselNo() {
		return counselNo;
	}
	public void setCounselNo(int counselNo) {
		this.counselNo = counselNo;
	}
}
