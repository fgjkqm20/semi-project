package nbd.qna.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nbd.qna.model.service.QnaService;
import nbd.qna.model.vo.Qna;

/**
 * Servlet implementation class QnaUpdateFrmServlet
 */
@WebServlet(name = "QnaUpdateFrm", urlPatterns = { "/qnaUpdateFrm.do" })
public class QnaUpdateFrmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QnaUpdateFrmServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */ 
    //qna 수정
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 인코딩
		request.setCharacterEncoding("utf-8");
		//2.값추출
		int infoNo = Integer.parseInt(request.getParameter("InfoNo"));
		//3.비즈니스로직
		QnaService service = new QnaService();
		Qna q = service.getQna(infoNo);
		//4.결과처리
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/qna/updateBoardFrm.jsp");
		request.setAttribute("q", q);
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
