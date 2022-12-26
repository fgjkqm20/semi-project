package nbd.counsel.controller;

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
import nbd.counsel.model.service.CounselService;
import nbd.counsel.model.vo.Counsel;

/**
 * Servlet implementation class CounselModifyServlet
 */
@WebServlet(name = "CounselModify", urlPatterns = {"/counselModify.do"})
public class CounselModifyServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CounselModifyServlet() {
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
        // 2-1. 파일 업로드 경로 설정
        String root = getServletContext().getRealPath("/");
        String saveDirectory = root + "upload/counsel";
        // 2-2. 파일 최대 크기 지정
        int maxSize = 10 * 1024 * 1024;
        // 2-3. request -> MultipartRequest 변환
        MultipartRequest mRequest = new MultipartRequest(request, saveDirectory, maxSize, "UTF-8",
                new DefaultFileRenamePolicy());

        int counselNo = Integer.parseInt(mRequest.getParameter("counselNo"));
        String title = mRequest.getParameter("title");
        String writer = mRequest.getParameter("writer");
        String subject = mRequest.getParameter("subject");
        String content = mRequest.getParameter("content");
        String status = mRequest.getParameter("status");
        String fileName = mRequest.getOriginalFileName("upfile");
        String filePath = mRequest.getFilesystemName("upfile");
        String oldFileName = mRequest.getParameter("oldFileName");
        String oldFilePath = mRequest.getParameter("oldFilePath");

        if (oldFileName != null && status.equals("stay")) {
            fileName = oldFileName;
            filePath = oldFilePath;
        }

        Counsel c = new Counsel();
        c.setCounselNo(counselNo);
        c.setCounselTitle(title);
        c.setMemberId(writer);
        c.setCounselSubject(subject);
        c.setCounselContent(content);
        c.setFileName(fileName);
        c.setFilePath(filePath);

        // 3. 비즈니스 로직
        CounselService service = new CounselService();
        int result = service.modifyCounsel(c);

        // 4. 결과 처리
        RequestDispatcher view = request
                .getRequestDispatcher("/counselView.do?clickIndex=1&counselNo=" + c.getCounselNo());
        if (result > 0) {
            if (status.equals("delete")) {
                File deleteFile = new File(saveDirectory + "/" + oldFilePath);
                deleteFile.delete();
            }
        } else {
            request.setAttribute("counselModifyFail", "글을 수정하지 못하였습니다.");
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
