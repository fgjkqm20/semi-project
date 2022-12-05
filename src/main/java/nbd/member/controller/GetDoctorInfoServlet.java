package nbd.member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import nbd.member.model.service.MemberService;
import nbd.member.model.vo.DoctorInfo;


/**
 * Servlet implementation class GetDoctorInfoServlet
 */
@WebServlet(name = "getDoctorInfo", urlPatterns = { "/getDoctorInfo.do" })
public class GetDoctorInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetDoctorInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String memberId = request.getParameter("memberId");
		int memberNo = Integer.parseInt(request.getParameter("memberNo"));
		MemberService service = new MemberService();
		DoctorInfo di = service.getDoctorInfo(memberId, memberNo);
		
		// 결과처리
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		Gson gson = new Gson();
		gson.toJson(di, out);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
