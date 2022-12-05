package nbd.clinic.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nbd.clinic.model.service.ClinicService;
import nbd.clinic.model.vo.Book;
import nbd.member.model.vo.Doctor;

/**
 * Servlet implementation class PrescriptionOServlet
 */
@WebServlet(name = "PrescriptionO", urlPatterns = { "/prescriptionO.do" })
public class PrescriptionOServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PrescriptionOServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1. 인코딩
	      request.setCharacterEncoding("utf-8");
	      // 2. 값추출
	      int memberNo = Integer.parseInt(request.getParameter("memberNo"));
	      String doctorid = request.getParameter("doctorid");
	      String hospitalAddr = request.getParameter("hospitalAddr");
	      String hospitalName = request.getParameter("hospitalName");
	      String docMajor = request.getParameter("docMajor");
	      String selectDay = request.getParameter("selectDay");
	      String selectTime = request.getParameter("select-time");
	      String sympData = request.getParameter("symptom-data");
	      
	      Book book = new Book();
	      book.setMemberNo(memberNo);
	      book.setBookDoctor(doctorid);
	      book.setHospitalAddr(hospitalAddr);
	      book.setHospitalName(hospitalName);
	      book.setDoctorMajor(docMajor);
	      book.setBookDate(selectDay);
	      book.setBookTime(selectTime);
	      book.setBookHistory(sympData);
	      
	      ClinicService service = new ClinicService();
	      int result = service.insertReserve(book);
	      
	      RequestDispatcher view;
	      
	      if(result > 0) {
	    	  view = request.getRequestDispatcher("/WEB-INF/views/clinic/PracticePatternPrescriptionO.jsp");
	    	  request.setAttribute("book", book);
	    	  view.forward(request, response);
	      }else {
	    	  view = request.getRequestDispatcher("/");
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
