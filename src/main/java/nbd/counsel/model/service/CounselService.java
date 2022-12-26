package nbd.counsel.model.service;

import java.sql.Connection;
import java.util.ArrayList;
import common.JDBCTemplate;
import nbd.counsel.model.dao.CounselDao;
import nbd.counsel.model.vo.Counsel;
import nbd.counsel.model.vo.CounselComment;
import nbd.counsel.model.vo.CounselPageData;
import nbd.counsel.model.vo.CounselViewData;

public class CounselService {
    private CounselDao dao;

    public CounselService() {
        super();
        dao = new CounselDao();
    }

    public CounselPageData selectSubjectList(String counselSubject, int reqPage,
            int categoryIndex) {
        Connection conn = JDBCTemplate.getConnection();

        int numPerPage = 20;
        int end = numPerPage * reqPage;
        int start = end - numPerPage + 1;
        ArrayList<Counsel> list = dao.selectSubjectList(conn, counselSubject, start, end);

        int totalCount = dao.selectSubjectListCount(conn, counselSubject);
        int totalPage = 0;
        if (totalCount % numPerPage == 0) {
            totalPage = totalCount / numPerPage;
        } else {
            totalPage = totalCount / numPerPage + 1;
        }

        int pageNaviSize = 5;
        int pageNo = ((reqPage - 1) / pageNaviSize) * pageNaviSize + 1;

        String pageNavi = "<ul class='pagination'>";

        // 이전버튼
        if (pageNo != 1) {
            pageNavi += "<li>";
            pageNavi += "<a class='page-item' href='/counselSubjectList.do?clickIndex=1"
                    + "&categoryIndex=" + categoryIndex + "&counselSubject=" + counselSubject
                    + "&reqPage=" + (pageNo - 1) + "'>";
            pageNavi += "<span>&lt;</span>";
            pageNavi += "</a></li>";
        }
        // 페이지숫자
        // 반복문 5개씩 만들기 위해서
        for (int i = 0; i < pageNaviSize; i++) {
            if (pageNo == reqPage) {
                pageNavi += "<li>";
                pageNavi +=
                        "<a class='page-item active-page' href='/counselSubjectList.do?clickIndex=1"
                                + "&categoryIndex=" + categoryIndex + "&counselSubject="
                                + counselSubject + "&reqPage=" + pageNo + "'>";
                pageNavi += pageNo;
                pageNavi += "</a></li>";
            } else {
                pageNavi += "<li>";
                pageNavi += "<a class='page-item' href='/counselSubjectList.do?clickIndex=1"
                        + "&categoryIndex=" + categoryIndex + "&counselSubject=" + counselSubject
                        + "&reqPage=" + pageNo + "'>";
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
            pageNavi += "<a class='page-item' href='/counselSubjectList.do?clickIndex=1"
                    + "&categoryIndex=" + categoryIndex + "&counselSubject=" + counselSubject
                    + "&reqPage=" + pageNo + "'>";
            pageNavi += "<span>&gt;</span>";
            pageNavi += "</a></li>";
        }
        pageNavi += "</ul>";

        CounselPageData cpd = new CounselPageData(list, pageNavi);
        JDBCTemplate.close(conn);

        return cpd;
    }

    public CounselPageData titleSearch(String searchWord, int reqPage) {
        Connection conn = JDBCTemplate.getConnection();

        int numPerPage = 20;
        int end = numPerPage * reqPage;
        int start = end - numPerPage + 1;
        ArrayList<Counsel> list = dao.titleSearch(conn, searchWord, start, end);

        int totalCount = dao.titleSearchCount(conn, searchWord);
        int totalPage = 0;
        if (totalCount % numPerPage == 0) {
            totalPage = totalCount / numPerPage;
        } else {
            totalPage = totalCount / numPerPage + 1;
        }

        int pageNaviSize = 5;
        int pageNo = ((reqPage - 1) / pageNaviSize) * pageNaviSize + 1;

        String pageNavi = "<ul class='pagination'>";

        // 이전버튼
        if (pageNo != 1) {
            pageNavi += "<li>";
            pageNavi += "<a class='page-item' href='/titleSearch.do?clickIndex=1" + "&searchInput="
                    + searchWord + "&reqPage=" + (pageNo - 1) + "'>";
            pageNavi += "<span>&lt;</span>";
            pageNavi += "</a></li>";
        }
        // 페이지숫자
        // 반복문 5개씩 만들기 위해서
        for (int i = 0; i < pageNaviSize; i++) {
            if (pageNo == reqPage) {
                pageNavi += "<li>";
                pageNavi += "<a class='page-item active-page' href='/titleSearch.do?clickIndex=1"
                        + "&searchInput=" + searchWord + "&reqPage=" + pageNo + "'>";
                pageNavi += pageNo;
                pageNavi += "</a></li>";
            } else {
                pageNavi += "<li>";
                pageNavi += "<a class='page-item' href='/titleSearch.do?clickIndex=1"
                        + "&searchInput=" + searchWord + "&reqPage=" + pageNo + "'>";
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
            pageNavi += "<a class='page-item' href='/titleSearch.do?clickIndex=1" + "&searchInput="
                    + searchWord + "&reqPage=" + pageNo + "'>";
            pageNavi += "<span>&gt;</span>";
            pageNavi += "</a></li>";
        }
        pageNavi += "</ul>";

        CounselPageData cpd = new CounselPageData(list, pageNavi);
        JDBCTemplate.close(conn);

        return cpd;
    }

    public int insertCounsel(Counsel c) {
        Connection conn = JDBCTemplate.getConnection();
        int result = dao.insertCounsel(conn, c);

        if (result > 0) {
            JDBCTemplate.commit(conn);
        } else {
            JDBCTemplate.rollback(conn);
        }

        JDBCTemplate.close(conn);
        return result;
    }

    public CounselViewData selectOneCounsel(int counselNo) {
        Connection conn = JDBCTemplate.getConnection();
        int result = dao.updateCounselCount(conn, counselNo);

        if (result > 0) {
            JDBCTemplate.commit(conn);
            Counsel c = dao.selectOneCounsel(conn, counselNo);

            CounselComment comment = dao.selectCounselComment(conn, counselNo);

            CounselViewData cvd = new CounselViewData(c, comment);

            JDBCTemplate.close(conn);
            return cvd;
        } else {
            JDBCTemplate.rollback(conn);
            JDBCTemplate.close(conn);
            return null;
        }
    }

    public int insertComment(CounselComment cc) {
        Connection conn = JDBCTemplate.getConnection();
        int result = dao.insertComment(conn, cc);

        if (result > 0) {
            result = dao.updateCounselAnswer(conn, cc.getCounselNo());

            if (result > 0) {
                JDBCTemplate.commit(conn);
            } else {
                JDBCTemplate.rollback(conn);
            }
        } else {
            JDBCTemplate.rollback(conn);
        }

        JDBCTemplate.close(conn);
        return result;
    }

    public Counsel getCounsel(int counselNo) {
        Connection conn = JDBCTemplate.getConnection();
        Counsel n = dao.selectOneCounsel(conn, counselNo);
        JDBCTemplate.close(conn);
        return n;
    }

    public int modifyCounsel(Counsel c) {
        Connection conn = JDBCTemplate.getConnection();
        int result = dao.modifyCounsel(conn, c);

        if (result > 0) {
            JDBCTemplate.commit(conn);
        } else {
            JDBCTemplate.rollback(conn);
        }

        JDBCTemplate.close(conn);
        return result;
    }

    public Counsel deleteNotice(int counselNo) {
        Connection conn = JDBCTemplate.getConnection();
        Counsel c = dao.selectOneCounsel(conn, counselNo);
        int result = dao.deleteCounsel(conn, counselNo);

        if (result > 0) {
            JDBCTemplate.commit(conn);
        } else {
            JDBCTemplate.rollback(conn);
            c = null;
        }

        JDBCTemplate.close(conn);
        return c;
    }

    public int deleteComment(int commentNo) {
        Connection conn = JDBCTemplate.getConnection();
        int result = dao.deleteComment(conn, commentNo);

        if (result > 0) {
            JDBCTemplate.commit(conn);
        } else {
            JDBCTemplate.rollback(conn);
        }

        JDBCTemplate.close(conn);
        return result;
    }

    public int updateComment(CounselComment cc) {
        Connection conn = JDBCTemplate.getConnection();
        int result = dao.updateComment(conn, cc);

        if (result > 0) {
            JDBCTemplate.commit(conn);
        } else {
            JDBCTemplate.rollback(conn);
        }

        JDBCTemplate.close(conn);
        return result;
    }


    public ArrayList<Counsel> getMyQuestion(String memberId, int startNum, int endNum) {
        // SELECT ROWNUM, MEMBER_ID, COUNSEL_TITLE, COUNSEL_CONTENT, COUNSEL_ANSWER FROM (SELECT *
        // FROM HEALTH_COUNSEL_TBL WHERE MEMBER_ID='USER117' ORDER BY COUNSEL_NO DESC);
        Connection conn = JDBCTemplate.getConnection();
        ArrayList<Counsel> clist = dao.getMyQuestion(conn, memberId, startNum, endNum);
        JDBCTemplate.close(conn);
        return clist;
    }


    public ArrayList<Counsel> getMyAnswer(int memberNo, int startNum, int endNum) {
        // SELECT ROWNUM, R.* FROM (SELECT * FROM HEALTH_COUNSEL_TBL WHERE COUNSEL_NO IN (SELECT
        // COUNSEL_NO FROM HEALTH_COUNSEL_COM_TBL WHERE MEMBER_ID='DOC1') ORDER BY COUNSEL_NO DESC)R
        // WHERE ROWNUM BETWEEN 1 AND 3;
        Connection conn = JDBCTemplate.getConnection();
        ArrayList<Counsel> clist = dao.getMyAnswer(conn, memberNo, startNum, endNum);
        JDBCTemplate.close(conn);
        return clist;
    }


}
