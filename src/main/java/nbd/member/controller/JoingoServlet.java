package nbd.member.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import nbd.member.model.service.MemberService;
import nbd.member.model.vo.Member;

/**
 * Servlet implementation class JoingoServlet
 */
@WebServlet(name = "/JoingoServlet", urlPatterns = {"/joingo.do"})
public class JoingoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public JoingoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 인코딩
        request.setCharacterEncoding("utf-8");

        String root = getServletContext().getRealPath("/"); // webapp 절대경로
        String saveDirectory = root + "upload/profil";

        // 파일 최대 사이즈
        int maxSize = 10 * 1024 * 1024;

        MultipartRequest mRequest = new MultipartRequest(request, saveDirectory, maxSize, "utf-8",
                new DefaultFileRenamePolicy());

        String memberId = mRequest.getParameter("id");
        String memberPw = mRequest.getParameter("pw");
        int memberLevel = Integer.parseInt(mRequest.getParameter("memberLevel"));
        // memberLevel에 따른 것은 dao의 쿼리문에서 ㄱㄱ
        String docMajor = mRequest.getParameter("docMajor");
        String memberName = mRequest.getParameter("name");
        String memberBirth = mRequest.getParameter("post");
        String email = mRequest.getParameter("email");
        String memberPhone = mRequest.getParameter("phone");
        String memberAddr = mRequest.getParameter("addr");
        String profilePhoto = mRequest.getFilesystemName("upfilePhoto");
        String filepath = mRequest.getFilesystemName("upfile");
        String hospitalName = mRequest.getParameter("hospitalName");
        String hospitalAddr = mRequest.getParameter("hospitalAddr");

        Member member = new Member();
        member.setMemberId(memberId);
        member.setMemberPw(memberPw);
        member.setMemberGrade(memberLevel);
        member.setMajor(docMajor);
        member.setMemberName(memberName);
        member.setMemberBirth(memberBirth);
        member.setMemberEmail(email);
        member.setMemberPhone(memberPhone);
        member.setMemberAddr(memberAddr);
        member.setMemberPhoto(profilePhoto);
        member.setDoctorFilePath(filepath);
        member.setHospitalName(hospitalName);
        member.setHospitalAddr(hospitalAddr);

        MemberService service = new MemberService();
        int result = service.insertMember(member);



        if (result > 0) {
            RequestDispatcher view =
                    request.getRequestDispatcher("/WEB-INF/views/member/welcome.jsp");
            view.forward(request, response);
        } else {
            RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/jMsg.jsp");
            request.setAttribute("title", "회원가입 중에 문제가 발생하였습니다.");
            request.setAttribute("loc", "/");
            view.forward(request, response);
        }
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


