package nbd.qna.controller;

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
import nbd.qna.model.service.QnaService;
import nbd.qna.model.vo.Qna;

/**
 * Servlet implementation class QnaFileDownServlet
 */
@WebServlet(name = "QnaFileDown", urlPatterns = {"/qnaFileDown.do"})
public class QnaFileDownServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public QnaFileDownServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 1.인코딩
        request.setCharacterEncoding("utf-8");
        // 2.값추출
        int infoNo = Integer.parseInt(request.getParameter("InfoNo"));
        // 3.비즈니스로직
        QnaService service = new QnaService();
        Qna q = service.getQna(infoNo);
        // 4.결과처리
        // 파일 읽어오는 작업
        String root = getServletContext().getRealPath("/");
        // 업로드 경로에 해당 게시물의 실제 없로드된 파일이름
        String downFile = root + "upload/qna/" + q.getFilePath();
        // 파일 서블릿으로 읽어오기 위한 스트림 생성
        FileInputStream fis = new FileInputStream(downFile); // 속도가 느려서
        BufferedInputStream bis = new BufferedInputStream(fis); // 속도 up
        // 읽어온 파일을 사용자게에 내보내기위한 스트림생성
        ServletOutputStream sos = response.getOutputStream();
        BufferedOutputStream bos = new BufferedOutputStream(sos);
        // 파일명처리
        String resFilename = new String(q.getFileName().getBytes("utf-8"), "ISO-8859-1");
        // 파일다운로드를 위한 HTTP 헤더설정
        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition", "attachment;filename=" + resFilename);
        // 파일전송
        while (true) {
            int read = bis.read(); // 읽어옴
            if (read != -1) {
                bos.write(read);
            } else {
                break;
            }
        }
        bos.close();
        bis.close(); // 반환
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
