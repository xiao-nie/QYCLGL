package top.lovelc.test.CLXX;

import com.sun.org.apache.bcel.internal.generic.NEW;
import top.lovelc.util.JDBCUtils;
import top.lovelc.www.CLXX;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Select1 {

    private String type;
    private String select;
    private String sql;

    public Select1(String type, String select) {
        this.select = select;
        if ("车牌号".equals(type)){
            this.sql = "select * from vehicle where vno like ?";
        }else if ("颜色".equals(type)){
            this.sql = "select * from vehicle where vcolour like ?";
        }else if ("车型号".equals(type)){
            this.sql = "select * from vehicle where vmodel like ?";
        }else if ("车类型".equals(type)){
            this.sql = "select * from vehicle where vtype like ?";
        }else if ("载重".equals(type)){
            this.sql = "select * from vehicle where vquality like ?";
        }else {
            System.out.println("找不到要查询的类型");
        }
    }

    public ArrayList<CLXX> query(){

        Connection conn = null;
        PreparedStatement patmt = null;
        ResultSet rs = null;
        ArrayList<CLXX> se = new ArrayList<CLXX>();
        try {
            conn = JDBCUtils.getConnection();
            patmt = conn.prepareStatement(sql);
            patmt.setString(1, "%"+this.select+"%");
            rs = patmt.executeQuery();
            while (rs.next()){
                se.add(new CLXX(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6)));
            }
        } catch (SQLException throwables) {
            System.out.println("异常了");
            throwables.printStackTrace();
        } finally {
            JDBCUtils.close(rs, patmt, conn);
            return se;
        }
    }
}
