package nbd.clinic.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import nbd.clinic.model.service.ClinicService;
import nbd.member.model.vo.Doctor;

/**
 * Servlet implementation class ReservationServlet
 */
@WebServlet(name = "ReservationDetail", urlPatterns = {"/reservationDetail.do"})
public class ReservationServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReservationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 1.인코딩

        // 2.값추출
        int doctorNo = Integer.parseInt(request.getParameter("doctorNo"));
        // 3.비즈니스로직
        ClinicService service = new ClinicService();
        Doctor doctor = service.selectOneDoctor(doctorNo);
        // 4.결과처리
        RequestDispatcher view =
                request.getRequestDispatcher("/WEB-INF/views/clinic/reservationDetail.jsp");
        if (doctor != null) {
            request.setAttribute("doctor", doctor);
        }
        view.forward(request, response);

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
