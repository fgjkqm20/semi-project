package nbd.qna.controller;

import java.io.File;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import nbd.qna.model.service.QnaService;
import nbd.qna.model.vo.Qna;

/**
 * Servlet implementation class QnaDeleteServlet
 */
@WebServlet(name = "QnaDelete", urlPatterns = {"/qnaDelete.do"})
public class QnaDeleteServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public QnaDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 게시글 삭제
        // 1.인코딩
        request.setCharacterEncoding("utf-8");
        // 2.값추출
        int infoNo = Integer.parseInt(request.getParameter("InfoNo"));
        // 3.비즈니스로직
        QnaService service = new QnaService();
        Qna q = service.deleteQna(infoNo);
        // 4.화면처리 결과
        RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
        if (q != null) {
            // 게시글 삭제에 성공하면 해당 게시글의 첨부파일을 삭제
            if (q.getFilePath() != null) { // 첨부파일이 있을때만 동작
                // 파일경로 가져오기
                String root = getServletContext().getRealPath("/");
                String deleteFile = root + "upload/qna/" + q.getFilePath();
                // 파일객체 만들기
                File delFile = new File(deleteFile);
                delFile.delete();
            }
            request.setAttribute("title", "삭제완료");
            request.setAttribute("msg", "삭제가 완료되었습니다.");
            request.setAttribute("icon", "success");
            request.setAttribute("loc", "/qnaList.do?reqPage=1");
        } else {
            request.setAttribute("title", "삭제실패");
            request.setAttribute("msg", "관리자에게 나문희");
            request.setAttribute("icon", "error");
            request.setAttribute("loc", "/qnaView.do?InfoNo=" + infoNo);
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
