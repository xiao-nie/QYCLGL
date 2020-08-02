package top.lovelc.test.SJXX;

import top.lovelc.util.JDBCUtils;
import top.lovelc.www.SJXX;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Select2 {

    private String type;
    private String select;
    private String sql;

    public Select2(String type, String select) {
        this.select = select;
        if ("工号".equals(type)){
            this.sql = "select * from driver where dno like ?";
        }else if ("姓名".equals(type)){
            this.sql = "select * from driver where dname like ?";
        }else if ("性别".equals(type)){
            this.sql = "select * from driver where dsex like ?";
        }else if ("联系电话".equals(type)){
            this.sql = "select * from driver where dtel like ?";
        }else if ("身份证号".equals(type)){
            this.sql = "select * from driver where didno like ?";
        }else if ("驾驶证等级".equals(type)){
            this.sql = "select * from driver where dln like ?";
            switch (select){
                case "C1": this.select = "1";break;
                case "B2": this.select = "2";break;
                case "B1": this.select = "3";break;
                case "A3": this.select = "4";break;
                case "A2": this.select = "5";break;
                case "A1": this.select = "6";break;
                default:
                    this.select=null;
            }
        }else if ("驾驶证号".equals(type)){
            this.sql = "select * from driver where dlg like ?";
        }else if ("车牌号".equals(type)){
            this.sql = "select * from driver where vno like ?";
        }else {
            System.out.println("找不到要查询的类型");
        }
    }

    public ArrayList<SJXX> query(){

        Connection conn = null;
        PreparedStatement patmt = null;
        ResultSet rs = null;
        ArrayList<SJXX> se = new ArrayList<SJXX>();
        try {
            conn = JDBCUtils.getConnection();
            patmt = conn.prepareStatement(sql);
            patmt.setString(1, "%"+this.select+"%");
            rs = patmt.executeQuery();
            while (rs.next()){
                String s;
                switch (rs.getString(6)){
                    case "1": s = "C1";break;
                    case "2": s = "B2";break;
                    case "3": s = "B1";break;
                    case "4": s = "A3";break;
                    case "5": s = "A2";break;
                    case "6": s = "A1";break;
                    default:
                        s=null;
                }
                se.add(new SJXX(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),s,rs.getString(7),rs.getString(8),rs.getString(9)));
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
