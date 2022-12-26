package nbd.counsel.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import nbd.counsel.model.service.CounselService;
import nbd.counsel.model.vo.Counsel;

/**
 * Servlet implementation class CounselWriteServlet
 */
@WebServlet(name = "Write", urlPatterns = {"/write.do"})
public class WriteServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public WriteServlet() {
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
        // 2-1. 파일이 업로드 된 경로를 지정
        String root = getServletContext().getRealPath("/");
        String saveDirectory = root + "upload/counsel";
        // 2-2. 파일 없로드 최대 용량 설정(일반적인 웹은 최대 용량 10MB)
        int maxSize = 10 * 1024 * 1024;
        // 2-3. multipart/form-data에서 데이터를 꺼내기 위한 객체
        MultipartRequest mRequest = new MultipartRequest(request, saveDirectory, maxSize, "UTF-8",
                new DefaultFileRenamePolicy());
        String title = mRequest.getParameter("title");
        String writer = mRequest.getParameter("writer");
        String subject = mRequest.getParameter("subject");
        String content = mRequest.getParameter("content");
        String fileneme = mRequest.getOriginalFileName("upfile");
        String filepath = mRequest.getFilesystemName("upfile");

        Counsel c = new Counsel();
        c.setCounselTitle(title);
        c.setMemberId(writer);
        c.setCounselSubject(subject);
        c.setCounselContent(content);
        c.setFileName(fileneme);
        c.setFilePath(filepath);

        // 3. 비즈니스 로직
        CounselService service = new CounselService();
        int result = service.insertCounsel(c);

        // 4. 결과 처리
        RequestDispatcher view = request.getRequestDispatcher("/counselSubjectList.do"
                + "?clickIndex=1&categoryIndex=0" + "&counselSubject=전체&reqPage=1");
        if (result <= 0) {
            request.setAttribute("writeFail", "글을 등록하지 못하였습니다.");
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
