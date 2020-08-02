package top.lovelc.test.WXXX;

import top.lovelc.util.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Delete3 {

    private String mno;

    public Delete3(String dno) {
        this.mno = dno;
    }

    public int delete3(){

        Connection conn = null;
        PreparedStatement patmt = null;
        int count = 0;
        try {
            conn = JDBCUtils.getConnection();
            String sql = "delete from maintain where mno = ?";
            patmt = conn.prepareStatement(sql);
            patmt.setString(1, this.mno);
            count = patmt.executeUpdate();
            System.out.println("删除维修信息成功");
        } catch (SQLException throwables) {
            System.out.println("删除维修信息异常了");
            throwables.printStackTrace();
        } finally {
            JDBCUtils.close(patmt, conn);
            return count;
        }
    }
}
