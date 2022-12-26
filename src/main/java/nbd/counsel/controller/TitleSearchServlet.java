package nbd.counsel.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import nbd.counsel.model.service.CounselService;
import nbd.counsel.model.vo.CounselPageData;

/**
 * Servlet implementation class CounselTitleSearchServlet
 */
@WebServlet(name = "TitleSearch", urlPatterns = {"/titleSearch.do"})
public class TitleSearchServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public TitleSearchServlet() {
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
        String searchWord = request.getParameter("searchInput");
        int reqPage = Integer.parseInt(request.getParameter("reqPage"));

        // 3. 비즈니스 로직
        CounselService service = new CounselService();
        CounselPageData cpd = service.titleSearch(searchWord, reqPage);

        // 4. 결과 처리
        RequestDispatcher view =
                request.getRequestDispatcher("/WEB-INF/views/counsel/counselList.jsp");
        request.setAttribute("list", cpd.getList());
        request.setAttribute("pageNavi", cpd.getPageNavi());
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
