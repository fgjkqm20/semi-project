package nbd.member.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import nbd.member.model.service.MemberService;
import nbd.member.model.vo.Member;
import nbd.member.model.vo.MemberInfo;

/**
 * Servlet implementation class GetMyTotalInfoServlet
 */
@WebServlet(name = "getMyTotalInfo", urlPatterns = { "/getMyTotalInfo.do" })
public class GetMyTotalInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetMyTotalInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		HttpSession session = request.getSession();
		Member m = (Member)session.getAttribute("m");
		int memberGrade = m.getMemberGrade();
		int memberNo = m.getMemberNo();
		
		MemberService service = new MemberService();
		if(memberGrade==2) {
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/member/mypageDoctor.jsp");
			view.forward(request, response);
		}else if(memberGrade==3) {
			
			MemberInfo mi = service.getMemberPageTotal(memberNo);
			// 결과처리
			request.setCharacterEncoding("utf-8");
			PrintWriter out = response.getWriter();
			Gson gson = new Gson();
			gson.toJson(mi, out);
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
