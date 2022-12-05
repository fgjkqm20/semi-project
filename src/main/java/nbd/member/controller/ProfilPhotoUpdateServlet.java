package nbd.member.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import nbd.member.model.service.MemberService;
import nbd.member.model.vo.Member;

/**
 * Servlet implementation class ProfilPhotoServlet
 */
@WebServlet(name = "ProfilPhotoUpdate", urlPatterns = { "/profilPhotoUpdate.do" })
public class ProfilPhotoUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfilPhotoUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 인코딩
				request.setCharacterEncoding("utf-8");
				// 값추출
				String root = getServletContext().getRealPath("/");
				String saveDirectory = root+"upload/profil";
				int maxSize = 10*1024*1024;
				MultipartRequest mRequest = new MultipartRequest(request, saveDirectory, maxSize, "utf-8", new DefaultFileRenamePolicy());
				int memberNo = Integer.parseInt(mRequest.getParameter("memberNo"));
				int memberGrade = Integer.parseInt(mRequest.getParameter("memberGrade"));
				String filepath = mRequest.getFilesystemName("profilPhoto");
				//String oldFilepath = mRequest.getParameter("oldFilepath");

				Member member = new Member();
				member.setMemberPhoto(filepath);
				member.setMemberNo(memberNo);
				
				// 비즈니스로직
				MemberService service = new MemberService();
				int result = service.updateProfilPhoto(member);
					
				// 결과처리
				
				if(result>0) {
					HttpSession session = request.getSession();
					Member m = (Member)session.getAttribute("m");
					m.setMemberPhoto(filepath);
					m.setMemberNo(memberNo);
					if(memberGrade == 2) {
						RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/jMsg.jsp");
						request.setAttribute(filepath, saveDirectory);
						request.setAttribute("title", "사진등록이 완료되었습니다.");
						request.setAttribute("loc", "/mypage.do?memberGrade=2");
						view.forward(request, response);
					}else if(memberGrade==3){
						RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/jMsg.jsp");
						request.setAttribute(filepath, saveDirectory);
						request.setAttribute("title", "사진등록이 완료되었습니다.");
						request.setAttribute("loc", "/mypage.do?memberGrade=3");
						view.forward(request, response);
					}
					
				}else {
					if(memberGrade == 2) {
						RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/jMsg.jsp");
						request.setAttribute(filepath, saveDirectory);
						request.setAttribute("title", "사진등록에 실패하였습니다.");
						request.setAttribute("loc", "/mypage.do?memberGrade=2");
						view.forward(request, response);
					}else if(memberGrade==3){
						RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/jMsg.jsp");
						request.setAttribute(filepath, saveDirectory);
						request.setAttribute("title", "사진등록에 실패하였습니다.");
						request.setAttribute("loc", "/mypage.do?memberGrade=3");
						view.forward(request, response);
					}
				}
				/*
				if(result>0) {
					if(status.equals("delete")) {
						File delFile = new File(saveDirectory+oldFilepath);
						delFile.delete();
					}
				request.setAttribute("result", "성공임");
				view.forward(request, response);
				
				}else {
					request.setAttribute("result", "실패");
					view.forward(request, response);
				}
				*/

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
