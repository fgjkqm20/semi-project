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

/**
 * Servlet implementation class PrescriptionGoServlet
 */
@WebServlet(name = "PrescriptionGoServlet", urlPatterns = {"/prescriptionGo.do"})
public class PrescriptionGoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public PrescriptionGoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");

        int bookNo = Integer.parseInt(request.getParameter("bookNo"));

        ClinicService service = new ClinicService();
        Book book = service.reservationView(bookNo);

        RequestDispatcher view = request
                .getRequestDispatcher("/WEB-INF/views/clinic/PracticePatternPrescriptionO.jsp");

        if (book != null) {
            request.setAttribute("book", book);
            view.forward(request, response);
        }

    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}
