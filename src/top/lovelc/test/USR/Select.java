package top.lovelc.test.USR;

import top.lovelc.util.JDBCUtils;
import top.lovelc.www.WXXX;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Select {

    private String no;

    public Select(String no) {
        this.no = no;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public boolean selects(){
        boolean a = false;
        Connection conn = null;
        PreparedStatement patmt = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtils.getConnection();
            patmt = conn.prepareStatement("select * from usr where id = ?");
            patmt.setString(1, this.no);
            rs = patmt.executeQuery();
            a = rs.next();
        } catch (SQLException throwables) {
            System.out.println("异常了");
            throwables.printStackTrace();
        } finally {
            JDBCUtils.close(rs, patmt, conn);
        }


        return a;
    }
}
