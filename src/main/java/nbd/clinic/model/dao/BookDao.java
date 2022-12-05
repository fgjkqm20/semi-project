package nbd.clinic.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.JDBCTemplate;
import nbd.clinic.model.vo.Book;

public class BookDao {

	public ArrayList<Book> selectAllPatient(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Book> list = new ArrayList<Book>();
		String query = "SELECT BOOK_NO, MEMBER_NO, BOOK_DOCTOR, "
				+ "(SELECT M.MEMBER_NAME FROM MEMBER_TBL M WHERE M.MEMBER_NO=B.MEMBER_NO) AS MEMBER_NAME, "
				+ "(SELECT M.MEMBER_PHONE FROM MEMBER_TBL M WHERE M.MEMBER_NO=B.MEMBER_NO) AS MEMBER_PHONE,"
				+ "(SELECT M. MEMBER_PHOTO FROM MEMBER_TBL M WHERE M.MEMBER_NO=B.MEMBER_NO) AS MEMBER_PHOTO,"
				+ "(SELECT SUBSTR(M.MEMBER_BIRTH, 0, 2) FROM MEMBER_TBL M WHERE M.MEMBER_NO=B.MEMBER_NO) AS MEMBER_BIRTH,"
				+ "BOOK_DATE, BOOK_TIME, BOOK_HISTORY, MEMBER_STATE  FROM BOOK_TBL B";
				
		
		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Book m= new Book();
				m.setMemberNo(rset.getInt("member_no"));
				m.setBookNo(rset.getInt("book_no"));
				m.setMemberState(rset.getInt("member_state"));
				m.setBookTime(rset.getString("book_time"));
				m.setBookHistory(rset.getString("book_history"));
				m.setBookDate(rset.getString("book_date"));
				m.setMemberAge(rset.getString("member_birth"));
				m.setMemberName(rset.getString("member_name"));
				m.setMemberPhoto(rset.getString("member_photo"));
				m.setMemberPhone(rset.getString("member_phone"));
				m.setBookDoctor(rset.getString("BOOK_DOCTOR"));
				list.add(m);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}

	public int insertPrice(Connection conn, Book b) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query = "update book_tbl set book_price = ?, member_state=5 where member_no=?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, b.getBookPrice());
			pstmt.setInt(2,b.getMemberNo());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int changeStatus(Connection conn, Book b) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query = "update book_tbl set MEMBER_STATE=? where book_no=?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, b.getMemberState());
			pstmt.setInt(2, b.getBookNo());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int sendDrug(Connection conn, int memberNo) {
		int result =0;
		PreparedStatement pstmt = null;
		String query = "update book_tbl set MEMBER_STATE=4 where member_no=?";
		
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
}

















































