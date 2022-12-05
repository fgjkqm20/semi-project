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
import nbd.qna.model.vo.QnaPageData;

/**
 * Servlet implementation class QnaListServlet
 */
@WebServlet(name = "QnaList", urlPatterns = { "/qnaList.do" })
public class QnaListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QnaListServlet() {
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
		int reqPage = Integer.parseInt(request.getParameter("reqPage"));
		//3.비즈니스로직
		QnaService service = new QnaService();
		QnaPageData qpd = service.selectQnaList(reqPage);
		
		//4.결과처리
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/qna/qnaboardlist.jsp");
		request.setAttribute("list", qpd.getList());
		request.setAttribute("pageNavi", qpd.getPageNavi());
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
