package nbd.counsel.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import nbd.counsel.model.service.CounselService;
import nbd.counsel.model.vo.Counsel;

/**
 * Servlet implementation class FileDownServlet
 */
@WebServlet(name = "FileDown", urlPatterns = {"/fileDown.do"})
public class FileDownServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public FileDownServlet() {
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
        Counsel c = service.getCounsel(counselNo);
        // 4. 결과 처리
        // 사용자에게 다운로드할 파일과 현재 서블릿 연결
        String root = getServletContext().getRealPath("/");
        // 업로드 경로 + 해당 게시물의 실제 업로된 파일 이름
        String downFile = root + "upload/counsel/" + c.getFilePath();
        // 파일을 서블릿으로 읽어오기 위한 스트림 생성
        FileInputStream fis = new FileInputStream(downFile);
        BufferedInputStream bis = new BufferedInputStream(fis);
        // 읽어온 파일을 사용자에게 내보내기 위한 스트림 생성
        ServletOutputStream sos = response.getOutputStream();
        BufferedOutputStream bos = new BufferedOutputStream(sos);
        // 파일명 처리
        String resFileName = new String(c.getFileName().getBytes("UTF-8"), "ISO-8859-1");
        // 파일 다운로드를 위한 HTTP 헤더 설정
        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition", "attachment;fileName=" + resFileName);
        // 파일 전송
        while (true) {
            int read = bis.read();
            if (read != -1) {
                bos.write(read);
            } else {
                break;
            }
        }
        bos.close();
        bis.close();
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
