package nbd.member.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import nbd.member.model.service.MemberService;

/**
 * Servlet implementation class ChangePwServlet
 */
@WebServlet(name = "ChangePw", urlPatterns = {"/changePw.do"})
public class ChangePwServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangePwServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 1. 인코딩
        request.setCharacterEncoding("utf-8");

        // 2. 값 추출
        String id = request.getParameter("id");
        String pw = request.getParameter("pw");

        // 3. 비즈니스 로직
        MemberService service = new MemberService();
        int result = service.changePw(id, pw);

        // 4. 결과 처리
        RequestDispatcher view;
        if (result > 0) {
            view = request.getRequestDispatcher("/WEB-INF/views/member/loginFrm.jsp");
        } else {
            request.setAttribute("fail", "비밀번호를 변경할 수 없습니다.");
            view = request
                    .getRequestDispatcher("/WEB-INF/views/member/changePwFrm.jsp?memberId=" + id);
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
