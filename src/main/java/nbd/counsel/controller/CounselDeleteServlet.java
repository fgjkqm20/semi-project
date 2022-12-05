package nbd.counsel.controller;

import java.io.File;
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
 * Servlet implementation class CounselDeleteServlet
 */
@WebServlet(name = "CounselDelete", urlPatterns = { "/counselDelete.do" })
public class CounselDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CounselDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 인코딩
		request.setCharacterEncoding("utf-8");
		
		// 2. 값 추출
		int counselNo = Integer.parseInt(request.getParameter("counselNo"));
		
		// 3. 비즈니스 로직
		CounselService service = new CounselService();
		// 삭제 후 파일을 처리하기 위해 해당 정보를 받음
		Counsel c = service.deleteNotice(counselNo);
		
		// 4. 결과 처리
		RequestDispatcher view;
		if(c != null) {
			view = request.getRequestDispatcher
					("/counselSubjectList.do?"
					+ "clickIndex=1&categoryIndex=0&"
					+ "counselSubject=전체&reqPage=1");
			
			// 게시물 삭제에 성공하면 해단 게시물의 첨부파일을 삭제
			if(c.getFilePath() != null) {
				String root = getServletContext().getRealPath("/");
				String deleteFile = root + "upload/counsel/" + c.getFileName();
				File delFile = new File(deleteFile);
				delFile.delete();
			}
		}else {
			view = request.getRequestDispatcher
					("/counselView.do?clickIndex=1&counselNo=" + counselNo);
			request.setAttribute("counselDeleteFail", "글을 삭제하지 못하였습니다.");
		}
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
