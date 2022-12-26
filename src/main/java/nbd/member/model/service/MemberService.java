package nbd.member.model.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.StringTokenizer;
import common.JDBCTemplate;
import nbd.member.model.dao.MemberDao;
import nbd.member.model.vo.AdminInfo;
import nbd.member.model.vo.Doctor;
import nbd.member.model.vo.DoctorInfo;
import nbd.member.model.vo.DoctorReview;
import nbd.member.model.vo.Member;
import nbd.member.model.vo.MemberInfo;

public class MemberService {

    private MemberDao dao;

    public MemberService() {
        super();
        // TODO Auto-generated constructor stub
        dao = new MemberDao();
    }

    public int insertMember(Member member) {
        Connection conn = JDBCTemplate.getConnection();
        int result = dao.insertMember(conn, member);

        if (result > 0) {

            if (member.getMemberGrade() == 2) {
                int memberNo = dao.selectMember(conn);
                // servlet에서 memberNo를 가져오지 않아서 service에서 memberNo를 set해줌
                member.setMemberNo(memberNo);
                result = dao.insertDoc(conn, member);

                if (result > 0) {
                    JDBCTemplate.commit(conn);
                } else {
                    JDBCTemplate.rollback(conn);
                }
            }

        } else {
            JDBCTemplate.rollback(conn);
        }

        JDBCTemplate.close(conn);

        return result;
    }

    public Member selectOneMember(String memberId) {

        Connection conn = JDBCTemplate.getConnection();
        Member member = dao.selectOneMember(conn, memberId);

        JDBCTemplate.close(conn);

        return member;
    }

    public Member login(String memberId, String memberPw) {
        Connection conn = JDBCTemplate.getConnection();
        Member m = dao.login(conn, memberId, memberPw);
        JDBCTemplate.close(conn);
        return m;
    }



    // 마이페이지
    public Member getMember(int memberNo) {
        Connection conn = JDBCTemplate.getConnection();
        Member m = dao.getMemberNo(conn, memberNo);
        JDBCTemplate.close(conn);
        return m;
    }


    public ArrayList<DoctorReview> getMyReview(String memberId, int startNum, int endNum) {
        Connection conn = JDBCTemplate.getConnection();
        ArrayList<DoctorReview> rlist = dao.getMyReview(conn, memberId, startNum, endNum);
        JDBCTemplate.close(conn);
        return rlist;
    }

    public ArrayList<Doctor> getMyHistory(String memberId) {
        Connection conn = JDBCTemplate.getConnection();
        ArrayList<Doctor> dlist = dao.getMyHistory(conn, memberId);
        JDBCTemplate.close(conn);
        return dlist;
    }

    public int updateProfilPhoto(Member member) {
        // UPDATE MEMBER_TBL SET MEMBER_PHOTO =? WHERE MEMBER_NO = ?
        Connection conn = JDBCTemplate.getConnection();
        int result = dao.updateProfilPhoto(conn, member);
        if (result > 0) {
            JDBCTemplate.commit(conn);
        } else {
            JDBCTemplate.rollback(conn);
        }
        JDBCTemplate.close(conn);
        return result;
    }



    public AdminInfo getAdminInfo() {
        Connection conn = JDBCTemplate.getConnection();
        AdminInfo ai = dao.getAdminInfo(conn);
        int todayD = ai.getTodayDoctor();
        double totalD = ai.getTotalDoctor();
        double doctorPer = Math.round((todayD / totalD) * 100);
        ai.setTotalDoctor(doctorPer);

        int todayP = ai.getTodayMember();
        double totalP = ai.getTotalMember();
        double PatientPer = Math.round((todayP / totalP) * 100);
        ai.setTotalMember(PatientPer);

        int todayR = ai.getTodayReservation();
        double totalR = ai.getTotalReservation();
        double ReservePer = Math.round((todayR / totalR) * 100);
        ai.setTotalReservation(ReservePer);

        int todayC = ai.getTodayWrite();
        double totalC = ai.getTotalWrite();
        double counselPer = Math.round((todayC / totalC) * 100);
        ai.setTotalWrite(counselPer);
        JDBCTemplate.close(conn);
        return ai;
    }

    public ArrayList<Member> selectAllMember() {
        // select * from member_tbl;
        Connection conn = JDBCTemplate.getConnection();
        ArrayList<Member> list = dao.selectAllMember(conn);
        JDBCTemplate.close(conn);
        return list;
    }

    public int insertMyHistory(String doctorId, String doctorWork, String year) {
        // insert into doctor_history_tbl values (?, ?, ?)
        Connection conn = JDBCTemplate.getConnection();
        int result = dao.insertMyHistory(conn, doctorId, doctorWork, year);
        if (result > 0) {
            JDBCTemplate.commit(conn);
        } else {
            JDBCTemplate.rollback(conn);
        }
        JDBCTemplate.close(conn);
        return result;
    }


    public DoctorInfo getDoctorInfo(String memberId, int memberNo) {
        Connection conn = JDBCTemplate.getConnection();
        int doctorStar = dao.selectDoctorStar(conn, memberId);
        int clinicCount = dao.selectDoctorCount(conn, memberId);
        int totalReview = dao.selectDoctorTotalReview(conn, memberId);
        int totalAnswer = dao.selectDoctorTotalComment(conn, memberNo);
        DoctorInfo di = new DoctorInfo(doctorStar, clinicCount, totalReview, totalAnswer);
        JDBCTemplate.close(conn);
        return di;
    }

    public int updateMemberPw(String newPw, int memberNo) {
        // TODO Auto-generated method stub
        Connection conn = JDBCTemplate.getConnection();
        int result = dao.updateMemberPW(conn, newPw, memberNo);
        if (result > 0) {
            JDBCTemplate.commit(conn);
        } else {
            JDBCTemplate.rollback(conn);
        }
        JDBCTemplate.close(conn);
        return result;
    }

    public int deleteMember(int memberNo) {
        // delete from member_tbl where member_no=?
        Connection conn = JDBCTemplate.getConnection();
        int result = dao.deleteMember(conn, memberNo);
        if (result > 0) {
            JDBCTemplate.commit(conn);
        } else {
            JDBCTemplate.rollback(conn);
        }
        JDBCTemplate.close(conn);
        return result;
    }

    public int updateMemberAddrPw(String memberAddr, String memberPhone, int memberNo) {
        // update member_tbl set member_addr = "", member_phone ="" where member_no=?
        Connection conn = JDBCTemplate.getConnection();
        int result = dao.updateMeberAddrPhone(conn, memberAddr, memberPhone, memberNo);
        if (result > 0) {
            JDBCTemplate.commit(conn);
        } else {
            JDBCTemplate.rollback(conn);
        }
        JDBCTemplate.close(conn);
        return result;
    }



    // 합본 후 추가
    /*
     * public HashMap<String, String> getDoctorPageTotal(int memberNo) { // 페이징 처리를 위한 의사의 토탈 경력,
     * 답변, 리뷰 구해오기 Connection conn = JDBCTemplate.getConnection(); HashMap<String, Integer>
     * doctorTotalInfo = dao.getDoctorPageTotal(conn, memberNo); JDBCTemplate.close(conn); return
     * doctorTotalInfo; }
     */
    public MemberInfo getMemberPageTotal(int memberNo) {
        // 페이징 처리를 위한 회원의 토탈 예약, 질문 구해오기
        Connection conn = JDBCTemplate.getConnection();
        MemberInfo mi = dao.getMemberPageTotal(conn, memberNo);
        JDBCTemplate.close(conn);
        return mi;
    }

    public int insertDoctorReview(String doctorId, String review, int bookNo, int memberNo,
            int star) {
        // TODO Auto-generated method stub
        Connection conn = JDBCTemplate.getConnection();
        int result = dao.insertDoctorReview(conn, doctorId, review, bookNo, memberNo, star);
        if (result > 0) {
            JDBCTemplate.commit(conn);
        } else {
            JDBCTemplate.rollback(conn);
        }
        JDBCTemplate.close(conn);
        return result;
    }



    // 효준



    // 효준
    // 등급변경
    public boolean checkedChangedLevel(String num, String level) {
        Connection conn = JDBCTemplate.getConnection();
        StringTokenizer sT1 = new StringTokenizer(num, "/");
        StringTokenizer sT2 = new StringTokenizer(level, "/");
        boolean result = true;
        while (sT1.hasMoreTokens()) {
            int memberNo = Integer.parseInt(sT1.nextToken());
            int memberLevel = Integer.parseInt(sT2.nextToken());
            int changeResult = dao.changeLevel(conn, memberNo, memberLevel);
            if (changeResult == 0) {
                result = false;
                break;
            }
        }
        if (result) {
            JDBCTemplate.commit(conn);
        } else {
            JDBCTemplate.rollback(conn);
        }
        JDBCTemplate.close(conn);

        return result;
    }


    // 아이디검색
    public ArrayList<Member> ADselectSearchMember(String memberId) {
        Connection conn = JDBCTemplate.getConnection();
        ArrayList<Member> list = dao.ADsearchMember(memberId, conn);
        JDBCTemplate.close(conn);
        return list;
    }

    // 등급검색
    public ArrayList<Member> BDselectSearchMember(int memberGrade) {
        Connection conn = JDBCTemplate.getConnection();

        ArrayList<Member> list = dao.BDsearchMember(memberGrade, conn);
        JDBCTemplate.close(conn);
        return list;
    }



    public Member checkEmail(String email) {
        Connection conn = JDBCTemplate.getConnection();
        Member m = dao.checkEmail(conn, email);
        JDBCTemplate.close(conn);
        return m;
    }

    public String checkId(String inputId) {
        Connection conn = JDBCTemplate.getConnection();
        String result = dao.checkId(conn, inputId);
        JDBCTemplate.close(conn);
        return result;
    }

    public int changePw(String id, String pw) {
        Connection conn = JDBCTemplate.getConnection();
        int result = dao.changePw(conn, id, pw);
        if (result > 0) {
            JDBCTemplate.commit(conn);
        } else {
            JDBCTemplate.rollback(conn);
        }
        JDBCTemplate.close(conn);
        return result;
    }

}


