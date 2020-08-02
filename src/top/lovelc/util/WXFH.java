package top.lovelc.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class WXFH {
    public static int fh() throws SQLException {
        String sql = "select top 1 mno from maintain  order by mno desc";
        Connection conn = null;
        PreparedStatement patmt = null;
        ResultSet rs = null;
        String a = null;
        int x = 0;
        try {
            conn = JDBCUtils.getConnection();
            patmt = conn.prepareStatement(sql);
            rs = patmt.executeQuery();
            rs.next();
            a = rs.getString(1).substring(2,6);
            System.out.println(a);
            x = Integer.parseInt(a) + 1;
            System.out.println(x);
        } catch (SQLException throwables) {
            System.out.println("异常了");
            throwables.printStackTrace();
        } finally {
            JDBCUtils.close(rs, patmt, conn);
            return x;
        }
    }
}
