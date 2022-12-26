package nbd.qna.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import nbd.qna.model.service.QnaService;
import nbd.qna.model.vo.QnaComment;

/**
 * Servlet implementation class InsertCommentServlet
 */
@WebServlet(name = "InsertCommentq", urlPatterns = {"/insertCommentq.do"})
public class InsertCommentqServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertCommentqServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 댓글
        // 1.인코딩
        request.setCharacterEncoding("utf-8");
        // 2.값추출
        QnaComment qc = new QnaComment();
        qc.setMemberId(request.getParameter("memberId")); // 작성자
        qc.setInfoNo(Integer.parseInt(request.getParameter("infoNo")));// 어떤공지사항의 댓글인지
        qc.setCommentNo(Integer.parseInt(request.getParameter("commentNo"))); // 댓글 번호
        qc.setCommentContent(request.getParameter("commentContent")); // 댓글내용
        // 3.비즈니스로직
        QnaService service = new QnaService();
        int result = service.insertQnaComment(qc);
        // 4.결과처리
        RequestDispatcher view =
                request.getRequestDispatcher("qnaView.do?InfoNo=" + qc.getInfoNo());
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
