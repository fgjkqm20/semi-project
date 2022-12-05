package nbd.counsel.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.JDBCTemplate;
import nbd.counsel.model.vo.Counsel;
import nbd.counsel.model.vo.CounselComment;

public class CounselDao {
	public ArrayList<Counsel> selectSubjectList(Connection conn, String counselSubject, int start, int end) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Counsel> list = new ArrayList<>();
		String query;
		if(counselSubject.equals("전체")) {
			query = "select * from("
					+ "(select rownum as rnum, n.* from("
					+ "select * from health_counsel_tbl "
					+ "order by counsel_no desc)n)) "
					+ "where rnum between ? and ?";
		}else {
			query = "select * from("
					+ "(select rownum as rnum, n.* from("
					+ "select * from health_counsel_tbl "
					+ "where counsel_subject = ? "
					+ "order by counsel_no desc)n)) "
					+ "where rnum between ? and ?";
		}
		
		try {
			pstmt = conn.prepareStatement(query);
			if(counselSubject.equals("전체")) {
				pstmt.setInt(1, start);
				pstmt.setInt(2, end);
			}else {
				pstmt.setString(1, counselSubject);
				pstmt.setInt(2, start);
				pstmt.setInt(3, end);
			}

			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Counsel c = new Counsel();
				c.setCounselNo(rset.getInt("counsel_no"));
				c.setCounselSubject(rset.getString("counsel_subject"));
				c.setCounselTitle(rset.getString("counsel_title"));
				c.setCounselDate(rset.getString("counsel_date"));
				c.setMemberId(rset.getString("member_id"));
				c.setCounselAnswer(rset.getInt("counsel_answer"));
				list.add(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rset);
		}
		
		return list;
	}

	public int selectSubjectListCount(Connection conn, String counselSubject) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int totalCount = 0;
		String query;
		if(counselSubject.equals("전체")) {
			query = "select count(*) as cnt from health_counsel_tbl";
		} else {
			query = "select count(*) as cnt from health_counsel_tbl "
					+ "where counsel_subject = ?";
		}
		
		try {
			pstmt = conn.prepareStatement(query);
			if(!counselSubject.equals("전체")) {
				pstmt.setString(1, counselSubject);
			}
			rset = pstmt.executeQuery();
			if(rset.next()) {
				totalCount = rset.getInt("cnt");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rset);
		}
		
		return totalCount;
	}

	public ArrayList<Counsel> titleSearch(Connection conn, String searchWord, int start, int end) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Counsel> list = new ArrayList<>();
		String query = "select * from("
					+ "(select rownum as rnum, n.* from("
					+ "select * from health_counsel_tbl "
					+ "where counsel_title like ? "
					+ "order by counsel_no desc)n)) "
					+ "where rnum between ? and ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%" + searchWord + "%");
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);

			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Counsel c = new Counsel();
				c.setCounselNo(rset.getInt("counsel_no"));
				c.setCounselSubject(rset.getString("counsel_subject"));
				c.setCounselTitle(rset.getString("counsel_title"));
				c.setCounselDate(rset.getString("counsel_date"));
				c.setMemberId(rset.getString("member_id"));
				c.setCounselAnswer(rset.getInt("counsel_answer"));
				list.add(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rset);
		}
		
		return list;
	}

	public int titleSearchCount(Connection conn, String searchWord) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int totalCount = 0;
		String query = "select count(*) as cnt from health_counsel_tbl "
					+ "where counsel_title like ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%" + searchWord + "%");
			rset = pstmt.executeQuery();
			if(rset.next()) {
				totalCount = rset.getInt("cnt");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rset);
		}
		
		return totalCount;
	}

	public int insertCounsel(Connection conn, Counsel c) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "insert into health_counsel_tbl values(?, counsel_seq.nextval, ?, ?, 0, to_char(SYSDATE, 'YYYY-MM-DD'), 0, ?, ?, ?)";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, c.getMemberId());
			pstmt.setString(2, c.getCounselTitle());
			pstmt.setString(3, c.getCounselContent());
			pstmt.setString(4, c.getFilePath());
			pstmt.setString(5, c.getFileName());
			pstmt.setString(6, c.getCounselSubject());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

	public int updateCounselCount(Connection conn, int counselNo) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "update health_counsel_tbl set counsel_count = counsel_count+1 where counsel_no = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, counselNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

	public Counsel selectOneCounsel(Connection conn, int counselNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Counsel c = null;
		String query = "select * from health_counsel_tbl where counsel_no = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, counselNo);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				c = new Counsel();
				c.setMemberId(rset.getString("member_id"));
				c.setCounselNo(rset.getInt("counsel_no"));
				c.setCounselTitle(rset.getString("counsel_title"));
				c.setCounselContent(rset.getString("counsel_content"));
				c.setCounselCount(rset.getInt("counsel_count"));
				c.setCounselDate(rset.getString("counsel_date"));
				c.setCounselAnswer(rset.getInt("counsel_answer"));
				c.setFilePath(rset.getString("filepath"));
				c.setFileName(rset.getString("filename"));
				c.setCounselSubject(rset.getString("counsel_subject"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return c;
	}
	
	public CounselComment selectCounselComment(Connection conn, int counselNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		CounselComment comment = null;
		String query = "select comment_no, nvl(comment_writer_no, -1) "
				+ "as comment_writer_no, comment_writer_name, "
				+ "comment_content, comment_date, counsel_no "
				+ "from counsel_com_tbl where counsel_no = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, counselNo);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				comment = new CounselComment();
				comment.setCommentNo(rset.getInt("comment_no"));
				comment.setCommentWriterNo(rset.getInt("comment_writer_no"));
				comment.setCommentWriterName(rset.getString("comment_writer_name"));
				comment.setCommentContent(rset.getString("comment_content"));
				comment.setCommentDate(rset.getString("comment_date"));
				comment.setCounselNo(rset.getInt("counsel_no"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rset);
		}
		
		return comment;
	}

	public int insertComment(Connection conn, CounselComment cc) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "insert into counsel_com_tbl "
				+ "values(counsel_com_seq.nextval, "
				+ "?, ?, ?, to_char(sysdate, 'yyyy-mm-dd'), ?)";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, cc.getCommentWriterNo());
			pstmt.setString(2, cc.getCommentWriterName());
			pstmt.setString(3, cc.getCommentContent());
			pstmt.setInt(4, cc.getCounselNo());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

	public int updateCounselAnswer(Connection conn, int counselNo) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "update health_counsel_tbl set counsel_answer = 1 where counsel_no = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, counselNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

	public int modifyCounsel(Connection conn, Counsel c) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "update health_counsel_tbl set counsel_title = ?, "
				+ "counsel_content = ?, filename = ?, "
				+ "filepath = ?, counsel_subject = ?"
				+ "where counsel_no = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, c.getCounselTitle());
			pstmt.setString(2, c.getCounselContent());
			pstmt.setString(3, c.getFileName());
			pstmt.setString(4, c.getFilePath());
			pstmt.setString(5, c.getCounselSubject());
			pstmt.setInt(6, c.getCounselNo());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

	public int deleteCounsel(Connection conn, int counselNo) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "delete from health_counsel_tbl where counsel_no = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, counselNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int deleteComment(Connection conn, int commentNo) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "delete from counsel_com_tbl where comment_no = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, commentNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

	public int updateComment(Connection conn, CounselComment cc) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "update counsel_com_tbl "
				+ "set comment_content = ? "
				+ "where comment_no = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, cc.getCommentContent());
			pstmt.setInt(2, cc.getCommentNo());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}
	
	
	public ArrayList<Counsel> getMyQuestion(Connection conn, String memberId, int startNum, int endNum) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Counsel> clist = new ArrayList<Counsel>();
		
		String query = "SELECT R.* FROM (SELECT ROWNUM RNUM, COUNSEL_NO, COUNSEL_TITLE, COUNSEL_DATE, COUNSEL_ANSWER, COUNSEL_SUBJECT FROM (SELECT * FROM HEALTH_COUNSEL_TBL WHERE MEMBER_ID=? ORDER BY COUNSEL_NO DESC))R WHERE RNUM BETWEEN ? AND ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, memberId);
			pstmt.setInt(2, startNum);
			pstmt.setInt(3, endNum);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Counsel c = new Counsel();
				c.setCounselTitle(rset.getString("COUNSEL_TITLE"));
				c.setCounselDate(rset.getString("COUNSEL_DATE"));
				c.setCounselAnswer(rset.getInt("COUNSEL_ANSWER"));
				c.setCounselSubject(rset.getString("COUNSEL_SUBJECT"));
				c.setCounselNo(rset.getInt("COUNSEL_NO"));
				System.out.println(c.getCounselTitle());
				clist.add(c);
			}
			
			if(clist.isEmpty()) {
				System.out.println();
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return clist;
	}
	
	
	// 의사 입장에서 내가 댓글을 단 게시물 목록을 가져오기
	public ArrayList<Counsel> getMyAnswer(Connection conn, int memberNo, int startNum, int endNum) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Counsel> clist = new ArrayList<Counsel>();
		String query = "SELECT RNUM, COUNSEL_TITLE, COUNSEL_SUBJECT, COUNSEL_DATE, COUNSEL_NO FROM (SELECT ROWNUM AS RNUM, R.* "
					+"FROM (SELECT * FROM HEALTH_COUNSEL_TBL "
					+"LEFT JOIN COUNSEL_COM_TBL USING (COUNSEL_NO) "
					+"WHERE COMMENT_WRITER_NO = ? ORDER BY COUNSEL_NO DESC)R) WHERE RNUM BETWEEN ? AND ?";
				
				try {
					pstmt = conn.prepareStatement(query);
					pstmt.setInt(1, memberNo);
					pstmt.setInt(2, startNum);
					pstmt.setInt(3, endNum);
					rset = pstmt.executeQuery();
					
					while(rset.next()) {
						Counsel c = new Counsel();
						c.setCounselTitle(rset.getString("COUNSEL_TITLE"));
						c.setCounselDate(rset.getString("COUNSEL_DATE"));
						c.setCounselSubject(rset.getString("COUNSEL_SUBJECT"));
						c.setCounselNo(rset.getInt("COUNSEL_NO"));
						clist.add(c);
					}
					
					if(clist.isEmpty()) {
						System.out.println();
					}
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {
					JDBCTemplate.close(rset);
					JDBCTemplate.close(pstmt);
				}
				
				return clist;
	}
	
	
	
	
}
