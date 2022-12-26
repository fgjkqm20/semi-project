package nbd.member.controller;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import nbd.member.model.service.MemberService;
import nbd.member.model.vo.Member;

/**
 * Servlet implementation class AdminSearhGradeServlet
 */
@WebServlet(name = "AdminSearhGrade", urlPatterns = {"/BsearchMember.do"})
public class AdminSearhGradeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminSearhGradeServlet() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 1.인코딩
        request.setCharacterEncoding("utf-8");
        // 2.값추출
        int memberGrade = Integer.parseInt(request.getParameter("memberGrade"));
        // 3.비즈니스 로직
        MemberService service = new MemberService();
        ArrayList<Member> list = service.BDselectSearchMember(memberGrade);
        // 4.결과처리
        request.setAttribute("list", list);
        RequestDispatcher view =
                request.getRequestDispatcher("/WEB-INF/views/member/mypageAdminUpdateMember.jsp");
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
