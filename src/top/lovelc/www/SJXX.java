package top.lovelc.www;

public class SJXX {

    private String dno;//工号
    private String dname;//姓名
    private String dsex;//性别
    private String dtel;//联系电话
    private String didno;//身份证号
    private String dln;//驾驶证等级
    private String dlg;//驾驶证号
    private String vno;//车牌号
    private String id;//id

    public SJXX(String dno, String dname, String dsex, String dtel, String didno, String dln, String dlg, String vno, String id) {
        this.dno = dno;
        this.dname = dname;
        this.dsex = dsex;
        this.dtel = dtel;
        this.didno = didno;
        this.dln = dln;
        this.dlg = dlg;
        this.vno = vno;
        this.id = id;
    }

    public String getDno() {
        return dno;
    }

    public void setDno(String dno) {
        this.dno = dno;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getDsex() {
        return dsex;
    }

    public void setDsex(String dsex) {
        this.dsex = dsex;
    }

    public String getDtel() {
        return dtel;
    }

    public void setDtel(String dtel) {
        this.dtel = dtel;
    }

    public String getDidno() {
        return didno;
    }

    public void setDidno(String didno) {
        this.didno = didno;
    }

    public String getDln() {
        return dln;
    }

    public void setDln(String dln) {
        this.dln = dln;
    }

    public String getDlg() {
        return dlg;
    }

    public void setDlg(String dlg) {
        this.dlg = dlg;
    }

    public String getVno() {
        return vno;
    }

    public void setVno(String vno) {
        this.vno = vno;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "SJXX{" +
                "dno='" + dno + '\'' +
                ", dname='" + dname + '\'' +
                ", dsex='" + dsex + '\'' +
                ", dtel='" + dtel + '\'' +
                ", didno='" + didno + '\'' +
                ", dln='" + dln + '\'' +
                ", dlg='" + dlg + '\'' +
                ", vno='" + vno + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
