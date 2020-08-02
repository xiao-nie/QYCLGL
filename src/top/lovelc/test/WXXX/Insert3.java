package top.lovelc.test.WXXX;

import top.lovelc.util.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Insert3 {

    private String mno;//维修编号
    private String mstore;//维修店铺
    private String mcontent;//维修原因
    private String vno;//车牌号
    private String id;//管理者

    public Insert3(String mstore, String mcontent, String vno, String id) throws SQLException {
        this.mstore = mstore;
        this.mcontent = mcontent;
        this.vno = vno;
        this.id = id;
        int a = top.lovelc.util.WXFH.fh();
        if (a < 10){
            this.mno = "XM000"+String.valueOf(a);
        }else if (a >=10 && a < 100){
            this.mno = "XM00"+String.valueOf(a);
        }
        else if (a >=100 && a < 1000){
            this.mno = "XM0"+String.valueOf(a);
        }
        else if (a >=1000 && a < 10000){
            this.mno = "XM"+String.valueOf(a);
        }




    }

    public String getMno() {
        return mno;
    }

    public Insert3(String mdo, String mstore, String mcontent, String vno, String id) {
        this.mno = mdo;
        this.mstore = mstore;
        this.mcontent = mcontent;
        this.vno = vno;
        this.id = id;
    }

    public int inserts(){

        Connection conn = null;
        PreparedStatement patmt = null;
        int count = 0;
        try {
            conn = JDBCUtils.getConnection();
            String sql = "insert into maintain values(?,?,?,?,?)";
            patmt = conn.prepareStatement(sql);
            patmt.setString(1, this.mno);
            System.out.println(this.mno);
            patmt.setString(2, this.mstore);
            System.out.println(this.mstore);
            patmt.setString(3, this.mcontent);
            System.out.println(this.mcontent);
            patmt.setString(4, this.vno);
            System.out.println(this.vno);
            patmt.setString(5, this.id);
            System.out.println(this.id);
            System.out.println(sql);
            count = patmt.executeUpdate();
            System.out.println("insert3中成功");
        } catch (SQLException throwables) {
            System.out.println("insert3异常了");
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
            String sql = "update maintain set mstore = ?, mcontent = ?, vno = ? where mno = ?";
            patmt = conn.prepareStatement(sql);
            patmt = conn.prepareStatement(sql);
            patmt.setString(1, this.mstore);
            System.out.println(this.mstore);
            patmt.setString(2, this.mcontent);
            System.out.println(this.mcontent);
            patmt.setString(3, this.vno);
            System.out.println(this.vno);
            patmt.setString(4, this.mno);
            System.out.println(this.mno);
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
