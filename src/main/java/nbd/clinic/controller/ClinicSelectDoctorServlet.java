package nbd.clinic.controller;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import nbd.clinic.model.service.ClinicService;
import nbd.member.model.vo.Doctor;

/**
 * Servlet implementation class ClinicSelectDoctorServlet
 */
@WebServlet(name = "ClinicSelectDoctor", urlPatterns = {"/clinicSelectDoctor.do"})
public class ClinicSelectDoctorServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClinicSelectDoctorServlet() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 1.

        // 2.값추출
        String doctorMajor = request.getParameter("doctorMajor");
        // 3.비즈니스로직
        ClinicService service = new ClinicService();
        ArrayList<Doctor> list = service.selectAllDoctor(doctorMajor);
        // 4.결과처리

        RequestDispatcher view =
                request.getRequestDispatcher("/WEB-INF/views/clinic/clinicSelectDoctor.jsp");
        if (!list.isEmpty()) {
            request.setAttribute("list", list);
        }
        view.forward(request, response);

    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}
