package top.lovelc.test.CLXX;

import top.lovelc.util.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Delete1 {

    private String vno;

    public Delete1(String vno) {
        this.vno = vno;
    }

    public int delete1(){

        Connection conn = null;
        PreparedStatement patmt = null;
        int count = 0;
        try {
            conn = JDBCUtils.getConnection();
            String sql = "delete from vehicle where vno = ?";
            patmt = conn.prepareStatement(sql);
            patmt.setString(1, this.vno);
            count = patmt.executeUpdate();
            System.out.println("成功");
        } catch (SQLException throwables) {
            System.out.println("异常了");
            throwables.printStackTrace();
        } finally {
            JDBCUtils.close(patmt, conn);
            return count;
        }
    }
}
