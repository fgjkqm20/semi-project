package nbd.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import nbd.clinic.model.vo.MyClinic;
import nbd.member.model.service.MemberService;
import nbd.member.model.vo.Member;

/**
 * Servlet implementation class InsertDoctorReviewServlet
 */
@WebServlet(name = "insertDoctorReview", urlPatterns = { "/insertDoctorReview.do" })
public class InsertDoctorReviewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertDoctorReviewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
        request.setCharacterEncoding("utf-8");
        
        int star = Integer.parseInt(request.getParameter("star"));
        int memberNo = Integer.parseInt(request.getParameter("memberNo"));
        int bookNo = Integer.parseInt(request.getParameter("bookNo"));
        String doctorId = request.getParameter("doctorId");
        String review = request.getParameter("review");
        
        MemberService service = new MemberService();
        int result = service.insertDoctorReview(doctorId, review, bookNo, memberNo, star);
        
        
        if(result>0) {
				RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/jMsg.jsp");
				request.setAttribute("title", "리뷰가 등록되었습니다.");
				request.setAttribute("loc", "/mypage.do?memberGrade=3");
				view.forward(request, response);	
		}else {
				RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/jMsg.jsp");
				request.setAttribute("title", "리뷰 등록에 실패하였습니다.");
				request.setAttribute("loc", "/mypage.do?memberGrade=3");
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
