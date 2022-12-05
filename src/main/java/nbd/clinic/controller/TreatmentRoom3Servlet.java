package nbd.clinic.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nbd.clinic.model.service.BookService;
import nbd.clinic.model.vo.Book;

/**
 * Servlet implementation class TreatmentRoom3Servlet
 */
@WebServlet(name = "TreatmentRoom3", urlPatterns = { "/treatmentRoom3.do" })
public class TreatmentRoom3Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TreatmentRoom3Servlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1.인코딩
		request.setCharacterEncoding("utf-8");
		// 2.값추출
		// 3.비즈니스로직
		String memberId = request.getParameter("memberId");
		System.out.println(memberId);
		BookService bookPatient = new BookService();
		ArrayList<Book> list = bookPatient.selectAllPatient();

		// 4.결과처리
		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/views/clinic/treatmentRoom.jsp");
		request.setAttribute("list", list);
		request.setAttribute("memberId", memberId);
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
