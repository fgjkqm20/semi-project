package nbd.qna.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nbd.qna.model.service.QnaService;
import nbd.qna.model.vo.QnaComment;

/**
 * Servlet implementation class QnaUpdateCommentServlet
 */
@WebServlet(name = "QnaUpdateComment", urlPatterns = { "/qnaUpdateComment.do" })
public class QnaUpdateCommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QnaUpdateCommentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.인코딩
		request.setCharacterEncoding("utf-8");
		//2.값추출
		int commentNo = Integer.parseInt(request.getParameter("commentNo"));
		int infoNo = Integer.parseInt(request.getParameter("InfoNo"));
		String qcContent = request.getParameter("qcContent");
		QnaComment qc = new QnaComment();
		qc.setCommentNo(commentNo);
		qc.setCommentContent(qcContent);
		//3.비즈니스로직
		QnaService service = new QnaService();
		int result = service.updateQnaComment(qc);
		//4.화면처리
		   RequestDispatcher view = request.getRequestDispatcher("/qnaView.do?InfoNo="+infoNo);
		      view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
