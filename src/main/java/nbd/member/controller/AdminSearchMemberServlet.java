package nbd.member.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nbd.member.model.service.MemberService;
import nbd.member.model.vo.Member;

/**
 * Servlet implementation class AdminSearchMemberServlet
 */
@WebServlet(name = "AdminSearchMember", urlPatterns = { "/AsearchMember.do" })
public class AdminSearchMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminSearchMemberServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String memberId = request.getParameter("memberId");
		MemberService service = new MemberService();
		ArrayList<Member> list =service.ADselectSearchMember(memberId);
		
		
		request.setAttribute("list", list);
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/member/mypageAdminUpdateMember.jsp");
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
