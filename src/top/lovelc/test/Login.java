package top.lovelc.test;

import top.lovelc.util.JDBCUtils;

import java.sql.*;
import java.util.ArrayList;

public class Login {

    public ArrayList<String> userlogin(String username, String password){
        Connection conn = null;
        PreparedStatement patmt = null;
        ResultSet rs = null;
        ArrayList<String> l = new ArrayList<>();
        try {
            conn = JDBCUtils.getConnection();
            String sql = "select id, sname , stype from usr where (id = ? and spassword = ?)";
            patmt = conn.prepareStatement(sql);
            patmt.setString(1,username);
            patmt.setString(2,password);
            rs = patmt.executeQuery();
            if (rs.next()){
                System.out.println("查询到数据！账号密码正确，可以登录！");
                l.add(rs.getString(1));
                l.add(rs.getString(2));
                l.add(rs.getString(3));
            }else {
                System.out.println("查不到数据！账号或密码错误！");
                return l;
            }

        } catch (SQLException throwables) {
            System.out.println("账号登陆的时候异常了！！！");
            throwables.printStackTrace();
        } finally {
            JDBCUtils.close(rs, patmt, conn);
            return l;
        }
    }

    public ArrayList<String> userloginid(String id){
        Connection conn = null;
        PreparedStatement patmt = null;
        ResultSet rs = null;
        ArrayList<String> l = new ArrayList<>();
        try {
            conn = JDBCUtils.getConnection();
            String sql = "select id, sname , stype from usr where id = ?";
            patmt = conn.prepareStatement(sql);
            patmt.setString(1,id);
            rs = patmt.executeQuery();
            if (rs.next()){
                System.out.println("后期验证，可以授权操作！");
                l.add(rs.getString(1));
                l.add(rs.getString(2));
                l.add(rs.getString(3));
            }else {
                System.out.println("验证失败！没有账号！！！");
                return l;
            }

        } catch (SQLException throwables) {
            System.out.println("二次验证异常了");
            throwables.printStackTrace();
        } finally {
            JDBCUtils.close(rs, patmt, conn);
            return l;
        }
    }

}
