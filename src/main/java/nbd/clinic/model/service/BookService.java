package nbd.clinic.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import common.JDBCTemplate;
import nbd.clinic.model.dao.BookDao;
import nbd.clinic.model.vo.Book;

public class BookService {
	private BookDao dao;

	public BookService() {
		super();
		dao = new BookDao();
	}

	public ArrayList<Book> selectAllPatient() {
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<Book> list = dao.selectAllPatient(conn);
		JDBCTemplate.close(conn);
		return list;
	}

	public int insertPrice(Book b) {
		Connection conn = JDBCTemplate.getConnection();
		int result = dao.insertPrice(conn, b);
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public int changeStatus(Book b) {
		Connection conn = JDBCTemplate.getConnection();
		int result = dao.changeStatus(conn, b);
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public int sendDrug(int memberNo) {
		Connection conn = JDBCTemplate.getConnection();
		int result = dao.sendDrug(conn, memberNo);
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;

	}
}
