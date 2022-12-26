package nbd.counsel.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import nbd.counsel.model.service.CounselService;
import nbd.counsel.model.vo.CounselComment;

/**
 * Servlet implementation class InsertCommentServlet
 */
@WebServlet(name = "InsertComment", urlPatterns = {"/insertComment.do"})
public class InsertCommentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertCommentServlet() {
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
        CounselComment cc = new CounselComment();
        cc.setCommentWriterNo(Integer.parseInt(request.getParameter("commentWriterNo")));
        cc.setCommentWriterName(request.getParameter("commentWriterName"));
        cc.setCommentContent(request.getParameter("commentContent"));
        int counselNo = Integer.parseInt(request.getParameter("counselNo"));
        cc.setCounselNo(counselNo);

        // 3. 비즈니스 로직
        CounselService service = new CounselService();
        int result = service.insertComment(cc);

        // 4. 결과 처리
        RequestDispatcher view = request
                .getRequestDispatcher("/counselView.do??clickIndex=1" + "&counselNo=" + counselNo);
        if (result <= 0) {
            request.setAttribute("commentWriteFail", "댓글을 등록하지 못하였습니다.");
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
