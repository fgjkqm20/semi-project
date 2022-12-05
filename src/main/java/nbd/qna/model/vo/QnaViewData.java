package nbd.qna.model.vo;

import java.util.ArrayList;

public class QnaViewData {
	private Qna q;
	private ArrayList<QnaComment> commentList;
	
	public QnaViewData() {
		super();
		// TODO Auto-generated constructor stub
	}

	public QnaViewData(Qna q, ArrayList<QnaComment> commentList) {
		super();
		this.q = q;
		this.commentList = commentList;
	}

	public Qna getQ() {
		return q;
	}

	public void setQ(Qna q) {
		this.q = q;
	}

	public ArrayList<QnaComment> getCommentList() {
		return commentList;
	}

	public void setCommentList(ArrayList<QnaComment> commentList) {
		this.commentList = commentList;
	}
	
	
}
