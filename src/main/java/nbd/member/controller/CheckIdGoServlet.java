package nbd.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nbd.member.model.service.MemberService;
import nbd.member.model.vo.Member;

/**
 * Servlet implementation class CheckIdGoServlet
 */
@WebServlet(name="/CheckIdGoServlet", urlPatterns = {"/checkIdGo.do"})
public class CheckIdGoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckIdGoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		String memberId = request.getParameter("checkId");
		
		MemberService service = new MemberService();
		Member member = service.selectOneMember(memberId);
		
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/member/checkId.jsp");
		request.setAttribute("memberId", memberId);
		if(member != null) {
			request.setAttribute("result", false);
		}else {
			request.setAttribute("result", true);
		}
		
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


















