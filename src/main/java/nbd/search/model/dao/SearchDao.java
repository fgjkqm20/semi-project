package nbd.search.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import common.JDBCTemplate;
import nbd.search.model.vo.Search;

public class SearchDao {
    public ArrayList<Search> searchRoad(Connection conn, String searchRoad) {
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        ArrayList<Search> list = new ArrayList<Search>();
        String query = "select * from pharmacist_tbl where pharm_useaddr like ?"; // 도로명의 %로%
        System.out.println(searchRoad);
        try {
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, "%" + searchRoad + "%");
            rset = pstmt.executeQuery();
            while (rset.next()) {
                Search p = new Search();
                p.setPharmNo(rset.getInt("pharm_no"));
                p.setPharmPhone(rset.getString("pharm_phone"));
                p.setPharmTitle(rset.getString("pharm_title"));
                p.setPharmAddr(rset.getString("pharm_useaddr"));
                list.add(p);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            JDBCTemplate.close(pstmt);
            JDBCTemplate.close(rset);
        }
        return list;
    }

}
