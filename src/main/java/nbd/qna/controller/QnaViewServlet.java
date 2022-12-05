package nbd.qna.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nbd.qna.model.service.QnaService;
import nbd.qna.model.vo.Qna;
import nbd.qna.model.vo.QnaViewData;

/**
 * Servlet implementation class QnaViewServlet
 */
@WebServlet(name = "QnaView", urlPatterns = { "/qnaView.do" })
public class QnaViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QnaViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 인코딩
		request.setCharacterEncoding("utf-8");
		//2. 값추출
		int infoNo = Integer.parseInt(request.getParameter("InfoNo"));
		//3. 비즈니스로직
		QnaService service = new QnaService();
		QnaViewData qvd =service.selectOneQna(infoNo);
		//4. 화면처리(결과처리)
		//성공했을때 Qna q, 실패 null이 들어옴
		if(qvd == null) {
			//실패시 alert 띄워주기
		}else {
			//성공시
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/qna/boardViewComment.jsp");
			request.setAttribute("q", qvd.getQ());//2개를 되돌려줌
			request.setAttribute("commentList", qvd.getCommentList());
			view.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
