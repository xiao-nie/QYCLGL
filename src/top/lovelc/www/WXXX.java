package top.lovelc.www;

public class WXXX {

    private String mno;//维修编号
    private String mstore;//维修店铺
    private String mcontent;//维修原因
    private String vno;//车牌号
    private String id;//信息管理者

    public WXXX(String mno, String mstore, String mcontent, String vno, String id) {
        this.mno = mno;
        this.mstore = mstore;
        this.mcontent = mcontent;
        this.vno = vno;
        this.id = id;
    }

    @Override
    public String toString() {
        return "WXXX{" +
                "mno='" + mno + '\'' +
                ", mstore='" + mstore + '\'' +
                ", mcontent='" + mcontent + '\'' +
                ", vno='" + vno + '\'' +
                ", id='" + id + '\'' +
                '}';
    }

    public String getMno() {
        return mno;
    }

    public void setMno(String mno) {
        this.mno = mno;
    }

    public String getMstore() {
        return mstore;
    }

    public void setMstore(String mstore) {
        this.mstore = mstore;
    }

    public String getMcontent() {
        return mcontent;
    }

    public void setMcontent(String mcontent) {
        this.mcontent = mcontent;
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
}
