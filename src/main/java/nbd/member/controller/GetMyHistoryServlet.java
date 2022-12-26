package nbd.member.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;
import nbd.member.model.service.MemberService;
import nbd.member.model.vo.Doctor;

/**
 * Servlet implementation class GetMyHistoryServlet
 */
@WebServlet(name = "getMyHistory", urlPatterns = {"/getMyHistory.do"})
public class GetMyHistoryServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetMyHistoryServlet() {
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
        String memberId = request.getParameter("memberId");

        // 비지니스 로직
        MemberService service = new MemberService();
        ArrayList<Doctor> rlist = service.getMyHistory(memberId);


        // 결과처리
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        new Gson().toJson(rlist, out);
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
