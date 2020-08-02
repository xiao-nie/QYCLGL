package top.lovelc.test.WXXX;

import top.lovelc.util.JDBCUtils;
import top.lovelc.www.WXXX;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Select3 {

    private String type;
    private String select;
    private String sql;

    public Select3(String type, String select) {
        this.select = select;
        if ("维修编号".equals(type)){
            this.sql = "select * from maintain where mno like ?";
        }else if ("维修店铺".equals(type)){
            this.sql = "select * from maintain where mstore like ?";
        }else if ("车牌号".equals(type)){
            this.sql = "select * from maintain where vno like ?";
        }else if ("维修原因".equals(type)){
            this.sql = "select * from maintain where mcontent like ?";
        }else {
            System.out.println("找不到要查询的类型");
        }
    }

    public ArrayList<WXXX> query(){

        Connection conn = null;
        PreparedStatement patmt = null;
        ResultSet rs = null;
        ArrayList<WXXX> se = new ArrayList<WXXX>();
        try {
            conn = JDBCUtils.getConnection();
            patmt = conn.prepareStatement(sql);
            patmt.setString(1, "%"+this.select+"%");
            rs = patmt.executeQuery();
            while (rs.next()){
                se.add(new WXXX(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)));
            }
            System.out.println(se);

        } catch (SQLException throwables) {
            System.out.println("异常了");
            throwables.printStackTrace();
        } finally {
            JDBCUtils.close(rs, patmt, conn);
            return se;
        }
    }
    public ArrayList<WXXX> querys(){

        Connection conn = null;
        PreparedStatement patmt = null;
        ResultSet rs = null;
        ArrayList<WXXX> se = new ArrayList<WXXX>();
        try {
            conn = JDBCUtils.getConnection();
            patmt = conn.prepareStatement(sql);
            patmt.setString(1, this.select);
            rs = patmt.executeQuery();
            while (rs.next()){
                se.add(new WXXX(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)));
            }
            System.out.println(se);

        } catch (SQLException throwables) {
            System.out.println("异常了");
            throwables.printStackTrace();
        } finally {
            JDBCUtils.close(rs, patmt, conn);
            return se;
        }
    }

}
