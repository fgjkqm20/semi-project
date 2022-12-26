package nbd.clinic.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;
import nbd.clinic.model.service.ClinicService;
import nbd.clinic.model.vo.MyClinic;

/**
 * Servlet implementation class GetMyBookServlet
 */
@WebServlet(name = "getMyBook", urlPatterns = {"/getMyBook.do"})
public class GetMyBookServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetMyBookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // select book_no, hospital_name, doctor_major, book_date, member_state from book_tbl join
        // doctor_tbl on (doctor_no=BOOK_DOCTOR) where member_no=117 order by book_no desc;
        // 인코딩
        request.setCharacterEncoding("utf-8");
        // 값추출
        int startNum = Integer.parseInt(request.getParameter("startIndex"));
        int endNum = Integer.parseInt(request.getParameter("endIndex"));
        int memberNo = Integer.parseInt(request.getParameter("memberNo"));

        // 비지니스로직
        ClinicService service = new ClinicService();
        ArrayList<MyClinic> rlist = service.getMyReserve(memberNo, startNum, endNum);

        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        new Gson().toJson(rlist, out);

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
