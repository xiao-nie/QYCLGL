package top.lovelc.servlet;

import top.lovelc.util.JDBCUtils;
import top.lovelc.www.Register;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;

public class Tongguo {

    private String id;

    public Tongguo(String id) {
        this.id = id;
    }

    public int jia(){
        ArrayList<Register> r = tog();
        Connection conn = null;
        PreparedStatement patmt = null;
        int count = 0;
        try {
            conn = JDBCUtils.getConnection();
            String sql = "insert into usr values (?,?,?,?)";
            patmt = conn.prepareStatement(sql);
            patmt.setString(1, r.get(0).getId());
            patmt.setString(2, r.get(0).getName());
            patmt.setString(3, r.get(0).getType());
            patmt.setString(4, r.get(0).getPassword());
            count = patmt.executeUpdate();
            System.out.println("注册表信息插入管理员表成功");
            int t = delete();
        } catch (SQLException throwables) {
            System.out.println("注册表信息插入管理员表异常了");
            throwables.printStackTrace();
        } finally {
            JDBCUtils.close(patmt, conn);
            return count;
        }
    }

    public ArrayList<Register> tog(){
        Connection conn = null;
        PreparedStatement patmt = null;
        ResultSet rs = null;
        ArrayList<Register> r = new ArrayList<>();
        try {
            conn = JDBCUtils.getConnection();
            String sql = "select * from register where id = ?";
            patmt = conn.prepareStatement(sql);
            patmt.setString(1, this.id);
            rs = patmt.executeQuery();
            rs.next();
            r.add(new Register(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4)));

        } catch (SQLException throwables) {
            System.out.println("注册表查询异常了");
            throwables.printStackTrace();
        } finally {
            JDBCUtils.close(patmt, conn);
            return r;
        }
    }
    public int delete(){
        Connection conn = null;
        PreparedStatement patmt = null;
        int count = 0;
        try {
            conn = JDBCUtils.getConnection();
            String sql = "delete from register where id = ?";
            patmt = conn.prepareStatement(sql);
            patmt.setString(1, this.id);
            count = patmt.executeUpdate();
            System.out.println("删除注册表信息成功");
        } catch (SQLException throwables) {
            System.out.println("删除注册表信息异常了");
            throwables.printStackTrace();
        } finally {
            JDBCUtils.close(patmt, conn);
            return count;
        }
    }

}
