package nbd.search.model.service;

import java.sql.Connection;
import java.util.ArrayList;
import common.JDBCTemplate;
import nbd.search.model.dao.SearchDao;
import nbd.search.model.vo.Search;

public class SearchService {
    private SearchDao dao;

    public SearchService() {
        super();
        dao = new SearchDao();
    }

    public ArrayList<Search> searchRoad(String searchRoad) {
        Connection conn = JDBCTemplate.getConnection();
        ArrayList<Search> list = dao.searchRoad(conn, searchRoad);
        JDBCTemplate.close(conn);
        return list;
    }

}
