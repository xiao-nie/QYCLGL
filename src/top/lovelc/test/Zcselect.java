package top.lovelc.test;

import top.lovelc.util.JDBCUtils;
import top.lovelc.www.Register;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Zcselect {

    public static ArrayList<Register> selects(){
        boolean a = false;
        Connection conn = null;
        PreparedStatement patmt = null;
        ResultSet rs = null;
        ArrayList<Register> ru = new ArrayList<>();
        try {
            conn = JDBCUtils.getConnection();
            patmt = conn.prepareStatement("select * from register");
            rs = patmt.executeQuery();
            while (rs.next()){
                ru.add(new Register(rs.getString(1),rs.getString(2),rs.getString(4),rs.getString(3)));
            }
        } catch (SQLException throwables) {
            System.out.println("异常了");
            throwables.printStackTrace();
        } finally {
            JDBCUtils.close(rs, patmt, conn);
        }
        return ru;
    }

}
