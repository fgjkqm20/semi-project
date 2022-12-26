package nbd.counsel.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import nbd.counsel.model.service.CounselService;
import nbd.counsel.model.vo.Counsel;

/**
 * Servlet implementation class CounselModifyFrmServlet
 */
@WebServlet(name = "CounselModifyFrm", urlPatterns = {"/counselModifyFrm.do"})
public class CounselModifyFrmServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CounselModifyFrmServlet() {
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

        // 3. 비지니스 로직
        CounselService service = new CounselService();
        Counsel c = service.getCounsel(counselNo);

        // 4. 결과 처리
        RequestDispatcher view =
                request.getRequestDispatcher("/WEB-INF/views/counsel/counselModifyFrm.jsp");
        request.setAttribute("c", c);
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
