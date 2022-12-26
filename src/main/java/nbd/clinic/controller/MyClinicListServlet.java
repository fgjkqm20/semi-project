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
import nbd.clinic.model.vo.MyClinic;

/**
 * Servlet implementation class MyClinicListServlet
 */
@WebServlet(name = "myClinicList", urlPatterns = {"/myClinicList.do"})
public class MyClinicListServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyClinicListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        int memberNo = Integer.parseInt(request.getParameter("memberNo"));
        ClinicService service = new ClinicService();
        ArrayList<MyClinic> rlist = service.getMyAllReserve(memberNo);

        if (rlist.size() == 0) {
            // 실패 얼럿
        } else {
            request.setAttribute("rlist", rlist);
            RequestDispatcher view =
                    request.getRequestDispatcher("/WEB-INF/views/clinic/myClinicList.jsp");
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
