package nbd.member.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import nbd.member.model.service.MemberService;
import nbd.member.model.vo.Member;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(name = "Login", urlPatterns = {"/login.do"})
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
        String memberId = request.getParameter("memberId");
        String memberPw = request.getParameter("memberPw");

        // 3. 비즈니스 로직
        MemberService service = new MemberService();
        Member m = service.login(memberId, memberPw);

        // 4. 결과 처리
        RequestDispatcher view;

        if (m != null) {
            HttpSession session = request.getSession();
            session.setAttribute("m", m);
            view = request.getRequestDispatcher("/");
        } else {
            request.setAttribute("loginFail", "아이디 또는 비밀번호를 잘못입력하셨습니다. 입력한 내용을 다시 확인해주세요.");
            view = request.getRequestDispatcher("/WEB-INF/views/member/loginFrm.jsp");
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
