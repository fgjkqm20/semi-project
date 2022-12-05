package nbd.counsel.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import nbd.counsel.model.service.CounselService;
import nbd.counsel.model.vo.Counsel;
import nbd.member.model.vo.Member;

/**
 * Servlet implementation class GetmyQServlet
 */
@WebServlet(name = "GetMyQuestion", urlPatterns = { "/getMyQuestion.do" })
public class GetMyQuestionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetMyQuestionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 인코딩
		request.setCharacterEncoding("utf-8");
		
		// 값추출
		
		String startIndex = request.getParameter("startIndex");
		String endIndex = request.getParameter("endIndex");

		int startNum = Integer.parseInt(startIndex);
		int endNum = Integer.parseInt(endIndex);
		
		String memberId = request.getParameter("memberId");
		
		// 비즈니스로직
		CounselService service = new CounselService();
		ArrayList<Counsel> clist = service.getMyQuestion(memberId, startNum, endNum);
		// 결과처리
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		new Gson().toJson(clist, out);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
