package nbd.qna.controller;

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
 * Servlet implementation class QnaWriteServlet
 */
@WebServlet(name = "QnaWrite", urlPatterns = {"/qnaWrite.do"})
public class QnaWriteServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public QnaWriteServlet() {
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
        // 2. 값추출 ->multipart/form-data -> cos.jar사용해서처리
        // 2-1. 파일이 업로드될 경로를지정
        String root = getServletContext().getRealPath("/");// wepapp폴더의 절대경로
        String saveDirectory = root + "upload/qna"; // 폴더
        int maxSize = 10 * 1024 * 1024; // 용량설정
        // multipart/form-data에서 테이터객체를 꺼내기위함
        MultipartRequest mRequest = new MultipartRequest(request, saveDirectory, maxSize, "UTF-8",
                new DefaultFileRenamePolicy());
        // multipartrequest에서 수행
        String qnaTitle = mRequest.getParameter("qnaTitle");
        String qnaWriter = mRequest.getParameter("qnaWriter");
        String qnaContent = mRequest.getParameter("qnaContent");
        String filename = mRequest.getOriginalFileName("upfile");// 다운로드할때 올렸던 파일이름그대로 다운로드
        String filepath = mRequest.getFilesystemName("upfile");// 화면에 업로드된파일(중복처리 후파일이름)

        Qna q = new Qna();
        q.setInfoTitle(qnaTitle);
        q.setMemberId(qnaWriter);
        q.setInfoContent(qnaContent);
        q.setFileName(filename);
        q.setFilePath(filepath);
        // 3.비즈니스로직
        QnaService service = new QnaService();
        int result = service.insertQna(q);
        // 4. 결과처리
        RequestDispatcher view = request.getRequestDispatcher("/qnaList.do?reqPage=1");
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
