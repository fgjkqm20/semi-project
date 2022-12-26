package nbd.qna.model.service;

import java.sql.Connection;
import java.util.ArrayList;
import common.JDBCTemplate;
import nbd.qna.model.dao.QnaDao;
import nbd.qna.model.vo.Qna;
import nbd.qna.model.vo.QnaComment;
import nbd.qna.model.vo.QnaPageData;
import nbd.qna.model.vo.QnaViewData;

public class QnaService {

    private QnaDao dao;

    public QnaService() {
        super();
        // TODO Auto-generated constructor stub
        dao = new QnaDao();
    }

    // Qna게시글 list 불러오기
    public QnaPageData selectQnaList(int reqPage) {
        // TODO Auto-generated method stub
        Connection conn = JDBCTemplate.getConnection();
        // 한페이지 당 게시물 수 지정 -> 10개
        int numPerPage = 10;

        int end = numPerPage * reqPage; // 시작페이지 끝번호
        int start = end - numPerPage + 1; // 시작페이지

        ArrayList<Qna> list = dao.selectQnaList(conn, start, end); // db조회

        int totalCount = dao.selectQnaCount(conn);

        // 전체페이지 수
        int totalPage = 0;
        if (totalCount % numPerPage == 0) {
            totalPage = totalCount / numPerPage;
        } else {
            totalPage = totalCount / numPerPage + 1;
        }

        // 지정해줘야할 값 페이지
        int pageNaviSize = 5;

        int pageNo = ((reqPage - 1) / pageNaviSize) * pageNaviSize + 1;

        String pageNavi = "<ul class='pagination'>";

        // 이전버튼
        if (pageNo != 1) {
            pageNavi += "<li>";
            pageNavi += "<a class='page-item' href=/qnaList.do?reqPage=" + (pageNo - 1) + ">";
            pageNavi += "<span>&lt;</span>";
            pageNavi += "</a></li>";
        }
        // 페이지숫자
        // 반복문 5개씩 만들기 위해서
        for (int i = 0; i < pageNaviSize; i++) {
            if (pageNo == reqPage) {
                pageNavi += "<li>";
                pageNavi += "<a class='page-item active-page' href='/qnaList.do?reqPage=" + pageNo
                        + "'>";
                pageNavi += pageNo;
                pageNavi += "</a></li>";
            } else {
                pageNavi += "<li>";
                pageNavi += "<a class='page-item' href='/qnaList.do?reqPage=" + pageNo + "'>";
                pageNavi += pageNo;
                pageNavi += "</a></li>";
            }
            pageNo++;
            if (pageNo > totalPage) {
                break;
            }
        }
        // 다음버튼
        if (pageNo <= totalPage) {
            pageNavi += "<li>";
            pageNavi += "<a class='page-item' href='/qnaList.do?reqPage=" + pageNo + "'>";
            pageNavi += "<span>&gt;</span>";
            pageNavi += "</a></li>";
        }
        pageNavi += "</ul>";
        QnaPageData qpd = new QnaPageData(list, pageNavi);
        JDBCTemplate.close(conn);

        return qpd;
    }

    // 게시글 제목 클릭했을때 조회
    public QnaViewData selectOneQna(int infoNo) {
        Connection conn = JDBCTemplate.getConnection();
        // 게시글 제목 누르면서 조회수가 하나 올라감
        int result = dao.updateReadCount(conn, infoNo);
        // 상세내용 조회 후에 해당 글 작성된 댓글 조회
        // 댓글 조회
        if (result > 0) {
            JDBCTemplate.commit(conn);
            Qna q = dao.selectOneQna(conn, infoNo); // 내가볼때는 조회수0 -> 이후 1
            // 일반댓글
            ArrayList<QnaComment> commentList = dao.selectQnaCommentList(conn, infoNo); // 댓글등록 후 댓글
                                                                                        // 조회
            QnaViewData qvd = new QnaViewData(q, commentList);

            JDBCTemplate.close(conn);
            return qvd;

        } else {// 업데이트 실패했을때
            JDBCTemplate.rollback(conn);
            JDBCTemplate.close(conn);
            return null;
        }
    }

    // content 내용보기
    public Qna getQna(int infoNo) {
        Connection conn = JDBCTemplate.getConnection();
        Qna q = dao.selectOneQna(conn, infoNo);
        JDBCTemplate.close(conn);
        return q;
    }

    // Qna게시판 글쓰기
    public int insertQna(Qna q) {
        Connection conn = JDBCTemplate.getConnection();
        int result = dao.insertQna(conn, q);
        if (result > 0) {
            JDBCTemplate.commit(conn);
        } else {
            JDBCTemplate.rollback(conn);
        }
        JDBCTemplate.close(conn);
        return result;
    }

    // 게시글 수정
    public int updateQna(Qna q) {
        Connection conn = JDBCTemplate.getConnection();
        int result = dao.updateQna(conn, q);
        if (result > 0) {
            JDBCTemplate.commit(conn);
        } else {
            JDBCTemplate.rollback(conn);
        }
        JDBCTemplate.close(conn);
        return result;
    }

    // 게시글 삭제
    public Qna deleteQna(int infoNo) {
        Connection conn = JDBCTemplate.getConnection();
        Qna q = dao.selectOneQna(conn, infoNo);// 조회 한 다음 삭제
        int result = dao.deleteQna(conn, infoNo);
        if (result > 0) {
            JDBCTemplate.commit(conn);
        } else { // 삭제가 실패하면 null을 리턴
            JDBCTemplate.rollback(conn);
            q = null;
        }
        JDBCTemplate.close(conn);
        return q; // 삭제가 성공이면 q을 리턴

    }

    // 댓글 작성
    public int insertQnaComment(QnaComment qc) {
        // TODO Auto-generated method stub
        Connection conn = JDBCTemplate.getConnection();
        int result = dao.insertQnaComment(conn, qc);
        if (result > 0) {
            JDBCTemplate.commit(conn);
        } else {
            JDBCTemplate.rollback(conn);
        }
        return result;
    }

    // 댓글 삭제
    public int deleteQnaComment(int commentNo) {
        Connection conn = JDBCTemplate.getConnection();
        int result = dao.deleteQnaComment(conn, commentNo);
        if (result > 0) {
            JDBCTemplate.commit(conn);
        } else {
            JDBCTemplate.rollback(conn);
        }
        JDBCTemplate.close(conn);
        return result;
    }

    // 댓글 업데이트
    public int updateQnaComment(QnaComment qc) {
        Connection conn = JDBCTemplate.getConnection();
        int result = dao.updateQnaComment(conn, qc);
        if (result > 0) {
            JDBCTemplate.commit(conn);
        } else {
            JDBCTemplate.rollback(conn);
        }
        JDBCTemplate.close(conn);
        return result;
    }

}


