package nbd.qna.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.JDBCTemplate;
import nbd.qna.model.vo.Qna;
import nbd.qna.model.vo.QnaComment;

public class QnaDao {

	   //게시글 몇개 몇개 가져올껀지 
	   public ArrayList<Qna> selectQnaList(Connection conn, int start, int end) {
	      // TODO Auto-generated method stub
	      PreparedStatement pstmt = null;
	      ResultSet rset = null;
	      ArrayList<Qna> list = new ArrayList<Qna>();
	      //10개씩 짤라오면서 댓글가져오기 
	      String query ="select * from (select rownum as rnum,n.*from (select * from HEALTH_INFO_TBL join (select info_no,(select count(*) from health_info_com_tbl ic where ic.info_no=info.info_no ) as commentCount from health_info_tbl info)a using (info_no) order by INFO_NO desc)n)where rnum between ? and ?";
//	            "select*from (select rownum as rnum,n.*from(select * from HEALTH_INFO_TBL order by INFO_NO desc)n)where rnum between ? and ?";
	            //"select info_no, info_title,info_content,info_count,(select count(*) from health_info_com_tbl ic where ic.info_no=info.info_no ) as commentCount from health_info_tbl info";
	      try {
	         pstmt = conn.prepareStatement(query);
	         pstmt.setInt(1, start);
	         pstmt.setInt(2, end);
	         rset = pstmt.executeQuery();
	         while(rset.next()) {
	            Qna q = new Qna();
	            q.setMemberId(rset.getString("member_id"));
	            q.setInfoNo(rset.getInt("info_no"));
	            q.setInfoTitle(rset.getString("info_title"));
	            q.setInfoContent(rset.getString("info_content"));
	            q.setInfoCount(rset.getInt("info_count"));
	            q.setInfoDate(rset.getString("info_date"));
	            q.setFilePath(rset.getString("FILEPATH"));
	            q.setFileName(rset.getString("FILENAME"));
	            q.setCommentCnt(rset.getInt("commentcount"));//댓글추가
	            list.add(q);
	         }
	      } catch (SQLException e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	      }finally {
	         JDBCTemplate.close(rset);
	         JDBCTemplate.close(pstmt);
	      }
	      return list;
	   }

	//등록된 게시물 전체 수 
	public int selectQnaCount(Connection conn) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int totalCount = 0;
		String query = "select count(*) as cnt from HEALTH_INFO_TBL"; //등록한 게시물 전체 갯수가 몇개인지
		
		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				totalCount = rset.getInt("cnt"); // 별칭
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rset);
		}
		return totalCount;
	}

	//게시글 읽었을때 조회수 
	public int updateReadCount(Connection conn, int infoNo) {
		PreparedStatement pstmt = null;
		
		int result=0;
		
		String query="update HEALTH_INFO_TBL set INFO_COUNT = INFO_COUNT+1 where info_no=?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, infoNo);
			result=pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	//일반댓글조회
	public ArrayList<QnaComment> selectQnaCommentList(Connection conn, int infoNo) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt=null;
		ResultSet rset= null;
		ArrayList<QnaComment> list = new ArrayList<QnaComment>();
		String query = "select * from HEALTH_INFO_COM_TBL where info_no=? order by 3";
		
		try {
			pstmt=conn.prepareStatement(query);
			pstmt.setInt(1, infoNo);
			rset=pstmt.executeQuery();
			while(rset.next()) {
				QnaComment qc = new QnaComment();
				qc.setInfoNo(rset.getInt("info_no"));
				qc.setMemberId(rset.getString("member_id"));
				qc.setCommentNo(rset.getInt("comment_no"));
				qc.setCommentContent(rset.getString("comment_content"));
				qc.setCommentDate(rset.getString("comment_date"));
				list.add(qc);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}
	//조회
	public Qna selectOneQna(Connection conn, int infoNo) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Qna q = null;
		String query="select * from HEALTH_INFO_TBL where info_no=?";
		
		try {
			pstmt=conn.prepareStatement(query);
			pstmt.setInt(1, infoNo);
			rset=pstmt.executeQuery();
			if(rset.next()) {
				q= new Qna();
				q.setMemberId(rset.getString("member_id"));
				q.setInfoNo(rset.getInt("info_no"));
				q.setInfoTitle(rset.getString("info_title"));
				q.setInfoContent(rset.getString("info_content"));
				q.setInfoCount(rset.getInt("info_count"));
				q.setInfoDate(rset.getString("info_date"));
				q.setFilePath(rset.getString("FILEPATH"));
				q.setFileName(rset.getString("FILENAME"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return q;
	}

	//Qna 게시판글쓰기
	public int insertQna(Connection conn, Qna q) {
		PreparedStatement pstmt = null;
		int result =0;
		String query="insert into HEALTH_INFO_TBL values(?,HEALTH_INFO_SEQ.nextval, ?,?, 0,to_char(sysdate,'yyyy-mm-dd'),?,?) ";
		
		try {
			pstmt=conn.prepareStatement(query);
			pstmt.setString(1,q.getMemberId());
			pstmt.setString(2,q.getInfoTitle());
			pstmt.setString(3,q.getInfoContent());
			pstmt.setString(4,q.getFilePath());
			pstmt.setString(5,q.getFileName());
			result=pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	//게시글 수정
	public int updateQna(Connection conn, Qna q) {
		PreparedStatement pstmt = null;
		int result=0;
		String query="update HEALTH_INFO_TBL set info_title=?, info_content=?, filename=?, filepath=? where info_no=?";
		try {
			pstmt=conn.prepareStatement(query);
			pstmt.setString(1, q.getInfoTitle());
			pstmt.setString(2, q.getInfoContent());
			pstmt.setString(3,q.getFileName());
			pstmt.setString(4,q.getFilePath());
			pstmt.setInt(5, q.getInfoNo());
			result=pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
	//게시글 삭제
	public int deleteQna(Connection conn, int infoNo) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query= "delete from HEALTH_INFO_TBL where info_no=?";
		
		try {
			pstmt=conn.prepareStatement(query);
			pstmt.setInt(1, infoNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	//댓글 작성
	public int insertQnaComment(Connection conn, QnaComment qc) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt=null;
		int result=0;
		String query ="insert into HEALTH_INFO_COM_TBL values(?,?,HEALTH_INFO_COM_SEQ.nextval,?,to_char(sysdate,'yyyy-mm-dd'))";
		 
		try {
			pstmt=conn.prepareStatement(query);
			pstmt.setString(1, qc.getMemberId());
			pstmt.setInt(2, qc.getInfoNo());
			pstmt.setString(3, qc.getCommentContent());
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	//댓글삭제
	public int deleteQnaComment(Connection conn, int commentNo) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		int result=0;
		String query = "delete from HEALTH_INFO_COM_TBL where comment_no=?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, commentNo);
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
	
	//댓글 수정
	public int updateQnaComment(Connection conn, QnaComment qc) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		int result=0;
		String query="update HEALTH_INFO_COM_TBL set COMMENT_CONTENT=? where COMMENT_NO=?";
		
		try {
			pstmt=conn.prepareStatement(query);
			pstmt.setString(1, qc.getCommentContent());
			pstmt.setInt(2, qc.getCommentNo());
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


















