package top.lovelc.test.CLXX;

import top.lovelc.util.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Insert1 {

    private String vno;
    private String vcolour;
    private String vmodel;
    private String vtype;
    private String vquality;
    private String id;

    public Insert1(String vno, String vcolour, String vmodel, String vtype, String vquality, String id) {
        this.vno = vno;
        this.vcolour = vcolour;
        this.vmodel = vmodel;
        this.vtype = vtype;
        this.vquality = vquality;
        this.id = id;
    }

    public int inserts(){

        Connection conn = null;
        PreparedStatement patmt = null;
        int count = 0;
        try {
            conn = JDBCUtils.getConnection();
            String sql = "insert into vehicle values(?,?,?,?,?,?)";
            patmt = conn.prepareStatement(sql);
            patmt.setString(1, this.vno);
            patmt.setString(2, this.vcolour);
            patmt.setString(3, this.vmodel);
            patmt.setString(4, this.vtype);
            patmt.setString(5, this.vquality);
            patmt.setString(6, this.id);
            count = patmt.executeUpdate();
            System.out.println("insert中成功");
        } catch (SQLException throwables) {
            System.out.println("异常了");
            throwables.printStackTrace();
        } finally {
            JDBCUtils.close(patmt, conn);
            return count;
        }
    }
    public int inserts_up(){

        Connection conn = null;
        PreparedStatement patmt = null;
        int count = 0;
        try {
            conn = JDBCUtils.getConnection();
            String sql = "update vehicle set vcolour = ?,vmodel = ?,vtype = ?,vquality = ? where vno = ?";
            patmt = conn.prepareStatement(sql);
            patmt.setString(1, this.vcolour);
            patmt.setString(2, this.vmodel);
            patmt.setString(3, this.vtype);
            patmt.setString(4, this.vquality);
            patmt.setString(5, this.vno);
            count = patmt.executeUpdate();
            System.out.println("修改成功");
        } catch (SQLException throwables) {
            System.out.println("修改异常了");
            throwables.printStackTrace();
        } finally {
            JDBCUtils.close(patmt, conn);
            return count;
        }
    }
}
