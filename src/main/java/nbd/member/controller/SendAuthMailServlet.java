package nbd.member.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.simple.JSONObject;
import nbd.member.model.service.MemberService;
import nbd.member.model.vo.Member;

/**
 * Servlet implementation class SendAuthMailServlet
 */
@WebServlet(name = "SendAuthMail", urlPatterns = {"/sendAuthMail.do"})
public class SendAuthMailServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SendAuthMailServlet() {
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
        String email = request.getParameter("email");
        // 3. 비즈니스 로직
        MemberService service = new MemberService();
        Member m = service.checkEmail(email);

        // 4. 결과 처리
        JSONObject data = new JSONObject();
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        if (m == null) {
            data.put("notMember", "nearbyDoctor에 가입된 이메일이 아닙니다.");
        } else {
            AuthMailSender sender = new AuthMailSender();
            String authCode = sender.sendAuthMail(email);

            if (authCode == null) {
                data.put("failSend", "인증번호를 발송할 수 없습니다.");
            } else {
                data.put("memberId", m.getMemberId());
                data.put("enrollDate", m.getEnrollDate());
                data.put("authCode", authCode);
            }
        }
        out.print(data);
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
