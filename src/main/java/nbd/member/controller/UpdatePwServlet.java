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
 * Servlet implementation class UpdatePwServlet
 */
@WebServlet(name = "updatePw", urlPatterns = { "/updatePw.do" })
public class UpdatePwServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdatePwServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// update member_tbl set member_pw=? where member_no=?;
		request.setCharacterEncoding("utf-8");
		String newPw = request.getParameter("newPw");
		String memberGrade = request.getParameter("memberGrade");
		int memberNo = Integer.parseInt(request.getParameter("memberNo"));
		
		MemberService service = new MemberService();
		int result = service.updateMemberPw(newPw, memberNo);
		
		if(result > 0) {
			if(memberGrade.equals("2")) { // 의사
				RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/member/mypageUpdate2.jsp");
				view.forward(request, response);
			} else if(memberGrade.equals("3")) { // 환자
				RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/member/mypageUpdate.jsp");
				view.forward(request, response);
			}
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

