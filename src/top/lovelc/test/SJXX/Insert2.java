package top.lovelc.test.SJXX;

import top.lovelc.util.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Insert2 {

    private String dno;//工号
    private String dname;//姓名
    private String dsex;//性别
    private String dtel;//联系电话
    private String didno;//身份证号
    private String dln;//驾驶证等级
    private String dlg;//驾驶证号
    private String vno;//车牌号
    private String id;//id

    public Insert2(String dno, String dname, String dsex, String dtel, String didno, String dln, String dlg, String vno, String id) {
        this.dno = dno;
        this.dname = dname;
        this.dsex = dsex;
        this.dtel = dtel;
        this.didno = didno;
        this.dlg = dlg;
        this.vno = vno;
        this.id = id;
        if ("C1".equals(dln)){
            this.dln = "1";
        }else if ("B2".equals(dln)){
            this.dln = "2";
        }else if ("B1".equals(dln)){
            this.dln = "3";
        }else if ("A3".equals(dln)){
            this.dln = "4";
        }else if ("A2".equals(dln)){
            this.dln = "5";
        }else if ("A1".equals(dln)){
            this.dln = "6";
        }
    }

    public int inserts(){

        Connection conn = null;
        PreparedStatement patmt = null;
        int count = 0;
        try {
            conn = JDBCUtils.getConnection();
            String sql = "insert into driver values(?,?,?,?,?,?,?,?,?)";
            patmt = conn.prepareStatement(sql);
            patmt.setString(1, this.dno);
            patmt.setString(2, this.dname);
            patmt.setString(3, this.dsex);
            patmt.setString(4, this.dtel);
            patmt.setString(5, this.didno);
            patmt.setString(6, this.dln);
            patmt.setString(7, this.dlg);
            patmt.setString(8, this.vno);
            patmt.setString(9, this.id);
            System.out.println(sql);
            count = patmt.executeUpdate();
            System.out.println("insert2中成功");
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
            String sql = "update driver set dname = ?, dsex = ?, dtel = ?, didno = ?, dln = ?, dlg = ?, vno = ? where dno = ?";
            patmt = conn.prepareStatement(sql);
            patmt.setString(1, this.dname);
            patmt.setString(2, this.dsex);
            patmt.setString(3, this.dtel);
            patmt.setString(4, this.didno);
            patmt.setString(5, this.dln);
            patmt.setString(6, this.dlg);
            patmt.setString(7, this.vno);
            patmt.setString(8, this.dno);
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
