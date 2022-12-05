package nbd.clinic.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.JDBCTemplate;
import nbd.clinic.model.vo.Book;
import nbd.clinic.model.vo.MyClinic;
import nbd.member.model.vo.Doctor;

public class ClinicDao {

	public ArrayList<Doctor> selectAllDoctor(Connection conn, String doctorMajor) {
		PreparedStatement pstmt = null;
		ResultSet rset= null;
		ArrayList<Doctor> list = new ArrayList<Doctor>();
		String query = "SELECT * FROM doctor_tbl JOIN member_tbl ON (doctor_no = member_no) where doctor_major = ?";
		System.out.println(doctorMajor);
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, doctorMajor);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Doctor d= new Doctor();
				d.setDoctorNo(rset.getInt("doctor_no"));
				d.setDoctorMajor(rset.getString("doctor_major"));
				d.setHospitalName(rset.getString("hospital_name"));
				d.setDoctorAvgStar(rset.getInt("doctor_star"));
				d.setDoctorId(rset.getString("doctor_id"));
				d.setHospitalAddr(rset.getString("hospital_addr"));
				d.setDoctorName(rset.getString("member_name"));
				list.add(d);
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

	public Doctor selectOneDoctor(Connection conn, int doctorNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Doctor doctor = null;
		String query = "SELECT * FROM doctor_tbl JOIN member_tbl ON (doctor_no = member_no) where doctor_no = ?";
		try {
			pstmt=conn.prepareStatement(query);
			pstmt.setInt(1, doctorNo);
			rset = pstmt.executeQuery();
			if(rset.next()) {
			doctor = new Doctor();
			doctor.setDoctorAvgStar(rset.getInt("doctor_star"));
			doctor.setDoctorId(rset.getString("doctor_id"));
			doctor.setHospitalName(rset.getString("hospital_name"));
			doctor.setDoctorMajor(rset.getString("doctor_major"));
			doctor.setDoctorNo(rset.getInt("doctor_no"));
			doctor.setDoctorName(rset.getString("member_name"));
			doctor.setHospitalAddr(rset.getString("hospital_addr"));
			doctor.setDoctorPhoto(rset.getString("member_photo"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rset);
		}
		return doctor;
	}

	public Doctor reservationStep(Connection conn,int docNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Doctor doctor = new Doctor();
		String query = "SELECT * FROM doctor_tbl JOIN member_tbl ON (doctor_no = member_no) where doctor_no = ?";
		try {
			pstmt=conn.prepareStatement(query);
			pstmt.setInt(1, docNo);
			rset = pstmt.executeQuery();
			if(rset.next()) {
			doctor.setDoctorNo(rset.getInt("doctor_no"));
			doctor.setDoctorId(rset.getString("doctor_id"));
			doctor.setHospitalName(rset.getString("hospital_name"));
			doctor.setDoctorMajor(rset.getString("doctor_major"));
			doctor.setDoctorName(rset.getString("member_name"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rset);
		}
		return doctor;
	}

	public int insertReserve(Connection conn, Book book) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = "insert into book_tbl values(?, BOOK_TBL_SEQ.nextval, ?, ?, ?, ?, 1, 0, null, ?, ?, ?)";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, book.getMemberNo());
			pstmt.setString(2, book.getBookDate());
			pstmt.setString(3, book.getBookTime());
			pstmt.setString(4, book.getBookDoctor());
			pstmt.setString(5, book.getBookHistory());
			pstmt.setString(6, book.getDoctorMajor());
			pstmt.setString(7, book.getHospitalAddr());
			pstmt.setString(8, book.getHospitalName());
			
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

	
	
	//은비
	// 나의 멤버 번호를 보내면 내 진료 내역 불러오는 쿼리
	public ArrayList<MyClinic> getMyReserve(Connection conn, int memberNo, int startNum, int endNum) {
		// select rownum, book_no, hospital_name, doctor_major, book_date, member_state from book_tbl join doctor_tbl on (doctor_no=BOOK_DOCTOR) where member_no=117 and rownum between 1 and 3 order by book_no desc;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<MyClinic> rlist = new ArrayList<MyClinic>();
		String query = "SELECT * FROM "
				+ "(SELECT ROWNUM AS RNUM, R.* FROM "
				+ "(SELECT B.BOOK_NO, B.HOSPITAL_NAME, D.DOCTOR_MAJOR, B.BOOK_DATE, B.MEMBER_STATE, B.MEMBER_NO FROM BOOK_TBL B "
				+ "LEFT JOIN DOCTOR_TBL D ON (D.DOCTOR_ID = B.BOOK_DOCTOR) "
				+ "WHERE MEMBER_NO=? ORDER BY BOOK_NO DESC)R) WHERE RNUM BETWEEN ? AND ?";

			try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, memberNo);
			pstmt.setInt(2, startNum);
			pstmt.setInt(3, endNum);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				MyClinic mc = new MyClinic();
				mc.setBookDate(rset.getString("book_date"));
				mc.setBookNo(rset.getInt("book_no"));
				mc.setDoctorMajor(rset.getString("doctor_major"));
				mc.setHospitalName(rset.getString("hospital_name"));
				mc.setMemberState(rset.getInt("member_state"));
				rlist.add(mc);
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

	public MyClinic getMyClinicDetail(Connection conn, int bookNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		MyClinic mc = null;
		
		String query = "SELECT B.BOOK_NO, B.MEMBER_STATE, B.BOOK_PHARM_NO, B.BOOK_DATE, B.BOOK_HISTORY, B.BOOK_PRICE, B.HOSPITAL_NAME, B.HOSPITAL_ADDR, "
				+"B.DOCTOR_MAJOR, M.MEMBER_NAME, P.PHARM_TITLE, P.PHARM_USEADDR, P.PHARM_PHONE, M.MEMBER_ID AS DOCTOR_ID "
				+"FROM BOOK_TBL B "
				+"LEFT JOIN MEMBER_TBL M ON (M.MEMBER_ID=B.BOOK_DOCTOR) "
				+"LEFT JOIN PHARMACIST_TBL P ON (P.PHARM_NO=B.BOOK_PHARM_NO) " 
				+"WHERE B.BOOK_NO = ? ";
				
				try {
					pstmt = conn.prepareStatement(query);
					pstmt.setInt(1, bookNo);
					rset = pstmt.executeQuery();
					if(rset.next()) {
						mc = new MyClinic();
						mc.setBookDate(rset.getString("book_date"));
						mc.setBookHistory(rset.getString("book_history"));
						mc.setBookNo(rset.getInt("book_no"));
						mc.setBookPrice(rset.getInt("book_price"));
						mc.setDoctorMajor(rset.getString("doctor_major"));
						mc.setHospitalName(rset.getString("hospital_name"));
						mc.setMemberState(rset.getInt("member_state"));
						mc.setPharmNo(rset.getInt("book_pharm_no"));
						mc.setDoctorName(rset.getString("member_name"));
						mc.setPharmAddr(rset.getString("pharm_useaddr"));
						mc.setPharmPhone(rset.getString("pharm_phone"));
						mc.setPharmTitle(rset.getString("pharm_title"));
						mc.setDoctorId(rset.getString("doctor_id"));
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {
					JDBCTemplate.close(rset);
					JDBCTemplate.close(pstmt);
				}
		return mc;
	}

	public int getReviewResult(Connection conn, int bookNo) {
		// select count(*) from doctor_review_tbl where book_no=?;
		int result = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select count(*) as cnt from doctor_review_tbl where book_no=?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, bookNo);
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

	public ArrayList<MyClinic> getMyReserve(Connection conn, int memberNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<MyClinic> rlist = new ArrayList<MyClinic>();
		String query = "SELECT * FROM (SELECT B.MEMBER_NO, B.BOOK_NO, B.BOOK_DATE, B.MEMBER_STATE, M.MAJOR, M.MEMBER_NAME AS DOCTOR_NAME, B.BOOK_TIME "
				+"FROM BOOK_TBL B "
				+"LEFT JOIN MEMBER_TBL M ON (M.MEMBER_ID = B.BOOK_DOCTOR)) WHERE MEMBER_NO = ?";

		
			try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, memberNo);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				MyClinic mc = new MyClinic();
				mc.setBookDate(rset.getString("BOOK_DATE"));
				mc.setBookNo(rset.getInt("BOOK_NO"));
				mc.setDoctorMajor(rset.getString("MAJOR"));
				mc.setHospitalName(rset.getString("BOOK_TIME"));
				mc.setMemberState(rset.getInt("MEMBER_STATE"));
				mc.setDoctorName(rset.getString("doctor_name"));
				rlist.add(mc);
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


	public ArrayList<Book> bookList(Connection conn, int memberNo) {
      
      PreparedStatement pstmt = null;
      ResultSet rset = null;
      
      ArrayList<Book> bookList = new ArrayList<Book>();
      String query = "select * from book_tbl where member_no = ?";
      
      try {
         pstmt = conn.prepareStatement(query);
         pstmt.setInt(1, memberNo);
         
         rset = pstmt.executeQuery();
         while(rset.next()) {
            Book book = new Book();
            book.setMemberNo(rset.getInt("member_no"));
            book.setBookNo(rset.getInt("book_no"));
            book.setBookDate(rset.getString("book_date"));
            book.setBookTime(rset.getString("book_time"));
            book.setBookDoctor(rset.getString("book_doctor"));
            book.setBookHistory(rset.getString("book_history"));
            book.setMemberState(rset.getInt("member_state"));
            book.setBookPrice(rset.getInt("book_price"));
            book.setDoctorMajor(rset.getString("doctor_major"));
            book.setHospitalAddr(rset.getString("hospital_addr"));
            book.setHospitalName(rset.getString("hospital_name"));
            bookList.add(book);
         }
      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      } finally {
         JDBCTemplate.close(pstmt);
         JDBCTemplate.close(rset);
      }
      
      return bookList;
   }
	
public Book reservationView(Connection conn, int bookNo) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		Book book = null;
		String qeury = "select * from book_tbl where book_no = ?";
		
		try {
			pstmt = conn.prepareStatement(qeury);
			pstmt.setInt(1, bookNo);
			
			rset = pstmt.executeQuery();
			if(rset.next()) {
				book = new Book();
				book.setMemberNo(rset.getInt("member_no"));
				book.setBookNo(rset.getInt("book_no"));
				book.setBookDate(rset.getString("book_date"));
				book.setBookTime(rset.getString("book_time"));
				book.setBookDoctor(rset.getString("book_doctor"));
				book.setBookHistory(rset.getString("book_history"));
				book.setMemberState(rset.getInt("member_state"));
				book.setBookPrice(rset.getInt("book_price"));
				book.setDoctorMajor(rset.getString("doctor_major"));
				book.setHospitalAddr(rset.getString("hospital_addr"));
				book.setHospitalName(rset.getString("hospital_name"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rset);
		}
		
		return book;
	}

	public String doctorName(Connection conn, String bookDoctor) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String docName = null;
		
		String query = "select member_name from member_tbl join book_tbl on (member_id = book_doctor) where member_id = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, bookDoctor);
			
			rset = pstmt.executeQuery();
			if(rset.next()) {
				docName = rset.getString("member_name");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return docName;
	}

	
	
}














