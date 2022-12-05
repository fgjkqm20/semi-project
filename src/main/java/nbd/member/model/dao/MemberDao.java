package nbd.member.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.JDBCTemplate;
import nbd.member.model.vo.AdminInfo;
import nbd.member.model.vo.Doctor;
import nbd.member.model.vo.DoctorReview;
import nbd.member.model.vo.Member;
import nbd.member.model.vo.MemberInfo;

public class MemberDao {

	public int insertMember(Connection conn, Member member) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = "insert into member_tbl values(member_tbl_seq.nextval, ?, ?, ?, ?, ?, ?, ?, ?, to_char(sysdate,'yyyy-mm-dd'), 0, ?, ?, ?, ?, ?)";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, member.getMemberId());
			pstmt.setString(2, member.getMemberPw());
			pstmt.setString(3, member.getMemberName());
			pstmt.setString(4, member.getMemberBirth());
			pstmt.setString(5, member.getMemberPhone());
			pstmt.setString(6, member.getMemberAddr());
			pstmt.setString(7, member.getMemberEmail());
			pstmt.setInt(8, member.getMemberGrade());
			pstmt.setString(9, member.getMemberPhoto());
			pstmt.setString(10, member.getMajor());
			pstmt.setString(11, member.getDoctorFilePath());
			pstmt.setString(12, member.getHospitalName());
			pstmt.setString(13, member.getHospitalAddr());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}
	
	public Member selectOneMember(Connection conn, String membeId) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		Member member = null;
		String query = "select * from member_tbl where member_id = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, membeId);
			
			rset = pstmt.executeQuery();
			if(rset.next()) {
				member = new Member();
				member.setMemberNo(rset.getInt("member_no"));
				member.setMemberId(rset.getString("member_id"));
				member.setMemberPw(rset.getString("member_pw"));
				member.setMemberName(rset.getString("member_name"));
				member.setMemberBirth(rset.getString("member_birth"));
				member.setMemberPhone(rset.getString("member_phone"));
				member.setMemberAddr(rset.getString("member_addr"));
				member.setMemberEmail(rset.getString("member_email"));
				member.setMemberGrade(rset.getInt("member_grade"));
				member.setEnrollDate(rset.getString("enroll_date"));
				member.setMemberWarning(rset.getInt("member_warning"));
				member.setMemberPhoto(rset.getString("member_photo"));
				member.setMajor(rset.getString("major"));
				member.setDoctorFilePath(rset.getString("DOCTOR_FILEPATH"));
				member.setHospitalName(rset.getString("HOSPITAL_NAME"));
				member.setHospitalAddr(rset.getString("HOSPITAL_ADDR"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rset);
		}
		
		return member;
	}
	
	public Member login(Connection conn, String memberId, String memberPw) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Member m = null;
		String query = "select * from member_tbl where member_id = ? and member_pw = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, memberId);
			pstmt.setString(2, memberPw);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				m = new Member();
				m.setMemberNo(rset.getInt("member_no"));
				m.setMemberId(rset.getString("member_id"));
				m.setMemberPw(rset.getString("member_pw"));
				m.setMemberName(rset.getString("member_name"));
				m.setMemberBirth(rset.getString("member_birth"));
				m.setMemberPhone(rset.getString("member_phone"));
				m.setMemberAddr(rset.getString("member_addr"));
				m.setMemberEmail(rset.getString("member_email"));
				m.setMemberGrade(rset.getInt("member_grade"));
				m.setEnrollDate(rset.getString("enroll_date"));
				m.setMemberWarning(rset.getInt("member_warning"));
				m.setMemberPhoto(rset.getString("member_photo"));
				m.setMajor(rset.getString("major"));
				m.setDoctorFilePath(rset.getString("DOCTOR_FILEPATH"));
				m.setHospitalName(rset.getString("HOSPITAL_NAME"));
				m.setHospitalAddr(rset.getString("HOSPITAL_ADDR"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rset);
		}
		
		return m;
	}

	public int insertDoc(Connection conn, Member m) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = "insert into doctor_tbl values(?, ?, ?, 0, ?, ?)";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, m.getMemberNo());
			pstmt.setString(2, m.getMemberId());
			pstmt.setString(3, m.getMajor());
			pstmt.setString(4, m.getHospitalName());
			pstmt.setString(5, m.getHospitalAddr());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

	public int selectMember(Connection conn) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		int memberNo = 0;
		String query = "select max(member_no) as memberNo from member_tbl";
		
		try {
			pstmt = conn.prepareStatement(query);

			rset = pstmt.executeQuery();
			if(rset.next()) {
				// memberNo를 0으로 초기화시켜주고 쿼리에서 조회된 회원번호를 memberNo에 넣어줌
				memberNo = rset.getInt("memberNo");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rset);
		}
		
		return memberNo;
	}

	
	
	

	// 마이페이지
	public Member getMemberNo(Connection conn, int memberNo) {
		// select * from member_tbl where member_no = ?;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Member m = null;
		
		String query = "select * from member_tbl where member_no = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, memberNo);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				m = new Member();
				m.setEnrollDate(rset.getString("enroll_date"));
				m.setMemberAddr(rset.getString("member_addr"));
				m.setMemberBirth(rset.getString("member_birth"));
				m.setMemberEmail(rset.getString("member_email"));
				m.setMemberGrade(rset.getInt("member_grade"));
				m.setMemberId(rset.getString("member_id"));
				m.setMemberName(rset.getString("member_name"));
				m.setMemberNo(rset.getInt("member_no"));
				m.setMemberPhone(rset.getString("member_phone"));
				m.setMemberPhoto(rset.getString("member_photo"));
				m.setMemberPw(rset.getString("member_pw"));
				m.setMemberWarning(rset.getInt("member_warning"));
	            m.setDoctorFilePath(rset.getString("doctor_filepath"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return m;
	}

	public ArrayList<DoctorReview> getMyReview(Connection conn, String memberId, int startNum, int endNum) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<DoctorReview> rlist = new ArrayList<DoctorReview>();
		String query = "SELECT R.* FROM (SELECT ROWNUM AS RNUM, REVIEW_NO, BOOK_NO, "
				+"(SELECT MEMBER_ID FROM MEMBER_TBL M WHERE M.MEMBER_NO=D.MEMBER_NO) AS  MEMBER_ID, "
				+"STAR_MARK, BOOK_DATE FROM DOCTOR_REVIEW_TBL D JOIN BOOK_TBL USING (BOOK_NO) "
				+"WHERE DOCTOR_ID=? ORDER BY REVIEW_NO DESC)R WHERE RNUM BETWEEN ? AND ?";
			   
	    try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, memberId);
			pstmt.setInt(2, startNum);
			pstmt.setInt(3, endNum);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				DoctorReview dr = new DoctorReview();
				dr.setBookNo(rset.getInt("book_no"));
				dr.setReviewNo(rset.getInt("review_no"));
				dr.setMemberId(rset.getString("member_id"));
				dr.setStarMark(rset.getInt("star_mark"));
				dr.setBookDate(rset.getString("book_date"));
				rlist.add(dr);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
	    
		return rlist;
	}

	public ArrayList<Doctor> getMyHistory(Connection conn, String memberId) {
		// SELECT SUBSTR(DOCTOR_DATE, 0, 4) STARTYEAR, SUBSTR(DOCTOR_DATE, 5, 9) ENDYEAR, DOCTOR_DATE, DOCTOR_WORK FROM DOCTOR_HISTORY_TBL WHERE DOCTOR_ID='DOC1' ORDER BY DOCTOR_DATE DESC;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Doctor> dlist = new ArrayList<Doctor>();
		String query = "SELECT SUBSTR(DOCTOR_DATE, 0, 4) STARTYEAR, SUBSTR(DOCTOR_DATE, 5, 9) ENDYEAR, DOCTOR_WORK FROM DOCTOR_HISTORY_TBL WHERE DOCTOR_ID=? ORDER BY DOCTOR_DATE DESC";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, memberId);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Doctor d = new Doctor();
				d.setHistoryStartYear(rset.getString("startyear"));
				d.setHistoryEndYear(rset.getString("endyear"));
				d.setDoctorWork(rset.getString("doctor_work"));
				System.out.println();
				dlist.add(d);
			}
					
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return dlist;
	}

	public int updateProfilPhoto(Connection conn, Member member) {
		// UPDATE MEMBER_TBL SET MEMBER_PHOTO =? WHERE MEMBER_NO = ?
		int result = 0;
		PreparedStatement pstmt = null;
		String query = "UPDATE MEMBER_TBL SET MEMBER_PHOTO =? WHERE MEMBER_NO = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, member.getMemberPhoto());
			pstmt.setInt(2, member.getMemberNo());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}

		return result;
	}

	
	public AdminInfo getAdminInfo(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		AdminInfo ai = null;
		String query = "SELECT (SELECT COUNT(*) FROM MEMBER_TBL WHERE MEMBER_GRADE = 2) AS TOTAL_DOCTOR, ";
				query += "(SELECT COUNT(*) FROM MEMBER_TBL WHERE MEMBER_GRADE = 3) AS TOTAL_MEMBER, ";
				query += "(SELECT COUNT(*) FROM BOOK_TBL) AS TOTAL_BOOK, ";
				query += "(SELECT COUNT(*) FROM HEALTH_COUNSEL_TBL) AS TOTAL_COUNSEL,";
				query += "(SELECT COUNT(*) FROM MEMBER_TBL WHERE ENROLL_DATE = TO_CHAR(SYSDATE, 'YYYY-MM-DD') AND MEMBER_GRADE = 3) AS TODAY_MEMBER,";
				query += "(SELECT COUNT(*) FROM MEMBER_TBL WHERE ENROLL_DATE = TO_CHAR(SYSDATE, 'YYYY-MM-DD') AND MEMBER_GRADE = 2) AS TODAY_DOCTOR, ";
				query += "(SELECT COUNT(*) FROM BOOK_TBL WHERE BOOK_DATE = TO_CHAR(SYSDATE, 'YYYY-MM-DD')) AS TODAY_BOOK, ";
				query += "(SELECT COUNT(*) FROM HEALTH_COUNSEL_TBL WHERE COUNSEL_DATE = TO_CHAR(SYSDATE, 'YYYY-MM-DD')) AS TODAY_COUNSEL ";
				query += "FROM DUAL";

				try {
					pstmt = conn.prepareStatement(query);
					rset = pstmt.executeQuery();
					
					if(rset.next()) {
						ai = new AdminInfo();
						ai.setTodayDoctor(rset.getInt("today_doctor"));
						ai.setTodayMember(rset.getInt("today_member"));
						ai.setTodayReservation(rset.getInt("today_book"));
						ai.setTodayWrite(rset.getInt("today_counsel"));
						ai.setTotalDoctor(rset.getInt("total_doctor"));
						ai.setTotalMember(rset.getInt("total_member"));
						ai.setTotalReservation(rset.getInt("total_book"));
						ai.setTotalWrite(rset.getInt("total_counsel"));
					}
					
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					JDBCTemplate.close(pstmt);
					JDBCTemplate.close(rset);
				}		
		return ai;
	}

	public ArrayList<Member> selectAllMember(Connection conn) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Member> list = new ArrayList<Member>();
		String query = "select * from member_tbl";
		
		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Member m = new Member();
				m.setEnrollDate(rset.getString("enroll_date"));
				m.setMemberAddr(rset.getString("member_addr"));
				m.setMemberBirth(rset.getString("member_birth"));
				m.setMemberEmail(rset.getString("member_email"));
				m.setMemberGrade(rset.getInt("member_grade"));
				m.setMemberId(rset.getString("member_id"));
				m.setMemberName(rset.getString("member_name"));
				m.setMemberNo(rset.getInt("member_no"));
				m.setMemberPhone(rset.getString("member_phone"));
				m.setMemberPhoto(rset.getString("member_photo"));
				m.setMemberPw(rset.getString("member_pw"));
				m.setMemberWarning(rset.getInt("member_warning"));
				m.setDoctorFilePath(rset.getString("doctor_filepath"));
				m.setMajor(rset.getString("major"));
				list.add(m);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rset);
		}		
		
		return list;
	}

	public int insertMyHistory(Connection conn, String doctorId, String doctorWork, String year) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "insert into doctor_history_tbl values (?, ?, ?)";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, doctorId);
			pstmt.setString(2, doctorWork);
			pstmt.setString(3, year);
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

		


	public int selectDoctorCount(Connection conn, String memberId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int result = 0;
		String query = "SELECT COUNT(*) AS BOOK FROM BOOK_TBL WHERE BOOK_DOCTOR=?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, memberId);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				result = rset.getInt("BOOK");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int selectDoctorStar(Connection conn, String memberId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int result = 0;
		String query = "SELECT DOCTOR_STAR FROM DOCTOR_TBL WHERE DOCTOR_ID=?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, memberId);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				result = rset.getInt("DOCTOR_STAR");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int updateMemberPW(Connection conn, String newPw, int memberNo) {
		// update member_tbl set member_pw=? where member_no=?;
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "update member_tbl set member_pw =? where member_no=?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, newPw);
			pstmt.setInt(2, memberNo);
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;

	}

	public int deleteMember(Connection conn, int memberNo) {
		// delete from member_tbl where member_no=?
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "delete from member_tbl where member_no=?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, memberNo);
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;

	}

	public int updateMeberAddrPhone(Connection conn, String memberAddr, String memberPhone, int memberNo) {
		// update member_tbl set member_addr = "", member_phone ="" where member_no=?
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "update member_tbl set member_addr=?, member_phone =? where member_no=?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, memberAddr);
			pstmt.setString(2, memberPhone);
			pstmt.setInt(3, memberNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}

	public MemberInfo getMemberPageTotal(Connection conn, int memberNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		MemberInfo mi = null;
		String query = "SELECT (SELECT COUNT(*) FROM BOOK_TBL B WHERE B.MEMBER_NO=?) AS TOTAL_BOOK, "
				+ "(SELECT COUNT(*) FROM HEALTH_COUNSEL_TBL H WHERE H.MEMBER_ID=(SELECT M.MEMBER_ID FROM MEMBER_TBL M WHERE M.MEMBER_NO=?)) AS TOTAL_QUESTION "
				+ "FROM DUAL";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, memberNo);
			pstmt.setInt(2, memberNo);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				mi = new MemberInfo();
				mi.setTotalBook(rset.getInt("TOTAL_BOOK"));
				mi.setTotalQuestion(rset.getInt("TOTAL_QUESTION"));
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return mi;
	}

	public int insertDoctorReview(Connection conn, String doctorId, String review, int bookNo, int memberNo, int star) {
        // 리뷰넘버, 의사아이디, 의사에대한 코멘트, 예약번호, 117, 4
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "INSERT INTO DOCTOR_REVIEW_TBL VALUES (DOCTOR_REVIEW_SEQ.NEXTVAL, ?,?,?,?,?)";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, doctorId);
			pstmt.setString(2, review);
			pstmt.setInt(3, bookNo);
			pstmt.setInt(4, memberNo);
			pstmt.setInt(5, star);
			result = pstmt.executeUpdate();
			
					
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int selectDoctorTotalReview(Connection conn, String memberId) {
		// SELECT COUNT(*) AS CNT FROM DOCTOR_REVIEW_TBL WHERE DOCTOR_ID = 'DOC1';
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int result = 0;
		String query = "SELECT COUNT(*) AS CNT FROM DOCTOR_REVIEW_TBL WHERE DOCTOR_ID = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, memberId);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				result = rset.getInt("cnt");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

	public int selectDoctorTotalComment(Connection conn, int memberNo) {
		// SELECT COUNT(*) AS CNT FROM COUNSEL_COM_TBL WHERE COMMENT_WRITER_NO = 188;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int result = 0;
		String query = "SELECT COUNT(*) AS CNT FROM COUNSEL_COM_TBL WHERE COMMENT_WRITER_NO = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, memberNo);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				result = rset.getInt("cnt");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}
	
	
	
	
	
	
	
	///////효준
	
	   //아이디 검색
	   public ArrayList<Member> ADsearchMember(String memberId, Connection conn) {
	      PreparedStatement pstmt = null;
	      ResultSet rset = null;
	      ArrayList<Member> list = new ArrayList<Member>();
	      String query = "select * from member_tbl where member_id like ?";
	      try {
	         pstmt = conn.prepareStatement(query);
	         pstmt.setString(1, "%"+memberId+"%");
	         rset = pstmt.executeQuery();
	         while(rset.next()) {
	            Member m = new Member();
	            m.setEnrollDate(rset.getString("enroll_date"));
	            m.setMemberAddr(rset.getString("member_addr"));
	            m.setMemberBirth(rset.getString("member_birth"));
	            m.setMemberEmail(rset.getString("member_email"));
	            m.setMemberGrade(rset.getInt("member_grade"));
	            m.setMemberId(rset.getString("member_id"));
	            m.setMemberName(rset.getString("member_name"));
	            m.setMemberNo(rset.getInt("member_no"));
	            m.setMemberPhone(rset.getString("member_phone"));
	            m.setMemberPhoto(rset.getString("member_photo"));
	            m.setMemberPw(rset.getString("member_pw"));
	            m.setMemberWarning(rset.getInt("member_warning"));
	            m.setDoctorFilePath(rset.getString("doctor_filepath"));
	            m.setMajor(rset.getString("major"));
	            list.add(m);
	         }
	      } catch (SQLException e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	      }finally {
	         JDBCTemplate.close(pstmt);
	         JDBCTemplate.close(rset);
	      }      
	      return list;
	   }

	   
	   //등급검색
	   public ArrayList<Member> BDsearchMember(int memberGrade, Connection conn) {
	      PreparedStatement pstmt = null;
	      ResultSet rset = null;
	      ArrayList<Member> list = new ArrayList<Member>();
	      String query = "select * from member_tbl where member_Grade like ?";
	      try {
	         pstmt = conn.prepareStatement(query);
	         pstmt.setString(1, "%"+memberGrade+"%");
	         rset = pstmt.executeQuery();
	         while(rset.next()) {
	            Member m = new Member();
	            m.setEnrollDate(rset.getString("enroll_date"));
	            m.setMemberAddr(rset.getString("member_addr"));
	            m.setMemberBirth(rset.getString("member_birth"));
	            m.setMemberEmail(rset.getString("member_email"));
	            m.setMemberGrade(rset.getInt("member_grade"));
	            m.setMemberId(rset.getString("member_id"));
	            m.setMemberName(rset.getString("member_name"));
	            m.setMemberNo(rset.getInt("member_no"));
	            m.setMemberPhone(rset.getString("member_phone"));
	            m.setMemberPhoto(rset.getString("member_photo"));
	            m.setMemberPw(rset.getString("member_pw"));
	            m.setMemberWarning(rset.getInt("member_warning"));
	            m.setDoctorFilePath(rset.getString("doctor_filepath"));
	            m.setMajor(rset.getString("major"));
	            list.add(m);
	         }
	      } catch (SQLException e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	      }finally {
	         JDBCTemplate.close(pstmt);
	         JDBCTemplate.close(rset);
	      }      
	      return list;
	   }


	   //멤버 등급변경
	   public int changeLevel(Connection conn, int memberNo, int memberLevel) {
	      PreparedStatement pstmt = null;
	      int result = 0;
	      String query ="update member_tbl set member_grade=? where member_no=?";
	      try {
	         pstmt = conn.prepareStatement(query);
	         pstmt.setInt(1, memberLevel);
	         pstmt.setInt(2, memberNo);
	         result = pstmt.executeUpdate();
	      } catch (SQLException e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	      }finally {
	         JDBCTemplate.close(pstmt);
	      }
	      return result;
	   }

	
	
	
	
	
	
	
	
	
	
	public Member checkEmail(Connection conn, String email) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Member m = null;
		String query = "select member_id, enroll_date from member_tbl where member_email = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, email);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				m = new Member();
				m.setMemberId(rset.getString("member_id"));
				m.setEnrollDate(rset.getString("enroll_date"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rset);
		}
		
		return m;
	}
	
	public String checkId(Connection conn, String inputId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String result = "false";
		String query = "select member_no from member_tbl where member_id = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, inputId);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				result = "true";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rset);
		}
		
		return result;
	}
	
	public int changePw(Connection conn, String id, String pw) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "update member_tbl set member_pw = ? where member_id = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, pw);
			pstmt.setString(2, id);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}	
	
	
	
	
}


























