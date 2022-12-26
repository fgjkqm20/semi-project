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
 * Servlet implementation class UpdateMemberServlet
 */
@WebServlet(name = "updateMember", urlPatterns = {"/updateMember.do"})
public class UpdateMemberServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateMemberServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // update member_tbl set member_addr = "", member_phone ="" where member_no=?
        request.setCharacterEncoding("utf-8");

        String memberAddr = request.getParameter("memberAddr");
        String memberPhone = request.getParameter("memberPhone");
        int memberNo = Integer.parseInt(request.getParameter("memberNo"));
        int memberGrade = Integer.parseInt(request.getParameter("memberGrade"));

        MemberService service = new MemberService();
        int result = service.updateMemberAddrPw(memberAddr, memberPhone, memberNo);

        if (result > 0) {
            // 성공얼럿
            if (memberGrade == 2) {
                RequestDispatcher view =
                        request.getRequestDispatcher("/WEB-INF/views/common/jMsg.jsp");
                request.setAttribute("title", "사진등록이 완료되었습니다.");
                request.setAttribute("loc", "/mypage.do?memberGrade=2");
                view.forward(request, response);
            } else if (memberGrade == 3) {
                RequestDispatcher view =
                        request.getRequestDispatcher("/WEB-INF/views/common/jMsg.jsp");
                request.setAttribute("title", "사진등록이 완료되었습니다.");
                request.setAttribute("loc", "/mypage.do?memberGrade=3");
                view.forward(request, response);
            }
        } else {
            // 실패얼럿
            if (memberGrade == 2) {
                RequestDispatcher view =
                        request.getRequestDispatcher("/WEB-INF/views/common/jMsg.jsp");
                request.setAttribute("title", "사진등록에 실패하였습니다.");
                request.setAttribute("loc", "/mypage.do?memberGrade=2");
                view.forward(request, response);
            } else if (memberGrade == 3) {
                RequestDispatcher view =
                        request.getRequestDispatcher("/WEB-INF/views/common/jMsg.jsp");
                request.setAttribute("title", "사진등록에 실패하였습니다.");
                request.setAttribute("loc", "/mypage.do?memberGrade=3");
                view.forward(request, response);
            }
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

