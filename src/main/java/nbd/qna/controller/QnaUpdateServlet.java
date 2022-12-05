package nbd.qna.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import nbd.qna.model.service.QnaService;
import nbd.qna.model.vo.Qna;

/**
 * Servlet implementation class QnaUpdateServlet
 */
@WebServlet(name = "QnaUpdate", urlPatterns = { "/qnaUpdate.do" })
public class QnaUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QnaUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 인코딩
		request.setCharacterEncoding("utf-8");
		//2. 값추출
		//2-1 파일업로드 경로설정
		String root = getServletContext().getRealPath("/");
		String saveDirectory = root+"upload/qna";
		int maxSize=10*1024*1024;
		//2-3 request-> Multipart로변환
		MultipartRequest mRequest = new MultipartRequest(request, saveDirectory,maxSize,"UTF-8",new DefaultFileRenamePolicy());
		int qnaNo=Integer.parseInt(mRequest.getParameter("qnaNo"));
		String qnaTitle=mRequest.getParameter("qnaTitle");
		String qnaContent=mRequest.getParameter("qnaContent");
		//기존파일이 지워졌으면 delete, 그외 모두 stay
		String status=mRequest.getParameter("status");
		//새 첨부파일
		String filename = mRequest.getOriginalFileName("upfile");
		String filepath = mRequest.getFilesystemName("upfile");
		//기존 첨부파일이 있었으면 기존첨부파일값, 없었으면 null
		String oldFilename = mRequest.getParameter("oldFilename");
		String oldFilepath = mRequest.getParameter("oldFilepath");
		
		if(oldFilename != null && status.equals("stay")) {
			filename = oldFilename;
			filepath = oldFilepath;
		}
		Qna q = new Qna();
		q.setInfoNo(qnaNo);
		q.setInfoTitle(qnaTitle);
		q.setInfoContent(qnaContent);
		q.setFileName(filename);
		q.setFilePath(filepath);
		//3. 비즈니스로직
		QnaService service = new QnaService();
		int result = service.updateQna(q);
		//4.화면처리
		RequestDispatcher view = request.getRequestDispatcher("/qnaView.do?InfoNo="+qnaNo);
	      if(result>0) {
	         //성공
	         if(status.equals("delete")) {
	            File delFile = new File(saveDirectory+"/"+oldFilepath);
	            delFile.delete();
	         }
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
