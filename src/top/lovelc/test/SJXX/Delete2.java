package top.lovelc.test.SJXX;

import top.lovelc.util.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Delete2 {

    private String dno;

    public Delete2(String dno) {
        this.dno = dno;
    }

    public int delete2(){

        Connection conn = null;
        PreparedStatement patmt = null;
        int count = 0;
        try {
            conn = JDBCUtils.getConnection();
            String sql = "delete from driver where dno = ?";
            patmt = conn.prepareStatement(sql);
            patmt.setString(1, this.dno);
            count = patmt.executeUpdate();
            System.out.println("删除司机成功");
        } catch (SQLException throwables) {
            System.out.println("删除司机异常了");
            throwables.printStackTrace();
        } finally {
            JDBCUtils.close(patmt, conn);
            return count;
        }
    }
}
