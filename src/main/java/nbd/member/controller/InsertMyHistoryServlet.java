package nbd.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nbd.member.model.service.MemberService;

/**
 * Servlet implementation class InsertMyHistoryServlet
 */
@WebServlet(name = "InsertMyHistory", urlPatterns = { "/insertMyHistory.do" })
public class InsertMyHistoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertMyHistoryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String year1= request.getParameter("year1");
		String year2= request.getParameter("year2");
		String doctorId = request.getParameter("doctorId");
		String doctorWork = request.getParameter("doctorWork");
		
		String year = year1+year2;
		
		
		// 비즈니스로직
		MemberService service = new MemberService();
		int result = service.insertMyHistory(doctorId, doctorWork, year);
		
		if(result>0) {
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/member/mypageDoctor.jsp");
			view.forward(request, response);
		}else {
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/member/mypageDoctor.jsp");
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
