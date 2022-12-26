package nbd.qna.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import nbd.qna.model.service.QnaService;

/**
 * Servlet implementation class QnaDeleteCommentServlet
 */
@WebServlet(name = "QnaDeleteComment", urlPatterns = {"/qnaDeleteComment.do"})
public class QnaDeleteCommentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public QnaDeleteCommentServlet() {
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
        // 2. 값추출 (commentNo(댓글번호), infoNo(게시글번호))
        int commentNo = Integer.parseInt(request.getParameter("CommentNo")); // 댓글번호
        int infoNo = Integer.parseInt(request.getParameter("InfoNo")); // 게시글번호
        // 3. 비즈니스로직
        QnaService service = new QnaService();
        int result = service.deleteQnaComment(commentNo);
        // 4. 결과처리(화면)
        RequestDispatcher view = request.getRequestDispatcher("qnaView.do?InfoNo=" + infoNo);
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
