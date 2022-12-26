package nbd.member.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import nbd.member.model.service.MemberService;
import nbd.member.model.vo.AdminInfo;

/**
 * Servlet implementation class MypageServlet
 */
@WebServlet(name = "Mypage", urlPatterns = {"/mypage.do"})
public class MypageServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public MypageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 인코딩
        request.setCharacterEncoding("utf-8");

        int memberGrade = Integer.parseInt(request.getParameter("memberGrade"));
        MemberService service = new MemberService();

        // 멤버등급에 따라 다르게 이동 일반회원3 / 의사2 / 환자1
        if (memberGrade == 1) {
            AdminInfo ai = service.getAdminInfo();
            request.setAttribute("ai", ai);
            RequestDispatcher view =
                    request.getRequestDispatcher("/WEB-INF/views/member/mypageAdmin.jsp");
            view.forward(request, response);

        } else if (memberGrade == 2) {
            RequestDispatcher view =
                    request.getRequestDispatcher("/WEB-INF/views/member/mypageDoctor.jsp");
            view.forward(request, response);
        } else {
            RequestDispatcher view =
                    request.getRequestDispatcher("/WEB-INF/views/member/mypagePatient.jsp");
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
