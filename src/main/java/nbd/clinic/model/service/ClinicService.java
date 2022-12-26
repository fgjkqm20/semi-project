package nbd.clinic.model.service;

import java.sql.Connection;
import java.util.ArrayList;
import common.JDBCTemplate;
import nbd.clinic.model.dao.ClinicDao;
import nbd.clinic.model.vo.Book;
import nbd.clinic.model.vo.MyClinic;
import nbd.member.model.vo.Doctor;

public class ClinicService {
    private ClinicDao dao;

    public ClinicService() {
        super();
        // TODO Auto-generated constructor stub
        dao = new ClinicDao();
    }

    public ArrayList<Doctor> selectAllDoctor(String doctorMajor) {
        Connection conn = JDBCTemplate.getConnection();
        ArrayList<Doctor> list = dao.selectAllDoctor(conn, doctorMajor);
        JDBCTemplate.close(conn);
        return list;
    }

    public Doctor selectOneDoctor(int doctorNo) {
        Connection conn = JDBCTemplate.getConnection();
        Doctor doctor = dao.selectOneDoctor(conn, doctorNo);
        JDBCTemplate.close(conn);
        return doctor;
    }

    public Doctor reservationStep(int docNo) {
        Connection conn = JDBCTemplate.getConnection();
        Doctor doctor = dao.reservationStep(conn, docNo);
        JDBCTemplate.close(conn);
        return doctor;
    }

    public int insertReserve(Book book) {

        Connection conn = JDBCTemplate.getConnection();
        int result = dao.insertReserve(conn, book);

        if (result > 0) {
            JDBCTemplate.commit(conn);
        } else {
            JDBCTemplate.rollback(conn);
        }

        return result;
    }



    // 은비
    public ArrayList<MyClinic> getMyReserve(int memberNo, int startNum, int endNum) {
        Connection conn = JDBCTemplate.getConnection();
        ArrayList<MyClinic> rlist = dao.getMyReserve(conn, memberNo, startNum, endNum);
        JDBCTemplate.close(conn);
        return rlist;
    }

    public MyClinic getMyClinicDetail(int bookNo) {
        // select * from book_tbl;
        Connection conn = JDBCTemplate.getConnection();
        MyClinic mc = dao.getMyClinicDetail(conn, bookNo);
        JDBCTemplate.close(conn);
        return mc;
    }

    public int getReviewResult(int bookNo) {
        // select count(*) from doctor_review_tbl where book_no=5;4
        Connection conn = JDBCTemplate.getConnection();
        int result = dao.getReviewResult(conn, bookNo);
        JDBCTemplate.close(conn);
        return result;
    }

    public ArrayList<MyClinic> getMyAllReserve(int memberNo) {
        Connection conn = JDBCTemplate.getConnection();
        ArrayList<MyClinic> rlist = dao.getMyReserve(conn, memberNo);
        JDBCTemplate.close(conn);
        return rlist;
    }

    public ArrayList<Book> bookList(int memberNo) {
        Connection conn = JDBCTemplate.getConnection();
        ArrayList<nbd.clinic.model.vo.Book> bookList = dao.bookList(conn, memberNo);
        JDBCTemplate.close(conn);
        return bookList;
    }

    /*
     * public ArrayList<Book> bookList(int memberNo) {
     * 
     * Connection conn = JDBCTemplate.getConnection(); ArrayList<Book> bookList = dao.bookList(conn,
     * memberNo);
     * 
     * JDBCTemplate.close(conn);
     * 
     * return bookList; }
     */

    public Book reservationView(int bookNo) {

        Connection conn = JDBCTemplate.getConnection();
        Book bookView = dao.reservationView(conn, bookNo);

        String docName = dao.doctorName(conn, bookView.getBookDoctor());

        bookView.setDocName(docName);

        JDBCTemplate.close(conn);

        return bookView;
    }



}


