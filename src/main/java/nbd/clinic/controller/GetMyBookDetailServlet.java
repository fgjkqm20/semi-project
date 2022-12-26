package nbd.clinic.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import nbd.clinic.model.service.ClinicService;
import nbd.clinic.model.vo.MyClinic;

/**
 * Servlet implementation class GetMyBookDetailServlet
 */
@WebServlet(name = "getMyBookDetail", urlPatterns = {"/getMyBookDetail.do"})
public class GetMyBookDetailServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetMyBookDetailServlet() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        // 값추출
        int bookNo = Integer.parseInt(request.getParameter("bookNo"));
        ClinicService service = new ClinicService();
        MyClinic mc = service.getMyClinicDetail(bookNo);
        int reviewResult = service.getReviewResult(bookNo);
        request.setAttribute("mc", mc);
        request.setAttribute("reviewResult", reviewResult);
        RequestDispatcher view =
                request.getRequestDispatcher("/WEB-INF/views/member/mypageDetail.jsp");
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
