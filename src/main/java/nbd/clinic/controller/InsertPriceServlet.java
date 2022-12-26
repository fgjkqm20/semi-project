package nbd.clinic.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import nbd.clinic.model.service.BookService;
import nbd.clinic.model.vo.Book;
import nbd.member.model.vo.Member;

/**
 * Servlet implementation class InsertPriceServlet
 */
@WebServlet(name = "InsertPrice", urlPatterns = {"/insertPrice.do"})
public class InsertPriceServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertPriceServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 1.인코딩
        request.setCharacterEncoding("utf-8");
        // 2.값추출
        int price = Integer.parseInt(request.getParameter("price"));
        HttpSession session = request.getSession();
        Member m = (Member) session.getAttribute("m");
        String memberId = m.getMemberId();
        int memberNo = Integer.parseInt(request.getParameter("memberNo"));
        Book b = new Book();
        b.setBookPrice(price);
        b.setMemberNo(memberNo);
        // 3.비즈니스 로직
        BookService service = new BookService();
        int result = service.insertPrice(b);
        // 4.결과처리
        RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/Dmsg.jsp");
        if (result > 0) {
            b.setBookPrice(price);
            b.setMemberNo(memberNo);
            request.setAttribute("title", "성 공");
            request.setAttribute("msg", "진료비 기입이 완료되었습니다.");
            request.setAttribute("icon", "success");
            request.setAttribute("loc", "/treatmentRoom3.do?memberId=" + memberId);
        } else {
            request.setAttribute("title", "정보변경 실패");
            request.setAttribute("icon", "error");
            request.setAttribute("loc", "/treatmentRoom3.do?memberId=" + memberId);
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
