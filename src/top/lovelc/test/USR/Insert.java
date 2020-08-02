package top.lovelc.test.USR;

import top.lovelc.util.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Insert {

    private String id;//工号
    private String sname;//姓名
    private String spassword;//密码
    private String stype;//类型

    public Insert(String id, String sname, String spassword, String stype) {
        this.id = id;
        this.sname = sname;
        this.spassword = spassword;
        this.stype = stype;
    }

    public int inserts(){

        Connection conn = null;
        PreparedStatement patmt = null;
        int count = 0;
        try {
            conn = JDBCUtils.getConnection();
            String sql = "insert into register values(?,?,?,?)";
            patmt = conn.prepareStatement(sql);
            patmt.setString(1, this.id);
            patmt.setString(2, this.sname);
            patmt.setString(3, this.spassword);
            patmt.setString(4, this.stype);
            count = patmt.executeUpdate();
            System.out.println("注册insert中成功");
        } catch (SQLException throwables) {
            System.out.println("异常了");
            count = 100;
            throwables.printStackTrace();
        } finally {
            JDBCUtils.close(patmt, conn);
            return count;
        }
    }
}
