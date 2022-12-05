package nbd.clinic.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import nbd.clinic.model.service.BookService;
import nbd.clinic.model.vo.Book;
import nbd.member.model.vo.Member;

/**
 * Servlet implementation class ChangeStatusServlet
 */
@WebServlet(name = "changeStatus", urlPatterns = { "/changeStatus.do" })
public class ChangeStatusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangeStatusServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.인코딩
		request.setCharacterEncoding("utf-8");
		//2.값추출
		int bookNo = Integer.parseInt(request.getParameter("bookNo"));
		int stateNo = Integer.parseInt(request.getParameter("pstatus"));
		HttpSession session = request.getSession();
		Member m = (Member)session.getAttribute("m");
		String memberId = m.getMemberId();
		Book b = new Book();
		b.setBookNo(bookNo);
		b.setMemberState(stateNo);
		//3.비즈니스 로직
		BookService service= new BookService();
		int result = service.changeStatus(b);
		//4.결과처리
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/Dmsg.jsp");
		if(result>0) {
			b.setMemberNo(bookNo);
			b.setMemberState(stateNo);
			request.setAttribute("title", "업데이트 성공");
			request.setAttribute("msg", "환자 현황 업데이트 완료.");
			request.setAttribute("icon", "success");
			request.setAttribute("loc", "/treatmentRoom3.do?memberId="+memberId);
		}else {
			request.setAttribute("title", "정보변경 실패");
			request.setAttribute("msg", "잘못입력하셨습니다");
			request.setAttribute("icon","error");
			request.setAttribute("loc", "/treatmentRoom3.do?memberId="+memberId);
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
