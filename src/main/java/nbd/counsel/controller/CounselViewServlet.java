package nbd.counsel.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import nbd.counsel.model.service.CounselService;
import nbd.counsel.model.vo.CounselViewData;

/**
 * Servlet implementation class CounselViewServlet
 */
@WebServlet(name = "CounselView", urlPatterns = {"/counselView.do"})
public class CounselViewServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CounselViewServlet() {
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
        int counselNo = Integer.parseInt(request.getParameter("counselNo"));

        // 3. 비즈니스 로직
        CounselService service = new CounselService();
        CounselViewData cvd = service.selectOneCounsel(counselNo);

        // 4. 결과 처리
        RequestDispatcher view;
        if (cvd == null) {
            request.setAttribute("viewFail", "글을 읽을 수 없습니다.");

            view = request.getRequestDispatcher("/WEB-INF/views/counsel/counselSubjectList.do?"
                    + "clickIndex=1&categoryIndex=0&" + "counselSubject=전체&reqPage=1");
        } else {
            request.setAttribute("c", cvd.getC());
            request.setAttribute("comment", cvd.getCommentList());

            view = request.getRequestDispatcher("/WEB-INF/views/counsel/counselView.jsp");
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
