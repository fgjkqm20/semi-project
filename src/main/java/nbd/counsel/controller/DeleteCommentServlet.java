package nbd.counsel.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import nbd.counsel.model.service.CounselService;

/**
 * Servlet implementation class DeleteCommentServlet
 */
@WebServlet(name = "DeleteComment", urlPatterns = {"/deleteComment.do"})
public class DeleteCommentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteCommentServlet() {
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
        int commentNo = Integer.parseInt(request.getParameter("commentNo"));
        int counselNo = Integer.parseInt(request.getParameter("counselNo"));

        // 3. 비즈니스 로직
        CounselService service = new CounselService();
        int result = service.deleteComment(commentNo);

        // 4. 결과 처리
        RequestDispatcher view =
                request.getRequestDispatcher("/counselView.do?clickIndex=1&counselNo=" + counselNo);
        if (result <= 0) {
            request.setAttribute("commentDeleteFail", "댓글을 삭제하지 못하였습니다.");
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
