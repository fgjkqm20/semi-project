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
import nbd.member.model.vo.DoctorReview;

/**
 * Servlet implementation class GetMyReviewServlet
 */
@WebServlet(name = "getMyReview", urlPatterns = {"/getMyReview.do"})
public class GetMyReviewServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetMyReviewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        // 값추출
        String memberId = request.getParameter("memberId");
        int startNum = Integer.parseInt(request.getParameter("startIndex"));
        int endNum = Integer.parseInt(request.getParameter("endIndex"));

        // 비지니스 로직
        MemberService service = new MemberService();
        ArrayList<DoctorReview> rlist = service.getMyReview(memberId, startNum, endNum);


        // 결과처리
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
